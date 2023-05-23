/*
 * Date.java                                           08/02/2023
 * IUT de Rodez, BUT info1 2022-2023 pas de copyright ni copyleft
 */

package iut.info1.datation;

/**
 * 
 * @author info1 TP2
 */

public class Date {

    // année minimale
    public final static int AN_MIN = 1850;

    // année maximale
    public final static int AN_MAX = 2100;

    /** séparateur de la date pour la locale française */
    public final static String SEPARATEUR = "/";

    /*  numero de jour entre 1 et 31 */
    private int jour;

    /*  numero de jour entre 1 et 12 */
    private int mois;

    /*  numero de l'anne entre AN_MIN et AN_MAX */
    private int annee;

    /**
     * initialiser la date jj/mm/aaaa
     * @param jj numero du jouer entre 1 et 31
     * @param mm numero du mois entre 1 et 12
     * @param aaa numero du mois entre AN_MIN et AN_MAX
     */
    public Date(int jj, int mm, int aaaa) {

    }

    /*
     * @return le numero de jour entre 1 et 31
     */
    public int getJj(){
        return 1;
    }

    
    /*
     * @return le numero du mois entre 1 et 12
     */
    public int getMm(){
        return 1;
    }

    
    /*
     * @return l'annee entre AN_MIN et AN_MAX
     */
    public int getAaaa(){
        return 1978;
    }

    /* non javadoc - @see java.lang.Object#toString() */
    public String toString(){
        return getJj() + SEPARATEUR + getMm() + SEPARATEUR + getAaaa();
    }
}