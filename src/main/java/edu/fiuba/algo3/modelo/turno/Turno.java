package edu.fiuba.algo3.modelo.turno;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificador.ModificadorTurno;
import edu.fiuba.algo3.modelo.opciones.opcion.Opciones;
import edu.fiuba.algo3.modelo.opciones.Simples;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaConcreta;
    /*
     class Turno {
    - turno :Int
    - respuestasPorTurno <Jugador>
    - preguntaDelTurno: Pregunta
    - modificadoresUsados<Modificador>
    - usarModificador(modificador :Modificador)
    ---
    + {static} Turno()
    + asignarPreguntaDelTurno(pregunta :Pregunta)
    + responderPorTurno(respuestasPorTurno<Respuestas>)
}
     */

public class Turno {
    private int turno;
    private Pregunta preguntaDelTurno;
    private List<ModificadorPuntaje> modificadoresUsados;
    private ModificadorTurno modificador;

    public Turno(Pregunta preguntaDelTurno){
        this.turno = 0;
        this.modificadoresUsados = new ArrayList<ModificadorPuntaje>();
        this.preguntaDelTurno = preguntaDelTurno;
    }

    public void responderPorTurno(List<Respuesta> respuestasPorTurno){
        
        preguntaDelTurno.asignarPuntajes(respuestasPorTurno);
        turno += 1;
    }

    public void asignarModificador(ModificadorTurno modificadorTurno){
        modificador=modificadorTurno;
    }

//    public void responder(Respuesta respuesta) {
//        preguntaDelTurno.asignarPuntaje(respuesta);
//    }

    public int responder(Jugador jugador, List<String> opcionesElegidas) {

        Opciones opcionesJugador=preguntaDelTurno.crearCopiaOpciones(opcionesElegidas);
        Respuesta respuestaJugador=new RespuestaConcreta(opcionesJugador,jugador);
    }
}
