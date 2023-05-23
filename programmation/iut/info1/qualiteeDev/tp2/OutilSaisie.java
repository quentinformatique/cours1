/**
 * Méthodes outils pour saisir des entiers
 * OutilSaisie.java                                     11/21
 */
package iut.info1.qualiteeDev.tp2;

import java.util.Scanner;

/**
 * Cette classe contient des méthodes outils pour effectuer des saisies d'entier
 * Les saisies sont recommencées en cas d'erreur de la part de l'utilisateur
 * 
 * @author C. Servières
 * @version 1.0
 *
 */
public class OutilSaisie {

    /**
     * Saisie d'un entier. La saisie est recommencée en cas d'erreur
     * 
     * @return l'entier saisi (un entier quelconque)
     */
    public static int saisirEntier() {
        Scanner entree = new Scanner(System.in);
        int valeur = 0;
        boolean correct = false; // on suppose que la saisie est incorrecte

        // on recommence la saisie jusqu'à ce qu'elle soit correcte
        do {
            System.out.print("Entrez un entier : ");
            if (entree.hasNextInt()) { // l'utilisateur a entré un entier
                valeur = entree.nextInt();
                correct = true;
            }
            entree.nextLine(); // on vide le tampon d'entrée
        } while (!correct);
        return valeur; // on renvoie l'entier saisi
    }

    /**
     * Saisie d'un entier. La saisie est recommencée en cas d'erreur
     * 
     * @param message affiché pour l'utilisateur
     * @return l'entier saisi (un entier quelconque)
     */
    public static int saisirEntier(String message) {
        Scanner entree = new Scanner(System.in);
        int valeur = 0;
        boolean correct = false; // on suppose que la saisie est incorrecte

        // on recommence la saisie jusqu'à ce qu'elle soit correcte
        do {
            System.out.print(message);
            if (entree.hasNextInt()) { // l'utilisateur a entré un entier
                valeur = entree.nextInt();
                correct = true;
            }
            entree.nextLine(); // on vide le tampon d'entrée
        } while (!correct);
        return valeur; // on renvoie l'entier saisi
    }

    /**
     * Saisie d'un entier positif ou nul. La saisie est recommencée en cas
     * d'erreur
     * 
     * @param message affiché pour l'utilisateur
     * @return l'entier saisi
     */
    public static int saisirEntierPositif(String message) {
        Scanner entree = new Scanner(System.in);
        int valeur = -1; // initialisée avec un entier incorrect

        // on recommence la saisie jusqu'à obtenir un entier positif ou nul
        do {
            System.out.print(message);
            if (entree.hasNextInt()) { // l'utilisateur a entré un entier
                valeur = entree.nextInt();
            }
            entree.nextLine(); // on vide le tampon d'entrée
        } while (valeur < 0);

        return valeur; // on renvoie l'entier saisi
    }

    /**
     * Saisie d'un entier appartenant à un intervalle. La saisie est recommencée
     * en cas d'erreur (les bornes de l'intervalle sont considérées comme des
     * valeurs correctes que l'utilisteur peut saisir)
     * 
     * @param message   affiché pour l'utilisateur
     * @param inferieur borne inférieure de l'intervalle
     * @param superieur borne supérieure de l'intervalle
     * @return l'entier saisi
     */
    public static int saisirEntierIntervalle(String message, int inferieur,
            int superieur) {
        Scanner entree = new Scanner(System.in);
        int valeur = inferieur - 1; // initialisée avec un entier incorrect

        /*
         * on recommence la saisie jusqu'à obtenir un entier
         * appartenant à l'intervalle
         */
        do {
            System.out.print(message);
            if (entree.hasNextInt()) { // l'utilisateur a entré un entier
                valeur = entree.nextInt();
            }
            entree.nextLine(); // on vide le tampon d'entrée
        } while (valeur < inferieur || valeur > superieur);
        return valeur; // on renvoie l'entier saisi
    }

}