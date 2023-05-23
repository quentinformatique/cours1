/*
 * FactureVenteLivre.java            21/11/2022
 * IUT de Rodez pas de droits d'auteurs
 */

 package iut.info1.instructionConditionnelle3;

 import java.util.Scanner;

 /**
  * Exercices sur ls instructions conditionlles
  * @author Quentin Costes
  */

 public class FactureVenteLivre {

    /**
     * Le programme saisira l’âge du client et le nombre de livres achetés. Il affichera ensuite le montant hors
     * taxe des livres une fois la réduction éventuelle déduite, le montant de la réduction accordée (si toutefois
     * une réduction est accordée), le montant de la TVA sur les livres, le montant des frais de transport (même
     * s’ils sont égaux à 0 euros) et le montant total TTC de la facture. On veillera à afficher les montants avec
     * seulement 2 chiffres décimaux.
     * @param args inutilisés
     */
    public static void main(String[] args) {

        final double PRIX_LIVRE_HT = 18.5;
        final double REDUCTION = 0.05;
        final int AGE_REDUCTION = 25;
        final double TVA = 0.055;
        final double FRAIS_DE_PORTS = 4.60;
        final double SEUIL_FDP_GRATUIT = 50;

        Scanner entree = new Scanner(System.in);
        int nombreLivres = 0,
            age = 0;
        double montantFinal,
               reduction;
        boolean entreeOK = false;

        while (!entreeOK) {
            System.out.print("Nombre de livres commandés : ");
            if (entree.hasNextInt()) {
                nombreLivres = entree.nextInt();
                entree.nextLine();
                if (nombreLivres < 0) {
                    System.out.print("Attention : il fallait entrer un entier positif\n");
                    entree.nextLine();
                } else {
                    entreeOK = true;
                }
            } else {
                System.out.print("Erreur : il faut saisir un entier positif.\n");
                entree.nextLine();
            }
        }
        entreeOK = false;

        while (!entreeOK) {
            System.out.print("Quel est votre age ? ");
            if (entree.hasNextInt()) {
                age = entree.nextInt();
                entree.nextLine();
                if (age < 0 || age > 115 ) {
                    System.out.println("Attention : il fallait entrer un entier compris entre 0 et 115\n");
                    entree.nextLine();
                } else {
                    entreeOK = true;
                }
            } else {
                System.out.print("Erreur : il faut saisir un entier positif.\n");
                entree.nextLine();
            }
        }

        System.out.printf("La facture sera établie pour l'achat de %d livre(s) et un age de %d ans.\n",nombreLivres, age);

        montantFinal = nombreLivres * PRIX_LIVRE_HT;

        
        if (age < AGE_REDUCTION) {
            reduction = (montantFinal * REDUCTION );
            montantFinal = montantFinal - reduction ;
            System.out.printf("Montant HT des livres ..... : %.2f\n",montantFinal);
            System.out.printf("    Réduction déduite ..... : %.2f\n",reduction);
        } else {
            System.out.printf("Montant HT des livres ..... : %.2f\n",montantFinal);
        }

        System.out.printf("Montant TVA ............... : %.2f\n",montantFinal * TVA);
        montantFinal += montantFinal * TVA;

        if (montantFinal < SEUIL_FDP_GRATUIT) {
            System.out.printf("Montant TVA ............... : %.2f\n",FRAIS_DE_PORTS);
            montantFinal += FRAIS_DE_PORTS;
        } else {
            System.out.print("Montant TVA ............... : 0.00\n");
        }
        System.out.printf("Montant total TTC ......... : %.2f\n",montantFinal);

        entree.close();
    }
 }
