/*
 * FactorielleV3.java			27/11/2022
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.bouclesConditionnelles;

import java.util.Scanner;

/**
 * demande un entier à l'utilisateur sur la console  
 * texte puis renvoie sa factorielle a l'aide d'un for en gerant
 * les dépacements de capicitée des int.<p>
 * Pour rappel la factorielle d'un entier n est : <br><ul>
 * <li>n! = 1 x 2 x 3 x ... x n-1 x n</li>
 * <li>0! = 1! = 1</li></ul>
 * @author Costes Quentin
 */

public class FactorielleV3 {

    /**
     * Demande à l'utilisateur d'entrer un entier naturel pour 
     * calculer sa factorielle.
     * <ul><li>Si l'entree est incorrecte, affiche 
     * un message d'erreur explicite et redemmande un entier.</li>
     * 
     * <li> Sinon affiche la factorielle de l'entier entrée et
     *  propose de recommencer.</li>
     * 
     * 
     * <li> A partir de 13, la factorielle de l'entier ne rentre 
     * plus dans un int, le programme signale alors
     *  qu'il qui n'est pas capable de la 
     * calculer et s'arrête.</li>
     * 
     * </ul>
     * @param args inutilisés
     */

    public static void main(String[] args) {

        final String MESSAGE_ERREUR_SAISIE = "Erreur, entrée incorrecte";
        final String MESSAGE_ERREUR_CALCUL = "Depassement de capacitee";
	    final String QUESTION_OUI_NON = "Entrez \"Oui\" ou \"Non\" pour continuer : ";
        final String OUI = "OUI";
        final String NON = "NON";

        int entierUtilisateur;
        int factorielle;
        String reponse;
	    boolean resultat;
        boolean reponseOk;
        Scanner entree = new Scanner(System.in); 

        factorielle = 1;
        entierUtilisateur = 0;
        reponseOk = false;
        resultat = true;
        do {
            System.out.print("Veuillez entrer un entier naturel positif : ");
            if (!(entree.hasNextInt())) {
                System.out.println(MESSAGE_ERREUR_SAISIE);
                entree.nextLine();
            } else {
                entierUtilisateur = entree.nextInt();
                reponseOk = entierUtilisateur >= 0;
                if (!reponseOk) {
                    System.out.println(MESSAGE_ERREUR_SAISIE);
                } else {
                    if (entierUtilisateur >= 13) {
                        System.out.println(MESSAGE_ERREUR_CALCUL);
                    } else {
                        for (int n = 1; n <= entierUtilisateur; n++) {
                            factorielle = factorielle * n;
                        }
                        System.out.printf("La factorielle de %d est %d%n",
                                          entierUtilisateur, factorielle);
                        factorielle = 1;
                        do {
                            System.out.print(QUESTION_OUI_NON);
                            reponse = entree.next().toUpperCase();
                            entree.nextLine();
                            reponseOk = reponse.equals(OUI) || reponse.equals(NON);
                            if (!reponseOk) {
                            System.out.println(MESSAGE_ERREUR_SAISIE);
                            }	
                        } while (!reponseOk);
                        
                        resultat = reponse.equals(OUI);
                    }
                }
            }
        } while (!reponseOk || resultat); 
        entree.close();
    }
}