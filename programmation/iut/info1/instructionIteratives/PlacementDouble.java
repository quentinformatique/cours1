/*
 * PlacementDouble.java			17/11/2022
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.instructionIteratives;

import java.util.Scanner;


/**
 * exercices sur instructions itératives
 * @author Quentin Costes
 */

public class PlacementDouble {

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
               taux = 0;
        int annees = 0;
        boolean entreeIncorrecte;

        do {
            System.out.print("Entrez la somme initiale : ");
            sommeInitiale = sommeDouble = entree.nextDouble();
            if (sommeInitiale > 0 ) {
                System.out.print("Entrez le taux de placement : ");
                taux = (entree.nextDouble()) * 0.01;
                if (taux > 100 || taux < 0){
                    entreeIncorrecte = true;
                    System.out.println("le taux doit entre compris entre 1 et 100");
                    entree.nextLine();
                }
                entreeIncorrecte = false;
            } else {
                entreeIncorrecte = true;
                entree.nextLine();
            }
        } while(entreeIncorrecte);
        
        do {
            sommeDouble += sommeDouble * taux;
            annees ++;
        } while (sommeDouble < 2 * sommeInitiale);
        System.out.printf("Pour doubler la somme , il faut %d annees", annees);

        entree.close();
    }
}