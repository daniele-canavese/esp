/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.ecore.EObject;
import it.polito.security.ontologies.annotations.MapsToDataProperty;
import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToObjectList;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Preferences</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The user preferences.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getWorkingDirectory <em>Working Directory</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getActcConfigurationFile <em>Actc Configuration File</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getEspPatchFile <em>Esp Patch File</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getEspJSONFile <em>Esp JSON File</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#isRemoteConnection <em>Remote Connection</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getRemoteUsername <em>Remote Username</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getRemotePassword <em>Remote Password</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getRemoteHost <em>Remote Host</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getRemotePort <em>Remote Port</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getRemoteFileSeparator <em>Remote File Separator</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getCommandACTC <em>Command ACTC</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getCommandTigress <em>Command Tigress</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getCommandCilly <em>Command Cilly</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getCommandPerl <em>Command Perl</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getCommandDot <em>Command Dot</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getMetricsFile <em>Metrics File</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getMetricsTransformationDegree <em>Metrics Transformation Degree</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getMetricsPseudoInverseSensitivity <em>Metrics Pseudo Inverse Sensitivity</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getMetricsDerivativeSensitivity <em>Metrics Derivative Sensitivity</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getMetricsFitter <em>Metrics Fitter</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getMetricsNonLinearMaximumIterations <em>Metrics Non Linear Maximum Iterations</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getMetricsNonLinearStepSize <em>Metrics Non Linear Step Size</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getMetricsNonLinearMinimumError <em>Metrics Non Linear Minimum Error</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getMetricsNonLinearMinimumChange <em>Metrics Non Linear Minimum Change</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#isParserHeaderParsing <em>Parser Header Parsing</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#isParserSystemFilesIgnoration <em>Parser System Files Ignoration</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getAttacksTimeLimit <em>Attacks Time Limit</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getAttacksMaximumDepth <em>Attacks Maximum Depth</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#isAttacksIncludedProtectionObjectivesRemoval <em>Attacks Included Protection Objectives Removal</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getProtectionsMinimumAttackMitigation <em>Protections Minimum Attack Mitigation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getMaxAttestatorsPerProtectionInstantiation <em>Max Attestators Per Protection Instantiation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getClientTimeOverhead <em>Client Time Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getServerTimeOverhead <em>Server Time Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getClientMemoryOverhead <em>Client Memory Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getServerMemoryOverhead <em>Server Memory Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getNetworkOverhead <em>Network Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pSolutionsCount <em>L1p Solutions Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pTimeLimit <em>L1p Time Limit</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pSolutionsLimit <em>L1p Solutions Limit</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pGapLimit <em>L1p Gap Limit</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pClientTimeOverheadPercentage <em>L1p Client Time Overhead Percentage</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pServerTimeOverheadPercentage <em>L1p Server Time Overhead Percentage</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pClientMemoryOverheadPercentage <em>L1p Client Memory Overhead Percentage</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pServerMemoryOverheadPercentage <em>L1p Server Memory Overhead Percentage</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pNetworkOverheadPercentage <em>L1p Network Overhead Percentage</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#isL1pDiscouragedPrecedencesIgnoration <em>L1p Discouraged Precedences Ignoration</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#isL1pEncouragedPrecedencesFocusing <em>L1p Encouraged Precedences Focusing</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#isL1pUseACTCPrecedences <em>L1p Use ACTC Precedences</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#isL1pIgnoreApplicationPartOrder <em>L1p Ignore Application Part Order</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pMaximumInstantiationsPerProtectionObjective <em>L1p Maximum Instantiations Per Protection Objective</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pMainSearchMaximumDepth <em>L1p Main Search Maximum Depth</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pMultiTreeMultiplier <em>L1p Multi Tree Multiplier</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pInitialAlpha <em>L1p Initial Alpha</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pInitialBeta <em>L1p Initial Beta</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pResearchDelta <em>L1p Research Delta</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pTranspositionTableMaximumSize <em>L1p Transposition Table Maximum Size</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pFutilityMargin <em>L1p Futility Margin</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pExtendedFutilityMargin <em>L1p Extended Futility Margin</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL1pRazoringMargin <em>L1p Razoring Margin</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL2pSolutionsCount <em>L2p Solutions Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL2pFunctionSplittingSeed <em>L2p Function Splitting Seed</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#isL2pStartFromL1pSolution <em>L2p Start From L1p Solution</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL2pSolutionLimit <em>L2p Solution Limit</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL2pTimeLimit <em>L2p Time Limit</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL2pGapLimit <em>L2p Gap Limit</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL2pUpperBound <em>L2p Upper Bound</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL2pFunctionSplittingMediumCodeBlockLength <em>L2p Function Splitting Medium Code Block Length</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator <em>L2p Function Splitting Code Block Length Randomization Denominator</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Preferences#getL2pFunctionSplittingDepthLevel <em>L2p Function Splitting Depth Level</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getPreferences()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#Preferences",
	name = "http://security.polito.it/esp/kb#preferences",
	singleton = true,
	dataProperties =
	{
		@MapsToDataProperty(id = KbPackage.PREFERENCES__WORKING_DIRECTORY, iri = "http://security.polito.it/esp/kb#hasWorkingDirectory"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__ACTC_CONFIGURATION_FILE, iri = "http://security.polito.it/esp/kb#hasACTCConfigurationFile"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__ESP_PATCH_FILE, iri = "http://security.polito.it/esp/kb#hasESPPatchFile"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__ESP_JSON_FILE, iri = "http://security.polito.it/esp/kb#hasESPJSONFile"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__ARCHITECTURE, iri = "http://security.polito.it/esp/kb#hasArchitecture"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__REMOTE_CONNECTION, iri = "http://security.polito.it/esp/kb#isRemoteConnection"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__REMOTE_USERNAME, iri = "http://security.polito.it/esp/kb#hasRemoteUsername"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__REMOTE_PASSWORD, iri = "http://security.polito.it/esp/kb#hasRemotePassword"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__REMOTE_HOST, iri = "http://security.polito.it/esp/kb#hasRemoteHost"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__REMOTE_PORT, iri = "http://security.polito.it/esp/kb#hasRemotePort"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__REMOTE_FILE_SEPARATOR, iri = "http://security.polito.it/esp/kb#hasRemoteFileSeparator"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__COMMAND_ACTC, iri = "http://security.polito.it/esp/kb#hasCommandACTC"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__COMMAND_PERL, iri = "http://security.polito.it/esp/kb#hasCommandPerl"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__COMMAND_DOT, iri = "http://security.polito.it/esp/kb#hasCommandDot"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__COMMAND_TIGRESS, iri = "http://security.polito.it/esp/kb#hasCommandTigress"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__COMMAND_CILLY, iri = "http://security.polito.it/esp/kb#hasCommandCilly"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__METRICS_FILE, iri = "http://security.polito.it/esp/kb#hasMetricsFile"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__METRICS_TRANSFORMATION_DEGREE, iri = "http://security.polito.it/esp/kb#hasMetricsTransformationDegree"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__METRICS_PSEUDO_INVERSE_SENSITIVITY, iri = "http://security.polito.it/esp/kb#hasMetricsPseudoInverseSensititivy"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__METRICS_DERIVATIVE_SENSITIVITY, iri = "http://security.polito.it/esp/kb#hasMetricsDerivativeSensititivy"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__METRICS_NON_LINEAR_MAXIMUM_ITERATIONS, iri = "http://security.polito.it/esp/kb#hasMetricsNonLinearMaximumIterations"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__METRICS_NON_LINEAR_STEP_SIZE, iri = "http://security.polito.it/esp/kb#hasMetricsNonLinearStepSize"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__METRICS_NON_LINEAR_MINIMUM_CHANGE, iri = "http://security.polito.it/esp/kb#hasMetricsNonLinearMinimumChange"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__METRICS_NON_LINEAR_MINIMUM_ERROR, iri = "http://security.polito.it/esp/kb#hasMetricsNonLinearMinimumError"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__PARSER_HEADER_PARSING, iri = "http://security.polito.it/esp/kb#isParserHeaderParsing"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__PARSER_SYSTEM_FILES_IGNORATION, iri = "http://security.polito.it/esp/kb#isParserSystemFilesIgnoration"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__ATTACKS_TIME_LIMIT, iri = "http://security.polito.it/esp/kb#hasAttacksTimeLimit"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__ATTACKS_MAXIMUM_DEPTH, iri = "http://security.polito.it/esp/kb#hasAttacksMaximumDepth"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL, iri = "http://security.polito.it/esp/kb#isAttacksIncludedProtectionObjectivesRemoval"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__CLIENT_TIME_OVERHEAD, iri = "http://security.polito.it/esp/kb#hasClientTimeOverhead"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__SERVER_TIME_OVERHEAD, iri = "http://security.polito.it/esp/kb#hasServerTimeOverhead"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__CLIENT_MEMORY_OVERHEAD, iri = "http://security.polito.it/esp/kb#hasClientMemoryOverhead"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__SERVER_MEMORY_OVERHEAD, iri = "http://security.polito.it/esp/kb#hasServerMemoryOverhead"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__NETWORK_OVERHEAD, iri = "http://security.polito.it/esp/kb#hasNetworkOverhead"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__MAX_ATTESTATORS_PER_PROTECTION_INSTANTIATION, iri = "http://security.polito.it/esp/kb#hasMaxNumOfAttestatorsPerPI"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_SOLUTIONS_COUNT, iri = "http://security.polito.it/esp/kb#hasL1PSolutionsCount"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_TIME_LIMIT, iri = "http://security.polito.it/esp/kb#hasL1PTimeLimit"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_SOLUTIONS_LIMIT, iri = "http://security.polito.it/esp/kb#hasL1PSolutionsLimit"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_GAP_LIMIT, iri = "http://security.polito.it/esp/kb#hasL1PGapLimit"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE, iri = "http://security.polito.it/esp/kb#hasL1PClientTimeOverheadPercentage"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_SERVER_TIME_OVERHEAD_PERCENTAGE, iri = "http://security.polito.it/esp/kb#hasL1PServerTimeOverheadPercentage"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE, iri = "http://security.polito.it/esp/kb#hasL1PClientMemoryOverheadPercentage"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE, iri = "http://security.polito.it/esp/kb#hasL1PServerMemoryOverheadPercentage"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_NETWORK_OVERHEAD_PERCENTAGE, iri = "http://security.polito.it/esp/kb#hasL1PNetworkOverheadPercentage"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_DISCOURAGED_PRECEDENCES_IGNORATION, iri = "http://security.polito.it/esp/kb#isL1PDiscouragedPrecedencesIgnoration"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_ENCOURAGED_PRECEDENCES_FOCUSING, iri = "http://security.polito.it/esp/kb#isL1PEncouragedPrecedencesFocusing"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_USE_ACTC_PRECEDENCES, iri = "http://security.polito.it/esp/kb#isUseL1PACTCPrecedences"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_IGNORE_APPLICATION_PART_ORDER, iri = "http://security.polito.it/esp/kb#isL1PIgnoreApplicationPartOrder"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE, iri = "http://security.polito.it/esp/kb#hasL1PMaximumInstantiationsPerProtectionObjective"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_MAIN_SEARCH_MAXIMUM_DEPTH, iri = "http://security.polito.it/esp/kb#hasL1PMainSearchMaximumDepth"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_MULTI_TREE_MULTIPLIER, iri = "http://security.polito.it/esp/kb#hasL1PMultiTreeMultiplier"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_INITIAL_ALPHA, iri = "http://security.polito.it/esp/kb#hasL1PInitialAlpha"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_INITIAL_BETA, iri = "http://security.polito.it/esp/kb#hasL1PInitialBeta"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_RESEARCH_DELTA, iri = "http://security.polito.it/esp/kb#hasL1PResearchDelta"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE, iri = "http://security.polito.it/esp/kb#hasL1PTranspositionTableMaximumSize"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_FUTILITY_MARGIN, iri = "http://security.polito.it/esp/kb#hasL1PFutilityMargin"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_EXTENDED_FUTILITY_MARGIN, iri = "http://security.polito.it/esp/kb#hasL1PExtendedFutilityMargin"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L1P_RAZORING_MARGIN, iri = "http://security.polito.it/esp/kb#hasL1PRazoringMargin"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L2P_SOLUTIONS_COUNT, iri = "http://security.polito.it/esp/kb#hasL2PSolutionsCount"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L2P_TIME_LIMIT, iri = "http://security.polito.it/esp/kb#hasL2PTimeLimit"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L2P_SOLUTION_LIMIT, iri = "http://security.polito.it/esp/kb#hasL2PSolutionLimit"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L2P_GAP_LIMIT, iri = "http://security.polito.it/esp/kb#hasL2PGapLimit"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR, iri = "http://security.polito.it/esp/kb#hasL2PFunctionSplittingCodeBlockLengthRandomizationDenominator"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_DEPTH_LEVEL, iri = "http://security.polito.it/esp/kb#hasL2PFunctionSplittingDepthLevel"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH, iri = "http://security.polito.it/esp/kb#hasL2PFunctionSplittingMediumCodeBlockLength"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_SEED, iri = "http://security.polito.it/esp/kb#hasL2PFunctionSplittingSeed"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L2P_START_FROM_L1P_SOLUTION, iri = "http://security.polito.it/esp/kb#hasL2PStartFromL1PSolution"),
		@MapsToDataProperty(id = KbPackage.PREFERENCES__L2P_UPPER_BOUND, iri = "http://security.polito.it/esp/kb#hasL2PUpperBound")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = KbPackage.PREFERENCES__PROTECTIONS_MINIMUM_ATTACK_MITIGATION, iri = "http://security.polito.it/esp/kb#hasProtectionsMinimumAttackMitigation"),
		@MapsToObjectProperty(id = KbPackage.PREFERENCES__METRICS_FITTER, iri = "http://security.polito.it/esp/kb#hasMetricsFitterType")
	}
)
public interface Preferences extends EObject {
	/**
	 * Returns the value of the '<em><b>Working Directory</b></em>' attribute.
	 * The default value is <code>"/home/aspire/test"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The working directory.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Working Directory</em>' attribute.
	 * @see #setWorkingDirectory(String)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_WorkingDirectory()
	 * @model default="/home/aspire/test" unique="false"
	 * @generated
	 */
	String getWorkingDirectory();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getWorkingDirectory <em>Working Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Working Directory</em>' attribute.
	 * @see #getWorkingDirectory()
	 * @generated
	 */
	void setWorkingDirectory(String value);

