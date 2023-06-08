package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.Algo;
import modele.EnsembleQuetes;
import modele.LectureFichierTexte;

import java.io.File;
import java.util.ArrayList;

public class VBoxRoot extends VBox {


    public VBoxRoot() {
        String [] listeScenario = new String[11];
        VBox BoiteScenario = new VBox();
        for (Integer i = 0; i < 11; i++) {
            String scenarionum=new String("scenario_" + i.toString());
            listeScenario[i]=scenarionum;
        }
        ComboBox comboBoxScenario = peubleComboBox(listeScenario);

        HBox HBoxbutton = new HBox();
        Button Exhaustive = new Button("Solution exhaustive");
        Button Efficace = new Button("Solution Efficace");
        HBoxbutton.getChildren().addAll(Exhaustive,Efficace);
        Exhaustive.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                File f = new File("scenarios" + File.separator + comboBoxScenario.getSelectionModel().getSelectedItem().toString()+".txt");
                EnsembleQuetes scenario = LectureFichierTexte.lecture(f);
                System.out.println("\n");
                System.out.println(comboBoxScenario.getSelectionModel().getSelectedItem().toString());
                System.out.println("Solution Exhaustive");
                Algo.algoGloutonEx(scenario);
            }
        });
        Efficace.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                File f = new File("scenarios" + File.separator + comboBoxScenario.getSelectionModel().getSelectedItem().toString()+".txt");
                EnsembleQuetes scenario = LectureFichierTexte.lecture(f);

                System.out.println("\n");
                System.out.println(comboBoxScenario.getSelectionModel().getSelectedItem().toString());
                System.out.println("Solution Efficace");
                Algo.algoGloutonEff(scenario);
            }
        });
        getChildren().addAll(comboBoxScenario,HBoxbutton);


    }

    private ComboBox<String> peubleComboBox(String [] strings) {
        ComboBox<String> comboBox = new ComboBox();
        for(String string: strings){
            comboBox.getItems().add(string);

        }
        comboBox.getSelectionModel().select(1);
        return comboBox;
    }
}
