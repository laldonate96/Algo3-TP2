package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class inicioDelJuego extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("Bienvenido a algo kahoot");

        Label label = new Label("Agregar Jugador:");
        label.getStyleClass().add("label-style");
        
        TextField inputJugador = new TextField();
        TextArea jugadoresGuardados = new TextArea();
        jugadoresGuardados.setEditable(false); 

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        
        
        VBox layout = new VBox(10); 
        layout.setPadding(new Insets(20)); 
        layout.getChildren().addAll(label, inputJugador, jugadoresGuardados, botonJugar);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout, 400, 350);
        stage.setScene(scene);


        String css = this.getClass().getResource("src/css/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.show();
    }
}
