package edu.fiuba.algo3.modelo.turno.Estado;

import edu.fiuba.algo3.modelo.excepciones.OpcionesIncorrectasException;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.MultipleChoice;

import java.util.List;

public class ManejarMultipleC implements Manejador {
    private final MultipleChoice pregunta;

    public ManejarMultipleC(MultipleChoice pregunta) {
        this.pregunta=pregunta;
    }

    private void validarOpcion(Opcion opcion) {
        if(!(opcion instanceof Simple)){
            throw new OpcionesIncorrectasException(" la pregunta asignada no acepta este tipo de opciones");
        }
    }

    public void validarOpciones(List<Opcion> opcionesJugador) {
        for (Simple opcionPregunta:pregunta.obtenerOpciones()) {
            for (Opcion opcion : opcionesJugador) {
                validarOpcion(opcion);
                opcionPregunta.actualizarEstado((Simple) opcion);
            }
        }

    }
}