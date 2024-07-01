package edu.fiuba.algo3.modelo.turno.Estado;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.excepciones.ModificadorInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.OpcionesIncorrectasException;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.MultipleChoice;

import java.util.List;

public class ManejarMultipleC implements Estado {
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
                ((Simple)opcion).actualizarEstado(opcionPregunta);
            }
        }

    }





    private void validarModificador(Modificador modificador) {
        if(!pregunta.modificadorEsValido(modificador)){
            throw new ModificadorInvalidoException("El modificador obtenido "+ modificador.getClass() + " no es valido para la pregunta asignada");
        }

    }
}