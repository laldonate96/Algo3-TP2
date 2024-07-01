package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.turno.Turno;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.List;

public class Juego {

    private Turno turnoActual;
    private List<Pregunta> preguntas;
    private List<Jugador> jugadores;

    public void IniciarJuego(){

        //Controlador.InicializarJuego()
        //muestra el comienzo del juego, solicita ingreso de jugadores y los va agregando a jugadores

        //Lector.ObtenerPreguntasDeJson()
        //carga todas las preguntas en preguntas

        int cantidadDePreguntas = preguntas.size();
        int i = 0;
        while (i < cantidadDePreguntas) {

            //turnoActual = Turno new(jugadores, preguntas[i])
            //para cada pregunta inicializa un turno, pasandole los jugadores y la pregunta.

            //Controlador.MostrarTurno(turnoActual);
            //la lógica asociada al turno
            i++;
        }
        return;
    }
}
