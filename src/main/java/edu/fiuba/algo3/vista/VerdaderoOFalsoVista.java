package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;


public class VerdaderoOFalsoVista implements mostrarOpciones{
    @Override
    public void mostrarOpciones(Pregunta pregunta, GridPane gridPane) {
        CheckBox opcion1 = new CheckBox("Verdadero");
        CheckBox opcion2 = new CheckBox("Falso");
        gridPane.add(opcion1, 0, 7);
        gridPane.add(opcion2, 0, 8);
    }    
}

