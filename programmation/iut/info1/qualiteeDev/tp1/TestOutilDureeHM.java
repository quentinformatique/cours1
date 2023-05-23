/*
 * Classe permettant de tester les méthode de la classe OutilDureeHM
 * TestOutilDureeeHM.java                               11/21
 */
package iut.info1.qualiteeDev.tp1;

import java.util.Scanner;

/**
 * Cette classe contient une méthode (au moins) pour tester chacune des méthodes
 * de la classe OutilDureeHM
 * @author INFO1
 * @version 1.0
 *
 */
public class TestOutilDureeHM {
    
    
    /** Objet Scanner pour les saisies au clavier */
    private static  Scanner  entree = new Scanner(System.in);
    
    
    /** Exemples de durées valides */
    private static final int[][] DUREE_VALIDE = { {10, 25}, {9, 0}, {21, 59}, {23, 12}, 
                    {23, 59}, {0, 45}, {0, 0}, {24, 25}, {56, 15}};
    
    
    /** Exemples de durées invalides */
    private static final int[][] DUREE_INVALIDE = { {-1, 12}, {-5, 7}, 
                      {9, -1}, {21, -15}, {23, 60}, {23, 70}, 
                      {50, 145}, {50, -5}, {-1, 33}, {-10, 36}};
    
    
    /** Tableau contenant des durées valides et d'autres invalides */
    private static final int[][] DUREE = { {10, 25}, {9, 0}, {-1, 12}, {21, 59}, 
            {23, 12}, {21, -15},  {23, 59}, {0, 45}, {50, 145}, {0, 0}, {24, 25}, 
            {-1, 33}, {56, 15}, {2000, 0}};
    
    
    /** Duree de référence utilisée dans les tests */
    private static final int[]  REFERENCE = {2, 40};
    
    
    /** Duree à comparer à d'autres durées pour le test d'égalité */
    private static final int[]  A_COMPARER = {21, 59};
    
    
    
    /********************   1 méthode outil pour gérer les tests   ******************/
    
 
    
    /**
     * Affiche le résultat d'un test : le nombre de tests réussis et le 
     * nombre de tests total
     * @param nbTestTotal       nombre total de tests effectués
     * @param nbTestOk          nombre de tests réussis
     */
    private static void afficherResultatTest(int nbTestTotal, int nbTestOk) {
        System.out.println(nbTestOk + " test(s) ont réussi sur un total de "
                + nbTestTotal + " tests réalisés.\n   ==>  "
                + ((nbTestOk == nbTestTotal) ?
                        "Tous les tests sont OK" 
                        : "Au moins un test a échoué.") + "\n");
    }
    
    
    /*************************   test de la méthode estValide   **********************/
    
    
    /**
     * Test de la méthode estValide
     * La méthode estValide est appliquée aux durées du tableau DUREE_VALIDE.
     * Normalement toutes ces durées sont valides.
     * Elle est ensuite appliquée à toutes le durées du tableau DUREE_INVALIDE.
     * Normalement aucune n'est valide.
     */
    public static void testEstValide() {
        int testCorrect;        // nombre de tests corrects        
        System.out.println("\nTest de la méthode de estValide\n"
                           + "--------------------------------\n");
        
        // tests avec des durées valides
        testCorrect = 0;
        for (int i = 0; i < DUREE_VALIDE.length; i++) {
            if (OutilDureeHM.estValide(DUREE_VALIDE[i])) {
                testCorrect++;
            } else {
                System.out.println("Résultat inattendu : " + DUREE_VALIDE[i][0] 
                                   + " h " + DUREE_VALIDE[i][1] 
                                   + " m   a été considérée comme invalide.");
            }
        }
        
        // résultat du test avec des durées valides
        System.out.print("Test avec des durées valides : ");        
        afficherResultatTest(DUREE_VALIDE.length, testCorrect);           
        
        // tests avec des durées invalides        
        testCorrect = 0;
        for (int i = 0; i < DUREE_INVALIDE.length; i++) {
            if (! OutilDureeHM.estValide(DUREE_INVALIDE[i])) {
                testCorrect++;
            } else {
                System.out.println("Résultat inattendu : " + DUREE_INVALIDE[i][0] 
                                   + " h " + DUREE_INVALIDE[i][1]
                                   + " a été considérée comme valide.");
            }
        }
        
        // résultat du test avec des durées invalides
        System.out.print("Test avec des durées invalides : ");
        afficherResultatTest(DUREE_INVALIDE.length, testCorrect);   
                
    }
    
    
    
    
    /*************************   tests de la méthode afficher   **********************/
    
    
    /**
     * Test de la méthode afficher 
     * Premier test à effectuer : très simple
     */
    public static void testAfficherSimplifie() {
        final int[] VALIDE = {12, 25};
        final int[] INVALIDE = {12, 256};
        
        System.out.println("\nTest de la méthode de afficher (test préalable très simple)\n"
                + "-----------------------------------------\n");
        
        // test avec une durée valide
        System.out.print("Exemple d'affichage d'une durée valide :  ");
        try {
            OutilDureeHM.afficher(VALIDE);
        } catch (IllegalArgumentException e) {
            System.out.println("\nle message d'erreur est le suivant : " + e.getMessage());
        }
        
        // test avec une durée invalide
        System.out.print("\nExemple d'affichage d'une durée invalide :  ");
        try {
            OutilDureeHM.afficher(INVALIDE);
        } catch (IllegalArgumentException e) {
            System.out.println("\nTest correct pour l'affichage d'une durée invalide : ");
            System.out.println("le message d'erreur est le suivant : " + e.getMessage());
        }

    }
    
   
    
