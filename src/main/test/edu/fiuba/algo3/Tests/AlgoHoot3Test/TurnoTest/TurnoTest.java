package edu.fiuba.algo3.Tests.AlgoHoot3Test.TurnoTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaNula;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;

import edu.fiuba.algo3.modelo.turno.Turno;

public class TurnoTest {


    private static List<Pregunta> preguntasTest;
    private Pregunta verdaderoOFalso;
    private Pregunta verdaderoOFalsoPenalidad;


    private Jugador jugador1;
    private Jugador jugador2;
    private Turno turno;
    private Pregunta multipleChoicePenalidad;
    private Pregunta orderedChoice;
    private Pregunta groupChoice;
    private Pregunta multipleChoiceSimple;
    private Pregunta multipleChoiceParcial;


    @BeforeAll
    public static void setupClass() {
        preguntasTest = Lector.obtenerPreguntasDeJson(new MezclaNula(), "recursos/test.json");
    }

    @BeforeEach
    public void setUp() {
        orderedChoice=preguntasTest.get(0);
        verdaderoOFalso = preguntasTest.get(1);
        groupChoice=preguntasTest.get(2);
        multipleChoiceParcial=preguntasTest.get(3);
        multipleChoiceSimple = preguntasTest.get(4);
        verdaderoOFalsoPenalidad = preguntasTest.get(5);
        multipleChoicePenalidad=preguntasTest.get(6);

        jugador1 = new Jugador("Contigo", FabricaModificadores.crearListaModificadores());
        jugador2 = new Jugador("Pipo", FabricaModificadores.crearListaModificadores());

        turno = new Turno();

    }

