/*
 * TP2MotDePasse.java                                    22 avr. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 * La vue est décrite dans le fichier fxml : SBMDP.fxml
 * 
 */
package application.tp2.mdp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** 
 * @author Costes Quentin
 *
 */
public class MotDePasseApp extends Application {

    /* non javadoc - @see javafx.application.Application#start(javafx.stage.Stage) */
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Compter caractères"); 

        
        // création d'un chargeur de code FXML
        FXMLLoader chargeurFXML = new FXMLLoader(); 
        
        /*
        * on indique au chargeur quelle est la vue fxml qu'il devra charger :
        * ici SBMDP.fxml
        */
        chargeurFXML.setLocation(getClass().getResource("SBMDP.fxml")); 
        
        /*
        * création d'un objet de type parent qui est initialisé avec le résultat du 
        * chargement de la vue FXML. Ou dit autrement le code écrit en FXML est transformé 
        * en un objet Java
        */
        Parent racine = chargeurFXML.load(); 
        
        Scene scene = new Scene(racine); 
        
        // on définit le titre, la hauteur et la largeur de la fenêtre
        primaryStage.setScene(scene); 
        primaryStage.show(); 
    }
    
    
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
