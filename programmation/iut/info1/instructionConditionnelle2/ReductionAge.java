/*
 * ReductionAge.java			06/10/2020
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.instructionConditionnelle2;

import java.util.Scanner;

/**
 * exercices sur les structures conditionneles partie 2
 * @author Quentin Costes
 */

public class ReductionAge {

    /**
     * demande à l'utilisateur de donner son age
     * dans le cas où l’âge est valide, 
     * le programme devra dire à l’utilisateur
     *  s’il a droit à une réduction ou pas. 
     */
    
    public static void main(String[] args) {

        final int AGE_MIN_REDUCTION = 18;
        final int AGE_MAX_REDUCTION = 65;
        int age;
        Scanner entree = new Scanner(System.in); 

        System.out.print("Entrez votre age : ");
        if(entree.hasNextInt()) {
            age = entree.nextInt();
            entree.close();
            if (age != 0 && age < 115) {
                if (age > AGE_MAX_REDUCTION || age < AGE_MIN_REDUCTION) {
                    System.out.print("Vous avez droit à une réduction");
                } else {
                    System.out.print("Vous n'avez pas droit à une réduction");
                }
            } else {
                System.out.print("Vous avez entré un age invalide. Relancez le programme ! ");
            }
        } else {
            System.out.print("Veillez a renseigner un entier !"); 
        }
    } 
}