package modele;

import java.util.*;
public class Quete implements Comparable <Quete> {

    private int numero;
    private int [] pos = new int[2] ;
    private int [] precond = new int[4];
    private int duree;
    private int experience;
    private String intitule;
    /**
     * transforme la quete d'une String à un objet de la classe Quete
     * @param ligne (String): quete sur une ligne du fichier
     */
    public Quete(String ligne){
        Scanner scanner = new Scanner(ligne).useDelimiter("\\|");
        while (scanner.hasNext()){
            this.numero = scanner.nextInt();
            String strpos = scanner.next();
            this.pos = extraitPos(strpos);
            String strprecond = scanner.next();
            this.precond = extraitPrecond(strprecond);
            this.duree = scanner.nextInt();
            this.experience = scanner.nextInt();
            this.intitule = scanner.next();
        }
    }
    /**
     * transforme la position de la quete en tableau à 2 valeurs
     * @param scanner (String): position de la quete dans la ligne
     * @return tableau de longueur 2
     */
    public int [] extraitPos(String scanner){
        String precond = scanner;
        int [] preconditions = new int [2];
        precond = precond.replace("(","");
        precond = precond.replace(")","");
        precond = precond.replace(" ","");
        Scanner scanPrecondition = new Scanner(precond).useDelimiter(",");
        int i= 0;
        while(scanPrecondition.hasNext()){
            String extrait = scanPrecondition.next();
            if(!extrait.equals(""))
                preconditions[i]=Integer.parseInt(extrait);
            i++;
        }
        return preconditions;
    }
    /**
     * transforme la precondtion de la quete en tableau à 4 valeurs
     * @param scanner (String): preconditions de la quete dans la ligne
     * @return tableau de longueur 4
     */
    public int [] extraitPrecond(String scanner){
        String precond = scanner;
        int [] preconditions = new int[4];
        precond = precond.replace("(","");
        precond = precond.replace(")","");
        precond = precond.replace(" ","");
        Scanner scanPrecondition = new Scanner(precond).useDelimiter(",");
        int i= 0;
        while(scanPrecondition.hasNext()){
            String extrait = scanPrecondition.next();
            if(!extrait.equals(""))
                preconditions[i]=Integer.parseInt(extrait);
            i++;
        }
        return preconditions;
    }
    /**
     * permet de voir si la quete peut etre faite en regardant ses préconditions et les quetes faites
     * @param listQueteFaite: dico des quetes faite avec comme clé leur id
     * @return true si la quete peut etre faite ou false si la quete ne peut pas etre faite
     */
    public boolean quetePossible(LinkedHashMap<Integer,Quete> listQueteFaite){
        Set<Integer> listIDFaite = listQueteFaite.keySet();
        return (((this.precond[0] == 0 || (listIDFaite.contains(this.precond[0]))) ||listIDFaite.contains(this.precond[1]))) && (((this.precond[2] == 0 || (listIDFaite.contains(this.precond[2]))) ||listIDFaite.contains(this.precond[3])));
    }
    /**
     * compare les numeros deux quetes
     * @param parquete : une quete
     * @return la difference entre une quete et la quete en parametre
     */
    public int compareTo(Quete parquete){
        return numero - parquete.numero;
    }
    /**
     * retoune la position de la quete sur la carte
     * @return pos (int []) : position de la quete sur la carte
     */
    public int[] getPos() {
        return pos;
    }
    /**
     * retourne les préconditions de la quete
     * @return precond (int []): préconditions de la quete
     */
    public int[] getPrecond() {
        return precond;
    }
    /**
     * retoune l'id de la quete
     * @return numero (int): id de la quete
     */
    public int getNumero() {
        return numero;
    }
    /**
     *retourne la durée que prend la quete
     * @return duree (int): la durée de la quete
     */
    public int getDuree() {
        return duree;
    }

    public String getIntitule() {
        return intitule;
    }

    /**
     * retourne un string qui affiche les champs des quetes
     * @return  un string qui represente la quete
     */
    @Override
    public String toString() {
        return numero+"-"+ Arrays.toString(pos) +"-"+ Arrays.toString(precond) +"-"+duree+"-"+experience+"-"+intitule;
    }
    /**
     * retourne l'expérience donnée de la quete
     * @return experience(int) : expérience donné de la quete
     */
    public int getExperience() {
        return experience;
    }
}
