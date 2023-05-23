/* 
 * Test manuel de la méthode prixAPayer de la classe TarifSpectacle
 * TestManuelTarifSpectacle                                 04/22
 */
package semestre2.gestiontest.spectacle;

import java.util.Scanner;

/**
 * Ce programme demande à l'utilisateur de saisir le type de spectacle choisi,
 * la catégorie du spectateur, et l'information concernant une carte d'adhérent
 * éventuelle. Il calcule et affiche ensuite le montant à payer pour l'achat
 * d'un billet de spectacle.
 * Si le testeur le souhaite, il peut continuer pour faire un autre test
 * 
 * @author INFO1
 * @version 1.0
 * 
 */
public class TestManuelTarifSpectacle {
    /**
     * Programme principal qui appelle la méthode prixAPayer de la classe TarifSpectacle
     * dans le but de la tester manuellement
     * 
     * @param args argument non utilsé
     */
    public static void main(String[] args) {

        // déclaration d'un objet Scanner pour les opérations de saisie
        Scanner entree = new Scanner(System.in);

        boolean adherent;        // vrai si le spectateur est adhérent
        String categorie,        // classe ou catégorie du spectateur
               spectacle;        // spectacle choisi (saisie de l'utilisateur)
        String reponse;          // réponse à la question adhérent ou refaire un test
        char codeCategorie,      // caractère égal au code de la catégorie du spectateur
             codeSpectacle;      // caractère égal au code du spectacle
        int montantAPayer;       // prix à payer 
        boolean recommencer;     // vrai si l'utilisteur souhaite refaire un test
        
        do { 
            // Saisie des données
            System.out.println("\n\nCodes pour la catégorie      ==>  "
                    + "'S'colaire,'E'tudiant,'M' = autre 'M'oins de 25 ans, "
                    + "'P' = autre 'P'lus de 25 ans\n"
                    + "Codes pour le spectacle      ==>  "
                    + "'T'heatre,'O'pera,'D'anse,'C'oncert\n");
            
            
            System.out.print("Categorie du spectateur ..... : ");
            categorie = entree.nextLine();
            
            System.out.print("Spectacle choisi ............ : ");
            spectacle = entree.nextLine();
      
            System.out.print("Le spectateur est-il adhérent (o ou O pour oui) ? ");
            reponse = entree.nextLine();
            
            // transformation des saisies booléen ou en code caractère
            adherent = reponse.equals("o") || reponse.equals("O");
            
            // prise en compte d'une éventuelle réponse vide ou trop longue
            codeCategorie = categorie.length() != 1? '?' : categorie.charAt(0);
            
            // prise en compte d'une éventuelle réponse vide ou trop longue
            codeSpectacle = spectacle.length() != 1? '?' : spectacle.charAt(0);
            
            // calcul du prix et affichage du résultat
            try {
                montantAPayer = TarifSpectacle.prixAPayer(codeSpectacle, codeCategorie, adherent);
                // Affichage du résultat
                System.out.print("Prix à payer .................. : "
                                 + montantAPayer + " euros\n");
            } catch(IllegalArgumentException erreur) {
                System.out.println("Calcul impossible : " + erreur.getMessage());
            }
            
            // on demande au testeur s'il veut recommencer
            System.out.print("\n\n--------------------------------\n"
                             + "Souhaitez-vous refaire un test (o ou O pour oui) ? ");
            reponse = entree.nextLine();
            
            // transformation des saisies booléen ou en code caractère
            recommencer = reponse.equals("o") || reponse.equals("O");
        } while (recommencer);
            
        entree.close();

    }

}