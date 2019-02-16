package com.kunlunsoft.dialog;

import com.intellij.openapi.ui.DialogWrapper;

import javax.swing.*;
import java.awt.*;

public class SampleDialogWrapper extends DialogWrapper {
    public SampleDialogWrapper() {
        super(true); // use current window as parent
        init();
        setTitle("Test DialogWrapper");
    }

    @Override
    protected JComponent createCenterPanel() {
        JPanel dialogPanel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("testing");
        label.setPreferredSize(new Dimension(100, 100));
        dialogPanel.add(label, BorderLayout.CENTER);

        return dialogPanel;
    }
}
