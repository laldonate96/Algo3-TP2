package edu.fiuba.algo3.vista.opciones;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.scene.layout.Pane;

public class OrderedChoiceVista implements OpcionesVista {
    private List<Opcion> opciones;

    @Override
    public List<Opcion> retornarOpcionesDelJugador(){
        return new ArrayList<>();
    }

    @Override
    public void mostrarOpciones(List<Opcion> opcionesRecibidas, Pane contenedor) {
        opciones = opcionesRecibidas;

        //hacer que se puedan arrastrar, y que el orden -vertical- defina la posicion en la lista opciones
        //opción facil: con botones con flechitas. Opcion difícil: drag and drop.
    }
}
