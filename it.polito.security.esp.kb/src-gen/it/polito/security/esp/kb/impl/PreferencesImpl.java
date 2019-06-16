/**
 */
package it.polito.security.esp.kb.impl;

import it.polito.security.esp.kb.FitterType;
import it.polito.security.esp.kb.KbPackage;
import it.polito.security.esp.kb.Level;
import it.polito.security.esp.kb.Preferences;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Preferences</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getWorkingDirectory <em>Working Directory</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getActcConfigurationFile <em>Actc Configuration File</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getEspPatchFile <em>Esp Patch File</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getEspJSONFile <em>Esp JSON File</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#isRemoteConnection <em>Remote Connection</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getRemoteUsername <em>Remote Username</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getRemotePassword <em>Remote Password</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getRemoteHost <em>Remote Host</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getRemotePort <em>Remote Port</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getRemoteFileSeparator <em>Remote File Separator</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getCommandACTC <em>Command ACTC</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getCommandTigress <em>Command Tigress</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getCommandCilly <em>Command Cilly</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getCommandPerl <em>Command Perl</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getCommandDot <em>Command Dot</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getMetricsFile <em>Metrics File</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getMetricsTransformationDegree <em>Metrics Transformation Degree</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getMetricsPseudoInverseSensitivity <em>Metrics Pseudo Inverse Sensitivity</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getMetricsDerivativeSensitivity <em>Metrics Derivative Sensitivity</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getMetricsFitter <em>Metrics Fitter</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getMetricsNonLinearMaximumIterations <em>Metrics Non Linear Maximum Iterations</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getMetricsNonLinearStepSize <em>Metrics Non Linear Step Size</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getMetricsNonLinearMinimumError <em>Metrics Non Linear Minimum Error</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getMetricsNonLinearMinimumChange <em>Metrics Non Linear Minimum Change</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#isParserHeaderParsing <em>Parser Header Parsing</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#isParserSystemFilesIgnoration <em>Parser System Files Ignoration</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getAttacksTimeLimit <em>Attacks Time Limit</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getAttacksMaximumDepth <em>Attacks Maximum Depth</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#isAttacksIncludedProtectionObjectivesRemoval <em>Attacks Included Protection Objectives Removal</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getProtectionsMinimumAttackMitigation <em>Protections Minimum Attack Mitigation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getMaxAttestatorsPerProtectionInstantiation <em>Max Attestators Per Protection Instantiation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getClientTimeOverhead <em>Client Time Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getServerTimeOverhead <em>Server Time Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getClientMemoryOverhead <em>Client Memory Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getServerMemoryOverhead <em>Server Memory Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getNetworkOverhead <em>Network Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pSolutionsCount <em>L1p Solutions Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pTimeLimit <em>L1p Time Limit</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pSolutionsLimit <em>L1p Solutions Limit</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pGapLimit <em>L1p Gap Limit</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pClientTimeOverheadPercentage <em>L1p Client Time Overhead Percentage</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pServerTimeOverheadPercentage <em>L1p Server Time Overhead Percentage</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pClientMemoryOverheadPercentage <em>L1p Client Memory Overhead Percentage</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pServerMemoryOverheadPercentage <em>L1p Server Memory Overhead Percentage</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pNetworkOverheadPercentage <em>L1p Network Overhead Percentage</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#isL1pDiscouragedPrecedencesIgnoration <em>L1p Discouraged Precedences Ignoration</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#isL1pEncouragedPrecedencesFocusing <em>L1p Encouraged Precedences Focusing</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#isL1pUseACTCPrecedences <em>L1p Use ACTC Precedences</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#isL1pIgnoreApplicationPartOrder <em>L1p Ignore Application Part Order</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pMaximumInstantiationsPerProtectionObjective <em>L1p Maximum Instantiations Per Protection Objective</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pMainSearchMaximumDepth <em>L1p Main Search Maximum Depth</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pMultiTreeMultiplier <em>L1p Multi Tree Multiplier</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pInitialAlpha <em>L1p Initial Alpha</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pInitialBeta <em>L1p Initial Beta</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pResearchDelta <em>L1p Research Delta</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pTranspositionTableMaximumSize <em>L1p Transposition Table Maximum Size</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pFutilityMargin <em>L1p Futility Margin</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pExtendedFutilityMargin <em>L1p Extended Futility Margin</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL1pRazoringMargin <em>L1p Razoring Margin</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL2pSolutionsCount <em>L2p Solutions Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL2pFunctionSplittingSeed <em>L2p Function Splitting Seed</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#isL2pStartFromL1pSolution <em>L2p Start From L1p Solution</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL2pSolutionLimit <em>L2p Solution Limit</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL2pTimeLimit <em>L2p Time Limit</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL2pGapLimit <em>L2p Gap Limit</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL2pUpperBound <em>L2p Upper Bound</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL2pFunctionSplittingMediumCodeBlockLength <em>L2p Function Splitting Medium Code Block Length</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator <em>L2p Function Splitting Code Block Length Randomization Denominator</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.PreferencesImpl#getL2pFunctionSplittingDepthLevel <em>L2p Function Splitting Depth Level</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PreferencesImpl extends MinimalEObjectImpl.Container implements Preferences {
	/**
	 * The default value of the '{@link #getWorkingDirectory() <em>Working Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkingDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final String WORKING_DIRECTORY_EDEFAULT = "/home/aspire/test";

	/**
	 * The cached value of the '{@link #getWorkingDirectory() <em>Working Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkingDirectory()
	 * @generated
	 * @ordered
	 */
	protected String workingDirectory = WORKING_DIRECTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getActcConfigurationFile() <em>Actc Configuration File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActcConfigurationFile()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTC_CONFIGURATION_FILE_EDEFAULT = "test.json";

	/**
	 * The cached value of the '{@link #getActcConfigurationFile() <em>Actc Configuration File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActcConfigurationFile()
	 * @generated
	 * @ordered
	 */
	protected String actcConfigurationFile = ACTC_CONFIGURATION_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEspPatchFile() <em>Esp Patch File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEspPatchFile()
	 * @generated
	 * @ordered
	 */
	protected static final String ESP_PATCH_FILE_EDEFAULT = "esp.patch";

	/**
	 * The cached value of the '{@link #getEspPatchFile() <em>Esp Patch File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEspPatchFile()
	 * @generated
	 * @ordered
	 */
	protected String espPatchFile = ESP_PATCH_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEspJSONFile() <em>Esp JSON File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEspJSONFile()
	 * @generated
	 * @ordered
	 */
	protected static final String ESP_JSON_FILE_EDEFAULT = "esp.json";

	/**
	 * The cached value of the '{@link #getEspJSONFile() <em>Esp JSON File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEspJSONFile()
	 * @generated
	 * @ordered
	 */
	protected String espJSONFile = ESP_JSON_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getArchitecture() <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchitecture()
	 * @generated
	 * @ordered
	 */
	protected static final String ARCHITECTURE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getArchitecture() <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchitecture()
	 * @generated
	 * @ordered
	 */
	protected String architecture = ARCHITECTURE_EDEFAULT;

	/**
	 * The default value of the '{@link #isRemoteConnection() <em>Remote Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoteConnection()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REMOTE_CONNECTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRemoteConnection() <em>Remote Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoteConnection()
	 * @generated
	 * @ordered
	 */
	protected boolean remoteConnection = REMOTE_CONNECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRemoteUsername() <em>Remote Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String REMOTE_USERNAME_EDEFAULT = "aspire";

	/**
	 * The cached value of the '{@link #getRemoteUsername() <em>Remote Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteUsername()
	 * @generated
	 * @ordered
	 */
	protected String remoteUsername = REMOTE_USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRemotePassword() <em>Remote Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemotePassword()
	 * @generated
	 * @ordered
	 */
	protected static final String REMOTE_PASSWORD_EDEFAULT = "aspire";

	/**
	 * The cached value of the '{@link #getRemotePassword() <em>Remote Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemotePassword()
	 * @generated
	 * @ordered
	 */
	protected String remotePassword = REMOTE_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getRemoteHost() <em>Remote Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteHost()
	 * @generated
	 * @ordered
	 */
	protected static final String REMOTE_HOST_EDEFAULT = "127.0.1.1";

	/**
	 * The cached value of the '{@link #getRemoteHost() <em>Remote Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteHost()
	 * @generated
	 * @ordered
	 */
	protected String remoteHost = REMOTE_HOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getRemotePort() <em>Remote Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemotePort()
	 * @generated
	 * @ordered
	 */
	protected static final int REMOTE_PORT_EDEFAULT = 3022;

	/**
	 * The cached value of the '{@link #getRemotePort() <em>Remote Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemotePort()
	 * @generated
	 * @ordered
	 */
	protected int remotePort = REMOTE_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRemoteFileSeparator() <em>Remote File Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteFileSeparator()
	 * @generated
	 * @ordered
	 */
	protected static final String REMOTE_FILE_SEPARATOR_EDEFAULT = "/";

	/**
	 * The cached value of the '{@link #getRemoteFileSeparator() <em>Remote File Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteFileSeparator()
	 * @generated
	 * @ordered
	 */
	protected String remoteFileSeparator = REMOTE_FILE_SEPARATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommandACTC() <em>Command ACTC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandACTC()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_ACTC_EDEFAULT = "docker-compose -f ~/git/framework/docker-compose.yml exec -T actc /opt/ACTC/actc.py";

	/**
	 * The cached value of the '{@link #getCommandACTC() <em>Command ACTC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandACTC()
	 * @generated
	 * @ordered
	 */
	protected String commandACTC = COMMAND_ACTC_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommandTigress() <em>Command Tigress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandTigress()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_TIGRESS_EDEFAULT = "docker-compose -f ~/git/framework/docker-compose.yml exec -T actc env TIGRESS_HOME=/projects/tigress-unstable PATH=$PATH:/projects/tigress-unstable /projects/tigress-unstable/tigress";

	/**
	 * The cached value of the '{@link #getCommandTigress() <em>Command Tigress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandTigress()
	 * @generated
	 * @ordered
	 */
	protected String commandTigress = COMMAND_TIGRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommandCilly() <em>Command Cilly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandCilly()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_CILLY_EDEFAULT = "docker-compose -f ~/git/framework/docker-compose.yml exec -T actc env TIGRESS_HOME=/projects/tigress-unstable PATH=$PATH:/projects/tigress-unstable /projects/tigress-unstable/cilly";

	/**
	 * The cached value of the '{@link #getCommandCilly() <em>Command Cilly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandCilly()
	 * @generated
	 * @ordered
	 */
	protected String commandCilly = COMMAND_CILLY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommandPerl() <em>Command Perl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandPerl()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_PERL_EDEFAULT = "/usr/bin/perl";

	/**
	 * The cached value of the '{@link #getCommandPerl() <em>Command Perl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandPerl()
	 * @generated
	 * @ordered
	 */
	protected String commandPerl = COMMAND_PERL_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommandDot() <em>Command Dot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandDot()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_DOT_EDEFAULT = "/usr/bin/dot";

	/**
	 * The cached value of the '{@link #getCommandDot() <em>Command Dot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandDot()
	 * @generated
	 * @ordered
	 */
	protected String commandDot = COMMAND_DOT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetricsFile() <em>Metrics File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsFile()
	 * @generated
	 * @ordered
	 */
	protected static final String METRICS_FILE_EDEFAULT = "+gammas.csv";

	/**
	 * The cached value of the '{@link #getMetricsFile() <em>Metrics File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsFile()
	 * @generated
	 * @ordered
	 */
	protected String metricsFile = METRICS_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetricsTransformationDegree() <em>Metrics Transformation Degree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsTransformationDegree()
	 * @generated
	 * @ordered
	 */
	protected static final int METRICS_TRANSFORMATION_DEGREE_EDEFAULT = 4;

	/**
	 * The cached value of the '{@link #getMetricsTransformationDegree() <em>Metrics Transformation Degree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsTransformationDegree()
	 * @generated
	 * @ordered
	 */
	protected int metricsTransformationDegree = METRICS_TRANSFORMATION_DEGREE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetricsPseudoInverseSensitivity() <em>Metrics Pseudo Inverse Sensitivity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsPseudoInverseSensitivity()
	 * @generated
	 * @ordered
	 */
	protected static final double METRICS_PSEUDO_INVERSE_SENSITIVITY_EDEFAULT = 1.0E-9;

	/**
	 * The cached value of the '{@link #getMetricsPseudoInverseSensitivity() <em>Metrics Pseudo Inverse Sensitivity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsPseudoInverseSensitivity()
	 * @generated
	 * @ordered
	 */
	protected double metricsPseudoInverseSensitivity = METRICS_PSEUDO_INVERSE_SENSITIVITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetricsDerivativeSensitivity() <em>Metrics Derivative Sensitivity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsDerivativeSensitivity()
	 * @generated
	 * @ordered
	 */
	protected static final double METRICS_DERIVATIVE_SENSITIVITY_EDEFAULT = 1.0E-9;

	/**
	 * The cached value of the '{@link #getMetricsDerivativeSensitivity() <em>Metrics Derivative Sensitivity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsDerivativeSensitivity()
	 * @generated
	 * @ordered
	 */
	protected double metricsDerivativeSensitivity = METRICS_DERIVATIVE_SENSITIVITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetricsFitter() <em>Metrics Fitter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsFitter()
	 * @generated
	 * @ordered
	 */
	protected static final FitterType METRICS_FITTER_EDEFAULT = FitterType.NON_LINEAR;

	/**
	 * The cached value of the '{@link #getMetricsFitter() <em>Metrics Fitter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsFitter()
	 * @generated
	 * @ordered
	 */
	protected FitterType metricsFitter = METRICS_FITTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetricsNonLinearMaximumIterations() <em>Metrics Non Linear Maximum Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsNonLinearMaximumIterations()
	 * @generated
	 * @ordered
	 */
	protected static final int METRICS_NON_LINEAR_MAXIMUM_ITERATIONS_EDEFAULT = 10000;

	/**
	 * The cached value of the '{@link #getMetricsNonLinearMaximumIterations() <em>Metrics Non Linear Maximum Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsNonLinearMaximumIterations()
	 * @generated
	 * @ordered
	 */
	protected int metricsNonLinearMaximumIterations = METRICS_NON_LINEAR_MAXIMUM_ITERATIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetricsNonLinearStepSize() <em>Metrics Non Linear Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsNonLinearStepSize()
	 * @generated
	 * @ordered
	 */
	protected static final double METRICS_NON_LINEAR_STEP_SIZE_EDEFAULT = 0.01;

	/**
	 * The cached value of the '{@link #getMetricsNonLinearStepSize() <em>Metrics Non Linear Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsNonLinearStepSize()
	 * @generated
	 * @ordered
	 */
	protected double metricsNonLinearStepSize = METRICS_NON_LINEAR_STEP_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetricsNonLinearMinimumError() <em>Metrics Non Linear Minimum Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsNonLinearMinimumError()
	 * @generated
	 * @ordered
	 */
	protected static final double METRICS_NON_LINEAR_MINIMUM_ERROR_EDEFAULT = 1.0E-9;

	/**
	 * The cached value of the '{@link #getMetricsNonLinearMinimumError() <em>Metrics Non Linear Minimum Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsNonLinearMinimumError()
	 * @generated
	 * @ordered
	 */
	protected double metricsNonLinearMinimumError = METRICS_NON_LINEAR_MINIMUM_ERROR_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetricsNonLinearMinimumChange() <em>Metrics Non Linear Minimum Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsNonLinearMinimumChange()
	 * @generated
	 * @ordered
	 */
	protected static final double METRICS_NON_LINEAR_MINIMUM_CHANGE_EDEFAULT = 1.0E-9;

	/**
	 * The cached value of the '{@link #getMetricsNonLinearMinimumChange() <em>Metrics Non Linear Minimum Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsNonLinearMinimumChange()
	 * @generated
	 * @ordered
	 */
	protected double metricsNonLinearMinimumChange = METRICS_NON_LINEAR_MINIMUM_CHANGE_EDEFAULT;

	/**
	 * The default value of the '{@link #isParserHeaderParsing() <em>Parser Header Parsing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParserHeaderParsing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PARSER_HEADER_PARSING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isParserHeaderParsing() <em>Parser Header Parsing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParserHeaderParsing()
	 * @generated
	 * @ordered
	 */
	protected boolean parserHeaderParsing = PARSER_HEADER_PARSING_EDEFAULT;

	/**
	 * The default value of the '{@link #isParserSystemFilesIgnoration() <em>Parser System Files Ignoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParserSystemFilesIgnoration()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PARSER_SYSTEM_FILES_IGNORATION_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isParserSystemFilesIgnoration() <em>Parser System Files Ignoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParserSystemFilesIgnoration()
	 * @generated
	 * @ordered
	 */
	protected boolean parserSystemFilesIgnoration = PARSER_SYSTEM_FILES_IGNORATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttacksTimeLimit() <em>Attacks Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttacksTimeLimit()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTACKS_TIME_LIMIT_EDEFAULT = 60;

	/**
	 * The cached value of the '{@link #getAttacksTimeLimit() <em>Attacks Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttacksTimeLimit()
	 * @generated
	 * @ordered
	 */
	protected int attacksTimeLimit = ATTACKS_TIME_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttacksMaximumDepth() <em>Attacks Maximum Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttacksMaximumDepth()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTACKS_MAXIMUM_DEPTH_EDEFAULT = 4;

	/**
	 * The cached value of the '{@link #getAttacksMaximumDepth() <em>Attacks Maximum Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttacksMaximumDepth()
	 * @generated
	 * @ordered
	 */
	protected int attacksMaximumDepth = ATTACKS_MAXIMUM_DEPTH_EDEFAULT;

	/**
	 * The default value of the '{@link #isAttacksIncludedProtectionObjectivesRemoval() <em>Attacks Included Protection Objectives Removal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAttacksIncludedProtectionObjectivesRemoval()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAttacksIncludedProtectionObjectivesRemoval() <em>Attacks Included Protection Objectives Removal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAttacksIncludedProtectionObjectivesRemoval()
	 * @generated
	 * @ordered
	 */
	protected boolean attacksIncludedProtectionObjectivesRemoval = ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getProtectionsMinimumAttackMitigation() <em>Protections Minimum Attack Mitigation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtectionsMinimumAttackMitigation()
	 * @generated
	 * @ordered
	 */
	protected static final Level PROTECTIONS_MINIMUM_ATTACK_MITIGATION_EDEFAULT = Level.MEDIUM;

	/**
	 * The cached value of the '{@link #getProtectionsMinimumAttackMitigation() <em>Protections Minimum Attack Mitigation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtectionsMinimumAttackMitigation()
	 * @generated
	 * @ordered
	 */
	protected Level protectionsMinimumAttackMitigation = PROTECTIONS_MINIMUM_ATTACK_MITIGATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxAttestatorsPerProtectionInstantiation() <em>Max Attestators Per Protection Instantiation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxAttestatorsPerProtectionInstantiation()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_ATTESTATORS_PER_PROTECTION_INSTANTIATION_EDEFAULT = 3;

	/**
	 * The cached value of the '{@link #getMaxAttestatorsPerProtectionInstantiation() <em>Max Attestators Per Protection Instantiation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxAttestatorsPerProtectionInstantiation()
	 * @generated
	 * @ordered
	 */
	protected int maxAttestatorsPerProtectionInstantiation = MAX_ATTESTATORS_PER_PROTECTION_INSTANTIATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getClientTimeOverhead() <em>Client Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientTimeOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final double CLIENT_TIME_OVERHEAD_EDEFAULT = 10.0;

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
	protected static final double SERVER_TIME_OVERHEAD_EDEFAULT = 10.0;

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
	protected static final int CLIENT_MEMORY_OVERHEAD_EDEFAULT = 10240;

	/**
	 * The cached value of the '{@link #getClientMemoryOverhead() <em>Client Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientMemoryOverhead()
	 * @generated
	 * @ordered
	 */
	protected int clientMemoryOverhead = CLIENT_MEMORY_OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getServerMemoryOverhead() <em>Server Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerMemoryOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final int SERVER_MEMORY_OVERHEAD_EDEFAULT = 10240;

	/**
	 * The cached value of the '{@link #getServerMemoryOverhead() <em>Server Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerMemoryOverhead()
	 * @generated
	 * @ordered
	 */
	protected int serverMemoryOverhead = SERVER_MEMORY_OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getNetworkOverhead() <em>Network Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetworkOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final int NETWORK_OVERHEAD_EDEFAULT = 1048576;

	/**
	 * The cached value of the '{@link #getNetworkOverhead() <em>Network Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetworkOverhead()
	 * @generated
	 * @ordered
	 */
	protected int networkOverhead = NETWORK_OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pSolutionsCount() <em>L1p Solutions Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pSolutionsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int L1P_SOLUTIONS_COUNT_EDEFAULT = 3;

	/**
	 * The cached value of the '{@link #getL1pSolutionsCount() <em>L1p Solutions Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pSolutionsCount()
	 * @generated
	 * @ordered
	 */
	protected int l1pSolutionsCount = L1P_SOLUTIONS_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pTimeLimit() <em>L1p Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pTimeLimit()
	 * @generated
	 * @ordered
	 */
	protected static final int L1P_TIME_LIMIT_EDEFAULT = 60;

	/**
	 * The cached value of the '{@link #getL1pTimeLimit() <em>L1p Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pTimeLimit()
	 * @generated
	 * @ordered
	 */
	protected int l1pTimeLimit = L1P_TIME_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pSolutionsLimit() <em>L1p Solutions Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pSolutionsLimit()
	 * @generated
	 * @ordered
	 */
	protected static final int L1P_SOLUTIONS_LIMIT_EDEFAULT = -10000;

	/**
	 * The cached value of the '{@link #getL1pSolutionsLimit() <em>L1p Solutions Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pSolutionsLimit()
	 * @generated
	 * @ordered
	 */
	protected int l1pSolutionsLimit = L1P_SOLUTIONS_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pGapLimit() <em>L1p Gap Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pGapLimit()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_GAP_LIMIT_EDEFAULT = -10.0;

	/**
	 * The cached value of the '{@link #getL1pGapLimit() <em>L1p Gap Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pGapLimit()
	 * @generated
	 * @ordered
	 */
	protected double l1pGapLimit = L1P_GAP_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pClientTimeOverheadPercentage() <em>L1p Client Time Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pClientTimeOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE_EDEFAULT = 75.0;

	/**
	 * The cached value of the '{@link #getL1pClientTimeOverheadPercentage() <em>L1p Client Time Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pClientTimeOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected double l1pClientTimeOverheadPercentage = L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pServerTimeOverheadPercentage() <em>L1p Server Time Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pServerTimeOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_SERVER_TIME_OVERHEAD_PERCENTAGE_EDEFAULT = -75.0;

	/**
	 * The cached value of the '{@link #getL1pServerTimeOverheadPercentage() <em>L1p Server Time Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pServerTimeOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected double l1pServerTimeOverheadPercentage = L1P_SERVER_TIME_OVERHEAD_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pClientMemoryOverheadPercentage() <em>L1p Client Memory Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pClientMemoryOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE_EDEFAULT = -75.0;

	/**
	 * The cached value of the '{@link #getL1pClientMemoryOverheadPercentage() <em>L1p Client Memory Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pClientMemoryOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected double l1pClientMemoryOverheadPercentage = L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pServerMemoryOverheadPercentage() <em>L1p Server Memory Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pServerMemoryOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE_EDEFAULT = -75.0;

	/**
	 * The cached value of the '{@link #getL1pServerMemoryOverheadPercentage() <em>L1p Server Memory Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pServerMemoryOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected double l1pServerMemoryOverheadPercentage = L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pNetworkOverheadPercentage() <em>L1p Network Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pNetworkOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_NETWORK_OVERHEAD_PERCENTAGE_EDEFAULT = -75.0;

	/**
	 * The cached value of the '{@link #getL1pNetworkOverheadPercentage() <em>L1p Network Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pNetworkOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected double l1pNetworkOverheadPercentage = L1P_NETWORK_OVERHEAD_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #isL1pDiscouragedPrecedencesIgnoration() <em>L1p Discouraged Precedences Ignoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pDiscouragedPrecedencesIgnoration()
	 * @generated
	 * @ordered
	 */
	protected static final boolean L1P_DISCOURAGED_PRECEDENCES_IGNORATION_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isL1pDiscouragedPrecedencesIgnoration() <em>L1p Discouraged Precedences Ignoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pDiscouragedPrecedencesIgnoration()
	 * @generated
	 * @ordered
	 */
	protected boolean l1pDiscouragedPrecedencesIgnoration = L1P_DISCOURAGED_PRECEDENCES_IGNORATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isL1pEncouragedPrecedencesFocusing() <em>L1p Encouraged Precedences Focusing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pEncouragedPrecedencesFocusing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean L1P_ENCOURAGED_PRECEDENCES_FOCUSING_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isL1pEncouragedPrecedencesFocusing() <em>L1p Encouraged Precedences Focusing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pEncouragedPrecedencesFocusing()
	 * @generated
	 * @ordered
	 */
	protected boolean l1pEncouragedPrecedencesFocusing = L1P_ENCOURAGED_PRECEDENCES_FOCUSING_EDEFAULT;

	/**
	 * The default value of the '{@link #isL1pUseACTCPrecedences() <em>L1p Use ACTC Precedences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pUseACTCPrecedences()
	 * @generated
	 * @ordered
	 */
	protected static final boolean L1P_USE_ACTC_PRECEDENCES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isL1pUseACTCPrecedences() <em>L1p Use ACTC Precedences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pUseACTCPrecedences()
	 * @generated
	 * @ordered
	 */
	protected boolean l1pUseACTCPrecedences = L1P_USE_ACTC_PRECEDENCES_EDEFAULT;

	/**
	 * The default value of the '{@link #isL1pIgnoreApplicationPartOrder() <em>L1p Ignore Application Part Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pIgnoreApplicationPartOrder()
	 * @generated
	 * @ordered
	 */
	protected static final boolean L1P_IGNORE_APPLICATION_PART_ORDER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isL1pIgnoreApplicationPartOrder() <em>L1p Ignore Application Part Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pIgnoreApplicationPartOrder()
	 * @generated
	 * @ordered
	 */
	protected boolean l1pIgnoreApplicationPartOrder = L1P_IGNORE_APPLICATION_PART_ORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pMaximumInstantiationsPerProtectionObjective() <em>L1p Maximum Instantiations Per Protection Objective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pMaximumInstantiationsPerProtectionObjective()
	 * @generated
	 * @ordered
	 */
	protected static final int L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE_EDEFAULT = 3;

	/**
	 * The cached value of the '{@link #getL1pMaximumInstantiationsPerProtectionObjective() <em>L1p Maximum Instantiations Per Protection Objective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pMaximumInstantiationsPerProtectionObjective()
	 * @generated
	 * @ordered
	 */
	protected int l1pMaximumInstantiationsPerProtectionObjective = L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pMainSearchMaximumDepth() <em>L1p Main Search Maximum Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pMainSearchMaximumDepth()
	 * @generated
	 * @ordered
	 */
	protected static final int L1P_MAIN_SEARCH_MAXIMUM_DEPTH_EDEFAULT = 3;

	/**
	 * The cached value of the '{@link #getL1pMainSearchMaximumDepth() <em>L1p Main Search Maximum Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pMainSearchMaximumDepth()
	 * @generated
	 * @ordered
	 */
	protected int l1pMainSearchMaximumDepth = L1P_MAIN_SEARCH_MAXIMUM_DEPTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pMultiTreeMultiplier() <em>L1p Multi Tree Multiplier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pMultiTreeMultiplier()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_MULTI_TREE_MULTIPLIER_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getL1pMultiTreeMultiplier() <em>L1p Multi Tree Multiplier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pMultiTreeMultiplier()
	 * @generated
	 * @ordered
	 */
	protected double l1pMultiTreeMultiplier = L1P_MULTI_TREE_MULTIPLIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pInitialAlpha() <em>L1p Initial Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pInitialAlpha()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_INITIAL_ALPHA_EDEFAULT = Double.NaN;

	/**
	 * The cached value of the '{@link #getL1pInitialAlpha() <em>L1p Initial Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pInitialAlpha()
	 * @generated
	 * @ordered
	 */
	protected double l1pInitialAlpha = L1P_INITIAL_ALPHA_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pInitialBeta() <em>L1p Initial Beta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pInitialBeta()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_INITIAL_BETA_EDEFAULT = Double.NaN;

	/**
	 * The cached value of the '{@link #getL1pInitialBeta() <em>L1p Initial Beta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pInitialBeta()
	 * @generated
	 * @ordered
	 */
	protected double l1pInitialBeta = L1P_INITIAL_BETA_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pResearchDelta() <em>L1p Research Delta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pResearchDelta()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_RESEARCH_DELTA_EDEFAULT = 5000.0;

	/**
	 * The cached value of the '{@link #getL1pResearchDelta() <em>L1p Research Delta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pResearchDelta()
	 * @generated
	 * @ordered
	 */
	protected double l1pResearchDelta = L1P_RESEARCH_DELTA_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pTranspositionTableMaximumSize() <em>L1p Transposition Table Maximum Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pTranspositionTableMaximumSize()
	 * @generated
	 * @ordered
	 */
	protected static final int L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE_EDEFAULT = 1000000;

	/**
	 * The cached value of the '{@link #getL1pTranspositionTableMaximumSize() <em>L1p Transposition Table Maximum Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pTranspositionTableMaximumSize()
	 * @generated
	 * @ordered
	 */
	protected int l1pTranspositionTableMaximumSize = L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pFutilityMargin() <em>L1p Futility Margin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pFutilityMargin()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_FUTILITY_MARGIN_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getL1pFutilityMargin() <em>L1p Futility Margin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pFutilityMargin()
	 * @generated
	 * @ordered
	 */
	protected double l1pFutilityMargin = L1P_FUTILITY_MARGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pExtendedFutilityMargin() <em>L1p Extended Futility Margin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pExtendedFutilityMargin()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_EXTENDED_FUTILITY_MARGIN_EDEFAULT = 2.0;

	/**
	 * The cached value of the '{@link #getL1pExtendedFutilityMargin() <em>L1p Extended Futility Margin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pExtendedFutilityMargin()
	 * @generated
	 * @ordered
	 */
	protected double l1pExtendedFutilityMargin = L1P_EXTENDED_FUTILITY_MARGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pRazoringMargin() <em>L1p Razoring Margin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pRazoringMargin()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_RAZORING_MARGIN_EDEFAULT = 4.0;

	/**
	 * The cached value of the '{@link #getL1pRazoringMargin() <em>L1p Razoring Margin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pRazoringMargin()
	 * @generated
	 * @ordered
	 */
	protected double l1pRazoringMargin = L1P_RAZORING_MARGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pSolutionsCount() <em>L2p Solutions Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pSolutionsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int L2P_SOLUTIONS_COUNT_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getL2pSolutionsCount() <em>L2p Solutions Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pSolutionsCount()
	 * @generated
	 * @ordered
	 */
	protected int l2pSolutionsCount = L2P_SOLUTIONS_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pFunctionSplittingSeed() <em>L2p Function Splitting Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pFunctionSplittingSeed()
	 * @generated
	 * @ordered
	 */
	protected static final int L2P_FUNCTION_SPLITTING_SEED_EDEFAULT = 1106103861;

	/**
	 * The cached value of the '{@link #getL2pFunctionSplittingSeed() <em>L2p Function Splitting Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pFunctionSplittingSeed()
	 * @generated
	 * @ordered
	 */
	protected int l2pFunctionSplittingSeed = L2P_FUNCTION_SPLITTING_SEED_EDEFAULT;

	/**
	 * The default value of the '{@link #isL2pStartFromL1pSolution() <em>L2p Start From L1p Solution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL2pStartFromL1pSolution()
	 * @generated
	 * @ordered
	 */
	protected static final boolean L2P_START_FROM_L1P_SOLUTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isL2pStartFromL1pSolution() <em>L2p Start From L1p Solution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL2pStartFromL1pSolution()
	 * @generated
	 * @ordered
	 */
	protected boolean l2pStartFromL1pSolution = L2P_START_FROM_L1P_SOLUTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pSolutionLimit() <em>L2p Solution Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pSolutionLimit()
	 * @generated
	 * @ordered
	 */
	protected static final int L2P_SOLUTION_LIMIT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getL2pSolutionLimit() <em>L2p Solution Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pSolutionLimit()
	 * @generated
	 * @ordered
	 */
	protected int l2pSolutionLimit = L2P_SOLUTION_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pTimeLimit() <em>L2p Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pTimeLimit()
	 * @generated
	 * @ordered
	 */
	protected static final int L2P_TIME_LIMIT_EDEFAULT = 60;

	/**
	 * The cached value of the '{@link #getL2pTimeLimit() <em>L2p Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pTimeLimit()
	 * @generated
	 * @ordered
	 */
	protected int l2pTimeLimit = L2P_TIME_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pGapLimit() <em>L2p Gap Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pGapLimit()
	 * @generated
	 * @ordered
	 */
	protected static final double L2P_GAP_LIMIT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getL2pGapLimit() <em>L2p Gap Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pGapLimit()
	 * @generated
	 * @ordered
	 */
	protected double l2pGapLimit = L2P_GAP_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pUpperBound() <em>L2p Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pUpperBound()
	 * @generated
	 * @ordered
	 */
	protected static final int L2P_UPPER_BOUND_EDEFAULT = 2;

	/**
	 * The cached value of the '{@link #getL2pUpperBound() <em>L2p Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pUpperBound()
	 * @generated
	 * @ordered
	 */
	protected int l2pUpperBound = L2P_UPPER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pFunctionSplittingMediumCodeBlockLength() <em>L2p Function Splitting Medium Code Block Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pFunctionSplittingMediumCodeBlockLength()
	 * @generated
	 * @ordered
	 */
	protected static final int L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH_EDEFAULT = 2;

	/**
	 * The cached value of the '{@link #getL2pFunctionSplittingMediumCodeBlockLength() <em>L2p Function Splitting Medium Code Block Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pFunctionSplittingMediumCodeBlockLength()
	 * @generated
	 * @ordered
	 */
	protected int l2pFunctionSplittingMediumCodeBlockLength = L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator() <em>L2p Function Splitting Code Block Length Randomization Denominator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator()
	 * @generated
	 * @ordered
	 */
	protected static final int L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR_EDEFAULT = 2;

	/**
	 * The cached value of the '{@link #getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator() <em>L2p Function Splitting Code Block Length Randomization Denominator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator()
	 * @generated
	 * @ordered
	 */
	protected int l2pFunctionSplittingCodeBlockLengthRandomizationDenominator = L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pFunctionSplittingDepthLevel() <em>L2p Function Splitting Depth Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pFunctionSplittingDepthLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int L2P_FUNCTION_SPLITTING_DEPTH_LEVEL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getL2pFunctionSplittingDepthLevel() <em>L2p Function Splitting Depth Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pFunctionSplittingDepthLevel()
	 * @generated
	 * @ordered
	 */
	protected int l2pFunctionSplittingDepthLevel = L2P_FUNCTION_SPLITTING_DEPTH_LEVEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreferencesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KbPackage.Literals.PREFERENCES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWorkingDirectory() {
		return workingDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWorkingDirectory(String newWorkingDirectory) {
		String oldWorkingDirectory = workingDirectory;
		workingDirectory = newWorkingDirectory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__WORKING_DIRECTORY, oldWorkingDirectory, workingDirectory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getActcConfigurationFile() {
		return actcConfigurationFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActcConfigurationFile(String newActcConfigurationFile) {
		String oldActcConfigurationFile = actcConfigurationFile;
		actcConfigurationFile = newActcConfigurationFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__ACTC_CONFIGURATION_FILE, oldActcConfigurationFile, actcConfigurationFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEspPatchFile() {
		return espPatchFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEspPatchFile(String newEspPatchFile) {
		String oldEspPatchFile = espPatchFile;
		espPatchFile = newEspPatchFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__ESP_PATCH_FILE, oldEspPatchFile, espPatchFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEspJSONFile() {
		return espJSONFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEspJSONFile(String newEspJSONFile) {
		String oldEspJSONFile = espJSONFile;
		espJSONFile = newEspJSONFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__ESP_JSON_FILE, oldEspJSONFile, espJSONFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getArchitecture() {
		return architecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArchitecture(String newArchitecture) {
		String oldArchitecture = architecture;
		architecture = newArchitecture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__ARCHITECTURE, oldArchitecture, architecture));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRemoteConnection() {
		return remoteConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRemoteConnection(boolean newRemoteConnection) {
		boolean oldRemoteConnection = remoteConnection;
		remoteConnection = newRemoteConnection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__REMOTE_CONNECTION, oldRemoteConnection, remoteConnection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRemoteUsername() {
		return remoteUsername;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRemoteUsername(String newRemoteUsername) {
		String oldRemoteUsername = remoteUsername;
		remoteUsername = newRemoteUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__REMOTE_USERNAME, oldRemoteUsername, remoteUsername));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRemotePassword() {
		return remotePassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRemotePassword(String newRemotePassword) {
		String oldRemotePassword = remotePassword;
		remotePassword = newRemotePassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__REMOTE_PASSWORD, oldRemotePassword, remotePassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRemoteHost() {
		return remoteHost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRemoteHost(String newRemoteHost) {
		String oldRemoteHost = remoteHost;
		remoteHost = newRemoteHost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__REMOTE_HOST, oldRemoteHost, remoteHost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getRemotePort() {
		return remotePort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRemotePort(int newRemotePort) {
		int oldRemotePort = remotePort;
		remotePort = newRemotePort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__REMOTE_PORT, oldRemotePort, remotePort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRemoteFileSeparator() {
		return remoteFileSeparator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRemoteFileSeparator(String newRemoteFileSeparator) {
		String oldRemoteFileSeparator = remoteFileSeparator;
		remoteFileSeparator = newRemoteFileSeparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__REMOTE_FILE_SEPARATOR, oldRemoteFileSeparator, remoteFileSeparator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCommandACTC() {
		return commandACTC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCommandACTC(String newCommandACTC) {
		String oldCommandACTC = commandACTC;
		commandACTC = newCommandACTC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__COMMAND_ACTC, oldCommandACTC, commandACTC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCommandTigress() {
		return commandTigress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCommandTigress(String newCommandTigress) {
		String oldCommandTigress = commandTigress;
		commandTigress = newCommandTigress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__COMMAND_TIGRESS, oldCommandTigress, commandTigress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCommandCilly() {
		return commandCilly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCommandCilly(String newCommandCilly) {
		String oldCommandCilly = commandCilly;
		commandCilly = newCommandCilly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__COMMAND_CILLY, oldCommandCilly, commandCilly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCommandPerl() {
		return commandPerl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCommandPerl(String newCommandPerl) {
		String oldCommandPerl = commandPerl;
		commandPerl = newCommandPerl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__COMMAND_PERL, oldCommandPerl, commandPerl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCommandDot() {
		return commandDot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCommandDot(String newCommandDot) {
		String oldCommandDot = commandDot;
		commandDot = newCommandDot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__COMMAND_DOT, oldCommandDot, commandDot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMetricsFile() {
		return metricsFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetricsFile(String newMetricsFile) {
		String oldMetricsFile = metricsFile;
		metricsFile = newMetricsFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__METRICS_FILE, oldMetricsFile, metricsFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMetricsTransformationDegree() {
		return metricsTransformationDegree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetricsTransformationDegree(int newMetricsTransformationDegree) {
		int oldMetricsTransformationDegree = metricsTransformationDegree;
		metricsTransformationDegree = newMetricsTransformationDegree;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__METRICS_TRANSFORMATION_DEGREE, oldMetricsTransformationDegree, metricsTransformationDegree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMetricsPseudoInverseSensitivity() {
		return metricsPseudoInverseSensitivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetricsPseudoInverseSensitivity(double newMetricsPseudoInverseSensitivity) {
		double oldMetricsPseudoInverseSensitivity = metricsPseudoInverseSensitivity;
		metricsPseudoInverseSensitivity = newMetricsPseudoInverseSensitivity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__METRICS_PSEUDO_INVERSE_SENSITIVITY, oldMetricsPseudoInverseSensitivity, metricsPseudoInverseSensitivity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMetricsDerivativeSensitivity() {
		return metricsDerivativeSensitivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetricsDerivativeSensitivity(double newMetricsDerivativeSensitivity) {
		double oldMetricsDerivativeSensitivity = metricsDerivativeSensitivity;
		metricsDerivativeSensitivity = newMetricsDerivativeSensitivity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__METRICS_DERIVATIVE_SENSITIVITY, oldMetricsDerivativeSensitivity, metricsDerivativeSensitivity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FitterType getMetricsFitter() {
		return metricsFitter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetricsFitter(FitterType newMetricsFitter) {
		FitterType oldMetricsFitter = metricsFitter;
		metricsFitter = newMetricsFitter == null ? METRICS_FITTER_EDEFAULT : newMetricsFitter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__METRICS_FITTER, oldMetricsFitter, metricsFitter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMetricsNonLinearMaximumIterations() {
		return metricsNonLinearMaximumIterations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetricsNonLinearMaximumIterations(int newMetricsNonLinearMaximumIterations) {
		int oldMetricsNonLinearMaximumIterations = metricsNonLinearMaximumIterations;
		metricsNonLinearMaximumIterations = newMetricsNonLinearMaximumIterations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__METRICS_NON_LINEAR_MAXIMUM_ITERATIONS, oldMetricsNonLinearMaximumIterations, metricsNonLinearMaximumIterations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMetricsNonLinearStepSize() {
		return metricsNonLinearStepSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetricsNonLinearStepSize(double newMetricsNonLinearStepSize) {
		double oldMetricsNonLinearStepSize = metricsNonLinearStepSize;
		metricsNonLinearStepSize = newMetricsNonLinearStepSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__METRICS_NON_LINEAR_STEP_SIZE, oldMetricsNonLinearStepSize, metricsNonLinearStepSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMetricsNonLinearMinimumError() {
		return metricsNonLinearMinimumError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetricsNonLinearMinimumError(double newMetricsNonLinearMinimumError) {
		double oldMetricsNonLinearMinimumError = metricsNonLinearMinimumError;
		metricsNonLinearMinimumError = newMetricsNonLinearMinimumError;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__METRICS_NON_LINEAR_MINIMUM_ERROR, oldMetricsNonLinearMinimumError, metricsNonLinearMinimumError));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMetricsNonLinearMinimumChange() {
		return metricsNonLinearMinimumChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetricsNonLinearMinimumChange(double newMetricsNonLinearMinimumChange) {
		double oldMetricsNonLinearMinimumChange = metricsNonLinearMinimumChange;
		metricsNonLinearMinimumChange = newMetricsNonLinearMinimumChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__METRICS_NON_LINEAR_MINIMUM_CHANGE, oldMetricsNonLinearMinimumChange, metricsNonLinearMinimumChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isParserHeaderParsing() {
		return parserHeaderParsing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParserHeaderParsing(boolean newParserHeaderParsing) {
		boolean oldParserHeaderParsing = parserHeaderParsing;
		parserHeaderParsing = newParserHeaderParsing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__PARSER_HEADER_PARSING, oldParserHeaderParsing, parserHeaderParsing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isParserSystemFilesIgnoration() {
		return parserSystemFilesIgnoration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParserSystemFilesIgnoration(boolean newParserSystemFilesIgnoration) {
		boolean oldParserSystemFilesIgnoration = parserSystemFilesIgnoration;
		parserSystemFilesIgnoration = newParserSystemFilesIgnoration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__PARSER_SYSTEM_FILES_IGNORATION, oldParserSystemFilesIgnoration, parserSystemFilesIgnoration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getAttacksTimeLimit() {
		return attacksTimeLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAttacksTimeLimit(int newAttacksTimeLimit) {
		int oldAttacksTimeLimit = attacksTimeLimit;
		attacksTimeLimit = newAttacksTimeLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__ATTACKS_TIME_LIMIT, oldAttacksTimeLimit, attacksTimeLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getAttacksMaximumDepth() {
		return attacksMaximumDepth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAttacksMaximumDepth(int newAttacksMaximumDepth) {
		int oldAttacksMaximumDepth = attacksMaximumDepth;
		attacksMaximumDepth = newAttacksMaximumDepth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__ATTACKS_MAXIMUM_DEPTH, oldAttacksMaximumDepth, attacksMaximumDepth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAttacksIncludedProtectionObjectivesRemoval() {
		return attacksIncludedProtectionObjectivesRemoval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAttacksIncludedProtectionObjectivesRemoval(boolean newAttacksIncludedProtectionObjectivesRemoval) {
		boolean oldAttacksIncludedProtectionObjectivesRemoval = attacksIncludedProtectionObjectivesRemoval;
		attacksIncludedProtectionObjectivesRemoval = newAttacksIncludedProtectionObjectivesRemoval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL, oldAttacksIncludedProtectionObjectivesRemoval, attacksIncludedProtectionObjectivesRemoval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Level getProtectionsMinimumAttackMitigation() {
		return protectionsMinimumAttackMitigation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProtectionsMinimumAttackMitigation(Level newProtectionsMinimumAttackMitigation) {
		Level oldProtectionsMinimumAttackMitigation = protectionsMinimumAttackMitigation;
		protectionsMinimumAttackMitigation = newProtectionsMinimumAttackMitigation == null ? PROTECTIONS_MINIMUM_ATTACK_MITIGATION_EDEFAULT : newProtectionsMinimumAttackMitigation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__PROTECTIONS_MINIMUM_ATTACK_MITIGATION, oldProtectionsMinimumAttackMitigation, protectionsMinimumAttackMitigation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMaxAttestatorsPerProtectionInstantiation() {
		return maxAttestatorsPerProtectionInstantiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxAttestatorsPerProtectionInstantiation(int newMaxAttestatorsPerProtectionInstantiation) {
		int oldMaxAttestatorsPerProtectionInstantiation = maxAttestatorsPerProtectionInstantiation;
		maxAttestatorsPerProtectionInstantiation = newMaxAttestatorsPerProtectionInstantiation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__MAX_ATTESTATORS_PER_PROTECTION_INSTANTIATION, oldMaxAttestatorsPerProtectionInstantiation, maxAttestatorsPerProtectionInstantiation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getClientTimeOverhead() {
		return clientTimeOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClientTimeOverhead(double newClientTimeOverhead) {
		double oldClientTimeOverhead = clientTimeOverhead;
		clientTimeOverhead = newClientTimeOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__CLIENT_TIME_OVERHEAD, oldClientTimeOverhead, clientTimeOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getServerTimeOverhead() {
		return serverTimeOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setServerTimeOverhead(double newServerTimeOverhead) {
		double oldServerTimeOverhead = serverTimeOverhead;
		serverTimeOverhead = newServerTimeOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__SERVER_TIME_OVERHEAD, oldServerTimeOverhead, serverTimeOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getClientMemoryOverhead() {
		return clientMemoryOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClientMemoryOverhead(int newClientMemoryOverhead) {
		int oldClientMemoryOverhead = clientMemoryOverhead;
		clientMemoryOverhead = newClientMemoryOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__CLIENT_MEMORY_OVERHEAD, oldClientMemoryOverhead, clientMemoryOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getServerMemoryOverhead() {
		return serverMemoryOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setServerMemoryOverhead(int newServerMemoryOverhead) {
		int oldServerMemoryOverhead = serverMemoryOverhead;
		serverMemoryOverhead = newServerMemoryOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__SERVER_MEMORY_OVERHEAD, oldServerMemoryOverhead, serverMemoryOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNetworkOverhead() {
		return networkOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNetworkOverhead(int newNetworkOverhead) {
		int oldNetworkOverhead = networkOverhead;
		networkOverhead = newNetworkOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__NETWORK_OVERHEAD, oldNetworkOverhead, networkOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getL1pSolutionsCount() {
		return l1pSolutionsCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pSolutionsCount(int newL1pSolutionsCount) {
		int oldL1pSolutionsCount = l1pSolutionsCount;
		l1pSolutionsCount = newL1pSolutionsCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_SOLUTIONS_COUNT, oldL1pSolutionsCount, l1pSolutionsCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getL1pTimeLimit() {
		return l1pTimeLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pTimeLimit(int newL1pTimeLimit) {
		int oldL1pTimeLimit = l1pTimeLimit;
		l1pTimeLimit = newL1pTimeLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_TIME_LIMIT, oldL1pTimeLimit, l1pTimeLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getL1pSolutionsLimit() {
		return l1pSolutionsLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pSolutionsLimit(int newL1pSolutionsLimit) {
		int oldL1pSolutionsLimit = l1pSolutionsLimit;
		l1pSolutionsLimit = newL1pSolutionsLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_SOLUTIONS_LIMIT, oldL1pSolutionsLimit, l1pSolutionsLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getL1pGapLimit() {
		return l1pGapLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pGapLimit(double newL1pGapLimit) {
		double oldL1pGapLimit = l1pGapLimit;
		l1pGapLimit = newL1pGapLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_GAP_LIMIT, oldL1pGapLimit, l1pGapLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getL1pClientTimeOverheadPercentage() {
		return l1pClientTimeOverheadPercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pClientTimeOverheadPercentage(double newL1pClientTimeOverheadPercentage) {
		double oldL1pClientTimeOverheadPercentage = l1pClientTimeOverheadPercentage;
		l1pClientTimeOverheadPercentage = newL1pClientTimeOverheadPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE, oldL1pClientTimeOverheadPercentage, l1pClientTimeOverheadPercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getL1pServerTimeOverheadPercentage() {
		return l1pServerTimeOverheadPercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pServerTimeOverheadPercentage(double newL1pServerTimeOverheadPercentage) {
		double oldL1pServerTimeOverheadPercentage = l1pServerTimeOverheadPercentage;
		l1pServerTimeOverheadPercentage = newL1pServerTimeOverheadPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_SERVER_TIME_OVERHEAD_PERCENTAGE, oldL1pServerTimeOverheadPercentage, l1pServerTimeOverheadPercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getL1pClientMemoryOverheadPercentage() {
		return l1pClientMemoryOverheadPercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pClientMemoryOverheadPercentage(double newL1pClientMemoryOverheadPercentage) {
		double oldL1pClientMemoryOverheadPercentage = l1pClientMemoryOverheadPercentage;
		l1pClientMemoryOverheadPercentage = newL1pClientMemoryOverheadPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE, oldL1pClientMemoryOverheadPercentage, l1pClientMemoryOverheadPercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getL1pServerMemoryOverheadPercentage() {
		return l1pServerMemoryOverheadPercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pServerMemoryOverheadPercentage(double newL1pServerMemoryOverheadPercentage) {
		double oldL1pServerMemoryOverheadPercentage = l1pServerMemoryOverheadPercentage;
		l1pServerMemoryOverheadPercentage = newL1pServerMemoryOverheadPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE, oldL1pServerMemoryOverheadPercentage, l1pServerMemoryOverheadPercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getL1pNetworkOverheadPercentage() {
		return l1pNetworkOverheadPercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pNetworkOverheadPercentage(double newL1pNetworkOverheadPercentage) {
		double oldL1pNetworkOverheadPercentage = l1pNetworkOverheadPercentage;
		l1pNetworkOverheadPercentage = newL1pNetworkOverheadPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_NETWORK_OVERHEAD_PERCENTAGE, oldL1pNetworkOverheadPercentage, l1pNetworkOverheadPercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isL1pDiscouragedPrecedencesIgnoration() {
		return l1pDiscouragedPrecedencesIgnoration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pDiscouragedPrecedencesIgnoration(boolean newL1pDiscouragedPrecedencesIgnoration) {
		boolean oldL1pDiscouragedPrecedencesIgnoration = l1pDiscouragedPrecedencesIgnoration;
		l1pDiscouragedPrecedencesIgnoration = newL1pDiscouragedPrecedencesIgnoration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_DISCOURAGED_PRECEDENCES_IGNORATION, oldL1pDiscouragedPrecedencesIgnoration, l1pDiscouragedPrecedencesIgnoration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isL1pEncouragedPrecedencesFocusing() {
		return l1pEncouragedPrecedencesFocusing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pEncouragedPrecedencesFocusing(boolean newL1pEncouragedPrecedencesFocusing) {
		boolean oldL1pEncouragedPrecedencesFocusing = l1pEncouragedPrecedencesFocusing;
		l1pEncouragedPrecedencesFocusing = newL1pEncouragedPrecedencesFocusing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_ENCOURAGED_PRECEDENCES_FOCUSING, oldL1pEncouragedPrecedencesFocusing, l1pEncouragedPrecedencesFocusing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isL1pUseACTCPrecedences() {
		return l1pUseACTCPrecedences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pUseACTCPrecedences(boolean newL1pUseACTCPrecedences) {
		boolean oldL1pUseACTCPrecedences = l1pUseACTCPrecedences;
		l1pUseACTCPrecedences = newL1pUseACTCPrecedences;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_USE_ACTC_PRECEDENCES, oldL1pUseACTCPrecedences, l1pUseACTCPrecedences));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isL1pIgnoreApplicationPartOrder() {
		return l1pIgnoreApplicationPartOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pIgnoreApplicationPartOrder(boolean newL1pIgnoreApplicationPartOrder) {
		boolean oldL1pIgnoreApplicationPartOrder = l1pIgnoreApplicationPartOrder;
		l1pIgnoreApplicationPartOrder = newL1pIgnoreApplicationPartOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_IGNORE_APPLICATION_PART_ORDER, oldL1pIgnoreApplicationPartOrder, l1pIgnoreApplicationPartOrder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getL1pMaximumInstantiationsPerProtectionObjective() {
		return l1pMaximumInstantiationsPerProtectionObjective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pMaximumInstantiationsPerProtectionObjective(int newL1pMaximumInstantiationsPerProtectionObjective) {
		int oldL1pMaximumInstantiationsPerProtectionObjective = l1pMaximumInstantiationsPerProtectionObjective;
		l1pMaximumInstantiationsPerProtectionObjective = newL1pMaximumInstantiationsPerProtectionObjective;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE, oldL1pMaximumInstantiationsPerProtectionObjective, l1pMaximumInstantiationsPerProtectionObjective));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getL1pMainSearchMaximumDepth() {
		return l1pMainSearchMaximumDepth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pMainSearchMaximumDepth(int newL1pMainSearchMaximumDepth) {
		int oldL1pMainSearchMaximumDepth = l1pMainSearchMaximumDepth;
		l1pMainSearchMaximumDepth = newL1pMainSearchMaximumDepth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_MAIN_SEARCH_MAXIMUM_DEPTH, oldL1pMainSearchMaximumDepth, l1pMainSearchMaximumDepth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getL1pMultiTreeMultiplier() {
		return l1pMultiTreeMultiplier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pMultiTreeMultiplier(double newL1pMultiTreeMultiplier) {
		double oldL1pMultiTreeMultiplier = l1pMultiTreeMultiplier;
		l1pMultiTreeMultiplier = newL1pMultiTreeMultiplier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_MULTI_TREE_MULTIPLIER, oldL1pMultiTreeMultiplier, l1pMultiTreeMultiplier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getL1pInitialAlpha() {
		return l1pInitialAlpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pInitialAlpha(double newL1pInitialAlpha) {
		double oldL1pInitialAlpha = l1pInitialAlpha;
		l1pInitialAlpha = newL1pInitialAlpha;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_INITIAL_ALPHA, oldL1pInitialAlpha, l1pInitialAlpha));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getL1pInitialBeta() {
		return l1pInitialBeta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pInitialBeta(double newL1pInitialBeta) {
		double oldL1pInitialBeta = l1pInitialBeta;
		l1pInitialBeta = newL1pInitialBeta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_INITIAL_BETA, oldL1pInitialBeta, l1pInitialBeta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getL1pResearchDelta() {
		return l1pResearchDelta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pResearchDelta(double newL1pResearchDelta) {
		double oldL1pResearchDelta = l1pResearchDelta;
		l1pResearchDelta = newL1pResearchDelta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_RESEARCH_DELTA, oldL1pResearchDelta, l1pResearchDelta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getL1pTranspositionTableMaximumSize() {
		return l1pTranspositionTableMaximumSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pTranspositionTableMaximumSize(int newL1pTranspositionTableMaximumSize) {
		int oldL1pTranspositionTableMaximumSize = l1pTranspositionTableMaximumSize;
		l1pTranspositionTableMaximumSize = newL1pTranspositionTableMaximumSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE, oldL1pTranspositionTableMaximumSize, l1pTranspositionTableMaximumSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getL1pFutilityMargin() {
		return l1pFutilityMargin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pFutilityMargin(double newL1pFutilityMargin) {
		double oldL1pFutilityMargin = l1pFutilityMargin;
		l1pFutilityMargin = newL1pFutilityMargin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_FUTILITY_MARGIN, oldL1pFutilityMargin, l1pFutilityMargin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getL1pExtendedFutilityMargin() {
		return l1pExtendedFutilityMargin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pExtendedFutilityMargin(double newL1pExtendedFutilityMargin) {
		double oldL1pExtendedFutilityMargin = l1pExtendedFutilityMargin;
		l1pExtendedFutilityMargin = newL1pExtendedFutilityMargin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_EXTENDED_FUTILITY_MARGIN, oldL1pExtendedFutilityMargin, l1pExtendedFutilityMargin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getL1pRazoringMargin() {
		return l1pRazoringMargin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL1pRazoringMargin(double newL1pRazoringMargin) {
		double oldL1pRazoringMargin = l1pRazoringMargin;
		l1pRazoringMargin = newL1pRazoringMargin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L1P_RAZORING_MARGIN, oldL1pRazoringMargin, l1pRazoringMargin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getL2pSolutionsCount() {
		return l2pSolutionsCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL2pSolutionsCount(int newL2pSolutionsCount) {
		int oldL2pSolutionsCount = l2pSolutionsCount;
		l2pSolutionsCount = newL2pSolutionsCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L2P_SOLUTIONS_COUNT, oldL2pSolutionsCount, l2pSolutionsCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getL2pFunctionSplittingSeed() {
		return l2pFunctionSplittingSeed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL2pFunctionSplittingSeed(int newL2pFunctionSplittingSeed) {
		int oldL2pFunctionSplittingSeed = l2pFunctionSplittingSeed;
		l2pFunctionSplittingSeed = newL2pFunctionSplittingSeed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_SEED, oldL2pFunctionSplittingSeed, l2pFunctionSplittingSeed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isL2pStartFromL1pSolution() {
		return l2pStartFromL1pSolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL2pStartFromL1pSolution(boolean newL2pStartFromL1pSolution) {
		boolean oldL2pStartFromL1pSolution = l2pStartFromL1pSolution;
		l2pStartFromL1pSolution = newL2pStartFromL1pSolution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L2P_START_FROM_L1P_SOLUTION, oldL2pStartFromL1pSolution, l2pStartFromL1pSolution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getL2pSolutionLimit() {
		return l2pSolutionLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL2pSolutionLimit(int newL2pSolutionLimit) {
		int oldL2pSolutionLimit = l2pSolutionLimit;
		l2pSolutionLimit = newL2pSolutionLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L2P_SOLUTION_LIMIT, oldL2pSolutionLimit, l2pSolutionLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getL2pTimeLimit() {
		return l2pTimeLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL2pTimeLimit(int newL2pTimeLimit) {
		int oldL2pTimeLimit = l2pTimeLimit;
		l2pTimeLimit = newL2pTimeLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L2P_TIME_LIMIT, oldL2pTimeLimit, l2pTimeLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getL2pGapLimit() {
		return l2pGapLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL2pGapLimit(double newL2pGapLimit) {
		double oldL2pGapLimit = l2pGapLimit;
		l2pGapLimit = newL2pGapLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L2P_GAP_LIMIT, oldL2pGapLimit, l2pGapLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getL2pUpperBound() {
		return l2pUpperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL2pUpperBound(int newL2pUpperBound) {
		int oldL2pUpperBound = l2pUpperBound;
		l2pUpperBound = newL2pUpperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L2P_UPPER_BOUND, oldL2pUpperBound, l2pUpperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getL2pFunctionSplittingMediumCodeBlockLength() {
		return l2pFunctionSplittingMediumCodeBlockLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL2pFunctionSplittingMediumCodeBlockLength(int newL2pFunctionSplittingMediumCodeBlockLength) {
		int oldL2pFunctionSplittingMediumCodeBlockLength = l2pFunctionSplittingMediumCodeBlockLength;
		l2pFunctionSplittingMediumCodeBlockLength = newL2pFunctionSplittingMediumCodeBlockLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH, oldL2pFunctionSplittingMediumCodeBlockLength, l2pFunctionSplittingMediumCodeBlockLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator() {
		return l2pFunctionSplittingCodeBlockLengthRandomizationDenominator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL2pFunctionSplittingCodeBlockLengthRandomizationDenominator(int newL2pFunctionSplittingCodeBlockLengthRandomizationDenominator) {
		int oldL2pFunctionSplittingCodeBlockLengthRandomizationDenominator = l2pFunctionSplittingCodeBlockLengthRandomizationDenominator;
		l2pFunctionSplittingCodeBlockLengthRandomizationDenominator = newL2pFunctionSplittingCodeBlockLengthRandomizationDenominator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR, oldL2pFunctionSplittingCodeBlockLengthRandomizationDenominator, l2pFunctionSplittingCodeBlockLengthRandomizationDenominator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getL2pFunctionSplittingDepthLevel() {
		return l2pFunctionSplittingDepthLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setL2pFunctionSplittingDepthLevel(int newL2pFunctionSplittingDepthLevel) {
		int oldL2pFunctionSplittingDepthLevel = l2pFunctionSplittingDepthLevel;
		l2pFunctionSplittingDepthLevel = newL2pFunctionSplittingDepthLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_DEPTH_LEVEL, oldL2pFunctionSplittingDepthLevel, l2pFunctionSplittingDepthLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int hashCode() {
		int result = 17;
		int _hashCode = "preferences".hashCode();
		int _plus = ((31 * result) + _hashCode);
		result = _plus;
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean equals(final Object object) {
		if ((object == null)) {
			return false;
		}
		else {
			if ((object instanceof Preferences)) {
				return (this == object);
			}
			else {
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KbPackage.PREFERENCES__WORKING_DIRECTORY:
				return getWorkingDirectory();
			case KbPackage.PREFERENCES__ACTC_CONFIGURATION_FILE:
				return getActcConfigurationFile();
			case KbPackage.PREFERENCES__ESP_PATCH_FILE:
				return getEspPatchFile();
			case KbPackage.PREFERENCES__ESP_JSON_FILE:
				return getEspJSONFile();
			case KbPackage.PREFERENCES__ARCHITECTURE:
				return getArchitecture();
			case KbPackage.PREFERENCES__REMOTE_CONNECTION:
				return isRemoteConnection();
			case KbPackage.PREFERENCES__REMOTE_USERNAME:
				return getRemoteUsername();
			case KbPackage.PREFERENCES__REMOTE_PASSWORD:
				return getRemotePassword();
			case KbPackage.PREFERENCES__REMOTE_HOST:
				return getRemoteHost();
			case KbPackage.PREFERENCES__REMOTE_PORT:
				return getRemotePort();
			case KbPackage.PREFERENCES__REMOTE_FILE_SEPARATOR:
				return getRemoteFileSeparator();
			case KbPackage.PREFERENCES__COMMAND_ACTC:
				return getCommandACTC();
			case KbPackage.PREFERENCES__COMMAND_TIGRESS:
				return getCommandTigress();
			case KbPackage.PREFERENCES__COMMAND_CILLY:
				return getCommandCilly();
			case KbPackage.PREFERENCES__COMMAND_PERL:
				return getCommandPerl();
			case KbPackage.PREFERENCES__COMMAND_DOT:
				return getCommandDot();
			case KbPackage.PREFERENCES__METRICS_FILE:
				return getMetricsFile();
			case KbPackage.PREFERENCES__METRICS_TRANSFORMATION_DEGREE:
				return getMetricsTransformationDegree();
			case KbPackage.PREFERENCES__METRICS_PSEUDO_INVERSE_SENSITIVITY:
				return getMetricsPseudoInverseSensitivity();
			case KbPackage.PREFERENCES__METRICS_DERIVATIVE_SENSITIVITY:
				return getMetricsDerivativeSensitivity();
			case KbPackage.PREFERENCES__METRICS_FITTER:
				return getMetricsFitter();
			case KbPackage.PREFERENCES__METRICS_NON_LINEAR_MAXIMUM_ITERATIONS:
				return getMetricsNonLinearMaximumIterations();
			case KbPackage.PREFERENCES__METRICS_NON_LINEAR_STEP_SIZE:
				return getMetricsNonLinearStepSize();
			case KbPackage.PREFERENCES__METRICS_NON_LINEAR_MINIMUM_ERROR:
				return getMetricsNonLinearMinimumError();
			case KbPackage.PREFERENCES__METRICS_NON_LINEAR_MINIMUM_CHANGE:
				return getMetricsNonLinearMinimumChange();
			case KbPackage.PREFERENCES__PARSER_HEADER_PARSING:
				return isParserHeaderParsing();
			case KbPackage.PREFERENCES__PARSER_SYSTEM_FILES_IGNORATION:
				return isParserSystemFilesIgnoration();
			case KbPackage.PREFERENCES__ATTACKS_TIME_LIMIT:
				return getAttacksTimeLimit();
			case KbPackage.PREFERENCES__ATTACKS_MAXIMUM_DEPTH:
				return getAttacksMaximumDepth();
			case KbPackage.PREFERENCES__ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL:
				return isAttacksIncludedProtectionObjectivesRemoval();
			case KbPackage.PREFERENCES__PROTECTIONS_MINIMUM_ATTACK_MITIGATION:
				return getProtectionsMinimumAttackMitigation();
			case KbPackage.PREFERENCES__MAX_ATTESTATORS_PER_PROTECTION_INSTANTIATION:
				return getMaxAttestatorsPerProtectionInstantiation();
			case KbPackage.PREFERENCES__CLIENT_TIME_OVERHEAD:
				return getClientTimeOverhead();
			case KbPackage.PREFERENCES__SERVER_TIME_OVERHEAD:
				return getServerTimeOverhead();
			case KbPackage.PREFERENCES__CLIENT_MEMORY_OVERHEAD:
				return getClientMemoryOverhead();
			case KbPackage.PREFERENCES__SERVER_MEMORY_OVERHEAD:
				return getServerMemoryOverhead();
			case KbPackage.PREFERENCES__NETWORK_OVERHEAD:
				return getNetworkOverhead();
			case KbPackage.PREFERENCES__L1P_SOLUTIONS_COUNT:
				return getL1pSolutionsCount();
			case KbPackage.PREFERENCES__L1P_TIME_LIMIT:
				return getL1pTimeLimit();
			case KbPackage.PREFERENCES__L1P_SOLUTIONS_LIMIT:
				return getL1pSolutionsLimit();
			case KbPackage.PREFERENCES__L1P_GAP_LIMIT:
				return getL1pGapLimit();
			case KbPackage.PREFERENCES__L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE:
				return getL1pClientTimeOverheadPercentage();
			case KbPackage.PREFERENCES__L1P_SERVER_TIME_OVERHEAD_PERCENTAGE:
				return getL1pServerTimeOverheadPercentage();
			case KbPackage.PREFERENCES__L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE:
				return getL1pClientMemoryOverheadPercentage();
			case KbPackage.PREFERENCES__L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE:
				return getL1pServerMemoryOverheadPercentage();
			case KbPackage.PREFERENCES__L1P_NETWORK_OVERHEAD_PERCENTAGE:
				return getL1pNetworkOverheadPercentage();
			case KbPackage.PREFERENCES__L1P_DISCOURAGED_PRECEDENCES_IGNORATION:
				return isL1pDiscouragedPrecedencesIgnoration();
			case KbPackage.PREFERENCES__L1P_ENCOURAGED_PRECEDENCES_FOCUSING:
				return isL1pEncouragedPrecedencesFocusing();
			case KbPackage.PREFERENCES__L1P_USE_ACTC_PRECEDENCES:
				return isL1pUseACTCPrecedences();
			case KbPackage.PREFERENCES__L1P_IGNORE_APPLICATION_PART_ORDER:
				return isL1pIgnoreApplicationPartOrder();
			case KbPackage.PREFERENCES__L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE:
				return getL1pMaximumInstantiationsPerProtectionObjective();
			case KbPackage.PREFERENCES__L1P_MAIN_SEARCH_MAXIMUM_DEPTH:
				return getL1pMainSearchMaximumDepth();
			case KbPackage.PREFERENCES__L1P_MULTI_TREE_MULTIPLIER:
				return getL1pMultiTreeMultiplier();
			case KbPackage.PREFERENCES__L1P_INITIAL_ALPHA:
				return getL1pInitialAlpha();
			case KbPackage.PREFERENCES__L1P_INITIAL_BETA:
				return getL1pInitialBeta();
			case KbPackage.PREFERENCES__L1P_RESEARCH_DELTA:
				return getL1pResearchDelta();
			case KbPackage.PREFERENCES__L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE:
				return getL1pTranspositionTableMaximumSize();
			case KbPackage.PREFERENCES__L1P_FUTILITY_MARGIN:
				return getL1pFutilityMargin();
			case KbPackage.PREFERENCES__L1P_EXTENDED_FUTILITY_MARGIN:
				return getL1pExtendedFutilityMargin();
			case KbPackage.PREFERENCES__L1P_RAZORING_MARGIN:
				return getL1pRazoringMargin();
			case KbPackage.PREFERENCES__L2P_SOLUTIONS_COUNT:
				return getL2pSolutionsCount();
			case KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_SEED:
				return getL2pFunctionSplittingSeed();
			case KbPackage.PREFERENCES__L2P_START_FROM_L1P_SOLUTION:
				return isL2pStartFromL1pSolution();
			case KbPackage.PREFERENCES__L2P_SOLUTION_LIMIT:
				return getL2pSolutionLimit();
			case KbPackage.PREFERENCES__L2P_TIME_LIMIT:
				return getL2pTimeLimit();
			case KbPackage.PREFERENCES__L2P_GAP_LIMIT:
				return getL2pGapLimit();
			case KbPackage.PREFERENCES__L2P_UPPER_BOUND:
				return getL2pUpperBound();
			case KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH:
				return getL2pFunctionSplittingMediumCodeBlockLength();
			case KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR:
				return getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator();
			case KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_DEPTH_LEVEL:
				return getL2pFunctionSplittingDepthLevel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KbPackage.PREFERENCES__WORKING_DIRECTORY:
				setWorkingDirectory((String)newValue);
				return;
			case KbPackage.PREFERENCES__ACTC_CONFIGURATION_FILE:
				setActcConfigurationFile((String)newValue);
				return;
			case KbPackage.PREFERENCES__ESP_PATCH_FILE:
				setEspPatchFile((String)newValue);
				return;
			case KbPackage.PREFERENCES__ESP_JSON_FILE:
				setEspJSONFile((String)newValue);
				return;
			case KbPackage.PREFERENCES__ARCHITECTURE:
				setArchitecture((String)newValue);
				return;
			case KbPackage.PREFERENCES__REMOTE_CONNECTION:
				setRemoteConnection((Boolean)newValue);
				return;
			case KbPackage.PREFERENCES__REMOTE_USERNAME:
				setRemoteUsername((String)newValue);
				return;
			case KbPackage.PREFERENCES__REMOTE_PASSWORD:
				setRemotePassword((String)newValue);
				return;
			case KbPackage.PREFERENCES__REMOTE_HOST:
				setRemoteHost((String)newValue);
				return;
			case KbPackage.PREFERENCES__REMOTE_PORT:
				setRemotePort((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__REMOTE_FILE_SEPARATOR:
				setRemoteFileSeparator((String)newValue);
				return;
			case KbPackage.PREFERENCES__COMMAND_ACTC:
				setCommandACTC((String)newValue);
				return;
			case KbPackage.PREFERENCES__COMMAND_TIGRESS:
				setCommandTigress((String)newValue);
				return;
			case KbPackage.PREFERENCES__COMMAND_CILLY:
				setCommandCilly((String)newValue);
				return;
			case KbPackage.PREFERENCES__COMMAND_PERL:
				setCommandPerl((String)newValue);
				return;
			case KbPackage.PREFERENCES__COMMAND_DOT:
				setCommandDot((String)newValue);
				return;
			case KbPackage.PREFERENCES__METRICS_FILE:
				setMetricsFile((String)newValue);
				return;
			case KbPackage.PREFERENCES__METRICS_TRANSFORMATION_DEGREE:
				setMetricsTransformationDegree((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__METRICS_PSEUDO_INVERSE_SENSITIVITY:
				setMetricsPseudoInverseSensitivity((Double)newValue);
				return;
			case KbPackage.PREFERENCES__METRICS_DERIVATIVE_SENSITIVITY:
				setMetricsDerivativeSensitivity((Double)newValue);
				return;
			case KbPackage.PREFERENCES__METRICS_FITTER:
				setMetricsFitter((FitterType)newValue);
				return;
			case KbPackage.PREFERENCES__METRICS_NON_LINEAR_MAXIMUM_ITERATIONS:
				setMetricsNonLinearMaximumIterations((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__METRICS_NON_LINEAR_STEP_SIZE:
				setMetricsNonLinearStepSize((Double)newValue);
				return;
			case KbPackage.PREFERENCES__METRICS_NON_LINEAR_MINIMUM_ERROR:
				setMetricsNonLinearMinimumError((Double)newValue);
				return;
			case KbPackage.PREFERENCES__METRICS_NON_LINEAR_MINIMUM_CHANGE:
				setMetricsNonLinearMinimumChange((Double)newValue);
				return;
			case KbPackage.PREFERENCES__PARSER_HEADER_PARSING:
				setParserHeaderParsing((Boolean)newValue);
				return;
			case KbPackage.PREFERENCES__PARSER_SYSTEM_FILES_IGNORATION:
				setParserSystemFilesIgnoration((Boolean)newValue);
				return;
			case KbPackage.PREFERENCES__ATTACKS_TIME_LIMIT:
				setAttacksTimeLimit((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__ATTACKS_MAXIMUM_DEPTH:
				setAttacksMaximumDepth((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL:
				setAttacksIncludedProtectionObjectivesRemoval((Boolean)newValue);
				return;
			case KbPackage.PREFERENCES__PROTECTIONS_MINIMUM_ATTACK_MITIGATION:
				setProtectionsMinimumAttackMitigation((Level)newValue);
				return;
			case KbPackage.PREFERENCES__MAX_ATTESTATORS_PER_PROTECTION_INSTANTIATION:
				setMaxAttestatorsPerProtectionInstantiation((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__CLIENT_TIME_OVERHEAD:
				setClientTimeOverhead((Double)newValue);
				return;
			case KbPackage.PREFERENCES__SERVER_TIME_OVERHEAD:
				setServerTimeOverhead((Double)newValue);
				return;
			case KbPackage.PREFERENCES__CLIENT_MEMORY_OVERHEAD:
				setClientMemoryOverhead((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__SERVER_MEMORY_OVERHEAD:
				setServerMemoryOverhead((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__NETWORK_OVERHEAD:
				setNetworkOverhead((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_SOLUTIONS_COUNT:
				setL1pSolutionsCount((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_TIME_LIMIT:
				setL1pTimeLimit((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_SOLUTIONS_LIMIT:
				setL1pSolutionsLimit((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_GAP_LIMIT:
				setL1pGapLimit((Double)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE:
				setL1pClientTimeOverheadPercentage((Double)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_SERVER_TIME_OVERHEAD_PERCENTAGE:
				setL1pServerTimeOverheadPercentage((Double)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE:
				setL1pClientMemoryOverheadPercentage((Double)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE:
				setL1pServerMemoryOverheadPercentage((Double)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_NETWORK_OVERHEAD_PERCENTAGE:
				setL1pNetworkOverheadPercentage((Double)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_DISCOURAGED_PRECEDENCES_IGNORATION:
				setL1pDiscouragedPrecedencesIgnoration((Boolean)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_ENCOURAGED_PRECEDENCES_FOCUSING:
				setL1pEncouragedPrecedencesFocusing((Boolean)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_USE_ACTC_PRECEDENCES:
				setL1pUseACTCPrecedences((Boolean)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_IGNORE_APPLICATION_PART_ORDER:
				setL1pIgnoreApplicationPartOrder((Boolean)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE:
				setL1pMaximumInstantiationsPerProtectionObjective((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_MAIN_SEARCH_MAXIMUM_DEPTH:
				setL1pMainSearchMaximumDepth((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_MULTI_TREE_MULTIPLIER:
				setL1pMultiTreeMultiplier((Double)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_INITIAL_ALPHA:
				setL1pInitialAlpha((Double)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_INITIAL_BETA:
				setL1pInitialBeta((Double)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_RESEARCH_DELTA:
				setL1pResearchDelta((Double)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE:
				setL1pTranspositionTableMaximumSize((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_FUTILITY_MARGIN:
				setL1pFutilityMargin((Double)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_EXTENDED_FUTILITY_MARGIN:
				setL1pExtendedFutilityMargin((Double)newValue);
				return;
			case KbPackage.PREFERENCES__L1P_RAZORING_MARGIN:
				setL1pRazoringMargin((Double)newValue);
				return;
			case KbPackage.PREFERENCES__L2P_SOLUTIONS_COUNT:
				setL2pSolutionsCount((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_SEED:
				setL2pFunctionSplittingSeed((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__L2P_START_FROM_L1P_SOLUTION:
				setL2pStartFromL1pSolution((Boolean)newValue);
				return;
			case KbPackage.PREFERENCES__L2P_SOLUTION_LIMIT:
				setL2pSolutionLimit((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__L2P_TIME_LIMIT:
				setL2pTimeLimit((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__L2P_GAP_LIMIT:
				setL2pGapLimit((Double)newValue);
				return;
			case KbPackage.PREFERENCES__L2P_UPPER_BOUND:
				setL2pUpperBound((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH:
				setL2pFunctionSplittingMediumCodeBlockLength((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR:
				setL2pFunctionSplittingCodeBlockLengthRandomizationDenominator((Integer)newValue);
				return;
			case KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_DEPTH_LEVEL:
				setL2pFunctionSplittingDepthLevel((Integer)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case KbPackage.PREFERENCES__WORKING_DIRECTORY:
				setWorkingDirectory(WORKING_DIRECTORY_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__ACTC_CONFIGURATION_FILE:
				setActcConfigurationFile(ACTC_CONFIGURATION_FILE_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__ESP_PATCH_FILE:
				setEspPatchFile(ESP_PATCH_FILE_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__ESP_JSON_FILE:
				setEspJSONFile(ESP_JSON_FILE_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__ARCHITECTURE:
				setArchitecture(ARCHITECTURE_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__REMOTE_CONNECTION:
				setRemoteConnection(REMOTE_CONNECTION_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__REMOTE_USERNAME:
				setRemoteUsername(REMOTE_USERNAME_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__REMOTE_PASSWORD:
				setRemotePassword(REMOTE_PASSWORD_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__REMOTE_HOST:
				setRemoteHost(REMOTE_HOST_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__REMOTE_PORT:
				setRemotePort(REMOTE_PORT_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__REMOTE_FILE_SEPARATOR:
				setRemoteFileSeparator(REMOTE_FILE_SEPARATOR_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__COMMAND_ACTC:
				setCommandACTC(COMMAND_ACTC_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__COMMAND_TIGRESS:
				setCommandTigress(COMMAND_TIGRESS_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__COMMAND_CILLY:
				setCommandCilly(COMMAND_CILLY_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__COMMAND_PERL:
				setCommandPerl(COMMAND_PERL_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__COMMAND_DOT:
				setCommandDot(COMMAND_DOT_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__METRICS_FILE:
				setMetricsFile(METRICS_FILE_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__METRICS_TRANSFORMATION_DEGREE:
				setMetricsTransformationDegree(METRICS_TRANSFORMATION_DEGREE_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__METRICS_PSEUDO_INVERSE_SENSITIVITY:
				setMetricsPseudoInverseSensitivity(METRICS_PSEUDO_INVERSE_SENSITIVITY_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__METRICS_DERIVATIVE_SENSITIVITY:
				setMetricsDerivativeSensitivity(METRICS_DERIVATIVE_SENSITIVITY_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__METRICS_FITTER:
				setMetricsFitter(METRICS_FITTER_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__METRICS_NON_LINEAR_MAXIMUM_ITERATIONS:
				setMetricsNonLinearMaximumIterations(METRICS_NON_LINEAR_MAXIMUM_ITERATIONS_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__METRICS_NON_LINEAR_STEP_SIZE:
				setMetricsNonLinearStepSize(METRICS_NON_LINEAR_STEP_SIZE_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__METRICS_NON_LINEAR_MINIMUM_ERROR:
				setMetricsNonLinearMinimumError(METRICS_NON_LINEAR_MINIMUM_ERROR_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__METRICS_NON_LINEAR_MINIMUM_CHANGE:
				setMetricsNonLinearMinimumChange(METRICS_NON_LINEAR_MINIMUM_CHANGE_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__PARSER_HEADER_PARSING:
				setParserHeaderParsing(PARSER_HEADER_PARSING_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__PARSER_SYSTEM_FILES_IGNORATION:
				setParserSystemFilesIgnoration(PARSER_SYSTEM_FILES_IGNORATION_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__ATTACKS_TIME_LIMIT:
				setAttacksTimeLimit(ATTACKS_TIME_LIMIT_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__ATTACKS_MAXIMUM_DEPTH:
				setAttacksMaximumDepth(ATTACKS_MAXIMUM_DEPTH_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL:
				setAttacksIncludedProtectionObjectivesRemoval(ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__PROTECTIONS_MINIMUM_ATTACK_MITIGATION:
				setProtectionsMinimumAttackMitigation(PROTECTIONS_MINIMUM_ATTACK_MITIGATION_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__MAX_ATTESTATORS_PER_PROTECTION_INSTANTIATION:
				setMaxAttestatorsPerProtectionInstantiation(MAX_ATTESTATORS_PER_PROTECTION_INSTANTIATION_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__CLIENT_TIME_OVERHEAD:
				setClientTimeOverhead(CLIENT_TIME_OVERHEAD_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__SERVER_TIME_OVERHEAD:
				setServerTimeOverhead(SERVER_TIME_OVERHEAD_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__CLIENT_MEMORY_OVERHEAD:
				setClientMemoryOverhead(CLIENT_MEMORY_OVERHEAD_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__SERVER_MEMORY_OVERHEAD:
				setServerMemoryOverhead(SERVER_MEMORY_OVERHEAD_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__NETWORK_OVERHEAD:
				setNetworkOverhead(NETWORK_OVERHEAD_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_SOLUTIONS_COUNT:
				setL1pSolutionsCount(L1P_SOLUTIONS_COUNT_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_TIME_LIMIT:
				setL1pTimeLimit(L1P_TIME_LIMIT_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_SOLUTIONS_LIMIT:
				setL1pSolutionsLimit(L1P_SOLUTIONS_LIMIT_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_GAP_LIMIT:
				setL1pGapLimit(L1P_GAP_LIMIT_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE:
				setL1pClientTimeOverheadPercentage(L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_SERVER_TIME_OVERHEAD_PERCENTAGE:
				setL1pServerTimeOverheadPercentage(L1P_SERVER_TIME_OVERHEAD_PERCENTAGE_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE:
				setL1pClientMemoryOverheadPercentage(L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE:
				setL1pServerMemoryOverheadPercentage(L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_NETWORK_OVERHEAD_PERCENTAGE:
				setL1pNetworkOverheadPercentage(L1P_NETWORK_OVERHEAD_PERCENTAGE_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_DISCOURAGED_PRECEDENCES_IGNORATION:
				setL1pDiscouragedPrecedencesIgnoration(L1P_DISCOURAGED_PRECEDENCES_IGNORATION_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_ENCOURAGED_PRECEDENCES_FOCUSING:
				setL1pEncouragedPrecedencesFocusing(L1P_ENCOURAGED_PRECEDENCES_FOCUSING_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_USE_ACTC_PRECEDENCES:
				setL1pUseACTCPrecedences(L1P_USE_ACTC_PRECEDENCES_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_IGNORE_APPLICATION_PART_ORDER:
				setL1pIgnoreApplicationPartOrder(L1P_IGNORE_APPLICATION_PART_ORDER_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE:
				setL1pMaximumInstantiationsPerProtectionObjective(L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_MAIN_SEARCH_MAXIMUM_DEPTH:
				setL1pMainSearchMaximumDepth(L1P_MAIN_SEARCH_MAXIMUM_DEPTH_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_MULTI_TREE_MULTIPLIER:
				setL1pMultiTreeMultiplier(L1P_MULTI_TREE_MULTIPLIER_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_INITIAL_ALPHA:
				setL1pInitialAlpha(L1P_INITIAL_ALPHA_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_INITIAL_BETA:
				setL1pInitialBeta(L1P_INITIAL_BETA_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_RESEARCH_DELTA:
				setL1pResearchDelta(L1P_RESEARCH_DELTA_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE:
				setL1pTranspositionTableMaximumSize(L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_FUTILITY_MARGIN:
				setL1pFutilityMargin(L1P_FUTILITY_MARGIN_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_EXTENDED_FUTILITY_MARGIN:
				setL1pExtendedFutilityMargin(L1P_EXTENDED_FUTILITY_MARGIN_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L1P_RAZORING_MARGIN:
				setL1pRazoringMargin(L1P_RAZORING_MARGIN_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L2P_SOLUTIONS_COUNT:
				setL2pSolutionsCount(L2P_SOLUTIONS_COUNT_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_SEED:
				setL2pFunctionSplittingSeed(L2P_FUNCTION_SPLITTING_SEED_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L2P_START_FROM_L1P_SOLUTION:
				setL2pStartFromL1pSolution(L2P_START_FROM_L1P_SOLUTION_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L2P_SOLUTION_LIMIT:
				setL2pSolutionLimit(L2P_SOLUTION_LIMIT_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L2P_TIME_LIMIT:
				setL2pTimeLimit(L2P_TIME_LIMIT_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L2P_GAP_LIMIT:
				setL2pGapLimit(L2P_GAP_LIMIT_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L2P_UPPER_BOUND:
				setL2pUpperBound(L2P_UPPER_BOUND_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH:
				setL2pFunctionSplittingMediumCodeBlockLength(L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR:
				setL2pFunctionSplittingCodeBlockLengthRandomizationDenominator(L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR_EDEFAULT);
				return;
			case KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_DEPTH_LEVEL:
				setL2pFunctionSplittingDepthLevel(L2P_FUNCTION_SPLITTING_DEPTH_LEVEL_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KbPackage.PREFERENCES__WORKING_DIRECTORY:
				return WORKING_DIRECTORY_EDEFAULT == null ? workingDirectory != null : !WORKING_DIRECTORY_EDEFAULT.equals(workingDirectory);
			case KbPackage.PREFERENCES__ACTC_CONFIGURATION_FILE:
				return ACTC_CONFIGURATION_FILE_EDEFAULT == null ? actcConfigurationFile != null : !ACTC_CONFIGURATION_FILE_EDEFAULT.equals(actcConfigurationFile);
			case KbPackage.PREFERENCES__ESP_PATCH_FILE:
				return ESP_PATCH_FILE_EDEFAULT == null ? espPatchFile != null : !ESP_PATCH_FILE_EDEFAULT.equals(espPatchFile);
			case KbPackage.PREFERENCES__ESP_JSON_FILE:
				return ESP_JSON_FILE_EDEFAULT == null ? espJSONFile != null : !ESP_JSON_FILE_EDEFAULT.equals(espJSONFile);
			case KbPackage.PREFERENCES__ARCHITECTURE:
				return ARCHITECTURE_EDEFAULT == null ? architecture != null : !ARCHITECTURE_EDEFAULT.equals(architecture);
			case KbPackage.PREFERENCES__REMOTE_CONNECTION:
				return remoteConnection != REMOTE_CONNECTION_EDEFAULT;
			case KbPackage.PREFERENCES__REMOTE_USERNAME:
				return REMOTE_USERNAME_EDEFAULT == null ? remoteUsername != null : !REMOTE_USERNAME_EDEFAULT.equals(remoteUsername);
			case KbPackage.PREFERENCES__REMOTE_PASSWORD:
				return REMOTE_PASSWORD_EDEFAULT == null ? remotePassword != null : !REMOTE_PASSWORD_EDEFAULT.equals(remotePassword);
			case KbPackage.PREFERENCES__REMOTE_HOST:
				return REMOTE_HOST_EDEFAULT == null ? remoteHost != null : !REMOTE_HOST_EDEFAULT.equals(remoteHost);
			case KbPackage.PREFERENCES__REMOTE_PORT:
				return remotePort != REMOTE_PORT_EDEFAULT;
			case KbPackage.PREFERENCES__REMOTE_FILE_SEPARATOR:
				return REMOTE_FILE_SEPARATOR_EDEFAULT == null ? remoteFileSeparator != null : !REMOTE_FILE_SEPARATOR_EDEFAULT.equals(remoteFileSeparator);
			case KbPackage.PREFERENCES__COMMAND_ACTC:
				return COMMAND_ACTC_EDEFAULT == null ? commandACTC != null : !COMMAND_ACTC_EDEFAULT.equals(commandACTC);
			case KbPackage.PREFERENCES__COMMAND_TIGRESS:
				return COMMAND_TIGRESS_EDEFAULT == null ? commandTigress != null : !COMMAND_TIGRESS_EDEFAULT.equals(commandTigress);
			case KbPackage.PREFERENCES__COMMAND_CILLY:
				return COMMAND_CILLY_EDEFAULT == null ? commandCilly != null : !COMMAND_CILLY_EDEFAULT.equals(commandCilly);
			case KbPackage.PREFERENCES__COMMAND_PERL:
				return COMMAND_PERL_EDEFAULT == null ? commandPerl != null : !COMMAND_PERL_EDEFAULT.equals(commandPerl);
			case KbPackage.PREFERENCES__COMMAND_DOT:
				return COMMAND_DOT_EDEFAULT == null ? commandDot != null : !COMMAND_DOT_EDEFAULT.equals(commandDot);
			case KbPackage.PREFERENCES__METRICS_FILE:
				return METRICS_FILE_EDEFAULT == null ? metricsFile != null : !METRICS_FILE_EDEFAULT.equals(metricsFile);
			case KbPackage.PREFERENCES__METRICS_TRANSFORMATION_DEGREE:
				return metricsTransformationDegree != METRICS_TRANSFORMATION_DEGREE_EDEFAULT;
			case KbPackage.PREFERENCES__METRICS_PSEUDO_INVERSE_SENSITIVITY:
				return metricsPseudoInverseSensitivity != METRICS_PSEUDO_INVERSE_SENSITIVITY_EDEFAULT;
			case KbPackage.PREFERENCES__METRICS_DERIVATIVE_SENSITIVITY:
				return metricsDerivativeSensitivity != METRICS_DERIVATIVE_SENSITIVITY_EDEFAULT;
			case KbPackage.PREFERENCES__METRICS_FITTER:
				return metricsFitter != METRICS_FITTER_EDEFAULT;
			case KbPackage.PREFERENCES__METRICS_NON_LINEAR_MAXIMUM_ITERATIONS:
				return metricsNonLinearMaximumIterations != METRICS_NON_LINEAR_MAXIMUM_ITERATIONS_EDEFAULT;
			case KbPackage.PREFERENCES__METRICS_NON_LINEAR_STEP_SIZE:
				return metricsNonLinearStepSize != METRICS_NON_LINEAR_STEP_SIZE_EDEFAULT;
			case KbPackage.PREFERENCES__METRICS_NON_LINEAR_MINIMUM_ERROR:
				return metricsNonLinearMinimumError != METRICS_NON_LINEAR_MINIMUM_ERROR_EDEFAULT;
			case KbPackage.PREFERENCES__METRICS_NON_LINEAR_MINIMUM_CHANGE:
				return metricsNonLinearMinimumChange != METRICS_NON_LINEAR_MINIMUM_CHANGE_EDEFAULT;
			case KbPackage.PREFERENCES__PARSER_HEADER_PARSING:
				return parserHeaderParsing != PARSER_HEADER_PARSING_EDEFAULT;
			case KbPackage.PREFERENCES__PARSER_SYSTEM_FILES_IGNORATION:
				return parserSystemFilesIgnoration != PARSER_SYSTEM_FILES_IGNORATION_EDEFAULT;
			case KbPackage.PREFERENCES__ATTACKS_TIME_LIMIT:
				return attacksTimeLimit != ATTACKS_TIME_LIMIT_EDEFAULT;
			case KbPackage.PREFERENCES__ATTACKS_MAXIMUM_DEPTH:
				return attacksMaximumDepth != ATTACKS_MAXIMUM_DEPTH_EDEFAULT;
			case KbPackage.PREFERENCES__ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL:
				return attacksIncludedProtectionObjectivesRemoval != ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL_EDEFAULT;
			case KbPackage.PREFERENCES__PROTECTIONS_MINIMUM_ATTACK_MITIGATION:
				return protectionsMinimumAttackMitigation != PROTECTIONS_MINIMUM_ATTACK_MITIGATION_EDEFAULT;
			case KbPackage.PREFERENCES__MAX_ATTESTATORS_PER_PROTECTION_INSTANTIATION:
				return maxAttestatorsPerProtectionInstantiation != MAX_ATTESTATORS_PER_PROTECTION_INSTANTIATION_EDEFAULT;
			case KbPackage.PREFERENCES__CLIENT_TIME_OVERHEAD:
				return clientTimeOverhead != CLIENT_TIME_OVERHEAD_EDEFAULT;
			case KbPackage.PREFERENCES__SERVER_TIME_OVERHEAD:
				return serverTimeOverhead != SERVER_TIME_OVERHEAD_EDEFAULT;
			case KbPackage.PREFERENCES__CLIENT_MEMORY_OVERHEAD:
				return clientMemoryOverhead != CLIENT_MEMORY_OVERHEAD_EDEFAULT;
			case KbPackage.PREFERENCES__SERVER_MEMORY_OVERHEAD:
				return serverMemoryOverhead != SERVER_MEMORY_OVERHEAD_EDEFAULT;
			case KbPackage.PREFERENCES__NETWORK_OVERHEAD:
				return networkOverhead != NETWORK_OVERHEAD_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_SOLUTIONS_COUNT:
				return l1pSolutionsCount != L1P_SOLUTIONS_COUNT_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_TIME_LIMIT:
				return l1pTimeLimit != L1P_TIME_LIMIT_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_SOLUTIONS_LIMIT:
				return l1pSolutionsLimit != L1P_SOLUTIONS_LIMIT_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_GAP_LIMIT:
				return l1pGapLimit != L1P_GAP_LIMIT_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE:
				return l1pClientTimeOverheadPercentage != L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_SERVER_TIME_OVERHEAD_PERCENTAGE:
				return l1pServerTimeOverheadPercentage != L1P_SERVER_TIME_OVERHEAD_PERCENTAGE_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE:
				return l1pClientMemoryOverheadPercentage != L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE:
				return l1pServerMemoryOverheadPercentage != L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_NETWORK_OVERHEAD_PERCENTAGE:
				return l1pNetworkOverheadPercentage != L1P_NETWORK_OVERHEAD_PERCENTAGE_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_DISCOURAGED_PRECEDENCES_IGNORATION:
				return l1pDiscouragedPrecedencesIgnoration != L1P_DISCOURAGED_PRECEDENCES_IGNORATION_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_ENCOURAGED_PRECEDENCES_FOCUSING:
				return l1pEncouragedPrecedencesFocusing != L1P_ENCOURAGED_PRECEDENCES_FOCUSING_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_USE_ACTC_PRECEDENCES:
				return l1pUseACTCPrecedences != L1P_USE_ACTC_PRECEDENCES_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_IGNORE_APPLICATION_PART_ORDER:
				return l1pIgnoreApplicationPartOrder != L1P_IGNORE_APPLICATION_PART_ORDER_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE:
				return l1pMaximumInstantiationsPerProtectionObjective != L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_MAIN_SEARCH_MAXIMUM_DEPTH:
				return l1pMainSearchMaximumDepth != L1P_MAIN_SEARCH_MAXIMUM_DEPTH_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_MULTI_TREE_MULTIPLIER:
				return l1pMultiTreeMultiplier != L1P_MULTI_TREE_MULTIPLIER_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_INITIAL_ALPHA:
				return l1pInitialAlpha != L1P_INITIAL_ALPHA_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_INITIAL_BETA:
				return l1pInitialBeta != L1P_INITIAL_BETA_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_RESEARCH_DELTA:
				return l1pResearchDelta != L1P_RESEARCH_DELTA_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE:
				return l1pTranspositionTableMaximumSize != L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_FUTILITY_MARGIN:
				return l1pFutilityMargin != L1P_FUTILITY_MARGIN_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_EXTENDED_FUTILITY_MARGIN:
				return l1pExtendedFutilityMargin != L1P_EXTENDED_FUTILITY_MARGIN_EDEFAULT;
			case KbPackage.PREFERENCES__L1P_RAZORING_MARGIN:
				return l1pRazoringMargin != L1P_RAZORING_MARGIN_EDEFAULT;
			case KbPackage.PREFERENCES__L2P_SOLUTIONS_COUNT:
				return l2pSolutionsCount != L2P_SOLUTIONS_COUNT_EDEFAULT;
			case KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_SEED:
				return l2pFunctionSplittingSeed != L2P_FUNCTION_SPLITTING_SEED_EDEFAULT;
			case KbPackage.PREFERENCES__L2P_START_FROM_L1P_SOLUTION:
				return l2pStartFromL1pSolution != L2P_START_FROM_L1P_SOLUTION_EDEFAULT;
			case KbPackage.PREFERENCES__L2P_SOLUTION_LIMIT:
				return l2pSolutionLimit != L2P_SOLUTION_LIMIT_EDEFAULT;
			case KbPackage.PREFERENCES__L2P_TIME_LIMIT:
				return l2pTimeLimit != L2P_TIME_LIMIT_EDEFAULT;
			case KbPackage.PREFERENCES__L2P_GAP_LIMIT:
				return l2pGapLimit != L2P_GAP_LIMIT_EDEFAULT;
			case KbPackage.PREFERENCES__L2P_UPPER_BOUND:
				return l2pUpperBound != L2P_UPPER_BOUND_EDEFAULT;
			case KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH:
				return l2pFunctionSplittingMediumCodeBlockLength != L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH_EDEFAULT;
			case KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR:
				return l2pFunctionSplittingCodeBlockLengthRandomizationDenominator != L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR_EDEFAULT;
			case KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_DEPTH_LEVEL:
				return l2pFunctionSplittingDepthLevel != L2P_FUNCTION_SPLITTING_DEPTH_LEVEL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case KbPackage.PREFERENCES___HASH_CODE:
				return hashCode();
			case KbPackage.PREFERENCES___EQUALS__OBJECT:
				return equals(arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (workingDirectory: ");
		result.append(workingDirectory);
		result.append(", actcConfigurationFile: ");
		result.append(actcConfigurationFile);
		result.append(", espPatchFile: ");
		result.append(espPatchFile);
		result.append(", espJSONFile: ");
		result.append(espJSONFile);
		result.append(", architecture: ");
		result.append(architecture);
		result.append(", remoteConnection: ");
		result.append(remoteConnection);
		result.append(", remoteUsername: ");
		result.append(remoteUsername);
		result.append(", remotePassword: ");
		result.append(remotePassword);
		result.append(", remoteHost: ");
		result.append(remoteHost);
		result.append(", remotePort: ");
		result.append(remotePort);
		result.append(", remoteFileSeparator: ");
		result.append(remoteFileSeparator);
		result.append(", commandACTC: ");
		result.append(commandACTC);
		result.append(", commandTigress: ");
		result.append(commandTigress);
		result.append(", commandCilly: ");
		result.append(commandCilly);
		result.append(", commandPerl: ");
		result.append(commandPerl);
		result.append(", commandDot: ");
		result.append(commandDot);
		result.append(", metricsFile: ");
		result.append(metricsFile);
		result.append(", metricsTransformationDegree: ");
		result.append(metricsTransformationDegree);
		result.append(", metricsPseudoInverseSensitivity: ");
		result.append(metricsPseudoInverseSensitivity);
		result.append(", metricsDerivativeSensitivity: ");
		result.append(metricsDerivativeSensitivity);
		result.append(", metricsFitter: ");
		result.append(metricsFitter);
		result.append(", metricsNonLinearMaximumIterations: ");
		result.append(metricsNonLinearMaximumIterations);
		result.append(", metricsNonLinearStepSize: ");
		result.append(metricsNonLinearStepSize);
		result.append(", metricsNonLinearMinimumError: ");
		result.append(metricsNonLinearMinimumError);
		result.append(", metricsNonLinearMinimumChange: ");
		result.append(metricsNonLinearMinimumChange);
		result.append(", parserHeaderParsing: ");
		result.append(parserHeaderParsing);
		result.append(", parserSystemFilesIgnoration: ");
		result.append(parserSystemFilesIgnoration);
		result.append(", attacksTimeLimit: ");
		result.append(attacksTimeLimit);
		result.append(", attacksMaximumDepth: ");
		result.append(attacksMaximumDepth);
		result.append(", attacksIncludedProtectionObjectivesRemoval: ");
		result.append(attacksIncludedProtectionObjectivesRemoval);
		result.append(", protectionsMinimumAttackMitigation: ");
		result.append(protectionsMinimumAttackMitigation);
		result.append(", maxAttestatorsPerProtectionInstantiation: ");
		result.append(maxAttestatorsPerProtectionInstantiation);
		result.append(", clientTimeOverhead: ");
		result.append(clientTimeOverhead);
		result.append(", serverTimeOverhead: ");
		result.append(serverTimeOverhead);
		result.append(", clientMemoryOverhead: ");
		result.append(clientMemoryOverhead);
		result.append(", serverMemoryOverhead: ");
		result.append(serverMemoryOverhead);
		result.append(", networkOverhead: ");
		result.append(networkOverhead);
		result.append(", l1pSolutionsCount: ");
		result.append(l1pSolutionsCount);
		result.append(", l1pTimeLimit: ");
		result.append(l1pTimeLimit);
		result.append(", l1pSolutionsLimit: ");
		result.append(l1pSolutionsLimit);
		result.append(", l1pGapLimit: ");
		result.append(l1pGapLimit);
		result.append(", l1pClientTimeOverheadPercentage: ");
		result.append(l1pClientTimeOverheadPercentage);
		result.append(", l1pServerTimeOverheadPercentage: ");
		result.append(l1pServerTimeOverheadPercentage);
		result.append(", l1pClientMemoryOverheadPercentage: ");
		result.append(l1pClientMemoryOverheadPercentage);
		result.append(", l1pServerMemoryOverheadPercentage: ");
		result.append(l1pServerMemoryOverheadPercentage);
		result.append(", l1pNetworkOverheadPercentage: ");
		result.append(l1pNetworkOverheadPercentage);
		result.append(", l1pDiscouragedPrecedencesIgnoration: ");
		result.append(l1pDiscouragedPrecedencesIgnoration);
		result.append(", l1pEncouragedPrecedencesFocusing: ");
		result.append(l1pEncouragedPrecedencesFocusing);
		result.append(", l1pUseACTCPrecedences: ");
		result.append(l1pUseACTCPrecedences);
		result.append(", l1pIgnoreApplicationPartOrder: ");
		result.append(l1pIgnoreApplicationPartOrder);
		result.append(", l1pMaximumInstantiationsPerProtectionObjective: ");
		result.append(l1pMaximumInstantiationsPerProtectionObjective);
		result.append(", l1pMainSearchMaximumDepth: ");
		result.append(l1pMainSearchMaximumDepth);
		result.append(", l1pMultiTreeMultiplier: ");
		result.append(l1pMultiTreeMultiplier);
		result.append(", l1pInitialAlpha: ");
		result.append(l1pInitialAlpha);
		result.append(", l1pInitialBeta: ");
		result.append(l1pInitialBeta);
		result.append(", l1pResearchDelta: ");
		result.append(l1pResearchDelta);
		result.append(", l1pTranspositionTableMaximumSize: ");
		result.append(l1pTranspositionTableMaximumSize);
		result.append(", l1pFutilityMargin: ");
		result.append(l1pFutilityMargin);
		result.append(", l1pExtendedFutilityMargin: ");
		result.append(l1pExtendedFutilityMargin);
		result.append(", l1pRazoringMargin: ");
		result.append(l1pRazoringMargin);
		result.append(", l2pSolutionsCount: ");
		result.append(l2pSolutionsCount);
		result.append(", l2pFunctionSplittingSeed: ");
		result.append(l2pFunctionSplittingSeed);
		result.append(", l2pStartFromL1pSolution: ");
		result.append(l2pStartFromL1pSolution);
		result.append(", l2pSolutionLimit: ");
		result.append(l2pSolutionLimit);
		result.append(", l2pTimeLimit: ");
		result.append(l2pTimeLimit);
		result.append(", l2pGapLimit: ");
		result.append(l2pGapLimit);
		result.append(", l2pUpperBound: ");
		result.append(l2pUpperBound);
		result.append(", l2pFunctionSplittingMediumCodeBlockLength: ");
		result.append(l2pFunctionSplittingMediumCodeBlockLength);
		result.append(", l2pFunctionSplittingCodeBlockLengthRandomizationDenominator: ");
		result.append(l2pFunctionSplittingCodeBlockLengthRandomizationDenominator);
		result.append(", l2pFunctionSplittingDepthLevel: ");
		result.append(l2pFunctionSplittingDepthLevel);
		result.append(')');
		return result.toString();
	}

} //PreferencesImpl
