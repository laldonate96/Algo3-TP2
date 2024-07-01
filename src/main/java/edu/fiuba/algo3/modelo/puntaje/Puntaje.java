package edu.fiuba.algo3.modelo.puntaje;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.Simple;

import java.util.List;

public abstract class Puntaje {
    protected int puntaje = 1;
    protected List<Modificador> validos;

    public abstract void asignarPuntaje(Respuesta respuesta);

    public void asignarPuntajes(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            asignarPuntaje(respuesta);
        }
    }

    public abstract boolean modificadorEsValido(Modificador modificador);
}

