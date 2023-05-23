/* 
 * TestTarifSpectacle.java         06/03/2023
 * IUT de Rodez pas de droits d'auteurs
 */

package semestre2.gestiontest.spectacle;


/**
 * test de la méthode Tarif spectacle
 * @author quentin costes
 */
public class TestTarifSpectacle {

    /** Valeur du code spectacle, pour le jeu de test contenant des valeurs correctes */
    private static final char[] SPECTACLE = {
        'T', 'T', 'T', 'T', 
        'O', 'O', 'O', 'O',
        'C', 'C', 'C', 'C', 
        'D', 'D', 'D', 'D'
    };

    /** Valeur du code catégorie, pour le jeu de test contenant des valeurs correctes */
    private static final char[] CATEGORIE = {
        'S', 'E', 'M', 'P', 
        'S', 'E', 'M', 'P',
        'S', 'E', 'M', 'P', 
        'S', 'E', 'M', 'P'
    };

    /** Valeur du boolean adherent, pour le jeu de test contenant des valeurs correctes */
    private static final  boolean[] ADHERENT = {
        true, false, true, false,
        false, true, false, true,
        true, false, true, false, 
        false, true, false, true
    };

    /** Valeur du résultat attendu, pour le jeu de test contenant des valeurs correctes */
    private static final int[] RESULTAT = {
        14, 17, 21, 25,
        24, 21, 28, 32,
        16, 19, 23, 27,
        21 ,18, 25, 26
    };
    
    /** Valeur du code spectacle, pour le jeu de tests avec valeurs incorrectes */
    private static char[] SPECTACLE_ERR = {'T', 'O', 'C', 'D', 'I', 't', 'c', '5' };

    /** Valeur du code catégorie, pour le jeu de tests avec valeurs incorrectes */
    private static char[] CATEGORIE_ERR = {'i', 'a', '5', 'x', 'ç', 'I', 'Q', '8'};

    /** Valeur du booléen adhérent, pour le jeu de tests avec valeurs correctes */
    private static boolean[] ADHERENT_ERR = {
        true, false, true, false, true, false, true, false, true
    };


    /**
     * 
     */
    public static void testPrixAPayer() {
        System.out.println("Test de la methode prixAPayer :");
        System.out.println("-------------------------------\n");

        int nbTestOk;

        nbTestOk = 0;
        for (int i = 0; i < SPECTACLE.length; i++) {
            if (TarifSpectacle.prixAPayer(SPECTACLE[i], CATEGORIE[i], ADHERENT[i]) == RESULTAT[i]) {
                nbTestOk ++;
            } else {
                System.out.printf("Echec du test avec les valeurs : %s / %s / %b"
                                   , SPECTACLE[i], CATEGORIE[i], ADHERENT[i]);
                System.out.printf("   ==> resultat calclule= %d   resultat attendu = %d \n"
                                    ,TarifSpectacle.prixAPayer(SPECTACLE[i], CATEGORIE[i]
                                    , ADHERENT[i]) ,RESULTAT[i]);
            }
        }

        afficherResultatTest(SPECTACLE.length, nbTestOk);       

    }

        /* *******************   méthode outil pour gérer les tests   ***************** */
    
    
    /**
     * Affiche le résultat d'un test : le nombre de tests réussis et le 
     * nombre de tests total
     * @param nbTestTotal       nombre total de tests effectués
     * @param nbTestOk          nombre de tests réussis
     */
    private static void afficherResultatTest(int nbTestTotal, int nbTestOk) {
        System.out.println("\n" + nbTestOk + " test(s) ont réussi sur un total de "
                + nbTestTotal + " tests réalisés.\n   ==>  "
                + ((nbTestOk == nbTestTotal) ?
                        "Tous les tests sont OK" 
                        : (nbTestTotal - nbTestOk) + " test(s) a (ont) échoué.") + "\n");
    }
    

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        testPrixAPayer();
    }
    
}
