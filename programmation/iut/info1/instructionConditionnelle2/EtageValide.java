/*
 * EtageValide.java			06/10/2020
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.instructionConditionnelle2;

import java.util.Scanner;

/**
 * exercices sur les structures conditionneles partie 2
 * @author Quentin Costes
 */

public class EtageValide {

    /**
     * verifie si un etage rentrer par l'utilisateur est valide
     */
    
    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in); 
        int etage;
        System.out.print("Entrez le numéro de l'étage : ");
        etage = entree.nextInt();
        
        // condition étage valide
        if (etage > -4 && etage < 21 && etage != 13) {
            System.out.println("L'étage est valide (test avec condition etage valide)");
        } else {
            System.out.println("L'étage est invalide (test avec condition etage valide)");
        }
        
        // VARIANTE : condition étage invalide
        if (etage < -3 || etage > 20 || etage == 13 ) {
            System.out.println("L'étage est invalide (test avec condition etage invalide)");
        } else {
            System.out.println("L'étage est valide (test avec condition etage invalide)");
        }

    } 
}