package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;

public class PreguntaMultipleChoice extends Pregunta {
    private List<String> opciones;

    public PreguntaMultipleChoice(String enunciado, List<String> opciones, List<String> respuestasCorrectas, TipoPregunta tipoPregunta) {
        super(enunciado, respuestasCorrectas, tipoPregunta);
        this.opciones = opciones;
    }
}
