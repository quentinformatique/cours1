/*
 * VenteDVD.java			16/10/2020
 * Quentin costes, pas de droits d'auteur
 */

package info1.programmation;

import java.util.Scanner;

/**
 * Exercice 5 1) 
 * Le programme demandera à l’utilisateur de saisir le nombre de coffrets commandés et le nombre de
 * magazines commandés. On supposera qu’il commande au moins un article. Le programme affichera
 * ensuite :
 * - le montant à payer hors frais de port (montant total y compris coffrets et DVD)
 * - le montant des frais de port
 * - le montant total à payer
 * - le nombre de points cadeau obtenus
 * @author quentin costes (surtout quentin)
 */

public class VenteDVD{

    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in); 

        final int PRIX_COFFRET = 39;
        final int PRIX_MAGAZINE = 9;
        final int FRAIS_DE_PORT = 7;

        int nbMagazines ;
        int nbCoffret ;
        int montantHfp ;
        int montantTotal ;
        int nbPoints ;


        System.out.print("Entrez le nombre de dvd achetés : ");
        nbCoffret = entree.nextInt();
        System.out.print("Entrez le nombre de coffret achetés : ");
        nbMagazines = entree.nextInt();

        montantHfp = nbCoffret * PRIX_COFFRET + nbMagazines * PRIX_MAGAZINE ;
        montantTotal = montantHfp + FRAIS_DE_PORT ;
        nbPoints = montantHfp / 15 ;

        System.out.println("le montant hors frais de port est de : "+ montantHfp);
        System.out.println("le des frais de port est de : "+ FRAIS_DE_PORT);
        System.out.println("le montant total est de : "+ montantTotal);
        System.out.println("le nombre de points cadeau obtenus est de : "+ nbPoints);
        entree.close();
    }
}