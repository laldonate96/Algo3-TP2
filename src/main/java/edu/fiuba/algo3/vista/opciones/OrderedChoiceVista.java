package edu.fiuba.algo3.vista.opciones;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class OrderedChoiceVista implements OpcionesVista {
    private List<Spinner<Integer>> selectores = new ArrayList<>();
    private List<Opcion> opciones;

    @Override
    public List<Opcion> retornarOpcionesDelJugador() {
        List<String> opcionesSeleccionadas = new ArrayList<>();
        List<String> ordenSeleccionado = new ArrayList<>();
        for (Spinner<Integer> selector : selectores) {
            opcionesSeleccionadas.add(opciones.get(selectores.indexOf(selector)).obtenerTexto());
            ordenSeleccionado.add(selector.getValue().toString());
        }
        return FabricaOpciones.crearListaOrdenada(opcionesSeleccionadas, ordenSeleccionado, new Incorrecta());
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