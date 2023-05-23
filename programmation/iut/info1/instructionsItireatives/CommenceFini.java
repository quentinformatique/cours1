/*
 * CommenceFini.java			08/12/2020
 * IUT de Rodez, pas de droits d'auteur
 */


package iut.info1.instructionsItireatives;

import java.util.Scanner;

/**
 * exercices sur les structures conditionneles
 * @author Quentin Costes
 */

public class CommenceFini {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Demande à l'utilisateur de saisir une chaîne
        System.out.print("Veuillez saisir une chaîne qui commence et fini par la même lettre : ");
        String chaine = (scanner.next() + scanner.nextLine()).strip();

        while (chaine.charAt(0) != chaine.charAt(chaine.length() - 1)) {
            
            System.out.println("La chaîne n'est pas valide, veuillez saisir une nouvelle chaîne.");
            System.out.print("Veuillez saisir une chaîne : ");
            chaine = (scanner.next() + scanner.nextLine()).strip();
        }

        // Affiche un message de confirmation si la chaîne est valide
        System.out.println("La chaîne est valide.");
        scanner.close();
    }
}