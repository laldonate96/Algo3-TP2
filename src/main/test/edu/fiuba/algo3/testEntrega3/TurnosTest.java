package edu.fiuba.algo3.testEntrega3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Respuestas.Respuestas;
import edu.fiuba.algo3.modelo.Respuestas.RespuestasConcretas;
import edu.fiuba.algo3.modelo.opciones.Opciones;
import edu.fiuba.algo3.modelo.opciones.Simples;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Multiplicador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.NuloPuntaje;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.opciones.opcion.Simple;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.turno.Turno;

public class TurnosTest {



    private VerdaderoFalso vof;
    private VerdaderoFalso vofPenal;
    private ModificadorPuntaje nulo;
    private ModificadorPuntaje multiplicador;


    private Opciones opciones;
    private Respuestas respuestas;
    private List<ModificadorPuntaje> modificadores;
    private Jugador jugador1;
    private Jugador jugador2;



    @BeforeEach
    public void setUp(){



        List<String> opcionesTexto= Arrays.asList("Correcta", "Incorrecta");
        List<String> posicionesCorrectas= List.of("1");
        opciones=new Simples(opcionesTexto,posicionesCorrectas);

        Clasica clasica=new Clasica(1);
        ConPenalidad penalidad=new ConPenalidad();

        vof = new VerdaderoFalso("un enunciado",opciones, clasica,"Mock");

        vofPenal = new VerdaderoFalso("un enunciado",opciones, penalidad,"Mock");

        modificadores = new ArrayList<>(); // Inicializando la lista de modificadores
        multiplicador = new Multiplicador(2);
        nulo = new NuloPuntaje();
        modificadores.add(nulo);
        modificadores.add(multiplicador);

        jugador1 = new Jugador("un jugador", modificadores);
        jugador2 = new Jugador("otro jugador", modificadores);

        respuestas=new RespuestasConcretas();
        

    }

    @Test
    public void test01seJuegaUnTurnoConUnaPreguntaVoFClasicaYseLespidePuntos(){
       //arrange
        Turno turno = new Turno(vof, new RespuestasConcretas());


        List<String> respuestaJugador1 = List.of("Correcta");
        List<String> respuestaJugador2 = List.of("Incorrecta");


        turno.agregarRespuesta(respuestaJugador1,jugador1,nulo);
        turno.agregarRespuesta(respuestaJugador2,jugador2,nulo);

        //act

        turno.asignarPuntajes();

        // assert
        
        assertEquals(1, jugador1.obtenerPuntaje());
        assertEquals(0, jugador2.obtenerPuntaje());
    }

    @Test
    public void test02seJuegaUnTurnoConUnaPreguntaVoFPenalizadaYseLespidePuntos(){
        //arrange
        Turno turno = new Turno(vof, new RespuestasConcretas());


        List<String> respuestaJugador1 = List.of("Correcta");
        List<String> respuestaJugador2 = List.of("Incorrecta");


        turno.agregarRespuesta(respuestaJugador1,jugador1,nulo);
        turno.agregarRespuesta(respuestaJugador2,jugador2,nulo);

        //act
        turno.asignarPuntajes();

        // assert

        assertEquals(1, jugador1.obtenerPuntaje());
        assertEquals(0, jugador2.obtenerPuntaje());
    }

    @Test
    public void test03seJuegaUnTurnoConUnaPreguntaVoFPenalizadaConMultiplicadorYseLespidePuntos(){
       //arrange
        Turno turno = new Turno(vof, new RespuestasConcretas());


        List<String> respuestaJugadores = List.of("Correcta");


        turno.agregarRespuesta(respuestaJugadores,jugador1,multiplicador);
        turno.agregarRespuesta(respuestaJugadores,jugador2,nulo);

        //act
        turno.asignarPuntajes();

        // assert
        
        assertEquals(2, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());
    }
}
