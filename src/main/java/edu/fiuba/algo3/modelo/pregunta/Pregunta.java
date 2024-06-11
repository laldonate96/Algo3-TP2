package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public abstract class Pregunta {
    protected String enunciado;
    protected List<Opcion> opciones;
    protected Puntaje puntaje;

    public Pregunta(String enunciado, List<Opcion> opciones, Puntaje puntaje) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.puntaje = puntaje;
    }

    public void asignarPuntajes(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            puntaje.asignarPuntaje(respuesta);
        }
//        puntaje.asignarPuntajes(respuestas);
    }
}
