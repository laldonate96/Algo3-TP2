package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Jugadores;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.Mezclador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.turno.Turno;

import java.util.List;

public class Juego {
    private List<Pregunta> preguntas;
    private Controlador controlador;
    private Jugadores jugadores;
    private Turno turnoActual;
    Juego(List<String> jugadores, Controlador controlador){
        List<String> nombreJugadores = jugadores;
        this.jugadores= new Jugadores(nombreJugadores);

        this.controlador = controlador;


        preguntas = Lector.obtenerPreguntasDeJson(new Mezclador());

    }


    public void IniciarTurno() {

        turnoActual =new Turno(preguntas.getFirst());
        preguntas.removeFirst();

        //para cada pregunta inicializa un turno, pasandole los jugadores y la pregunta.

        //controlador.MostrarTurno(Turno);

        //la lógica asociada al turno



    }


    //quizas seria mejor dividir por opcion???
    //Pre: Un jugador eligio ciertas opciones en una pregunta
    //Post: Devuelve los puntos que gano el jugador en esa pregunta sin aplicar modificadores
    public int responder(String nombreJugador, List<String> opcionesElegida){
        Jugador jugador=jugadores.buscarJugador(nombreJugador);

        int puntos=turnoActual.responder(jugador,opcionesElegida)

        return puntos;

    }

    private void iniciarTurno() {

    }
}
