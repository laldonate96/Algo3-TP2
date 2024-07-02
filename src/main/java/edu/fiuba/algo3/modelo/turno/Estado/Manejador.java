package edu.fiuba.algo3.modelo.turno.Estado;

import edu.fiuba.algo3.modelo.opcion.Opcion;


import java.util.List;

public interface Manejador {
    void validarOpciones(List<Opcion> opcionesJugador);
}