package edu.fiuba.algo3.modelo.puntaje;

import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuestas.respuesta.Respuesta;

public class ConPenalidad extends Puntaje {
    protected int puntajeIncorrecta=-1;

    @Override
    public void asignarPuntaje(Respuesta respuesta) {
        for (Opcion opcion : respuesta.obtenerOpciones()) {
            respuesta.asignarPuntaje(opcion.contarCorrecta()*puntaje + opcion.contarIncorrecta()*puntajeIncorrecta );
        }
    }
}
