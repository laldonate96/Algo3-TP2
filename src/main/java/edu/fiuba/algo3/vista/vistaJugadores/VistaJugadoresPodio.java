package edu.fiuba.algo3.vista.vistaJugadores;

import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VistaJugadoresPodio {

    public void armarPodio(VBox jugadoresPodio, List<Jugador> jugadores) {

        jugadores.remove(0);
        List<Jugador> topJugadores = jugadores.subList(0, Math.min(2, jugadores.size()));

        int count = 0;
        for (Jugador jugador : topJugadores) {

            Text jugadorTop1 = new Text(jugador.obtenerNombre() + " ");

            VBox jugadorBox = new VBox(10);
            jugadorBox.getChildren().addAll(jugadorTop1);
            
            if (count == 0) {
                jugadorTop1.getStyleClass().add("primerElementoTitulo");
                jugadorBox.getStyleClass().add("primerElementoPodio");
            } else {
                jugadorTop1.getStyleClass().add("primeraVentanaTitulo");
                jugadorBox.getStyleClass().add("jugadoresPodio");
            }

            jugadorBox.setAlignment(Pos.CENTER);
            jugadorBox.setMaxWidth(Double.MAX_VALUE); 
            
            VBox contenedor2 = new VBox(10);
            contenedor2.getChildren().addAll(jugadorBox);
            contenedor2.setAlignment(Pos.CENTER);
            contenedor2.setMaxWidth(Double.MAX_VALUE);
            
            jugadoresPodio.getChildren().add(contenedor2);
            
            count++;
        }
    }
}