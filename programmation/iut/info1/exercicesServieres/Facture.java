/*
 * Facture.java			14/10/2020
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.exercicesServieres;

import java.util.Scanner;

/**
 * exercices 1 sur les instruction d'affectation
 * affiche le resume d'une facture EDF mensuelle
 * @author Quentin Costes
 */
 
public class Facture {

    /**
     * recupere les relevees pour afficher 
	 * le nombre de kwh consommes
     * le montant hors taxes de la facture 
	 * le montant total de la TVA
	 * le montant TTC de la facture en euros et en francs
     */

    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in); 
				
		final double PRIX_KWH = 0.0883;
		final double ABONNEMENT = 5.56;
		final double TVA_CONSO = 0.20;
		final double TVA_ABO = 0.055;
		

		int premierReleve;
		int nouveauReleve;
		int consommation;
		double montantHT;
		double montantTVA;
		double totalEuros;
		double totalFranc;
		
		//recuperation des releves
		
		System.out.print("Entrez l'ancien releve : ");
		premierReleve = entree.nextInt();
		System.out.print("Entrez le nouveau releve : ");
		nouveauReleve = entree.nextInt();

		if (premierReleve > nouveauReleve) {
			System.out.print("Le premier releve est plus grand que le nouveau ...");
			 System.exit(1);
		}

		consommation = nouveauReleve - premierReleve;
		montantHT = consommation * PRIX_KWH + ABONNEMENT;
		montantTVA = consommation * PRIX_KWH * TVA_CONSO + ABONNEMENT * TVA_ABO;
		totalEuros = montantHT + montantTVA;
		totalFranc = totalEuros * 6.55957;
		
		System.out.println("Consomation..................... : " + consommation);
		System.out.println("Montant hors taxes ............. : " + montantHT);
		System.out.println("Montant de la TVA .............. : " + montantTVA);
		System.out.printf("Total........................... : %.2f \n", totalEuros);
		System.out.printf("Total en francs................. : %.2f \n", totalFranc);
    }
}