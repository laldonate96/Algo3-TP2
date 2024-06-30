package edu.fiuba.algo3.modelo.turno;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.Nulo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

public class Turno {
    private List<Respuesta> respuestas;
    private Pregunta preguntaDelTurno;
    private Modificador modificador;

    public Turno(){
        this.respuestas = new ArrayList<>();
        this.modificador= new Nulo();
    }

    public void establecerPregunta(Pregunta preguntaDelTurno) {
        this.preguntaDelTurno = preguntaDelTurno;
    }



    public void agregarRespuesta(List<Opcion> opcionesJugador, Jugador jugador, Modificador modificador) {
        
        validarOpciones(opcionesJugador,preguntaDelTurno.obtenerOpciones());

        Respuesta respuesta=new Respuesta(opcionesJugador, jugador);
        respuestas.add(respuesta);

        this.modificador.agregarModificador(modificador);

        jugador.usar(modificador);


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


    public void reiniciarTurno(Pregunta pregunta) {
        this.respuestas = new ArrayList<>();
        this.modificador= new Nulo();
        this.preguntaDelTurno=pregunta;
    }
}
