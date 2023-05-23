/*
 * Utilisation de la classe OutilTableau2D                           11/21
 * UtilisationTableau2D.java
 */
package iut.info1.qualiteeDev.tp2;

import java.util.Scanner;

/**
 * Cette classe permet de tester le bon fonctionnement de la gestion des
 * exceptions
 * définies dans la classe OutilTableau2D
 * 
 * @author INFO2
 * @version 1.0
 */
public class TestOutilTableau2D {

    /** pour les saisies au clavier */
    private static Scanner entree = new Scanner(System.in);

    /** Lorsqu'un test est répété, il sera répété 3 fois */
    private static final int NB_TEST = 3;

    /** Matrice carrrée qui sert de jeu de test */
    private static final int[][] MATRICE_CARREE = { { 4, 9, 17, 26, 13 },
            { -3, 2, 8, -6, 30 },
            { 12, 9, 1, 3, 11 },
            { 7, -2, 0, 6, 15 },
            { 11, 10, -5, 3, -1 } };

    /** Matrice rectangulaire qui sert de jeu de test */
    private static final int[][] MATRICE_RECTANGLE = { { 4, 9, 17, 26, 13, 5, -9 },
            { -3, 2, 8, -6, 30, -1, 18 },
            { 12, 9, 1, 3, 11, -5, -2 },
            { 7, -2, 0, 6, 15, 8, -3 },
            { 11, 10, -5, 3, -1, 0, 10 } };

    /** Matrice irrégulière qui sert de jeu de test */
    private static final int[][] MATRICE_IRREGUL = { { 4, 9, 17, 26, 13 },
            { -3, 2, 8, -6, 30, -1, 18 },
            { 12, 9, 1 },
            { 7, -2, 0, 6, 15, 8 },
            { 11, 10, -5, 3, -1 } };

    /** Matrice nulle (référence nulle) */
    private static final int[][] MATRICE_NULLE = null;

    /* ------------------------ Test de sommeLigne ------------------------ */

    /**
     * Affiche sur la console la somme de la ligne numéro numLigne de la
     * matrice argument. Si le numéro de ligne est incorrect, un message
     * d'erreur est affiché.
     * 
     * @param matrice  matrice à partir de laquelle le calcul est fait
     * @param numLigne numéro de la ligne dont la somme est affichée
     */
    public static void afficherSommeLigne(int[][] matrice, int numLigne) {
        try {
            System.out.print("Somme de la ligne " + numLigne + " = " + OutilTableau2D.sommeLigne(matrice, numLigne));
        } catch (IllegalArgumentException e) {
            System.err.printf(e.getMessage());
        }
    }

    /**
     * Méthode de test de la méthode sommeLigne
     * Le test est interactif : l'utilisateur entre un numéro de lign
     * La somme des valeurs de cette ligne est affichée, pour chacune
     * des 4 matrices jeux de tests
     */
    public static void testSommeLigne() {

        int ligneATester;
        System.out.println("TEST DE LA METHODE sommeLigne :\n"
                + "---------------------------------");
        for (int numTest = 1; numTest <= NB_TEST; numTest++) {
            System.out.println("\n******** TEST " + numTest + "/" + NB_TEST + " ********");
            ligneATester = OutilSaisie.saisirEntier("Entrez un numéro de ligne : ");

            // on affiche la somme de ligneATester pour chacune des 3 matrices de test
            System.out.println("\n  1)  Résultat pour la matrice carrée : ");
            afficherSommeLigne(MATRICE_CARREE, ligneATester);

            System.out.println("\n  2)  Résultat pour la matrice rectangulaire : ");
            afficherSommeLigne(MATRICE_RECTANGLE, ligneATester);

            System.out.println("\n  3)  Résultat pour la matrice irrégulière : ");
            afficherSommeLigne(MATRICE_IRREGUL, ligneATester);

            System.out.println("\n  4)  Résultat pour la matrice nulle : ");
            afficherSommeLigne(MATRICE_NULLE, ligneATester);

        }

    }

    /* ------------------------ Test de Afficher ------------------------ */

