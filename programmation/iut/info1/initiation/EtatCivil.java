/*
 * EtatCivil.java			06/10/2020
 * IUT de Rodez, pas de droits d'auteur
 */

package iut.info1.initiation;

import java.util.Scanner;

/**
 * analyse l'entrée du l'utisateur , récoupere ses infos
 * met en forme ses information .
 * @author Quentin Costes
 */

public class EtatCivil{

    /**
     * demande le prenom de l'utilisateur, 
     * son nom, son année de naissance et son lieu de naissance
     * Afficher alors son état civil sous la forme : 
     * Prénom NOM (nn ans)
     * né(e) en .... à ...
     */

    public static void main(String[] args) {
    
        final int anneActuelle = 2022;

        String nom;
        String prenom;
        String etatCivil;
        String lieuNaissance;
        int anneeNaissance;
        int age;
        

        Scanner entree = new Scanner(System.in);
        System.out.print("Entrez votre Nom : ");
        nom = entree.next() + ' ' + entree.nextLine().trim();
		nom = nom.trim();
        System.out.print("Entrez votre Prenom : ");
        prenom = entree.next() + ' ' + entree.nextLine().trim();
		prenom = prenom.trim();
        System.out.print("Entrez votre année de Naissance : ");
        anneeNaissance = entree.nextInt();
	entree.nextLine();
        System.out.print("Entrez votre Lieu de naissance : ");
        lieuNaissance = entree.next() + ' ' + entree.nextLine().trim();
	lieuNaissance = lieuNaissance.trim();

        age = anneActuelle - anneeNaissance;

        etatCivil = prenom + ' ';
        etatCivil += nom + ' ';
        etatCivil += "(" + age + " ans)";
        etatCivil += "\n";
        etatCivil += "né(é) en " + anneeNaissance;
        etatCivil += " à " + lieuNaissance;

        System.out.print("\n" + etatCivil);

        entree.close();
    }
}