	/**
	 * Returns the value of the '<em><b>Actc Configuration File</b></em>' attribute.
	 * The default value is <code>"test.json"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ACTC configuration file.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Actc Configuration File</em>' attribute.
	 * @see #setActcConfigurationFile(String)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_ActcConfigurationFile()
	 * @model default="test.json" unique="false"
	 * @generated
	 */
	String getActcConfigurationFile();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getActcConfigurationFile <em>Actc Configuration File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actc Configuration File</em>' attribute.
	 * @see #getActcConfigurationFile()
	 * @generated
	 */
	void setActcConfigurationFile(String value);

	/**
	 * Returns the value of the '<em><b>Esp Patch File</b></em>' attribute.
	 * The default value is <code>"esp.patch"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ESP patch file.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Esp Patch File</em>' attribute.
	 * @see #setEspPatchFile(String)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_EspPatchFile()
	 * @model default="esp.patch" unique="false"
	 * @generated
	 */
	String getEspPatchFile();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getEspPatchFile <em>Esp Patch File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Esp Patch File</em>' attribute.
	 * @see #getEspPatchFile()
	 * @generated
	 */
	void setEspPatchFile(String value);

	/**
	 * Returns the value of the '<em><b>Esp JSON File</b></em>' attribute.
	 * The default value is <code>"esp.json"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ESP json file.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Esp JSON File</em>' attribute.
	 * @see #setEspJSONFile(String)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_EspJSONFile()
	 * @model default="esp.json" unique="false"
	 * @generated
	 */
	String getEspJSONFile();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getEspJSONFile <em>Esp JSON File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Esp JSON File</em>' attribute.
	 * @see #getEspJSONFile()
	 * @generated
	 */
	void setEspJSONFile(String value);

