/*
 * EquationSecondDegree.java                         29/12/2022
 * IUT de Rodez, info1 2022-2023, pas de copyright ni "copyleft"
 */
package iut.info1.exoNoel;

import java.util.Scanner;

/**
 * exercices sur les float
 * @author info1 TP2
 */
public class EquationSecondDegree {

    /**
     * Résoudre une équation du second degré ax²+bx+c=0
     * Dans R
     * @param args inutilisé
     */
    public static void main(String[] args) {
    
        final String MESSAGE_ENTREE
        = "Entrez un réel a : ";
        final String MESSAGE_ENTREE2
        = "Entrez un réel b : ";
        final String MESSAGE_ENTREE3
        = "Entrez un réel c : ";
    
        final String MESSAGE_ERREUR
        = "Entrez trois réels";
    
        float a;
        float b;
        float c;
        float delta;
        float x1;
        float x2;
        boolean entreeOk;
    
        Scanner analyseurConsole = new Scanner(System.in);
        entreeOk = false;
        a = 0;
        b = 0;
        c = 0;
        do {
            System.out.print(MESSAGE_ENTREE);
            if (analyseurConsole.hasNextFloat()) {
                a = analyseurConsole.nextFloat();
                analyseurConsole.nextLine();
                System.out.print(MESSAGE_ENTREE2);
                if (analyseurConsole.hasNextFloat()) {
                    b = analyseurConsole.nextFloat();
                    analyseurConsole.nextLine();
                    System.out.print(MESSAGE_ENTREE3);
                    if (analyseurConsole.hasNextFloat()) {
                        c = analyseurConsole.nextFloat();
                        analyseurConsole.nextLine();
                        entreeOk = true;
                    }
                    }
            } else {
                analyseurConsole.nextLine();
            }
            if (!entreeOk) {
                System.out.println(MESSAGE_ERREUR);
            }
        } while (!entreeOk);

        System.out.println("L\'équation est : " + a + "x²+" + b + "x+" + c + "=0");

        delta = b * b - 4 * a * c;
        if (delta < 0) {
            System.out.println("Pas de solution");
        } else if (delta == 0) {
            x1 = -b / (2 * a);
            System.out.println("Une solution : " + x1);
        } else {
            x1 = (-b - (float) Math.sqrt(delta)) / (2 * a);
            x2 = (-b + (float) Math.sqrt(delta)) / (2 * a);
            System.out.println("Deux solutions : " + x1 + " et " + x2);
        }
             
    }
}