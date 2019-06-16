package it.polito.security.esp.metrics;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.orangepalantir.leastsquares.Fitter;
import org.orangepalantir.leastsquares.Function;
import org.orangepalantir.leastsquares.fitters.LinearFitter;
import org.orangepalantir.leastsquares.fitters.MarquardtFitter;
import org.orangepalantir.leastsquares.fitters.NonLinearSolver;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.StaticVariableSet;

import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.KbFactory;
import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.ApplicationPartMetricSet;
import it.polito.security.esp.kb.ApplicationPartType;
import it.polito.security.esp.kb.AppliedProtectionInstantiation;
import it.polito.security.esp.kb.FitterType;
import it.polito.security.esp.kb.Metric;
import it.polito.security.esp.kb.Protection;
import it.polito.security.esp.kb.ProtectionInstantiation;
import it.polito.security.esp.kb.Solution;
import it.polito.security.esp.kb.SolutionSequence;
import it.polito.security.esp.kb.UseType;
import it.polito.security.esp.l1p.IntegerTupleWalker;
import it.polito.security.esp.util.Strings;

/**
 * The amazing metrics framework.
 * @author Daniele Canavese
 **/
public class MetricsFramework
{
	/** The maximum number of ACTC build tries. **/
	private static final int MAX_TRIES = 3;
	/** The list of interesting metrics. **/
	final public static String[] METRICS = new String[] { "nr_ins_static", "nr_indirect_edges_CFIM_static", "nr_edges_static",
			"cyclomatic_complexity_static", "nr_dst_oper_static", "nr_src_oper_static", "halstead_program_size_static",
			"nr_of_mobile_blocks", "nr_of_mobile_bytes", "nr_of_bytes_in_ads", "nr_of_blocks", "nr_of_guarded_bytes" };
	/** The ESP. **/
	private ESP esp;
	/** The gamma map. **/
	private Map<ProtectionInstantiation, Map<String, List<Double>>> gammaMap;
	/** The metrics cache. **/
	private Map<Solution, Map<ApplicationPart, Map<List<AppliedProtectionInstantiation>, Map<String, Double>>>> metricsCache;

	/**
	 * Creates the framework.
	 * @param esp
	 *            The ESP.
	 */
	public MetricsFramework(ESP esp)
	{
		this.esp = esp;
		gammaMap = new HashMap<>();
		metricsCache = new HashMap<>();
	}

	/**
	 * Computes all the metrics and saves them into a file.
	 * @param file
	 *            The file where the metrics will be saved.
	 * @param monitor
	 *            The progress monitor.
	 * @param The
	 *            combination depth.
	 * @throws CoreException
	 *             If the metrics file cannot be created.
	 * @throws IOException
	 *             If an ACTC fails.
	 **/
	public void computeMetrics(IFile file, IProgressMonitor monitor, int depth) throws CoreException, IOException
	{
		long start = System.currentTimeMillis();

		List<Set<ApplicationPart>> assets = getSplitAssets();
		Set<Set<List<AppliedProtectionInstantiation>>> solutions = new HashSet<>();
		
		while (assets.size() > 3)
			assets.remove(2);

		for (Set<ApplicationPart> i : assets)
		{
			// Computes the part-API map.
			Map<ApplicationPart, List<AppliedProtectionInstantiation>> apis = new HashMap<>();
			for (AppliedProtectionInstantiation j : esp.getModel().getAppliedProtectionInstantiations())
				if (i.contains(j.getApplicationPart()))
				{
					List<AppliedProtectionInstantiation> list;
					if (apis.containsKey(j.getApplicationPart()))
						list = apis.get(j.getApplicationPart());
					else
					{
						list = new ArrayList<>();
						apis.put(j.getApplicationPart(), list);
					}
					list.add(j);
				}

			// Computes the partial solutions.
			Map<ApplicationPart, List<List<AppliedProtectionInstantiation>>> partials = new HashMap<>();
			for (int j = 1; j <= depth; ++j)
			{
				for (ApplicationPart k : apis.keySet())
				{
					List<AppliedProtectionInstantiation> p = apis.get(k);
					List<Integer> v = new ArrayList<>();
					for (int l = 1; l <= j; ++l)
						v.add(p.size());
					List<Integer> o = new ArrayList<>();
					IntegerTupleWalker walker = new IntegerTupleWalker(v, o);

					while (walker.computeNext())
					{
						List<AppliedProtectionInstantiation> x = new ArrayList<>();
						boolean good = true;
						int highCount = 0;
						int lowCount = 0;
						for (int l : o)
						{
							AppliedProtectionInstantiation pi = p.get(l - 1);
							x.add(pi);
							if (pi.getProtectionInstantiation().getName().contains("high"))
								++highCount;
							else if (pi.getProtectionInstantiation().getName().contains("low"))
								++lowCount;
//							if (k.getWeight() == 1 && pi.getProtectionInstantiation().getName().contains("high"))
//								good = false;
//							else if (k.getWeight() > 1 && pi.getProtectionInstantiation().getName().contains("low"))
//								good = false;
							
						}
						
						if (!good || (highCount != x.size() && lowCount != x.size()))
							continue;

						List<List<AppliedProtectionInstantiation>> list;
						if (partials.containsKey(k))
							list = partials.get(k);
						else
						{
							list = new ArrayList<>();
							partials.put(k, list);
						}
						list.add(x);
					}
				}
			}

			int longest = 0;
			for (List<List<AppliedProtectionInstantiation>> j : partials.values())
				longest = Math.max(longest, j.size());

			for (int j = 0; j < longest; ++j)
			{
				Set<List<AppliedProtectionInstantiation>> solution = new HashSet<>();
				for (List<List<AppliedProtectionInstantiation>> k : partials.values())
					if (j < k.size())
						solution.add(k.get(j));
				solutions.add(solution);
			}
		}

		monitor.beginTask("Building...", solutions.size());

		StringBuilder sb = new StringBuilder();

		// Computes the metrics on the vanilla application.
		build(esp.getModel().getVanillaSolution(), null);
		sb.append(getMetrics(esp.getModel().getVanillaSolution(), new HashSet<List<AppliedProtectionInstantiation>>()));

		// Computes the metrics on all the other solutions.
		int count = 0;
		for (Set<List<AppliedProtectionInstantiation>> i : solutions)
			try
			{
				Solution s = build(i, ++count, solutions.size());
				sb.append(getMetrics(s, i));
				monitor.worked(1);
			}
			catch (Exception e)
			{
				log.severe("Unable to build the solution");
			}

		// Saves everything to a file.
		if (!file.exists())
			file.create(new ByteArrayInputStream(sb.toString().getBytes()), true, null);
		else
			file.setContents(new ByteArrayInputStream(sb.toString().getBytes()), true, true, null);
		monitor.done();

		long stop = System.currentTimeMillis();
		System.out.println(stop - start);
	}

