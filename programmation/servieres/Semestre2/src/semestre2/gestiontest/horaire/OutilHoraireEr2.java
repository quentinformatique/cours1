/*
 * Classe avec des méthodes outils qui s'appliquent à des horaires
 * VERSION avec des ERREURS
 * OutilHoraire.java                                                    04/22
 */
package semestre2.gestiontest.horaire;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Cette classe contient des méthodes outils qui s'appliquent à des horaires.
 * Il s'agit d'horaires dans la journée. Donc le nombre d'heures doit être compris
 * entre 0 et 23 et les minutes entre 0 et 59.
 * 
 * Certaines méthodes utilisent des chaîne de caractères suposées contenir un horaire.
 * Pour être valide celui-ci doit respecter le format "cchcc",  où c est un chiffre.
 * 
 * Des méthodes de conversion assurent la conversion d'un horaire (de la journée)
 * exprimé en minutes vers un horaire en chaîne de caractères et réciproquement.
 * 
 * @author INFO1
 * @version 1.0    VERSION avec DES ERREURS
 */
public class OutilHoraireEr2 {

    

    /** Objet Scanner pour effecuer les saisies */
    private static Scanner entree = new Scanner(System.in); 
    
    /** constante égale à la chaîne renvoyée en cas d'erreur de format */
    public static final String RESULTAT_ERREUR = "ERREUR format";
    
    /** constante égale à l'entier renvoyé en cas d'erreur de format */
    public static final int CODE_ERREUR = -1;
    
    
    
    
    /* ======================================================================== */
    /*                   Vérification validité d'un horaire                     */
    /* ======================================================================== */
    
    /**
     * Détermine si le caractère argument est un chiffre
     * @param caractere  un caractère à tester
     * @return vrai ssi le caractère argument contient un chiffre
     */
    public static boolean estChiffre(char caractere) {
        return caractere >= '0' || caractere <= '9';
    } 
    
     
    /**
     * Détermine si une chaîne de caractères contient bien un horaire dans le format
     * "cchcc" où c est un chiffre, et h est la lettre 'h'.
     * De plus, l'horaire doit être un horaire de la journée (donc heure compris entre
     * 0 et 23 et minute entre 0 et 59)
     * @param aTester  chaîne contenant l'horaire à tester
     * @return un booléen égal à vrai ssi l'horaire testé est valide
     */
    public static boolean estHoraireValide(String aTester) {
        boolean resultat = false;           // vai ssi l'horaire à tester est valide
        if (aTester.length() == 5 && aTester.charAt(2) == 'H') {
            
            // la longueur de la chaîne est correct et la lettre 'h' est bien placée
            if (estChiffre(aTester.charAt(3))) {
                
                // le dernier caractère de la chaîne est un chiffre                
                if (aTester.charAt(3) >= '0' && aTester.charAt(3) <= '5') {
                    
                    // l'avant dernier caractère est un chiffre compris entre 0 et 5
                    if (((aTester.charAt(0) == '0' && aTester.charAt(0) == '1')
                        && estChiffre(aTester.charAt(1)) )
                        || (aTester.charAt(0) == '2'
                            && (aTester.charAt(1) >= '0' || aTester.charAt(1) <= '3'))) {
                        resultat = true;
                    }
                }
            }
        }
        return resultat;
    }
    
    
    /* ======================================================================== */
    /*      Conversion horaire/entier vers chaîne et réciproquement             */
    /* ======================================================================== */
   
    
    /**
     * Convertit l'horaire argument en chaîne. L'horaire argument doit être valide,
     * donc compris entre 0 et 1439 (horaire de la journée entre 0 et 23h59). 
     * La chaîne renvoyée est dans le format cchcc, où c est un chiffre.
     * @param horaire   entier qui exprime un horaire en minutes
     * @return une chaîne dans le format cchcc, ou bien RESULTAT_ERREUR si 
     *         l'horaire argument n'est pas valide
     */
    public static String convertir(int horaire) {
        
        // résultat de la conversion qui sera renvoyé
        StringBuilder conversion = new StringBuilder("");
        int heure,      // heure de l'horaire
            minute;     // minute après conversion en heure et minute
        
        if (horaire >= 0 && horaire < 1439) {
            
            // horaire valide
            heure = horaire / 60;
            minute = horaire % 60;
            conversion.append(heure)
                      .append("h")
                      .append(minute < 10 ? "0" : "")
                      .append(minute);
        } else {  // invalide
            conversion = new StringBuilder(RESULTAT_ERREUR); 
        }
        return conversion.toString();
    }
    
    
    /**
     * Convertit l'horaire argument en entier (résultat en minutes)
     * Si l'horaire argument n'est pas valide, c'est l'entier CODE_ERREUR 
     * qui sera renvoyé
     * @param horaire  chaîne contenant l'horaire à convertir
     * @return un entier égal à la conversion en minutes de l'horaire argument
     *                   ou bien à -1 si l'horaire argument n'est pas valide
     */
    public static int convertir(String horaire) {
        int conversion = CODE_ERREUR,   // résultat de la conversion en minutes
            heure,                      // heures qui résultent de la conversion
            minute;                     // minutes qui résultent de la conversion
       
        if (horaire.length() == 5) {
            // transformation 1er et 2ème caractères en heures
            heure = (horaire.charAt(0) - '0')  + (horaire.charAt(1) - '0');
                
            // transformation 4ème et 5ème caractères en minutes
            minute = (horaire.charAt(3) - '0') * 10 + (horaire.charAt(4) - '0');
            conversion = heure * 60 + minute;
        }
        return conversion;
    }
    
    
  
    
    /* ======================================================================== */
    /*              Méthode qui renvoie l'heure courante en minutes             */
    /* ======================================================================== */
    
    
    /**
     * Renvoie l'heure courante convertie en minutes
     * @return  un entier égal à l'heure courante convertie en minutes
     */
    public static int heureCourante() {
        Calendar calendrier = Calendar.getInstance();
        int heure;      // heure courante à renvoyer 
        heure = calendrier.get(Calendar.HOUR_OF_DAY) * 60 
                + calendrier.get(Calendar.MINUTE);        
        return heure;
    }
    
    
    