	/**
	 * Returns the value of the '<em><b>Architecture</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The architecture where the project is deployed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Architecture</em>' attribute.
	 * @see #setArchitecture(String)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_Architecture()
	 * @model default="" unique="false"
	 * @generated
	 */
	String getArchitecture();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getArchitecture <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Architecture</em>' attribute.
	 * @see #getArchitecture()
	 * @generated
	 */
	void setArchitecture(String value);

	/**
	 * Returns the value of the '<em><b>Remote Connection</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The use of a remote connection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Remote Connection</em>' attribute.
	 * @see #setRemoteConnection(boolean)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_RemoteConnection()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isRemoteConnection();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#isRemoteConnection <em>Remote Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Connection</em>' attribute.
	 * @see #isRemoteConnection()
	 * @generated
	 */
	void setRemoteConnection(boolean value);

	/**
	 * Returns the value of the '<em><b>Remote Username</b></em>' attribute.
	 * The default value is <code>"aspire"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The username for the remote server.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Remote Username</em>' attribute.
	 * @see #setRemoteUsername(String)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_RemoteUsername()
	 * @model default="aspire" unique="false"
	 * @generated
	 */
	String getRemoteUsername();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getRemoteUsername <em>Remote Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Username</em>' attribute.
	 * @see #getRemoteUsername()
	 * @generated
	 */
	void setRemoteUsername(String value);

	/**
	 * Returns the value of the '<em><b>Remote Password</b></em>' attribute.
	 * The default value is <code>"aspire"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The password for the remote server.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Remote Password</em>' attribute.
	 * @see #setRemotePassword(String)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_RemotePassword()
	 * @model default="aspire" unique="false"
	 * @generated
	 */
	String getRemotePassword();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getRemotePassword <em>Remote Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Password</em>' attribute.
	 * @see #getRemotePassword()
	 * @generated
	 */
	void setRemotePassword(String value);

	/**
	 * Returns the value of the '<em><b>Remote Host</b></em>' attribute.
	 * The default value is <code>"127.0.1.1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The remote host to use.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Remote Host</em>' attribute.
	 * @see #setRemoteHost(String)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_RemoteHost()
	 * @model default="127.0.1.1" unique="false"
	 * @generated
	 */
	String getRemoteHost();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getRemoteHost <em>Remote Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Host</em>' attribute.
	 * @see #getRemoteHost()
	 * @generated
	 */
	void setRemoteHost(String value);

	/**
	 * Returns the value of the '<em><b>Remote Port</b></em>' attribute.
	 * The default value is <code>"3022"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The remote port to use.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Remote Port</em>' attribute.
	 * @see #setRemotePort(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_RemotePort()
	 * @model default="3022" unique="false"
	 * @generated
	 */
	int getRemotePort();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getRemotePort <em>Remote Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Port</em>' attribute.
	 * @see #getRemotePort()
	 * @generated
	 */
	void setRemotePort(int value);

	/**
	 * Returns the value of the '<em><b>Remote File Separator</b></em>' attribute.
	 * The default value is <code>"/"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The remote server file separator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Remote File Separator</em>' attribute.
	 * @see #setRemoteFileSeparator(String)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_RemoteFileSeparator()
	 * @model default="/" unique="false"
	 * @generated
	 */
	String getRemoteFileSeparator();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getRemoteFileSeparator <em>Remote File Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote File Separator</em>' attribute.
	 * @see #getRemoteFileSeparator()
	 * @generated
	 */
	void setRemoteFileSeparator(String value);

	/**
	 * Returns the value of the '<em><b>Command ACTC</b></em>' attribute.
	 * The default value is <code>"docker-compose -f ~/git/framework/docker-compose.yml exec -T actc /opt/ACTC/actc.py"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ACTC command.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Command ACTC</em>' attribute.
	 * @see #setCommandACTC(String)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_CommandACTC()
	 * @model default="docker-compose -f ~/git/framework/docker-compose.yml exec -T actc /opt/ACTC/actc.py" unique="false"
	 * @generated
	 */
	String getCommandACTC();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getCommandACTC <em>Command ACTC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command ACTC</em>' attribute.
	 * @see #getCommandACTC()
	 * @generated
	 */
	void setCommandACTC(String value);

	/**
	 * Returns the value of the '<em><b>Command Tigress</b></em>' attribute.
	 * The default value is <code>"docker-compose -f ~/git/framework/docker-compose.yml exec -T actc env TIGRESS_HOME=/projects/tigress-unstable PATH=$PATH:/projects/tigress-unstable /projects/tigress-unstable/tigress"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Tigress command.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Command Tigress</em>' attribute.
	 * @see #setCommandTigress(String)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_CommandTigress()
	 * @model default="docker-compose -f ~/git/framework/docker-compose.yml exec -T actc env TIGRESS_HOME=/projects/tigress-unstable PATH=$PATH:/projects/tigress-unstable /projects/tigress-unstable/tigress" unique="false"
	 * @generated
	 */
	String getCommandTigress();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getCommandTigress <em>Command Tigress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command Tigress</em>' attribute.
	 * @see #getCommandTigress()
	 * @generated
	 */
	void setCommandTigress(String value);

	/**
	 * Returns the value of the '<em><b>Command Cilly</b></em>' attribute.
	 * The default value is <code>"docker-compose -f ~/git/framework/docker-compose.yml exec -T actc env TIGRESS_HOME=/projects/tigress-unstable PATH=$PATH:/projects/tigress-unstable /projects/tigress-unstable/cilly"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Cilly command.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Command Cilly</em>' attribute.
	 * @see #setCommandCilly(String)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_CommandCilly()
	 * @model default="docker-compose -f ~/git/framework/docker-compose.yml exec -T actc env TIGRESS_HOME=/projects/tigress-unstable PATH=$PATH:/projects/tigress-unstable /projects/tigress-unstable/cilly" unique="false"
	 * @generated
	 */
	String getCommandCilly();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getCommandCilly <em>Command Cilly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command Cilly</em>' attribute.
	 * @see #getCommandCilly()
	 * @generated
	 */
	void setCommandCilly(String value);

