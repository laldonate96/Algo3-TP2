package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;


public class MultipleChoiseVista implements mostrarOpciones{
    @Override
    public void mostrarOpciones(Pregunta pregunta, GridPane gridPane) {
            int row = 7;
            for (String opcion : pregunta.obtenerOpciones()) {
                CheckBox checkBox = new CheckBox(opcion);
                gridPane.add(checkBox, 0, row++);
    }
    }
}