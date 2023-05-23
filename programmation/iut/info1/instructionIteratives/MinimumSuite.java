/*
 * MinimumSuite.java			17/11/2022
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.instructionIteratives;

import java.util.Scanner;

/**
 * exercices sur instructions itératives
 * @author Quentin Costes
 */

public class MinimumSuite {

    /**
     * demande à l'utilisateur de donner une suite d'entier
     * terminée par -1 , le programme retournera le minimum
     * et le maximum de la suite 
	 * @params args inutilisés
     */
    
    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in); 
        int minimum;
        int maximum;
        int temp;
        boolean continuerBoucle = true;

        System.out.println("Entrez une suite d'entiers terminée pas -1");
        System.out.print("Premier entier ? ");
        temp = entree.nextInt();
        minimum = maximum = temp ;
        if (temp > -1) {
            do {
                System.out.print("Entier suivant ? ");
                temp = entree.nextInt();
                if (temp == -1){
                    continuerBoucle = false;
                } else if (temp < minimum ) {
                    minimum = temp;
                } else if (temp > maximum) {
                    maximum = temp;
                }
            } while (continuerBoucle);
            System.out.println("Le minimum des entiers est : " + minimum);
            System.out.print("Le maximum des entiers est : " + maximum);
        } else {
            System.out.print("Vous n'avez pas donne d'entier significatif . Recherche impossible ");
        }
        entree.close();
    }
}