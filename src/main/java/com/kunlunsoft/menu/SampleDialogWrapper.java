package com.kunlunsoft.menu;

import com.intellij.openapi.ui.DialogWrapper;
import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.print.PrinterJob;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
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
        label.setPreferredSize(new Dimension(400, 300));
//        dialogPanel.add(label, BorderLayout.CENTER);


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
                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        @Override
                        public void checkClientTrusted(
                                java.security.cert.X509Certificate[] certs, String authType) {
                        }

                        @Override
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

            WebEngine webEngine = webView.getEngine();
            webEngine.setOnAlert(event -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Message from the web page");
                alert.setContentText(event.getData());
                alert.showAndWait();
            });


            webView.getEngine().load("https://bpms.alibaba-inc.com/processmgr/v2/homepage?__redirect__=false");
            webView.getEngine().getLoadWorker().stateProperty().addListener(
                    (ov, oldState, newState) -> {
                        System.out.println(" :" + ov.getValue() + ",");
                        System.out.println(webView.getEngine().getLoadWorker().exceptionProperty());
                        if (newState == Worker.State.SUCCEEDED) {
                            PrinterJob job = PrinterJob.createPrinterJob();
                            if (job != null) {
                                webView.getEngine().print(job);
//                                    job.endJob();
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
