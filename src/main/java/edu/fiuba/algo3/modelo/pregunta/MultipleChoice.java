package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.distribuidoraDePuntaje.DistribuidoraDePuntaje;

import java.util.List;

public class MultipleChoice extends Pregunta {
    protected List<String> opciones;

    public MultipleChoice(String enunciado, List<String> respuestasCorrectas, DistribuidoraDePuntaje distribuidoraDePuntaje, List<String> opciones) {
        super(enunciado, respuestasCorrectas, distribuidoraDePuntaje);
        this.opciones = opciones;
    }
}
