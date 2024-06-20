package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.turno.Turno;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class turnoVista {
    public void mostrarTurno(Turno turno){
        Label turnoLabel = new Label("Turno:");
        TextField turnoTextField = new TextField();
        turnoTextField.setMaxWidth(50);

        Label modificadorLabel = new Label("Modificador jugado");
        TextField modificadorTextField = new TextField();
        modificadorTextField.setMaxWidth(50);
        
    }
}
