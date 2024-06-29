package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;

import java.util.List;

public class Respuesta {
    private final List<Opcion> opciones;
    private final Jugador jugador;
    private int puntaje;
    private final Modificador modificador;

    public Respuesta(List<Opcion> opciones, Jugador jugador, Modificador modificador) {
        this.opciones = opciones;
        this.jugador = jugador;
        this.modificador = modificador;
    }

    public void asignarPuntaje(int puntaje) {
        this.puntaje = modificador.modificarPuntaje(puntaje);

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
