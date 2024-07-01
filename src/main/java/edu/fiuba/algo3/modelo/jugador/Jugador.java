package edu.fiuba.algo3.modelo.jugador;

import java.util.List;

import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaConcreta;

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

    public Respuesta responder(List<Opcion> opcionesJugador, List<Opcion> opcionesPregunta, Modificador modificador) {
        Respuesta respuesta = new RespuestaConcreta(opcionesJugador, this, modificador);

        for (Opcion opcionPregunta : opcionesPregunta) {
            respuesta.validarOpcion(opcionPregunta);
        }
        modificador.usar();
        modificador.actualizar(modificadores);
        return respuesta;
    }
}


