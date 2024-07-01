package edu.fiuba.algo3.modelo.puntaje;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

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

    public boolean modificadorEsValido(Modificador modificador) {
        for (Modificador modificadorValido: validos){
            if (modificador.getClass().equals(modificadorValido.getClass())) {
                return true;
            }
        }
        return false;
    }
}

