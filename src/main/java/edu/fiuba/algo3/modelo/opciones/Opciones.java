package edu.fiuba.algo3.modelo.opciones;

import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;

import java.util.List;

public interface Opciones extends Iterable<Opcion> {

    Opciones crearCopia(List<String> opcionesElegidas);


    List<String> obtenerListaStrings();
}