	/**
	 * Retrieves the assets split in levels.
	 * @return The assets split in levels
	 **/
	public List<Set<ApplicationPart>> getSplitAssets()
	{
		Set<ApplicationPart> assets = new HashSet<>();
		assets.addAll(esp.getModel().getAssets());

		List<Set<ApplicationPart>> levels = new ArrayList<>();

		Set<ApplicationPart> current = new HashSet<>();
		for (ApplicationPart i : assets)
			if (i.getDeclaringCode() != null && i.getDeclaringCode().getType() == ApplicationPartType.FUNCTION)
				current.add(i);

		while (!current.isEmpty())
		{
			levels.add(current);
			Set<ApplicationPart> children = new HashSet<>();
			for (ApplicationPart i : current)
				for (ApplicationPart j : i.getApplicationParts())
					if (j.isAsset())
						children.add(j);
			current = children;
		}

		return levels;
	}

	/**
	 * Retrieves the depth of the deepest nested asset.
	 * @return The maximum depth of the asset tree.
	 **/
	public int getMaxDepth()
	{
		int max = 0;

		for (ApplicationPart i : esp.getModel().getAssets())
			max = Math.max(max, getMaxDepth(i));

		return max;
	}

	/**
	 * Retrieves the depth of the deepest nested asset into another asset.
	 * @param asset
	 *            The asset.
	 * @return The maximum depth of the asset tree.
	 **/
	public int getMaxDepth(ApplicationPart asset)
	{
		int max = 0;

		ApplicationPart parent = asset.getDeclaringCode();

		while (parent != null)
		{
			if (parent.isAsset())
				++max;
			parent = parent.getDeclaringCode();
		}

		return max;
	}

	/**
	 * Creates a text version of a solution metrics.
	 * @param solution
	 *            The solution.
	 * @param The
	 *            list of applied PIs.
	 * @return A text version of the solution metrics.
	 **/
	private String getMetrics(Solution solution, Set<List<AppliedProtectionInstantiation>> pis)
	{
		Set<ApplicationPart> assets = new HashSet<>();
		for (List<AppliedProtectionInstantiation> i : pis)
			for (AppliedProtectionInstantiation j : i)
				assets.add(j.getApplicationPart());

		Map<ApplicationPart, List<AppliedProtectionInstantiation>> map = new HashMap<>();
		for (List<AppliedProtectionInstantiation> i : pis)
			map.put(i.get(0).getApplicationPart(), i);

		StringBuilder sb = new StringBuilder();

		// Creates the table where the columns are:
		// + the PI name or * if there is no PI
		// + the application part name @ source file
		// + the metric id
		// + the metric value
		for (ApplicationPartMetricSet i : solution.getApplicationPartMetricSets())
		{
			ApplicationPart part = i.getApplicationPart();
			if (assets.isEmpty() || assets.contains(i.getApplicationPart()))
				for (String j : METRICS)
				{
					double value = Double.NaN;
					for (Metric k : i.getMetrics())
						if (k.getName().equals(j))
							value = k.getValue();

					if (Double.isNaN(value))
					{
						// log.warning("Metric " + j + " for " + part + " not found.");
						continue;
					}

					String pi = "";

					if (map.containsKey(part))
					{
						List<AppliedProtectionInstantiation> p = map.get(i.getApplicationPart());
						List<String> names = new ArrayList<>();
						for (AppliedProtectionInstantiation k : p)
							names.add(k.getProtectionInstantiation().getName());
						pi = Strings.join(names, "|");
					}
					else
						pi = "*";
					sb.append(pi + ";");

					sb.append(part.getName() + "@" + part.getSourceFilePath() + ";");
					sb.append(j + ";");
					sb.append(value + "\n");
				}
		}

		return sb.toString();
	}

