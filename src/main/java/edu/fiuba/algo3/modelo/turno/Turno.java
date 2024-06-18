package edu.fiuba.algo3.modelo.turno;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.Respuestas.Respuestas;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ModificadorTurno;
import edu.fiuba.algo3.modelo.opciones.Opciones;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuestas.respuesta.Respuesta;
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
    private Respuestas respuestas;
    private int turno;
    private Pregunta preguntaDelTurno;
    private List<ModificadorPuntaje> modificadoresUsados;
    private ModificadorTurno modificador;

    public Turno(){
        this.modificadoresUsados = new ArrayList<>();
        this.turno=0;
    }
    public Turno(Pregunta preguntaDelTurno, Respuestas respuestas){
        this.modificadoresUsados = new ArrayList<>();
        this.turno=0;
        this.respuestas=respuestas;
        this.preguntaDelTurno=preguntaDelTurno;
    }

    public Turno nuevoTurno(Pregunta preguntaDelTurno, Respuestas respuestas) {
        Turno nuevoTurno=new Turno(preguntaDelTurno,respuestas);
        return nuevoTurno;
    }

    public void asignarModificador(ModificadorTurno modificadorTurno) {
        this.modificador=modificadorTurno;
    }



    public void agregarRespuesta(List<String> opcionesElegidas, Jugador jugador, ModificadorPuntaje modificadorPuntaje) {
        Opciones opcionesJugador=preguntaDelTurno.crearCopiaOpciones(opcionesElegidas);
        respuestas.agregar(opcionesJugador, jugador, modificadorPuntaje);
        modificador.actualizar(modificadorPuntaje,jugador);
        turno += 1;
    }


    public void asignarPuntajes() {
        preguntaDelTurno.asignarPuntajes(respuestas);
        modificador.modificarPuntajes(respuestas);
        respuestas.sumarPuntajes();
    }
}
