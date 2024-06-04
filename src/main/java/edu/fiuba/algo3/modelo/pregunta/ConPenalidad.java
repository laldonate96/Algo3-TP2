package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

public class ConPenalidad extends DistribuidoraDePuntaje {



    @Override
    public void asignarPuntaje(Respuesta respuesta, int respuestasIncorrectas, int respuestasCorrectas) {

        respuesta.sumarPuntaje((respuestasCorrectas-respuestasIncorrectas) * puntaje);
    }
}
