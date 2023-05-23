/* ShiFuMi.java                04/01/2023
 * IUT de Rodze pas de droits d'auteurs
 */
 
package iut.info1.autres;

import java.util.Scanner;

/**
 * Jeu de shifumi ou l'utilisateur entre son choix et l'ordinateur
 * va generer aleatoirement son choix 
 * @author Quentin Costes
 */
 
public class ShiFuMi {
	
	/**
	 *	-------------
	 * @param args inutilises
	 */
	 
	public static void main(String[] args){
		
		final String DEFAITE  = "Pas de chance, vous avez perdu !";
		
		final String VICTOIRE = "Chance, vous avez gagner !";
		
		final String DEMANDE_CHOIX = "Entrez votre choix : ";
		  
		  
		final String PRESENTATION
		= """
		  Ce jeux de ShiFuMi consiste a choisir parmi pierre feuille ou ciseaux
		  \'C\' pour Ciseaux, \'P\' pour Pierre, \'F\' pour Feuille
		  """;
		
		final char CISEAUX = 'C';
		final char FEUILLE = 'F';
		final char PIERRE  = 'P';
		
		char choixOrdi;
		char choixJoueur;
		String ligneEntree;
		
		Scanner analyseurEntree = new Scanner(System.in);
		
		
		System.out.println(PRESENTATION);
		
		do {
			System.out.print(DEMANDE_CHOIX);
			ligneEntree = analyseurEntree.nextLine();
			choixJoueur = ligneEntree.charAt(0);
		}
		
		
		
	
	
	}
	
}