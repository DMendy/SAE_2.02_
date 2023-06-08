package modele;

import java.util.Arrays;

public class Algo {


    public static void algoGloutonEx(EnsembleQuetes parEnsembleQuetes) {
        Chemin chChemin = new Chemin(parEnsembleQuetes);
        chChemin.setChexp(0);
        while (chChemin.getQuetesNonFaite().size() > 0) {
            for (Quete quete : parEnsembleQuetes.getTreeEnsembleQuetes()) {
                if (quete.quetePossible(chChemin.getQuetesFaite()) == true && quete.getNumero() != 0) {
                    chChemin.ajouteQueteFaite(quete);
                    chChemin.ajoutexp(quete.getExperience());
                }
            }
        }
        chChemin.ajouteQueteFaite(chChemin.getQueteFin());
        for (Quete quete1 : chChemin.getQuetesFaite().values()) {
            System.out.println("\n");
            System.out.println("Se deplace en"+ Arrays.toString(quete1.getPos()));
            System.out.println("quete "+quete1.getNumero()+": "+quete1.getIntitule());
        }
    }


    public static void algoGloutonEff(EnsembleQuetes parEnsembleQuetes) {
        Chemin chChemin = new Chemin(parEnsembleQuetes);
        chChemin.setChexp(0);
        while (!chChemin.queteFinPossibleEfficace()) {
            for (Quete quete : parEnsembleQuetes.getTreeEnsembleQuetes()) {
                if (quete.quetePossible(chChemin.getQuetesFaite()) == true && quete.getNumero() != 0) {
                    chChemin.ajoutexp(quete.getExperience());
                    chChemin.ajouteQueteFaite(quete);
                }
            }
        }
        chChemin.ajouteQueteFaite(chChemin.getQueteFin());
        for (Quete quete1 : chChemin.getQuetesFaite().values()) {
            System.out.println("\n");
            System.out.println("Se deplace en"+ Arrays.toString(quete1.getPos()));
            System.out.println("quete "+quete1.getNumero()+": "+quete1.getIntitule());
        }
    }
    public static String afficheAlgoGloutonEff(EnsembleQuetes parEnsembleQuetes) {
        Chemin chChemin = new Chemin(parEnsembleQuetes);
        chChemin.setChexp(0);
        while (!chChemin.queteFinPossibleEfficace()) {
            for (Quete quete : parEnsembleQuetes.getTreeEnsembleQuetes()) {
                if (quete.quetePossible(chChemin.getQuetesFaite()) == true && quete.getNumero() != 0) {
                    chChemin.ajoutexp(quete.getExperience());
                    chChemin.ajouteQueteFaite(quete);
                }
            }
        }
        chChemin.ajouteQueteFaite(chChemin.getQueteFin());
        return chChemin.getQuetesFaite().values().toString();
    }
    public static String afficheAlgoGloutonEx(EnsembleQuetes parEnsembleQuetes) {
        Chemin chChemin = new Chemin(parEnsembleQuetes);
        chChemin.setChexp(0);
        while (chChemin.getQuetesNonFaite().size() > 0) {
            for (Quete quete : parEnsembleQuetes.getTreeEnsembleQuetes()) {
                if (quete.quetePossible(chChemin.getQuetesFaite()) == true && quete.getNumero() != 0) {
                    chChemin.ajouteQueteFaite(quete);
                    chChemin.ajoutexp(quete.getExperience());
                }
            }
        }
        chChemin.ajouteQueteFaite(chChemin.getQueteFin());
        return chChemin.getQuetesFaite().values().toString();
    }
}
