package edu.fiuba.algo3.modelo.turno;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ModificadorTurno;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
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
    private final List<Respuesta> respuestas;
    private Pregunta preguntaDelTurno;
    private ModificadorTurno modificador;

    public Turno(){
        this.respuestas = new ArrayList<>();
    }

    public void establecerPregunta(Pregunta preguntaDelTurno) {
        this.preguntaDelTurno = preguntaDelTurno;
    }

    public void asignarModificador(ModificadorTurno modificadorTurno) {
        this.modificador = modificadorTurno;
    }

    public void pasarTurno() {
    }

    public void agregarRespuesta(List<Opcion> opcionesJugador, Jugador jugador, ModificadorPuntaje modificadorPuntaje) {
        
        validarOpciones(opcionesJugador,preguntaDelTurno.obtenerOpciones());

        Respuesta respuesta=new Respuesta(opcionesJugador, jugador, modificadorPuntaje);
        
        respuestas.add(respuesta);
        modificador.usar(modificadorPuntaje,jugador);

    }

    private void validarOpciones(List<Opcion> opcionesJugador, List<Opcion> opcionesPregunta) {
        for (Opcion opcionPregunta:opcionesPregunta) {
            for (Opcion opcion : opcionesJugador) {
                opcion.actualizarEstado(opcionPregunta);
            }
        }
    }

    public void asignarPuntajes() {
        preguntaDelTurno.asignarPuntajes(respuestas);
        modificador.modificarPuntajes(respuestas);

        for(Respuesta respuesta:respuestas){
            respuesta.sumarPuntaje();
        }

    }


}
