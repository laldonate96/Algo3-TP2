package edu.fiuba.algo3.testEntrega3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificador.Multiplicador;
import edu.fiuba.algo3.modelo.modificador.Nulo;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.opciones.opcion.Simple;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.turno.Turno;

public class TurnosTest {

    private VerdaderoFalso vof;
    private VerdaderoFalso vofPenal;
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
    private ConPenalidad penalidad;
    private Jugador jugador1;
    private Jugador jugador2;

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
        penalidad = new ConPenalidad();
        vof = new VerdaderoFalso("un enunciado",opciones, clasica,"Mock");
        vofPenal = new VerdaderoFalso("un enunciado",opciones, penalidad,"Mock");

        modificadores = new ArrayList<>(); // Inicializando la lista de modificadores
        multiplicador = new Multiplicador(2);
        nulo = new Nulo();
        modificadores.add(nulo);
        modificadores.add(multiplicador);

        jugador1 = new Jugador("un jugador", modificadores);
        jugador2 = new Jugador("otro jugador", modificadores);


        
        respuestas = new ArrayList<>(); // Inicializando la lista de respuestas
    }

    @Test
    public void test01seJuegaUnTurnoConUnaPreguntaVoFClasicaYseLespidePuntos(){
       //arrange
        Turno turno = new Turno(vof);

        Opcion respuestaJugador1 = new Simple("correcta", incorrecta);
        Opcion respuestaJugador2 = new Simple("incorrecta", incorrecta);
        Respuesta respuesta1 = jugador1.responder(Arrays.asList(respuestaJugador1),opciones, nulo);
        Respuesta respuesta2 = jugador2.responder(Arrays.asList(respuestaJugador2),opciones, nulo);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        //act

        turno.responderPorTurno(respuestas);

        // assert
        
        assertEquals(1, jugador1.obtenerPuntaje());
        assertEquals(0, jugador2.obtenerPuntaje());
    }

    @Test
    public void test02seJuegaUnTurnoConUnaPreguntaVoFPenalizadaConMultiplicadorYseLespidePuntos(){
       //arrange


        Turno turno = new Turno(vofPenal);
        Opcion respuestaJugador = new Simple("correcta", incorrecta);
        Respuesta respuesta1 = jugador1.responder(Arrays.asList(respuestaJugador),opciones, multiplicador);
        Respuesta respuesta2 = jugador2.responder(Arrays.asList(respuestaJugador),opciones, nulo);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        //act


        turno.responderPorTurno(respuestas);

        // assert
        
        assertEquals(2, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());
    }
}
