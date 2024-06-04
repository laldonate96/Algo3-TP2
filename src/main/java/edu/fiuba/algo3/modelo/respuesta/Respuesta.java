package edu.fiuba.algo3.modelo.respuesta;

import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;


public class Respuesta {
    private List<String> contenido;
    private Jugador jugador;
    private int cantidadCorrectas;
    private int cantidadIncorrectas;

    public Respuesta(List<String> contenido, Jugador jugador) {
        this.contenido = contenido;
        this.jugador = jugador;
        cantidadCorrectas=0;
        cantidadIncorrectas=0;

    }

    public void verificarRespuesta(List<String> respuestasCorrectas){
        for (String correcta : this.contenido) {

            if (respuestasCorrectas.contains(correcta)) {
                cantidadCorrectas++;
            } else {
                cantidadIncorrectas++;
            }
        }
    }


    public void sumarPuntaje(int puntaje) {
        jugador.sumarPuntaje(puntaje);
    }

    public int cantidadCorrectas() {
        return cantidadCorrectas;
    }
    public int cantidadIncorrectas(){
        return cantidadIncorrectas;
    }
}