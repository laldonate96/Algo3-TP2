package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public abstract class Pregunta {
    protected String enunciado;
    protected List<String> correctas;
    protected DistribucionPuntos distribucionPuntos;

    public Pregunta(String enunciado, List<String> respuestasCorrectas, DistribucionPuntos distribucionPuntos) {
        this.enunciado = enunciado;
        this.correctas = respuestasCorrectas;
        this.distribucionPuntos = distribucionPuntos;
        distribucionPuntos.establecerTotalCorrectas( this.correctas.size());
    }

    public void asignarPuntajes(List<Respuesta> respuestas) {

        for (Respuesta respuesta : respuestas) {
            asignarPuntaje(respuesta, distribucionPuntos);
        }
    }

    public void asignarPuntaje(Respuesta respuesta, DistribucionPuntos distribucionPuntos) {
        respuesta.verificarRespuesta(this.correctas);
        distribucionPuntos.asignarPuntaje(respuesta);
    }
}
