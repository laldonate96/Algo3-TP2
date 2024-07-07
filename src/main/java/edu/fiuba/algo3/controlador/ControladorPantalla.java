package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VerVista;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControladorPantalla {
    public void fullscreen(Stage stage, Button boton) {
        if (stage.isFullScreen()) {
            stage.setFullScreen(false);
            boton.setText("FullScreen");
        } else {
            stage.setFullScreen(true);
            boton.setText("Exit FullScreen");
        }
    }

    public void mostrarVentana(Label etiqueta) {
        VerVista reglas = new VerVista();
        reglas.mostrarVentana(etiqueta);
    }
}
