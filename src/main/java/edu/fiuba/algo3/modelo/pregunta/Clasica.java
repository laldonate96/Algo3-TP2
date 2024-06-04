package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

public class Clasica implements TipoPregunta {

    @Override
    public void asignarPuntaje(int aciertos, int respuestasCorrectas, Respuesta respuesta) {
        if (aciertos == respuestasCorrectas)
            respuesta.asignarPuntaje(aciertos);
    }
}
