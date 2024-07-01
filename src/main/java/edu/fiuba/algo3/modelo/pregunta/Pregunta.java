package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public abstract class Pregunta {
    protected String categoria;
    protected String enunciado;
    protected String explicacion;

    protected Puntaje puntaje;


    public Pregunta(String enunciado, Puntaje puntaje, String categoria, String explicacion) {
        this.enunciado = enunciado;
        this.puntaje = puntaje;
        this.categoria = categoria;
        this.explicacion = explicacion;
    }

    public void asignarPuntajes(List<Respuesta> respuestas) {
        puntaje.asignarPuntajes(respuestas);
    }

    public boolean modificadorEsValido(Modificador modificador){
        return puntaje.modificadorEsValido(modificador);
    }

    public String obtenerCategoria() {
        return categoria;
    }

    public String obtenerEnunciado() {
        return enunciado;
    }
    public String obtenerExplicacion() {
        return explicacion;
    }


}
