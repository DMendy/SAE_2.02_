package modele;

import java.io.File;

public class ClientAlgo {
    public static void main(String[] args) {
        // Spécifiez le chemin vers votre fichier de scénario
        File f = new File("scenarios" + File.separator + "scenario_1.txt");
        
        // Lecture du fichier de scénario
        EnsembleQuetes scenario = LectureFichierTexte.lecture(f);
        
        // Affichage de la résolution du scénario avec l'algorithme glouton
        System.out.println(Algo.afficheAlgoGloutonEx(scenario));
    }
}
