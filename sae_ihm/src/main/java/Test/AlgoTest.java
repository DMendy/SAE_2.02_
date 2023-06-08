package Test;

import modele.*;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import modele.Chemin;
import modele.EnsembleQuetes;
import org.junit.Assert;




class AlgoTest {

    @Test
    public void testAlgoGloutonEx() {
        EnsembleQuetes ensembleQuetes = new EnsembleQuetes(new String());
        Chemin chemin = new Chemin(new EnsembleQuetes(new String()));
        chemin.getAllQuetes(ensembleQuetes.getTreeEnsembleQuetes()) ; // Définir l'ensembleQuetes statique de la classe Chemin

        // Appeler la méthode algoGloutonEx
        Algo.algoGloutonEx(ensembleQuetes);

        // Vérifier le résultat attendu
        Chemin chChemin = new Chemin(ensembleQuetes); // Obtenir l'instance du chemin généré

        // Vérifier que toutes les quêtes effectuées sont possibles
        for (Quete quete : chChemin.getQuetesFaite().values()) {
            Assert.assertTrue(quete.quetePossible(chChemin.getQuetesFaite()));
        }

        // Vérifier que la quête finale a été ajoutée
        Assert.assertTrue(chChemin.getQuetesFaite().containsKey(chChemin.getQueteFin().getNumero()));
    }


    @Test
    public void testAlgoGloutonEff() {
        EnsembleQuetes ensembleQuetes = new EnsembleQuetes(new String());
        Chemin chemin = new Chemin(new EnsembleQuetes(new String()));
        chemin.getAllQuetes(ensembleQuetes.getTreeEnsembleQuetes());  // Définir l'ensembleQuetes statique de la classe Chemin

        // Appeler la méthode algoGloutonEff
        Algo.algoGloutonEx(ensembleQuetes);

        // Vérifier le résultat attendu
        Chemin chChemin = new Chemin(ensembleQuetes); // Obtenir l'instance du chemin généré

        // Vérifier que toutes les quêtes effectuées sont possibles et que la quête finale est possible
        for (Quete quete : chChemin.getQuetesFaite().values()) {
            Assert.assertTrue(quete.quetePossible(chChemin.getQuetesFaite()));
        }
        Assert.assertTrue(chChemin.queteFinPossibleEfficace());

        // Vérifier que la quête finale a été ajoutée
        Assert.assertTrue(chChemin.getQuetesFaite().containsKey(chChemin.getQueteFin().getNumero()));
    }
}