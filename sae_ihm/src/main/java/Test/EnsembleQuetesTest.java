package Test;

import modele.*;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import modele.Chemin;
import modele.EnsembleQuetes;
import org.junit.Assert;

import java.util.TreeSet;

class EnsembleQuetesTest {

    @Test
    public void testAjout() {
        Quete quete = new Quete("2|(2, 2)|((4, 1),)|2|100|explorer tombeau de Reha Thalor");
        EnsembleQuetes ensembleQuetes = new EnsembleQuetes(new String());

        ensembleQuetes.ajout(quete);

        // Vérifiez le résultat attendu
        TreeSet<Quete> treeEnsembleQuetes = ensembleQuetes.getTreeEnsembleQuetes();
        Assert.assertTrue(treeEnsembleQuetes.contains(quete));
        Assert.assertEquals(1, ensembleQuetes.getNbdeQuete());
    }
}
