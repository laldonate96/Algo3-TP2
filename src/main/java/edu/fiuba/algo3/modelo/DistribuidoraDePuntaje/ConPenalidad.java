package edu.fiuba.algo3.modelo.DistribuidoraDePuntaje;

import edu.fiuba.algo3.modelo.Respuesta;

public class ConPenalidad extends DistribuidoraDePuntaje {



    @Override
    public void asignarPuntaje(Respuesta respuesta, int respuestasIncorrectas, int respuestasCorrectas) {

        respuesta.sumarPuntaje((respuestasCorrectas-respuestasIncorrectas) * puntaje);
    }
}
