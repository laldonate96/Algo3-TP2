package edu.fiuba.algo3.vista.opciones;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

public class VerdaderoOFalsoVista implements OpcionesVista {

    private CheckBox opcion1;
    private CheckBox opcion2;
    private List<Simple> opciones;

    @Override
    public List<Opcion> retornarOpcionesDelJugador() {
        List<Opcion> opcionesSeleccionadas = new ArrayList<>();
        if (opcion1.isSelected()) {
            opcionesSeleccionadas.add(opciones.get(0));
        } else if (opcion2.isSelected()) {
            opcionesSeleccionadas.add(opciones.get(1));
        }
        return opcionesSeleccionadas;
    }


    public void mostrarOpciones(List<Simple> opciones, GridPane contenedor) {
        this.opciones = opciones;
        opcion1 = new CheckBox(opciones.get(0).obtenerTexto());
        opcion2 = new CheckBox(opciones.get(1).obtenerTexto());

        opcion1.setOnAction(event -> {
            if (opcion1.isSelected()) {
                opcion2.setSelected(false);
            }
        });

        opcion2.setOnAction(event -> {
            if (opcion2.isSelected()) {
                opcion1.setSelected(false);
            }
        });

        contenedor.add(opcion1, 0, 0);
        contenedor.add(opcion2, 0, 1);
    }
}
