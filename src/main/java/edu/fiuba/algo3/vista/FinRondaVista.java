package edu.fiuba.algo3.vista;

import java.util.List;

import edu.fiuba.algo3.controlador.ControladorDeJugador;
import edu.fiuba.algo3.controlador.ControladorDePregunta;
import edu.fiuba.algo3.controlador.ControladorDeTurno;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.botones.Boton;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FinRondaVista extends Application {
    private ControladorDeJugador controladorDeJugador = new ControladorDeJugador();
    private ControladorDeTurno controladorDeTurno = new ControladorDeTurno();
    private ControladorDePregunta controladorDePregunta = new ControladorDePregunta();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
public void start(Stage primaryStage) throws Exception {
    VBox toolbarBox = Toolbar.obtenerInstancia().mostrarToolbar(primaryStage);

    List<Jugador> jugadores = controladorDeJugador.obtenerJugadores();

    VBox jugadoresBox = new VBox();
    jugadoresBox.setAlignment(Pos.CENTER);
    jugadoresBox.setSpacing(10);

    for (Jugador jugador : jugadores) {
        HBox jugadorBox = new HBox();
        jugadorBox.setAlignment(Pos.CENTER);
        jugadorBox.setSpacing(20);

        Label nombreLabel = new Label(jugador.obtenerNombre());
        nombreLabel.getStyleClass().add("labelPostRonda");

        Label puntajeLabel = new Label("Puntos: " + String.valueOf(jugador.obtenerPuntaje()));
        puntajeLabel.getStyleClass().add("labelPostRonda");

        Label flechaLabel = new Label("→");
        flechaLabel.getStyleClass().add("flechaPuntajeJugador");

        Label flechaLabel2 = new Label("→");
        flechaLabel2.getStyleClass().add("flechaPuntajeJugador");

        Label modificadorUsado = new Label(jugador.obtenerUltimoModificadorUsado().mostrarModificador());
        modificadorUsado.getStyleClass().add("labelPostRonda");

        jugadorBox.getChildren().addAll(nombreLabel, flechaLabel, puntajeLabel, flechaLabel2, modificadorUsado);
        jugadoresBox.getChildren().add(jugadorBox);
    }

    VBox modificadoresBox = new VBox();
    modificadoresBox.setSpacing(10);

    Boton botonSiguienteRonda = new Boton("Siguiente", "boton");
    botonSiguienteRonda.setOnAction(e -> controladorDeTurno.siguienteRonda(primaryStage));

    Text explicacion = new Text(controladorDePregunta.mostrarPregunta().obtenerExplicacion());
    explicacion.getStyleClass().add("explicacion");
    explicacion.setWrappingWidth(1000);

    VBox mainBox = new VBox();
    mainBox.setAlignment(Pos.CENTER);
    mainBox.setSpacing(20);
    mainBox.getChildren().addAll(explicacion, jugadoresBox);

    VBox btnBox = new VBox();
    btnBox.setAlignment(Pos.CENTER_RIGHT);
    btnBox.setSpacing(20);
    btnBox.getChildren().addAll(botonSiguienteRonda);

    BorderPane root = new BorderPane();
    root.setTop(toolbarBox);
    root.setCenter(mainBox);
    root.setRight(btnBox);

    Scene scene = new Scene(root, 1280, 720);

    try {
        String css = getClass().getResource("src/css/style.css").toExternalForm();
        scene.getStylesheets().add(css);
    } catch (NullPointerException e) {
        System.err.println("Archivo CSS no encontrado: " + e.getMessage());
    }

    primaryStage.setTitle("Final de Ronda");
    primaryStage.setScene(scene);
    primaryStage.show();
}

}
