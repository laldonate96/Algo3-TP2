package edu.fiuba.algo3.modelo.CriterioDeVictoria;

import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.List;

public interface CriterioDeVictoria {

    void establecerJugadores(List<Jugador> jugadores);

    List<Jugador> jugadoresOrdenados();

    boolean terminoJuego(int rondasJugadas);

}
