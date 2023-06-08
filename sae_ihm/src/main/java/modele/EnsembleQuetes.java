package modele;

import java.util.TreeSet;

public class EnsembleQuetes {
    private final TreeSet<Quete> treeEnsembleQuetes;
    private int nbdeQuete;
    private final String chIntitule;

    /**
     * Constructeur de la classe EnsembleQuetes.
     *
     * @param parIntitule Nom du scénario.
     */
    public EnsembleQuetes(String parIntitule){
        treeEnsembleQuetes = new TreeSet<>();
        nbdeQuete = 0;
        chIntitule = parIntitule;
    }

    /**
     * Ajoute une quête à l'ensemble.
     *
     * @param chQuete Quête à ajouter.
     */
    public void ajout(Quete chQuete){
        treeEnsembleQuetes.add(chQuete);
        nbdeQuete = nbdeQuete + 1;
    }

    /**
     * Retourne toutes les quêtes triées avec les identifiants dans l'ordre croissant.
     *
     * @return TreeSet des quêtes triées par numéro.
     */
    public TreeSet<Quete> getTreeEnsembleQuetes() {
        return treeEnsembleQuetes;
    }

    /**
     * Retourne le nombre de quêtes du scénario.
     *
     * @return Nombre de quêtes dans le scénario.
     */
    public int getNbdeQuete() {
        return nbdeQuete;
    }
}
