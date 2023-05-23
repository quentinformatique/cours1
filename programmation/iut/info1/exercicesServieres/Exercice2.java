/*
 * Exercice2.java                05/10/22 
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.exerciceServires;

import java.util.Scanner ;


/**
 * Deuxième exercice de la suite « TP instruction affectation »
 * @author Quentin costes
 */

public class Exercice2 {
  
  /**
   * On demande a l’utilisateur une durée en secondes
   * puis le programme la convertit en minutes et heures
   */
    

    public static void main(String[] args) { 
      
      Scanner entree = new Scanner(System.in);
      
      /**
       * Déclaration des variables
       */

      int heure;
      int minutes;
      int secondes;      
      int secondesUtilisateur;
      System.out.println("Programme de conversion secondes en heures/minutes/secondes.");
      /**
       * Lecture de l'entrée de l’utilisateur
       */
      System.out.print("Veuillez entrer le nombre de secondes");
      secondes = entree.nextInt();

      /**
       * Calculs de conversions
       */
      
      heure = secondesUtilisateur / 3600;
      secondesUtilisateur %= 3600;
      minutes = secondesUtilisateur / 60;
      secondesUtilisateur %= 60;
      seconde = secondesUtilisateur;

      /**
       * Retour de la durée en minutes et en heures
       */
      System.out.println("La duree equivalente est "  heure " heure (s) " minutes " minutes (s) " seconde " seconde (s)" );
  }
}
