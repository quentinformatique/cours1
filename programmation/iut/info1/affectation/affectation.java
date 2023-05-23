/**
 *
 *
 */

package affectation;

import java.util.Scanner;

/**
 *
 *
 */

public class Affectation{

    public static void main(String[] args) {

        int heures;
        int minutes;
        int secondes;
        int resultat;
        Scanner entreeMinutes = new Scanner(System.in);
        Scanner entreeHeures = new Scanner(System.in);
        Scanner entreeSecondes = new Scanner(System.in);
        
        System.out.print("Donnez le nombres d'heures :")
        heures = entreeHeures.nextInt();
        System.out.print("Donnez le nombres de minutes:")
        minutes = entreeMinutes.nextInt();
        System.out.print("Donnez le nombres de secondes:")
        secondes = entreeSecondes.nextInt();
    }
}