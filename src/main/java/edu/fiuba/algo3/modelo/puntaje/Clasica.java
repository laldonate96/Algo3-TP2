package edu.fiuba.algo3.modelo.puntaje;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

public class Clasica extends Puntaje {
    @Override
    public void asignarPuntaje(Respuesta respuesta) {
        for (Opcion opcion : respuesta.getOpciones()) {
            if (!opcion.esCorrecta()) {
                return;
            }
        }
        respuesta.sumarPuntaje(puntaje);
    }
}
