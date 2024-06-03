package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

public class PreguntaMultipleChoiceClasico implements ValidarRespuesta {
    private String enunciado;
    private List<String> respuestaCorrecta;
    private List<String> opciones;
    private int puntos;

    public PreguntaMultipleChoiceClasico(String enunciado, List<String> opciones, List<String> respuestaCorrecta) {
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
        this.puntos = 1;
        this.opciones = opciones;
    }

    @Override
    public void validarRespuestas(List<Respuesta> respuestas) {
        for (Respuesta respuesta : respuestas) {
            validarRespuesta(respuesta);
        }
    }

    @Override
    public void validarRespuesta(Respuesta respuesta) {
        boolean esCorrecta = respuesta.validarRespuesta(respuestaCorrecta);
        if (esCorrecta) {
            respuesta.asignarPuntaje(puntos);
        }
    }
}
