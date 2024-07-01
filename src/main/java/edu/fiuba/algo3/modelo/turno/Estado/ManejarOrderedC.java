
package edu.fiuba.algo3.modelo.turno.Estado;

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
        Ordenada opcion;
        Ordenada opcionPregunta;
        for (int i=0; i< opcionesJugador.size();i++) {
            validarOpcion(opcionesJugador.get(i));
            opcion = (Ordenada) opcionesJugador;

            opcionPregunta=pregunta.obtenerOpciones().get(i);
            opcionPregunta.actualizarEstado(opcion);

        }

    }





}
