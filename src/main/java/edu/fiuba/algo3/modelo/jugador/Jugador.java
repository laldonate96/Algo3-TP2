package edu.fiuba.algo3.modelo.jugador;

import java.util.List;

import edu.fiuba.algo3.modelo.modificador.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaConcreta;

public class Jugador {
    private int puntaje;
    private String nombre;
    private List<ModificadorPuntaje> modificadores;

    public Jugador(String nombre, List<ModificadorPuntaje> modificadores) {
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

    public Respuesta responder(List<Opcion> opcionesJugador, List<Opcion> opcionesPregunta, ModificadorPuntaje modificadorPuntaje) {
        Respuesta respuesta = new RespuestaConcreta(opcionesJugador, this, modificadorPuntaje);

        for (Opcion opcionPregunta : opcionesPregunta) {
            respuesta.validarOpcion(opcionPregunta);
        }
        modificadorPuntaje.usar();
        modificadorPuntaje.actualizar(modificadores);
        return respuesta;
    }


    public boolean tieneNombre(String buscado) {
        return nombre.equals(buscado);
    }
}