    /**
     * Test de la méthode afficher 
     * Les durées du tableau DUREE sont affichées seulement si elles sont valides
     */
    public static void testAfficher() {
        
        System.out.println("\nTest de la méthode de afficher\n"
                + "-----------------------------------------------\n");
        
        System.out.println("\nExemples d'affichage de durées valides :  \n");
        for (int i = 0 ; i < DUREE.length ; i++) {
            if (OutilDureeHM.estValide(DUREE[i])) {
                OutilDureeHM.afficher(DUREE[i]);
            }
        }
        
        System.out.println("\n\nTentative d'affichage de toutes les durées : \n");
        for (int i = 0 ; i < DUREE.length ; i++) {
            try {
                OutilDureeHM.afficher(DUREE[i]);
            } catch (IllegalArgumentException e) {
                System.out.println("==> Impossible d'afficher la durée située à l'indice "
                                   + i + ". Elle n'est pas valide");
            }
        }
    }
    
    
    
    
    /***********   tests des méthodes qui effectuent des sommes   **************/
    
    
    /**
     * Test de la méthode somme2Durees 
     * TODO : compléter
     */
    public static void testSomme2Durees() {        
        System.out.println("\nTest de la méthode de somme2Durees\n"
                + "---------------------------------------------------\n");
        
        System.out.print("\n==> TEST 1 - Ajout de la durée ");
        OutilDureeHM.afficher(REFERENCE);
        System.out.println(" à des durées valides: \n");
        // TODO : compléter 
                
        System.out.print("\n==> TEST 2 -  Ajout de la durée ");
        OutilDureeHM.afficher(REFERENCE);
        System.out.println(" à des durées invalides: \n");
        // TODO : compléter        
        
        System.out.print("\n==> TEST 3 - Ajout de la durée ");
        OutilDureeHM.afficher(REFERENCE);
        System.out.println(" à différentes durées valides ou invalides: \n");
        // TODO : compléter      
        
    }

    
    
    /**
     * Test de la méthode sommeTableDuree
     * TODO : compléter
     */
    public static void testSommeTableDuree() {        
        System.out.println("\nTest de la méthode de sommeTableDuree\n"
                + "---------------------------------------\n");
        
        System.out.println("==> TEST 1 - Somme de durées valides :");
        // TODO : compléter 
              
        System.out.println("\n\n==> TEST 2 -  Somme de durées invalides :  ");
        // TODO : compléter 
        
        System.out.println("\n\n==> TEST 3 -  Somme de durées valides ou invalides :  ");
        // TODO : compléter 
                     
    }

    
   
    
    /********   tests des méthodes qui effectuent des tests d'égalité   ************/
    
   
    
    /**
     * Test de la méthode egalite 
     * TODO : compléter
     */
    public static void testEgalite() {        
        System.out.println("\nTest de la méthode Egalite\n"
                + "--------------------------\n");
        
        System.out.print("Comparaison de la durée ");
        OutilDureeHM.afficher(A_COMPARER);
        System.out.println(" à différentes durées valides ou invalides: \n");
        // TODO 
          
    }

    
    
    
    /**
     * Programme principal qui lance les méthodes de test
     * @param args  argument non utilisé
     */
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------\n"
                           + "     TESTS DE LA CLASSE  OUTIL DUREE \n"
                           + "-----------------------------------------------\n");
        
        // testEstValide();
        // testAfficherSimplifie();
        testAfficher();
    }
}