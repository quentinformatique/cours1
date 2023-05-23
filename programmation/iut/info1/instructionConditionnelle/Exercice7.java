/*
 * Exercice7.java			03/11/2022
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.instructionconditionelle;

import java.util.Scanner;

/**
 * exercices sur les structures conditionneles
 * @author Quentin Costes
 */

public class Exercice7{

    /**
     * On demande tout d'abord a l'utilisateur de rentrer une horaire puis 
     * une autre en vérifiant que les valeurs sont bonnes puis il compare
     * et renvoie laquelle des durée est la plus courte
     * @params args inutilisés
     */

    public static void main(String[] args) {

        /*
         * Déclaration des variables
         */

        Scanner entree = new Scanner(System.in);
        int seconde1;
        int minute1;
        int heure1;
        int seconde2;
        int minute2;
        int heure2;

        /*
         * Demandes a l'utilisateurs (premiere durée)
         */

        System.out.println("\n===> Saisie de la premiere duree");

        System.out.print("\n\nEntrez les heures (entier de 0 et 23) : ");
        heure1 = entree.nextInt();

        if (heure1 < 0 || heure1 > 23) {
            System.out.print("Heure invalide ! Relancez le programme !");
            System.exit(1);
        }

        System.out.print("\nEntrez les minutes (entier de 0 et 59) : ");
        minute1 = entree.nextInt();

        if (minute1 < 0 || minute1 > 59) {
            System.out.print("Minute invalide ! Relancez le programme !");
            System.exit(1);
        }

        System.out.print("\nEntrez les secondes (entier de 0 et 59) : ");
        seconde1 = entree.nextInt();

        if (seconde1 < 0 || seconde1 > 59) {
            System.out.print("Seconde invalide ! Relancez le programme !");
            System.exit(1);
        }

        /*
         * Demandes a l'utilisateurs (seconde durée)
         */

        System.out.println("\n\n===> Saisie de la deuxieme duree");

        System.out.print("\n\nEntrez les heures (entier de 0 et 23) : ");
        heure2 = entree.nextInt();

        if (heure2 < 0 || heure2 > 23) {
            System.out.print("Heure invalide ! Relancez le programme !");
            System.exit(1);
        }

        System.out.print("\nEntrez les minutes (entier de 0 et 59) : ");
        minute2 = entree.nextInt();

        if (minute2 < 0 || minute2 > 59) {
            System.out.print("Minute invalide ! Relancez le programme !");
            System.exit(1);
        }

        System.out.print("\nEntrez les secondes (entier de 0 et 59) : ");
        seconde2 = entree.nextInt();

        if (seconde2 < 0 || seconde2 > 59) {
            System.out.print("Seconde invalide ! Relancez le programme !");
            System.exit(1);
        }

        if ((heure1 == heure2) && (minute1 == minute2) && (seconde1 == seconde2)) {
            System.out.print("Les 2 durees sont egales."); 
            
        } else if ((heure1 > heure2) || (heure1 == heure2 && minute1 > minute2) || (heure1 == heure2 && minute1 == minute2 && seconde1 > seconde2)) {
                System.out.println("La deuxieme duree est la plus courte : "
                                    + heure2 + " heure(s) " + minute2 
                                    + " minute(s) " + seconde2 + " seconde(s) ");
        } else {
            System.out.println("La premiere duree est la plus courte : "
            + heure1 + " heure(s) " + minute1 
            + " minute(s) " + seconde1 + " seconde(s) ");
        }


    }
}