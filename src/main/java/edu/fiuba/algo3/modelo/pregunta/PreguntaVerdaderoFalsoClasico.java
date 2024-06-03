package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import java.util.List;

public class PreguntaVerdaderoFalsoClasico implements ValidarRespuesta {
    private String enunciado;
    private List<String> respuestaCorrecta;
    private int puntos;

    public PreguntaVerdaderoFalsoClasico(String enunciado, List<String> respuestaCorrecta) {
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
        this.puntos = 1;
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
