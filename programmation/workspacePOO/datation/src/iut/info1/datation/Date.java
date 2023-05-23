/* Date.java                     15 févr. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package iut.info1.datation;

/**
 * Date grégorienne dans une période de AN_MIN à AN_MAX
 * @author quentin costes
 */
public class Date {
    

    /** Numéro d'année minimale du calendrier */
    public static final int AN_MIN = 1850;

    /** Numéro d'année maximale du calendrier */
    public static final int AN_MAX = 2100;

    /** Séparateur de date pour la locale française */
    public static final String SEPARATEUR = "/";

    /** Numéro d'année entre AN_MIN et AN_MAX */
    private int date;

    /**
     * Initialise la date jj/mm/aaaa si valide
     * @param jj   le numéro de jour entre 1 et 31
     * @param mm   le numéro de mois entre 1 et 12
     * @param aaaa le numéro d'année entre AN_MIN et AN_MAX
     */
    public Date(int jj, int mm, int aaaa) {
        if (isValide(jj, mm, aaaa)) {
            date = aaaa*10000 + mm*100 + jj;
        } else {
            throw new IllegalArgumentException("Veuillez donner une date valide");
        }

    }

    /** @return le numéro de jour entre 1 et 31*/
    public int getJj() {
        return date%100;
    }

    /** @return le numéro de mois entre 1 et 12*/
    public int getMm() {
        return date/100%100;
    }

    /** @return le numéro d'année entre AN_MIN et AN_MAX*/
    public int getAaaa() {
        return date/10000;
    }

    /* non javadoc - @see java.lang.Object#toString() */
    @Override
    public String toString() {
        return getJj() + SEPARATEUR + getMm() + SEPARATEUR + getAaaa();
    }  

    /** TODO comment method role
     * @param date2 a comparer
     * @return int 
     */
    public int differenceAnnee(Date date2) {
        return Math.abs(this.getAaaa() - date2.getAaaa());
    }
    
    /** TODO comment method role
     * @param jj
     * @param mm
     * @param aaaa
     * @return true si la date est valide false sinon
     */
    private static boolean isValide(int jj, int mm, int aaaa) {
        final int[] DUREE_NORMALE_MOIS
        = { 0, 31, 28, 31, 30, 31, 30, 31, 
               31, 30, 31, 30, 31
        };
        
        return AN_MIN <= aaaa && aaaa <= AN_MAX
                && 1 <= mm && mm <= 12
                && 1 <= jj
                && (!(mm == 2 && jj == 29)
                    ? 1 <= jj && jj <= DUREE_NORMALE_MOIS[mm]
                    : estBisextile(aaaa));
    }
    
    /** test si une annee est bisextile
     * @param aaaa
     * @return true si la date est bisextile, false sinon
     */
    public static boolean estBisextile(int aaaa) {
        return aaaa % 4 == 0 && aaaa % 100 != 0 || aaaa % 400 == 0;
    }
    
    /* non javadoc - @see java.lang.Object#hashCode() */
    @Override
    public int hashCode() {
        return date;
    }
    
    /* non javadoc - @see java.lang.Object#equals(java.lang.Object) */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Date)) {
            return false;
        }
        return hashCode() == obj.hashCode();
    }
}
