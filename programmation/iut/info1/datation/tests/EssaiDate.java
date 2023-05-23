/*
 * EssaiDate.java                                           08/02/2023
 * IUT de Rodez, BUT info1 2022-2023 pas de copyright ni copyleft
 */

package iut.info1.datation.tests;

import iut.info1.datation.Date;

/**
 * simple mise en oeuvre de iut.info.datation.Date
 * @author info1 TP2
 */

public class EssaiDate {

    public static void main(String[] args) {

        Date parDefault = new Date();

        System.out.println("date par defaul = " + parDefault);
        System.out.println("jour : "  + parDefault.getJj());
        System.out.println("mois : "  + parDefault.getMm()); 
        System.out.println("annee : " + parDefault.getAaaa());  
    }
    
}