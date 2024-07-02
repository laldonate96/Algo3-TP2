package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.alertas.Alerta;
import edu.fiuba.algo3.vista.alertas.AlgoSalioMal;
import javafx.application.Application;
import javafx.stage.Stage;

public class ControladorVentanaNueva {
    public void abrirVentanaNueva(Application vista, Stage stage) {
        try {
            Stage stageNuevo = new Stage();
            if (stage.isFullScreen()) {
                stageNuevo.setFullScreen(true);
            }
            vista.start(stageNuevo);
            stage.close();
        } catch (Exception e) {
            Alerta algoSalioMal = new AlgoSalioMal();
            algoSalioMal.mostrarAlerta(stage);
        }
    }
}
