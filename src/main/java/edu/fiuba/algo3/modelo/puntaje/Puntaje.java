package edu.fiuba.algo3.modelo.puntaje;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public abstract class Puntaje {
    protected int puntaje = 1;

    protected abstract void asignarPuntaje(Respuesta respuesta);

    public void asignarPuntajes(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            asignarPuntaje(respuesta);
        }
    }
}
