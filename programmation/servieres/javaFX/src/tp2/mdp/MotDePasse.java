/*
 *  Générateur de mots de passe. Dans cette version : un prototype
 * MotDePasse.java                      02/22
 */
package application.tp2.mdp;


/**
 * <p>
 * Cette classe permet de créer des instances "mot de passe" construits
 * selon les caractéristiques précisées en tant qu'argument du constructeur.
 * </p>
 * <p>
 * Pour l'instant ce constructeur n'est pas encore codé.
 * Seul un constructeur par défaut est présent : il choisit aléatoirement un mot de passe dans un tableau
 * constant contenant plusieurs mots de passe.
 * </p>
 * @author Costes Quentin
 */
public class MotDePasse {
    
    
    /**
     * Ensemble prédéfini de mots de passe
     */
    private static final String MOT_EXEMPLE[] = { "unMotDePasse999!",
            "nouveauMotDePasse123*",  "iut999", "butinformatique2022",
            "butInfoSem2?"};
   
    
    /** Mot de passe généré automatiquement */
    private String mot;
    
    
    /** Constructeur par défaut.
     * Le mot de passe est choisi aléatoirement dans l'ensemble MOT_EXEMPLE
     */
    public MotDePasse() {
        mot = MOT_EXEMPLE[genereAleatoire(MOT_EXEMPLE.length)];
    }
    
    /*
     * TODO : ajouter ce constructeur
    public MotDePasse(int nbLettreMin, int nbLettreMaj, int nbChiffre, int nbCarSpecial) {
       
    }
    */
    
    /**
     * Accesseur sur le mot de passe
     * @return le mot de passe généré
     */
    public String getMot() {
        return mot;
    }
    
    
    /**
     * Renvoie un entier aléatoire compris entre 0 et valeurSup - 1
     * @param valeurSup  limite pour l'entier aléatoire
     * @return un entier généré de manière aléatoire entre 0 et valeurSup - 1
     */
    private static int genereAleatoire(int valeurSup) {
        return (int) ( Math.random()*valeurSup);
    }

}