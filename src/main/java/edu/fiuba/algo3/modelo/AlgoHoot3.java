package edu.fiuba.algo3.modelo;

import java.util.Iterator;
import java.util.List;

import edu.fiuba.algo3.modelo.CriterioDeVictoria.CriterioDeVictoria;
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
    private Turno turno;
    private static AlgoHoot3 instancia;
    private int rondas;
    private Iterator<Jugador> iteradorJugadores;
    private Jugador jugadorActual;
    private CriterioDeVictoria criterio;

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

    public void iniciarAlgoHoot(List<Jugador> jugadores, Turno turno, CriterioDeVictoria criterio) {
        this.jugadores= jugadores;
        this.turno =turno;
        criterio.establecerJugadores(jugadores);
        this.criterio=criterio;
    }

    public void pasarRonda() {
        rondas++;
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.obtenerPuntaje());
        }
        iteradorJugadores = jugadores.iterator();
        jugadorActual = iteradorJugadores.next();
        System.out.println("Ronda: "+rondas);
        System.out.println("terminoJuego: " + terminoJuego());
        if (terminoJuego()) {
            return;
        }
        turno.reiniciarTurno(obtenerPreguntaDeRondaActual());
        return;
    }

    public void jugarTurno(List<Opcion> opcionesElegidas, Modificador modificadorPuntaje) {
        turno.agregarRespuesta(opcionesElegidas, jugadorActual, modificadorPuntaje);
        if (terminoLaRonda()){
            asignarPuntajes();
            iteradorJugadores = jugadores.iterator();
            pasarRonda();
            return;
        }
        jugadorActual=iteradorJugadores.next();
    }

    public boolean terminoLaRonda(){
        return !iteradorJugadores.hasNext() && !terminoJuego();
    }

    public int obtenerRonda(){
        return this.rondas;
    }

    public Pregunta obtenerPreguntaDeRondaActual() {
        return preguntas.get(rondas-1);
    }

    public void asignarPuntajes(){
        turno.asignarPuntajes();
    }

    public Jugador obtenerJugadorActual() {
        return jugadorActual;
    }

    public boolean terminoJuego(){
        return criterio.terminoJuego(this.rondas);
    }

    public Jugador victorioso(){
        return criterio.obtenerGanador();
    }
}
