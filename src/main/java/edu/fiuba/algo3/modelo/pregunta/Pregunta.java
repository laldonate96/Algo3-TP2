package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public interface Pregunta {
    public void validarRespuestas(List<Respuesta> respuestas);

    public void validarRespuesta(Respuesta respuesta);
}
