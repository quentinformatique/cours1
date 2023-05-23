/*
 * Gestion des opérations de base entre 2 opérandes
 * Calcul.java                                              05/22
 */

package principal.outilcalcul;

/**
 * Cette classe permet de gérer des calculs entre 2 opérandes de type entier : 
 *    addition, multiplication et division avec résultat de type double 
 * @author C. Servières
 * @version 1.0
 */
public class Calcul {
    
    /** Opérande gauche pour le calcul calcul */
    private int opGauche;
    
    /** Opérande de droite pour le calcul calcul */
    private int opDroite;
    
    /**
     * Constructeur qui initialise les opérandes à O
     */
    public Calcul() {
        opGauche = 0;
        opDroite = 0;
    }

    /**
     * Constructeur avec en argument les valeurs initiales des opérandes
     * @param opGauche  entier égal à la valeur initiale de l'opérande gauche
     * @param opDroite  entier égal à la valeur initiale de l'opérade de droite
     */
    public Calcul(int opGauche, int opDroite) {
        this.opGauche = opGauche;
        this.opDroite = opDroite;
    }
    
    /**
     * Renvoie la somme des 2 opérandes
     * @return un entier éagal  à la somme des 2 opérandes
     */
    public int ajouter() {
        return opGauche + opDroite;
    }
    
    /**
     * Renvoie la multiplication des 2 opérandes
     * @return un entier éagal  à la multiplication des 2 opérandes
     */
    public int multiplier() {
        return opGauche * opDroite;
    }
    
    /**
     * Renvoie le résultat de la division opGauche / opDroite
     * @return un entier éagal  à la division entière opGauche / opDroite
     * @throws IllegalStateException  exception levée si l'opérande de droite
     *                                est égal à 0
     */
    public int diviser() {
        if (opDroite == 0) {
            throw new IllegalStateException("Impossible de diviser par 0");
        }
        return opGauche / opDroite;
    }
    
    /**
     * Renvoie une chaîne contenant les valeurs des opérandes
     * dans le format "D = valeur | G = valeur"
     * @return une chaîne contenant les opérandes
     */
    public String toString() {
        return "G = " + opGauche + " | D = " + opDroite;
    }
}