package it.polito.security.esp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import it.polito.security.esp.attacks.AttackFinder;
import it.polito.security.esp.connectors.ACTCConnector;
import it.polito.security.esp.connectors.AnnotationRewriter;
import it.polito.security.esp.connectors.CDTConnector;
import it.polito.security.esp.connectors.Runner;
import it.polito.security.esp.connectors.TigressConnector;
import it.polito.security.esp.kb.KBUtil;
import it.polito.security.esp.kb.Activator;
import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.Model;
import it.polito.security.esp.kb.Preferences;
import it.polito.security.esp.kb.Solution;
import it.polito.security.esp.l1p.AttackEvaluator;
import it.polito.security.esp.l1p.MinimaxSolver;
import it.polito.security.esp.l1p.ProtectionEvaluator;
import it.polito.security.esp.l1p.SimpleAttackEvaluator;
import it.polito.security.esp.l1p.SimpleProtectionEvaluator;
import it.polito.security.esp.l1p.SolutionSolver;
import it.polito.security.esp.l2p.SecondLevelProtectionFinder;
import it.polito.security.esp.metrics.MetricsFramework;
import it.polito.security.esp.protections.ProtectionFinder;
import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.exceptions.InconsistencyException;
import it.polito.security.ontologies.exceptions.NoSuchEntityException;
import it.polito.security.ontologies.exceptions.OntologyChangeException;
import it.polito.security.ontologies.exceptions.OntologyCreationException;
import it.polito.security.ontologies.exceptions.OntologySaveException;
import it.polito.security.ontologies.exceptions.ParsingErrorException;
import it.polito.security.ontologies.exceptions.ReasoningInterruptedException;

/**
 * I am the great ESP, son of ADSS of the ASPIRE tribe! From the desolate land of Turin! One of the last seven sages!
 * @author Daniele Canavese, Leonardo Regano
 **/
public class ESP
{
	/**
	 * Creates a new empty KB.
	 * @param file
	 *            The KB file to create.
	 * @param copyGammasFile
	 *            Specifies if the gamma coefficients files should be copied in the project as well.
	 * @throws IOException
	 *             If some file cannot be read or written.
	 **/
	static public void create(IFile file, boolean copyGammasFile) throws IOException
	{
		create(file, null, copyGammasFile);
	}

	/**
	 * Creates a new empty KB.
	 * @param file
	 *            The KB file to create.
	 * @param preferences
	 *            The preferences to set or <code>null</code> to use the default ones.
	 * @param copyGammasFile
	 *            Specifies if the gamma coefficients files should be copied in the project as well.
	 * @throws IOException
	 *             If some file cannot be read or written.
	 **/
	static public void create(IFile file, Preferences preferences, boolean copyGammasFile) throws IOException
	{
		try
		{
			Ontology ontology = KBUtil.createEmptyOntology(preferences);
			ByteArrayOutputStream array = new ByteArrayOutputStream();
			ontology.save(array);
			if (!file.exists())
				file.create(new ByteArrayInputStream(array.toByteArray()), true, null);

			if (copyGammasFile)
			{
				URL url = new URL("platform:/plugin/" + Activator.PLUGIN_ID + "/files/gammas.csv");
				IFile gammasFile = file.getProject().getFile("gammas.csv");
				if (gammasFile.exists())
					gammasFile.setContents(url.openStream(), true, false, null);
				else
					gammasFile.create(url.openStream(), true, null);
			}

			log.info("KB initialized in " + file);
		}
		catch (Exception e)
		{
			throw new IOException(e.getMessage());
		}
	}

	/**
	 * Closes the ESP connections, if pending.
	 **/
	public void close()
	{
		runner.close();
	}

	/** The logger. **/
	private static Logger log = Logger.getLogger(ESP.class.getName());
	/** The model. **/
	private Model model;
	/** The attack finder. **/
	private AttackFinder attackFinder;
	/** The protection finder. **/
	private ProtectionFinder protectionFinder;
	/** The ACTC connector. **/
	private ACTCConnector actcConnector;
	/** The Tigress connector. **/
	private TigressConnector tigressConnector;
	/** The CDT connector. **/
	private CDTConnector cdtConnector;
	/** The annotation rewriter. **/
	private AnnotationRewriter annotationRewriter;
	/** The metrucs framework. **/
	private MetricsFramework metricsFramework;