    @Test
    public void test01seJuegaUnTurnoConUnaPreguntaVoFClasicaYSeLesPidePuntos() {
        //arrange
        List<String> contenidoOpciones1 = List.of("Verdadero");
        List<String> posicion1 = List.of("1");
        List<Opcion> opcionesJugador1 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Incorrecta()));

        List<String> contenidoOpciones2 = List.of("Falso");
        List<String> posicion2 = List.of();
        List<Opcion> opcionesJugador2 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));


        Modificador nuloJugador1 = jugador1.obtenerModificadores().get(0);
        Modificador nuloJugador2 = jugador2.obtenerModificadores().get(0);

        turno.reiniciarTurno(verdaderoOFalso);
        turno.agregarRespuesta(opcionesJugador1, jugador1, nuloJugador1);
        turno.agregarRespuesta(opcionesJugador2, jugador2, nuloJugador2);


        //act

        turno.asignarPuntajes();

        // assert

        assertEquals(0, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test02seJuegaUnTurnoConUnaPreguntaVoFPenalizadaYseLespidePuntos() {
        //arrange


        List<String> contenidoOpciones1 = List.of("Verdadero");
        List<String> posicion1 = List.of("1");
        List<Opcion> opcionesJugador1 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Correcta()));

        List<String> contenidoOpciones2 = List.of("Falso");
        List<String> posicion2 = List.of();
        List<Opcion> opcionesJugador2 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));

        turno.reiniciarTurno(verdaderoOFalsoPenalidad);

        Modificador nuloJugador1 = jugador1.obtenerModificadores().get(0);
        Modificador nuloJugador2 = jugador2.obtenerModificadores().get(0);

        turno.agregarRespuesta(opcionesJugador1, jugador1, nuloJugador1);
        turno.agregarRespuesta(opcionesJugador2, jugador2, nuloJugador2);

        //act
        turno.asignarPuntajes();

        // assert

        assertEquals(-1, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test03UsandoUnaMultipleChoicePenalidadYUnMultiplicadorYLosJugadoresObtienenLosPuntosEsperados() {
        //arrange


        List<String> contenidoOpciones1 = List.of("Verdadero");
        List<String> posicion1 = List.of("1");
        List<Opcion> opcionesJugador1 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Correcta()));

        List<String> contenidoOpciones2 = List.of("Falso");
        List<String> posicion2 = List.of();
        List<Opcion> opcionesJugador2 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));


        turno.reiniciarTurno(verdaderoOFalsoPenalidad);


        Modificador multiplicador = jugador1.obtenerModificadores().get(1);
        Modificador nuloJugador2 = jugador2.obtenerModificadores().get(0);

        turno.agregarRespuesta(opcionesJugador1, jugador1, multiplicador);
        turno.agregarRespuesta(opcionesJugador2, jugador2, nuloJugador2);

        //act
        turno.asignarPuntajes();

        // assert
        assertEquals(-2, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test04seJuegaUnTurnoConUnaPreguntaVoFClasicaConAnuladorYseLespidePuntos() {
        //arrange


        List<String> contenidoOpciones1 = List.of("Falso");
        List<String> posicion1 = List.of("1");
        List<Opcion> opcionesJugador1 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Correcta()));

        List<String> contenidoOpciones2 = List.of("Falso");
        List<String> posicion2 = List.of();
        List<Opcion> opcionesJugador2 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));


        turno.reiniciarTurno(verdaderoOFalso);


        Modificador nuloJugador1 = jugador1.obtenerModificadores().get(0);
        Modificador anulador = jugador2.obtenerModificadores().get(5);

        turno.agregarRespuesta(opcionesJugador1, jugador1, nuloJugador1);
        turno.agregarRespuesta(opcionesJugador2, jugador2, anulador);

        //act
        turno.asignarPuntajes();

        // assert

        assertEquals(0, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());


    }


    @Test
    public void test05AgregarRespuestasConNuloAsignarlasReiniciarYVolverAAgregarlasAsignaLosPuntosEsperados() {
        //arrange
        List<String> contenidoOpciones1 = List.of("Verdadero");
        List<String> posicion1 = List.of("1");
        List<Opcion> opcionesJugador1 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Correcta()));

        List<String> contenidoOpciones2 = List.of("Falso");
        List<String> posicion2 = List.of();
        List<Opcion> opcionesJugador2 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));

        turno.reiniciarTurno(verdaderoOFalsoPenalidad);

        Modificador nuloJugador = jugador1.obtenerModificadores().get(0);
        Modificador multiplicador = jugador2.obtenerModificadores().get(0);

        turno.agregarRespuesta(opcionesJugador2, jugador2, multiplicador);
        turno.agregarRespuesta(opcionesJugador1, jugador1, nuloJugador);

        turno.asignarPuntajes();
        jugador2.obtenerPuntaje();


        opcionesJugador1 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Incorrecta()));
        opcionesJugador2 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));

        turno.reiniciarTurno(verdaderoOFalsoPenalidad);

        turno.agregarRespuesta(opcionesJugador2, jugador2, multiplicador);
        turno.agregarRespuesta(opcionesJugador1, jugador1, nuloJugador);

        //act
        turno.asignarPuntajes();
        jugador2.obtenerPuntaje();

        // assert
        assertEquals(-2, jugador1.obtenerPuntaje());
        assertEquals(2, jugador2.obtenerPuntaje());
    }


    @Test
    public void test06AgregarRespuestasMultiplicadorYAnuladorAsignarlasReiniciarYVolverAAgregarlasAsignaLosPuntosEsperados() {
        //arrange

        List<String> contenidoOpciones1 = List.of("Verdadero");
        List<String> posicion1 = List.of("1");
        List<Opcion> opcionesJugador1 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Correcta()));

        List<String> contenidoOpciones2 = List.of("Falso");
        List<String> posicion2 = List.of();
        List<Opcion> opcionesJugador2 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));


        turno.reiniciarTurno(verdaderoOFalsoPenalidad);


        Modificador nuloJugador = jugador1.obtenerModificadores().get(0);
        Modificador multiplicador = jugador2.obtenerModificadores().get(1);

        turno.agregarRespuesta(opcionesJugador2, jugador2, multiplicador);
        turno.agregarRespuesta(opcionesJugador1, jugador1, nuloJugador);


        turno.asignarPuntajes();
        jugador2.obtenerPuntaje();


        opcionesJugador1 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Incorrecta()));
        opcionesJugador2 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));


        turno.reiniciarTurno(verdaderoOFalsoPenalidad);


        multiplicador = jugador2.obtenerModificadores().get(1);

        turno.agregarRespuesta(opcionesJugador2, jugador2, multiplicador);
        turno.agregarRespuesta(opcionesJugador1, jugador1, nuloJugador);

        //act
        turno.asignarPuntajes();


        jugador2.obtenerPuntaje();
        // assert
        assertEquals(-2, jugador1.obtenerPuntaje());
        assertEquals(5, jugador2.obtenerPuntaje());
    }
}

