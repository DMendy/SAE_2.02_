package modele;
import java.io.File;


public class ClientAlgo {
    public static void main(String[] args) {
        File f = new File("scenarios" + File.separator + "scenario_1.txt");
        EnsembleQuetes scenario = LectureFichierTexte.lecture(f);
        System.out.println(Algo.afficheAlgoGloutonEx(scenario));

    }
}