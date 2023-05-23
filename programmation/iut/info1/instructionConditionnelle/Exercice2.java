/*
 * exercice2.java			06/10/2020
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.instructionConditionnelle;

import java.util.Scanner;

/**
 * exercices sur les structures conditionneles
 * @author Quentin Costes
 */

public class Exercice2 {

    /**
     * Demande a l'utilisateur deux entier
     * puis determine si l'un des deux est le carré de l'autre
     */
    
    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in); 
        int valeur1,
            valeur2;

        System.out.print("Entrez un premier entier : ");
        valeur1 = entree.nextInt();
        System.out.print("Entrez un second entier : ");
        valeur2 = entree.nextInt();

        if (valeur2 == (valeur1*valeur1)) {
            System.out.printf("%d est le carré de %d",valeur2,valeur1);
        } else if (valeur1 == (valeur2*valeur2)) {
            System.out.printf("%d est le carré de %d",valeur1,valeur2);
        } else {
            System.out.print("aucun nombre n'est le carré de l'autre");
        }

        entree.close();
    }
}