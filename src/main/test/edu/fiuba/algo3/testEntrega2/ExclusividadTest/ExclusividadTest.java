package edu.fiuba.algo3.testEntrega2.ExclusividadTest;

import edu.fiuba.algo3.modelo.modificador.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.turno.Turno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadTest {
    private VerdaderoFalso vof;
    private ModificadorPuntaje nulo;
    private ModificadorPuntaje multiplicador;
    private Correcta correcta;
    private Incorrecta incorrecta;
    private List<Opcion> opciones;
    private List<Respuesta> respuestas;
    private Opcion opcion1;
    private Opcion opcion2;
    private List<ModificadorPuntaje> modificadores;
    private Clasica clasica;
    private Jugador jugador1;
    private Jugador jugador2;
    private ModificadorTurno modificadorTurno;

    @BeforeEach
    public void setUp(){
        correcta = new Correcta();
        incorrecta = new Incorrecta();
        opcion1 = new Simple("correcta", correcta);
        opcion2 = new Simple("incorrecta", incorrecta);

        opciones = new ArrayList<>(); // Inicializando la lista de opciones
        opciones.add(opcion1);
        opciones.add(opcion2);

        clasica = new Clasica(1);
        vof = new VerdaderoFalso("un enunciado",opciones, clasica,"Mock");

        modificadores = new ArrayList<>(); // Inicializando la lista de modificadores
        multiplicador = new Multiplicador(2);
        nulo = new Nulo();
        modificadores.add(nulo);
        modificadores.add(multiplicador);

        jugador1 = new Jugador("un jugador", modificadores);
        jugador2 = new Jugador("otro jugador", modificadores);

        modificadorTurno = new ExclusividadTurno();

        respuestas = new ArrayList<>(); // Inicializando la lista de respuestas
    }

    @Test
    public void test01JugadoresRespondenCorrectamentePreguntaVerdaderoYFalsoNoPenalizadaYunJugadorAplicaExclusividadSeAsignanCorrectamenteSusPuntos(){

        //arrange

        Opcion respuestaJugador1 = new Simple("correcta", incorrecta);
        Opcion respuestaJugador2 = new Simple("correcta", incorrecta);
        Respuesta respuesta1 = jugador1.responder(Arrays.asList(respuestaJugador1),opciones, nulo);
        Respuesta respuesta2 = jugador2.responder(Arrays.asList(respuestaJugador2),opciones, nulo);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        //act

        //jugador1 juega Anulador
        modificadorTurno.asignarPuntajes(respuestas);

        // assert

        assertEquals(0, jugador1.obtenerPuntaje());
        assertEquals(0, jugador2.obtenerPuntaje());
    }

    @Test
    public void test02JugadoresRespondenBienYMalPreguntaVerdaderoYFalsoNoPenalizadaYunJugadorAplicaExclusividadYAsignanCorrectamenteSusPuntos(){
        //arrange

        Opcion respuestaJugador1 = new Simple("correcta", incorrecta);
        Opcion respuestaJugador2 = new Simple("incorrecta", incorrecta);
        Respuesta respuesta1 = jugador1.responder(Arrays.asList(respuestaJugador1),opciones, nulo);
        Respuesta respuesta2 = jugador2.responder(Arrays.asList(respuestaJugador2),opciones, nulo);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        //act

        //jugador1 juega  Exlusividad
        modificadorTurno.asignarPuntajes(respuestas);

        // assert

        assertEquals(2, jugador1.obtenerPuntaje());
        assertEquals(0, jugador2.obtenerPuntaje());
    }
    @Test
    public void test03JugadoresRespondenBienYMalPreguntaVerdaderoYFalsoNoPenalizadaYVariosJugadoresUsanExclusividadYAsignanCorrectamenteSusPuntos(){
        //arrange

        Opcion respuestaJugador1 = new Simple("correcta", incorrecta);
        Opcion respuestaJugador2 = new Simple("incorrecta", incorrecta);
        Respuesta respuesta1 = jugador1.responder(Arrays.asList(respuestaJugador1),opciones, nulo);
        Respuesta respuesta2 = jugador2.responder(Arrays.asList(respuestaJugador2),opciones, nulo);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        //act

        //jugador1 juega  Exclusividad
        // jugador2 juega Exclusividad

        modificadorTurno.asignarPuntajes(respuestas);

        // assert

        assertEquals(4, jugador1.obtenerPuntaje()); //porque cant Jugadores * dobleDePuntos(2)
        assertEquals(0, jugador2.obtenerPuntaje());

    }


}
