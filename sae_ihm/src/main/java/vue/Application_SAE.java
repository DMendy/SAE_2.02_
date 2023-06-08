package vue;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * constructeur de la classe
 */
public class Application_SAE extends Application {
    public void start(Stage stage) {
        VBox root = new VBoxRoot();
        Scene scene = new Scene(root, 400, 380);
        stage.setScene(scene);
        stage.setTitle("Partie_Mario");
        stage.setWidth(1200);
        stage.setHeight(500);
        stage.show();
    }
    public static void main (String [] args) {
        Application.launch(args);
    }
}
