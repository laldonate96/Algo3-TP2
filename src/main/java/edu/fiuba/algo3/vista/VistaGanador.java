package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeJugador;
import edu.fiuba.algo3.controlador.ControladorMusica;
import edu.fiuba.algo3.controlador.ControladorVentanaNueva;
import edu.fiuba.algo3.vista.animaciones.Titilante;
import edu.fiuba.algo3.vista.animaciones.Traslacion;
import edu.fiuba.algo3.vista.botones.Boton;
import edu.fiuba.algo3.vista.vistaJugadores.VistaJugadoresPodio;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.File;

public class VistaGanador extends Application {
    private Stage ventanaPrincipal;
    private ControladorVentanaNueva controladorVentanaNueva = new ControladorVentanaNueva();
    private InicioDelJuego inicioDelJuego = new InicioDelJuego();
    private VistaJugadoresPodio vistaJugadoresPodio = new VistaJugadoresPodio();
    private ControladorDeJugador controladorDeJugador = new ControladorDeJugador();
    private ControladorMusica controladorMusica = new ControladorMusica();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.ventanaPrincipal = primaryStage;
        controladorMusica.cambiarMusica("recursos/musica/Ganador.mp3");

        Text titulo = new Text("GANADOR " + ganador().toUpperCase());
        titulo.getStyleClass().add("ganadorTitulo");
        Titilante titilante = new Titilante(2, titulo);
        titilante.aplicarAnimacion();
        Boton botonJugar = new Boton("Reiniciar", "botonJugar");
        botonJugar.setOnAction(event -> {
            controladorMusica.cambiarMusica("recursos/musica/Tema 4.mp3");
            controladorVentanaNueva.abrirVentanaNueva(inicioDelJuego, ventanaPrincipal);
        });

        VBox centerBox = new VBox(10);
        centerBox.getChildren().add(titulo);
        centerBox.setAlignment(Pos.CENTER);
        VBox.setMargin(centerBox, new Insets(20));

        VBox jugadoresPodio = new VBox(20);
        vistaJugadoresPodio.armarPodio(jugadoresPodio, controladorDeJugador.obtenerJugadores());
        jugadoresPodio.setAlignment(Pos.CENTER);
        Traslacion traslacion = new Traslacion();
        traslacion.aplicarTraslacion(jugadoresPodio, 2);

        ScrollPane scrollPane = new ScrollPane(jugadoresPodio);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefViewportHeight(300);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");

        VBox resetBox = new VBox(20);
        resetBox.getChildren().addAll(botonJugar);
        resetBox.setAlignment(Pos.BOTTOM_RIGHT);
        resetBox.setPadding(new Insets(20));

        VBox toolbarBox = Toolbar.obtenerInstancia().mostrarToolbar(primaryStage);
        toolbarBox.setAlignment(Pos.TOP_LEFT);

        centerBox.getChildren().add(scrollPane);

        BorderPane ganador = new BorderPane();
        ganador.getStyleClass().add("ganador");
        ganador.setTop(toolbarBox);
        ganador.setCenter(centerBox);
        ganador.setBottom(resetBox);

        Scene escenaDelJuego = new Scene(ganador, 1280, 720);

        try {
            String css =  new File("src/main/java/edu/fiuba/algo3/vista/src/css/style.css").toURI().toString();
            escenaDelJuego.getStylesheets().add(css);
        } catch (NullPointerException e) {
            System.err.println("Archivo CSS no encontrado: " + e.getMessage());
        }

        primaryStage.setTitle("Ganador");
        primaryStage.setScene(escenaDelJuego);
        primaryStage.show();
    }

    public String ganador(){
        return controladorDeJugador.obtenerJugadores().get(0).obtenerNombre();
    }
}
