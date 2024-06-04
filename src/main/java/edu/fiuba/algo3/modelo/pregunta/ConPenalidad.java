package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

public class ConPenalidad implements TipoPregunta {
    private static final int PUNTAJE = 1;

    @Override
    public void asignarPuntaje(int aciertos, int respuestasCorrectas, Respuesta respuesta) {
        respuesta.asignarPuntaje((aciertos - (respuestasCorrectas - aciertos)) * PUNTAJE);
    }
}
