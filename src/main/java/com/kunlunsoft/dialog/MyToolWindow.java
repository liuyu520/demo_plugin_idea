package com.kunlunsoft.dialog;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class MyToolWindow implements ToolWindowFactory {
    /**
     * important
     *
     * @param project
     * @param toolWindow
     */
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        /*ToolWindowForm myToolWindow = new ToolWindowForm(toolWindow, project);
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(myToolWindow.getRootPanel(), "", false);
        toolWindow.getContentManager().addContent(content);*/


        final JFXPanel fxPanel = new JFXPanel();
        JComponent component = toolWindow.getComponent();

        Platform.setImplicitExit(false);
        Platform.runLater(() -> {
            Group root = new Group();
//            Scene scene  =  new  Scene(root, Color.ALICEBLUE);
            Text text = new Text();

            text.setX(40);
            text.setY(100);
            text.setFont(new Font(25));
            text.setText("Welcome JavaFX!");

            root.getChildren().add(text);

            WebView webView = new WebView();
            webView.getEngine().load("https://bpms-test.alibaba-inc.com/processdesigner/newProcDesign?processId=807764092");

            fxPanel.setScene(new Scene(webView));

//            fxPanel.setScene(scene);
        });

        component.getParent().add(fxPanel);
    }

    @Override
    public void init(ToolWindow window) {

    }

    @Override
    public boolean shouldBeAvailable(@NotNull Project project) {
        return true;
    }

    @Override
    public boolean isDoNotActivateOnStart() {
        return false;
    }
}
