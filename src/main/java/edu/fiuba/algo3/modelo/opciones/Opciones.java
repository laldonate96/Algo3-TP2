package edu.fiuba.algo3.modelo.opciones;

import edu.fiuba.algo3.modelo.opciones.opcion.Simple;

import java.util.List;

public interface Opciones {

    Opciones crearCopia(List<String> opcionesElegidas);
}
