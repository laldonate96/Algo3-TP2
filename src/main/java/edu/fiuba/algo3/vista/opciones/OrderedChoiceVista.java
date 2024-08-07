package edu.fiuba.algo3.vista.opciones;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class OrderedChoiceVista implements OpcionesVista {
    private final List<Spinner<Integer>> selectores = new ArrayList<>();
    private List<Ordenada> opciones;
    String texto;

    @Override
    public List<Opcion> retornarOpcionesDelJugador() {
        List<Opcion> opcionesJugador = new ArrayList<>();
        for (Spinner<Integer> selector : selectores) {

            texto = opciones.get(selectores.indexOf(selector)).obtenerTexto();
            int posicion = Integer.parseInt(selector.getValue().toString());
            opcionesJugador.add(new Ordenada(texto, posicion));
        }

        return opcionesJugador;
    }


    public void mostrarOpciones(List<Ordenada> opcionesRecibidas, GridPane contenedor) {
        opciones = opcionesRecibidas;
        int cantidadOpciones = opciones.size();

        for (Ordenada opcion : opciones) {
            Label labelOpcion = new Label(opcion.obtenerTexto()); 
            labelOpcion.getStyleClass().add("labelOpcion");
            Spinner<Integer> spinnerOpcion = new Spinner<>(1, cantidadOpciones, 1);
            spinnerOpcion.setPrefWidth(75);
            
            HBox hbox = new HBox(10);
            hbox.getChildren().addAll(spinnerOpcion, labelOpcion);

            contenedor.add(hbox, 0, opciones.indexOf(opcion));
            selectores.add(spinnerOpcion);
        }
    }
}