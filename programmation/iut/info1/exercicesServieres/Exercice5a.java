/*
 * Exercice5a.java			16/10/2020
 * Quentin costes, pas de droits d'auteur
 */

package info1.programmation.ExercicesServieres;

import java.util.Scanner;

/**
 * Exercice 5 1) 
 * Le programme affiche les intérêts et la somme obtenue après un an.
 * @author Simon Guiraud et quentin costes (surtout quentin)
 */

public class Exercice5a{

    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in); 
        double placement;
        double taux;
        double interets;
        double gains;
        double secondeAnneeGains;
        double secondeAnneeInteret;

        System.out.println("******************** Calculs pour un placement financier *******************");

        System.out.print("Entrez la somme placee en euros : ");
        placement = entree.nextDouble();
        System.out.print("Entrez le taux de placement : ");
        taux = entree.nextDouble()/ 100;

        gains = placement + placement*taux;
        interets = placement*taux;
        secondeAnneeGains =  gains + gains*taux;
        secondeAnneeInteret = gains*taux;
        System.out.printf("Au bout d'un an, les intérêts seront de %.2f euros\n", interets);
        System.out.printf("et la somme obtenue égale à %.2f euros\n", gains );
        System.out.printf("\nLa deuxième année les intérêts seront de %.2f euros\n", secondeAnneeInteret);
        System.out.printf("La deuxième année les intérêts seront de %.2f euros", secondeAnneeGains);
        
        entree.close();
    }
}