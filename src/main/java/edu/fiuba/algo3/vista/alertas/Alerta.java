package edu.fiuba.algo3.vista.alertas;

import javafx.scene.control.Alert;

public abstract class Alerta {
    protected String alerta;
    protected String textoDeAlerta;
    protected Alert.AlertType tipoAlerta;
    
    public Alerta(String alerta, String textoDeAlerta, Alert.AlertType tipoAlerta){
        this.alerta = alerta;
        this.textoDeAlerta = textoDeAlerta;
        this.tipoAlerta = tipoAlerta;
    }

    public void mostrarAlerta(){
        Alert alert = new Alert(this.tipoAlerta);
            alert.setTitle(this.alerta);
            alert.setHeaderText(null);
            alert.setContentText(this.textoDeAlerta);
            alert.showAndWait();
    }
}
