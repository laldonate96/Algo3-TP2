package edu.fiuba.algo3.vista.vistaJugadores;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
//import org.w3c.dom.Text;
import javafx.scene.text.*;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VistaJugadoresPodio {

    public void armarPodio(VBox jugadoresPodio, List<Jugador> jugadores) {

        int top = 1;
        for (Jugador jugador : jugadores) {
            Text jugadorTop1 = new Text(jugador.obtenerNombre() + " ");
            jugadorTop1.getStyleClass().add("primeraVentanaTitulo");
            VBox jugadorBox = new VBox(10);
            jugadorBox.getChildren().addAll(jugadorTop1);

            Text puntuacion = new Text(jugador.obtenerPuntaje() + " puntos");
            puntuacion.getStyleClass().add("primeraVentanaTitulo");
            VBox puntuacionBox = new VBox(10);
            puntuacionBox.getChildren().addAll(puntuacion);

            if (top == 1) {
                jugadorBox.getStyleClass().add("jugadorGanador");
                puntuacionBox.getStyleClass().add("puntuacionGanador");
            } else {
                jugadorBox.getStyleClass().add("jugadoresPodio");
                puntuacionBox.getStyleClass().add("jugadoresPodio");
                ;
            }

            HBox contenedor2 = new HBox(10);
            contenedor2.getChildren().addAll(jugadorBox, puntuacionBox);
            contenedor2.setAlignment(Pos.CENTER);
            jugadoresPodio.getChildren().add(contenedor2);
            top++;
        }
    }
}