	/**
	 * Returns the value of the '<em><b>Command Perl</b></em>' attribute.
	 * The default value is <code>"/usr/bin/perl"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Perl interpreter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Command Perl</em>' attribute.
	 * @see #setCommandPerl(String)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_CommandPerl()
	 * @model default="/usr/bin/perl" unique="false"
	 * @generated
	 */
	String getCommandPerl();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getCommandPerl <em>Command Perl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command Perl</em>' attribute.
	 * @see #getCommandPerl()
	 * @generated
	 */
	void setCommandPerl(String value);

	/**
	 * Returns the value of the '<em><b>Command Dot</b></em>' attribute.
	 * The default value is <code>"/usr/bin/dot"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The dot command.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Command Dot</em>' attribute.
	 * @see #setCommandDot(String)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_CommandDot()
	 * @model default="/usr/bin/dot" unique="false"
	 * @generated
	 */
	String getCommandDot();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getCommandDot <em>Command Dot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command Dot</em>' attribute.
	 * @see #getCommandDot()
	 * @generated
	 */
	void setCommandDot(String value);

	/**
	 * Returns the value of the '<em><b>Metrics File</b></em>' attribute.
	 * The default value is <code>"+gammas.csv"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The metrics coefficients file name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metrics File</em>' attribute.
	 * @see #setMetricsFile(String)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_MetricsFile()
	 * @model default="+gammas.csv" unique="false"
	 * @generated
	 */
	String getMetricsFile();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getMetricsFile <em>Metrics File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metrics File</em>' attribute.
	 * @see #getMetricsFile()
	 * @generated
	 */
	void setMetricsFile(String value);

	/**
	 * Returns the value of the '<em><b>Metrics Transformation Degree</b></em>' attribute.
	 * The default value is <code>"4"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The transformation degree.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metrics Transformation Degree</em>' attribute.
	 * @see #setMetricsTransformationDegree(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_MetricsTransformationDegree()
	 * @model default="4" unique="false"
	 * @generated
	 */
	int getMetricsTransformationDegree();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getMetricsTransformationDegree <em>Metrics Transformation Degree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metrics Transformation Degree</em>' attribute.
	 * @see #getMetricsTransformationDegree()
	 * @generated
	 */
	void setMetricsTransformationDegree(int value);

	/**
	 * Returns the value of the '<em><b>Metrics Pseudo Inverse Sensitivity</b></em>' attribute.
	 * The default value is <code>"1e-9"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The pseudo-inverse matrix computation sensitivity.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metrics Pseudo Inverse Sensitivity</em>' attribute.
	 * @see #setMetricsPseudoInverseSensitivity(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_MetricsPseudoInverseSensitivity()
	 * @model default="1e-9" unique="false"
	 * @generated
	 */
	double getMetricsPseudoInverseSensitivity();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getMetricsPseudoInverseSensitivity <em>Metrics Pseudo Inverse Sensitivity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metrics Pseudo Inverse Sensitivity</em>' attribute.
	 * @see #getMetricsPseudoInverseSensitivity()
	 * @generated
	 */
	void setMetricsPseudoInverseSensitivity(double value);

	/**
	 * Returns the value of the '<em><b>Metrics Derivative Sensitivity</b></em>' attribute.
	 * The default value is <code>"1e-9"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The derivative computation sensitivity.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metrics Derivative Sensitivity</em>' attribute.
	 * @see #setMetricsDerivativeSensitivity(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_MetricsDerivativeSensitivity()
	 * @model default="1e-9" unique="false"
	 * @generated
	 */
	double getMetricsDerivativeSensitivity();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getMetricsDerivativeSensitivity <em>Metrics Derivative Sensitivity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metrics Derivative Sensitivity</em>' attribute.
	 * @see #getMetricsDerivativeSensitivity()
	 * @generated
	 */
	void setMetricsDerivativeSensitivity(double value);

	/**
	 * Returns the value of the '<em><b>Metrics Fitter</b></em>' attribute.
	 * The default value is <code>"nonLinearFitter"</code>.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.FitterType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The fitter type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metrics Fitter</em>' attribute.
	 * @see it.polito.security.esp.kb.FitterType
	 * @see #setMetricsFitter(FitterType)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_MetricsFitter()
	 * @model default="nonLinearFitter" unique="false"
	 * @generated
	 */
	FitterType getMetricsFitter();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getMetricsFitter <em>Metrics Fitter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metrics Fitter</em>' attribute.
	 * @see it.polito.security.esp.kb.FitterType
	 * @see #getMetricsFitter()
	 * @generated
	 */
	void setMetricsFitter(FitterType value);

	/**
	 * Returns the value of the '<em><b>Metrics Non Linear Maximum Iterations</b></em>' attribute.
	 * The default value is <code>"10000"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The non-linear fitter maximum iterations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metrics Non Linear Maximum Iterations</em>' attribute.
	 * @see #setMetricsNonLinearMaximumIterations(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_MetricsNonLinearMaximumIterations()
	 * @model default="10000" unique="false"
	 * @generated
	 */
	int getMetricsNonLinearMaximumIterations();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getMetricsNonLinearMaximumIterations <em>Metrics Non Linear Maximum Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metrics Non Linear Maximum Iterations</em>' attribute.
	 * @see #getMetricsNonLinearMaximumIterations()
	 * @generated
	 */
	void setMetricsNonLinearMaximumIterations(int value);

	/**
	 * Returns the value of the '<em><b>Metrics Non Linear Step Size</b></em>' attribute.
	 * The default value is <code>"0.01"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The non-linear fitter step size.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metrics Non Linear Step Size</em>' attribute.
	 * @see #setMetricsNonLinearStepSize(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_MetricsNonLinearStepSize()
	 * @model default="0.01" unique="false"
	 * @generated
	 */
	double getMetricsNonLinearStepSize();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getMetricsNonLinearStepSize <em>Metrics Non Linear Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metrics Non Linear Step Size</em>' attribute.
	 * @see #getMetricsNonLinearStepSize()
	 * @generated
	 */
	void setMetricsNonLinearStepSize(double value);

	/**
	 * Returns the value of the '<em><b>Metrics Non Linear Minimum Error</b></em>' attribute.
	 * The default value is <code>"1e-9"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The non-linear fitter error minimum error.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metrics Non Linear Minimum Error</em>' attribute.
	 * @see #setMetricsNonLinearMinimumError(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_MetricsNonLinearMinimumError()
	 * @model default="1e-9" unique="false"
	 * @generated
	 */
	double getMetricsNonLinearMinimumError();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getMetricsNonLinearMinimumError <em>Metrics Non Linear Minimum Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metrics Non Linear Minimum Error</em>' attribute.
	 * @see #getMetricsNonLinearMinimumError()
	 * @generated
	 */
	void setMetricsNonLinearMinimumError(double value);

	/**
	 * Returns the value of the '<em><b>Metrics Non Linear Minimum Change</b></em>' attribute.
	 * The default value is <code>"1e-9"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The non-linear fitter minimum change.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metrics Non Linear Minimum Change</em>' attribute.
	 * @see #setMetricsNonLinearMinimumChange(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_MetricsNonLinearMinimumChange()
	 * @model default="1e-9" unique="false"
	 * @generated
	 */
	double getMetricsNonLinearMinimumChange();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getMetricsNonLinearMinimumChange <em>Metrics Non Linear Minimum Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metrics Non Linear Minimum Change</em>' attribute.
	 * @see #getMetricsNonLinearMinimumChange()
	 * @generated
	 */
	void setMetricsNonLinearMinimumChange(double value);

