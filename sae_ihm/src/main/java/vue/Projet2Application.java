package vue;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

/**
 * constructeur de la classe
 */
public class Projet2Application extends Application {
    public void start(Stage stage) {
        VBox root = new VBoxRoot();
        Scene scene = new Scene(root, 400, 380);
        stage.setScene(scene);
        stage.setTitle("Calendrier du mois");
        stage.setWidth(1200);
        stage.setHeight(500);
        stage.show();
    }
    public static void main (String [] args) {
        Application.launch(args);
    }
}
