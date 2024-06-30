package edu.fiuba.algo3.modelo.CriterioDeVictoria;

import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.List;

public interface CriterioDeVictoria {

    void establecerJugadores(List<Jugador> jugadores);

    Jugador obtenerGanador();

    boolean terminoJuego(int rondasJugadas);

}
