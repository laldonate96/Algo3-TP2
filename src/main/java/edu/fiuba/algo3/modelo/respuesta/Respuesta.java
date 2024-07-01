package edu.fiuba.algo3.modelo.respuesta;

import edu.fiuba.algo3.modelo.opcion.Opcion;

import java.util.List;

public interface Respuesta {
    void sumarPuntaje(int puntaje);

    List<Opcion> obtenerOpciones();

    void validarOpcion(Opcion opcionPregunta);
}