	/**
	 * Returns the value of the '<em><b>Parser Header Parsing</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Parses the header files.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parser Header Parsing</em>' attribute.
	 * @see #setParserHeaderParsing(boolean)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_ParserHeaderParsing()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isParserHeaderParsing();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#isParserHeaderParsing <em>Parser Header Parsing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parser Header Parsing</em>' attribute.
	 * @see #isParserHeaderParsing()
	 * @generated
	 */
	void setParserHeaderParsing(boolean value);

	/**
	 * Returns the value of the '<em><b>Parser System Files Ignoration</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Ignores the system files.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parser System Files Ignoration</em>' attribute.
	 * @see #setParserSystemFilesIgnoration(boolean)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_ParserSystemFilesIgnoration()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isParserSystemFilesIgnoration();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#isParserSystemFilesIgnoration <em>Parser System Files Ignoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parser System Files Ignoration</em>' attribute.
	 * @see #isParserSystemFilesIgnoration()
	 * @generated
	 */
	void setParserSystemFilesIgnoration(boolean value);

	/**
	 * Returns the value of the '<em><b>Attacks Time Limit</b></em>' attribute.
	 * The default value is <code>"60"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack finder time limit in seconds or a non-positive value to disable it.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attacks Time Limit</em>' attribute.
	 * @see #setAttacksTimeLimit(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_AttacksTimeLimit()
	 * @model default="60" unique="false"
	 * @generated
	 */
	int getAttacksTimeLimit();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getAttacksTimeLimit <em>Attacks Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attacks Time Limit</em>' attribute.
	 * @see #getAttacksTimeLimit()
	 * @generated
	 */
	void setAttacksTimeLimit(int value);

	/**
	 * Returns the value of the '<em><b>Attacks Maximum Depth</b></em>' attribute.
	 * The default value is <code>"4"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack finder maximum search depth.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attacks Maximum Depth</em>' attribute.
	 * @see #setAttacksMaximumDepth(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_AttacksMaximumDepth()
	 * @model default="4" unique="false"
	 * @generated
	 */
	int getAttacksMaximumDepth();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getAttacksMaximumDepth <em>Attacks Maximum Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attacks Maximum Depth</em>' attribute.
	 * @see #getAttacksMaximumDepth()
	 * @generated
	 */
	void setAttacksMaximumDepth(int value);

	/**
	 * Returns the value of the '<em><b>Attacks Included Protection Objectives Removal</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Removes the included protection objectives.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attacks Included Protection Objectives Removal</em>' attribute.
	 * @see #setAttacksIncludedProtectionObjectivesRemoval(boolean)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_AttacksIncludedProtectionObjectivesRemoval()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isAttacksIncludedProtectionObjectivesRemoval();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#isAttacksIncludedProtectionObjectivesRemoval <em>Attacks Included Protection Objectives Removal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attacks Included Protection Objectives Removal</em>' attribute.
	 * @see #isAttacksIncludedProtectionObjectivesRemoval()
	 * @generated
	 */
	void setAttacksIncludedProtectionObjectivesRemoval(boolean value);

	/**
	 * Returns the value of the '<em><b>Protections Minimum Attack Mitigation</b></em>' attribute.
	 * The default value is <code>"medium"</code>.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.Level}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum allowed mitigation level for a protection to be used.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protections Minimum Attack Mitigation</em>' attribute.
	 * @see it.polito.security.esp.kb.Level
	 * @see #setProtectionsMinimumAttackMitigation(Level)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_ProtectionsMinimumAttackMitigation()
	 * @model default="medium" unique="false"
	 * @generated
	 */
	Level getProtectionsMinimumAttackMitigation();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getProtectionsMinimumAttackMitigation <em>Protections Minimum Attack Mitigation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protections Minimum Attack Mitigation</em>' attribute.
	 * @see it.polito.security.esp.kb.Level
	 * @see #getProtectionsMinimumAttackMitigation()
	 * @generated
	 */
	void setProtectionsMinimumAttackMitigation(Level value);

	/**
	 * Returns the value of the '<em><b>Max Attestators Per Protection Instantiation</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum allowed number of attestators generated for a single protection instantiation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Attestators Per Protection Instantiation</em>' attribute.
	 * @see #setMaxAttestatorsPerProtectionInstantiation(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_MaxAttestatorsPerProtectionInstantiation()
	 * @model default="3" unique="false"
	 * @generated
	 */
	int getMaxAttestatorsPerProtectionInstantiation();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getMaxAttestatorsPerProtectionInstantiation <em>Max Attestators Per Protection Instantiation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Attestators Per Protection Instantiation</em>' attribute.
	 * @see #getMaxAttestatorsPerProtectionInstantiation()
	 * @generated
	 */
	void setMaxAttestatorsPerProtectionInstantiation(int value);

	/**
	 * Returns the value of the '<em><b>Client Time Overhead</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The client time overhead in percentage w.r.t. to the vanilla application.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Client Time Overhead</em>' attribute.
	 * @see #setClientTimeOverhead(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_ClientTimeOverhead()
	 * @model default="10" unique="false"
	 * @generated
	 */
	double getClientTimeOverhead();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getClientTimeOverhead <em>Client Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Time Overhead</em>' attribute.
	 * @see #getClientTimeOverhead()
	 * @generated
	 */
	void setClientTimeOverhead(double value);

	/**
	 * Returns the value of the '<em><b>Server Time Overhead</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The server time overhead in percentage w.r.t. to the vanilla application.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Server Time Overhead</em>' attribute.
	 * @see #setServerTimeOverhead(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_ServerTimeOverhead()
	 * @model default="10" unique="false"
	 * @generated
	 */
	double getServerTimeOverhead();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getServerTimeOverhead <em>Server Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Time Overhead</em>' attribute.
	 * @see #getServerTimeOverhead()
	 * @generated
	 */
	void setServerTimeOverhead(double value);

	/**
	 * Returns the value of the '<em><b>Client Memory Overhead</b></em>' attribute.
	 * The default value is <code>"10240"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The client memory overhead in bytes w.r.t. to the vanilla application.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Client Memory Overhead</em>' attribute.
	 * @see #setClientMemoryOverhead(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_ClientMemoryOverhead()
	 * @model default="10240" unique="false"
	 * @generated
	 */
	int getClientMemoryOverhead();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getClientMemoryOverhead <em>Client Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Memory Overhead</em>' attribute.
	 * @see #getClientMemoryOverhead()
	 * @generated
	 */
	void setClientMemoryOverhead(int value);

	/**
	 * Returns the value of the '<em><b>Server Memory Overhead</b></em>' attribute.
	 * The default value is <code>"10240"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The server memory overhead in bytes w.r.t. to the vanilla application.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Server Memory Overhead</em>' attribute.
	 * @see #setServerMemoryOverhead(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_ServerMemoryOverhead()
	 * @model default="10240" unique="false"
	 * @generated
	 */
	int getServerMemoryOverhead();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getServerMemoryOverhead <em>Server Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Memory Overhead</em>' attribute.
	 * @see #getServerMemoryOverhead()
	 * @generated
	 */
	void setServerMemoryOverhead(int value);

	/**
	 * Returns the value of the '<em><b>Network Overhead</b></em>' attribute.
	 * The default value is <code>"1048576"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The network overhead in bytes per second w.r.t. to the vanilla application.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Network Overhead</em>' attribute.
	 * @see #setNetworkOverhead(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_NetworkOverhead()
	 * @model default="1048576" unique="false"
	 * @generated
	 */
	int getNetworkOverhead();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getNetworkOverhead <em>Network Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Network Overhead</em>' attribute.
	 * @see #getNetworkOverhead()
	 * @generated
	 */
	void setNetworkOverhead(int value);

