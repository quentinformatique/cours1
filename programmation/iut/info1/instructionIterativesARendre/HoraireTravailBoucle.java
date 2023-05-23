/*
 * HoraireTravailBoucle.java            27/12/2022
 * IUT de rodez pas de sroit d'auteur 
 */

package iut.info1.instructioniterative2;

import java.util.Scanner;

/**
 * Ce programme détermine à quelle heure un employé débute sa journée de
 * travail. Cet horaire est fonction du jour de la semaine et du rang de
 * celle-ci dans le mois. Le jour de la semaine sera saisi sous la forme d'une
 * lettre (L,M,m,J,V,S,D)
 * Les saisies du jour de la semaine, et du numéro de la semaine sont 
 * recommencée en cas d'erreur
 * @author Quentin Costes
 */
public class HoraireTravailBoucle {

	/**
	 * Programme principal
	 * @param args argument non utilisé
	 */
	public static void main(String[] args) {

		Scanner entree = new Scanner(System.in);
		char jour;
		int numeroSemaine;
		boolean entreeOK;

		numeroSemaine = 6;

		do {

			System.out.println("'L'undi 'M'ardi 'm'ercredi 'J'eudi 'V'endredi" 
							   + " 'S'amedi 'D'imanche");
			System.out.print("Entrez le jour de la semaine ....... :");
			jour = entree.next().charAt(0);

		} while (jour != 'L' && jour != 'M' && jour != 'm' && jour != 'J' 
				 && jour != 'V' && jour != 'S' && jour != 'D');

		do {
			System.out.print("Entrez le rang de la semaine (de 1 à 5 )" 
							 + "....... :");
			entreeOK = entree.hasNextInt();
			if (entreeOK) {
				numeroSemaine = entree.nextInt(); 
			} else {
				entree.nextLine();
			}
		} while (numeroSemaine < 1 || numeroSemaine > 5);


		switch (jour) {

			case 'L':
			if (numeroSemaine == 5) {
				System.out.println("La personne ne travaille pas ce jour-la !");
			} else {
				System.out.println("La personne debute à 9 heures");
			}
			break;

			case 'M':
			if (numeroSemaine == 2 || numeroSemaine == 4) {
				System.out.println("La personne debute à 9 heures");				
			} else {
				System.out.println("La personne debute à 8 heures");
			}
			break;

			case 'm':
			if (numeroSemaine < 4) {				
				System.out.println("La personne debute à 8 heures");
			} else {
				System.out.println("La personne debute à 14 heures");
			}
			break;

			case 'J':
			if (numeroSemaine == 2 || numeroSemaine == 4) {
				System.out.println("La personne debute à 9 heures");				
			} else {
				System.out.println("La personne debute à 8 heures");
			}
			break;

			case 'V':
			if (numeroSemaine == 1 || numeroSemaine == 2) {
				System.out.println("La personne ne travaille pas ce jour-la !");
			} else if (numeroSemaine == 4) {
				System.out.println("La personne debute à 8 heures 30");
			} else {
				System.out.println("La personne debute à 9 heures");
			}
			break;

			case 'S':
			if (numeroSemaine == 1 || numeroSemaine == 3) {
				System.out.println("La personne debute à 8 heures 30");
			} else {
			System.out.println("La personne ne travaille pas ce jour-la !");
			}

			break;

			case 'D':
			System.out.println("La personne ne travaille pas ce jour-la !");
			break;
			
			default:
				System.out.println("La lettre n'est ni a ni b");
		  }


	}
}