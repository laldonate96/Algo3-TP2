package edu.fiuba.algo3.modelo.respuesta;

import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import java.util.HashMap;


public class Respuesta {
    private List<String> contenido;
    private Jugador jugador;
    private final String RESPUESTAS_CORRECTAS = "correctas";
    private final String RESPUESTAS_INCORRECTAS = "incorrectas";

    public Respuesta(List<String> contenido, Jugador jugador) {
        this.contenido = contenido;
        this.jugador = jugador;

    }

    public HashMap<String, Integer> calcularCantidadRespuestas(List<String> respuestasCorrectas){
        HashMap<String, Integer> cantidadRespuestas = new HashMap<>();
        int cantidadCorrectas=0,cantidadIncorrectas=0;
        for (String correcta : this.contenido) {
            if (respuestasCorrectas.contains(correcta)) {
                cantidadCorrectas++;
            } else {
                cantidadIncorrectas++;
            }
        }
        cantidadRespuestas.put(RESPUESTAS_CORRECTAS,cantidadCorrectas);
        cantidadRespuestas.put(RESPUESTAS_INCORRECTAS,cantidadIncorrectas);
        return cantidadRespuestas;
    }

    public void sumarPuntaje(int puntaje) {
        jugador.sumarPuntaje(puntaje);
    }


}