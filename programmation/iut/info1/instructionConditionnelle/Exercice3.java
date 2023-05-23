/*
 * exercice3.java			06/10/2020
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.instructionConditionnelle;

import java.util.Scanner;

/**
 * exercices sur les structures conditionneles
 * @author Quentin Costes
 */

public class Exercice3 {

    /**
     * demande à l'utilisateur de donner une heure, sous la forme d'un nombre
     * d'heures, de minutes et de secondes,
     * et qui affiche l'heure qu'il sera une seconde plus tard.
     */
    
    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in); 
        int heure,
            seconde,
            minute;

        System.out.print("Entrez les heures (entier entre 0 et 23) : ");
        heure = entree.nextInt();
        System.out.print("Entrez les minutes (entier entre 0 et 59) : ");
        minute = entree.nextInt();
        System.out.print("Entrez les secondes (entier entre 0 et 59) : ");
        seconde = entree.nextInt();
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