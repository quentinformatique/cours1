/*
 * PlusPetitDiviseur.java			17/11/2022
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.instructionIteratives;

import java.util.Scanner;


/**
 * exercices sur instructions itératives
 * @author Quentin Costes
 */

public class PlusPetitDiviseur {

    /**
     * demande à l'utilisateur de donner un entier au moins egal a 1
     * le programme affichera le plus petit divisuer de celui ci 
     * (on n'affiche pas 1 sauf si l'entier saisie est 1) 
	 * @params args inutilisés
     */
    
    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in); 
        int entierUtilisateur = 0;
        int plusPetitDiviseur = 1;
        boolean entreeIncorrecte;

        do {
            System.out.print("Entrez une valeur de réference (au moins egale a 1) : ");
            if (entree.hasNextInt()){
                entierUtilisateur = entree.nextInt();
                if (entierUtilisateur <= 0){
                    entreeIncorrecte = true;
                    System.out.println("Erreur. Cet entier est trop petit. Recommencez.");
                    entree.nextLine();
                } else {
                    entreeIncorrecte = false;
                }
            } else {
                entreeIncorrecte = true;
                System.out.println("Erreur. Il faut donner un nombre entier. Recommencez.");
                entree.nextLine();
            }
        } while (entreeIncorrecte);

        for (int n = entierUtilisateur ; n > 1 ; n-- ){
            if(entierUtilisateur % n == 0) {
                plusPetitDiviseur = n ;
            }
        }
        if (entierUtilisateur == 1) {
            System.out.print("1 n'a pas dautres diviseurs que lui-même");
        } else {
            System.out.printf("le plus petit diviseur de %d (autre que 1) est %d"
                               ,entierUtilisateur, plusPetitDiviseur);
        }
        

        entree.close();
    }
}