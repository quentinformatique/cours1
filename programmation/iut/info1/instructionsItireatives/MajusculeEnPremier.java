/*
 * MajusculeEnPremier.java			08/12/2020
 * IUT de Rodez, pas de droits d'auteur
 */


package iut.info1.instructionsItireatives;

import java.util.Scanner;

/**
 * exercices sur les structures conditionneles
 * @author Quentin Costes
 */

public class MajusculeEnPremier {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;
        
        // On continue à demander la saisie tant qu'elle ne commence pas par une lettre majuscule
        do {
            System.out.print("Veuillez saisir une chaîne débutant par une majuscule : ");
            input = scanner.nextLine();
        } while (!Character.isUpperCase(input.charAt(0)));
        
        System.out.println("Vous avez donnez la chaine : " + input);
        scanner.close();
    }
}