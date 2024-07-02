package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeJugador;
import edu.fiuba.algo3.controlador.ControladorDePregunta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.animaciones.Animacion;
import edu.fiuba.algo3.vista.animaciones.MaquinaDeEscribir;
import edu.fiuba.algo3.vista.animaciones.Titilante;
import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PreguntaVista extends Application{
    private Stage ventanaPrincipal;
    private Jugador jugador = new ControladorDeJugador().obtenerJugadorActual();
    private Pregunta pregunta = new ControladorDePregunta().mostrarPregunta();

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        ventanaPrincipal.setTitle(jugador.obtenerNombre());
        
        Text titulo = new Text("Pregunta: ");
        Animacion titilante = new Titilante(1, titulo);
        titilante.aplicarAnimacion();

        Text enunciado = new Text();
        Animacion maquinaDeEscribir = new MaquinaDeEscribir(2, enunciado, pregunta.obtenerEnunciado());
        maquinaDeEscribir.aplicarAnimacion();

        

    }
    
}
