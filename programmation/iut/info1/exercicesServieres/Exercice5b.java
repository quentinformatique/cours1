/*
 * Exercice5b.java			16/10/2020
 * Simon Guiraud, pas de droits d'auteur
 */

package info1.programmation;

import java.util.Scanner;

/**
 * Exercice 5 2) 
 * Le programme affiche les intérêts et la somme obtenue après un an
 * puis ceux obtenus après deux ans
 * @author Simon Guiraud
 */

public class Exercice5b{

    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in);
        double placement;
        double taux;
        double interets1;
        double gains1;
        double interets2;
        double gains2;

        System.out.println("Entrez la somme placee en euros : ");
        placement = entree.nextDouble();
        System.out.println("Entrez le taux de placement : ");
        taux = entree.nextDouble()/ 100;

        gains1 = placement + placement*taux;
        interets1 = placement*taux;

        interets2 = gains1*taux;
        gains2 = gains1 + gains1*taux;

        System.out.println("Au bout d'un an, les interets seront de "
                           + interets1 
                           + " euros et la somme totale obtenue égale à "
                           + gains1 + " euros");

        System.out.println("La deuxieme annee les interets seront de " 
                           + interets2 
                           + " euros et la somme totale obtenue égale à "
                           + gains2 + " euros");
    }
}