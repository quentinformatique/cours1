/* 
 * Effectue la saisie d'une chaîne débutant par une lettre majuscule
 * MajusculeEnPremier.java                                        11/22
 */
package iut.info1.instructioniterative2;
import java.util.Scanner;

/**
 * Effectue la saisie d'une chaîne qui débute par une lettre majuscule.
 * La saisie est recommencée en cas d'erreur. 
 * @author Tom Douaud
 * @version 1.0
 */
public class MajusculeEnPremier {

    /**
     * Programme principal
     * @param args argument non utilisé
     */
    public static void main(String[] args) {
      
        // pour les saisies
        Scanner entree = new Scanner(System.in);

        String chaineMajuscule;
        char premiereLettre;

        System.out.print("Donnez une chaîne débutant par une majuscule : ");
        chaineMajuscule = entree.nextLine();
        premiereLettre = chaineMajuscule.charAt(0);

        if (Character.isUpperCase(premiereLettre)) {
            System.out.println("Le premier caractère de la chaîne est en " 
                               + "majuscule.");
        } else {
            System.out.println("Le premier caractère de la chaîne n'est pas " 
                               + "en majuscule.");
        }
    }
}
