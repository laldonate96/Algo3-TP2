package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;

public class MultipleChoice extends Pregunta {
    protected List<String> opciones;

    public MultipleChoice(String enunciado, List<String> opciones, List<String> respuestasCorrectas, DistribuidoraDePuntaje distribuidoraDePuntaje) {
        super(enunciado, respuestasCorrectas, distribuidoraDePuntaje);
        this.opciones = opciones;
    }
}
