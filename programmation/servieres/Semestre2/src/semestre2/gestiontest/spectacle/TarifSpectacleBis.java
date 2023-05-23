/*
 * Détermine le prix à payer pour un billet d'entrée à un spectacle
 * TarifSpectacle.java
 */

package semestre2.gestiontest.spectacle;


/**
 * Cette classe contient une méthode outil permettant de calculer le prix à payer pour 
 * un billet de spectacle, compte tenu de la catégorie du spectateur, du type de spectacle
 * et du fait que le spectateur possède ou pas une carte d'adhérent. 

 * @author INFO1
 * @version 1.0
 * 
 */
public class TarifSpectacleBis {
    
    /** prix de base d'une place pour un spectacle pièce de théâtre */
    private static final int BILLET_THEATRE = 25;
    
    /** prix de base d'une place pour un opéra */
    private static final int BILLET_OPERA = 32;
    
    /** prix de base d'une place pour un spectacle de danse */
    private static final int BILLET_DANSE = 27;
    
    /** prix de base d'une place pour un concert */
    private static final int BILLET_CONCERT = 29;
    
    /** réduction accordée aux scolaires et étudiants */
    private static final int REDUC_CATEGORIE = 8;
    
    /** réduction accordée aux moins de 25 ans */
    private static final int REDUC_JEUNE = 4;
    
    /** réduction accordée aux adhérents */
    private static final int REDUC_ADHERENT = 3;

    /** Code correspondant au spectacle Théâtre */
    private static final char CODE_THEATRE = 'T';
    
    /** Code correspondant au spectacle Theatre */
    private static final char CODE_OPERA = 'O';
    
    /** Code correspondant au spectacle Theatre */
    private static final char CODE_DANSE = 'D';
    
    /** Code correspondant au spectacle Theatre */
    private static final char CODE_CONCERT = 'C';
    
    /** Code correspondant à la catégorie des spectateurs : scolaire */
    private static final char CAT_SCOLAIRE = 'S';
    
    /** Code correspondant à la catégorie des spectateurs : étudiant */
    private static final char CAT_ETUDIANT = 'E';
    
    /** Code correspondant à la catégorie des spectateurs : autre moins de 25 ans */
    private static final char CAT_MOINS_25 = 'M';
    
    /** Code correspondant à la catégorie des spectateurs : autre plus de 25 ans */
    private static final char CAT_PLUS_25 = 'P';
    
    
    
    /**
     * Détermine le prix à payer en fonction du spectacle, de la catégorie du spectateur
     * et du fait qu'il possède ou pas une carte d'adhérent
     * @param spectacle   caractère code du spectacle, parmi les 4 possibles
     * @param categorie   caractère code de la catégorie du spectateur, parmi les 4 possibles 
     * @param adherent    un booléen égal à vrai ssi le spectateur possède une carte
     *                    d'adhérent
     * @return un entier égal au prix à payer une fois les éventuelles réductions déduites
     * @throw IllegalArgumentException  levée si un code (spectacle ou catégorie) est invalide
     */
    public static int prixAPayer(char spectacle, char categorie, boolean adherent) {
        int reduction = 0;      // réduction selon catégorie et/ou adhérent
        switch (categorie) {
        case CAT_SCOLAIRE :  // catégorie scolaire
            reduction = adherent ? REDUC_CATEGORIE + REDUC_ADHERENT 
                                   : REDUC_CATEGORIE;
            break;
        case CAT_ETUDIANT : // catégorie étudiant
            reduction = REDUC_CATEGORIE;
            if (adherent && (spectacle == CODE_OPERA || spectacle == CODE_DANSE)) {
                reduction += REDUC_ADHERENT;
            }
            break;
        case CAT_MOINS_25 :  // catégorie autre moins de 25 ans
            reduction = REDUC_JEUNE;
            if (adherent && spectacle == CODE_OPERA) {
                reduction += REDUC_ADHERENT;
            }
            break;
        case CAT_PLUS_25 :  // catégorie autre plus de 25 ans
            if (adherent && spectacle == CODE_DANSE) {
                reduction += REDUC_ADHERENT;
            }
            break;   
        default:    // code catégorie incorrect
            throw new IllegalArgumentException("La catégorie " + categorie
                                               + " est invalide.");
        }

        // calcul du prix du billet : on teste le code du spectacle
        int prixBillet = 0;     // prix à payer et qui sera renvoyé
        switch (spectacle) {
        case CODE_THEATRE:
            prixBillet = BILLET_THEATRE - reduction;
            break;
        case CODE_OPERA:
            prixBillet = BILLET_OPERA - reduction;
            break;
        case CODE_DANSE:
            prixBillet = BILLET_DANSE - reduction;
            break;
        case CODE_CONCERT:
            prixBillet = BILLET_CONCERT - reduction;
            break;
        default:   // code spectacle incorrect
            throw new IllegalArgumentException("Le code " + spectacle
                    + " est invalide.");
        }
        return prixBillet;
    }
    
    
}