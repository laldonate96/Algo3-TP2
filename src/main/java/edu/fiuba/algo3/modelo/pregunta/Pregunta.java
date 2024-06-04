package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.DistribuidoraDePuntaje.DistribuidoraDePuntaje;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.util.Pair;

import java.util.List;

public abstract class Pregunta {
    protected String enunciado;
    protected List<String> correctas;
    protected DistribuidoraDePuntaje distribuidoraDePuntaje;

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
        Pair<Integer,Integer> cantidadRespuestas =respuesta.calcularCantidadRespuestas(this.correctas);
        int respuestaIncorrectas = cantidadRespuestas.getKey();
        int respuestasCorrectas = cantidadRespuestas.getValue();
        distribuidoraDePuntaje.asignarPuntaje(respuesta, respuestaIncorrectas, respuestasCorrectas);
    }
}
