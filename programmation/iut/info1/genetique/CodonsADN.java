/*
 * CodonsADNjava                       31 jan. 2022
 * IUT de Rodez, BUT info1 2022-2023 pas de copyright ni copyleft
 */
package iut.info1.genetique;

import java.util.Scanner;

/**
 * controle de la validitée d'un sequence ADN
 * @author info1 TP2
 */
public class CodonsADN {

    /**
     * 
     * @param args la sequence
     */

    public static void main(String[] args) {

        final char ADENNINE  = 'A';
        final char CYTOSINNE = 'C';
        final char GUANINE   = 'G';
        final char THYNINE   = 'T';

        if (args.length != 1) {
            System.err.print("erreur !");
        }
                   
        String brinADN = args[0];

        if (brinADN.length() % 3 != 0) {
            System.err.print("La longueur de la sequence doit etre multiple de trois");
        }
        
        
    }
}