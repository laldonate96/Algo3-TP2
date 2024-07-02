package edu.fiuba.algo3.vista.alertas;

import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public abstract class Alerta {
    protected String alerta;
    protected String textoDeAlerta;
    protected Alert.AlertType tipoAlerta;

    public Alerta(String alerta, String textoDeAlerta, Alert.AlertType tipoAlerta) {
        this.alerta = alerta;
        this.textoDeAlerta = textoDeAlerta;
        this.tipoAlerta = tipoAlerta;
    }

    public void mostrarAlerta(Window owner) {
        Alert alert = new Alert(this.tipoAlerta);
        alert.setTitle(this.alerta);
        alert.setHeaderText(this.alerta);
        alert.setContentText(this.textoDeAlerta);

        Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
        alertStage.initModality(Modality.WINDOW_MODAL);
        alertStage.initOwner(owner);
        alertStage.setAlwaysOnTop(true);

       
        alert.showAndWait();
    }
}