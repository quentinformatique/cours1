/*
 * Affiche la fenêtre par défaut de JavaFX
 * ExempleCours1.java 01/22
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
/**
 * Cette classe est la classe principale d'une application JavaFX.
 * On dit aussi le point d'entrée de l'application, car c'est la première classe qui
 * sera exécutée au lancement de l'application (car elle hérite de la classe Application).
 * La fenêtre affichée aura pour titre "Première fenêtre JavaFX", une hauteur de 300 pixels
 * et une largeur de 500 pixels
 * @author Costes quentin
 *
 */
public class tp1Exo1 extends Application {
     @Override
     public void start(Stage primaryStage) {
    
         // on définit le titre, la hauteur et la largeur de la fenêtre
         primaryStage.setTitle("Convertisseur");
         primaryStage.setHeight(300); // l'unité est le pixel
         primaryStage.setWidth(500);
         
         VBox racine = new VBox();

         // les composants seront centrés
         racine.setAlignment(Pos.TOP_CENTER);

         // création de la zone de texte
         Text message = new Text("convertisseur durées heures et minutes");
         racine.setPadding(new Insets(15, 15, 15, 15)); 
         message.setFill(Color.BLUE);
         message.setFont(new Font("verdana", 20));
         

         // on ajoute les composants, Text et Button, au layout racine
         racine.getChildren().add(message);


         HBox ligneHeures = new HBox(30);
         ligneHeures.setPadding(new Insets(10, 10, 10, 10)); 
         ligneHeures.setAlignment(Pos.CENTER);

         Label labelHeures = new Label("Heures :");       
         TextField inputHeures = new TextField();
         
         ligneHeures.getChildren().addAll(labelHeures, inputHeures);
         racine.getChildren().add(ligneHeures); 
         
         
         HBox ligneMinutes = new HBox(30);
         ligneMinutes.setPadding(new Insets(10, 10, 10, 10)); 
         ligneMinutes.setAlignment(Pos.CENTER);

         Label labelMinutes = new Label("Minutes :");       
         TextField inputMinutes = new TextField();
         
         ligneMinutes.getChildren().addAll(labelMinutes, inputMinutes);
         racine.getChildren().add(ligneMinutes);
         
         
         HBox ligneEnMinutes = new HBox(30);
         ligneEnMinutes.setPadding(new Insets(10, 10, 10, 10)); 
         ligneEnMinutes.setAlignment(Pos.CENTER);

         Label labelEnMinutes = new Label("En minutes :");       
         TextField inputEnMinutes = new TextField();
         inputEnMinutes.setEditable(false);
         
         ligneEnMinutes.getChildren().addAll(labelEnMinutes, inputEnMinutes);
         racine.getChildren().add(ligneEnMinutes);
         
         HBox ligneBoutons = new HBox(30);
         ligneBoutons.setPadding(new Insets(10, 10, 10, 10));
         ligneBoutons.setAlignment(Pos.BOTTOM_RIGHT);
         
         Button boutonAnnuler = new Button("Annuler"); 
         Button boutonConvertir = new Button("Convertir");
         ligneBoutons.getChildren().addAll(boutonAnnuler, boutonConvertir);
         racine.getChildren().add(ligneBoutons);
         
         boutonConvertir.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 String heures = inputHeures.getText();
                 String minutes = inputMinutes.getText();
                 int heuresInt;
                 int minutesInt;
                 
                 if (heures.isEmpty()) {
                     heuresInt = 0;
                 } else {
                     try {    
                         heuresInt = Integer.parseInt(heures);
                     } catch (NumberFormatException e) {
                         heuresInt = 0;
                     }
                 }
                 
                 if (minutes.isEmpty()) {
                     minutesInt = 0;
                 } else {
                     try {    
                         minutesInt = Integer.parseInt(minutes);
                     } catch (NumberFormatException e) {
                         minutesInt = 0;
                     }
                 }
                 
                 inputEnMinutes.setText(heuresInt * 60 + minutesInt + "");
             }
         });
         
         boutonAnnuler.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 inputEnMinutes.setText("");
                 inputMinutes.setText("");
                 inputHeures.setText("");
             }
         });
        
         
         
         // on créé une nouvelle scène
         Scene scene = new Scene(racine);
         primaryStage.setScene(scene);
        
         // on demande à ce que la fenêtre soit affichée
         primaryStage.show();
 }

     /**
     * Programme principal
     * @param args argument non utilisé
     */
     public static void main(String[] args) {
    
         /* la méthode launch va créer une instance de la classe courante,
         * donc ExempleCours1
         * Ensuite la méthode start de cette classe est automatiquement appelée
         */
         launch(args);
     }
}