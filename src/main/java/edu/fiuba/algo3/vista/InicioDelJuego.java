package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.Reproductor;
import edu.fiuba.algo3.vista.alertas.Alerta;
import edu.fiuba.algo3.vista.alertas.AlgoSalioMal;
import edu.fiuba.algo3.vista.animaciones.Titilante;
import edu.fiuba.algo3.vista.botones.Boton;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;

public class InicioDelJuego extends Application {
    private Stage ventanaPrincipal;

    public void abrirCargaJugadores() {
        CargarJugadores cargarJugadores = new CargarJugadores();
        try {
            cargarJugadores.start(new Stage());
            ventanaPrincipal.close();
        } catch (Exception e) {
            Alerta algoSalioMal = new AlgoSalioMal();
            algoSalioMal.mostrarAlerta();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Reproductor reproductor = new Reproductor();
        reproductor.reproducir();
        this.ventanaPrincipal = primaryStage;

        Text titulo = new Text("Bienvenido a Algohoot");
        titulo.getStyleClass().add("primeraVentanaTitulo");
        Titilante titilante = new Titilante(1, titulo);
        titilante.aplicarAnimacion();

        Boton botonJugar = new Boton("Jugar", "botonJugar");
        botonJugar.setOnAction(event -> abrirCargaJugadores());

        VBox centerBox = new VBox(20);
        centerBox.getChildren().addAll(titulo, botonJugar);
        centerBox.setAlignment(Pos.CENTER);

        Toolbar toolbar = new Toolbar();
        VBox toolbarBox = toolbar.mostrarToolbar(primaryStage);

        BorderPane root = new BorderPane();
        root.setTop(toolbarBox);
        root.setCenter(centerBox);

        Scene escenaDelJuego = new Scene(root, 800, 500);

        String cssPath = "src/css/style.css";
        URL cssURL = this.getClass().getResource(cssPath);
        if (cssURL != null) {
            String css = cssURL.toExternalForm();
            escenaDelJuego.getStylesheets().add(css);
        } else {
            System.err.println("CSS file not found: " + cssPath);
        }

        primaryStage.setTitle("Algohoot");
        primaryStage.setScene(escenaDelJuego);
        primaryStage.setResizable(false);  
        primaryStage.show();
    }
}
