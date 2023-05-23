/*
 * Median.java			21/11/2022
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.exercicesVacances;

import static java.lang.System.out;

import java.util.Scanner;

/**
 * Exercices sur les structures conditionnelles : calcul du median
 * de trois nombres
 * @author Costes Quentin
 */

public class Median {

    /**
     * Demande a l'utilisateur trois entiers sur console
     * en gérant les erreurs de saisie,
     * puis affiche le médian des trois entiers entrés
     * @params args inutilisé
     */
    public static void main(String[] args) {

        final String MESSSAGE_ERREUR_ENTREE
        = """
          Erreur : entrez des entiers en base 10,
          exemples : -97, 0, 45, 67895 
          """;

        int a,   // nombres à comparer
            b,
            c;

        int median;

	    Scanner analyseurEntree = new Scanner(System.in); 
        boolean entreeOk;
	
	    a = 0;
	    b = 0;
	    c = 0;
	
         out.println("Calcul du median de trois nombres");
	    out.print("Entrez un premier entier : ");
	    entreeOk = analyseurEntree.hasNextInt();
        if (entreeOk) {
            a = analyseurEntree.nextInt();
            analyseurEntree.nextLine();
            out.print("Entrez un second entier : ");
			entreeOk = analyseurEntree.hasNextInt();
        }
			
        
        if (entreeOk) {
            b = analyseurEntree.nextInt();
            analyseurEntree.nextLine();
            out.print("Entrez un troisieme entier : ");
			entreeOk = analyseurEntree.hasNextInt();
        }
		
		
        if (entreeOk) {
            c = analyseurEntree.nextInt();
			
            median = a;						
            if (a >= b && a<= c) {
                median = a;	
            } else {
			
				if (a >= c && a<= b) {
					median = a;
				} else {
					
					if (b >= a && b<= c) {
					median = b;
					} else {
						if (b >= c && b<= a) {
							median = b;
						} else {
							median = c;
						}
					}
          		}
            }			
						
            out.printf("Le médian de %d, %d et %d est %d",
		       a, b, c, median);
	    } else {
            out.print(MESSSAGE_ERREUR_ENTREE);
	    }
	    analyseurEntree.close();
    }
}