	/**
	 * Creates an ESP instance from an existing KB.
	 * @param file
	 *            The KB file to load.
	 * @throws OntologyCreationException
	 *             If the ontology cannot be loaded.
	 * @throws NullPointerException
	 *             If the reasoner cannot be created.
	 * @throws CoreException
	 *             If a custom built-in cannot be registered.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IllegalAccessException
	 *             If a Java been class cannot be used.
	 * @throws InstantiationException
	 *             If a Java been class cannot be instantiated.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 * @throws OntologyChangeException
	 *             If an axiom cannot be added.
	 * @throws JAXBException
	 * @throws URISyntaxException
	 * @throws OntologySaveException
	 * @throws InterruptedException
	 **/
	public ESP(IFile file, Model model) throws OntologyCreationException, CoreException, InstantiationException, IllegalAccessException,
			ClassNotFoundException, NoSuchEntityException, InconsistencyException, ReasoningInterruptedException, ParsingErrorException,
			IOException, OntologyChangeException, JAXBException, URISyntaxException, OntologySaveException, InterruptedException
	{
		this.file = file;
		attackFinder = new AttackFinder(this);
		protectionFinder = new ProtectionFinder(this);
		this.model = model;
		actcConnector = new ACTCConnector(this);
		tigressConnector = new TigressConnector(this);
		cdtConnector = new CDTConnector(this);
		annotationRewriter = new AnnotationRewriter(this);
		runner = new Runner(this);
		metricsFramework = new MetricsFramework(this);

		log.info(String.format("KB loaded = %s, %d objects", file.toString(), model.getOntology().getEObjects().size()));
	}

	/**
	 * Analyzes the source code.
	 * @throws IOException
	 *             If an external command cannot be executed.
	 * @throws CoreException
	 *             If a component cannot be instantiated.
	 **/
	public void analyzeSourceCode() throws IOException, CoreException
	{

		cdtConnector.parse();

		// int functions = 0;
		// int codeBlocks = 0;
		// for (ApplicationPart i : getModel().getAllApplicationParts())
		// {
		// if (i.getType() == ApplicationPartType.FUNCTION)
		// {
		// ++functions;
		// Stack<CodeBlock> aux = new Stack<>();
		// if (i.getBody() != null)
		// aux.push(i.getBody());
		// while (!aux.isEmpty())
		// {
		// CodeBlock block = aux.pop();
		// ++codeBlocks;
		// for (CodeBlock j : block.getCodeBlocks())
		// aux.push(j);
		// }
		// }
		// }
		//
		// System.out.println("Functions: " + functions);
		// System.out.println("Code blocks: " + codeBlocks);
		//
		// final int PROT_COUNT = 4;
		// final int PI_COUNT = 6;
		// final int ASSET_COUNT = PI_COUNT;
		//
		// model.setVanillaSolution(KbFactory.eINSTANCE.createSolution());
		// metricsFramework.build(model.getVanillaSolution(), null);
		//
		// model.getProtections().clear();
		// for (int i = 0; i < PROT_COUNT; ++i)
		// {
		// Protection protection = KbFactory.eINSTANCE.createProtection();
		// protection.setName("prot" + i);
		// protection.setId("prot" + i);
		// protection.setSecondLevel(true);
		// model.getProtections().add(protection);
		// }
		// for (int i = 0; i < PROT_COUNT; ++i)
		// {
		// Protection protection = model.getProtections().get(i);
		// for (int j = i + 1; j < PROT_COUNT; ++j)
		// protection.getForbiddenPrecedences().add(model.getProtections().get(j));
		// }
		//
		// int k = 0;
		// List<ProtectionInstantiation> pis = new ArrayList<>();
		// for (Protection i : model.getProtections())
		// for (int j = 0; j < PI_COUNT; ++j)
		// {
		// ProtectionInstantiation pi = KbFactory.eINSTANCE.createProtectionInstantiation();
		// pi.setName(i.getId() + "." + j);
		// pi.setProtection(i);
		// pi.setCodeAnnotation("obfuscations,enable_obfuscation(flatten_function:percent_apply=" + (++k * 2) + ")");
		// pi.setClientTimeOverhead("0.01 * " + (j + 1));
		// pi.setServerTimeOverhead("0");
		// pi.setClientMemoryOverhead("0");
		// pi.setServerMemoryOverhead("0");
		// pi.setNetworkOverhead("0");
		// pis.add(pi);
		// }
		//
		// System.out.println("PI: " + pis.size());
		//
		// int l = 0;
		// Solution solution = KbFactory.eINSTANCE.createSolution();
		// for (ApplicationPart i : getModel().getAllApplicationParts())
		// if (i.getType() == ApplicationPartType.CODE_REGION)
		// {
		// SolutionSequence sequence = KbFactory.eINSTANCE.createSolutionSequence();
		// for (Protection j : model.getProtections())
		// {
		// ProtectionInstantiation pi = j.getInstantiations().get(l);
		// AppliedProtectionInstantiation api = KbFactory.eINSTANCE.createAppliedProtectionInstantiation();
		// api.setApplicationPart(i);
		// api.setProtectionInstantiation(pi);
		// sequence.getAppliedProtectionInstantiations().add(api);
		// model.getAppliedProtectionInstantiations().add(api);
		// }
		// l = ++l % PI_COUNT;
		// solution.getSolutionSequences().add(sequence);
		// if (solution.getSolutionSequences().size() >= ASSET_COUNT)
		// break;
		// }
		//
		// model.getSolutions().add(solution);
		// System.out.println(solution);
		// System.out.println("Overhead: " + metricsFramework.getClientTimeOverhead(model.getVanillaSolution(), solution, null));
		//
		// try
		// {
		// findSecondLevelProtections(solution);
		// for (Solution i : model.getSolutions())
		// {
		// int count = 0;
		// for (SolutionSequence j : i.getSolutionSequences())
		// count += j.getAppliedProtectionInstantiations().size();
		// System.out.println(count + " " + i);
		// }
		//
		// }
		// catch (Exception e)
		// {
		// e.printStackTrace();
		// }
	}

