/*
 * PuissanceV1.java                               29/12/2022
 * IUT de Rodez, info1 2022-2023, pas de copyright ni "copyleft"
 */
package iut.info1.exoNoel;

import java.util.Scanner;

/**
 * exercices sur les float
 * @author info1 TP2
 */
public class PuissanceV1 {

    /**
     * Demander un réel x et une puissance n entier naturel
     * et afficher x^n
     * @param args inutilisé
     */
    public static void main(String[] args) {

        final String MESSAGE_ENTREE
        = "Entrez un réel x : ";
        final String MESSAGE_ENTREE2
        = "Entrez une puissance n : ";

        final String MESSAGE_ERREUR
        = "Entrez un réel et un entier positif";

        float x;
        int n;
        float resultat;
        boolean entreeOk;

        Scanner analyseurConsole = new Scanner(System.in);
        entreeOk = false;
        n = 0;
        x= 0;
        do {
            System.out.print(MESSAGE_ENTREE);
            if (analyseurConsole.hasNextFloat()) {
                x = analyseurConsole.nextFloat();
                analyseurConsole.nextLine();
                System.out.print(MESSAGE_ENTREE2);
                if (analyseurConsole.hasNextInt()) {
                    n = analyseurConsole.nextInt();
                    analyseurConsole.nextLine();
                    if (n >= 0) {
                        entreeOk = true;
                    }
                }
            } else {
                analyseurConsole.nextLine();
            }
            if (!entreeOk) {
                System.out.println(MESSAGE_ERREUR);
            }
        } while (!entreeOk);


        resultat = 1;
        for (int i = 0; i < n; i++) {
            resultat = resultat * x;
        }


        if (x == 0 && n == 0) {
            System.out.println("0^0 n'est pas défini");
        } else {
            System.out.println(x + "^" + n + " = " + resultat);
        }
        
    }
}PuissanceEntiere.java