package edu.fiuba.algo3.vista.alertas;

import javafx.scene.control.Alert;

public abstract class Alerta {
    protected String alerta;
    protected String textoDeAlerta;
    
    public Alerta(String alerta, String textoDeAlerta){
        this.alerta = alerta;
        this.textoDeAlerta = textoDeAlerta;
    }

    public void mostrarAlerta(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(this.alerta);
            alert.setHeaderText(null);
            alert.setContentText(this.textoDeAlerta);
            alert.showAndWait();
    }
}
