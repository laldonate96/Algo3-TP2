package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.distribuidoraDePuntaje.DistribuidoraDePuntaje;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.HashMap;
import java.util.List;

public abstract class Pregunta {
    protected String enunciado;
    protected List<String> correctas;
    protected DistribuidoraDePuntaje distribuidoraDePuntaje;

    public Pregunta(String enunciado, List<String> respuestasCorrectas, DistribuidoraDePuntaje distribuidoraDePuntaje) {
        this.enunciado = enunciado;
        this.correctas = respuestasCorrectas;
        this.distribuidoraDePuntaje = distribuidoraDePuntaje;
        distribuidoraDePuntaje.establecerTotalCorrectas( this.correctas.size());
    }

    public void asignarPuntajes(List<Respuesta> opciones) {

        for (Respuesta respuesta : opciones) {
            asignarPuntaje(respuesta);
        }
    }

    public void asignarPuntaje(Respuesta respuesta) {

    }
}
