package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class VerVista {

    public void mostrarVentana(Label etiqueta) {
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.initStyle(StageStyle.UTILITY);
        ventana.setTitle("Reglas del Juego");
        etiqueta.setPadding(new Insets(10));

        VBox layout = new VBox(10);
        layout.getChildren().add(etiqueta);
        layout.setPadding(new Insets(20));

        Scene escena = new Scene(layout, 800, 250);
        ventana.setScene(escena);

        ventana.show();
    }
}
