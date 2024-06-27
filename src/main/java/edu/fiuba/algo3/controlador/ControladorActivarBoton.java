package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControladorActivarBoton implements EventHandler<ActionEvent> {

    private final Button boton;

    public ControladorActivarBoton(Button boton){
        this.boton= boton;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.boton.setStyle("-fx-background-color: grey;");
    }
}