package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorVentanaNueva;
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
    private CargarJugadores cargarJugadores = new CargarJugadores();
    private ControladorVentanaNueva controladorVentanaNueva = new ControladorVentanaNueva();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.ventanaPrincipal = primaryStage;

        Text titulo = new Text("Bienvenido a Algohoot");
        titulo.getStyleClass().add("primeraVentanaTitulo");
        Titilante titilante = new Titilante(1, titulo);
        titilante.aplicarAnimacion();

        Boton botonJugar = new Boton("Jugar", "botonJugar");
        botonJugar.setOnAction(event -> controladorVentanaNueva.abrirVentanaNueva(cargarJugadores, ventanaPrincipal));

        VBox centerBox = new VBox(20);
        centerBox.getChildren().addAll(titulo, botonJugar);
        centerBox.setAlignment(Pos.CENTER);

        VBox toolbarBox = Toolbar.obtenerInstancia().mostrarToolbar(primaryStage);

        BorderPane root = new BorderPane();
        root.setTop(toolbarBox);
        root.setCenter(centerBox);

        Scene escenaDelJuego = new Scene(root, 1280, 720);

        String cssPath = "src/css/style.css";
        URL cssURL = this.getClass().getResource(cssPath);
        if (cssURL != null) {
            String css = cssURL.toExternalForm();
            escenaDelJuego.getStylesheets().add(css);
        } else {
            System.err.println("Archivo CSS no encontrado: " + cssPath);
        }

        primaryStage.setTitle("Algohoot");
        primaryStage.setScene(escenaDelJuego);
        primaryStage.show();
    }
}
