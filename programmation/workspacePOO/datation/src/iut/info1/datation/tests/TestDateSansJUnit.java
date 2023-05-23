/* TestDateSansJUnit.java                     15 févr. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package iut.info1.datation.tests;

import iut.info1.datation.Date;

/**
 * Tests unitaires de iut.info1.datation.Date
 * @author quentin costes
 *
 */
public class TestDateSansJUnit {

    /** 
     * test
     * @param args inutilisés
     */ 
    public static void main(String[] args) {
        testDateIntIntIntok();
        testDateIntIntIntNok();
        System.out.println("\n \n");
        testDifferenceOk();
        testDifferencNok();
    }

    /** 
     * Test unitaires du constructeur Date(int, int, int)
     */
    private static void testDateIntIntIntNok() {
        boolean testOk;
        
        
        System.out.println("test du constructeur de Date(int, int, int) invalides :");
        testOk = true;
        testOk = testOk && verifierCombinaison(31, 12, -1);
        testOk = testOk && verifierCombinaison(31, 12, 1849);
        testOk = testOk && verifierCombinaison(1, 1, 2101);
        testOk = testOk && verifierCombinaison(3, 0, 1910);
        testOk = testOk && verifierCombinaison(17, 13, 2020);
        testOk = testOk && verifierCombinaison(31, 2, 2023);

        
        if (!testOk) {
            System.err.println("Echec du test Constructeur de dates invalide");
        } else {
            System.out.println("Test de Date(int, int, int) invalides réussi");
        }
    }

    /** 
     * @param jj numero du jour entre 1 et 31
     * @param mm numero du mois entre 1 et 12
     * @param aaaa numero d'annee entre AN_MIN et AN_MAX
     * @return true si la cobinaison est valide, false sinon
     */
    private static boolean verifierCombinaison(int jj, int mm, int aaaa) {
        try {
            new Date(jj, mm, aaaa);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }
    
    
    /** 
     * Test unitaires du constructeur Date(int, int, int)
     */
    private static void testDateIntIntIntok() {
        
        System.out.println("test du constructeur de Date(int, int, int) valides :");
        try {
            new Date(1, 1, 1850);
            new Date(1, 1, 2100);
            new Date(10, 5, 2000);
            
            System.out.println("Tests de Date(int, int, int) réussis");
        } catch (IllegalArgumentException e) {
            System.err.println("Echec du testConstructeur de date valide");
        }
    }
    
    private static void testDifferenceOk() {
        boolean testOk;
        
        System.out.println("test de la difference valide enntre deux dates");

        testOk = true;
        testOk = testOk && verifierDifference(new Date(16, 12, 2004), new Date(16, 12, 2008), 4);
        testOk = testOk && verifierDifference(new Date(16, 12, 2008), new Date(16, 12, 2004), 4);
        testOk = testOk && verifierDifference(new Date(1, 1, 1850), new Date(31, 12, 2100), 250);
        testOk = testOk && verifierDifference(new Date(31, 12, 2100), new Date(1, 1, 1850), 250);
        testOk = testOk && verifierDifference(new Date(1, 1, 1850), new Date(31, 12, 2100), 250);
        testOk = testOk && verifierDifference(new Date(1, 1, 2000), new Date(1, 1, 2000), 0);
        testOk = testOk && verifierDifference(new Date(31, 12, 2000), new Date(1, 1, 2000), 0);
        
        if (!testOk) {
            System.err.println("Echec du test de differences invalides de dates");
        } else {
            System.out.println("Test de differences invalides réussi");
        }
        
    }
    
    private static void testDifferencNok() {
        boolean testOk;
        
        System.out.println("test de la difference invalide entre deux dates");
        
        testOk = true;
        testOk = testOk && verifierDifference(new Date(16, 12, 2004), new Date(16, 12, 2008), 8);
        testOk = testOk && verifierDifference(new Date(16, 12, 2008), new Date(16, 12, 2004), 8);
        testOk = testOk && verifierDifference(new Date(1, 1, 1850), new Date(31, 12, 2100), 20);
        testOk = testOk && verifierDifference(new Date(31, 12, 2100), new Date(1, 1, 1850), 0);
        
        if (testOk) {
            System.err.println("Echec du test de differences valides de dates");
        } else {
            System.out.println("Test de difference invalides réussi");
        }
    }

    private static boolean verifierDifference(Date date1, Date date2, int attendu) {
        return date1.differenceAnnee(date2) == attendu;
    }
}
