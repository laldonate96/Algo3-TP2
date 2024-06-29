package edu.fiuba.algo3.vista.opciones;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class EleccionGrupalVista implements OpcionesVista {
    private List<Spinner<String>> selectores;
    private List<Opcion> opciones;

    @Override
    public List<Opcion> retornarOpcionesDelJugador() {
        List<Opcion> opcionesSeleccionadas = new ArrayList<>();
        for (Spinner<String> selector : selectores) {
            opcionesSeleccionadas.add(opciones.get(selector.getValue() - 1));
        }
        return opcionesSeleccionadas;
    }

    @Override
    public void mostrarOpciones(List<Opcion> opcionesRecibidas, Pane contenedor) {
        opciones = opcionesRecibidas;
        selectores = new ArrayList<>();
        int cantidadOpciones = opciones.size();
        VBox vbox = new VBox(10); 

        for (Opcion opcion : opciones) {
            Label labelOpcion = new Label(opcion.obtenerTexto()); 
            Spinner<String> spinnerOpcion = new Spinner<>(1, cantidadOpciones, 1);
            selectores.add(spinnerOpcion);

            HBox hbox = new HBox(10);
            hbox.getChildren().addAll(labelOpcion, spinnerOpcion);

            vbox.getChildren().add(hbox);
        }

        contenedor.getChildren().add(vbox);
    }
}