	/**
	 * Retrieves the runner.
	 * @return The runner.
	 */
	public Runner getRunner()
	{
		return runner;
	}

	/**
	 * Retrieves the model.
	 * @return The model
	 **/
	public Model getModel()
	{
		return model;
	}

	/**
	 * Step 1: finds the attacks and the relevant data.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	public void findAttacks() throws Exception
	{
		attackFinder.run();
		log.info("Attack paths inferred for " + file);
	}

	/**
	 * Step 2: finds the protections and the relevant data.
	 * @throws OntologyChangeException
	 *             If an axiom cannot be added.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IllegalAccessException
	 *             If a Java been class cannot be used.
	 * @throws InstantiationException
	 *             If a Java been class cannot be instantiated.
	 * @throws URISyntaxException
	 * @throws JAXBException
	 *             If an XML file is invalid.
	 * @throws CoreException
	 *             If the ACTC cannot be launched.
	 **/
	public void findProtections() throws InstantiationException, IllegalAccessException, ClassNotFoundException, OntologyChangeException,
			ParsingErrorException, NoSuchEntityException, IOException, InconsistencyException, ReasoningInterruptedException, JAXBException,
			URISyntaxException, CoreException
	{
		actcConnector.collectProtections();
		protectionFinder.run();
		cdtConnector.updateIdentifiers();
	}

	/**
	 * Finds the first level protections.
	 * @param solverObserver
	 *            An optional solver observer to use.
	 * @throws IOException
	 *             If some file cannot be created.
	 * @throws CoreException
	 *             If a log file cannot be created.
	 **/
	public void findFirstLevelProtections() throws IOException, CoreException
	{
		metricsFramework.build(model.getVanillaSolution(), "l1p-actc-build.log");

		if (!model.getPreferences().getMetricsFile().isEmpty() && model.getPreferences().getMetricsFile().startsWith("+"))
		{
			IFile gammaFile = file.getProject().getFile(model.getPreferences().getMetricsFile().substring(1));
			if (gammaFile.exists())
				metricsFramework.loadCoefficients(gammaFile);
		}

		ProtectionEvaluator protectionEvaluator = new SimpleProtectionEvaluator(this);
		AttackEvaluator attackEvaluator = new SimpleAttackEvaluator(this);
		SolutionSolver solver = new MinimaxSolver(this, attackEvaluator, protectionEvaluator);

		solver.run();
		model.getSolutions().addAll(solver.getSolutions());
	}

	/**
	 * Finds the second level protections.
	 * @throws Exception
	 **/
	public void findSecondLevelProtections(Solution solution) throws Exception
	{
		log.fine("Inferring second level protection linear programming model");
		long start = System.currentTimeMillis();
//		deploySolution(solution);
		SecondLevelProtectionFinder secondFinder = new SecondLevelProtectionFinder(this, solution);
		secondFinder.findSecondLevelProtectionWithCompleteModel();
		long stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
	}

