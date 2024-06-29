package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.jugador.Jugador;

import edu.fiuba.algo3.modelo.opcion.Opcion;

import java.util.List;

public class Respuesta {
    private final List<Opcion> opciones;
    private final Jugador jugador;
    private int puntaje;

    public Respuesta(List<Opcion> opciones, Jugador jugador) {
        this.opciones = opciones;
        this.jugador = jugador;
    }

    public void asignarPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public List<Opcion> obtenerOpciones() {
        return opciones;
    }

    public int obtenerPuntaje() {
        return puntaje;
    }

    public void multiplicarPuntaje(int valor) {
        puntaje=puntaje*valor;
    }

    public boolean esCorrecta() {
        return puntaje>0;
    }

    public void sumarPuntaje() {
        jugador.sumarPuntaje(puntaje);
    }

    public boolean perteneceA(Jugador jugador) {
        return this.jugador.equals(jugador);
    }
}
