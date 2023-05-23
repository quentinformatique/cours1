/*
 * Calcule le prix à payer une fois un bon d'achat déduit
 * CalculAvecBonAchat.java                                                10/22
 */
package iut.info1.exercicesServieres;

import java.util.Scanner;

/**
 * Ce programme demande à l'utilisateur de saisir un prix de base en euros,
 * et le montant d'un bon d'achat.
 * Il calcule et affiche le prix final à payer.
 * Les différents montants sont des nombres entiers.
 * @author INFO1
 * @version 1.0
 */
public class CalculAvecBonAchat {
    
    /**
     * Programme principal
     * @param args argument non utilisé
     */
    public static void main(String[] args) {
        
        // objet Scanner pour les saisies
        Scanner entree = new Scanner(System.in);
        
        int prixDeBase ;        // prix de base saisi par l'utilisateur
        int montantBonAchat;    // montant du bon d'achat, saisi par l'utilisateur
        int montantAPayer;      // montant à payer, calculé par le programme
                
        // saisies du prix initial et du montant du bon d'achat
        System.out.print("Entrez le prix initial de l'article : "); 
	prixDeBase = entree.nextInt();
        System.out.print("Entrez le montant du bon d'achat : ");
	montantBonAchat = entree.nextInt();
        
        // on calcule et on affiche le prix à payer
        montantAPayer = prixDeBase - montantBonAchat;
		
        System.out.println("Pour un prix de base de "+ prixDeBase +" avec une reduction de "
        + montantBonAchat +" le prix a payer est de : "+ montantAPayer);  
                                      
    }
}