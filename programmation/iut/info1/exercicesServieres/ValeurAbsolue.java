/*
 * ValeurAbsolue.java			16/10/2020
 * Quentin costes, pas de droits d'auteur
 */

package info1.programmation.exercicesServieres;

import java.util.Scanner;

/**
 * 
 * @author Simon Guiraud et quentin costes (surtout quentin)
 * 
 */

public class ValeurAbsolue{

    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in); 

        int valeur;
        int valeurAbsolue;

        System.out.print("Entrez une valeur :");
        valeur = entree.nextInt();
	    valeurAbsolue = valeur;

        if (valeur < 0) {
            valeurAbsolue = valeur * - 1;
        }

        System.out.printf("votre valeur est %d , sa valeur absolue est %d", valeur, valeurAbsolue);

        entree.close();
    }
}