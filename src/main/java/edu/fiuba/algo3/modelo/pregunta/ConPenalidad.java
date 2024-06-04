package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

public class ConPenalidad extends DistribucionPuntos {



    @Override
    public void asignarPuntaje(Respuesta respuesta) {
        int respuestasCorrectas=respuesta.cantidadCorrectas();
        int respuestasIncorrectas=respuesta.cantidadIncorrectas();
        respuesta.sumarPuntaje((respuestasCorrectas-respuestasIncorrectas) * puntaje);
    }
}
