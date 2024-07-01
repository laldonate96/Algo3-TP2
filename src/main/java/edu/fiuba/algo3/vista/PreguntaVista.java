package edu.fiuba.algo3.vista;

import java.util.List;

import edu.fiuba.algo3.controlador.ControladorDeJugador;
import edu.fiuba.algo3.controlador.ControladorDePregunta;
import edu.fiuba.algo3.controlador.ControladorDeTurno;
import edu.fiuba.algo3.controlador.ControladorVentanaNueva;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.Nulo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.alertas.Alerta;
import edu.fiuba.algo3.vista.alertas.RespuestaNoIngresa;
import edu.fiuba.algo3.vista.animaciones.Animacion;
import edu.fiuba.algo3.vista.animaciones.MaquinaDeEscribir;
import edu.fiuba.algo3.vista.botones.Boton;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vista.botones.BotonModificador;
import edu.fiuba.algo3.vista.botones.BotonNulo;
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
    private ControladorDePregunta controladorDePregunta = new ControladorDePregunta();
    private ControladorDeTurno controladorDeTurno;
    private SeleccionadorOpciones seleccionadorOpciones = new SeleccionadorOpciones();
    public static void main(String[] args) {
        launch(args);
    }
    public void enviarRespuestas(HBox modificadores){
        List<Opcion> respuestas = seleccionadorOpciones.retornarOpcionesDelJugador();
        if(!respuestas.isEmpty()){
            controladorDeTurno = new ControladorDeTurno();
            //Modificador modificarUsado = 
            controladorDeTurno.responderPregunta(respuestas, this.obtenerModificadorUsado(modificadores), ventanaPrincipal);
        } else {
            Alerta RespuestaNoIngresa = new RespuestaNoIngresa();
            RespuestaNoIngresa.mostrarAlerta();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.ventanaPrincipal = stage;
        ventanaPrincipal.setTitle("AlgoHoot - Pregunta");

        Text nombreJugador = new Text(jugador.obtenerNombre());
        nombreJugador.getStyleClass().add("nombreJugador");

        Pregunta pregunta = controladorDePregunta.mostrarPregunta();

        HBox modificadoresBox = new HBox(10);
        modificadoresBox.setAlignment(Pos.CENTER);
        CrearModificadores.crearModificadores(jugador, modificadoresBox, pregunta);

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

        Boton botonResponder = new BotonEnviarRespuesta();
        botonResponder.setOnAction(e -> this.enviarRespuestas(modificadoresBox));

        this.seleccionadorOpciones.seleccionarVistaOpciones(pregunta, contenedorOpciones);

        VBox toolbarBox = Toolbar.obtenerInstancia().mostrarToolbar(ventanaPrincipal);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(jugadorBoxConBorde, centerBox, contenedorOpciones, botonResponder);
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

    public Modificador obtenerModificadorUsado(HBox modificadoresBox){
        BotonModificador botonNulo = (BotonModificador) modificadoresBox.getChildren().get(0);
        for (int i = 0; i < modificadoresBox.getChildren().size(); i++) {
            BotonModificador boton = (BotonModificador) modificadoresBox.getChildren().get(i);
            if(boton.isDisabled()){
                return boton.obtenerModificador();
            }
        }
        return botonNulo.obtenerModificador();
    }
}