	/**
	 * Computes the metrics estimation coefficients by reading the metrics from a set of files.
	 * @param files
	 *            The metric files.
	 * @param file
	 *            The file where the results are saved.
	 * @param monitor
	 *            The progress monitor.
	 * @throws IOException
	 *             If the file cannot be opened.
	 * @throws CoreException
	 *             If a file cannot be read.
	 **/
	public void computeCoefficients(Collection<IFile> files, IFile file, IProgressMonitor monitor) throws IOException, CoreException
	{
		Map<ProtectionInstantiation, Map<String, Set<Sample>>> map = new HashMap<>();
		for (IFile i : files)
			loadMetrics(i, map);
		int size = map.size() * METRICS.length;

		monitor.beginTask("Building...", size);

		gammaMap.clear();
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (Entry<ProtectionInstantiation, Map<String, Set<Sample>>> i : map.entrySet())
			for (Entry<String, Set<Sample>> j : i.getValue().entrySet())
			{
				List<Double> list = computeGammas(j.getValue());
				sb.append(i.getKey().getName() + ";");
				sb.append(j.getKey() + ";");
				sb.append(Strings.join(list, ",") + "\n");
				Map<String, List<Double>> m;
				if (gammaMap.containsKey(i.getKey()))
					m = gammaMap.get(i.getKey());
				else
				{
					m = new HashMap<>();
					gammaMap.put(i.getKey(), m);
				}
				m.put(j.getKey(), list);
				log.fine("Computed " + ++count + "/" + size + " gammas");
				monitor.worked(1);
			}

		if (!file.exists())
			file.create(new ByteArrayInputStream(sb.toString().getBytes()), true, null);
		else
			file.setContents(new ByteArrayInputStream(sb.toString().getBytes()), true, true, null);

		monitor.done();
	}

	/**
	 * Computes the gamma coefficients from a list of samples.
	 * @param samples
	 *            The samples.
	 * @return The gamma coefficients
	 **/
	private List<Double> computeGammas(final Set<Sample> samples)
	{
		List<Double> list = new ArrayList<>();
		final int n = samples.size();

		if (n > 1)
		{
			final int size = samples.iterator().next().getX().size();
			final int degree = Math.min(n, esp.getModel().getPreferences().getMetricsTransformationDegree() + 1);

			double[][] x = new double[n][];
			double[] y = new double[n];
			double[] g = new double[(degree - 1) * size + 1];
			int count = 0;
			for (Sample i : samples)
			{
				x[count] = new double[size];
				for (int j = 0; j < size; ++j)
					x[count][j] = i.getX().get(j);
				y[count] = i.getY();
				++count;
			}
			for (int i = 0; i < (degree - 1) * size + 1; ++i)
				g[i] = 0.0;

			Function function = new Function()
			{
				@Override
				public double evaluate(double[] values, double[] parameters)
				{
					double r = parameters[0];

					for (int i = 0; i < size; ++i)
						for (int j = 0; j < degree - 1; ++j)
							r += parameters[i * (degree - 1) + j + 1] * Math.pow(values[i], j + 1);

					return r;
				}

				@Override
				public int getNInputs()
				{
					return size;
				}

				@Override
				public int getNParameters()
				{
					return (degree - 1) * size + 1;
				}
			};

			Fitter fitter;
			if (esp.getModel().getPreferences().getMetricsFitter() == FitterType.LINEAR)
				fitter = new LinearFitter(function);
			else if (esp.getModel().getPreferences().getMetricsFitter() == FitterType.NON_LINEAR)
			{
				NonLinearSolver f = new NonLinearSolver(function);
				f.setDelta(esp.getModel().getPreferences().getMetricsDerivativeSensitivity());
				f.setMaxIterations(esp.getModel().getPreferences().getMetricsNonLinearMaximumIterations());
				f.setMinChange(esp.getModel().getPreferences().getMetricsNonLinearMinimumChange());
				f.setMinError(esp.getModel().getPreferences().getMetricsNonLinearMinimumError());
				f.setStepSize(esp.getModel().getPreferences().getMetricsNonLinearStepSize());
				fitter = f;
			}
			else
			{
				MarquardtFitter f = new MarquardtFitter(function);
				f.setDelta(esp.getModel().getPreferences().getMetricsDerivativeSensitivity());
				fitter = f;
			}
			fitter.setData(x, y);
			fitter.setParameters(g);

			fitter.fitData(esp.getModel().getPreferences().getMetricsPseudoInverseSensitivity());
			for (double i : fitter.getParameters())
				list.add(i);
			for (int i = 0; i < esp.getModel().getPreferences().getMetricsTransformationDegree() + 1 - list.size(); ++i)
				list.add(0.0);
		}

		return list;
	}

