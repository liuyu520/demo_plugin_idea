package com.kunlunsoft.form;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.wm.ToolWindow;
import com.swing.messagebox.GUIUtil23;

import javax.swing.*;

public class ToolWindowForm {
    private JTextField appIdTextField1;
    private JPanel rootPanel;
    private JTextField appNameTextField2;
    private JButton saveButton;
    private JButton cancelButton;
    private JTextArea textArea1;

    private ToolWindow toolWindow;
    private Project project;

    public ToolWindowForm(ToolWindow toolWindow, Project project) {
        this.project = project;
        this.toolWindow = toolWindow;
        cancelButton.addActionListener(e -> toolWindow.hide(null));
        saveButton.addActionListener(e -> {
            String appId = appIdTextField1.getText();
            String appName = appNameTextField2.getText();
            GUIUtil23.infoDialog(String.format("appId:%s,appName:%s", appId, appName));

            if (null != project) {
                Messages.showMessageDialog(project, "Hello world!22222", "Greeting22222", Messages.getInformationIcon());
            }
            if (null != toolWindow) {
                toolWindow.hide(null);
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
