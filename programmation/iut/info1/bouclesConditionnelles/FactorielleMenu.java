/*
 * FactorielleMenu.java			7/12/2022
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.bouclesConditionnelles;

import java.util.Scanner;

/**
 * affiche un menue pour choisir le rang pour rang! 
 * et permet de choisir soit int soit long soit double
 * texte puis renvoie sa factorielle a l'aide d'un for en gerant
 * les dépacements de capicitée des int.<p>
 * Pour rappel la factorielle d'un entier n est : <br><ul>
 * <li>n! = 1 x 2 x 3 x ... x n-1 x n</li>
 * <li>0! = 1! = 1</li></ul>
 * @author Costes Quentin
 */

public class FactorielleMenu {

    /**
     * Demande à l'utilisateur d'entrer un entier naturel pour 
     * calculer sa factorielle.
     * <ul><li>Si l'entree est incorrecte, affiche 
     * un message d'erreur explicite et redemmande un entier.</li>
     * 
     * <li> Sinon affiche la factorielle de l'entier entrée et
     *  propose de recommencer.</li>
     * 
     * 
     * <li> A partir de 13, la factorielle de l'entier ne rentre 
     * plus dans un int, le programme signale alors
     *  qu'il qui n'est pas capable de la 
     * calculer et s'arrête.</li>
     * 
     * </ul>
     * @param args inutilisés
     */

    public static void main(String[] args) { 

        final char QUITTER = 'Q';
        final char LONG = 'L';
        final char DOUBLE = 'D';
        final char INT = 'I';
        final String MENU =
        """
        --------Menue de chois pour la Factorielle--------      
         - Calculer la factorielle en int      :  I
         - Calculer la factorielle en long     :  L
         - Calculer la factorielle en double   :  D
         - Quitter le programme                :  Q

        """;

        char choix;
        Scanner entree = new Scanner(System.in);
        int rangInt;
        long rangLong;
        double rangDouble;

        do {
            System.out.println(MENU);
            System.out.print("Votre choix : ");

            

            switch (choix) {
                case INT :
                System.out.print("Entrez le rang : ");
                rangInt = entree.nextInt();
                break;

                case LONG :
                System.out.print("Entrez le rang : ");
                rangLong = entree.nextLong();
                break;

                case DOUBLE :
                System.out.print("Entrez le rang : ");
                rangDouble = entree.nextDouble();
                break;

                case QUITTER :
                System.out.print("Programme quitté !");
                break;

                default :
                System.out.println("Erreur de saisie, recommencez !");
                entree.nextLine();
                break;

            }

        } while (choix != QUITTER);
    }
}
