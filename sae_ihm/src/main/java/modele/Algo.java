package modele;

import java.util.Arrays;

public class Algo {

    /**
     * Algorithme glouton pour trouver une solution exhaustive.
     * 
     * @param parEnsembleQuetes Ensemble de quêtes disponibles
     */
    public static void algoGloutonEx(EnsembleQuetes parEnsembleQuetes) {
        Chemin chChemin = new Chemin(parEnsembleQuetes);
        chChemin.setChexp(0);
        while (chChemin.getQuetesNonFaite().size() > 0) {
            for (Quete quete : parEnsembleQuetes.getTreeEnsembleQuetes()) {
                if (quete.quetePossible(chChemin.getQuetesFaite()) && quete.getNumero() != 0) {
                    chChemin.ajouteQueteFaite(quete);
                    chChemin.ajoutexp(quete.getExperience());
                }
            }
        }
        chChemin.ajouteQueteFaite(chChemin.getQueteFin());
        for (Quete quete1 : chChemin.getQuetesFaite().values()) {
            System.out.println("\n");
            System.out.println("Se déplace en " + Arrays.toString(quete1.getPos()));
            System.out.println("Quête " + quete1.getNumero() + ": " + quete1.getIntitule());
        }
    }

    /**
     * Algorithme glouton pour trouver une solution efficace.
     * 
     * @param parEnsembleQuetes Ensemble de quêtes disponibles
     */
    public static void algoGloutonEff(EnsembleQuetes parEnsembleQuetes) {
        Chemin chChemin = new Chemin(parEnsembleQuetes);
        chChemin.setChexp(0);
        while (!chChemin.queteFinPossibleEfficace()) {
            for (Quete quete : parEnsembleQuetes.getTreeEnsembleQuetes()) {
                if (quete.quetePossible(chChemin.getQuetesFaite()) && quete.getNumero() != 0) {
                    chChemin.ajoutexp(quete.getExperience());
                    chChemin.ajouteQueteFaite(quete);
                }
            }
        }
        chChemin.ajouteQueteFaite(chChemin.getQueteFin());
        for (Quete quete1 : chChemin.getQuetesFaite().values()) {
            System.out.println("\n");
            System.out.println("Se déplace en " + Arrays.toString(quete1.getPos()));
            System.out.println("Quête " + quete1.getNumero() + ": " + quete1.getIntitule());
        }
    }

    /**
     * Algorithme glouton pour trouver une solution exhaustive et retourner une chaîne représentant les quêtes accomplies.
     * 
     * @param parEnsembleQuetes Ensemble de quêtes disponibles
     * @return Chaîne représentant les quêtes accomplies
     */
    public static String afficheAlgoGloutonEff(EnsembleQuetes parEnsembleQuetes) {
        Chemin chChemin = new Chemin(parEnsembleQuetes);
        chChemin.setChexp(0);
        while (!chChemin.queteFinPossibleEfficace()) {
            for (Quete quete : parEnsembleQuetes.getTreeEnsembleQuetes()) {
                if (quete.quetePossible(chChemin.getQuetesFaite()) && quete.getNumero() != 0) {
                    chChemin.ajoutexp(quete.getExperience());
                    chChemin.ajouteQueteFaite(quete);
                }
            }
        }
        chChemin.ajouteQueteFaite(chChemin.getQueteFin());
        return chChemin.getQuetesFaite().values().toString();
    }

    /**
     * Algorithme glouton pour trouver une solution efficace et retourner une chaîne représentant les quêtes accomplies.
     * 
     * @param parEnsembleQuetes Ensemble de quêtes disponibles
     * @return Chaîne représentant les quêtes accomplies
     */
    public static String afficheAlgoGloutonEx(EnsembleQuetes parEnsembleQuetes) {
        Chemin chChemin = new Chemin(parEnsembleQuetes);
        chChemin.setChexp(0);
        while (chChemin.getQuetesNonFaite().size() > 0) {
            for (Quete quete : parEnsembleQuetes.getTreeEnsembleQuetes()) {
                if (quete.quetePossible(chChemin.getQuetesFaite()) && quete.getNumero() != 0) {
                    chChemin.ajouteQueteFaite(quete);
                    chChemin.ajoutexp(quete.getExperience());
                }
            }
        }
        chChemin.ajouteQueteFaite(chChemin.getQueteFin());
        return chChemin.getQuetesFaite().values().toString();
    }
}
