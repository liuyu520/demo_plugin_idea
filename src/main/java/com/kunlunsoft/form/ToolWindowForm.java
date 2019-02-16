package com.kunlunsoft.form;

import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;

public class ToolWindowForm {
    private JTextField textField1;
    private JPanel rootPanel;
    ToolWindow toolWindow;

    public ToolWindowForm(ToolWindow toolWindow) {
        this.toolWindow = toolWindow;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
