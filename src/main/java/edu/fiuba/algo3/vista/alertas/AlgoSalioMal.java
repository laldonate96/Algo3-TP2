package edu.fiuba.algo3.vista.alertas;

import javafx.scene.control.Alert.AlertType;

public class AlgoSalioMal extends Alerta{

    public AlgoSalioMal(){
        super("Algo salio mal", "por favor reinicie el juego", AlertType.ERROR);
    }
    
}
