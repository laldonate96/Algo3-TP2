package edu.fiuba.algo3.testEntrega4.AlgoHoot3Test;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.CriterioDeVictoria.MejorPuntaje;
import edu.fiuba.algo3.modelo.Fabricas.FabricaJugadores;
import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Fabricas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaNula;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.pregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.turno.Turno;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlgoHootTest {
    private List<Jugador> jugadores;
    private AlgoHoot3 algoHoot3;
    private OrderedChoice preguntaOrdenadaEsperada;
    private List<Pregunta> preguntasEsperadas;
    private static String nombreJugador1;
    private static String nombreJugador2;
    private static String nombreJugador3;


    @BeforeAll
    public static void setupClass(){
        nombreJugador1="Ignacioo";
        nombreJugador2="Lucas";
        nombreJugador3="Ivan";

    }

    @BeforeEach
    public void setUp(){
        List<String> jugadoresString = List.of(nombreJugador1,nombreJugador2,nombreJugador3);

        preguntasEsperadas = Lector.obtenerPreguntasDeJson(new MezclaNula(), ("recursos/test.json"));
        preguntaOrdenadaEsperada=(OrderedChoice) preguntasEsperadas.get(0);
        jugadores = FabricaJugadores.crearListaJugadores(jugadoresString);

        algoHoot3 = AlgoHoot3.obtenerInstancia();

    }

    @Test
    public void test01SeCreaYSusRondasSon0(){
        //Arrange
        algoHoot3.iniciarAlgoHoot(jugadores, new Turno(), new MejorPuntaje(3,14),
                                    Lector.obtenerPreguntasDeJson(new MezclaNula(),("recursos/test.json")));

        //Act

        int ronda = algoHoot3.obtenerRonda();

        //Assert
        assertEquals(0, ronda);
    }
    @Test
    public void test02AlPasarRondaSinJugarNoTerminoLaRonda(){
        //Arrange
        algoHoot3.iniciarAlgoHoot(jugadores, new Turno(),
                                    new MejorPuntaje(3,14),
                                    Lector.obtenerPreguntasDeJson(new MezclaNula(),("recursos/test.json")));


        //Act
        algoHoot3.pasarRonda();

        //Assert
        assertFalse(algoHoot3.terminoLaRonda());
    }
    @Test
    public void test03AlPasarRondaYSolicitarPreguntaSeObtieneLaEsperada(){
        //Arrange
        algoHoot3.iniciarAlgoHoot(jugadores, new Turno(),
                new MejorPuntaje(3,14),
                Lector.obtenerPreguntasDeJson(new MezclaNula(),("recursos/test.json")));


        //Act
        algoHoot3.pasarRonda();
        List<Ordenada> opcionesEsperadas=preguntaOrdenadaEsperada.obtenerOpciones();
        List<Ordenada> opciones= ((OrderedChoice) algoHoot3.obtenerPreguntaDeRondaActual()).obtenerOpciones();

        //Assert

        assertEquals(algoHoot3.obtenerPreguntaDeRondaActual().obtenerEnunciado(),preguntaOrdenadaEsperada.obtenerEnunciado());
        assertEquals(algoHoot3.obtenerPreguntaDeRondaActual().obtenerCategoria(), preguntaOrdenadaEsperada.obtenerCategoria());

        assertTrue(opciones.get(0).equals(opcionesEsperadas.get(0)));
        assertTrue(opciones.get(1).equals(opcionesEsperadas.get(1)));
        assertTrue(opciones.get(2).equals(opcionesEsperadas.get(2)));
        assertTrue(opciones.get(3).equals(opcionesEsperadas.get(3)));

    }
    @Test
    public void test04AlPasarRondaYSolicitarJugadorSeObtieneElPrimeroEnLaLista(){
        //Arrange
        algoHoot3.iniciarAlgoHoot(jugadores, new Turno(),
                new MejorPuntaje(3,14),
                Lector.obtenerPreguntasDeJson(new MezclaNula(),("recursos/test.json")));


        //Act
        algoHoot3.pasarRonda();

        //Assert

        assertTrue(algoHoot3.obtenerJugadorActual().equals(jugadores.get(0)));

    }

    @Test
    public void test14AlJugar14RondasYSolicitarLosJugadoresSegunCriterioSeObtienenLosEsperadosConLosPuntosEsperados(){

    }




    }