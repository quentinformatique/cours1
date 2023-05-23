/*
 * fichier Patinage.java                                             26-12-0022
 * IUT de rodez pas de droit d'auteurs
 */

package iut.info1.instructioniterative3;

import java.util.Scanner;

/**
 * Calcul des notes obtenues au patinage artistique. La note d'un candidat est
 * égale à  : 
 *   (somme des notes - note minimale - note maximale ) / (nombre notes - 2) 
 * Le programme permet de gérer NB_CANDIDAT candidats notés par NB_JUGE juges.
 * La saisie d'une note est recommencée en cas d'erreur.
 * @author Costes Quentin
 */
public class Patinage {

    /**
     * Fonction principale
     * @param args   argument non utilisé
     */

    public static void main(String[] args) {

        final int NB_JUGE = 5;          
        final int NB_CANDIDAT = 2;    
        final int NOTE_MAXI = 20;      
        final int NOTE_MINI = 0;        
        int numeroJuge;
        int numeroCandidat;
        int note;
        int somme;
        int max;
        int min;
        double moyenne;

        numeroJuge = 1;
        numeroCandidat = 1;
        note = 100;
        somme = 0;
        min = 20;
        max = 0; 

        Scanner entree = new Scanner(System.in);


        System.out.println("La note d'un candidat est un entier " 
                           + "compris entre 0 et 20.");
        for (int i = 0; i < NB_CANDIDAT; i++) {

            System.out.println("\n\nSaisie des notes pour le candidat numéro " 
                               + numeroCandidat + " : ");
            System.out.println("\n-----------------------------------------" 
                               + "--------\n");

            for (int j = 0; j < NB_JUGE; j++) {


                note = 100;
                
                while (note < NOTE_MINI || note > NOTE_MAXI) {

                    System.out.print("Note du juge " + numeroJuge + " ? ");
                    
                    while (!entree.hasNextInt()) {
                        
                        System.out.println("Erreur de saisie ! Donnez un " 
                        + "entier !");
                        System.out.print("Note du juge " + numeroJuge + " ? ");
                        entree.next();
                        
                    }
                    
                    note = entree.nextInt();
                    
                    
                    if (note < NOTE_MINI || note > NOTE_MAXI) {
                        
                        System.out.println("Erreur de saisie ! La note est " 
                        + "comprise entre 0 et 20.");
                        
                    }
                }
                
                somme += note;

                if (note < min) {
                    min = note;
                }
                if (note > max) {
                    max = note;
                }

                numeroJuge++;

            }

            moyenne = ((somme - min) - max) / (numeroJuge - 3);
            System.out.println("\nLa note finale du candidat " 
                               + numeroCandidat + " est " + moyenne);

            numeroCandidat++;
            numeroJuge = 1;
            somme = 0;
            min = 20;
            max = 0;

        }
        
    }

}
