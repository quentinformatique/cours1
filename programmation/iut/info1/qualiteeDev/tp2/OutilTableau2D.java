/*
 * Classe contenant différents traitements sur les tableaux à 2 dimensions
 * Les tableaux gérés contiendront des entiers.                        11/21
 * fichier OutilTableau2D.java
 */
package iut.info1.qualiteeDev.tp2;

import javax.swing.text.TabExpander;

/**
 * Cette classe contient différentes méthodes permettant de traiter des tableaux
 * à 2 dimensions : initialiser une matrice, afficher/saisir son contenu,
 * calculer des sommes d'un sous-ensemble de valeurs de la matrice,
 * rechercher selon différents critères (présence, maximum ...)
 * 
 * @author C. Servières
 * @version 1.0
 * 
 */
public class OutilTableau2D {

    /** Message d'erreur si le tableau argument n'est pas créé (référence nulle) */
    private static final String ERREUR_REF_NULLE = "Erreur. La matrice argument n'a pas été créée.";

    /** Message d'erreur si une ligne n'existe pas */
    private static final String ERREUR_LIGNE_INVALIDE = "Erreur. La ligne numéro %d n'existe pas.";

    /** Message d'erreur si une colonne n'existe pas */
    private static final String ERREUR_COLONNE_INVALIDE = "Erreur. La colonne numéro %d n'existe pas.";

    /** Message d'erreur si une colonne n'existe pas pour une ligne précise */
    private static final String ERREUR_COL_INVALIDE_SUR_LIG = "Erreur. La colonne numéro %d n'existe pas pour la ligne %d.";

    /** Message d'erreur si la matrice n'est pas carrée */
    private static final String ERREUR_MATRICE_NON_CARREE = "Erreur. La matrice argument n'est pas carrée.";

    /**
     * Calcule la somme des valeurs situées sur la ligne argument
     * 
     * @param table matrice à traiter
     * @param ligne numéro de la ligne dont on calcule la somme
     * @return somme des valeurs de la ligne
     * @throws IllegalArgumentException levée si TODO : compléter
     */
    public static int sommeLigne(int[][] table, int ligne) {

        

        if (table == null) {
            throw new IllegalArgumentException(String.format(ERREUR_LIGNE_INVALIDE, ligne));
        }

        if (ligne > table.length - 1 || ligne <= 0) {
            throw new IllegalArgumentException(String.format(ERREUR_LIGNE_INVALIDE, ligne));
        }

        int somme = 0; // somme des valeurs de ligne
        for (int i = 0 ; i < table[ligne].length ; i ++){
            somme += table[ligne][i];
        }

        return somme;
    }

    /**
     * Cette méthode affiche le tableau à 2 dimensions argument
     * 
     * @param table tableau à afficher (contient des entiers)
     * @throws IllegalArgumentException levée si TODO : compléter
     */
    public static void afficher(int[][] table) {
        if (table == null) {
            throw new IllegalArgumentException(ERREUR_REF_NULLE);
        }

        for (int[] ligne: table){
            for (int cellule: ligne) {
                System.out.printf("%d\t ", cellule);
            }
            System.out.print("\n");
        }
    }

    /**
     * Détermine si une matrice est carrée ou pas
     * 
     * @param table matrice à tester
     * @return un booléen égal à vrai ssi la matrice argument est carrée
     * @throws IllegalArgumentException levée si la référence table est nulle
     * 
     */
    public static boolean matriceCarree(int[][] table) {
        if (table == null) {
            throw new IllegalArgumentException(ERREUR_REF_NULLE);
        }
        boolean estCarre = true;

        for (int i = 0; i < table.length && estCarre; i ++) {
            estCarre = table[i].length == table.length;
        }
        return estCarre;
    }

    /**
     * Calcule la somme des valeurs situées sur la première diagonale de la
     * matrice argument
     * 
     * @param table tableau à 2 dimensions à traiter
     * @return un entier égal à la somme des valeurs de la diagonale principale
     * @throws IllegalArgumentException levée si TODO : compléter
     */
    public static int sommePremiereDiag(int[][] table) {
        if (table == null) {
            throw new IllegalArgumentException(ERREUR_REF_NULLE);
        }

        if (!matriceCarree(table)) {
            throw new IllegalArgumentException(ERREUR_MATRICE_NON_CARREE);
        }

        int somme;
        somme = 0;
        for (int i = 0; i < table.length; i++) {
            somme += table[i][i];
        }

        return somme;

    }

    /**
     * Calcule la somme des valeurs situées sur la colonne argument
     * 
     * @param table   matrice à traiter
     * @param colonne numéro de la colonne dont on calcule la somme
     * @return somme des valeurs de la colonne
     * @throws IllegalArgumentException levée si TODO compléter
     */
    public static int sommeColonne(int[][] table, int colonne) {
        int somme = 0; // somme des valeurs de la colonne

        if (table == null) {
            throw new IllegalArgumentException(ERREUR_REF_NULLE);
        }

        if (colonne > table.length - 1 || colonne <= 0) {
            throw new IllegalArgumentException(String.format(ERREUR_COLONNE_INVALIDE, colonne));
        }

        for (int i = 0; i < table.length; i++) {
            somme += table[0][colonne];
        }

        return somme;
    }

    /**
     * Calcule la somme des valeurs situées sur la colonne argument
     * 
     * @param table   matrice à traiter
     * @param valeur valeure a rechercher 
     * @return True si la valeur est dans la matrice, false sinon
     * @throws IllegalArgumentException levée 
     */

    public static boolean cherche(int[][] table, int valeur ) {
    
        if (table == null) {
            throw new IllegalArgumentException(ERREUR_REF_NULLE);
        }

        boolean trouver;

        trouver = false;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                trouver = table[i][j] == valeur;
            }
        }

        return trouver;


    }

    

}