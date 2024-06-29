package edu.fiuba.algo3.vista;

import java.util.List;

import edu.fiuba.algo3.controlador.ControladorDeJugador;
import edu.fiuba.algo3.controlador.ControladorDePregunta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.vista.animaciones.Animacion;
import edu.fiuba.algo3.vista.animaciones.MaquinaDeEscribir;
import edu.fiuba.algo3.vista.animaciones.Titilante;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PreguntaVista extends Application{
    private Stage ventanaPrincipal;
    // private Jugador jugador = new ControladorDeJugador().obtenerJugadorActual();
    // private Pregunta pregunta = new ControladorDePregunta().mostrarPregunta();
    private Toolbar toolbar;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.ventanaPrincipal = stage;
        //Jugador jugador = new Jugador("Pepe", List.of());
        ventanaPrincipal.setTitle("Pepe");
        
        Text titulo = new Text("Pregunta: ");
        Animacion titilante = new Titilante(1, titulo);
        titilante.aplicarAnimacion();

        Text enunciado = new Text();
        //Animacion maquinaDeEscribir = new MaquinaDeEscribir(2, enunciado, pregunta.obtenerEnunciado());
        Animacion maquinaDeEscribir = new MaquinaDeEscribir(2, enunciado, "Enunciado");
        maquinaDeEscribir.aplicarAnimacion();

        VBox centerBox = new VBox(20);
        centerBox.getChildren().addAll(titulo, enunciado);
        centerBox.setAlignment(Pos.CENTER);

        VBox toolbarBox = Toolbar.obtenerInstancia().mostrarToolbar(ventanaPrincipal);

        BorderPane root = new BorderPane();
        root.setTop(toolbarBox);
        root.setCenter(centerBox);

        Scene scene = new Scene(root, 800, 500);

        String css = getClass().getResource("src/css/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.show();
    }
}