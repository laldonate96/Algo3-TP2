package edu.fiuba.algo3.modelo.distribuidoraDePuntaje;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

public class Clasica extends DistribuidoraDePuntaje {



    @Override
    public void asignarPuntaje(Respuesta respuesta, int respuestasIncorrectas, int respuestasCorrectas) {
        if (totalCorrectas == respuestasCorrectas) {
            respuesta.sumarPuntaje(puntaje);
        }
    }
}
