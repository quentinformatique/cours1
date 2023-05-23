/*
 * Minimum4EntiersV2.java			16/11/2022
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.exercicesVacances;

import static java.lang.System.out;

import java.util.Scanner;

/**
 * Exercices sur les structures conditionnelles : calcul de minimum,
 * et graphe de contrôle
 * @author info1 TP2
 */

public class Minimum4EntiersV2 {

    /**
     * Demande a l'utilisateur quatres entiers sur console
     * en gérant les erreurs de saisie,
     * puis affiche le minimum des quatres entiers entrés
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
            c,
            d;

        int minimum;

	    Scanner analyseurEntree = new Scanner(System.in); 
		
		boolean entreeOk;
		
        out.println("Calcul du minimum de plusieurs nombres");
	    out.print("Entrez un premier entier : ");
		
		entreeOk = analyseurEntree.hasNextInt();
		
		a = 0 ;
	    if (entreeOk) {
            a = analyseurEntree.nextInt();
			out.print("Entrez un second entier : ");
			entreeOk = analyseurEntree.hasNextInt();
		}
		
		b = 0;
		if (entreeOk) {
			b = analyseurEntree.nextInt();
			out.print("Entrez un troisieme entier : ");
			entreeOk = analyseurEntree.hasNextInt();
		}
		
		c = 0;
		if (entreeOk) {
			c = analyseurEntree.nextInt();
			out.print("Entrez un quatrieme entier : ");
			entreeOk = analyseurEntree.hasNextInt();
		}
		
		d = 0;
		if (entreeOk) {
			b = analyseurEntree.nextInt();
			
			minimum = a;
			if (b < minimum) {
				minimum = b;
			}
			if (c < minimum) {
				minimum = c;
			}
			if (d < minimum) {
				minimum = d;
			}
			
			out.printf("min( %d , %d , %d , %d ) = %d",
			           a, b, c, d, minimum);
			
		} else {
			out.print(MESSSAGE_ERREUR_ENTREE);
		}
		
    }
}