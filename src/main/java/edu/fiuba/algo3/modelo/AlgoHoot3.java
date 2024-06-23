package edu.fiuba.algo3.modelo;

import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaSinRepetirCategoria;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ModificadorTurno;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.turno.Turno;

public class AlgoHoot3 {
    private final List<Pregunta> preguntas;
    private List<Jugador> jugadores;
    private Turno turnoActual;
    private static AlgoHoot3 instancia;
    private int rondas;
    private Jugador jugadorActual;

    private AlgoHoot3(){
        this.rondas = 0;
        preguntas = Lector.obtenerPreguntasDeJson(new MezclaSinRepetirCategoria());
    }

    public static AlgoHoot3 obtenerInstancia() {
        if (instancia == null) {
            instancia = new AlgoHoot3();
        }
        return instancia;
    }

    public void asignarJugadores(List<Jugador> jugadores) {
        this.jugadores= jugadores;
    }

    public int pasarRonda(Turno nuevoTurno) {
        turnoActual = nuevoTurno;
        jugadorActual = jugadores.get(0);
        turnoActual.establecerPregunta(preguntas.get(rondas));
        rondas++;
        return rondas;
    }

    public void pasarTurno(List<String> opcionesElegidas, ModificadorPuntaje modificadorPuntaje) {
        turnoActual.agregarRespuesta(opcionesElegidas, jugadorActual, modificadorPuntaje);
        this.turnoActual.pasarTurno();
        rondas++;
    }

    public void jugarTurno(){
        
    }

    public int obtenerRonda(){
        return this.rondas;
    }

    public Pregunta obtenerPreguntaDeRondaActual() {
        return preguntas.get(rondas);
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

    public Jugador obtenerJugadorActual() {
        return jugadorActual;
    }
}
