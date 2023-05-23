/*
 * CaclulTVA.java			14/10/2020
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.exercicesServieres;

import java.util.Scanner;

/**
 * exercices d'entrainement faclcutatif
 * Calcul la TVA de l'utilisateur
 * @author Quentin Costes
 */
 
public class CalculTVA {


    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in); 
		double montantHT;
		float tauxTVA;
		float montantTVA;
		float montantTTC;
		
		System.out.print("Enrtez le montant hors taxes :");
		montantHT = entree.nextDouble();
				if (Double.parseDouble(montantHT)) {
			System.out.println("Erreur de saisie. Relancez le programme !");
			System.exit(0);
		}
    }
}