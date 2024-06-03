package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

public class ConPenalidad implements TipoPregunta {
    private int puntaje;

    public ConPenalidad() {
        this.puntaje = 1;
    }

    @Override
    public void asignarPuntaje(boolean esCorrecta, Respuesta respuesta) {
        if (esCorrecta)
            respuesta.asignarPuntaje(this.puntaje);
        else
            respuesta.asignarPuntaje(-this.puntaje);
    }
}
