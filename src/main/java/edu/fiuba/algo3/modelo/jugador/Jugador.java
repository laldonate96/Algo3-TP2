package edu.fiuba.algo3.modelo.jugador;

import java.util.List;

import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

public class Jugador {
    private int puntaje;
    private String nombre;
    private List<Modificador> modificadores;

    public Jugador(String nombre, List<Modificador> modificadores) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.modificadores = modificadores;
    }

    public void sumarPuntaje(int puntaje) {
        this.puntaje += puntaje;
    }

    public int obtenerPuntaje() {
        return puntaje;
    }

    public Respuesta responder(List<Opcion> opciones, List<Opcion> opcionesPregunta, Modificador modificador) {
        Respuesta respuesta = new Respuesta(opciones, this, modificador);

        for (Opcion opcionPregunta : opcionesPregunta) {
            respuesta.validarOpcion(opcionPregunta);
        }

        if (modificador.tieneUsos()) {
            modificador.usar();
        } else {
            modificadores.remove(modificador);
        }
        return respuesta;
    }
}


