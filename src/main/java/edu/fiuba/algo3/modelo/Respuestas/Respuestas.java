package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Respuestas.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.opciones.Opciones;

public interface Respuestas extends Iterable<Respuesta>{
    void agregar(Opciones opciones, Jugador jugador, ModificadorPuntaje modificadorPuntaje);

    void agregar(Respuesta respuesta);

//    Respuesta buscarRespuestaPorJugador(Jugador jugador);

    Respuesta obtener(int turno);

    void sumarPuntajes();

}
