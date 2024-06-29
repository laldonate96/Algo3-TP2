package edu.fiuba.algo3.vista;

import java.util.List;

import edu.fiuba.algo3.controlador.ControladorDeJugador;
import edu.fiuba.algo3.controlador.ControladorDePregunta;
import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.opcion.estado.*;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.vista.animaciones.Animacion;
import edu.fiuba.algo3.vista.animaciones.MaquinaDeEscribir;
import edu.fiuba.algo3.vista.animaciones.Titilante;
import edu.fiuba.algo3.vista.opciones.SeleccionadorOpciones;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PreguntaVista extends Application{
    private Stage ventanaPrincipal;
    // private Jugador jugador = new ControladorDeJugador().obtenerJugadorActual();
    // private Pregunta pregunta = new ControladorDePregunta().mostrarPregunta();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.ventanaPrincipal = stage;
        ventanaPrincipal.setTitle("AlgoHoot - Pregunta");

        Text enunciado = new Text();
        enunciado.getStyleClass().add("enunciado");
        List<Opcion> opciones = FabricaOpciones.crearListaSimple(List.of("1", "2", "3"), List.of("1", "3"), new Correcta());
        Pregunta pregunta = new MultipleChoice("pepe", opciones, new Clasica(1), "categoria");
        //Pregunta pregunta = new VerdaderoFalso("Enunciado 1", opciones, new Clasica(1), "Categoria");
        Animacion maquinaDeEscribir = new MaquinaDeEscribir(2, enunciado, pregunta.obtenerEnunciado());
        maquinaDeEscribir.aplicarAnimacion();

        HBox centerBox = new HBox(20);
        centerBox.getChildren().addAll(enunciado);
        centerBox.setAlignment(Pos.CENTER);

        GridPane contenedorOpciones = new GridPane();
        contenedorOpciones.setVgap(10);
        contenedorOpciones.setAlignment(Pos.CENTER);

        SeleccionadorOpciones.seleccionarVistaOpciones(opciones, pregunta, contenedorOpciones);

        VBox toolbarBox = Toolbar.obtenerInstancia().mostrarToolbar(ventanaPrincipal);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(centerBox, contenedorOpciones);
        layout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setTop(toolbarBox);
        root.setCenter(layout);

        Scene scene = new Scene(root, 800, 500);

        String css = getClass().getResource("src/css/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.show();
    }
}