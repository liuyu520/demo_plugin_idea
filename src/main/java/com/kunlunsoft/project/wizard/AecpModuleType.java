package com.kunlunsoft.project.wizard;

import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.openapi.module.ModuleType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AecpModuleType extends ModuleType<ModuleBuilder> {
    private ModuleBuilder firstModuleBuilder;

    protected AecpModuleType(@NotNull String id) {
        super(id);
    }

    public AecpModuleType(@NotNull String id, ModuleBuilder firstModuleBuilder) {
        super(id);
        this.firstModuleBuilder = firstModuleBuilder;
    }

    public ModuleBuilder getFirstModuleBuilder() {
        return firstModuleBuilder;
    }

    public void setFirstModuleBuilder(ModuleBuilder firstModuleBuilder) {
        this.firstModuleBuilder = firstModuleBuilder;
    }

    @NotNull
    @Override
    public ModuleBuilder createModuleBuilder() {
        return firstModuleBuilder;// DemoModuleWizardStep.this;
    }

    @NotNull
    @Override
    public String getName() {
        return "Aecp 项目";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Aecp 项目 描述";
    }

    @Override
    public Icon getNodeIcon(boolean isOpened) {
        return null;
    }
}
