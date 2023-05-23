/* 
 * Affiche des résultats dans un format imposé
 * AffichagePrecis.java
 */
package info1.programmation;

import java.util.Scanner;

/**
 * Ce programme saisit deux entiers et affiche les résultat de différents 
 * calculs effectués à partir de ces entiers.
 * @author Simon Guiraud
 * version 1.0
 */

public class AffichagePrecis {

    /**
     * Programme principal
     * @param args     argument non utilisé
     */
    public static void main(String[] args) {

    // déclaration d'un objet Scanner pour effectuer des saisies
    Scanner entree = new Scanner(System.in);

    int valeur1;            // premier entier saisi par l'utilisateur
    int valeur2;            // deuxieme entier saisi par l'utilisateur
    int addition;
    int soustraction;
    int division;

    // saisie des deux entiers
    System.out.print("Donnez un nombre entier : ");
    valeur1 = entree.nextInt();
    System.out.print("Donnez un deuxieme nombre entier : ");
    valeur2 = entree.nextInt();

    addition = valeur1 + valeur2;
    soustraction = valeur1 - valeur2;
    division = valeur1 / valeur2;

    System.out.println("Voici differents calculs effectues a partir de ces entiers : ");
    System.out.println("Addition : " + valeur1 + " + " + valeur2 + " = " 
                       + addition);
    System.out.println("Soustraction : " + valeur1 + " - " + valeur2 + " = "
                     + soustraction);
    System.out.println("Division : " + valeur1 + " / " + valeur2 + " = "
                     + division);
    System.out.print("\t\"Au revoir !\"");
    }
}