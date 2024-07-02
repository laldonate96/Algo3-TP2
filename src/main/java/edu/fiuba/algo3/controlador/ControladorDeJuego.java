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
    private List<Pregunta> preguntas;

    public ControladorDeJuego(){
        preguntas = Lector.obtenerPreguntasDeJson(new MezclaSinRepetirCategoria(),("recursos/preguntas.json"));
    }

    public void iniciarJuego(List<String> nombresDeJugadores, int rondas, int puntos) {
        
        List<Jugador> jugadores = FabricaJugadores.crearListaJugadores(nombresDeJugadores);
        
        AlgoHoot3 algoHoot = AlgoHoot3.obtenerInstancia();

        algoHoot.iniciarAlgoHoot(jugadores, new Turno(), new MejorPuntaje(rondas, puntos), preguntas);
        algoHoot.pasarRonda();
    }

    public int cantidadPreguntaJuego() {
        return Lector.obtenerPreguntasDeJson(new MezclaSinRepetirCategoria(),("recursos/preguntas.json")).size();
    }

    public int cantidadPreguntasJuego(){

        return preguntas.size();
    }
}