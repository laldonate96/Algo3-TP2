package edu.fiuba.algo3.vista.alertas;

import javafx.scene.control.Alert.AlertType;

public class IngreseMasJugadores extends Alerta{

    public IngreseMasJugadores(){
      super("faltan jugadores para ingresar", "el juego es de entre 2 a mas jugadores", AlertType.WARNING);
    }
}
