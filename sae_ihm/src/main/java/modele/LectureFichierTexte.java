package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LectureFichierTexte {
    /**
     * lis un fichier EnsembleQuetes. Crée le scénario avec ses quetes
     *
     * @param fichier (File): le fichier du scénario
     * @return  L'objet EnsembleQuetes : si le fichier existe
     *          Null             : si le fichier n'existe pas
     */
    public static EnsembleQuetes lecture(File fichier) {
        try {
            Scanner scanner = new Scanner(fichier);
            EnsembleQuetes EnsembleQuetes = new EnsembleQuetes(fichier.getName());
            while (scanner.hasNext()) {
                Quete quete = new Quete(scanner.nextLine());
                EnsembleQuetes.ajout(quete);
            }
            return EnsembleQuetes;
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
