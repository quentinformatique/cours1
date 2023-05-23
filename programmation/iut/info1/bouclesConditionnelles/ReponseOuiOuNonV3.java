/*
 * ReponseOuiOuNonV3.java                            23/11/2022
 * IUT de Rodez, info1 2022-2023, pas de copyright ni "copyleft"
 */
package iut.info1.bouclesConditionnelles;

import java.util.Scanner;

/**
 * Etude de structures itératives : while et do...while
 * en testant une réponse entrée sur console et redemandée
 * @author Costes Quentin
 */
public class ReponseOuiOuNonV3 {

    /**
     * Demander une réponse à une question oui/non sur console
     * et redemander en cas d'entrée incorrecte
     * @param args inutilisé
     */
    public static void main(String[] args) {

        final String QUESTION_OUI_NON
        = "Etes-vous d'accord (O/N) ? ";

        final String MESSAGE_ERREUR
        = "Tapez un caractere O pour oui, N pour Non";

        final char AFFIRMATION = 'O';
        final char NEGATION = 'N';

        char reponse;

        boolean reponseOk;
        boolean resultat;

        String ligneEntree;
        Scanner analyseurConsole = new Scanner(System.in);
        
        do {
            System.out.print(QUESTION_OUI_NON);
            ligneEntree = analyseurConsole.next();
            analyseurConsole.nextLine();

            reponse =  ligneEntree.length() == 1 ?
                       Character.toUpperCase(ligneEntree.charAt(0))
                     : 'A';
            reponseOk = reponse == 'O' || reponse == 'N'; 
            
            if (!reponseOk) {
                System.out.println(MESSAGE_ERREUR);
            }

        } while (!reponseOk);
        
        resultat = reponse == AFFIRMATION;
        System.out.print("Resultat = " + resultat);
    }
}