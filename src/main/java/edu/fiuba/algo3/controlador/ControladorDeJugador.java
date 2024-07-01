package edu.fiuba.algo3.controlador;

import java.util.List;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class ControladorDeJugador {
    public Jugador obtenerJugadorActual(){
        return AlgoHoot3.obtenerInstancia().obtenerJugadorActual();
    }

    public List<Jugador> obtenerJugadores(){
        return AlgoHoot3.obtenerInstancia().jugadoresOrdenadosPorCriterio();
    }
}
