package edu.fiuba.algo3.vista.alertas;

import javafx.scene.control.Alert.AlertType;

public class NombresNoIngresados extends Alerta{
    public NombresNoIngresados(){
        super("Nombres no ingresados", "por favor para empezar a jugar debe ingresar un nombre",AlertType.WARNING);
    }
}