    /**
     * Méthode de test de la méthode afficher
     * Elle affiche les 4 matrices jeux de tests
     */
    public static void testAfficher() {
        System.out.println("TEST DE LA METHODE afficher :\n"
                + "----------------------------");
        // TODO : gérer l'erreur
        // on affiche les 4 matrices de test
        System.out.println("\n  1)  Résultat pour la matrice carrée : ");
        try {
            OutilTableau2D.afficher(MATRICE_CARREE);
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        System.out.println("\n  2)  Résultat pour la matrice rectangulaire : ");
        try {
            OutilTableau2D.afficher(MATRICE_RECTANGLE);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("\n  3)  Résultat pour la matrice irregulière : ");
        try {
            OutilTableau2D.afficher(MATRICE_IRREGUL);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("\n  4)  Résultat pour la matrice nulle : ");
        try {
            OutilTableau2D.afficher(MATRICE_NULLE);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    /* ------------------------ Test de matriceCarree ------------------------ */

    /**
     * Méthode de test de la méthode matriceCarree
     * Elle affiche le résultat du test pour les 4 matrices jeux de tests
     */
    public static void testMatriceCarree() {
        System.out.println("TEST DE LA METHODE matriceCarree :\n"
                + "-------------------------------");
        // TODO : gérer l'erreur
        // on affiche le résultat pour les 4 matrices de test
        System.out.print("\n  1)  Résultat pour la matrice carrée : ");
        try {
            System.out.println(OutilTableau2D.matriceCarree(MATRICE_CARREE)
                    ? "carrée"
                    : "pas carrée");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        

        System.out.print("\n  2)  Résultat pour la matrice rectangulaire : ");
        try {
            System.out.println(OutilTableau2D.matriceCarree(MATRICE_RECTANGLE)
                    ? "carrée"
                    : "pas carrée");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        

        System.out.print("\n  3)  Résultat pour la matrice irregulière : ");
        try {
            System.out.println(OutilTableau2D.matriceCarree(MATRICE_IRREGUL)
                    ? "carrée"
                    : "pas carrée");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        

        System.out.println("\n  4)  Résultat pour la matrice nulle : ");
        try {
            System.out.println(OutilTableau2D.matriceCarree(MATRICE_NULLE)
                    ? "carrée"
                    : "pas carrée");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        

    }

    /*
     * ------------------------ Test de sommePremiereDiag ------------------------
     */

    /**
     * Affiche sur la console la somme de la première diagonale de la
     * matrice argument. Si ce n'est pas possible, un message
     * d'erreur est affiché.
     * 
     * @param matrice matrice à partir de laquelle le calcul est fait
     */
    public static void afficherSommePremiereDiag(int[][] matrice) {
        System.out.print("      Somme de la diagonale = ");
        try {
            System.out.println(OutilTableau2D.sommePremiereDiag(matrice));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Méthode de test de la méthode sommePremiereDiag
     * Elle affiche le résultat du test pour les 4 matrices jeux de tests
     */
    public static void testsommePremiereDiag() {
        System.out.println("TEST DE LA METHODE sommePremiereDiag :\n"
                + "--------------------------------------");

        System.out.println("\n  1)  Résultat pour la matrice carrée : ");
        afficherSommePremiereDiag(MATRICE_CARREE);

        System.out.println("\n  2)  Résultat pour la matrice rectangulaire : ");
        afficherSommePremiereDiag(MATRICE_RECTANGLE);

        System.out.println("\n  3)  Résultat pour la matrice irregulière : ");
        afficherSommePremiereDiag(MATRICE_IRREGUL);

        System.out.println("\n  4)  Résultat pour la matrice nulle : ");
        afficherSommePremiereDiag(MATRICE_NULLE);
    }

    /* ------------------------ Test de sommeColonne ------------------------ */

    /**
     * Affiche sur la console la somme de la colonne numéro numColonne de la
     * matrice argument. Si le numéro de colonne est incorrect, un message
     * d'erreur est affiché.
     * 
     * @param matrice    matrice à partir de laquelle le calcul est fait
     * @param numColonne numéro de la colonne dont la somme est affichée
     */
    public static void afficherSommeColonne(int[][] matrice, int numColonne) {
        System.out.print("Somme de la colonne " + numColonne + " = ");

        try {
            System.out.println(OutilTableau2D.sommeColonne(matrice, numColonne));
        } catch (IllegalArgumentException e) {
            System.err.printf(e.getMessage());
        }
    }

    /**
     * Méthode de test de la méthode sommeColonne
     * Le test est interactif : l'utilisateur entre un numéro de colonne
     * La somme des valeurs de cette colonne est affichée, pour chacune
     * des 4 matrices jeux de tests
     */
    public static void testSommeColonne() {

        int colonneATester;
        System.out.println("TEST DE LA METHODE sommeColonne :\n"
                + "---------------------------------");
        for (int numTest = 1; numTest <= NB_TEST; numTest++) {
            System.out.println("\n******** TEST " + numTest + "/" + NB_TEST + " ********");
            colonneATester = OutilSaisie.saisirEntier("Entrez un numéro de colonne : ");

            // on affiche la somme de colonneATester pour chacune des 4 matrices de test
            System.out.println("\n  1)  Résultat pour la matrice carrée : ");
            afficherSommeColonne(MATRICE_CARREE, colonneATester);
            System.out.println("\n  2)  Résultat pour la matrice rectangulaire : ");
            afficherSommeColonne(MATRICE_RECTANGLE, colonneATester);
            System.out.println("\n  3)  Résultat pour la matrice irregulière : ");
            afficherSommeColonne(MATRICE_IRREGUL, colonneATester);
            System.out.println("\n  4)  Résultat pour la matrice nulle : ");
            afficherSommeColonne(MATRICE_NULLE, colonneATester);
        }

    }

    public static void testChercher() {
        int valeurATester;
        System.out.println("TEST DE LA METHODE chercher :\n"
                + "---------------------------------");
        for (int numTest = 1; numTest <= NB_TEST; numTest++) {
            System.out.println("\n******** TEST " + numTest + "/" + NB_TEST + " ********");
            valeurATester = OutilSaisie.saisirEntier("Entrez une valeure a chercher : ");

            System.out.println("\n  1)  Résultat pour la matrice carrée : ");
            OutilTableau2D.cherche(MATRICE_CARREE, valeurATester);
            System.out.println("\n  2)  Résultat pour la matrice rectangulaire : ");
            OutilTableau2D.cherche(MATRICE_RECTANGLE, valeurATester);
            System.out.println("\n  3)  Résultat pour la matrice irregulière : ");
            OutilTableau2D.cherche(MATRICE_CARREE, valeurATester);
            System.out.println("\n  4)  Résultat pour la matrice nulle : ");
            OutilTableau2D.cherche(MATRICE_NULLE, valeurATester);
        }
    }

    /**
     * Programme principal qui lance les méthodes de test
     * 
     * @param args argument non utilisé
     */
    public static void main(String[] args) {

        //  testSommeLigne();

        // testAfficher();
        // testMatriceCarree();
        // testsommePremiereDiag();
        // testSommeColonne();
        testChercher();
    }

}