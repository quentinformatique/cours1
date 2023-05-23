/*
 * CarreLimite.java         25/11/2022
 * IUT de rodez , pas de droits d'auteurs
 */

package iut.info1.instructionIteratives;

import java.util.Scanner;

/**
 * entrainements sur la comparaison d'approche algorithmique
 * @author CostesQuentin
 */

public class CarreLimite {

    /**
     * l'utilisteur entre un entier , le programme va 
     * afficher tous les entiers naturels strictements positifs dont le 
     * carré est inférieur ou égal a cette valeur limite 
     * @param args inutilisées
     */

    public static void main(String[] args) {

        Scanner analyseurEntree = new Scanner(System.in);

        int entierUtilisateur = 0;
        int carre = 1;
        boolean entreeIncorrecte;

        do {
            System.out.print("Entrez une valeur limite : ");
            if (analyseurEntree.hasNextInt()){
                entreeIncorrecte = false;
                entierUtilisateur = analyseurEntree.nextInt();
                if (entierUtilisateur > 0) {
                    entreeIncorrecte = false;
                } else {
                    System.out.println("Cette valier est trop petite. Recommencez");
                    entreeIncorrecte = true;
                }
            } else {
                System.out.println("Vous n'avez pas saisi un entier. Recommencez");
                entreeIncorrecte = true;
                analyseurEntree.nextLine();
            }
        } while (entreeIncorrecte);

        if (entierUtilisateur != 0) {
            System.out.printf("Les entiers dont le carre est inferieur a %d sont :",entierUtilisateur);

           while (carre * carre <= entierUtilisateur) {
                System.out.printf("  %d",carre);
               carre += 1;
            }
        } else {
             System.out.print("Aucun entier strictement positif n'a un carré inérieur à 0");
        }
        
        analyseurEntree.close();
    }

}
