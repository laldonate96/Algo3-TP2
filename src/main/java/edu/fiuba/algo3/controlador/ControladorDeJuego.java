package edu.fiuba.algo3.controlador;

import java.util.List;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.CriterioDeVictoria.MejorPuntaje;
import edu.fiuba.algo3.modelo.Fabricas.FabricaJugadores;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaSinRepetirCategoria;
import edu.fiuba.algo3.modelo.turno.Turno;


public class ControladorDeJuego {
    public void iniciarJuego(List<String> nombresDeJugadores) {
        
        List<Jugador> jugadores = FabricaJugadores.crearListaJugadores(nombresDeJugadores);
        
        AlgoHoot3 algoHoot = AlgoHoot3.obtenerInstancia();
     
        algoHoot.iniciarAlgoHoot(jugadores, new Turno(), new MejorPuntaje(2,40), Lector.obtenerPreguntasDeJson(new MezclaSinRepetirCategoria(),("recursos/preguntas.json")));
        algoHoot.pasarRonda();
    }
}