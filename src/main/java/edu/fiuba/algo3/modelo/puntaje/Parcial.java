package edu.fiuba.algo3.modelo.puntaje;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

public class Parcial extends Puntaje {


    @Override
    public void asignarPuntaje(Respuesta respuesta) {
        int puntosParciales = 0;

        for (Opcion opcion : respuesta.obtenerOpciones()) {
            if (opcion.esCorrecta()) {
                puntosParciales += puntaje;
            } else {
                return;
            }
        }

        respuesta.sumarPuntaje(puntosParciales);
    }
}




