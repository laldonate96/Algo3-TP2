package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public abstract class Pregunta {
    protected String enunciado;
    protected List<String> respuestasCorrectas;

    public Pregunta(String enunciado, List<String> respuestasCorrectas) {
        this.enunciado = enunciado;
        this.respuestasCorrectas = respuestasCorrectas;
    }

    public void validarRespuestas(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            validarRespuesta(respuesta);
        }
    };

    public void validarRespuesta(Respuesta respuesta) {
        respuesta.validarRespuesta(respuestasCorrectas);
    }
}
