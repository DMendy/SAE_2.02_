package modele;

import java.util.*;

public class Quete implements Comparable<Quete> {

    private int numero;
    private int[] pos = new int[2];
    private int[] precond = new int[4];
    private int duree;
    private int experience;
    private String intitule;

    /**
     * Constructeur de la classe Quete.
     *
     * @param ligne Ligne représentant la quête dans le fichier.
     */
    public Quete(String ligne) {
        Scanner scanner = new Scanner(ligne).useDelimiter("\\|");
        while (scanner.hasNext()) {
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
     * Transforme la position de la quête en tableau à 2 valeurs.
     *
     * @param scanner Position de la quête dans la ligne.
     * @return Tableau de longueur 2 représentant la position.
     */
    public int[] extraitPos(String scanner) {
        String precond = scanner;
        int[] preconditions = new int[2];
        precond = precond.replace("(", "");
        precond = precond.replace(")", "");
        precond = precond.replace(" ", "");
        Scanner scanPrecondition = new Scanner(precond).useDelimiter(",");
        int i = 0;
        while (scanPrecondition.hasNext()) {
            String extrait = scanPrecondition.next();
            if (!extrait.equals(""))
                preconditions[i] = Integer.parseInt(extrait);
            i++;
        }
        return preconditions;
    }

    /**
     * Transforme les préconditions de la quête en tableau à 4 valeurs.
     *
     * @param scanner Préconditions de la quête dans la ligne.
     * @return Tableau de longueur 4 représentant les préconditions.
     */
    public int[] extraitPrecond(String scanner) {
        String precond = scanner;
        int[] preconditions = new int[4];
        precond = precond.replace("(", "");
        precond = precond.replace(")", "");
        precond = precond.replace(" ", "");
        Scanner scanPrecondition = new Scanner(precond).useDelimiter(",");
        int i = 0;
        while (scanPrecondition.hasNext()) {
            String extrait = scanPrecondition.next();
            if (!extrait.equals(""))
                preconditions[i] = Integer.parseInt(extrait);
            i++;
        }
        return preconditions;
    }

    /**
     * Vérifie si la quête peut être réalisée en regardant ses préconditions et les quêtes déjà faites.
     *
     * @param listQueteFaite Dictionnaire des quêtes déjà faites avec leur ID comme clé.
     * @return true si la quête peut être faite, false sinon.
     */
    public boolean quetePossible(LinkedHashMap<Integer, Quete> listQueteFaite) {
        Set<Integer> listIDFaite = listQueteFaite.keySet();
        return (((this.precond[0] == 0 || listIDFaite.contains(this.precond[0])) || listIDFaite.contains(this.precond[1])))
                && (((this.precond[2] == 0 || listIDFaite.contains(this.precond[2])) || listIDFaite.contains(this.precond[3])));
    }

    /**
     * Compare les numéros de deux quêtes.
     *
     * @param parquete Une quête.
     * @return La différence entre la quête actuelle et la quête en paramètre.
     */
    public int compareTo(Quete parquete) {
        return numero - parquete.numero;
    }

    /**
     * Retourne la position de la quête sur la carte.
     *
     * @return Tableau de longueur 2 représentant la position de la quête.
     */
    public int[] getPos() {
        return pos;
    }

    /**
     * Retourne les préconditions de la quête.
     *
     * @return Tableau de longueur 4 représentant les préconditions de la quête.
     */
    public int[] getPrecond() {
        return precond;
    }

    /**
     * Retourne l'ID de la quête.
     *
     * @return ID de la quête.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Retourne la durée que prend la quête.
     *
     * @return Durée de la quête.
     */
    public int getDuree() {
        return duree;
    }

    /**
     * Retourne l'intitulé de la quête.
     *
     * @return Intitulé de la quête.
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * Retourne une chaîne de caractères représentant les champs de la quête.
     *
     * @return Chaîne de caractères représentant la quête.
     */
    @Override
    public String toString() {
        return "\n" + "quete" + " " + numero + "\n" + "Se deplace en " + Arrays.toString(pos) + "\n"
                + "Obtient " + experience + "xp" + "\n" + intitule;
    }

    /**
     * Retourne l'expérience donnée par la quête.
     *
     * @return Expérience donnée par la quête.
     */
    public int getExperience() {
        return experience;
    }
}
