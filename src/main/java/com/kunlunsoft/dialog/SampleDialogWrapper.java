package com.kunlunsoft.dialog;

import com.intellij.openapi.ui.DialogWrapper;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.print.PrinterJob;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.*;
import java.awt.*;
import java.security.GeneralSecurityException;

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


        final JFXPanel fxPanel = new JFXPanel();

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


            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(
                                java.security.cert.X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(
                                java.security.cert.X509Certificate[] certs, String authType) {
                        }
                    }
            };

// Install the all-trusting trust manager
            try {
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            } catch (GeneralSecurityException e) {
            }

            WebView webView = new WebView();
            webView.getEngine().setJavaScriptEnabled(true);
            webView.getEngine().load("https://bpms.alibaba-inc.com/");
            webView.getEngine().getLoadWorker().stateProperty().addListener(
                    new ChangeListener<Worker.State>() {
                        @Override
                        public void changed(ObservableValue ov,
                                            Worker.State oldState, Worker.State newState) {
                            System.out.println(" :" + ov.getValue() + ",");
                            System.out.println(webView.getEngine().getLoadWorker().exceptionProperty());
                            if (newState == Worker.State.SUCCEEDED) {
                                PrinterJob job = PrinterJob.createPrinterJob();
                                if (job != null) {
                                    webView.getEngine().print(job);
//                                    job.endJob();
                                }
                            }
                        }
                    });


            fxPanel.setScene(new Scene(webView));

//            fxPanel.setScene(scene);
        });
        dialogPanel.add(fxPanel);

        return dialogPanel;
    }
}
