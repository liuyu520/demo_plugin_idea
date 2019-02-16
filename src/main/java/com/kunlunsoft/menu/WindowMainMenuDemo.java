package com.kunlunsoft.menu;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.kunlunsoft.dialog.SampleDialogWrapper;

public class WindowMainMenuDemo extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Project project = e.getProject();
        /*  Messages.showMessageDialog(project, "Hello world!22222", "Greeting22222", Messages.getInformationIcon());*/

        boolean result = new SampleDialogWrapper().showAndGet();
        if (result) {
            // user pressed ok
            Messages.showMessageDialog(project, "user pressed ok", "Greeting", Messages.getInformationIcon());
        } else {
            //press cancel
        }

    }
}
