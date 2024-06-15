package edu.fiuba.algo3.modelo.turno;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
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
    private List<Modificador> modificadoresUsados;

    public Turno(){
        this.turno = 0;
        this.modificadoresUsados = new ArrayList<Modificador>();
    }
    public void asignarPreguntaDelTurno(Pregunta pregunta){
        this.preguntaDelTurno = pregunta;
    }
    public void responderPorTurno(List<Respuesta> respuestasPorTurno){
        
        preguntaDelTurno.asignarPuntajes(respuestasPorTurno);
        turno += 1;
    }

}
