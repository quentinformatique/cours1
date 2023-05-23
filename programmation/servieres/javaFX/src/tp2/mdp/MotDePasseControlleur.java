/*
 * TP2MotDePasseControlleur.java                                    22 avr. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package application.tp2.mdp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 *
 * @author Costes quentin
 */
public class MotDePasseControlleur {

    /** Text où afficher le résultat */
    @FXML 
    private Label resultat;

    
    @FXML
    private void effacerResultat() {
        System.out.println("Effacer cliqué");
        resultat.setText("?");
    }
    
    @FXML
    private void genererMDP () {
        System.out.println("Générer cliqué");
        MotDePasse motDePasseGenere = new MotDePasse();
        resultat.setText(motDePasseGenere.getMot());
    }
}
