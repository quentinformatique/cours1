/*
 * PlacementDoubleV2.java			17/11/2022
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.instructionIteratives;

import java.util.Scanner;


/**
 * exercices sur instructions itératives
 * @author Quentin Costes
 */

public class PlacementDoubleV2 {

    /**
     * demande à l'utilisateur de donner une somme initiale
     * et un taux de placement , le programme retourne le nombre d'années
     * nécessaires pour doubler la somme 
	 * @params args inutilisés
     */
    
    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in); 
        
        double sommeInitiale = 0,
               sommeDouble = 0,
               taux = 0,
               temp;
        boolean entreeIncorrecte;
        int annees = 0;

        do {
            System.out.print("Entrez la somme initiale : ");
            if (entree.hasNextDouble()) {
                temp = entree.nextDouble();
                if (temp < 0) {
                    sommeInitiale = sommeDouble = - temp;
                    System.out.printf("attention : cette somme est négative. Le calcul sera effectué avec %.2f euros\n"
                                       , sommeInitiale);
                    } else {
                        sommeInitiale = sommeDouble = temp;
                    }
                    System.out.print("Entrez le taux de placement : ");
                    if (entree.hasNextDouble()) {
                        taux = (entree.nextDouble()) * 0.01;
                        entreeIncorrecte = false;
                    } else {
                        System.out.println("Vous n'avez pas saisi un entier. Recommencez");
                        entreeIncorrecte = true;
                        entree.nextLine();
                    }
            } else {
                System.out.println("Vous n'avez pas saisi un entier. Recommencez");
                entreeIncorrecte = true;
                entree.nextLine();
            }
        } while (entreeIncorrecte);
        
        do {
            sommeDouble += sommeDouble * taux;
            annees ++;
        } while (sommeDouble < 2 * sommeInitiale);
        System.out.printf("Pour doubler la somme , il faut %d annees", annees);

        entree.close();
    }
}