	/**
	 * Returns the value of the '<em><b>L1p Solutions Count</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The number of solutions to find.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Solutions Count</em>' attribute.
	 * @see #setL1pSolutionsCount(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pSolutionsCount()
	 * @model default="3" unique="false"
	 * @generated
	 */
	int getL1pSolutionsCount();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pSolutionsCount <em>L1p Solutions Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Solutions Count</em>' attribute.
	 * @see #getL1pSolutionsCount()
	 * @generated
	 */
	void setL1pSolutionsCount(int value);

	/**
	 * Returns the value of the '<em><b>L1p Time Limit</b></em>' attribute.
	 * The default value is <code>"60"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The time limit in seconds or a non-positive value to disable it.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Time Limit</em>' attribute.
	 * @see #setL1pTimeLimit(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pTimeLimit()
	 * @model default="60" unique="false"
	 * @generated
	 */
	int getL1pTimeLimit();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pTimeLimit <em>L1p Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Time Limit</em>' attribute.
	 * @see #getL1pTimeLimit()
	 * @generated
	 */
	void setL1pTimeLimit(int value);

	/**
	 * Returns the value of the '<em><b>L1p Solutions Limit</b></em>' attribute.
	 * The default value is <code>"-10000"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum number of solutions to explore or a non-positive value to disable it.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Solutions Limit</em>' attribute.
	 * @see #setL1pSolutionsLimit(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pSolutionsLimit()
	 * @model default="-10000" unique="false"
	 * @generated
	 */
	int getL1pSolutionsLimit();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pSolutionsLimit <em>L1p Solutions Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Solutions Limit</em>' attribute.
	 * @see #getL1pSolutionsLimit()
	 * @generated
	 */
	void setL1pSolutionsLimit(int value);

	/**
	 * Returns the value of the '<em><b>L1p Gap Limit</b></em>' attribute.
	 * The default value is <code>"-10.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The gap limit or a non-positive value to disable it.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Gap Limit</em>' attribute.
	 * @see #setL1pGapLimit(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pGapLimit()
	 * @model default="-10.0" unique="false"
	 * @generated
	 */
	double getL1pGapLimit();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pGapLimit <em>L1p Gap Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Gap Limit</em>' attribute.
	 * @see #getL1pGapLimit()
	 * @generated
	 */
	void setL1pGapLimit(double value);

	/**
	 * Returns the value of the '<em><b>L1p Client Time Overhead Percentage</b></em>' attribute.
	 * The default value is <code>"75"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The percentage of the client time overhead to use or a non-positive value to ignore the overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Client Time Overhead Percentage</em>' attribute.
	 * @see #setL1pClientTimeOverheadPercentage(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pClientTimeOverheadPercentage()
	 * @model default="75" unique="false"
	 * @generated
	 */
	double getL1pClientTimeOverheadPercentage();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pClientTimeOverheadPercentage <em>L1p Client Time Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Client Time Overhead Percentage</em>' attribute.
	 * @see #getL1pClientTimeOverheadPercentage()
	 * @generated
	 */
	void setL1pClientTimeOverheadPercentage(double value);

	/**
	 * Returns the value of the '<em><b>L1p Server Time Overhead Percentage</b></em>' attribute.
	 * The default value is <code>"-75"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The percentage of the server time overhead to use or a non-positive value to ignore the overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Server Time Overhead Percentage</em>' attribute.
	 * @see #setL1pServerTimeOverheadPercentage(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pServerTimeOverheadPercentage()
	 * @model default="-75" unique="false"
	 * @generated
	 */
	double getL1pServerTimeOverheadPercentage();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pServerTimeOverheadPercentage <em>L1p Server Time Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Server Time Overhead Percentage</em>' attribute.
	 * @see #getL1pServerTimeOverheadPercentage()
	 * @generated
	 */
	void setL1pServerTimeOverheadPercentage(double value);

	/**
	 * Returns the value of the '<em><b>L1p Client Memory Overhead Percentage</b></em>' attribute.
	 * The default value is <code>"-75"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The percentage of the client memory overhead to use or a non-positive value to ignore the overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Client Memory Overhead Percentage</em>' attribute.
	 * @see #setL1pClientMemoryOverheadPercentage(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pClientMemoryOverheadPercentage()
	 * @model default="-75" unique="false"
	 * @generated
	 */
	double getL1pClientMemoryOverheadPercentage();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pClientMemoryOverheadPercentage <em>L1p Client Memory Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Client Memory Overhead Percentage</em>' attribute.
	 * @see #getL1pClientMemoryOverheadPercentage()
	 * @generated
	 */
	void setL1pClientMemoryOverheadPercentage(double value);

	/**
	 * Returns the value of the '<em><b>L1p Server Memory Overhead Percentage</b></em>' attribute.
	 * The default value is <code>"-75"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The percentage of the server memory overhead to use or a non-positive value to ignore the overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Server Memory Overhead Percentage</em>' attribute.
	 * @see #setL1pServerMemoryOverheadPercentage(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pServerMemoryOverheadPercentage()
	 * @model default="-75" unique="false"
	 * @generated
	 */
	double getL1pServerMemoryOverheadPercentage();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pServerMemoryOverheadPercentage <em>L1p Server Memory Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Server Memory Overhead Percentage</em>' attribute.
	 * @see #getL1pServerMemoryOverheadPercentage()
	 * @generated
	 */
	void setL1pServerMemoryOverheadPercentage(double value);

	/**
	 * Returns the value of the '<em><b>L1p Network Overhead Percentage</b></em>' attribute.
	 * The default value is <code>"-75"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The percentage of the network overhead to use or a non-positive value to ignore the overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Network Overhead Percentage</em>' attribute.
	 * @see #setL1pNetworkOverheadPercentage(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pNetworkOverheadPercentage()
	 * @model default="-75" unique="false"
	 * @generated
	 */
	double getL1pNetworkOverheadPercentage();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pNetworkOverheadPercentage <em>L1p Network Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Network Overhead Percentage</em>' attribute.
	 * @see #getL1pNetworkOverheadPercentage()
	 * @generated
	 */
	void setL1pNetworkOverheadPercentage(double value);

	/**
	 * Returns the value of the '<em><b>L1p Discouraged Precedences Ignoration</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Ignores the discouraged precedences.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Discouraged Precedences Ignoration</em>' attribute.
	 * @see #setL1pDiscouragedPrecedencesIgnoration(boolean)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pDiscouragedPrecedencesIgnoration()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isL1pDiscouragedPrecedencesIgnoration();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#isL1pDiscouragedPrecedencesIgnoration <em>L1p Discouraged Precedences Ignoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Discouraged Precedences Ignoration</em>' attribute.
	 * @see #isL1pDiscouragedPrecedencesIgnoration()
	 * @generated
	 */
	void setL1pDiscouragedPrecedencesIgnoration(boolean value);

	/**
	 * Returns the value of the '<em><b>L1p Encouraged Precedences Focusing</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Focuses only on the encouraged precedences.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Encouraged Precedences Focusing</em>' attribute.
	 * @see #setL1pEncouragedPrecedencesFocusing(boolean)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pEncouragedPrecedencesFocusing()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isL1pEncouragedPrecedencesFocusing();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#isL1pEncouragedPrecedencesFocusing <em>L1p Encouraged Precedences Focusing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Encouraged Precedences Focusing</em>' attribute.
	 * @see #isL1pEncouragedPrecedencesFocusing()
	 * @generated
	 */
	void setL1pEncouragedPrecedencesFocusing(boolean value);

