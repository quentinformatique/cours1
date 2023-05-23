/*
 * NombresPremiers.java			14/12/2020
 * IUT de Rodez, pas de droits d'auteur
 */


package instructionsItireatives;

import java.util.Scanner;

/**
 * exercices sur les structures conditionneles
 * @author Quentin Costes
 */

public class NombresAmis {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int diviseurM;
        int diviseurN;
        int n;
        
        for (int m = 0 ; m <= 10000 ; m ++) {
            diviseurM = 0;
            for (int i = 1 ; i < m ; i ++){
                if (m % i == 0) {
                    diviseurM += i;
                }
            }
            diviseurN = 0;
            for (n = 0 ; n < m ; n ++){
                for (int i = 1 ; i < m ; i ++){
                    if (m % i == 0) {
                        diviseurN += i;
                    }
                }
            }
            if (diviseurM == n && diviseurN == m){
                System.out.printf("(%d,%d)    ",m,n);
            }
        }

        scanner.close();
    }
}