	/**
	 * Loads the gamma coefficients from a file.
	 * @param file
	 *            The file to load.
	 * @throws IOException
	 *             If the file cannot be opened.
	 * @throws CoreException
	 *             If a file cannot be read.
	 **/
	public void loadCoefficients(IFile file) throws IOException, CoreException
	{
		gammaMap.clear();

		BufferedReader reader = new BufferedReader(new InputStreamReader(file.getContents()));

		String line;
		while ((line = reader.readLine()) != null)
		{
			String[] tokens = line.split(";");

			String piName = tokens[0];
			ProtectionInstantiation pi = null;
			for (Protection i : esp.getModel().getProtections())
				for (ProtectionInstantiation j : i.getInstantiations())
					if (j.getName().equals(piName))
						pi = j;
			String metricName = tokens[1];
			List<Double> values = new ArrayList<>();
			for (String i : tokens[2].split(","))
				values.add(Double.valueOf(i));

			if (pi != null)
			{
				Map<String, List<Double>> map;
				if (gammaMap.containsKey(pi))
					map = gammaMap.get(pi);
				else
				{
					map = new HashMap<>();
					gammaMap.put(pi, map);
				}

				map.put(metricName, values);
			}
		}
	}

	/**
	 * Loads the metrics from a file.
	 * @param file
	 *            The file.
	 * @param map
	 *            The map that will contain the metrics.
	 * @throws IOException
	 *             If the file cannot be opened.
	 * @throws CoreException
	 *             If a file cannot be read.
	 */
	private void loadMetrics(IFile file, Map<ProtectionInstantiation, Map<String, Set<Sample>>> map) throws IOException, CoreException
	{
		Map<Integer, Map<String, Double>> vanillaMap = new HashMap<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(file.getContents()));

