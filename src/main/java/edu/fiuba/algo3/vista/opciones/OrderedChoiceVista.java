package edu.fiuba.algo3.vista.opciones;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class OrderedChoiceVista implements OpcionesVista {
    private List<Spinner<Integer>> selectores = new ArrayList<>();
    private List<Opcion> opciones;

    @Override
    public List<Opcion> retornarOpcionesDelJugador() {
        List<Opcion> opcionesSeleccionadas = new ArrayList<>();
        for (Spinner<Integer> selector : selectores) {
            opcionesSeleccionadas.add(opciones.get(selector.getValue() - 1));
        }
        return opcionesSeleccionadas;
    }

    @Override
    public void mostrarOpciones(List<Opcion> opcionesRecibidas, GridPane contenedor) {
        opciones = opcionesRecibidas;
        int cantidadOpciones = opciones.size();

        for (Opcion opcion : opciones) {
            Label labelOpcion = new Label(opcion.obtenerTexto()); 
            labelOpcion.getStyleClass().add("labelOpcion");
            Spinner<Integer> spinnerOpcion = new Spinner<>(1, cantidadOpciones, 1);
            
            HBox hbox = new HBox(10);
            hbox.getChildren().addAll(spinnerOpcion, labelOpcion);

            contenedor.add(hbox, 0, opciones.indexOf(opcion));
            selectores.add(spinnerOpcion);
        }
    }
}