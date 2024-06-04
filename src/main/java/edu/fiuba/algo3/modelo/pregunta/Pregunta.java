package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.distribuidoraDePuntaje.DistribuidoraDePuntaje;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.HashMap;
import java.util.List;

public abstract class Pregunta {
    protected String enunciado;
    protected List<String> correctas;
    protected DistribuidoraDePuntaje distribuidoraDePuntaje;
    private static final String RESPUESTAS_CORRECTAS = "correctas";
    private static final String RESPUESTAS_INCORRECTAS = "incorrectas";

    public Pregunta(String enunciado, List<String> respuestasCorrectas, DistribuidoraDePuntaje distribuidoraDePuntaje) {
        this.enunciado = enunciado;
        this.correctas = respuestasCorrectas;
        this.distribuidoraDePuntaje = distribuidoraDePuntaje;
        distribuidoraDePuntaje.establecerTotalCorrectas( this.correctas.size());
    }

    public void asignarPuntajes(List<Respuesta> respuestas) {

        for (Respuesta respuesta : respuestas) {
            asignarPuntaje(respuesta);
        }
    }

    public void asignarPuntaje(Respuesta respuesta) {
        HashMap<String, Integer> cantidadRespuestas = respuesta.calcularCantidadRespuestas(this.correctas);
        int respuestasCorrectas = cantidadRespuestas.getOrDefault(RESPUESTAS_CORRECTAS, 0);
        int respuestaIncorrectas = cantidadRespuestas.getOrDefault(RESPUESTAS_INCORRECTAS, 0);
        distribuidoraDePuntaje.asignarPuntaje(respuesta, respuestaIncorrectas, respuestasCorrectas);
    }
}
