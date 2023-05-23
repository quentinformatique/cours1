/*
 * Permutation.java			06/10/2020
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.initiation;

import java.util.Scanner;

/**
 * permet de permututer deux variables entrées par l'utilisateur
 * @author Quentin Costes
 */

public class Permutation{

    /**
     * analyse l'entrée de l'utilisateur pour récuperer deux varibles afin 
     * de les permuter
     * @param args inutilisées
     */

    public static void main(String[] args) {

        int p;
        int n;
        int tampon;
        Scanner entree = new Scanner(System.in);

        System.out.print("Entrez la valeur de p : ");
        p = entree.nextInt();
        System.out.print("Entrez la valeur de n : ");
        n = entree.nextInt();
        tampon = n;

        System.out.println("\np avant inversion : " + p);
        System.out.println("n avant inversion : " + n);
	
	n = p;
	p = tampon;

        System.out.println("\np apres inversion V1: " + p);
        System.out.println("n apres inversion V1: " + n);
	
        n += p;
        p = n - p;
        n -=p;


        System.out.println("\np apres inversion V2: " + p);
        System.out.println("n apres inversion V2: " + n);
	
        entree.close();
    }
}