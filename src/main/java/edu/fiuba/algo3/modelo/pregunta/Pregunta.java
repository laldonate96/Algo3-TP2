package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public abstract class Pregunta {
    protected String categoria;
    protected String enunciado;
    protected List<Opcion> opciones;
    protected Puntaje puntaje;

    public Pregunta(String enunciado, List<Opcion> opciones, Puntaje puntaje, String categoria) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.puntaje = puntaje;
        this.categoria = categoria;
    }

    public void asignarPuntajes(List<Respuesta> respuestas) {
        puntaje.asignarPuntajes(respuestas);
    }

    public String obtenerCategoria() {
        return categoria;
    }
}
