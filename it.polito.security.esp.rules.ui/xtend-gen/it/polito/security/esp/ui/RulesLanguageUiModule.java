/**
 * generated by Xtext 2.10.0
 */
package it.polito.security.esp.ui;

import it.polito.security.esp.ui.AbstractRulesLanguageUiModule;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class RulesLanguageUiModule extends AbstractRulesLanguageUiModule {
  @Override
  public Class<? extends IXtextEditorCallback> bindIXtextEditorCallback() {
    return IXtextEditorCallback.NullImpl.class;
  }
  
  public RulesLanguageUiModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
}