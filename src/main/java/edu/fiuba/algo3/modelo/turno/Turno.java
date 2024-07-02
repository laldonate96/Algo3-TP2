package edu.fiuba.algo3.modelo.turno;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.ModificadorInvalidoException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.Nulo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.turno.Estado.Manejador;

public class Turno {
    private List<Respuesta> respuestas;
    private Pregunta preguntaDelTurno;
    private Modificador modificador;
    private Manejador manejador;

    public Turno(){
        this.respuestas = new ArrayList<>();
        this.modificador= new Nulo();

    }


    public void agregarRespuesta(List<Opcion> opcionesJugador, Jugador jugador, Modificador modificador) {

        manejador.validarOpciones(opcionesJugador);

        Respuesta respuesta=new Respuesta(opcionesJugador, jugador);
        respuestas.add(respuesta);

        if(!preguntaDelTurno.modificadorEsValido(modificador)){
            throw new ModificadorInvalidoException("El modificador obtenido "+ modificador.getClass() + " no es valido para la pregunta asignada");
        }

        this.modificador.agregarModificador(modificador);

        jugador.usar(modificador);


    }



    public void asignarPuntajes() {
        preguntaDelTurno.asignarPuntajes(respuestas);
        modificador.modificarPuntajes(respuestas);

        for(Respuesta respuesta:respuestas){
            respuesta.sumarPuntaje();
        }

    }


    public void reiniciarTurno(Pregunta pregunta, Manejador manejador) {
        this.respuestas = new ArrayList<>();
        this.modificador= new Nulo();
        this.preguntaDelTurno=pregunta;
        this.manejador = manejador;
    }

    public int cantidadDeRespuestas() {
        return respuestas.size();
    }
}