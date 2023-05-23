/*
 * Application.java                                    22 avr. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package application.tp2.devine;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** TODO comment class responsibility (SRP)
 * @author François de Saint Palais
 *
 */
public class ApplicationDevineNb extends javafx.application.Application {

    /* non javadoc - @see javafx.application.Application#start(javafx.stage.Stage) */
    @Override
    public void start(Stage primryStage) throws Exception {
        primryStage.setTitle("Quel est ce nombre ?");
        
        FXMLLoader chargeurFXML = new FXMLLoader();
        chargeurFXML.setLocation(getClass().getResource("VueDevineNb.fxml"));

        Parent racine = chargeurFXML.load();
        
        Scene scene = new Scene(racine);
        
        primryStage.setScene(scene);
        primryStage.show();
    }
    
    /**@param args */
    public static void main(String[] args) {
        launch(args);
    }

}
