/*
 * Classe de test des méthodes de la classe OutilHoraire
 * TestOutilHoraire.java                                               04/22
 */
package semestre2.gestiontest.horaire;

import java.util.Scanner;


/**
 * Classe de tests unitaires qui contient les méthodes de test 
 * des méthodes de la classe OutilHoraire.
 * 
 * La classe contient 2 méthodes générales :
 *    - l'une qui affiche un texte de synthèse indiquant le nombre de tests
 *      corrects par rapport à un nombre total de test
 *    - l'autre qui invite l'utilisateur à taper sur 'entrée' pour continuer
 *            
 * @author INFO1
 * @version 1.0
 */
public class OutilHoraireTest {
    
    
    /** Objet Scanner pour effectuer les saisies au clavier */
    private static Scanner entree = new Scanner(System.in);
    

    /* ======================================================================== */
    /*                                  Jeux de tests                           */
    /* ======================================================================== */
   
    
    /* --------------------  Jeux de test méthode estChiffre ------------------ */
    
    /** jeu de test pour la méthode estChiffre : valeurs correctes */
    private static final char[] CHIFFRE = { '0', '1', '2', '3', '4', '5', 
                                            '6', '7', '8', '9'}; 
    

    /** jeu de test pour la méthode estChiffre : valeurs incorrectes */
    private static final char[] NON_CHIFFRE = { ':', ';', 'a', 'o', 'O', 'A',
                                                '~', '/', '.', '!', '&'}; 
    
    /* --------------------  Jeux de test méthode estValide ------------------ */
    

    /** jeu de test avec des chaînes invalides (pour un horaire) */
    private static final String[] HORAIRE_INVALIDE = {
        "25h00", "23h60", "12:00", "1h2", "24h00", "00h60", "12",  
        "12h60", "12h0", "12h", "12H00", "000h00", "00h000", "06h60",
        "08h61", "18h-1", "12h00am", "24h30", "-1h00",
        "12h-1"
    };
    
    private static final String[] HORAIRE_VALIDE = {
        "00h00", "00h01", "01h30", "12h00", "23h59",
        "10h15", "08h45", "15h30", "19h00", "22h45", 
        "05h15"
    };
    
    
    /* ------------  Jeux de test méthodes de conversion ------------------ */
    
    // TODO
   
  
    
    /* ======================================================================== */
    /*                 2 méthodes outils pour gérer les tests                   */
    /* ======================================================================== */
   
    
    /**
     * Demande à l'utilisateur d'appuyer sur entrée pour continuer
     */
    private static void continuer() {
        System.out.println("\n\n\nAppuyer sur entrée pour continuer les tests.") ;
        entree.nextLine();
        System.out.println("\n\n");
    }
    
    
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
                        : (nbTestTotal - nbTestOk) + " tests ont échoué.") + "\n");
    }
    
    
    /* ======================================================================== */
    /*           Test des méthodes de vérification de validité                  */
    /* ======================================================================== */
    
    private static void testEstChiffre() {
        int nbTestOk;
        
        System.out.println("\t==> a) tests avec des chiffres");
        nbTestOk =  0;
        for (int i = 0; i < CHIFFRE.length; i++) {
           if (OutilHoraire.estChiffre(CHIFFRE[i])) {
               nbTestOk ++;
           } else {
               System.out.printf("Erreur : la methode a détecté que %s n'est pas un chiffre.\n",
                                 CHIFFRE[i]);
           }
        }
        afficherResultatTest(CHIFFRE.length, nbTestOk);
        
        System.out.println("\t==> b) tests autres caractères");
        nbTestOk =  0;
        for (int i = 0; i < NON_CHIFFRE.length; i++) {
           if (!OutilHoraire.estChiffre(NON_CHIFFRE[i])) {
               nbTestOk ++;
           } else {
               System.out.printf("Erreur : la methode a détecté que %s est un chiffre.\n",
                                  NON_CHIFFRE[i]);
           }
        }
        afficherResultatTest(NON_CHIFFRE.length, nbTestOk);
    }
    
    private static void testEstHoraireValide() {
        int nbTestTotal = 0;
        int nbTestOk = 0;

        System.out.println("Test avec des horaires valides");
        for (String horaire : HORAIRE_VALIDE) {
            nbTestTotal++;
            if (OutilHoraire.estHoraireValide(horaire)) {
                nbTestOk++;
            } else {
                System.out.println("Erreur : la méthode a détecté que "
                                   + horaire
                                   + " n'est pas une horaire valide.");
            }
        }
        afficherResultatTest(nbTestTotal, nbTestOk);
        nbTestTotal = 0;
        nbTestOk = 0;

        System.out.println("Test avec des horaires invalides");
        for (String horaire : HORAIRE_INVALIDE) {
            nbTestTotal++;
            if (!OutilHoraire.estHoraireValide(horaire)) {
                nbTestOk++;
            } else {
                System.out.println("Erreur : la méthode a détecté que "
                                   + horaire
                                   + " est un horaire valide.");
            }
        }
        afficherResultatTest(nbTestTotal, nbTestOk);
    }
    
    /* ======================================================================== */
    /*                        Test des méthodes  de conversion                  */
    /* ======================================================================== */
    
    
    // TODO 
    
    

    /* ======================================================================== */
    /*                         Test obtention heure courante                    */
    /* ======================================================================== */
    
   
    // TODO 
    
    /* ======================================================================== */
    /*                             Test des méthodes de saisie                  */
    /* ======================================================================== */
    
    // TODO 
    
    /**
     * Programme principal qui lance les méthodes de test
     * @param args  argument non utilisé
     */
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------\n"
                           + "     TESTS DE LA CLASSE  OUTIL HORAIRE \n"
                           + "-----------------------------------------------\n");
        
        // TODO 
        continuer();
        
        System.out.println("Test de la méthode estChiffre");
        System.out.println("-----------------------------");
        testEstHoraireValide();
       
    }

}