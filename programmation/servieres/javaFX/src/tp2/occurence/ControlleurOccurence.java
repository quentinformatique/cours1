/*
 * ControlleurOccurence.java                                    22 avr. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package application.tp2.occurence;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/** TODO comment class responsibility (SRP)
 * @author François de Saint Palais
 *
 */
public class ControlleurOccurence {
    
    @FXML
    private TextArea saisieText;
    
    @FXML
    private TextField saisieLettre;
    
    @FXML
    private TextField resultat;

    @FXML
    private void calculerOccurence () {
        System.out.println("Calculer cliqué");
        if (saisieText.getText().isEmpty() && saisieLettre.getText().isEmpty()) {
            Alert alerteChampsVide = new Alert(AlertType.ERROR,
                    "Un des champs est vide");
            alerteChampsVide.showAndWait();
            
        } else if (!saisieLettre.getText().matches("^[a-zA-Z]{1}$")) {
            Alert alerteNonLettre = new Alert(AlertType.ERROR,
                    "Le caractére à compter n'est pas une lettre");
            alerteNonLettre.showAndWait();
            saisieLettre.setText("");
            
        } else {
            String text = saisieText.getText();
            char lettre = saisieLettre.getText().charAt(0);
            int occurence = 0;
            for (int i = 0; i < text.length();i++) {
                if (text.charAt(i) == lettre) {
                    occurence ++;
                }
            }
            resultat.setText(occurence + "");            
        }
    }
    
    /**
     * Méthode permettant de faire en sorte que l'utilisateur ne puisse
     * saisir, au maximum, qu'un certain nombre de caractères
     * @param zoneDeSaisie champ de saisie dont on veut limiter le nombre 
     * de caractères
     * @param nbMaxCaractere nombre maximum de caractères à saisir
     */
     private static void setTextLimit(TextField zoneDeSaisie, int nbMaxCaractere) { 
         /*
         * Si le nombre de caractères saisis dépasse la valeur nbMaxCaractere,
         * on extrait de la chaîne saisie le début de cette chaîne
         * (dont entre les indices 0 et nbMaxCaractere - 1)
         * Cette sous-chaîne est affichée dans la zoneDeSaisie
         * Grâce à l'appel à positinCaret, le curseur est placé en fin de chaîne
         */
         zoneDeSaisie.setOnKeyTyped(event -> { 
             String string = zoneDeSaisie.getText(); 
             if (string.length() > nbMaxCaractere) { 
                 zoneDeSaisie.setText(string.substring(0, nbMaxCaractere)); 
                 zoneDeSaisie.positionCaret(string.length()); 
             } 
         }); 
     }
     
     @FXML
     private void initialize () {
         setTextLimit(saisieLettre, 1);
     }

    
    /**
     * Remet l'interface à zéro.
     */
    @FXML
    private void effacer() {
        System.out.println("Effacer cliqué");
        saisieLettre.setText("");
        saisieText.setText("");
        resultat.setText("");
    }
}
