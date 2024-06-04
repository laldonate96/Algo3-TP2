package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

public class Clasica extends DistribucionPuntos {



    @Override
    public void asignarPuntaje(Respuesta respuesta) {
        int respuestasCorrectas=respuesta.cantidadCorrectas();
        if (totalCorrectas == respuestasCorrectas)
            respuesta.sumarPuntaje(puntaje);
    }
}
