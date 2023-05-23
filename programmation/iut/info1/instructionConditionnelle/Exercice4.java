/*
 * exercice4.java			06/10/2020
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.instructionConditionnelle;

import java.util.Scanner;

/**
 * exercices sur les structures conditionneles
 * @author Quentin Costes
 */

public class Exercice4 {

    /**
     * L’utilisateur entre une durée en heure, minute et seconde. 
     * Le programme devra vérifier au fur et à mesure
     * de la saisie qu’il s’agit bien d’un horaire de la journée 
     */
    
    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in); 
        int heure,
            seconde,
            minute;

        System.out.print("Entrez les heures (entier entre 0 et 23) : ");
        heure = entree.nextInt();
        if ((heure < 0) | (heure > 23)) {
            System.out.println("Heure invalide ! Relancez le programme !");
            System.exit(0);
        }

        System.out.print("Entrez les minutes (entier entre 0 et 59) : ");
        minute = entree.nextInt();
        if ((minute < 0) | (minute > 59)) {
            System.out.println("minute invalide ! Relancez le programme !");
            System.exit(0);
        }

        System.out.print("Entrez les secondes (entier entre 0 et 59) : ");
        seconde = entree.nextInt();
        if ((seconde < 0) | (seconde > 59)) {
            System.out.println("seconde invalide ! Relancez le programme !");
            System.exit(0);
        }

        if (seconde == 59) {
            seconde = 0;
            if (minute == 59) {
                minute = 0;
                if (heure == 23) {
                    heure = 0;
                } else {
                    heure += 1;
                }
            } else {
                minute +=1;
            }
        } else {
            seconde += 1;
        }

        System.out.print("Une seconde plus tard ,");
        System.out.printf("il sera %d heure(s) %d minute(s) %d seconde(s)",
                           heure,minute,seconde);

        entree.close();
    }
}