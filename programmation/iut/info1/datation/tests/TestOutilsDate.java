/*
 * TestOutilsDate.java                       11/01/2023
 * IUT de Rodez, BUT info1 2022-2023 pas de copyright ni copyleft
 */
package iut.info1.datation.tests;

import iut.info1.datation.OutilsDate;

import static iut.info1.iutUnit.Assertions.assurerVrai;
import static iut.info1.iutUnit.Assertions.assurerFaux;


/**
 * Controler la validité d'une combinaison grégorienne jj/mm/aaaa
 * @author info1 TP2
 */

public class TestOutilsDate {

    /**
     * lancement des Tests 
     * @param args inutilisés
     * @return true si jour, mois, an est une date, false sinon
     */
    public static void main(String[] args) {

        try {
            testIsValide();
        } catch (Exception defaultDetecte) {
            System.err.print(defaultDetecte.getMessage());
        }
    }

    /* package */ static void testIsValide() throws Exception {

        assurerFaux(OutilsDate.isValide(1, 1, -1),      "1/1/-1 doit etre Faux");
        assurerFaux(OutilsDate.isValide(23, 7, 3000),   "23/7/3000 doit etre Faux");
        assurerFaux(OutilsDate.isValide(31, 12, 1849),  "31/12/1849 doit etre Faux");
        assurerFaux(OutilsDate.isValide(1, 1, 2101),    "1/1/2101 doit etre Faux");
        assurerFaux(OutilsDate.isValide(29, 2, 2023),   "30/2/2023 doit etre Faux");
        assurerFaux(OutilsDate.isValide(0, 2, 2023),    "0/2/2023 doit etre Faux");
        assurerFaux(OutilsDate.isValide(29, 14, 2023),  "30/14/2023 doit etre Faux");


        assurerVrai(OutilsDate.isValide(1, 1, 1850),    "1/1/1850 doit etre Vrai");
        assurerVrai(OutilsDate.isValide(31, 1, 2100),   "31/1/2100 doit etre Vrai");
        assurerVrai(OutilsDate.isValide(12, 12, 2023),  "12/12/2023 doit etre Vrai");

        System.out.print("tests Reussis !");
    }

}