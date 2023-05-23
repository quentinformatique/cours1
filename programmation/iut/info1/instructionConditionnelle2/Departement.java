/*
 * Departement.java			06/10/2020
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.instructionConditionnelle2;

import java.util.Scanner;

/**
 * exercices sur les structures conditionneles partie 2
 * @author Quentin Costes
 */

public class Departement {

    /**
     * L'utilisateur entre un numéro de département.
     * Si celui-ci est invalide, le programme prévient l'utilisateur.
     * Dans le cas contraire, le programme indique où réside la personne :
     * - à Paris
     * - en petite couronne
     * - en Ile de France
     * - en Province
     */
    
    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in); 
        int region;
        System.out.print("Entrez votre numéro de département : ");
        region = entree.nextInt();

        if (region >0 || region <= 95) {
            switch (region) {
            case 75 :
				System.out.print("Vous habitez à Paris ! ");
			case 77 :
			case 78 :
			case 91 :
			case 95 :
                System.out.print("Vous habitez dans la région Ile de France !");
				break;
            case 93 :
            case 92 :
            case 94 :
                System.out.print("Vous habitez la petite couronne !");
                break;
            default :
                System.out.print("Vous habitez en Province ! ");
                break;
            }
        } else {
			System.out.print("Entrée incorrecte");
		}


        entree.close();
    } 
}