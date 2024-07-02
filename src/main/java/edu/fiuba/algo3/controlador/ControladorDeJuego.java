package edu.fiuba.algo3.controlador;

import java.util.List;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.Fabricas.FabricaJugadores;
import edu.fiuba.algo3.modelo.criterioDeVictoria.MejorPuntaje;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaSinRepetirCategoria;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.turno.Turno;


public class ControladorDeJuego {
    public void iniciarJuego(List<String> nombresDeJugadores, int rondas, int puntos) {
        
        List<Jugador> jugadores = FabricaJugadores.crearListaJugadores(nombresDeJugadores);
        
        AlgoHoot3 algoHoot = AlgoHoot3.obtenerInstancia();

        List<Pregunta> preguntas = Lector.obtenerPreguntasDeJson(new MezclaSinRepetirCategoria(),("recursos/preguntas.json"));
     
        algoHoot.iniciarAlgoHoot(jugadores, new Turno(), new MejorPuntaje(rondas, puntos), preguntas);
        algoHoot.pasarRonda();
    }
}