package com.kunlunsoft.project.wizard.better;

import com.intellij.icons.AllIcons;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.ModuleTypeManager;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class DemoModuleType extends ModuleType<DemoModuleBuilder> {
    private static final String ID = "DEMO_MODULE_TYPE";

    public DemoModuleType() {
        super(ID);
    }

    public static DemoModuleType getInstance() {
        return (DemoModuleType) ModuleTypeManager.getInstance().findByID(ID);
    }

    @NotNull
    @Override
    public DemoModuleBuilder createModuleBuilder() {
        return new DemoModuleBuilder();
    }

    @NotNull
    @Override
    public String getName() {
        return "AECP Application";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "AECP Application description";
    }


    @Override
    public Icon getNodeIcon(@Deprecated boolean b) {
        return AllIcons.General.Information;//this.getClass().getResource("")
    }

    @NotNull
    @Override
    public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext, @NotNull DemoModuleBuilder moduleBuilder, @NotNull ModulesProvider modulesProvider) {
        return super.createWizardSteps(wizardContext, moduleBuilder, modulesProvider);
    }
}
