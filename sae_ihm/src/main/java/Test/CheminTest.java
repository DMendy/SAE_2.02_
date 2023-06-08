package Test;

import modele.Chemin;
import modele.EnsembleQuetes;
import modele.Quete;
import org.junit.Assert;
import org.junit.Before;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.TreeSet;

public class CheminTest{
    private Chemin chemin;
    private EnsembleQuetes ensembleQuetes;



    @Test
    public void testQueteFinPossibleExhaustive() {
        String ligne = "2|(2, 2)|((4, 1),)|2|100|explorer tombeau de Reha Thalor";
        String ligne2 = "5|(4, 3)|((1, 4), (2,))|1|150|explorer jardin de Syhe Lenora";
        Quete quete = new Quete(ligne);
        Quete quete2 = new Quete(ligne2);
        chemin.getQuetesFaite().put(1, quete);
        chemin.getQuetesFaite().put(2, quete2);
        boolean result = chemin.queteFinPossibleExhaustive();
        // Vérifiez le résultat attendu
        Assert.assertTrue(result);
    }


    @Test
    public void testQueteFinPossibleEfficace_ExperienceSuffisanteEtQuetePossible() {
        String ligne = "2|(2, 2)|((4, 1),)|2|100|explorer tombeau de Reha Thalor";
        String ligne2 = "5|(4, 3)|((1, 4), (2,))|1|150|explorer jardin de Syhe Lenora";
        Quete quete = new Quete(ligne);
        Quete quete2 = new Quete(ligne2);
        chemin.setChexp(250); // Experience suffisante
        chemin.getQuetesFaite().put(1, quete); // Quête déjà effectuée

        boolean result = chemin.queteFinPossibleEfficace();

        // Vérifiez le résultat attendu
        Assert.assertTrue(result);
    }

    @Test
    public void testAjoutexp_ExpPositif() {
        int parQueteExp = 100;
        chemin.ajoutexp(parQueteExp);

        // Vérifiez le résultat attendu
        int expectedExp = 100;
        Assert.assertEquals(expectedExp, chemin.getChexp());
    }



    @Test
    public void testAjouteQueteFaite() {
        chemin = new Chemin(ensembleQuetes);
        LinkedHashMap chQuetesFaite = new LinkedHashMap<>();
        TreeSet quetesNonFaite = new TreeSet<>();
        Quete quete = new Quete("2|(2, 2)|((4, 1),)|2|100|explorer tombeau de Reha Thalor");
        quetesNonFaite.add(quete);

        chemin.ajouteQueteFaite(quete);

        // Vérifiez le résultat attendu
        Assert.assertTrue(chQuetesFaite.containsKey(quete.getNumero()));
        Assert.assertFalse(quetesNonFaite.contains(quete));
    }
}


