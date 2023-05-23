/*
 * MinimumQuatresEntiers.java			06/10/2022
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.exercicesVacances;

import java.util.Scanner;

/**
 * exercices sur les structures conditionneles
 * @author Quentin Costes
 */

public class MinimumQuatresEntiers {

    /**
     * Demande a l'utilisateur quatres entiers
     * puis affiche le minimum des quatres entiers entrées
     * @params args inutilisées
     */
    
    public static void main(String[] args) {

        int a,
            b,
            c,
            d,
            minimum;
	Scanner analyseurEntree = new Scanner(System.in); 
		
		System.out.print("Entrez un premier entier : ");
		if (analyseurEntree.hasNextInt()) {
			a = analyseurEntree.nextInt();
			System.out.print("Entrez un second entier : ");
			
			if (analyseurEntree.hasNextInt()) {
			    b = analyseurEntree.nextInt();
			    System.out.print("Entrez un troisieme entier : ");
			
			    if (analyseurEntree.hasNextInt()) {
			        c = analyseurEntree.nextInt();
			        System.out.print("Entrez un quatrieme entier : ");
				if (analyseurEntree.hasNextInt()) {
						d = analyseurEntree.nextInt();;
						
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
						
						System.out.printf("min( %d , %d , %d , %d ) = %d",
						                  a, b, c, d, minimum);
						analyseurEntree.close();
						
					} else {
						System.out.print("veillez a bien rentrer un entier !");
					}
		        } else {
		       	    System.out.print("veillez a bien rentrer un entier !");
		        }
		    } else {
			    System.out.print("veillez a bien rentrer un entier !");
		    }
		} else {
			System.out.print("veillez a bien rentrer un entier !");
		}
    }
}