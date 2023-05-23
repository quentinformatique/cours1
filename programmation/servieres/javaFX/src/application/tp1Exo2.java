/*
 * tp1Exo2.java                                    18 avr. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */
package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos; 

/** TODO comment class responsibility (SRP)
 * @author quent
 *
 */
public class tp1Exo2 extends Application {
    
    /** TODO comment method role
     * @param primaryStage
     */
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calcul prix repas");
        primaryStage.setHeight(300); // l'unité est le pixel
        primaryStage.setWidth(500);
        
        VBox racine = new VBox();

        // les composants seront centrés
        racine.setAlignment(Pos.TOP_CENTER);

        // création de la zone de texte
        Text message = new Text("Restaurant - Calcul du prix à payer");
        racine.setPadding(new Insets(15, 15, 15, 15)); 
        message.setFill(Color.BLUE);
        message.setFont(new Font("verdana", 20));
        
        // on ajoute les composants, Text et Button, au layout racine
        racine.getChildren().add(message);
        
        
        HBox ligneMenu = new HBox(30);
        ligneMenu.setPadding(new Insets(10, 10, 10, 10)); 
        ligneMenu.setAlignment(Pos.BASELINE_LEFT);
        Label labelMenu = new Label("Menu");
        
        ligneMenu.getChildren().addAll(labelMenu);
        racine.getChildren().add(ligneMenu); 
        
        
        
        HBox ligneBoissonRepas = new HBox(30);
        ligneBoissonRepas.setPadding(new Insets(10, 10, 10, 10)); 
        ligneBoissonRepas.setAlignment(Pos.BASELINE_LEFT);
        Label labelBoissonRepas = new Label("Boisson avec le repas ?");
        
        ligneBoissonRepas.getChildren().addAll(labelBoissonRepas);
        racine.getChildren().add(ligneBoissonRepas);
        
        

        
        HBox ligneBoisson = new HBox(30);
        ligneBoisson.setPadding(new Insets(10, 10, 10, 10)); 
        ligneBoisson.setAlignment(Pos.BASELINE_LEFT);
        Label labelBoisson = new Label("Autre boisson :");
        
        ligneBoisson.getChildren().addAll(labelBoisson);
        racine.getChildren().add(ligneBoisson);
        
        

        
        HBox lignePayer = new HBox(30);
        lignePayer.setPadding(new Insets(10, 10, 10, 10)); 
        lignePayer.setAlignment(Pos.BASELINE_LEFT);
        Label labelPayer = new Label("A payer :");
        
        TextField inputPayer = new TextField();
        inputPayer.setEditable(false);
        
        lignePayer.getChildren().addAll(labelPayer, inputPayer );
        racine.getChildren().add(lignePayer); 
        

        
        HBox lignecalculer = new HBox(30);
        lignecalculer.setPadding(new Insets(10, 10, 10, 10)); 
        lignecalculer.setAlignment(Pos.BASELINE_RIGHT);
        
        Button boutonEffacer = new Button("Effacer"); 
        Button boutonCalculer = new Button("Calculer");
        lignecalculer.getChildren().addAll(boutonEffacer, boutonCalculer);
        racine.getChildren().add(lignecalculer);
        
        


        
        
        
        
        
        
        
        // on créé une nouvelle scène
        Scene scene = new Scene(racine);
        primaryStage.setScene(scene);
       
        // on demande à ce que la fenêtre soit affichée
        primaryStage.show();
        
    }
    
    /** TODO comment method role
     * @param args
     */
    public static void main(String[] args) {
        
        /* la méthode launch va créer une instance de la classe courante,
        * donc ExempleCours1
        * Ensuite la méthode start de cette classe est automatiquement appelée
        */
        launch(args);
    }
    
   
    

}
