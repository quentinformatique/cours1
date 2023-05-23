/* 
 * Effectue la saisie d'une chaîne débutant et se terminant par une 
 * même lettre
 * MemeLettreDebutFin.java                                        11/12/22
 */
package iut.info1.instructioniterative2;
import java.util.Scanner;

/**
 * Effectue la saisie d'une chaîne qui débute et se termine par une même lettre.
 * La saisie est recommencée en cas d'erreur. 
 * @author Tom Douaud
 * @version 1.0
 */
public class MemeLettreDebutFin {

    /**
     * Programme principal
     * @param args argument non utilisé
     */
    public static void main(String[] args) {
      
        // pour les saisies
        Scanner entree = new Scanner(System.in);
        String chaineSaisie;
        boolean motPasBon;
        boolean entreeOk;
        int longeurMot;
        char premiereLettre;
        char derniereLettre;


        System.out.print("Donnez une chaîne débutant et se terminant par " 
                           + "la même lettre : "); // pas trouvé comment faire si il ya une chaine vide ¯\_(ツ)_/¯
        chaineSaisie = entree.nextLine();
        longeurMot = chaineSaisie.length();
        premiereLettre = chaineSaisie.toUpperCase().charAt(0);
        derniereLettre = chaineSaisie.toUpperCase().charAt(longeurMot -1);
        motPasBon = premiereLettre == derniereLettre;
        
        while (!motPasBon) {

            System.out.println("Erreur. La chaîne entrée ne convient pas. " 
                               + "Recommencez.");
            System.out.print("Donnez une chaîne débutant et se terminant par " 
                             + "la même lettre : ");

            chaineSaisie = entree.nextLine();
            longeurMot = chaineSaisie.length();
            premiereLettre = chaineSaisie.toUpperCase().charAt(0);
            derniereLettre = chaineSaisie.toUpperCase().charAt(longeurMot -1);
            motPasBon = premiereLettre == derniereLettre;

        }
        
        // la chaîne saisie est affichée pour vérification
        System.out.println("Vous avez donné la chaîne " + chaineSaisie);
    }
}

