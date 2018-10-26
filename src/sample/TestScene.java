package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class TestScene {
    @FXML
    private Button scene2b1;
    @FXML
    private Hyperlink closeLinkscene1;
    @FXML
    private TextField cmdLine;
    @FXML
    private TextArea textOut;

    @FXML
    void switch2Scene1(ActionEvent event) throws IOException {
        Parent scene1Parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene1 = new Scene(scene1Parent);
        System.out.println("Switching scenes");
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();

    }
    @FXML
    void executeCmd(ActionEvent event) {
        String cmdline=cmdLine.getText();
        String[] cmds = {cmdline,"-send"};
        String[] cmds1 = {"/bin/sh", "-c",cmdline};     //ping -c 3 google.com      Use this cmd :)
        System.out.println("Command: "+cmdline);
        //Here is one method...
        /*try {
            Process p = Runtime.getRuntime().exec(cmds1);
            p.waitFor();
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                //System.out.println("Output:");
                String s = null;
                while ((s = stdInput.readLine()) != null) {
                    System.out.println(s);
                    textOut.appendText(s+"\n");
                }
                //System.out.println("Output(if any error):");
                while ((s = stdError.readLine()) != null) {
                    System.out.println(s);
                    textOut.appendText(s+"\n");
                }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //Here is another method(better)...
        ProcessBuilder builder = new ProcessBuilder(cmds1);
        builder.redirectErrorStream(true);

        Process process = null;
        try {
            process = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
                /*InputStream is = process.getInputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line = null;

                try {
                while ((line = reader.readLine()) != null) {
                System.out.println(line);
                textOut.appendText(line+"\n");
                }
                } catch (IOException e) {
                e.printStackTrace();
                //Logger.getLogger(Documents.class.getName()).log(Level.SEVERE, null, e);
                }*/
                Path outStream = Paths.get("/home/ravi/temp1.txt");
                BufferedReader reader1 = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line1 = null;
                //BufferedWriter writer2 = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(outStream,CREATE, APPEND)));
        try {
            while ((line1 = reader1.readLine()) != null) {
                System.out.println(line1);
                //writer2.write("\n" + line1, 0, line1.getBytes().length);
                //textOut.appendText(line1+"\n");
                PrintStream printStream = new PrintStream(new CustomOutputStream(textOut));
                System.setOut(printStream);
                System.setErr(printStream);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        cmdLine.clear();
    }

    class CustomOutputStream extends OutputStream {
        public CustomOutputStream(TextArea textArea) {
        textOut = textArea;
        }
        @Override
        public void write(int b) throws IOException {
        // redirects data to the text area
        textOut.appendText(String.valueOf((char)b));
        // scrolls the text area to the end of data
        //textOut.setCaretPosition(textOut.getDocument().getLength());
        }
    }

    @FXML
    void closeScene1(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm?");
        alert.setHeaderText("Are you sure you want to close this window?");
        //alert.setContentText("Choose your option.");
        alert.setContentText("");
        ButtonType buttonTypeOne = new ButtonType("Yes");
        ButtonType buttonTypeCancel = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

        //This changes the alert box look up as css style...
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
        getClass().getResource("testStyle.css").toExternalForm());

        Thread thread = new Thread(() -> {
            try {
                // Wait for 10 secs
                Thread.sleep(10000);
                if (alert.isShowing()) {
                    Platform.runLater(() -> alert.close());
                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
        //Optional<ButtonType> result = alert.showAndWait();
        alert.showAndWait();

        if(alert.getResult().equals(buttonTypeOne)) {
            System.out.println("yes");
            System.exit(0);
        }
        System.out.println(alert.getResult().equals(buttonTypeOne));
    }
}



//NOTE:
/* /usr/bin/libreoffice --headless --convert-to pdf:'writer_pdf_Export' --outdir /home/ravi/Documents/ /home/ravi/Documents/Untitled1.txt
*  host -t a google.com
 * ping -c 3 google.com
  *
  * */