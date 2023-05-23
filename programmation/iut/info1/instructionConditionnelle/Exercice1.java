/*
 * exercice1.java			06/10/2020
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.instructionConditionnelle;

import java.util.Scanner;

/**
 * exercices sur les structures conditionneles
 * @author Quentin Costes
 */

public class Exercice1 {

    /**
     * Demande a l'utilisateur un entier
     * puis affiche la valeur absolue de celui ci
     */
    
    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in); 
        int valeur;

        System.out.print("Entrez un entier : ");
        valeur = entree.nextInt();

        if (valeur < 0) {
            valeur = valeur * -1;
        }

        System.out.print("La valeur absolue est : " + valeur);
        entree.close();
    }
}