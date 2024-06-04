package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

public interface TipoPregunta {
    public void asignarPuntaje(int aciertos, int respuestasCorrectas, Respuesta respuesta);
}