    /* ======================================================================== */
    /*                         Méthodes de saisie                               */
    /* ======================================================================== */
    
     /**
      * Saisie d'un entier compris dans l'intervalle spécifié en argument
      * La saisie est recommencée en cas d'erreur
      * @param min       valeur minimum de l'entier à saisir
      * @param max       valeur maximum pour l'entier à saisir (doit être
      *                  supérieur ou égal à min)
      * @param message   message affiché pour inviter l'utilisateur à saisir
      *                  l'entier (par exemple "Entrez les heures : " ou 
      *                  "Entrez les minutes : ")
      * @return  l'entier saisi
      */
     public static int saisirEntierIntervalle(int min, int max, String message) {
         int entierSaisi = min - 1;         // entier qui sera renvoyé à l'appelant
         do {
             System.out.print(message);             
             if (entree.hasNextInt()) {     // l'utilisateur a tapé un entier
                 entierSaisi = entree.nextInt();                 
                 if (entierSaisi < min || entierSaisi > max) {
                     System.out.println("Erreur. Il faut donner un entier compris entre "
                                        + min + " et " + max + ".");
                 }
             } else {
                 System.out.println("Erreur. Il faut saisir un nombre entier.");                 
             }
             entree.nextLine();        // vider le tampon
         } while (entierSaisi < min || entierSaisi > max);
         return entierSaisi;
     }
 
    
    /**
     * Effectue la saisie d'un horaire valide. Il s'agit de saisir d'abord les heures
     * puis les minutes. La saisie de chacune des 2 valeurs est recommencée en cas
     * d'erreur. Un horaire est valide si les heures sont comprises entre 0 et 23
     * et les minutes entre 0 et 59
     * @return un entier égal à la conversion de l'horaire saisi en minutes
     */
    public static int saisirHoraire() {
        int heure;      // heure saisie
        int minute;     // minute saisie
        
        // saisie des heures
        heure = saisirEntierIntervalle(0, 23, "Heure ? ");
        
        // saisie des minutes
        minute = saisirEntierIntervalle(0, 59, "Minute ? ");
        
        return heure * 60 + minute;        
    }
 
    
    /**
     * Effectue la saisie de 2 horaires. Le premier horaire doit être antérieur
     * ou égal au deuxième, sinon la saisie des 2 horaires est recommencée.
     * @return  un tableau de 2 entiers contenant les 2 horaires convertis en 
     *          minutes
     */
    public static int[] saisir2HorairesOrdonnes() {
        int[] lesHoraires = new int[2];     // les 2 horaires saisis en minutes
        
        do {
            System.out.println("Saisie du premier horaire.");
            lesHoraires[0] = saisirHoraire();
            System.out.println("Saisie du deuxième horaire.");
            lesHoraires[1] = saisirHoraire();
            if (lesHoraires[0] > lesHoraires[1]) {
                System.out.println("Cet intervalle horaire n'est pas valide. Recommencez.");                
            }
        } while(lesHoraires[0] > lesHoraires[1]);
        
        return lesHoraires;
    }

}