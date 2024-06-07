package edu.fiuba.algo3.modelo.puntaje;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

public class ConPenalidad extends Puntaje {
    @Override
    public void asignarPuntaje(Respuesta respuesta) {
        for (Opcion opcion : respuesta.obtenerOpciones()) {
            if (opcion.esCorrecta()) {
                respuesta.sumarPuntaje(puntaje);
            } else {
                respuesta.sumarPuntaje(-puntaje);
            }
        }
    }
}