	/**
	 * Deploys a solution.
	 * @param solution
	 *            The solution to deploy.
	 * @throws IOException
	 *             If a source file cannot be read.
	 * @throws CoreException
	 *             If a log file cannot be created.
	 **/
	public void deploySolution(Solution solution) throws IOException, CoreException
	{
		actcConnector.clean();
		tigressConnector.clean();
		tigressConnector.build("tigress.log", solution);
		// annotationRewriter.deployPatch(null);
		annotationRewriter.deployPatch(solution);
		 annotationRewriter.deployJSON(solution);
//		annotationRewriter.deployJSON(null);
		actcConnector.build(null);
		log.info("Solution deployed");
	}

	/**
	 * Saves the ESP state to file.
	 * @throws OntologySaveException
	 *             If the ontology cannot be saved.
	 * @throws CoreException
	 *             If the file cannot be refreshed.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IOException
	 *             If an object cannot be serialized or the output file cannot be created.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws OntologyCreationException
	 **/
	public void save() throws OntologySaveException, CoreException, OntologyChangeException, ParsingErrorException, NoSuchEntityException,
			IOException, InconsistencyException, ReasoningInterruptedException, OntologyCreationException
	{
		// Saves a backup first.
		getOntology().save(file.getLocation().toFile() + ".old");

		KBUtil.saveIntoOntology(model);
		getOntology().save(file.getLocation().toFile());
		file.refreshLocal(0, null);

		file.getProject().refreshLocal(IProject.DEPTH_INFINITE, null);

		log.info(String.format("KB saved = %s, %d objects", file.toString(), model.getOntology().getEObjects().size()));
	}

	/**
	 * Returns the KB file.
	 * @return The KB file.
	 **/
	public IFile getKBFile()
	{
		return file;
	}

	/**
	 * Retrieves the ontology.
	 * @return The ontology
	 **/
	public Ontology getOntology()
	{
		return model.getOntology();
	}

	/**
	 * Retrieves the ACTC connector.
	 * @return The ACTC connector.
	 **/
	public ACTCConnector getACTCConnector()
	{
		return actcConnector;
	}

	/**
	 * Retrieves the Tigress connector.
	 * @return The Tigress connector.
	 **/
	public TigressConnector getTigressConnector()
	{
		return tigressConnector;
	}
	
	/**
	 * Retrieves the metrics framework.
	 * @return The metrics framework.
	 **/
	public MetricsFramework getMetricsFramework()
	{
		return metricsFramework;
	}

	/**
	 * Retrieves the annotation rewriter.
	 * @return The annotation rewriter.
	 **/
	public AnnotationRewriter getAnnotationRewriter()
	{
		return annotationRewriter;
	}

	/**
	 * Retrieves the CDT connector.
	 * @return The CDT connector.
	 **/
	public CDTConnector getCDTConnector()
	{
		return cdtConnector;
	}

	/**
	 * Updates the assets. This method <b>must</b> be called if the assets are changed somehow.
	 **/
	public void updateAssets()
	{
		cdtConnector.updateIdentifiers();
	}

	/**
	 * Computes all the metrics and saves them in a file.
	 * @param file
	 *            The file where the metrics will be saved.
	 * @param monitor
	 *            The progress monitor.
	 * @param The
	 *            search depth.
	 * @throws IOException
	 *             If the ACTC command cannot be executed.
	 * @throws CoreException
	 *             If a file cannot be created.
	 **/
	public void computeMetrics(IFile file, IProgressMonitor monitor, int depth) throws IOException, CoreException
	{
		metricsFramework.computeMetrics(file, monitor, depth);
	}

	/**
	 * Computes all the metric coefficients.
	 * @param files
	 *            The files containing the metrics to analyze
	 * @param file
	 *            The file that will contain the results.
	 * @param monitor
	 *            The progress monitor.
	 **/
	public void computeMetricCoefficients(Collection<IFile> files, IFile file, IProgressMonitor monitor) throws IOException, CoreException
	{
		metricsFramework.computeCoefficients(files, file, monitor);
	}

	/**
	 * Creates some fake attack paths for all the assets.
	 **/
	public void createFakeAttackPaths()
	{
		attackFinder.createFakeAttackPaths();
	}

	/** The KB file. **/
	private IFile file;
	/** The runner. **/
	private Runner runner;

	Map<String, Map<Integer, List<Entry<String, ApplicationPart>>>> uses;
}
