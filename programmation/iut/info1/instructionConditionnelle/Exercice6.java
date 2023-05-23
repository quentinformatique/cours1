/*
 * Exercice6.java			14/10/2020
 * IUT de Rodez, pas de droits d'auteur
 */

package  iut.info1.instructionConditionnelle;

import java.util.Scanner;

/**
 * exercices sur les structures conditionneles
 * @author Quentin Costes
 */
 
public class Exercice6 {

    /**
     * à partir du nombre de plats commandés, 
     * affiche le montant hors taxe des plats cuisinés
     * le montant hors taxe des emballages
     */

    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in); 
        final double PRIX_PLAT = 6.17;
        final double EMBALLAGE = 0.25;
        final double EMBALLAGE_REDUCTION = 0.10;
        final double REDUCTION = 0.15;
        final double TVA = 0.20;
        int nombrePlats;
        double prixEmballages;
        double montantTVA;
        double prixFinal;

        System.out.print("Nombre de plats commandés : ");
        nombrePlats = entree.nextInt();

        prixEmballages = nombrePlats > 20 ? (EMBALLAGE_REDUCTION * nombrePlats) : (prixEmballages = EMBALLAGE * nombrePlats;);
        montantTVA = (prixEmballages*TVA) + ((PRIX_PLAT * nombrePlats)*0.20);
        prixFinal = prixEmballages + montantTVA + PRIX_PLAT * nombrePlats;


        System.out.printf("Montant HT des plats ................. : %.2f \n",(PRIX_PLAT * nombrePlats));
        System.out.printf("Montant HT des embalages ............. : %.2f \n",prixEmballages);
        System.out.printf("Montant HT des TVA ................... : %.2f \n",montantTVA);
        System.out.printf("Montant total de la facture .......... : %.2f",prixFinal);


    }
}