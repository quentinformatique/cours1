/*
 * NombresPremiers.java			14/12/2020
 * IUT de Rodez, pas de droits d'auteur
 */


package instructionsItireatives;

import java.util.Scanner;

/**
 * exercices sur les structures conditionneles
 * @author Quentin Costes
 */

public class NombresPremiers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int entierUser;
        int diviseur;


        System.out.print("Entrez une valeur limite : ");
        entierUser = scanner.nextInt();
        System.out.printf("Les nombres premiers de l'intervalle [ 0 ; %d ] sont : \n"
                                   , entierUser);

        // recherche de tous les nombres premiers entre 0 et entierUser
        for (int n = 0 ; n <= entierUser ; n++) {
            for (diviseur = 2 ; (n % diviseur != 0) && (diviseur * diviseur < n) 
                              ; diviseur ++);
            if (n % diviseur != 0) {
                System.out.print("  " + n + "  ");
            }
        }

        scanner.close();
    }
}