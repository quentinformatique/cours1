/*
 * Exercice3.java                05/10/22 
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.exerciceServires;

import java.util.Scanner ;
import java.lang.Math ;

/**
 * Troisième exercice de la suite « TP instruction affectation »
 * @author Quentin costes
 */

public class Exercice3 {
  
  /**
   * On demande a l’utilisateur un nombre réel x et un entier p
   * Le programme calcule ensuite et rends x^p
   */
    

    public static void main(String[] args) { 
      
      Scanner entree = new Scanner(System.in);
      
      /**
       * Déclaration des variables
       */

      float x;
      int p; 
      int valeurFinale 
      
      /**
       * Lecture des entrées de l’utilisateur
       */
      System.out.print("Veuillez entrer le réel x");
      x = entree.nextFloat();

      System.out.print("Veuillez entrer l'entier p");
      p = entree.nextInt();

      /**
       * Calcul de x a la puissance p
       */
      
      valeurFinale = Math.pow(x,p)

      System.out.println("La valeure finale de " + x + " puissance " p " est de " + valeurFinale);
  }
}
