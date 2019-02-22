package com.kunlunsoft;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.demo.examples.webbrowser.SimpleWebBrowserExample;

import javax.swing.*;

/**
 * 类描述: TODO 请添加注释. <br />
 *
 * @author hanjun.hw
 * @since 2019/2/19
 */
public class Main {

    public static void main(String[] args) {
        NativeInterface.open();
        UIUtils.setPreferredLookAndFeel();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("DJ Native Swing Test");
                frame.setDefaultCloseOperation(3);
                frame.getContentPane().add(SimpleWebBrowserExample.createContent(), "Center");
                frame.setSize(800, 600);
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
            }
        });
        NativeInterface.runEventPump();
    }
}
