/*
 * exercice1.java			06/10/2020
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.exercicesVacances;

import java.util.Scanner;

import java.lang.Math;

/**
 * exercices sur les structures conditionneles
 * @author Quentin Costes
 */

public class Exercice4 {

    /**
     * Demande a l'utilisateur quatres entiers
     * puis affiche le minimum des quatres entiers entrées
     */
    
    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in); 
        int entier1,
            entier2,
            entier3;

        int valeurmin;
        int valeurmax;

        System.out.print("Entrez un premier entier : ");
        entier1 = entree.nextInt();
        System.out.print("Entrez un second entier : ");
        entier2 = entree.nextInt();
        System.out.print("Entrez un troisieme entier : ");
        entier3 = entree.nextInt();

        valeurmin = Math.min(entier3, Math.min(entier1, entier2));
        valeurmax = Math.max(entier3, Math.max(entier1, entier2));

        if ((valeurmin == entier1) && (valeurmax == entier3)) {

            System.out.println("le median de " + entier1 + ", " + entier2 + ", " + entier3 + " est " + entier2);

        } else if ((valeurmin == entier3) && (valeurmax == entier1)) {

                System.out.println("le median de " + entier1 + ", " + entier2 + ", " + entier3 + " est " + entier2);

        } else if ((valeurmin == entier1) && (valeurmax == entier2)) {

            System.out.println("le median de " + entier1 + ", " + entier2 + ", " + entier3 + " est " + entier3);

        } else if ((valeurmin == entier1) && (valeurmax == entier2)) {

            System.out.println("le median de " + entier1 + ", " + entier2 + ", " + entier3 + " est " + entier3);

        } else if ((valeurmin == entier2) && (valeurmax == entier3)) {

            System.out.println("le median de " + entier1 + ", " + entier2 + ", " + entier3 + " est " + entier1);

        } else if ((valeurmin == entier2) && (valeurmax == entier3)) {

            System.out.println("le median de " + entier1 + ", " + entier2 + ", " + entier3 + " est " + entier1);

        }

        entree.close();
    }
}











