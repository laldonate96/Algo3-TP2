package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuestas.RespuestasConcretas;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Jugadores;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.Mezclador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ModificadorTurno;
import edu.fiuba.algo3.modelo.modificadores.Modificadores;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.turno.Turno;

import java.util.List;

public class Juego {
    private List<Pregunta> preguntas;
//    private Controlador controlador;
    private Jugadores jugadores;
    private Turno turnoActual;
    Juego(List<String> nombreJugadores,Jugadores jugadores, Turno turno){

        this.jugadores= jugadores;
        List<ModificadorPuntaje> modificadores= Modificadores.obtenerListaModificadoresPuntaje();
        jugadores.agregar(nombreJugadores,modificadores);

//        this.controlador = controlador;
        turnoActual=turno;


        preguntas = Lector.obtenerPreguntasDeJson(new Mezclador());

    }


    public void IniciarTurno() {

        turnoActual=turnoActual.nuevoTurno(preguntas.removeFirst(), new RespuestasConcretas());

    }



    public void asignarModificadorTurno(String nombreModificadorTurno){
        ModificadorTurno modificadorTurno= Modificadores.parsearModificadorTurno(nombreModificadorTurno);
        turnoActual.asignarModificador(modificadorTurno);
    }


    //Pre: Un jugador eligio ciertas opciones en una pregunta
    //Post: Devuelve los puntos que gano el jugador en esa pregunta sin aplicar modificadores
    public void crearRespuestaJugador(List<String> opcionesElegida, String nombreJugador, String nombreModificador){
        Jugador jugador=jugadores.buscarJugador(nombreJugador);
        ModificadorPuntaje modificadorPuntaje= Modificadores.parsearModificadorPuntaje(nombreModificador);

        turnoActual.agregarRespuesta(opcionesElegida, jugador, modificadorPuntaje);
    }




    public void asignarPuntajes(){
        turnoActual.asignarPuntajes();
    }


}
