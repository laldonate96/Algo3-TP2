package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeJugador;
import edu.fiuba.algo3.controlador.ControladorDePregunta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.animaciones.Animacion;
import edu.fiuba.algo3.vista.animaciones.MaquinaDeEscribir;
import edu.fiuba.algo3.vista.botones.CrearModificadores;
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

public class PreguntaVista extends Application {
    private Stage ventanaPrincipal;
    private Jugador jugador = new ControladorDeJugador().obtenerJugadorActual();
    private Pregunta pregunta = new ControladorDePregunta().mostrarPregunta();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.ventanaPrincipal = stage;
        ventanaPrincipal.setTitle("AlgoHoot - Pregunta");

        Text nombreJugador = new Text(jugador.obtenerNombre());
        nombreJugador.getStyleClass().add("nombreJugador");

        HBox modificadoresBox = new HBox(10);
        modificadoresBox.setAlignment(Pos.CENTER);
        CrearModificadores.crearModificadores(jugador, modificadoresBox);

        VBox jugadorBox = new VBox(10);
        jugadorBox.getChildren().addAll(nombreJugador, modificadoresBox);
        jugadorBox.setAlignment(Pos.CENTER); 

        BorderPane jugadorBoxConBorde = new BorderPane(jugadorBox);
        jugadorBoxConBorde.getStyleClass().add("jugadorBox");
        jugadorBoxConBorde.setPadding(new Insets(10));
        jugadorBoxConBorde.setMaxWidth(400);

        Text enunciado = new Text();
        enunciado.getStyleClass().add("enunciado");
        enunciado.setWrappingWidth(600);

        Animacion maquinaDeEscribir = new MaquinaDeEscribir(2, enunciado, pregunta.obtenerEnunciado());
        maquinaDeEscribir.aplicarAnimacion();

        VBox centerBox = new VBox(20);
        centerBox.getChildren().addAll(enunciado);
        centerBox.setAlignment(Pos.CENTER);

        GridPane contenedorOpciones = new GridPane();
        contenedorOpciones.setVgap(10);
        contenedorOpciones.setAlignment(Pos.CENTER);

        SeleccionadorOpciones.seleccionarVistaOpciones(pregunta, contenedorOpciones);

        VBox toolbarBox = Toolbar.obtenerInstancia().mostrarToolbar(ventanaPrincipal);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(jugadorBoxConBorde, centerBox, contenedorOpciones);
        layout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setTop(toolbarBox);
        root.setCenter(layout);

        Scene scene = new Scene(root, 1280, 720);

        String css = getClass().getResource("src/css/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.show();
    }
}
