package edu.fiuba.algo3.modelo.puntaje;

import edu.fiuba.algo3.modelo.Modificador.Usable;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.List;

public abstract class Puntaje {
    protected int puntaje = 1;

    public abstract void asignarPuntaje(Respuesta respuesta);

    public void asignarPuntajes(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            asignarPuntaje(respuesta);
        }
    }

    public abstract boolean modificadorEsValido(Usable usable);
}

