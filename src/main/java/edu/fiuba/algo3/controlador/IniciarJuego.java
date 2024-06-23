package edu.fiuba.algo3.controlador;

import java.util.List;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.Fabricas.FabricaJugadores;
import edu.fiuba.algo3.modelo.jugador.Jugador;


public class IniciarJuego {
    public void iniciarJuego(List<String> nombresDeJugadores) {
        List<Jugador> jugadores = FabricaJugadores.crearListaJugadores(nombresDeJugadores);

        AlgoHoot3 algoHoot = AlgoHoot3.obtenerInstancia();

        algoHoot.asignarJugadores(jugadores);
    }
}