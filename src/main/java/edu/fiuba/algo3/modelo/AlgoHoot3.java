package edu.fiuba.algo3.modelo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaSinRepetirCategoria;
import edu.fiuba.algo3.modelo.lector.mezclador.Mezclador;
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


    private AlgoHoot3(Mezclador mezclador){
        this.rondas = 0;
        preguntas = Lector.obtenerPreguntasDeJson(mezclador);
    }

    public static AlgoHoot3 obtenerInstancia() {
        if (instancia == null) {
            instancia = new AlgoHoot3(new MezclaSinRepetirCategoria());
        }
        return instancia;
    }

    public static AlgoHoot3 obtenerInstancia(Mezclador mezclador) {
        if (instancia == null) {
            instancia = new AlgoHoot3(mezclador);
        }
        return instancia;
    }

    public void asignarJugadores(List<Jugador> jugadores) {
        this.jugadores= jugadores;
    }

    public int pasarRonda(Turno nuevoTurno) {
        rondas++;
        turnoActual = nuevoTurno;
        iteradorJugadores = jugadores.iterator();
        jugadorActual = iteradorJugadores.next();
        turnoActual.establecerPregunta(preguntas.get(rondas-1));

        return rondas;
    }

    public void jugarTurno(List<Opcion> opcionesElegidas, Modificador modificadorPuntaje) {
        turnoActual.agregarRespuesta(opcionesElegidas, jugadorActual, modificadorPuntaje);
        jugadorActual=iteradorJugadores.next();
        if (!iteradorJugadores.hasNext()){
            asignarPuntajes();
            iteradorJugadores = jugadores.iterator();
            this.pasarRonda(new Turno());
        }
    }

    public boolean quedanJugadores(){
        return iteradorJugadores.hasNext();
    }

    public int obtenerRonda(){
        return this.rondas;
    }

    public Pregunta obtenerPreguntaDeRondaActual() {
        return preguntas.get(rondas-1);
    }



    public void asignarPuntajes(){
        turnoActual.asignarPuntajes();
    }

    public Jugador obtenerJugadorActual() {
        return jugadorActual;
    }

    public Jugador victorioso(){
        Jugador ganador = jugadores.get(0);
        for (Jugador jugador : jugadores){
            ganador = ganador.obtenerMejorPuntuado(jugador);
        }
        return ganador;
    }
}
