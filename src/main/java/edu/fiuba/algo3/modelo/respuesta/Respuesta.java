package edu.fiuba.algo3.modelo.respuesta;

import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Respuesta {
    private List<String> contenido;
    private Jugador jugador;

    public Respuesta(List<String> contenido, Jugador jugador) {
        this.contenido = contenido;
        this.jugador = jugador;
    }

    public Boolean validarRespuesta(List<String> respuestaCorrecta) {
        return contenido.equals(respuestaCorrecta);
    }
    public void asignarPuntaje(int puntaje) {
        jugador.sumarPuntos(puntaje);
    }
}