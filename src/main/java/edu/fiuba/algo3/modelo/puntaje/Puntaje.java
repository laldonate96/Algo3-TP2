package edu.fiuba.algo3.modelo.puntaje;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

public abstract class Puntaje {
    protected int puntaje = 1;

    public abstract void asignarPuntaje(Respuesta respuesta);
}
