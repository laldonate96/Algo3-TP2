package edu.fiuba.algo3.modelo;


import java.util.Iterator;
import java.util.List;

import edu.fiuba.algo3.modelo.CriterioDeVictoria.CriterioDeVictoria;
import edu.fiuba.algo3.modelo.Fabricas.FabricaEstado;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.excepciones.CantidadDeJugadoresMenorADosException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.turno.Turno;


public class AlgoHoot3 {
    private List<Pregunta> preguntas;
    private List<Jugador> jugadores;
    private Turno turno;
    private static AlgoHoot3 instancia;
    private int rondas;
    private Iterator<Jugador> iteradorJugadores;
    private Jugador jugadorActual;
    private CriterioDeVictoria criterio;


    private AlgoHoot3(){}

    public static AlgoHoot3 obtenerInstancia() {
        if (instancia == null) {
            instancia = new AlgoHoot3();
        }
        return instancia;
    }


    private void validarJugadores(List<Jugador> jugadores) {
        if (jugadores.size()<2){
            throw new CantidadDeJugadoresMenorADosException("Por favor ingrese al menos dos jugadores");
        }
    }

    public void iniciarAlgoHoot(List<Jugador> jugadores, Turno turno, CriterioDeVictoria criterio, List<Pregunta> preguntas) {

        this.preguntas=preguntas;

        validarJugadores(jugadores);
        this.jugadores = jugadores;

        this.turno =turno;


        criterio.establecerJugadores(jugadores);
        this.criterio=criterio;

        rondas=0;
        jugadorActual=null;
        iteradorJugadores=null;

    }

    public void pasarRonda() {
        rondas++;
        iteradorJugadores = jugadores.iterator();
        jugadorActual = iteradorJugadores.next();
        if (terminoJuego()) {
            return;
        }
        turno.reiniciarTurno(obtenerPreguntaDeRondaActual(), FabricaEstado.crearEstado(obtenerPreguntaDeRondaActual()));
    }

    public void jugarTurno(List<Opcion> opcionesElegidas, Modificador modificador) {
        turno.agregarRespuesta(opcionesElegidas, jugadorActual, modificador);
        if (terminoLaRonda()){
            asignarPuntajes();
            return;
        }
        jugadorActual=iteradorJugadores.next();
    }
    
    public boolean terminoLaRonda(){
        return (turno.cantidadDeRespuestas() == jugadores.size()) && !terminoJuego();
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

    public List<Jugador> jugadoresOrdenadosPorCriterio(){
        return criterio.jugadoresOrdenados();
    }
}