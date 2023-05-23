/*
 * TousLesPremiers.java                        30/12/22
 * IUT de rodez pas de droits d'auteurs
 */

package iut.info1.instructioniterative3;

import java.util.Scanner;

/**
 * Ce programme recherche tous les nombres premiers inférieurs ou égaux à une
 * valeur limite entrée par l'utilisateur. Les nombres premiers trouvés seront
 * affichés par ligne de 10.
 * 
 * @author Quentin Costes
 */

public class TousLesPremiers {

    /**
     * Programme principal
     * @param args  argument non utilisé
     */

    public static void main(String[] args) {

        
        final int NB_PREMIER_LIGNE = 10;

        int valeurLimiteChoisi;
        int diviseur;
        int rangAffichage;
          

        Scanner entree = new Scanner(System.in);

        System.out.print("Entrez une limite "
                         + "(nombre entier naturel positif supérieur à 1) : ");
        valeurLimiteChoisi = entree.nextInt();

        System.out.print("les nombres premiers inférieur "
                                 + "à la limite donné sont :\n");                                                                 

        rangAffichage = 1;

        for (int nombreTest = 2;
             nombreTest <= valeurLimiteChoisi;
             nombreTest++) {
            
            for (diviseur = 2;
                 nombreTest % diviseur != 0;
                 diviseur++); 
            if (nombreTest == diviseur) {

                rangAffichage++;
                if (rangAffichage > NB_PREMIER_LIGNE) {
                    rangAffichage = 1;
                    System.out.println(diviseur + "\t");

                } else {
                    System.out.print(diviseur + "\t");

                }
            }
        }
    }
}
