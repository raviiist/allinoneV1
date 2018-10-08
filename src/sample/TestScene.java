package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TestScene {
    @FXML
    private Button scene2b1;

    @FXML
    void switch2Scene1(ActionEvent event) throws IOException {
        Parent scene1Parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene1 = new Scene(scene1Parent);
        System.out.println("Switching scenes");
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
}
