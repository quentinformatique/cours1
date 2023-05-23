/*
 * Exercice4.java                05/10/22 
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.exercicesServieres;

import java.util.Scanner ;
/**
 * quatrieme exercice de la suite « TP instruction affectation »
 * @author Quentin costes
 */

public class Exercice4 {
  
  /**
   * On demande a l’utilisateur un nombre de joueurs et de cartes a distribuer
   * puis le programme retourne le nombre de carte de chaques joueurs et le reste
   */
    

    public static void main(String[] args) { 
      
        Scanner entree = new Scanner(System.in);
        int joueurs;
        int cartes;

        System.out.print("Entrez le nombre de joueurs :");
        joueurs = entree.nextInt();
        System.out.print("Entrez le nombre de cartes:");
        cartes = entree.nextInt();

        System.out.print("\nIl y a "+ joueurs +" joueurs , qui auront chacun "
        + cartes / joueurs +" cartes et "+ cartes % joueurs +" ne seront pas distribués");
    }
}
