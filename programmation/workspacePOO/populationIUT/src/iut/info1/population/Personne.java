/*
 * Personne.java                                    9 mai 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package iut.info1.population;

import iut.info1.datation.Date;

/** TODO comment class responsibility (SRP)
 * @author quentin costes
 *
 */
public class Personne implements Comparable<Personne> {
    
    final String REGEX_NOM = "[a-zA-Z- ']+";
    final String REGEX_PRENOM = "[a-zA-Z- ']+";
    final String REGEX_NONIR = "^[12][0-9]{2}[0-1][0-9](2[abAB]|[0-9]{2})[0-9]{3}[0-9]{3}[0-9]{2}$";
    
    /** Numéro d'incription au repertoire national */
    private String noNIR;
    
    /** nom patronyme de famille */
    private String nom;
    
    /** prénom usuel, 1er prenom */
    private String prenom;
    
    /** Datede naissance */
    private Date naissance;
    

    /** TODO comment initial state properties
     * @param i
     * @param nom
     * @param prenom
     * @param naissance
     */
    public Personne(String i, String nom, String prenom, Date naissance) {
        super();

        if (isValide(i, nom, prenom, naissance)) {
            this.noNIR = i;
            this.nom = nom;
            this.prenom = prenom;
            this.naissance = naissance;
        } else {
            throw new IllegalArgumentException("donnez une personne valide");
        }
    }

    /* non javadoc - @see java.lang.Comparable#compareTo(java.lang.Object) */
    @Override
    public int compareTo(Personne o) {
        // TODO Auto-generated method stub
        return 0;
    }

    /** @return valeur de noNIR */
    public String getNoNIR() {
        return noNIR;
    }


    /** @return valeur de nom */
    public String getNom() {
        return nom;
    }


    /** @return valeur de prenom */
    public String getPrenom() {
        return prenom;
    }


    /** @return valeur de naissance */
    public Date getNaissance() {
        return naissance;
    }


    /* non javadoc - @see java.lang.Object#toString() */
    @Override
    public String toString() {
        return "Personne [noNIR=" + noNIR + ", nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + "]";
    }
    
    private boolean isValide(String noNIR, String nom, String prenom, Date dateNaissance) {

        return    noNIR.matches(REGEX_NONIR)
               && nom.matches(REGEX_NOM)
               && prenom.matches(REGEX_PRENOM);
    } 

    

}
