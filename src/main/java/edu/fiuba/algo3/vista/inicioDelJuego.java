package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.animaciones.Titilante;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class InicioDelJuego extends Application {
    public void abrirCargaJugadores() {
        CargarJugadores cargarJugadores = new CargarJugadores();
            try {
                cargarJugadores.start(new Stage());
            } catch (Exception e) {
                
            }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text titulo = new Text("Bienvenido a algohoot");
        titulo.getStyleClass().add("primeraVentanaTitulo");
        Titilante titilante = new Titilante();
        titilante.aplicarAnimacion(1, titulo); 

        Button botonJugar = new Button("Jugar");
        botonJugar.getStyleClass().add("botonJugar");
        botonJugar.setOnAction(event -> abrirCargaJugadores());

        VBox root = new VBox(20);
        root.getChildren().addAll(titulo, botonJugar);
        root.setAlignment(Pos.CENTER);

        Scene gameScene = new Scene(root, 800, 500);
        String css = this.getClass().getResource("src/css/style.css").toExternalForm();
        gameScene.getStylesheets().add(css);

        primaryStage.setTitle("Algohoot");
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }
}