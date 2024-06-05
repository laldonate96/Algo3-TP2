package edu.fiuba.algo3.modelo.respuesta;

import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;



public class Respuesta {
    private List<Opcion> opciones;
    private Jugador jugador;

    public Respuesta(List<Opcion> opciones, Jugador jugador) {
        this.opciones = opciones;
        this.jugador = jugador;
    }

    public void sumarPuntaje(int puntaje) {
        jugador.sumarPuntaje(puntaje);
    }
}