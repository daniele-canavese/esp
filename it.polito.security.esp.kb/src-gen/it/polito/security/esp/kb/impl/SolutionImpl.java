/**
 */
package it.polito.security.esp.kb.impl;

import com.google.common.base.Objects;

import it.polito.security.esp.kb.KbPackage;
import it.polito.security.esp.kb.ApplicationPartMetricSet;
import it.polito.security.esp.kb.AttackPath;
import it.polito.security.esp.kb.Metric;
import it.polito.security.esp.kb.Solution;
import it.polito.security.esp.kb.SolutionSequence;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.impl.SolutionImpl#getSolutionSequences <em>Solution Sequences</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.SolutionImpl#getAttackPaths <em>Attack Paths</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.SolutionImpl#getApplicationMetrics <em>Application Metrics</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.SolutionImpl#getApplicationPartMetricSets <em>Application Part Metric Sets</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.SolutionImpl#getFirstLevelSolution <em>First Level Solution</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.SolutionImpl#getL1pScore <em>L1p Score</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.SolutionImpl#getL1pTime <em>L1p Time</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.SolutionImpl#getL2pScore <em>L2p Score</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.SolutionImpl#getL2pTime <em>L2p Time</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.SolutionImpl#getClientTimeOverhead <em>Client Time Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.SolutionImpl#getServerTimeOverhead <em>Server Time Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.SolutionImpl#getClientMemoryOverhead <em>Client Memory Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.SolutionImpl#getServerMemoryOverhead <em>Server Memory Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.SolutionImpl#getNetworkOverhead <em>Network Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.SolutionImpl#getId <em>Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SolutionImpl extends MinimalEObjectImpl.Container implements Solution
{
	/**
	 * The cached value of the '{@link #getSolutionSequences() <em>Solution Sequences</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutionSequences()
	 * @generated
	 * @ordered
	 */
	protected EList<SolutionSequence> solutionSequences;

	/**
	 * The cached value of the '{@link #getAttackPaths() <em>Attack Paths</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackPath> attackPaths;

	/**
	 * The cached value of the '{@link #getApplicationMetrics() <em>Application Metrics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationMetrics()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric> applicationMetrics;

	/**
	 * The cached value of the '{@link #getApplicationPartMetricSets() <em>Application Part Metric Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationPartMetricSets()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationPartMetricSet> applicationPartMetricSets;

	/**
	 * The cached value of the '{@link #getFirstLevelSolution() <em>First Level Solution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstLevelSolution()
	 * @generated
	 * @ordered
	 */
	protected Solution firstLevelSolution;

	/**
	 * The default value of the '{@link #getL1pScore() <em>L1p Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pScore()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_SCORE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getL1pScore() <em>L1p Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pScore()
	 * @generated
	 * @ordered
	 */
	protected double l1pScore = L1P_SCORE_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pTime() <em>L1p Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pTime()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getL1pTime() <em>L1p Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pTime()
	 * @generated
	 * @ordered
	 */
	protected double l1pTime = L1P_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pScore() <em>L2p Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pScore()
	 * @generated
	 * @ordered
	 */
	protected static final double L2P_SCORE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getL2pScore() <em>L2p Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pScore()
	 * @generated
	 * @ordered
	 */
	protected double l2pScore = L2P_SCORE_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pTime() <em>L2p Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pTime()
	 * @generated
	 * @ordered
	 */
	protected static final double L2P_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getL2pTime() <em>L2p Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pTime()
	 * @generated
	 * @ordered
	 */
	protected double l2pTime = L2P_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getClientTimeOverhead() <em>Client Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientTimeOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final double CLIENT_TIME_OVERHEAD_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getClientTimeOverhead() <em>Client Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientTimeOverhead()
	 * @generated
	 * @ordered
	 */
	protected double clientTimeOverhead = CLIENT_TIME_OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getServerTimeOverhead() <em>Server Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerTimeOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final double SERVER_TIME_OVERHEAD_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getServerTimeOverhead() <em>Server Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerTimeOverhead()
	 * @generated
	 * @ordered
	 */
	protected double serverTimeOverhead = SERVER_TIME_OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getClientMemoryOverhead() <em>Client Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientMemoryOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final double CLIENT_MEMORY_OVERHEAD_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getClientMemoryOverhead() <em>Client Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientMemoryOverhead()
	 * @generated
	 * @ordered
	 */
	protected double clientMemoryOverhead = CLIENT_MEMORY_OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getServerMemoryOverhead() <em>Server Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerMemoryOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final double SERVER_MEMORY_OVERHEAD_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getServerMemoryOverhead() <em>Server Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerMemoryOverhead()
	 * @generated
	 * @ordered
	 */
	protected double serverMemoryOverhead = SERVER_MEMORY_OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getNetworkOverhead() <em>Network Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetworkOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final double NETWORK_OVERHEAD_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getNetworkOverhead() <em>Network Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetworkOverhead()
	 * @generated
	 * @ordered
	 */
	protected double networkOverhead = NETWORK_OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SolutionImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return KbPackage.Literals.SOLUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SolutionSequence> getSolutionSequences()
	{
		if (solutionSequences == null)
		{
			solutionSequences = new EObjectResolvingEList<SolutionSequence>(SolutionSequence.class, this, KbPackage.SOLUTION__SOLUTION_SEQUENCES);
		}
		return solutionSequences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackPath> getAttackPaths()
	{
		if (attackPaths == null)
		{
			attackPaths = new EObjectResolvingEList<AttackPath>(AttackPath.class, this, KbPackage.SOLUTION__ATTACK_PATHS);
		}
		return attackPaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric> getApplicationMetrics()
	{
		if (applicationMetrics == null)
		{
			applicationMetrics = new EObjectResolvingEList<Metric>(Metric.class, this, KbPackage.SOLUTION__APPLICATION_METRICS);
		}
		return applicationMetrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationPartMetricSet> getApplicationPartMetricSets()
	{
		if (applicationPartMetricSets == null)
		{
			applicationPartMetricSets = new EObjectResolvingEList<ApplicationPartMetricSet>(ApplicationPartMetricSet.class, this, KbPackage.SOLUTION__APPLICATION_PART_METRIC_SETS);
		}
		return applicationPartMetricSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Solution getFirstLevelSolution()
	{
		if (firstLevelSolution != null && firstLevelSolution.eIsProxy())
		{
			InternalEObject oldFirstLevelSolution = (InternalEObject)firstLevelSolution;
			firstLevelSolution = (Solution)eResolveProxy(oldFirstLevelSolution);
			if (firstLevelSolution != oldFirstLevelSolution)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KbPackage.SOLUTION__FIRST_LEVEL_SOLUTION, oldFirstLevelSolution, firstLevelSolution));
			}
		}
		return firstLevelSolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Solution basicGetFirstLevelSolution()
	{
		return firstLevelSolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstLevelSolution(Solution newFirstLevelSolution)
	{
		Solution oldFirstLevelSolution = firstLevelSolution;
		firstLevelSolution = newFirstLevelSolution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.SOLUTION__FIRST_LEVEL_SOLUTION, oldFirstLevelSolution, firstLevelSolution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getL1pScore()
	{
		return l1pScore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pScore(double newL1pScore)
	{
		double oldL1pScore = l1pScore;
		l1pScore = newL1pScore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.SOLUTION__L1P_SCORE, oldL1pScore, l1pScore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getL1pTime()
	{
		return l1pTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pTime(double newL1pTime)
	{
		double oldL1pTime = l1pTime;
		l1pTime = newL1pTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.SOLUTION__L1P_TIME, oldL1pTime, l1pTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getL2pScore()
	{
		return l2pScore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL2pScore(double newL2pScore)
	{
		double oldL2pScore = l2pScore;
		l2pScore = newL2pScore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.SOLUTION__L2P_SCORE, oldL2pScore, l2pScore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getL2pTime()
	{
		return l2pTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL2pTime(double newL2pTime)
	{
		double oldL2pTime = l2pTime;
		l2pTime = newL2pTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.SOLUTION__L2P_TIME, oldL2pTime, l2pTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getClientTimeOverhead()
	{
		return clientTimeOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClientTimeOverhead(double newClientTimeOverhead)
	{
		double oldClientTimeOverhead = clientTimeOverhead;
		clientTimeOverhead = newClientTimeOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.SOLUTION__CLIENT_TIME_OVERHEAD, oldClientTimeOverhead, clientTimeOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getServerTimeOverhead()
	{
		return serverTimeOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerTimeOverhead(double newServerTimeOverhead)
	{
		double oldServerTimeOverhead = serverTimeOverhead;
		serverTimeOverhead = newServerTimeOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.SOLUTION__SERVER_TIME_OVERHEAD, oldServerTimeOverhead, serverTimeOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getClientMemoryOverhead()
	{
		return clientMemoryOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClientMemoryOverhead(double newClientMemoryOverhead)
	{
		double oldClientMemoryOverhead = clientMemoryOverhead;
		clientMemoryOverhead = newClientMemoryOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.SOLUTION__CLIENT_MEMORY_OVERHEAD, oldClientMemoryOverhead, clientMemoryOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getServerMemoryOverhead()
	{
		return serverMemoryOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerMemoryOverhead(double newServerMemoryOverhead)
	{
		double oldServerMemoryOverhead = serverMemoryOverhead;
		serverMemoryOverhead = newServerMemoryOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.SOLUTION__SERVER_MEMORY_OVERHEAD, oldServerMemoryOverhead, serverMemoryOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getNetworkOverhead()
	{
		return networkOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetworkOverhead(double newNetworkOverhead)
	{
		double oldNetworkOverhead = networkOverhead;
		networkOverhead = newNetworkOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.SOLUTION__NETWORK_OVERHEAD, oldNetworkOverhead, networkOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId()
	{
		int _hashCode = this.hashCode();
		long h = (((long) _hashCode) + (-((long) Integer.MIN_VALUE)));
		Solution _firstLevelSolution = this.getFirstLevelSolution();
		boolean _equals = Objects.equal(_firstLevelSolution, null);
		if (_equals)
		{
			return Long.valueOf(h).toString();
		}
		else
		{
			String _string = Long.valueOf(h).toString();
			String _plus = (_string + " (");
			String _string_1 = this.getFirstLevelSolution().getId().toString();
			String _plus_1 = (_plus + _string_1);
			return (_plus_1 + ")");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString()
	{
		return this.getSolutionSequences().toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		int r = 0;
		EList<SolutionSequence> _solutionSequences = this.getSolutionSequences();
		for (final SolutionSequence i : _solutionSequences)
		{
			int _r = r;
			int _hashCode = i.hashCode();
			r = (_r + _hashCode);
		}
		result = ((31 * result) + r);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean equals(final Object object)
	{
		boolean _equals = Objects.equal(object, null);
		if (_equals)
		{
			return false;
		}
		else
		{
			if ((object instanceof Solution))
			{
				return EcoreUtil.equals(this.getSolutionSequences(), ((Solution)object).getSolutionSequences());
			}
			else
			{
				return false;
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case KbPackage.SOLUTION__SOLUTION_SEQUENCES:
				return getSolutionSequences();
			case KbPackage.SOLUTION__ATTACK_PATHS:
				return getAttackPaths();
			case KbPackage.SOLUTION__APPLICATION_METRICS:
				return getApplicationMetrics();
			case KbPackage.SOLUTION__APPLICATION_PART_METRIC_SETS:
				return getApplicationPartMetricSets();
			case KbPackage.SOLUTION__FIRST_LEVEL_SOLUTION:
				if (resolve) return getFirstLevelSolution();
				return basicGetFirstLevelSolution();
			case KbPackage.SOLUTION__L1P_SCORE:
				return getL1pScore();
			case KbPackage.SOLUTION__L1P_TIME:
				return getL1pTime();
			case KbPackage.SOLUTION__L2P_SCORE:
				return getL2pScore();
			case KbPackage.SOLUTION__L2P_TIME:
				return getL2pTime();
			case KbPackage.SOLUTION__CLIENT_TIME_OVERHEAD:
				return getClientTimeOverhead();
			case KbPackage.SOLUTION__SERVER_TIME_OVERHEAD:
				return getServerTimeOverhead();
			case KbPackage.SOLUTION__CLIENT_MEMORY_OVERHEAD:
				return getClientMemoryOverhead();
			case KbPackage.SOLUTION__SERVER_MEMORY_OVERHEAD:
				return getServerMemoryOverhead();
			case KbPackage.SOLUTION__NETWORK_OVERHEAD:
				return getNetworkOverhead();
			case KbPackage.SOLUTION__ID:
				return getId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case KbPackage.SOLUTION__SOLUTION_SEQUENCES:
				getSolutionSequences().clear();
				getSolutionSequences().addAll((Collection<? extends SolutionSequence>)newValue);
				return;
			case KbPackage.SOLUTION__ATTACK_PATHS:
				getAttackPaths().clear();
				getAttackPaths().addAll((Collection<? extends AttackPath>)newValue);
				return;
			case KbPackage.SOLUTION__APPLICATION_METRICS:
				getApplicationMetrics().clear();
				getApplicationMetrics().addAll((Collection<? extends Metric>)newValue);
				return;
			case KbPackage.SOLUTION__APPLICATION_PART_METRIC_SETS:
				getApplicationPartMetricSets().clear();
				getApplicationPartMetricSets().addAll((Collection<? extends ApplicationPartMetricSet>)newValue);
				return;
			case KbPackage.SOLUTION__FIRST_LEVEL_SOLUTION:
				setFirstLevelSolution((Solution)newValue);
				return;
			case KbPackage.SOLUTION__L1P_SCORE:
				setL1pScore((Double)newValue);
				return;
			case KbPackage.SOLUTION__L1P_TIME:
				setL1pTime((Double)newValue);
				return;
			case KbPackage.SOLUTION__L2P_SCORE:
				setL2pScore((Double)newValue);
				return;
			case KbPackage.SOLUTION__L2P_TIME:
				setL2pTime((Double)newValue);
				return;
			case KbPackage.SOLUTION__CLIENT_TIME_OVERHEAD:
				setClientTimeOverhead((Double)newValue);
				return;
			case KbPackage.SOLUTION__SERVER_TIME_OVERHEAD:
				setServerTimeOverhead((Double)newValue);
				return;
			case KbPackage.SOLUTION__CLIENT_MEMORY_OVERHEAD:
				setClientMemoryOverhead((Double)newValue);
				return;
			case KbPackage.SOLUTION__SERVER_MEMORY_OVERHEAD:
				setServerMemoryOverhead((Double)newValue);
				return;
			case KbPackage.SOLUTION__NETWORK_OVERHEAD:
				setNetworkOverhead((Double)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case KbPackage.SOLUTION__SOLUTION_SEQUENCES:
				getSolutionSequences().clear();
				return;
			case KbPackage.SOLUTION__ATTACK_PATHS:
				getAttackPaths().clear();
				return;
			case KbPackage.SOLUTION__APPLICATION_METRICS:
				getApplicationMetrics().clear();
				return;
			case KbPackage.SOLUTION__APPLICATION_PART_METRIC_SETS:
				getApplicationPartMetricSets().clear();
				return;
			case KbPackage.SOLUTION__FIRST_LEVEL_SOLUTION:
				setFirstLevelSolution((Solution)null);
				return;
			case KbPackage.SOLUTION__L1P_SCORE:
				setL1pScore(L1P_SCORE_EDEFAULT);
				return;
			case KbPackage.SOLUTION__L1P_TIME:
				setL1pTime(L1P_TIME_EDEFAULT);
				return;
			case KbPackage.SOLUTION__L2P_SCORE:
				setL2pScore(L2P_SCORE_EDEFAULT);
				return;
			case KbPackage.SOLUTION__L2P_TIME:
				setL2pTime(L2P_TIME_EDEFAULT);
				return;
			case KbPackage.SOLUTION__CLIENT_TIME_OVERHEAD:
				setClientTimeOverhead(CLIENT_TIME_OVERHEAD_EDEFAULT);
				return;
			case KbPackage.SOLUTION__SERVER_TIME_OVERHEAD:
				setServerTimeOverhead(SERVER_TIME_OVERHEAD_EDEFAULT);
				return;
			case KbPackage.SOLUTION__CLIENT_MEMORY_OVERHEAD:
				setClientMemoryOverhead(CLIENT_MEMORY_OVERHEAD_EDEFAULT);
				return;
			case KbPackage.SOLUTION__SERVER_MEMORY_OVERHEAD:
				setServerMemoryOverhead(SERVER_MEMORY_OVERHEAD_EDEFAULT);
				return;
			case KbPackage.SOLUTION__NETWORK_OVERHEAD:
				setNetworkOverhead(NETWORK_OVERHEAD_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case KbPackage.SOLUTION__SOLUTION_SEQUENCES:
				return solutionSequences != null && !solutionSequences.isEmpty();
			case KbPackage.SOLUTION__ATTACK_PATHS:
				return attackPaths != null && !attackPaths.isEmpty();
			case KbPackage.SOLUTION__APPLICATION_METRICS:
				return applicationMetrics != null && !applicationMetrics.isEmpty();
			case KbPackage.SOLUTION__APPLICATION_PART_METRIC_SETS:
				return applicationPartMetricSets != null && !applicationPartMetricSets.isEmpty();
			case KbPackage.SOLUTION__FIRST_LEVEL_SOLUTION:
				return firstLevelSolution != null;
			case KbPackage.SOLUTION__L1P_SCORE:
				return l1pScore != L1P_SCORE_EDEFAULT;
			case KbPackage.SOLUTION__L1P_TIME:
				return l1pTime != L1P_TIME_EDEFAULT;
			case KbPackage.SOLUTION__L2P_SCORE:
				return l2pScore != L2P_SCORE_EDEFAULT;
			case KbPackage.SOLUTION__L2P_TIME:
				return l2pTime != L2P_TIME_EDEFAULT;
			case KbPackage.SOLUTION__CLIENT_TIME_OVERHEAD:
				return clientTimeOverhead != CLIENT_TIME_OVERHEAD_EDEFAULT;
			case KbPackage.SOLUTION__SERVER_TIME_OVERHEAD:
				return serverTimeOverhead != SERVER_TIME_OVERHEAD_EDEFAULT;
			case KbPackage.SOLUTION__CLIENT_MEMORY_OVERHEAD:
				return clientMemoryOverhead != CLIENT_MEMORY_OVERHEAD_EDEFAULT;
			case KbPackage.SOLUTION__SERVER_MEMORY_OVERHEAD:
				return serverMemoryOverhead != SERVER_MEMORY_OVERHEAD_EDEFAULT;
			case KbPackage.SOLUTION__NETWORK_OVERHEAD:
				return networkOverhead != NETWORK_OVERHEAD_EDEFAULT;
			case KbPackage.SOLUTION__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case KbPackage.SOLUTION___TO_STRING:
				return toString();
			case KbPackage.SOLUTION___HASH_CODE:
				return hashCode();
			case KbPackage.SOLUTION___EQUALS__OBJECT:
				return equals(arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //SolutionImpl
