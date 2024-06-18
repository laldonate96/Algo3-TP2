package edu.fiuba.algo3.modelo.respuesta;

import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;



public class RespuestaConcreta implements Respuesta {
    private final List<Opcion> opciones;
    private final Jugador jugador;
    private int puntaje;
    private final ModificadorPuntaje modificadorPuntaje;

    public RespuestaConcreta(List<Opcion> opciones, Jugador jugador, ModificadorPuntaje modificadorPuntaje) {
        this.opciones = opciones;
        this.jugador = jugador;
        this.modificadorPuntaje = modificadorPuntaje;
    }

    public void asignarPuntaje(int puntaje) {
        puntaje = modificadorPuntaje.modificarPuntaje(puntaje);

    }

    public List<Opcion> obtenerOpciones() {
        return opciones;
    }

    public void validarOpcion(Opcion opcionPregunta) {
        for (Opcion opcion : opciones) {
            opcion.actualizarEstado(opcionPregunta);
        }
    }

    @Override
    public int obtenerPuntaje() {
        return puntaje;
    }

    @Override
    public void multiplicarPuntaje(int valor) {
        puntaje=puntaje*valor;
    }

    @Override
    public boolean esCorrecta() {
        return puntaje>0;
    }

    @Override
    public void sumarPuntaje() {
        jugador.sumarPuntaje(puntaje);
    }

}