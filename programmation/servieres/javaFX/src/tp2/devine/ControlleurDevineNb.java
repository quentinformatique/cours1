/*
 * ControlleurDevineNb.java                                    22 avr. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package application.tp2.devine;

import java.util.Optional;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;

/** 
 * Permet l'intraction avec l'utilisateur.
 * @author François de Saint Palais
 *
 */
public class ControlleurDevineNb {

    private int nbMin;
    private int nbMax;
    private int tentativeRestante;
    private int nombreAleatoire;
    
    @FXML
    private Text textPresentation;
    @FXML
    private Text textTentativeRestante;
    @FXML
    private Text textMasque;
    @FXML
    private TextField saisieProposition;
    
    /**
     * Vérifie si la proposition du joueur correspond 
     * au nombre généré aléatoirement.
     */
    @FXML
    private void soumissionNb () {
        System.out.println("Soumettre cliqué");
        if (saisieProposition.getText().isEmpty()) {
            Alert champVide = new Alert(AlertType.ERROR,"Il faut saisir une "
                                        + "proposition");
            champVide.showAndWait();
        } else if (!saisieProposition.getText().matches("^[0-9]{3}$")) {
            Alert champVide = new Alert(AlertType.ERROR,"Il faut saisir un "
                                        + "nombre d'au moins 3 chiffres");
            champVide.showAndWait();
        } else {
            int nombreSaisie = Integer.parseInt(saisieProposition.getText());
            if (nombreSaisie == nombreAleatoire) {
                gagner();
            } else {
                propositionIncorrect();
            }
        }
    }

    /** 
     * <p>
     * Est appelé lorsque la proposition du joueur est incorrect.
     * Il y a deux cas :
     * </p>
     * <ul>
     *     <li>
     *         Le nombre de tentative est à zéro. Alors le joueur à perdu.
     *     </li>
     *     <li>
     *         Il reste des tentatives. Alors on met à jour le masque 
     *         pour aider le joueurs.
     *         Et on lui retire une tentative.
     *     </li>
     * </ul>
     */
    private void propositionIncorrect() {
        if (tentativeRestante == 1) {
            perdu();
        } else {
            updateMasque();
            tentativeRestante --;
            textTentativeRestante.setText(tentativeRestante + "");
            saisieProposition.setText("");
        }
    }

    /** 
     * Met à jour le masque en fonction de la proposition du joueur.
     * 
     */
    private void updateMasque() {
        String aTrouver = nombreAleatoire + "";
        String nouveauMasque = textMasque.getText();
        for (int i = 0; i < aTrouver.length();i++) {
            if (aTrouver.charAt(i) == saisieProposition.getText().charAt(i)) {
                nouveauMasque = nouveauMasque.substring(0,i) 
                                + aTrouver.charAt(i) 
                                + nouveauMasque.substring(i+1,nouveauMasque.length());
            }
            System.out.println(nouveauMasque);
        }
        textMasque.setText(nouveauMasque);
    }

    /** Appelé lorsque le joueur à perdu. */
    private void perdu() {
        Alert perdu = new Alert(AlertType.ERROR,"Perdu ! Le nombre à trouver "
                + "été : " + nombreAleatoire);
        ButtonType rejouer = new ButtonType("Rejouer"); 
        ButtonType quitter = new ButtonType("Quitter"); 
         
        // on supprime les boutons affichés par défaut
        perdu.getButtonTypes().clear(); 
         
        // on ajoute les 3 boutons personnalisés
        perdu.getButtonTypes().addAll(rejouer,quitter); 
         
         
        Optional<ButtonType> option = perdu.showAndWait(); 
        if (option.get() == rejouer) {
            initialize();
        } else if (option.get() == quitter) {
            Platform.exit();
        }
    }

    /** S'éxécute lorsque le joueur à trouvé le nombre */
    private void gagner() {
        updateMasque();
        Alert gagner = new Alert(AlertType.CONFIRMATION,"Félicitation vous avez"
                                 + " trouvé !");
        ButtonType rejouer = new ButtonType("Rejouer"); 
        ButtonType quitter = new ButtonType("Quitter"); 
         
        // on supprime les boutons affichés par défaut
        gagner.getButtonTypes().clear(); 
         
        // on ajoute les 3 boutons personnalisés
        gagner.getButtonTypes().addAll(rejouer,quitter); 
         
         
        Optional<ButtonType> option = gagner.showAndWait(); 
        if (option.get() == rejouer) {
            initialize();
        } else if (option.get() == quitter) {
            Platform.exit();
        }

    }

    @FXML
    private void initialize() {
        nbMax = 999;
        nbMin = 100;
        tentativeRestante = 10;
        nombreAleatoire = nbMin + (int)(Math.random() * ((nbMax - nbMin) + 1));
//        System.out.println("Nombre aléatoire : " + nombreAleatoire);
        textPresentation.setText(String.format("Le nombre est compris entre %d "
                                               + "et %d", nbMin, nbMax));
        textTentativeRestante.setText(tentativeRestante + "");
        saisieProposition.setText("");
        textMasque.setText("???");
        System.out.println("Application initialisé.");
    }
    
}
