package edu.fiuba.algo3.vista;

import java.util.List;

import edu.fiuba.algo3.controlador.ControladorDeJugador;
import edu.fiuba.algo3.controlador.ControladorDeTurno;
import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.botones.Boton;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinRondaVista extends Application {
    private ControladorDeJugador controladorDeJugador = new ControladorDeJugador();
    private ControladorDeTurno controladorDeTurno = new ControladorDeTurno();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox toolbarBox = Toolbar.obtenerInstancia().mostrarToolbar(primaryStage);

        List<Jugador> jugadores = controladorDeJugador.obtenerJugadores();
        //List<String> modificadores = mostrarModificadoresDeRonda();

        VBox jugadoresBox = new VBox();
        jugadoresBox.setAlignment(Pos.CENTER);
        jugadoresBox.setSpacing(10);

        for (Jugador jugador : jugadores) {
            HBox jugadorBox = new HBox();
            jugadorBox.setAlignment(Pos.CENTER);
            jugadorBox.setSpacing(20);

            Label nombreLabel = new Label(jugador.obtenerNombre());
            Label puntajeLabel = new Label(String.valueOf(jugador.obtenerPuntaje()) + " puntos");

            jugadorBox.getChildren().addAll(nombreLabel, puntajeLabel);
            jugadoresBox.getChildren().add(jugadorBox);
        }

        VBox modificadoresBox = new VBox();
        modificadoresBox.setAlignment(Pos.CENTER);
        modificadoresBox.setSpacing(10);

        // for (String modificador : modificadores) {
        //     Label modificadorLabel = new Label(modificador);
        //     modificadoresBox.getChildren().add(modificadorLabel);
        // }

        Boton botonSiguienteRonda = new Boton("Siguiente", "boton");
        botonSiguienteRonda.setOnAction(e -> controladorDeTurno.siguienteRonda(primaryStage));

        VBox mainBox = new VBox();
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setSpacing(20);
        mainBox.getChildren().addAll(jugadoresBox, botonSiguienteRonda);

        BorderPane root = new BorderPane();
        root.setTop(toolbarBox);
        root.setCenter(mainBox);

        Scene scene = new Scene(root, 1280, 720);

        try {
            String css = getClass().getResource("/css/style.css").toExternalForm();
            scene.getStylesheets().add(css);
        } catch (NullPointerException e) {
            System.err.println("Archivo CSS no encontrado: " + e.getMessage());
        }

        primaryStage.setTitle("Final de Ronda");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static List<String> mostrarModificadoresDeRonda() {
        return AlgoHoot3.obtenerInstancia().mostrarModificadoresUsados();
    }
}
