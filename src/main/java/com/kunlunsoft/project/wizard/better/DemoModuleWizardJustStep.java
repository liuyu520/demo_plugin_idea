package com.kunlunsoft.project.wizard.better;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;

import javax.swing.*;

public class DemoModuleWizardJustStep extends ModuleWizardStep {
    @Override
    public JComponent getComponent() {
        return new JLabel("222###Provide some setting here");
    }

    @Override
    public void updateDataModel() {
        //todo update model according to UI
    }
}
