package edu.fiuba.algo3.vista;

import java.util.List;

import edu.fiuba.algo3.controlador.ControladorDeJuego;
import edu.fiuba.algo3.controlador.ControladorVentanaNueva;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vista.alertas.AlgoSalioMal;
import edu.fiuba.algo3.vista.alertas.IngreseMasJugadores;
import edu.fiuba.algo3.vista.alertas.NombreNoIngresado;
import edu.fiuba.algo3.vista.alertas.NombresNoIngresados;
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
    private ControladorDeJuego controladorDeJuego = new ControladorDeJuego();
    private int MAX_CARACTERES = 26;
    private ControladorVentanaNueva controladorVentanaNueva = new ControladorVentanaNueva();
    private List<Jugador> jugadores;

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
        botonJugar.setOnAction(event -> jugar());
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

        VBox toolbarBox = Toolbar.obtenerInstancia().mostrarToolbar(ventanaPrincipal);

        BorderPane root = new BorderPane();
        root.setTop(toolbarBox);
        root.setCenter(layout);

        Scene scene = new Scene(root, 1280, 720);

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
            controladorVentanaNueva.abrirVentanaNueva(new PreguntaVista(), ventanaPrincipal);
        } else if(listaDeNombres.isEmpty()){
            NombresNoIngresados nombresNoIngresados = new NombresNoIngresados();
            nombresNoIngresados.mostrarAlerta();
        }else if(listaDeNombres.size() == 1){
            IngreseMasJugadores ingreseMasJugadores = new IngreseMasJugadores();
            ingreseMasJugadores.mostrarAlerta();
        }else{
            AlgoSalioMal algoSalioMal = new AlgoSalioMal();
            algoSalioMal.mostrarAlerta();
        }
    }
}
