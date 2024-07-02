package edu.fiuba.algo3.vista.opciones;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;

public class VerdaderoOFalsoVista implements OpcionesVista {

    private CheckBox opcion1;
    private CheckBox opcion2;
    private List<Opcion> opciones;

    @Override
    public List<Opcion> retornarOpcionesDelJugador() {
        List<Opcion> opcinesSeleccionadas = new ArrayList<>();
        if (opcion1.isSelected()) {
            opcinesSeleccionadas.add(opciones.get(0));
        } else if (opcion2.isSelected()) {
            opcinesSeleccionadas.add(opciones.get(1));
        }
        return opcinesSeleccionadas;
    }

    @Override
    public void mostrarOpciones(List<Opcion> opciones, Pane contenedor) {
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

        contenedor.getChildren().addAll(opcion1, opcion2);
    }
}
