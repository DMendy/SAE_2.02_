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
     * permet de constuire un objet de la classe Chemin
     * @param parEnsembleQuetes (Scenario): Scenario sur lequel le Chemin va se basé
     */
    public Chemin(EnsembleQuetes parEnsembleQuetes){
        chEnsembleQuetes = parEnsembleQuetes;
        chexp = 0;
        chQuetesFaite =  new LinkedHashMap<>();
        quetesNonFaite = getAllQuetes(chEnsembleQuetes.getTreeEnsembleQuetes());
        queteFin = chEnsembleQuetes.getTreeEnsembleQuetes().first();
    }

    /**
     * crée un Treeset des quetes sans la quete 0
     * @param treeq (TreeSet<Quete>) : est le treeSet de toutes les quetes du scénario
     * @return treeQueteNonFaite ((TreeSet<Quete>): est l'ensemble des quetes non faites au début
     */
    public TreeSet <Quete> getAllQuetes(TreeSet<Quete> treeq){
        TreeSet<Quete> treeQueteNonFaite = new TreeSet<>(treeq);
        treeQueteNonFaite.pollFirst();
        return treeQueteNonFaite;
    }
    /**
     * permet de savoir la quete O peut etre réalisé dans l'agorithme efficace
     * @return false: si la quete ne peut etre réalisé
     *         true: si la quete peut etre réalisé
     */
    public boolean queteFinPossibleEfficace(){
        return ((chexp >= queteFin.getExperience()) && ((queteFin.quetePossible(chQuetesFaite))));
    }
    /**
     * retoune les quetes non faites actuelles du Chemin
     * @return liste des quetes non faites du chemin
     */
    public TreeSet<Quete> getQuetesNonFaite() {
        return quetesNonFaite;
    }

    /**
     * retoune les quetes faites actuelles du Chemin
     * @return liste des quetes faites du chemin
     */
    public LinkedHashMap<Integer,Quete> getQuetesFaite() {
        return chQuetesFaite;
    }
    /**
     * change l'expérience du Chemin
     * @param chexp (int): l'expérience qui qu'on veut mettre
     */
    public void setChexp(int chexp) {
        this.chexp = chexp;
    }
    /**
     * permet de savoir la quete O peut etre réalisé dans l'algorithme exhaustif
     *
     * @return false: si la quete ne peut etre réalisé
     *         true: si la quete peut etre réalisé
     */
    public boolean queteFinPossibleExhaustive(){
        return (((queteFin.quetePossible(chQuetesFaite))) &&(((chEnsembleQuetes.getNbdeQuete() -1) == chQuetesFaite.keySet().size())));
    }
    /**
     * retourne un string qui affiche un Chemin
     * @return String: un string qui represente le Chemin
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
     * retourne la quete 0 (quete finale) du Chemin
     * @return queteFin(Quete): quete finale du Chemin
     */
    public Quete getQueteFin() {
        return queteFin;
    }
    /**
     * ajoute l'expérience de la quete faites au Chemin
     * @param parQueteExp (int): représente l'expérience de la quete faite
     */
    public void ajoutexp(int parQueteExp){
        this.chexp = chexp + parQueteExp;
    }
    /**
     * ajoute la quete qui vient d'etre fait et l'enleve des quetes possibles et des quetes non faites
     * @param parquete (Quete) est la quete qui vient d'etre fait
     */
    public void ajouteQueteFaite(Quete parquete){
        chQuetesFaite.put(parquete.getNumero(),parquete);
        quetesNonFaite.remove(parquete);
    }
}