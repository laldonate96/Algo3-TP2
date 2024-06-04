package edu.fiuba.algo3.modelo;

import java.util.List;

import javafx.util.Pair;


public class Respuesta {
    private List<String> contenido;
    private Jugador jugador;

    public Respuesta(List<String> contenido, Jugador jugador) {
        this.contenido = contenido;
        this.jugador = jugador;

    }



    public Pair<Integer,Integer> calcularCantidadRespuestas(List<String> respuestasCorrectas){
        int cantidadCorrectas=0,cantidadIncorrectas=0;
        for (String correcta : this.contenido) {

            if (respuestasCorrectas.contains(correcta)) {
                cantidadCorrectas++;
            } else {
                cantidadIncorrectas++;
            }
        }
        return  new Pair<>(cantidadIncorrectas,cantidadCorrectas);
    }

    public void sumarPuntaje(int puntaje) {
        jugador.sumarPuntaje(puntaje);
    }


}