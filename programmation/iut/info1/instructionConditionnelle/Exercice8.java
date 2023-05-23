/*
 * Exercice8.java			03/11/2022
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.instructionconditionelle;

import java.util.Scanner;

/**
 * exercices sur les structures conditionneles
 * @author Quentin Costes
 */

public class Exercice8{

    /**
     * On demande a l'utilisateur trois entiers puis on regarde si 
	 * les entiers sont dans l'ordre croissant, décroissant ou 
	 * si ils sont égaux
     */

    public static void main(String[] args) {

	   /**
		* Déclarations des variables
		*/
		
		int entier1;
		int entier2;
		int entier3;
		Scanner entree = new Scanner(System.in);
		
	   /**
		* Demandes a l'utilisateur
		*/
		
		System.out.print("\n\nDonnez un premier entier : ");
		entier1 = entree.nextInt();
		System.out.print("\nDonnez un deuxieme entier : ");
		entier2 = entree.nextInt();
		System.out.print("\nDonnez un troisieme entier : ");
		entier3 = entree.nextInt();
		
		if ((entier1 < entier2) && (entier2 < entier3)) {
			System.out.println("Les 3 entiers " + entier1 + ", " + entier2 
								+ ", " + entier3 
								+ " sont dans l'ordre croissant");
		} else if ((entier1 > entier2) && (entier2 > entier3)) {
			System.out.println("Les 3 entiers " + entier1 + ", " + entier2 
								+ ", " + entier3 
								+ " sont dans l'ordre décroissant");
		} else if ((entier1 == entier2) && (entier2 == entier3)) {
			System.out.println("Les 3 entiers " + entier1 + ", " + entier2 
								+ ", " + entier3 
								+ " sont dans egaux");
		} else {
			System.out.println("Les 3 entiers " + entier1 + ", " + entier2 
								+ ", " + entier3 
								+ " sont dans le desordre");
		}
    }
}