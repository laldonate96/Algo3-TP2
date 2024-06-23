package edu.fiuba.algo3.controlador;

import java.util.List;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.jugador.Jugadores;

public class ManejoDeJuego {
        public void iniciarJuego(List<String> nombresDeJugadores){
            AlgoHoot3 algoHoot3 = AlgoHoot3.obtenerInstancia(nombresDeJugadores, new Jugadores());
            
        }
}