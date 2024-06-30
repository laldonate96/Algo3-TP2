package edu.fiuba.algo3.vista.alertas;

import javafx.scene.control.Alert.AlertType;

public class RespuestaNoIngresa extends Alerta{
    public RespuestaNoIngresa(){
        super("Respuesta no ingresada", "por favor ingrese una respuesta", AlertType.WARNING);
    }
}
