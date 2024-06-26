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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CargarJugadores extends Application {
    private VistaJugadores vistaJugadores = new VistaJugadores();
    private Stage ventanaPrincipal;
    private TextField inputJugador;
    private ControladorDeJuego controladorDeJuego;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Agreguen los jugadores");

        Label jugadoresLabel = new Label("Agregar Jugador:");
        jugadoresLabel.getStyleClass().add("jugadoresLabel");

        inputJugador = new TextField();
        inputJugador.setMaxWidth(300);  

        Boton botonJugar = new Boton("Jugar", "button");

        Boton botonAgregar = new Boton("Agregar Jugador", "button");
        botonAgregar.setOnAction(event -> agregarJugador());

        VBox jugadores = vistaJugadores.mostrarJugadores();

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20)); 
        layout.getChildren().addAll(jugadoresLabel, inputJugador, botonAgregar, jugadores, botonJugar);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 800, 500);  


        String css = getClass().getResource("src/css/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.setResizable(false);  
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
