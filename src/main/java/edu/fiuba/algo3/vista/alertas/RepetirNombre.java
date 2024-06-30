package edu.fiuba.algo3.vista.alertas;

import javafx.scene.control.Alert.AlertType;

public class RepetirNombre extends Alerta{
    public RepetirNombre(){
        super("Nombre repetido","el nombre ingresado ya existe, favor ingrese otro", AlertType.WARNING);
    }
}
