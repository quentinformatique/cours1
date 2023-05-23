/*
 * TestPuissanceEntiere.java                             6 feb. 2023
 * IUT de Rodez, info1 2022-2023, pas de copyright ni "copyleft"
 */
package iut.info1.mathematiques.tests;

import static iut.info1.mathematiques.FonctionsReelles.puissance;

/**
 * 
 * @author info1 TP2
 */
public class TestPuissanceEntiere {

    /* jeu de test unitaire = "fixture" de test */
    private static final double[] NOMBRES_A_EXPONENTIER = {
        -2.0e200, -1.5e15,            // x < 0.0, |x| grand
        -314.1592, -10.0,             // x < 0.0, |x| "normal"
        -1.0,
        -7.19e-10, -Double.MIN_VALUE, // x < 0.0, |x| petit
        -0.0, 0.0,
         Double.MIN_VALUE, 2.0e-5,    // x > 0.0, |x| petit
         1.0,
         Math.E,                      // x > 0.0, |x| "normal"
         5.2e20, Double.MAX_VALUE,    // x > 0.0, |x| grand 
         Double.POSITIVE_INFINITY,
         Double.NEGATIVE_INFINITY,
         Double.NaN
    };

    /**
     * Tests unitaires de la méthode puissance
     *
     * @param args non utilisé
     */
    public static void main(String[] args) {
 
        // TODO tests unitaires
        boolean testOk;

        /* exposant négatif non pris en compte */
        testOk = true;
        for (int exposant = -1 ; testOk && exposant < 0 ; exposant -= 1000) {
             try {
                 puissance(1.0, exposant);
                 testOk = false;
                 System.err.printf("echec de test : 1.0 puissance %d calculable \n",
                                   exposant);

             } catch(IllegalArgumentException exposantNegatif) {
                 /* test ok : exception propagée */
                 // testOk = true;
             }
        }

        /* qqsoit x, x puissance 0 == 1.0 */
        for (int noJeu = 0 ; 
             testOk && noJeu < NOMBRES_A_EXPONENTIER.length;
             noJeu++) {

             testOk = puissance(NOMBRES_A_EXPONENTIER[noJeu], 0) == 1.0;
             if (!testOk) {
                 System.err.printf("echec de test : puissance(%e, 0) != 1.0 \n",
                                   NOMBRES_A_EXPONENTIER[noJeu]);
             }
        }
        
        testOk = puissance(-2.0e200, 4) == Double.POSITIVE_INFINITY;
        if (!testOk) {
            System.err.printf("echec de test : puissance(%e, %d) != %e \n",
                              -2.0e200, 4, Double.POSITIVE_INFINITY);
        } 

        if (testOk) {
            System.out.println("tests reussis");
        }
    }
}