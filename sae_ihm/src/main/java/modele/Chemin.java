package modele;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.TreeSet;

public class Chemin {
    private final EnsembleQuetes chEnsembleQuetes;
    private int chexp;

    private final LinkedHashMap<Integer,Quete> chQuetesFaite;
    private final TreeSet<Quete> quetesNonFaite;
    private final Quete queteFin;

    /**
     * Constructeur de la classe Chemin.
     *
     * @param parEnsembleQuetes Ensemble de quêtes sur lequel le Chemin se base.
     */
    public Chemin(EnsembleQuetes parEnsembleQuetes){
        chEnsembleQuetes = parEnsembleQuetes;
        chexp = 0;
        chQuetesFaite =  new LinkedHashMap<>();
        quetesNonFaite = getAllQuetes(chEnsembleQuetes.getTreeEnsembleQuetes());
        queteFin = chEnsembleQuetes.getTreeEnsembleQuetes().first();
    }

    /**
     * Crée un TreeSet des quêtes sans la quête 0.
     *
     * @param treeq TreeSet de toutes les quêtes du scénario.
     * @return TreeSet des quêtes non faites au début.
     */
    public TreeSet<Quete> getAllQuetes(TreeSet<Quete> treeq){
        TreeSet<Quete> treeQueteNonFaite = new TreeSet<>(treeq);
        treeQueteNonFaite.pollFirst();
        return treeQueteNonFaite;
    }

    /**
     * Vérifie si la quête finale peut être réalisée dans l'algorithme efficace.
     *
     * @return true si la quête finale peut être réalisée, sinon false.
     */
    public boolean queteFinPossibleEfficace(){
        return ((chexp >= queteFin.getExperience()) && ((queteFin.quetePossible(chQuetesFaite))));
    }

    /**
     * Retourne les quêtes non faites actuelles du Chemin.
     *
     * @return Liste des quêtes non faites du Chemin.
     */
    public TreeSet<Quete> getQuetesNonFaite() {
        return quetesNonFaite;
    }

    /**
     * Retourne les quêtes faites actuelles du Chemin.
     *
     * @return Liste des quêtes faites du Chemin.
     */
    public LinkedHashMap<Integer,Quete> getQuetesFaite() {
        return chQuetesFaite;
    }

    /**
     * Change l'expérience du Chemin.
     *
     * @param chexp Nouvelle valeur de l'expérience.
     */
    public void setChexp(int chexp) {
        this.chexp = chexp;
    }

    /**
     * Vérifie si la quête finale peut être réalisée dans l'algorithme exhaustif.
     *
     * @return true si la quête finale peut être réalisée, sinon false.
     */
    public boolean queteFinPossibleExhaustive(){
        return (((queteFin.quetePossible(chQuetesFaite))) &&(((chEnsembleQuetes.getNbdeQuete() -1) == chQuetesFaite.keySet().size())));
    }

    /**
     * Retourne une chaîne de caractères représentant le Chemin.
     *
     * @return Chaîne de caractères représentant le Chemin.
     */
    @Override
    public String toString(){
        String str ="";
        for (Integer i : chQuetesFaite.keySet()){
            str = str + i + " ";
        }
        return str;
    }

    /**
     * Retourne la quête finale du Chemin.
     *
     * @return Quête finale du Chemin.
     */
    public Quete getQueteFin() {
        return queteFin;
    }

    /**
     * Ajoute l'expérience de la quête faite au Chemin.
     *
     * @param parQueteExp Expérience de la quête faite.
     */
    public void ajoutexp(int parQueteExp){
        this.chexp = chexp + parQueteExp;
    }

    /**
     * Ajoute la quête qui vient d'être faite et l'enlève des quêtes possibles et des quêtes non faites.
     *
     * @param parquete Quête qui vient d'être faite.
     */
    public void ajouteQueteFaite(Quete parquete){
        chQuetesFaite.put(parquete.getNumero(),parquete);
        quetesNonFaite.remove(parquete);
    }
}
