/*
 * CodeArticle.java			06/10/2020
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.instructionConditionnelle2;

import java.util.Scanner;

/**
 * exercices sur les structures conditionneles partie 2
 * @author Quentin Costes
 */

public class CodeArticle {

    /**
     * demande à l'utilisateur de donner son age
     * dans le cas où l’âge est valide, 
     * le programme devra dire à l’utilisateur
     *  s’il a droit à une réduction ou pas. 
     */
    
    public static void main(String[] args) {

        int codeArticle;
        Scanner entree = new Scanner(System.in); 
        System.out.print("Entrez un code article : ");
        codeArticle = entree.nextInt();
        entree.close();
        
        // condition code article valide
        if ((codeArticle > 9 && codeArticle < 100) | (codeArticle > 999 && codeArticle < 1000000)) {
            System.out.println("Code article valide (test avec condition code valide)");
        } else {
            System.out.println("Code article invalide (test avec condition code valide)");  
        }
        
        if ((codeArticle < 10 || codeArticle > 99) && (codeArticle < 1000 || codeArticle > 999999)) {
            System.out.println("Code article invalide (test avec condition code invalide)");       
        } else {
            System.out.println("Code article valide (test avec condition code invalide)");
        }
        
    } 
}