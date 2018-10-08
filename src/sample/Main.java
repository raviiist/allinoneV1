package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main extends Application {

    private Object TestScene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("All In One");
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }

/*    String configFile="/home/ravi/Documents/allinone/config.inp";
    Path congFlPath= Paths.get(configFile);
    Controller c = new Controller();*/

    public static void main(String[] args) {
        launch(args);
    }
    /*sample.Controller c1 = new Controller();
    c1.testmethod();*/          //WHY it didn't work??

}
