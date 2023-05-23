/*
 * MinimumDeuxEntiers.java			13/11/2022
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.exercicesVacances;

import java.util.Scanner;

/**
 * exercices sur les structures conditionneles
 * @author Quentin Costes
 */

public class MinimumDeuxEntiers {

    /**
     * Demande a l'utilisateur deux entiers
     * puis affiche le minimum des deux entiers entrées
     * @params args inutilisées
     */
    
    public static void main(String[] args) {
  
        int n;
        int p;
        int minimum;

        Scanner analyseurEntree = new Scanner(System.in); 
		
	System.out.print("Entrez un premier entier : ");
	if (analyseurEntree.hasNextInt()) {
            n = analyseurEntree.nextInt();
	    System.out.print("Entrez un second entier : ");
	    if (analyseurEntree.hasNextInt()) {
		p = analyseurEntree.nextInt();
		minimum = n > p ? p : n;
		System.out.printf("Entre %d et %d , c'est %d qui est plus petit !",n ,p, minimum);
		analyseurEntree.close();
	    } else {
		System.out.print("veillez a bien rentrer un entier !");
	    }
        } else {
		System.out.print("veillez a bien rentrer un entier !");
	}	
    }
}