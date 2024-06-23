package edu.fiuba.algo3.controlador;

import java.util.List;

import edu.fiuba.algo3.modelo.AlgoKahoot3;
import edu.fiuba.algo3.modelo.jugador.Jugadores;

public class ManejoDeJuego {
        public void iniciarJuego(List<String> nombresDeJugadores){
            AlgoKahoot3 algoKahoot3 = AlgoKahoot3.obtenerInstancia(nombresDeJugadores, new Jugadores());
            
        }
}