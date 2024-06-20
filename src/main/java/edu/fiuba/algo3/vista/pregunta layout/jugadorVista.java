package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class jugadorVista {
    public void mostrarJugador(Jugador jugador){

        Label jugadorLabel = new Label("Jugador:");
        TextField jugadorTextField = new TextField();
        jugadorTextField.setMaxWidth(200);
     
        Label puntosLabel = new Label("Puntos");
        TextField puntosTextField = new TextField();
        puntosTextField.setMaxWidth(50);
    }

}
