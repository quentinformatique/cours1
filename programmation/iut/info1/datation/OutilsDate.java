/*
 * OutilsDate.java                       11/01/2023
 * IUT de Rodez, BUT info1 2022-2023 pas de copyright ni copyleft
 */
package iut.info1.datation;

/**
 * Controler la validité d'une combinaison grégorienne jj/mm/aaaa
 * @author info1 TP2
 */
public class OutilsDate {

    public final static int AN_MIN = 1850;
    public final static int AN_MAX = 2100;

    public final static int[] DUREE_MOIS_GREGORIEN
    = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * main vide 
     * @param args
     */
    public static void main(String[] args) {
        
    }

    /**
     * Prédicat de vérification d'une combinaison jour, mois, an
     * afin d'indiquer si c'est une date existante 
     * dans la période AN_MIN à AN_MAX du calendrier grégorien
     *
     * @param jour numéro de jour (de 1 à 31)
     * @param mois numéro du mois (de 1 à 12)
     * @param an numéro de l'année (de AN_MIN à AN_MAX)
     * @return true si jour, mois, an est une date, false sinon
     */

    public static boolean isValide(int jour, int mois, int an) {

        return AN_MIN <= an && an <= AN_MAX
               && 1 <= mois && mois <= 12
               && 1 <= jour
               && (!(mois == 2 && jour == 29)
                   ? 1 <= jour && jour <= DUREE_MOIS_GREGORIEN[mois]
                   : estBisextile(an));

    }

    /** TODO comment method role
     * @param an
     * @return
     */
    public static boolean estBisextile(int an) {
        return an % 4 == 0 && an % 100 != 0 || an % 400 == 0;
    }
}