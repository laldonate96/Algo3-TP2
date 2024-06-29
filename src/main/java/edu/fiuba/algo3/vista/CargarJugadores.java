package edu.fiuba.algo3.vista;

import java.util.List;

import edu.fiuba.algo3.controlador.ControladorDeJuego;
import edu.fiuba.algo3.vista.alertas.NombreNoIngresado;
import edu.fiuba.algo3.vista.botones.Boton;
import edu.fiuba.algo3.vista.vistaJugadores.VistaJugadores;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CargarJugadores extends Application {
    private VistaJugadores vistaJugadores = new VistaJugadores();
    private Stage ventanaPrincipal;
    private TextField inputJugador;
    private ControladorDeJuego controladorDeJuego;
    private int MAX_CARACTERES = 25;
    private Toolbar toolbar;

    public CargarJugadores(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.ventanaPrincipal = stage;
        ventanaPrincipal.setTitle("Agreguen los jugadores");

        Label jugadoresLabel = new Label("Agregar Jugador:");
        jugadoresLabel.getStyleClass().add("jugadoresLabel");

        inputJugador = new TextField();
        inputJugador.setMaxWidth(300);

        TextFormatter<String> formatearTexto = new TextFormatter<>(change -> {
            if (change.isAdded() && change.getControlNewText().length() > MAX_CARACTERES) {
                return null;
            }
            return change;
        });

        inputJugador.setTextFormatter(formatearTexto);

        Boton botonJugar = new Boton("Jugar", "button");
        Boton botonAgregar = new Boton("Agregar Jugador", "button");

        botonAgregar.setOnAction(event -> agregarJugador());
        botonJugar.setOnAction(event -> jugar());

        VBox jugadores = vistaJugadores.mostrarJugadores();

        HBox buttonLayout = new HBox(10);
        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.getChildren().addAll(botonAgregar, botonJugar);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(jugadoresLabel, inputJugador, buttonLayout, jugadores);
        layout.setAlignment(Pos.CENTER);

        VBox toolbarBox = toolbar.mostrarToolbar(ventanaPrincipal);

        BorderPane root = new BorderPane();
        root.setTop(toolbarBox);
        root.setCenter(layout);

        Scene scene = new Scene(root, 800, 500);

        String css = getClass().getResource("src/css/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.show();
    }

    public void agregarJugador() {
        String nombreJugador = inputJugador.getText().trim();
        if (!nombreJugador.isEmpty()) {
            vistaJugadores.agregarJugador(nombreJugador);
            inputJugador.clear();
        } else {
            NombreNoIngresado nombreNoIngresado = new NombreNoIngresado();
            nombreNoIngresado.mostrarAlerta();
        }
    }

    public void jugar() {
        List<String> listaDeNombres = vistaJugadores.obtenerJugadores();
        if (!listaDeNombres.isEmpty()) {
            controladorDeJuego.iniciarJuego(listaDeNombres);
            this.ventanaPrincipal.close();
        } else {
            // poner un exception
        }
    }
}