		String line;
		while ((line = reader.readLine()) != null)
		{
			String[] tokens = line.split(";");
			if (tokens.length == 4)
				try
				{
					String piName = tokens[0];
					ProtectionInstantiation pi = null;
					for (Protection i : esp.getModel().getProtections())
						for (ProtectionInstantiation j : i.getInstantiations())
							if (j.getName().equals(piName))
								pi = j;
					int partHash = Integer.valueOf(tokens[1]);
					String metricName = tokens[2];
					double metricValue = Double.valueOf(tokens[3]);

					// Skips uninteresting metrics.
					if (!Arrays.asList(METRICS).contains(metricName))
						continue;

					if (pi == null && piName.equals("*"))
					{
						Map<String, Double> partMap;
						if (vanillaMap.containsKey(partHash))
							partMap = vanillaMap.get(partHash);
						else
						{
							partMap = new LinkedHashMap<>();
							vanillaMap.put(partHash, partMap);
						}

						partMap.put(metricName, metricValue);
					}
					else if (pi != null)
					{
						Map<String, Set<Sample>> metricMap;
						if (map.containsKey(pi))
							metricMap = map.get(pi);
						else
						{
							metricMap = new HashMap<>();
							map.put(pi, metricMap);
						}

						Set<Sample> samples;
						if (metricMap.containsKey(metricName))
							samples = metricMap.get(metricName);
						else
						{
							samples = new HashSet<>();
							metricMap.put(metricName, samples);
						}

						samples.add(new Sample(vanillaMap.get(partHash), metricValue));
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
		}
	}

	/**
	 * Deploys a solution with a set of applied PIs, builds the project and extract all of its metrics.
	 * @param pis
	 *            The applied protection instantiation.
	 * @param number
	 *            The solution number.
	 * @param The
	 *            total number of solutions.
	 * @return The solution.
	 * @throws IOException
	 *             If the ACTC command cannot be executed.
	 * @throws CoreException
	 *             If the ACTC log file cannot be created.
	 **/
	private Solution build(Set<List<AppliedProtectionInstantiation>> pis, Integer number, Integer total) throws IOException, CoreException
	{
		Solution solution = KbFactory.eINSTANCE.createSolution();
		for (List<AppliedProtectionInstantiation> i : pis)
		{
			SolutionSequence sequence = KbFactory.eINSTANCE.createSolutionSequence();
			solution.getSolutionSequences().add(sequence);
			sequence.getAppliedProtectionInstantiations().addAll(i);
		}

		log.info("Building solution " + number + "/" + total + " for " + solution);
		build(solution, null);

		return solution;
	}

	/**
	 * Builds a solution.
	 * @param solution
	 *            The solution to build.
	 * @param fileName
	 *            The file name of the ACTC logs or <code>null</code> to disable the logging.
	 * @throws IOException
	 *             If the ACTC command cannot be executed.
	 * @throws CoreException
	 *             If the ACTC log file cannot be created.
	 */
	public void build(Solution solution, String fileName) throws IOException, CoreException
	{
		for (int i = 0; i < MAX_TRIES; ++i)
			try
			{
				esp.updateAssets();
				esp.getACTCConnector().clean();
				esp.getAnnotationRewriter().deployPatch(solution);
				esp.getAnnotationRewriter().deployJSON(null);
				esp.getACTCConnector().build(fileName);
				esp.getACTCConnector().parseMetrics(solution);

				return;
			}
			catch (Exception e)
			{
				e.printStackTrace();
				if (i == MAX_TRIES - 1)
					throw e;
			}
	}

	/**
	 * Retrieves an estimated metric value of an application part.
	 * @param reference
	 *            The reference solution to use.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part.
	 * @param metricName
	 *            The metric name.
	 * @return The metric value.
	 **/
	private double getEstimatedMetric(Solution reference, Collection<List<AppliedProtectionInstantiation>> solution,
			ApplicationPart applicationPart, String metricName)
	{
		// Finds all the applied PIs on the application part.
		List<AppliedProtectionInstantiation> pis = new ArrayList<>();
		for (List<AppliedProtectionInstantiation> i : solution)
			for (AppliedProtectionInstantiation j : i)
				if (j.getApplicationPart() == applicationPart)
					pis.add(j);

		Map<String, Double> map = getEstimatedMetric(reference, pis, applicationPart);
		if (map.containsKey(metricName))
			return map.get(metricName);
		else
			return 0.0;
	}

	/**
	 * Retrieves all the estimated metrics of an application part.
	 * @param reference
	 *            The reference solution to use.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part.
	 * @return The metric values.
	 **/
	private Map<String, Double> getEstimatedMetric(Solution reference, List<AppliedProtectionInstantiation> solution,
			ApplicationPart applicationPart)
	{
		// Searches the metric in the cache.
		Map<String, Double> metrics = search(reference, applicationPart, solution);
		if (metrics != null)
			return metrics;

		metrics = new HashMap<>();

		// Searches in the vanilla set if the solution is void.
		if (solution.isEmpty())
		{
			for (ApplicationPartMetricSet i : reference.getApplicationPartMetricSets())
				if (i.getApplicationPart() == applicationPart)
					for (Metric j : i.getMetrics())
						metrics.put(j.getName(), j.getValue());
		}
		else
		{
			// Removes the last PI from the list and ask the reduced solution metrics.
			List<AppliedProtectionInstantiation> reducedSolution = new ArrayList<>();
			reducedSolution.addAll(solution);
			ProtectionInstantiation pi = solution.get(solution.size() - 1).getProtectionInstantiation();
			reducedSolution.remove(reducedSolution.size() - 1);
			Map<String, Double> oldMetrics = getEstimatedMetric(reference, reducedSolution, applicationPart);

			// If the corresponding gammas does not exists, we do nothing.
			if (!gammaMap.containsKey(pi))
				return oldMetrics;

			// Compute the new metrics.
			Map<String, List<Double>> map = gammaMap.get(pi);
			for (Entry<String, List<Double>> i : map.entrySet())
			{
				double value;
				if (oldMetrics.containsKey(i.getKey()))
					value = oldMetrics.get(i.getKey());
				else
					value = 0.0;
				int degree = (i.getValue().size() - 1) / METRICS.length;

				for (int k = 0; k < i.getValue().size(); ++k)
					if (k == 0)
						value += i.getValue().get(k);
					else
					{
						double v = 0.0;
						if (oldMetrics.containsKey(METRICS[(k - 1) / degree]))
							v = oldMetrics.get(METRICS[(k - 1) / degree]);
//						if(i.getValue().get(k) * Math.pow(v, (k - 1) % degree + 1)>0)
							value += i.getValue().get(k) * Math.pow(v, (k - 1) % degree + 1);
					}
//				if (!Double.isFinite(value) || value < 0.0)
////					value = 0.0;
//					if (oldMetrics.containsKey(i.getKey()))
//						value = oldMetrics.get(i.getKey());
//				{
					Random r = new Random(esp.getModel().getPreferences().getL2pFunctionSplittingSeed());
					if(oldMetrics.get(i.getKey())!=null)
						value =  oldMetrics.get(i.getKey()) + (oldMetrics.get(i.getKey()) * (r.nextDouble() / 100.0));
					else if (!Double.isFinite(value) || value < 0.0)
						value = 0.0;
//				}
				metrics.put(i.getKey(), value);
			}
		}

		add(reference, applicationPart, solution, metrics);
		return metrics;
	}

	/**
	 * Retrieves a metric value of an application part.
	 * @param reference
	 *            The reference solution to use.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part .
	 * @param metricName
	 *            The metric name.
	 * @return The metric value.
	 * @throws IOException
	 *             If the ACTC command cannot be executed.
	 * @throws CoreException
	 *             If the ACTC log file cannot be created.
	 **/
	public double getMetric(Solution reference, Collection<List<AppliedProtectionInstantiation>> solution, ApplicationPart applicationPart,
			String metricName) throws IOException, CoreException
	{
		if (gammaMap.isEmpty())
			return getRealMetric(toSolution(solution), applicationPart, metricName);
		else
			return getEstimatedMetric(reference, solution, applicationPart, metricName);
	}

	/**
	 * Retrieves a metric value of an application part.
	 * @param reference
	 *            The reference solution to use.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part .
	 * @param metricName
	 *            The metric name.
	 * @return The metric value.
	 * @throws IOException
	 *             If the ACTC command cannot be executed.
	 * @throws CoreException
	 *             If the ACTC log file cannot be created.
	 **/
	public double getMetric(Solution reference, Solution solution, ApplicationPart applicationPart, String metricName)
			throws IOException, CoreException
	{
		if (gammaMap.isEmpty())
			return getRealMetric(solution, applicationPart, metricName);
		else
			return getEstimatedMetric(reference, toCollection(solution), applicationPart, metricName);
	}

	/**
	 * Retrieves a real metric value of an application part.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part .
	 * @param metricName
	 *            The metric name.
	 * @return The metric value.
	 * @throws IOException
	 *             If the ACTC command cannot be executed.
	 * @throws CoreException
	 *             If the ACTC log file cannot be created.
	 **/
	private double getRealMetric(Solution solution, ApplicationPart applicationPart, String metricName) throws IOException, CoreException
	{
		build(solution, null);

		for (ApplicationPartMetricSet i : solution.getApplicationPartMetricSets())
			if (i.getApplicationPart() == applicationPart)
				for (Metric j : i.getMetrics())
					if (j.getName().equals(metricName))
						return j.getValue();

		return 0.0;
	}

	/**
	 * Computes a formula result with an application part metrics.
	 * @param reference
	 *            The reference solution to use.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part .
	 * @param formula
	 *            The formula.
	 * @return The formula result.
	 **/
	private double computeFormula(Solution reference, Collection<List<AppliedProtectionInstantiation>> solution,
			ApplicationPart applicationPart, String formula)
	{
		try
		{
			StaticVariableSet<Double> variables = new StaticVariableSet<Double>();
//			if(applicationPart.isCode())
				for (String i : METRICS)
					variables.set(i, getEstimatedMetric(reference, solution, applicationPart, i));

			
			if(formula.contains("sum_total_dimension_strings_lit_in_func")||
					formula.contains("no_strings_lit_in_func")||
					formula.contains("no_int_lit_in_func"))
			{
				ApplicationPart function = applicationPart;
				while(!function.getType().equals(ApplicationPartType.FUNCTION))
					function = function.getDeclaringCode();
				
				int[] literalMetrics = esp.getCDTConnector().findLiteralMetrics(function, null, null);
				variables.set("no_int_lit_in_func", Double.valueOf(literalMetrics[0]));
				variables.set("no_strings_lit_in_func", Double.valueOf(literalMetrics[1]));
				variables.set("sum_total_dimension_strings_lit_in_func", Double.valueOf(literalMetrics[2]));
				
			}
			
			if(formula.contains("var_uses"))
			{
				Integer varUsesCount = applicationPart.getTargetOf().size();
				variables.set("no_int_lit_in_func", Double.valueOf(varUsesCount));
			}
			
			//find metric of the declaring function if the part is a variable
			if(formula.contains("function_nr_ins_static"))
			{
				ApplicationPart function = applicationPart;
				while(!function.getType().equals(ApplicationPartType.FUNCTION))
					function = function.getDeclaringCode();
				
				variables.set("function_nr_ins_static", getEstimatedMetric(reference, solution, function, "nr_ins_static"));
			}
			
			DoubleEvaluator evaluator = new DoubleEvaluator();
			double result = evaluator.evaluate(formula, variables);
			if (!Double.isFinite(result))
				result = 0.0;

			return result;
		}
		catch (Exception e)
		{
			return 0.0;
		}
	}

	/**
	 * Computes the client time overhead of a solution or an application part.
	 * @param reference
	 *            The reference solution to use.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part for computing its overhead or <code>null</code> for computing the solution overhead.
	 * @return The overhead.
	 **/
	public double getClientTimeOverhead(Solution reference, Collection<List<AppliedProtectionInstantiation>> solution,
			ApplicationPart applicationPart)
	{
		double overhead = 0.0;

//		String solutionString="";
//		
//		for (List<AppliedProtectionInstantiation> i : solution)
//			for (AppliedProtectionInstantiation j : i)
//				solutionString+=j;
		
		for (List<AppliedProtectionInstantiation> i : solution)
			for (AppliedProtectionInstantiation j : i)
				if (applicationPart == null || j.getApplicationPart() == applicationPart)
				{
					double o = computeFormula(reference, solution, j.getApplicationPart(),
							j.getProtectionInstantiation().getClientTimeOverhead());

					double total = 1.0;
					for (Metric k : reference.getApplicationMetrics())
						if (k.getName().equals("nr_ins_static"))
						{
							total = k.getValue();
							break;
						}

					for (ApplicationPartMetricSet k : reference.getApplicationPartMetricSets())
						if (k.getApplicationPart() == j.getApplicationPart())
						{
							double local = 1.0;
							for (Metric l : k.getMetrics())
								if (l.getName().equals("nr_ins_static"))
								{
									local = l.getValue();
									break;
								}

							o *= local / total;
						}

//					log.info(j+" in "+solutionString);
//					log.info(o + "+" + overhead);
					overhead += o;
				}

//		log.info(overhead +" final overhead for "+ solutionString);
		return overhead;
	}

	/**
	 * Computes the server time overhead of a solution or an application part.
	 * @param reference
	 *            The reference solution to use.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part for computing its overhead or <code>null</code> for computing the solution overhead.
	 * @return The overhead.
	 **/
	public double getServerTimeOverhead(Solution reference, Collection<List<AppliedProtectionInstantiation>> solution,
			ApplicationPart applicationPart)
	{
		double overhead = 0.0;

		for (List<AppliedProtectionInstantiation> i : solution)
			for (AppliedProtectionInstantiation j : i)
				if (applicationPart == null || j.getApplicationPart() == applicationPart)
					overhead += computeFormula(reference, solution, j.getApplicationPart(),
							j.getProtectionInstantiation().getServerTimeOverhead());

		return overhead;
	}

	/**
	 * Computes the client memory overhead of a solution or an application part.
	 * @param reference
	 *            The reference solution to use.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part for computing its overhead or <code>null</code> for computing the solution overhead.
	 * @return The overhead.
	 **/
	public double getClientMemoryOverhead(Solution reference, Collection<List<AppliedProtectionInstantiation>> solution,
			ApplicationPart applicationPart)
	{
		double overhead = 0.0;

		for (List<AppliedProtectionInstantiation> i : solution)
			for (AppliedProtectionInstantiation j : i)
				if (applicationPart == null || j.getApplicationPart() == applicationPart)
					overhead += computeFormula(reference, solution, j.getApplicationPart(),
							j.getProtectionInstantiation().getClientMemoryOverhead());

		return overhead;
	}

	/**
	 * Computes the server memory overhead of a solution or an application part.
	 * @param reference
	 *            The reference solution to use.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part for computing its overhead or <code>null</code> for computing the solution overhead.
	 * @return The overhead.
	 **/
	public double getServerMemoryOverhead(Solution reference, Collection<List<AppliedProtectionInstantiation>> solution,
			ApplicationPart applicationPart)
	{
		double overhead = 0.0;

		for (List<AppliedProtectionInstantiation> i : solution)
			for (AppliedProtectionInstantiation j : i)
				if (applicationPart == null || j.getApplicationPart() == applicationPart)
					overhead += computeFormula(reference, solution, j.getApplicationPart(),
							j.getProtectionInstantiation().getServerMemoryOverhead());

		return overhead;
	}

	/**
	 * Computes the network overhead of a solution or an application part.
	 * @param reference
	 *            The reference solution to use.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part for computing its overhead or <code>null</code> for computing the solution overhead.
	 * @return The overhead.
	 **/
	public double getNetworkOverhead(Solution reference, Collection<List<AppliedProtectionInstantiation>> solution,
			ApplicationPart applicationPart)
	{
		double overhead = 0.0;

		for (List<AppliedProtectionInstantiation> i : solution)
			for (AppliedProtectionInstantiation j : i)
				if (applicationPart == null || j.getApplicationPart() == applicationPart)
					overhead += computeFormula(reference, solution, j.getApplicationPart(),
							j.getProtectionInstantiation().getNetworkOverhead());

		return overhead;
	}

	/**
	 * Computes the client time overhead of a solution or an application part.
	 * @param reference
	 *            The reference solution to use.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part for computing its overhead or <code>null</code> for computing the solution overhead.
	 * @return The overhead.
	 **/
	public double getClientTimeOverhead(Solution reference, Solution solution, ApplicationPart applicationPart)
	{
		return getClientTimeOverhead(reference, toCollection(solution), applicationPart);
	}

	/**
	 * Computes the server time overhead of a solution or an application part.
	 * @param reference
	 *            The reference solution to use.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part for computing its overhead or <code>null</code> for computing the solution overhead.
	 * @return The overhead.
	 **/
	public double getServerTimeOverhead(Solution reference, Solution solution, ApplicationPart applicationPart)
	{
		return getServerTimeOverhead(reference, toCollection(solution), applicationPart);
	}

	/**
	 * Computes the client memory overhead of a solution or an application part.
	 * @param reference
	 *            The reference solution to use.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part for computing its overhead or <code>null</code> for computing the solution overhead.
	 * @return The overhead.
	 **/
	public double getClientMemoryOverhead(Solution reference, Solution solution, ApplicationPart applicationPart)
	{
		return getClientMemoryOverhead(reference, toCollection(solution), applicationPart);
	}

	/**
	 * Computes the server memory overhead of a solution or an application part.
	 * @param reference
	 *            The reference solution to use.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part for computing its overhead or <code>null</code> for computing the solution overhead.
	 * @return The overhead.
	 **/
	public double getServerMemoryOverhead(Solution reference, Solution solution, ApplicationPart applicationPart)
	{
		return getServerMemoryOverhead(reference, toCollection(solution), applicationPart);
	}

	/**
	 * Computes the network overhead of a solution or an application part.
	 * @param reference
	 *            The reference solution to use.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part for computing its overhead or <code>null</code> for computing the solution overhead.
	 * @return The overhead.
	 **/
	public double getNetworkOverhead(Solution reference, Solution solution, ApplicationPart applicationPart)
	{
		return getNetworkOverhead(reference, toCollection(solution), applicationPart);
	}

	/**
	 * Converts a solution to a collection of applied PIs.
	 * @param solution
	 *            The solution.
	 * @return The collection of applied PIs.
	 **/
	private Collection<List<AppliedProtectionInstantiation>> toCollection(Solution solution)
	{
		Collection<List<AppliedProtectionInstantiation>> s = new ArrayList<>();

		for (SolutionSequence i : solution.getSolutionSequences())
		{
			List<AppliedProtectionInstantiation> list = new ArrayList<>();
			list.addAll(i.getAppliedProtectionInstantiations());
			s.add(list);
		}

		return s;
	}

	/**
	 * Converts a a collection of applied PIs into a solution.
	 * @param solution
	 *            The collection of applied PIs.
	 * @return The solution.
	 **/
	private Solution toSolution(Collection<List<AppliedProtectionInstantiation>> solution)
	{
		Solution s = KbFactory.eINSTANCE.createSolution();

		for (List<AppliedProtectionInstantiation> i : solution)
		{
			SolutionSequence sequence = KbFactory.eINSTANCE.createSolutionSequence();
			sequence.getAppliedProtectionInstantiations().addAll(i);
			s.getSolutionSequences().add(sequence);
		}

		return s;
	}

	/**
	 * Searches all the metrics in the cache.
	 * @param reference
	 *            The reference solution.
	 * @param applicationPart
	 *            The application part.
	 * @param pis
	 *            The list of PIs.
	 * @return The metric values or <code>null</code> if no values were found.
	 **/
	private Map<String, Double> search(Solution reference, ApplicationPart applicationPart, List<AppliedProtectionInstantiation> pis)
	{
		if (metricsCache.containsKey(reference))
		{
			Map<ApplicationPart, Map<List<AppliedProtectionInstantiation>, Map<String, Double>>> partMap = metricsCache.get(reference);
			if (partMap.containsKey(applicationPart))
			{
				Map<List<AppliedProtectionInstantiation>, Map<String, Double>> piMap = partMap.get(applicationPart);
				if (piMap.containsKey(pis))
					return piMap.get(pis);
			}
		}

		return null;
	}

	/**
	 * Adds the metrics in the cache.
	 * @param reference
	 *            The reference solution.
	 * @param applicationPart
	 *            The application part.
	 * @param pis
	 *            The list of PIs.
	 * @param metrics
	 *            The metrics.
	 **/
	private void add(Solution reference, ApplicationPart applicationPart, List<AppliedProtectionInstantiation> pis,
			Map<String, Double> metrics)
	{
		Map<ApplicationPart, Map<List<AppliedProtectionInstantiation>, Map<String, Double>>> partMap;
		if (metricsCache.containsKey(reference))
			partMap = metricsCache.get(reference);
		else
		{
			partMap = new HashMap<>();
			metricsCache.put(reference, partMap);
		}

		Map<List<AppliedProtectionInstantiation>, Map<String, Double>> piMap;
		if (partMap.containsKey(applicationPart))
			piMap = partMap.get(applicationPart);
		else
		{
			piMap = new HashMap<>();
			partMap.put(applicationPart, piMap);
		}

		piMap.put(pis, metrics);
	}

	/** The logger. **/
	private static Logger log = Logger.getLogger(MetricsFramework.class.getName());
}
