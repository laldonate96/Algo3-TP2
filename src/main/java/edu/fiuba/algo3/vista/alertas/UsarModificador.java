package edu.fiuba.algo3.vista.alertas;

import javafx.scene.control.Alert.AlertType;


public class UsarModificador extends Alerta{
    public UsarModificador(){
        super("Esta seguro de que quiere usar el modificador", "tiene un unico uso para cada modificador",AlertType.WARNING);
    }
}
