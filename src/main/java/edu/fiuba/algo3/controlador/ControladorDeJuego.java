package edu.fiuba.algo3.controlador;

import java.util.List;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.Fabricas.FabricaJugadores;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.turno.Turno;


public class ControladorDeJuego {
    public void iniciarJuego(List<String> nombresDeJugadores) {
        System.out.println("Hola0");
        List<Jugador> jugadores = FabricaJugadores.crearListaJugadores(nombresDeJugadores);
        System.out.println("Hola1");
        AlgoHoot3 algoHoot = AlgoHoot3.obtenerInstancia();
        System.out.println("Hola2");
        algoHoot.asignarJugadores(jugadores);
        System.out.println("Hola3");
        algoHoot.pasarRonda(new Turno());
    }
}