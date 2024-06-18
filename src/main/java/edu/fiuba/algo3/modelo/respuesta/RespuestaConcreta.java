package edu.fiuba.algo3.modelo.respuesta;

import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.opcion.Opcion;



public class RespuestaConcreta implements Respuesta {
    private List<Opcion> opciones;
    private Jugador jugador;
    private ModificadorPuntaje modificadorPuntaje;

    public RespuestaConcreta(List<Opcion> opciones, Jugador jugador, ModificadorPuntaje modificadorPuntaje) {
        this.opciones = opciones;
        this.jugador = jugador;
        this.modificadorPuntaje = modificadorPuntaje;
    }

    public void sumarPuntaje(int puntaje) {
        int puntajeModificado = modificadorPuntaje.modificarPuntaje(puntaje);
        jugador.sumarPuntaje(puntajeModificado);
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
    public void borrar(ModificadorPuntaje modificadorchiquito) {

    }
}