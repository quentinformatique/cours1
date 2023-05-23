/*
 * fichier TousLesAmis.java                        30/12/22
 * IUT de rodez pas de droits d'auteurs
 */

package iut.info1.instructioniterative3;

/**
 * Ce programme recherche toutes les paires de nombres amis (m,n) telles que : m
 *   n < m et n < 10000 
 *   m et  n sont amis
 * Deux nombres m et n sont dits "amis" si la
 * somme des diviseurs de m (m non compris) est égale à n, et si réciproquement,
 * la somme des diviseurs de n (n non compris) est égale à m.
 * 
 * @author Costes quentin
 * @version 1.0
 */

public class TousLesAmis {

    /**
     * Programme principal
     * @param args      argument non utilisé
     */

    public static void main(String[] args) {

        final int LIMITE = 10000;       

        int sommeDiviseurN,             
            sommeDiviseurM,             
            rangAffichage;
            

        rangAffichage = 0;
        System.out.println("Avec la limite " + LIMITE
                           + " les paires de nombres amis sont : ");

        for (int nombreM = 1; nombreM < LIMITE; nombreM++) {
            sommeDiviseurM = 0;
            sommeDiviseurN = 0;

            for (int diviseur1 = 1; diviseur1 <= (nombreM / 2); diviseur1++) {
                if (nombreM % diviseur1 == 0) {
                    sommeDiviseurM += diviseur1;
                }
            }


            for (int diviseur2 = 1;
                    diviseur2 <= (sommeDiviseurM / 2);
                    diviseur2++) {
                
                if (sommeDiviseurM % diviseur2 == 0) {
                    sommeDiviseurN += diviseur2;
                }
            }

            if (sommeDiviseurN == nombreM
                && sommeDiviseurM > sommeDiviseurN) {

                rangAffichage++;

                if (rangAffichage == 5) {
                    rangAffichage = 0;
                    System.out.printf("(%d,%d)\n",
                                        sommeDiviseurN,
                                        sommeDiviseurM);

                } else {
                    System.out.printf("(%d,%d)\t",
                                        sommeDiviseurN,
                                        sommeDiviseurM);
                }
            }
        }
    }
}