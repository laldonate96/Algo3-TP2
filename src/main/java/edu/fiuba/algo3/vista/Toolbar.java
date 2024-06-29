package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorMusica;
import edu.fiuba.algo3.controlador.ControladorPantalla;
import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaSinRepetirCategoria;
import edu.fiuba.algo3.vista.botones.Boton;
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.stage.Stage; 

public class Toolbar { 
    private Button button1 = new Boton("FullScreen", "botonToolbar");
    private ControladorMusica controladorMusica = new ControladorMusica();
    private ControladorPantalla controladorPantalla = new ControladorPantalla();
    private Label reglas = new Label("Reglas: \n\n" +
        "1. Cada jugador deberá responder preguntas (la pregunta se repite 1 vez por cada jugador).\n" +
        "2. Es responsabilidad de cada jugador no ver la pantalla cuándo otro reponde.\n" +
        "3. Cada pregunta tiene un puntaje asociado.\n" +
        "4. Cada jugador posee distintos modificadores que puede utilizar (multiplicador, anulador, exclusividad).\n" +
        "4.1 Multiplicador: Duplica o triplica el puntaje de la pregunta.\n" +
        "4.2 Anulador: Anula la pregunta para el resto de jugadores (si lo usa mas de 1 jugador, nadie recibe puntos).\n" +
        "4.3.1 Exclusividad: Si el jugador acierta la pregunta, recibe el doble de puntos (sólo si nadie más contestó bien).\n" +
        "4.3.2 Si más jugadores usaron exclusividad, el efecto se acumula.\n" +
        "5. El jugador con más puntos al final de la partida gana.\n"
    );
    private Label acercaDe = new Label("Acerca de: \n\n" +
        "Algohoot es un juego de preguntas y respuestas, donde los jugadores deberán responder preguntas.\n" +
        "El juego fue desarrollado por los siguientes estudiantes de la Universidad de Buenos Aires:\n" +
        "- Lucas Aldonate\n" +
        "- Valentino Ceniceros\n" +
        "- Felipe Santellan\n" +
        "- Ignacio Orgeira\n" +
        "- Ivan Fuschetto.\n" +
        "El juego fue desarrollado en el marco de la materia Algoritmos y Programación III.\n"
    );
    private static Toolbar instancia;

    private Toolbar() {};

    public static Toolbar obtenerInstancia() {
        if (instancia == null) {
            instancia = new Toolbar();
        }
        return instancia;
    }

	public VBox mostrarToolbar(Stage stage) 
	{ 
        button1.setOnAction(e -> controladorPantalla.fullscreen(stage, this.button1)); 
        MenuButton button2 = new MenuButton("Musica");
        MenuItem item1 = new MenuItem("Reproducir/Parar");
        item1.setOnAction(e -> controladorMusica.pausar());
        MenuItem item2 = new MenuItem("Tema 1");
        item2.setOnAction(e -> controladorMusica.cambiarMusica("recursos/musica/Tema 1.mp3"));
        MenuItem item3 = new MenuItem("Tema 2");
        item3.setOnAction(e -> controladorMusica.cambiarMusica("recursos/musica/Tema 2.mp3"));
        MenuItem item4 = new MenuItem("Tema 3");
        Slider sliderVolumen = new Slider(0, 1, 0.1);
        sliderVolumen.valueProperty().addListener((observable, oldValue, newValue) -> {
            controladorMusica.ajustarVolumen(newValue.doubleValue());
        });
        CustomMenuItem sliderMenuItem = new CustomMenuItem(sliderVolumen);
        sliderMenuItem.setHideOnClick(false);
        item4.setOnAction(e -> controladorMusica.cambiarMusica("recursos/musica/Tema 3.mp3"));
        button2.getItems().addAll(item1, item2, item3, item4, sliderMenuItem);
        MenuButton button3 = new MenuButton("Ver");
        MenuItem item5 = new MenuItem("Acerca De");
        item5.setOnAction(e -> controladorPantalla.mostrarVentana(stage, acercaDe));
        MenuItem item6 = new MenuItem("Reglas");
        item6.setOnAction(e -> controladorPantalla.mostrarVentana(stage, reglas));
        button3.getItems().addAll(item5, item6);
        Button button4 = new Boton("Salir", "botonToolbar");
        button4.setOnAction(e -> cerrarJuego(stage));
        ToolBar toolbar = new ToolBar(button1, button2, button3, button4); 
        VBox vbox = new VBox(toolbar);

        return vbox;
	}

    public void cerrarJuego(Stage stage) {
        stage.close();
    }
} 
