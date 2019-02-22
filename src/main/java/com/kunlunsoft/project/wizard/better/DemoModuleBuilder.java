package com.kunlunsoft.project.wizard.better;

import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import com.kunlunsoft.form.ProjectCreateWizardFrom;
import com.kunlunsoft.form.ToolWindowForm;

import javax.swing.*;

public class DemoModuleBuilder extends ModuleBuilder {
    @Override
    public void setupRootModel(ModifiableRootModel model) throws ConfigurationException {

    }

    @Override
    public ModuleType getModuleType() {
        return DemoModuleType.getInstance();
    }

    /**
     * 只能返回一个步骤,优先级比 createWizardSteps 高
     *
     * @param context
     * @param parentDisposable
     * @return
     */
    /*@Nullable
    @Override
    public ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
        return new DemoModuleWizardJustStep();
    }*/

    /**
     * 优先级比 getCustomOptionsStep 低
     *
     * @param wizardContext
     * @param modulesProvider
     * @return
     */
    @Override
    public ModuleWizardStep[] createWizardSteps(WizardContext wizardContext, ModulesProvider modulesProvider) {
        return new ModuleWizardStep[]{new ModuleWizardStep() {//第一个步骤
            @Override
            public JComponent getComponent() {
                ProjectCreateWizardFrom projectCreateWizardFrom = new ProjectCreateWizardFrom();
                return projectCreateWizardFrom.getRootPanel();
            }

            @Override
            public void updateDataModel() {
            }
        },
                new ModuleWizardStep() {//第二个步骤
                    @Override
                    public JComponent getComponent() {
                        ToolWindowForm toolWindowForm = new ToolWindowForm(null, null);
                        return toolWindowForm.getRootPanel();
                    }

                    @Override
                    public void updateDataModel() {
                    }
                }
        };
    }
}
