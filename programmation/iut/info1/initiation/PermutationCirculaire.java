/*
 * PermutationCirculaire.java			06/10/2020
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.initiation;

import java.util.Scanner;

/**
 * permet de permututer trois variables entrées par l'utilisateur
 * @author Quentin Costes
 */

public class PermutationCirculaire{

    /**
     * analyse l'entrée de l'utilisateur pour récuperer trois varibles afin 
     * de les permuter et les renvoyer
     */

    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in);
		int a;
		int b;
		int c;
		int tampon;
		
		System.out.print("Veuiller rentrer un entier a : ");
		a = entree.nextInt();
	    System.out.print("\nVeuiller rentrer un entier b : ");
		b = entree.nextInt();
		System.out.print("\nVeuiller rentrer un entier c : ");
		c = entree.nextInt();

		System.out.println("Vous avez entree comme valeurs :\n a : " + a 
		+ "\n b : " + b + "\n c : " + c);
	
		tampon = a;
		a = b;
		b = c;
		c = tampon;
		System.out.println("La permutation donne comme valeur:\n a : " + a 
		+ "\n b : " + b + "\n c : " + c);
		
		entree.close();
    }
}