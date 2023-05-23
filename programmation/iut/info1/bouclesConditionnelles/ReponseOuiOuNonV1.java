/*
 * ReponseOuiOuNonV1                                23/11/2022
 * IUT de Rodez, info1 2022-2023, pas de copyright ni "copyleft"
 */
package iut.info1.bouclesConditionnelles;

import java.util.Scanner;

/**
 * Etude de structures itératives : while et do...while
 * en testant une réponse entrée sur console et redemandée
 * @author info1 TP2
 */
public class ReponseOuiOuNonV1 {

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

        // TODO initialisations
        reponse = 'A';      // pour contrôle d'init
        reponseOk = false;  // pour au moins 1 itération
                            // donc do...while ???
        while (!reponseOk ) {
            System.out.print(QUESTION_OUI_NON);
            ligneEntree = analyseurConsole.next();
            analyseurConsole.nextLine();

            if (ligneEntree.length() == 1) {
                reponse = ligneEntree.charAt(0);
                reponse = Character.toUpperCase(reponse);
                reponseOk = reponse == 'O' || reponse == 'N';
            }

            if (!reponseOk) {
                System.out.println(MESSAGE_ERREUR);
            }
        }
        
        resultat = reponse == AFFIRMATION;
        System.out.println("Resultat = " + resultat);
    }
}