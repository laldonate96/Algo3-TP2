package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public abstract class Pregunta {
    protected String enunciado;
    protected TipoPregunta tipoPregunta;
    protected List<String> respuestaCorrecta;

    public Pregunta(String enunciado, List<String> respuestaCorrecta, TipoPregunta tipoPregunta) {
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
        this.tipoPregunta = tipoPregunta;
    }

    public void validarRespuestas(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            boolean esCorrecta = validarRespuesta(respuesta);
            tipoPregunta.asignarPuntaje(esCorrecta, respuesta);
        }
    };

    public boolean validarRespuesta(Respuesta respuesta) {
        return respuesta.validarRespuesta(respuestaCorrecta);
    }
}
