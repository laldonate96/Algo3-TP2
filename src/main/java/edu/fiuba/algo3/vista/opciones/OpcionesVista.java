package edu.fiuba.algo3.vista.opciones;

import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.scene.layout.GridPane;

public interface OpcionesVista {
    public List<Opcion> retornarOpcionesDelJugador();
}
