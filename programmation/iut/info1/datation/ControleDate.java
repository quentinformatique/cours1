/*
 * ControleDate.java                       14 dec. 2022
 * IUT de Rodez, BUT info1 2022-2023 pas de copyright ni copyleft
 */
package datation;

import java.util.Scanner;

/**
 * Controler la validité d'une combinaison grégorienne jj/mm/aaaa
 * @author info1 TP2
 */
public class ControleDate {

    /** TODO comment field role (attribute, associative role) */
    public final static String REGEX_DATE
    = "[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}";

    /**
     * Outil en ligne de commande indiquant si une combinaison jj/mm/aaaa
     * représente une date du calendrier grégorien dans une période AN_MIN à AN_MAX
     * @param args la date au format jj/mm/aaaa à controller
     */

    public static void main(String[] args) {

        final int CODE_EXIT_ERREUR_NB_ARGS = 1;

        final String MESSAGE_ERREUR_NB_ARGS
        = "Mauvais nombre d'arguments en ligne de commande, 1 seul argument exige";

        final String AIDE
        = "usage : java iut.info1.datation.ControleDate jj/mm/aaaa";

        /* la combinaison à vérifier */
        int jj,
            mm,
            aaaa;

        Scanner analyseurArgument;

        /* analyse de la ligne de commande */
        if (args.length != 1) {
            System.err.println(MESSAGE_ERREUR_NB_ARGS);
            System.out.println(AIDE);
            System.exit(CODE_EXIT_ERREUR_NB_ARGS);
        }
        // else
        analyseurArgument = new Scanner(args[0]);

        if (!analyseurArgument.hasNext(REGEX_DATE)) {
            System.out.println(args[0] 
                               + " n'a pas le format d'une date jj/mm/aaaa");
        } else {
            /* extraction des entiers jj, mm, aaaa */
            analyseurArgument.useDelimiter("/");
            jj   = analyseurArgument.nextInt();
            mm   = analyseurArgument.nextInt();
            aaaa = analyseurArgument.nextInt();

            /* vérifier la validité de jj/mm/aaaa */
            System.out.printf("Combinaison : jour = %d   mois = %d   an = %d\n",
                              jj, mm, aaaa);

            if (OutilsDate.isValide(jj, mm, aaaa)) {
                System.out.println(args[0] + " est une date correcte");
            } else {
                System.out.println(args[0] + " n'est pas une date correcte");
            }
        }
    }
}