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


import java.io.IOException;
import java.util.Optional;

public class TestScene {
    @FXML
    private Button scene2b1;
    @FXML
    private Hyperlink closeLinkscene1;


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
