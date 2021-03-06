/**
 * generated by Xtext 2.12.0
 */
package it.polito.security.esp.rulesLanguage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see it.polito.security.esp.rulesLanguage.RulesLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface RulesLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "rulesLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://security.polito.it/esp/RulesLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "rulesLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  RulesLanguagePackage eINSTANCE = it.polito.security.esp.rulesLanguage.impl.RulesLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link it.polito.security.esp.rulesLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.polito.security.esp.rulesLanguage.impl.ModelImpl
   * @see it.polito.security.esp.rulesLanguage.impl.RulesLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Rules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__RULES = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link it.polito.security.esp.rulesLanguage.impl.RuleImpl <em>Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.polito.security.esp.rulesLanguage.impl.RuleImpl
   * @see it.polito.security.esp.rulesLanguage.impl.RulesLanguagePackageImpl#getRule()
   * @generated
   */
  int RULE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__NAME = 0;

  /**
   * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__CONDITIONS = 1;

  /**
   * The feature id for the '<em><b>Action</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__ACTION = 2;

  /**
   * The number of structural features of the '<em>Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link it.polito.security.esp.rulesLanguage.impl.ConditionImpl <em>Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.polito.security.esp.rulesLanguage.impl.ConditionImpl
   * @see it.polito.security.esp.rulesLanguage.impl.RulesLanguagePackageImpl#getCondition()
   * @generated
   */
  int CONDITION = 2;

  /**
   * The number of structural features of the '<em>Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link it.polito.security.esp.rulesLanguage.impl.FunctionDeclarationImpl <em>Function Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.polito.security.esp.rulesLanguage.impl.FunctionDeclarationImpl
   * @see it.polito.security.esp.rulesLanguage.impl.RulesLanguagePackageImpl#getFunctionDeclaration()
   * @generated
   */
  int FUNCTION_DECLARATION = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DECLARATION__NAME = CONDITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DECLARATION__PARAMETERS = CONDITION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Function Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DECLARATION_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link it.polito.security.esp.rulesLanguage.ParameterType <em>Parameter Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.polito.security.esp.rulesLanguage.ParameterType
   * @see it.polito.security.esp.rulesLanguage.impl.RulesLanguagePackageImpl#getParameterType()
   * @generated
   */
  int PARAMETER_TYPE = 4;

  /**
   * The meta object id for the '{@link it.polito.security.esp.rulesLanguage.Action <em>Action</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.polito.security.esp.rulesLanguage.Action
   * @see it.polito.security.esp.rulesLanguage.impl.RulesLanguagePackageImpl#getAction()
   * @generated
   */
  int ACTION = 5;


  /**
   * Returns the meta object for class '{@link it.polito.security.esp.rulesLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see it.polito.security.esp.rulesLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link it.polito.security.esp.rulesLanguage.Model#getRules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rules</em>'.
   * @see it.polito.security.esp.rulesLanguage.Model#getRules()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Rules();

  /**
   * Returns the meta object for class '{@link it.polito.security.esp.rulesLanguage.Rule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule</em>'.
   * @see it.polito.security.esp.rulesLanguage.Rule
   * @generated
   */
  EClass getRule();

  /**
   * Returns the meta object for the attribute '{@link it.polito.security.esp.rulesLanguage.Rule#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see it.polito.security.esp.rulesLanguage.Rule#getName()
   * @see #getRule()
   * @generated
   */
  EAttribute getRule_Name();

  /**
   * Returns the meta object for the containment reference list '{@link it.polito.security.esp.rulesLanguage.Rule#getConditions <em>Conditions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Conditions</em>'.
   * @see it.polito.security.esp.rulesLanguage.Rule#getConditions()
   * @see #getRule()
   * @generated
   */
  EReference getRule_Conditions();

  /**
   * Returns the meta object for the attribute '{@link it.polito.security.esp.rulesLanguage.Rule#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Action</em>'.
   * @see it.polito.security.esp.rulesLanguage.Rule#getAction()
   * @see #getRule()
   * @generated
   */
  EAttribute getRule_Action();

  /**
   * Returns the meta object for class '{@link it.polito.security.esp.rulesLanguage.Condition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Condition</em>'.
   * @see it.polito.security.esp.rulesLanguage.Condition
   * @generated
   */
  EClass getCondition();

  /**
   * Returns the meta object for class '{@link it.polito.security.esp.rulesLanguage.FunctionDeclaration <em>Function Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Declaration</em>'.
   * @see it.polito.security.esp.rulesLanguage.FunctionDeclaration
   * @generated
   */
  EClass getFunctionDeclaration();

  /**
   * Returns the meta object for the attribute '{@link it.polito.security.esp.rulesLanguage.FunctionDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see it.polito.security.esp.rulesLanguage.FunctionDeclaration#getName()
   * @see #getFunctionDeclaration()
   * @generated
   */
  EAttribute getFunctionDeclaration_Name();

  /**
   * Returns the meta object for the attribute list '{@link it.polito.security.esp.rulesLanguage.FunctionDeclaration#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Parameters</em>'.
   * @see it.polito.security.esp.rulesLanguage.FunctionDeclaration#getParameters()
   * @see #getFunctionDeclaration()
   * @generated
   */
  EAttribute getFunctionDeclaration_Parameters();

  /**
   * Returns the meta object for enum '{@link it.polito.security.esp.rulesLanguage.ParameterType <em>Parameter Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Parameter Type</em>'.
   * @see it.polito.security.esp.rulesLanguage.ParameterType
   * @generated
   */
  EEnum getParameterType();

  /**
   * Returns the meta object for enum '{@link it.polito.security.esp.rulesLanguage.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Action</em>'.
   * @see it.polito.security.esp.rulesLanguage.Action
   * @generated
   */
  EEnum getAction();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  RulesLanguageFactory getRulesLanguageFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link it.polito.security.esp.rulesLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.polito.security.esp.rulesLanguage.impl.ModelImpl
     * @see it.polito.security.esp.rulesLanguage.impl.RulesLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__RULES = eINSTANCE.getModel_Rules();

    /**
     * The meta object literal for the '{@link it.polito.security.esp.rulesLanguage.impl.RuleImpl <em>Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.polito.security.esp.rulesLanguage.impl.RuleImpl
     * @see it.polito.security.esp.rulesLanguage.impl.RulesLanguagePackageImpl#getRule()
     * @generated
     */
    EClass RULE = eINSTANCE.getRule();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE__NAME = eINSTANCE.getRule_Name();

    /**
     * The meta object literal for the '<em><b>Conditions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE__CONDITIONS = eINSTANCE.getRule_Conditions();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE__ACTION = eINSTANCE.getRule_Action();

    /**
     * The meta object literal for the '{@link it.polito.security.esp.rulesLanguage.impl.ConditionImpl <em>Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.polito.security.esp.rulesLanguage.impl.ConditionImpl
     * @see it.polito.security.esp.rulesLanguage.impl.RulesLanguagePackageImpl#getCondition()
     * @generated
     */
    EClass CONDITION = eINSTANCE.getCondition();

    /**
     * The meta object literal for the '{@link it.polito.security.esp.rulesLanguage.impl.FunctionDeclarationImpl <em>Function Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.polito.security.esp.rulesLanguage.impl.FunctionDeclarationImpl
     * @see it.polito.security.esp.rulesLanguage.impl.RulesLanguagePackageImpl#getFunctionDeclaration()
     * @generated
     */
    EClass FUNCTION_DECLARATION = eINSTANCE.getFunctionDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_DECLARATION__NAME = eINSTANCE.getFunctionDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_DECLARATION__PARAMETERS = eINSTANCE.getFunctionDeclaration_Parameters();

    /**
     * The meta object literal for the '{@link it.polito.security.esp.rulesLanguage.ParameterType <em>Parameter Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.polito.security.esp.rulesLanguage.ParameterType
     * @see it.polito.security.esp.rulesLanguage.impl.RulesLanguagePackageImpl#getParameterType()
     * @generated
     */
    EEnum PARAMETER_TYPE = eINSTANCE.getParameterType();

    /**
     * The meta object literal for the '{@link it.polito.security.esp.rulesLanguage.Action <em>Action</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.polito.security.esp.rulesLanguage.Action
     * @see it.polito.security.esp.rulesLanguage.impl.RulesLanguagePackageImpl#getAction()
     * @generated
     */
    EEnum ACTION = eINSTANCE.getAction();

  }

} //RulesLanguagePackage
