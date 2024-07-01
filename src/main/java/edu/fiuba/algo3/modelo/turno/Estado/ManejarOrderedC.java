
package edu.fiuba.algo3.modelo.turno.Estado;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.excepciones.ModificadorInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.OpcionesIncorrectasException;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.OrderedChoice;

import java.util.List;

public class ManejarOrderedC implements Estado {
    private final OrderedChoice pregunta;

    public ManejarOrderedC(OrderedChoice pregunta) {
        this.pregunta=pregunta;
    }


    private void validarOpcion(Opcion opcion) {
        if(!(opcion instanceof Ordenada)){
            throw new OpcionesIncorrectasException(" la pregunta asignada no acepta este tipo de opciones");
        }
    }


    public void validarOpciones(List<Opcion> opcionesJugador) {
        for (Ordenada opcionPregunta:pregunta.obtenerOpciones()) {
            for (Opcion opcion : opcionesJugador) {
                validarOpcion(opcion);
                ((Ordenada)opcion).actualizarEstado(opcionPregunta);
            }
        }

    }





    private void validarModificador(Modificador modificador) {
        if(!pregunta.modificadorEsValido(modificador)){
            throw new ModificadorInvalidoException("El modificador obtenido "+ modificador.getClass() + " no es valido para la pregunta asignada");
        }

    }
}