	/**
	 * Returns the value of the '<em><b>L1p Use ACTC Precedences</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Uses the ACTC precedences.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Use ACTC Precedences</em>' attribute.
	 * @see #setL1pUseACTCPrecedences(boolean)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pUseACTCPrecedences()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isL1pUseACTCPrecedences();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#isL1pUseACTCPrecedences <em>L1p Use ACTC Precedences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Use ACTC Precedences</em>' attribute.
	 * @see #isL1pUseACTCPrecedences()
	 * @generated
	 */
	void setL1pUseACTCPrecedences(boolean value);

	/**
	 * Returns the value of the '<em><b>L1p Ignore Application Part Order</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Ignores the application part order.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Ignore Application Part Order</em>' attribute.
	 * @see #setL1pIgnoreApplicationPartOrder(boolean)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pIgnoreApplicationPartOrder()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isL1pIgnoreApplicationPartOrder();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#isL1pIgnoreApplicationPartOrder <em>L1p Ignore Application Part Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Ignore Application Part Order</em>' attribute.
	 * @see #isL1pIgnoreApplicationPartOrder()
	 * @generated
	 */
	void setL1pIgnoreApplicationPartOrder(boolean value);

	/**
	 * Returns the value of the '<em><b>L1p Maximum Instantiations Per Protection Objective</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum number o1 instantiations per protection objective or <code>null</code> for infinity.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Maximum Instantiations Per Protection Objective</em>' attribute.
	 * @see #setL1pMaximumInstantiationsPerProtectionObjective(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pMaximumInstantiationsPerProtectionObjective()
	 * @model default="3" unique="false"
	 * @generated
	 */
	int getL1pMaximumInstantiationsPerProtectionObjective();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pMaximumInstantiationsPerProtectionObjective <em>L1p Maximum Instantiations Per Protection Objective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Maximum Instantiations Per Protection Objective</em>' attribute.
	 * @see #getL1pMaximumInstantiationsPerProtectionObjective()
	 * @generated
	 */
	void setL1pMaximumInstantiationsPerProtectionObjective(int value);

	/**
	 * Returns the value of the '<em><b>L1p Main Search Maximum Depth</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The main search maximum depth.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Main Search Maximum Depth</em>' attribute.
	 * @see #setL1pMainSearchMaximumDepth(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pMainSearchMaximumDepth()
	 * @model default="3" unique="false"
	 * @generated
	 */
	int getL1pMainSearchMaximumDepth();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pMainSearchMaximumDepth <em>L1p Main Search Maximum Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Main Search Maximum Depth</em>' attribute.
	 * @see #getL1pMainSearchMaximumDepth()
	 * @generated
	 */
	void setL1pMainSearchMaximumDepth(int value);

	/**
	 * Returns the value of the '<em><b>L1p Multi Tree Multiplier</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multi-tree multiplier or a non-negative number to disable the multi-trees.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Multi Tree Multiplier</em>' attribute.
	 * @see #setL1pMultiTreeMultiplier(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pMultiTreeMultiplier()
	 * @model default="1.0" unique="false"
	 * @generated
	 */
	double getL1pMultiTreeMultiplier();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pMultiTreeMultiplier <em>L1p Multi Tree Multiplier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Multi Tree Multiplier</em>' attribute.
	 * @see #getL1pMultiTreeMultiplier()
	 * @generated
	 */
	void setL1pMultiTreeMultiplier(double value);

	/**
	 * Returns the value of the '<em><b>L1p Initial Alpha</b></em>' attribute.
	 * The default value is <code>"NaN"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The initial alpha value or <code>NaN</code> for infinity.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Initial Alpha</em>' attribute.
	 * @see #setL1pInitialAlpha(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pInitialAlpha()
	 * @model default="NaN" unique="false"
	 * @generated
	 */
	double getL1pInitialAlpha();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pInitialAlpha <em>L1p Initial Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Initial Alpha</em>' attribute.
	 * @see #getL1pInitialAlpha()
	 * @generated
	 */
	void setL1pInitialAlpha(double value);

	/**
	 * Returns the value of the '<em><b>L1p Initial Beta</b></em>' attribute.
	 * The default value is <code>"NaN"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The initial beta value or <code>NaN</code> for infinity.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Initial Beta</em>' attribute.
	 * @see #setL1pInitialBeta(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pInitialBeta()
	 * @model default="NaN" unique="false"
	 * @generated
	 */
	double getL1pInitialBeta();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pInitialBeta <em>L1p Initial Beta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Initial Beta</em>' attribute.
	 * @see #getL1pInitialBeta()
	 * @generated
	 */
	void setL1pInitialBeta(double value);

	/**
	 * Returns the value of the '<em><b>L1p Research Delta</b></em>' attribute.
	 * The default value is <code>"5000.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The research base delta.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Research Delta</em>' attribute.
	 * @see #setL1pResearchDelta(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pResearchDelta()
	 * @model default="5000.0" unique="false"
	 * @generated
	 */
	double getL1pResearchDelta();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pResearchDelta <em>L1p Research Delta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Research Delta</em>' attribute.
	 * @see #getL1pResearchDelta()
	 * @generated
	 */
	void setL1pResearchDelta(double value);

	/**
	 * Returns the value of the '<em><b>L1p Transposition Table Maximum Size</b></em>' attribute.
	 * The default value is <code>"1000000"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The transposition table maximum size or a non-positive value to disable them.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Transposition Table Maximum Size</em>' attribute.
	 * @see #setL1pTranspositionTableMaximumSize(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pTranspositionTableMaximumSize()
	 * @model default="1000000" unique="false"
	 * @generated
	 */
	int getL1pTranspositionTableMaximumSize();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pTranspositionTableMaximumSize <em>L1p Transposition Table Maximum Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Transposition Table Maximum Size</em>' attribute.
	 * @see #getL1pTranspositionTableMaximumSize()
	 * @generated
	 */
	void setL1pTranspositionTableMaximumSize(int value);

	/**
	 * Returns the value of the '<em><b>L1p Futility Margin</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The futility margin or a non-positive value to disable it.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Futility Margin</em>' attribute.
	 * @see #setL1pFutilityMargin(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pFutilityMargin()
	 * @model default="1.0" unique="false"
	 * @generated
	 */
	double getL1pFutilityMargin();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pFutilityMargin <em>L1p Futility Margin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Futility Margin</em>' attribute.
	 * @see #getL1pFutilityMargin()
	 * @generated
	 */
	void setL1pFutilityMargin(double value);

	/**
	 * Returns the value of the '<em><b>L1p Extended Futility Margin</b></em>' attribute.
	 * The default value is <code>"2.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The extended futility margin or a non-positive value to disable it.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Extended Futility Margin</em>' attribute.
	 * @see #setL1pExtendedFutilityMargin(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pExtendedFutilityMargin()
	 * @model default="2.0" unique="false"
	 * @generated
	 */
	double getL1pExtendedFutilityMargin();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pExtendedFutilityMargin <em>L1p Extended Futility Margin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Extended Futility Margin</em>' attribute.
	 * @see #getL1pExtendedFutilityMargin()
	 * @generated
	 */
	void setL1pExtendedFutilityMargin(double value);

