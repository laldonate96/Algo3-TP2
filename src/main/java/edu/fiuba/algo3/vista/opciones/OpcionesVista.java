package edu.fiuba.algo3.vista.opciones;

import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.scene.layout.Pane;

public interface OpcionesVista {
    public void mostrarOpciones(List<Opcion> opciones, Pane contenedor);
    public List<Opcion> retornarOpcionesDelJugador();
}
