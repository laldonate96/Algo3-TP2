package edu.fiuba.algo3.modelo.modificadores.ModificadorTurno;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;

import java.util.List;

public interface ModificadorTurno {

     void modificarPuntajes(List<Respuesta> respuestas);


    void usar(ModificadorPuntaje modificadorPuntaje, Jugador jugadorActivo);
}
