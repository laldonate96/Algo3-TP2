package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public abstract class Pregunta {
    protected String enunciado;
    protected List<String> respuestasCorrectas;
    protected TipoPregunta tipoPregunta;

    public Pregunta(String enunciado, List<String> respuestasCorrectas, TipoPregunta tipoPregunta) {
        this.enunciado = enunciado;
        this.respuestasCorrectas = respuestasCorrectas;
        this.tipoPregunta = tipoPregunta;
    }

    public void validarRespuestas(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            validarRespuesta(respuesta, tipoPregunta);
        }
    };

    public void validarRespuesta(Respuesta respuesta, TipoPregunta tipoPregunta) {
        respuesta.validarRespuesta(respuestasCorrectas, tipoPregunta);
    }
}
