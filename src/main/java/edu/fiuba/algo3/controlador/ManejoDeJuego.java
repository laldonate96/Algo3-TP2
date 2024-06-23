package edu.fiuba.algo3.controlador;

import java.util.List;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class ManejoDeJuego {
        public void iniciarJuego(List<String> nombresDeJugadores){
            List<Jugador> jugadores= FabricaJugadores.CrearListaJugadores(nombresDeJugadores);
            AlgoHoot3 algoHoot3 = AlgoHoot3.obtenerInstancia(jugadores);
            
        }
}