	/**
	 * Returns the value of the '<em><b>L1p Razoring Margin</b></em>' attribute.
	 * The default value is <code>"4.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The razoring margin or a non-positive value to disable it.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Razoring Margin</em>' attribute.
	 * @see #setL1pRazoringMargin(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L1pRazoringMargin()
	 * @model default="4.0" unique="false"
	 * @generated
	 */
	double getL1pRazoringMargin();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL1pRazoringMargin <em>L1p Razoring Margin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Razoring Margin</em>' attribute.
	 * @see #getL1pRazoringMargin()
	 * @generated
	 */
	void setL1pRazoringMargin(double value);

	/**
	 * Returns the value of the '<em><b>L2p Solutions Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The number of the best first level solution on which the second level solution is inferred with the automatic build.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Solutions Count</em>' attribute.
	 * @see #setL2pSolutionsCount(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L2pSolutionsCount()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getL2pSolutionsCount();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL2pSolutionsCount <em>L2p Solutions Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Solutions Count</em>' attribute.
	 * @see #getL2pSolutionsCount()
	 * @generated
	 */
	void setL2pSolutionsCount(int value);

	/**
	 * Returns the value of the '<em><b>L2p Function Splitting Seed</b></em>' attribute.
	 * The default value is <code>"1106103861"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The seed to generate random function splitting, <=0 for casual seed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Function Splitting Seed</em>' attribute.
	 * @see #setL2pFunctionSplittingSeed(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L2pFunctionSplittingSeed()
	 * @model default="1106103861" unique="false"
	 * @generated
	 */
	int getL2pFunctionSplittingSeed();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL2pFunctionSplittingSeed <em>L2p Function Splitting Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Function Splitting Seed</em>' attribute.
	 * @see #getL2pFunctionSplittingSeed()
	 * @generated
	 */
	void setL2pFunctionSplittingSeed(int value);

	/**
	 * Returns the value of the '<em><b>L2p Start From L1p Solution</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Builds the L1P solution before starting.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Start From L1p Solution</em>' attribute.
	 * @see #setL2pStartFromL1pSolution(boolean)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L2pStartFromL1pSolution()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isL2pStartFromL1pSolution();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#isL2pStartFromL1pSolution <em>L2p Start From L1p Solution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Start From L1p Solution</em>' attribute.
	 * @see #isL2pStartFromL1pSolution()
	 * @generated
	 */
	void setL2pStartFromL1pSolution(boolean value);

	/**
	 * Returns the value of the '<em><b>L2p Solution Limit</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum number of solutions of the second level solution MIP model to be found, <=0 for no solution limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Solution Limit</em>' attribute.
	 * @see #setL2pSolutionLimit(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L2pSolutionLimit()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getL2pSolutionLimit();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL2pSolutionLimit <em>L2p Solution Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Solution Limit</em>' attribute.
	 * @see #getL2pSolutionLimit()
	 * @generated
	 */
	void setL2pSolutionLimit(int value);

	/**
	 * Returns the value of the '<em><b>L2p Time Limit</b></em>' attribute.
	 * The default value is <code>"60"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The time limit to solve the second level solution MIP model, <=0 for no time limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Time Limit</em>' attribute.
	 * @see #setL2pTimeLimit(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L2pTimeLimit()
	 * @model default="60" unique="false"
	 * @generated
	 */
	int getL2pTimeLimit();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL2pTimeLimit <em>L2p Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Time Limit</em>' attribute.
	 * @see #getL2pTimeLimit()
	 * @generated
	 */
	void setL2pTimeLimit(int value);

	/**
	 * Returns the value of the '<em><b>L2p Gap Limit</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The gap (relative distance between the actual solution and the possible best solution) limit to solve the second level solution MIP model, <=0 for no gap limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Gap Limit</em>' attribute.
	 * @see #setL2pGapLimit(double)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L2pGapLimit()
	 * @model default="0" unique="false"
	 * @generated
	 */
	double getL2pGapLimit();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL2pGapLimit <em>L2p Gap Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Gap Limit</em>' attribute.
	 * @see #getL2pGapLimit()
	 * @generated
	 */
	void setL2pGapLimit(double value);

	/**
	 * Returns the value of the '<em><b>L2p Upper Bound</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum number of time a non singleton protection instantiation can be applied to an application part
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Upper Bound</em>' attribute.
	 * @see #setL2pUpperBound(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L2pUpperBound()
	 * @model default="2" unique="false"
	 * @generated
	 */
	int getL2pUpperBound();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL2pUpperBound <em>L2p Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Upper Bound</em>' attribute.
	 * @see #getL2pUpperBound()
	 * @generated
	 */
	void setL2pUpperBound(int value);

	/**
	 * Returns the value of the '<em><b>L2p Function Splitting Medium Code Block Length</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum length that a code block must have in order to be further splitted, <= 0 in order to generate an application part for every code block.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Function Splitting Medium Code Block Length</em>' attribute.
	 * @see #setL2pFunctionSplittingMediumCodeBlockLength(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L2pFunctionSplittingMediumCodeBlockLength()
	 * @model default="2" unique="false"
	 * @generated
	 */
	int getL2pFunctionSplittingMediumCodeBlockLength();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL2pFunctionSplittingMediumCodeBlockLength <em>L2p Function Splitting Medium Code Block Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Function Splitting Medium Code Block Length</em>' attribute.
	 * @see #getL2pFunctionSplittingMediumCodeBlockLength()
	 * @generated
	 */
	void setL2pFunctionSplittingMediumCodeBlockLength(int value);

	/**
	 * Returns the value of the '<em><b>L2p Function Splitting Code Block Length Randomization Denominator</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a value > 0 is passed, the length of the generated blocks will be random between (minimumCodeBlockLength-+inf(minimumCodeBlockLength/codeBlockLengthRandomizationDenominator)), otherwise all the generated blocks will be long at most minimumCodeBlockLength lines; in any case the last block generated may be less long than the specified interval.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Function Splitting Code Block Length Randomization Denominator</em>' attribute.
	 * @see #setL2pFunctionSplittingCodeBlockLengthRandomizationDenominator(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L2pFunctionSplittingCodeBlockLengthRandomizationDenominator()
	 * @model default="2" unique="false"
	 * @generated
	 */
	int getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator <em>L2p Function Splitting Code Block Length Randomization Denominator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Function Splitting Code Block Length Randomization Denominator</em>' attribute.
	 * @see #getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator()
	 * @generated
	 */
	void setL2pFunctionSplittingCodeBlockLengthRandomizationDenominator(int value);

	/**
	 * Returns the value of the '<em><b>L2p Function Splitting Depth Level</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The desired function splitting depth level, <=0 for no limit on depth level.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Function Splitting Depth Level</em>' attribute.
	 * @see #setL2pFunctionSplittingDepthLevel(int)
	 * @see it.polito.security.esp.kb.KbPackage#getPreferences_L2pFunctionSplittingDepthLevel()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getL2pFunctionSplittingDepthLevel();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Preferences#getL2pFunctionSplittingDepthLevel <em>L2p Function Splitting Depth Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Function Splitting Depth Level</em>' attribute.
	 * @see #getL2pFunctionSplittingDepthLevel()
	 * @generated
	 */
	void setL2pFunctionSplittingDepthLevel(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 * @generated
	 */
	int hashCode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Compares another object with the current one.
	 * <!-- end-model-doc -->
	 * @model unique="false" objectUnique="false"
	 * @generated
	 */
	boolean equals(Object object);

} // Preferences
