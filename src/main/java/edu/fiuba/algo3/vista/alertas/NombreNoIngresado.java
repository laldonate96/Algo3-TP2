package edu.fiuba.algo3.vista.alertas;

import javafx.scene.control.Alert.AlertType;

public class NombreNoIngresado extends Alerta{
    public NombreNoIngresado(){
        super("Nombre no ingresado", "Por favor ingrese un nombre.", AlertType.WARNING);
    }

    
}
