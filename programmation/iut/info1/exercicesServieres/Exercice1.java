/*
 * Exercice1.java                05/10/22 
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.exerciceServires;

import java.util.Scanner ;

/**
 * Premier exercice de la suite « TP instruction affectation »
 * @author Quentin costes
 */

public class Exercice1 {
  
  /**
   * On demande a l’utilisateur de donner un nombre d’heure,
   * de minutes et de secondes et le programme retourne le nombre
   * total de secondes
   */
    

    public static void main(String[] args) { 
      
      Scanner entree = new Scanner(System.in);
      
      /**
       * Déclaration des variables
       */

      int heure;
      int minutes;
      int secondes;      
      

      /**
       * Lectures des entrées de l’utilisateur
       */
      System.out.print("Veuillez entrer le nombre d’heures");
      heure = entree.nextInt();
      System.out.print("Veuillez entrer le nombre de minutes");
      minutes = entree.nextInt();
      System.out.print("Veuillez entrer le nombre de secondes");
      secondes = entree.nextInt();

      /**
       * Retour de la durée en secondes
       */
      System.out.println("La duree equivalente en seconde est " + ((heure * 60 *60) + minutes * 60 + secondes));
  }
}
