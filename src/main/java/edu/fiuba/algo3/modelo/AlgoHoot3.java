package edu.fiuba.algo3.modelo;

import java.util.List;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaSinRepetirCategoria;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ModificadorTurno;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.turno.Turno;

public class AlgoHoot3 {
    private final List<Pregunta> preguntas;
    private final List<Jugador> jugadores;
    private Turno turnoActual;
    private static AlgoHoot3 instancia;
    private int rondas;

    private AlgoHoot3(List<Jugador> jugadores){
        this.jugadores = jugadores;
        this.rondas = 0;
        preguntas = Lector.obtenerPreguntasDeJson(new MezclaSinRepetirCategoria());
    }

    public static AlgoHoot3 obtenerInstancia(List<Jugador> jugadores) {
        if (instancia == null) {
            instancia = new AlgoHoot3(jugadores);
        }
        return instancia;
    }



    public void pasarRonda(Turno nuevoTurno) {
        turnoActual = nuevoTurno;
        turnoActual.establecerPregunta(preguntas.remove(0));
        rondas++;
    }

    public void jugar(){

    }

    public int obtenerRonda(){
        return this.rondas;
    }

    public void asignarModificadorTurno(ModificadorTurno modificadorTurno){
        turnoActual.asignarModificador(modificadorTurno);
    }


     public void crearRespuestaJugador(List<String> opcionesElegida, Jugador jugador, ModificadorPuntaje modificadorPuntaje){
        turnoActual.agregarRespuesta(opcionesElegida, jugador, modificadorPuntaje);
    }

    public void asignarPuntajes(){
        turnoActual.asignarPuntajes();
    }


}
