/*
 * ApplicationOccurence.java                                    22 avr. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package application.tp2.occurence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/** TODO comment class responsibility (SRP)
 * @author François de Saint Palais
 *
 */
public class ApplicationOccurence extends Application {

    /* non javadoc - @see javafx.application.Application#start(javafx.stage.Stage) */
    @Override
    public void start(Stage scenePrimaire) throws Exception {
        // TODO Auto-generated method stub
        scenePrimaire.setTitle("Recherche occurence");
        
        FXMLLoader chargeurFXML = new FXMLLoader();
        chargeurFXML.setLocation(getClass().getResource("VueOccurence.fxml"));
        
        Parent racine = chargeurFXML.load();
        
        Scene scene = new Scene(racine);
        scenePrimaire.setScene(scene);
        scenePrimaire.show();
    }

    /**@param args */
    public static void main(String[] args) {
        launch(args);
    }
}
