/*
* FactorielleV3.java			27/11/2022
* IUT de Rodez, pas de droits d'auteur
*/

package iut.info1.bouclesConditionnelles;

import java.util.Scanner;

/**
 * exercices sur les boucles et les conditionnelles
 * @author Costes Quentin
 */

public class DateGregorienne {

    /**
     * demande 3 entiers jour, mois, an sur la console texte
     * (si l'utilisateur n'entre pas des entiers alors le programme s'arrête avec un
     * message d'erreur compréhensible)
     * puis qui vérifie que jour/mois/an représente une date grégorienne correcte 
     * @param args inutilisés
     */

    public static void main(String[] args) {

        final String MESSAGE_ERREUR_SAISIE = "Erreur, entrée incorrecte";
        final String MESSAGE_ERREUR_DATE = "Erreur, date incorrecte";
        final String QUESTION_JOUR = "Entrez le jour : ";
        final String QUESTION_MOIS = "Entrez le mois : ";
        final String QUESTION_AN = "Entrez l'année : ";

        int jour;
        int mois;
        int an;
        boolean reponseOk;
        Scanner entree = new Scanner(System.in); 

        reponseOk = true;
        do {
            System.out.print(QUESTION_JOUR);
            if (entree.hasNextInt()) {
                jour = entree.nextInt();
                System.out.print(QUESTION_MOIS);
                if (entree.hasNextInt()) {
                    mois = entree.nextInt();
                    System.out.print(QUESTION_AN);
                    if (entree.hasNextInt()) {
                        an = entree.nextInt();
                        if (jour > 0 && jour < 32 && mois > 0 && mois < 13 && an > 0) {
                            if (mois == 2) {
                                if (an % 4 == 0 && an % 100 != 0 || an % 400 == 0) {
                                    if (jour > 29) {
                                        System.out.println(MESSAGE_ERREUR_DATE);
                                        reponseOk = false;
                                    }
                                } else {
                                    if (jour > 28) {
                                        System.out.println(MESSAGE_ERREUR_DATE);
                                        reponseOk = false;
                                    }
                                }
                            } else {
                                if (mois == 4 || mois == 6 || mois == 9 || mois == 11) {
                                    if (jour > 30) {
                                        System.out.println(MESSAGE_ERREUR_DATE);
                                        reponseOk = false;
                                    }
                                }
                            }
                        } else {
                            System.out.println(MESSAGE_ERREUR_DATE);
                            reponseOk = false;
                            entree.nextLine();

                        }
                    } else {
                        System.out.println(MESSAGE_ERREUR_SAISIE);
                        reponseOk = false;
                        entree.nextLine();
                    }
                } else {
                    System.out.println(MESSAGE_ERREUR_SAISIE);
                    reponseOk = false;
                    entree.nextLine();

                }
            } else {
                System.out.println(MESSAGE_ERREUR_SAISIE);
                reponseOk = false;
                entree.nextLine();
            }
        } while (!reponseOk);
            
        System.out.println("La date est correcte");
        entree.close();
        
}
}