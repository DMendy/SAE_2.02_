package modele;

import java.util.TreeSet;

public class EnsembleQuetes {
    private final TreeSet<Quete> treeEnsembleQuetes;
    private int nbdeQuete;
    private final String chIntitule;
    /**
     * construit un objet de la classe Chemin
     * @param parIntitule (String): represente le nom du scénario
     */
    public EnsembleQuetes(String parIntitule){
        treeEnsembleQuetes = new TreeSet<>();
        nbdeQuete = 0;
        chIntitule = parIntitule;

    }
    /**
     * ajoute une quete à l'ensemble
     * @param chQuete: Une quete qui doit etre dans ce scenario
     */
    public void ajout(Quete chQuete){
        treeEnsembleQuetes.add(chQuete);
        nbdeQuete = nbdeQuete + 1;
    }
    /**
     * retoune tous les quetes triées avec les id dans l'ordre croissant
     * @return treeEnsembleQuetes (TreeSet<Quete>): represente les quetes par numero
     */
    public TreeSet<Quete> getTreeEnsembleQuetes() {
        return treeEnsembleQuetes;
    }
    /**
     * retourne le nombre de quêtes du scénario.
     * @return getNbdeQuete (int): représente le nombre de quêtes dans le scénario
     */
    public int getNbdeQuete() {
        return nbdeQuete;
    }
}