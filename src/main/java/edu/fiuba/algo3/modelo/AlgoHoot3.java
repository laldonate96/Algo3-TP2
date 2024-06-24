package edu.fiuba.algo3.modelo;

import java.util.Iterator;
import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaSinRepetirCategoria;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ModificadorTurno;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.turno.Turno;

public class AlgoHoot3 {
    private final List<Pregunta> preguntas;
    private List<Jugador> jugadores;
    private Turno turnoActual;
    private static AlgoHoot3 instancia;
    private int rondas;
    private Iterator<Jugador> iteradorJugadores;
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
        iteradorJugadores = jugadores.iterator();
        jugadorActual = iteradorJugadores.next();
        turnoActual.establecerPregunta(preguntas.get(rondas));
        rondas++;
        return rondas;
    }

    public void jugarTurno(List<Opcion> opcionesElegidas, ModificadorPuntaje modificadorPuntaje) {
        turnoActual.agregarRespuesta(opcionesElegidas, jugadorActual, modificadorPuntaje);
        this.turnoActual.pasarTurno();
        jugadorActual=iteradorJugadores.next();
        if (!iteradorJugadores.hasNext()){
            asignarPuntajes();
            iteradorJugadores = jugadores.iterator();
        }
    }

    public boolean quedanJugadores(){
        return iteradorJugadores.hasNext();
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



    public void asignarPuntajes(){
        turnoActual.asignarPuntajes();
    }

    public Jugador obtenerJugadorActual() {
        return jugadorActual;
    }
}
