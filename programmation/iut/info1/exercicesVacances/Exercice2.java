/*
 * exercice1.java			06/10/2020
 * IUT de Rodez, pas de droits d'auteur
 */


package iut.info1.exercicesVacances;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * exercices sur les structures conditionneles
 * @author Quentin Costes
 */

public class Exercice2 {

    /**
     * Demande a l'utilisateur deux entiers
     * puis affiche le minimum des deux entiers entrées
     */

    public static void main(String[] args) {

        int firstInteger,
            secondInteger;
        Scanner entree = new Scanner(System.in);
        try {
            /*
             * Demande des deux entiers à l'utilisateur.
             * renvoie le plus grand des deux
             */
            System.out.print("Premier entier : ");
            firstInteger = entree.nextInt();

            System.out.print("Second entier : ");
            secondInteger = entree.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Les valeurs ne sont pas "
                             + "des entiers.");
            entree.close();
            return;
        }

        if (firstInteger == secondInteger) {
            System.out.println("Les deux entiers sont "
                                + "identiques.");
        } else {
            System.out.printf("%d est le plus petit nombre.", 
                            firstInteger > secondInteger 
                            ? secondInteger 
                            : firstInteger);
        }
        entree.close();
    }
}
