package edu.fiuba.algo3.testEntrega2.ModificadorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Multiplicador;
import edu.fiuba.algo3.modelo.modificador.Nulo;

public class MultiplicadorTest {
    private Jugador jugador1;
    private Opcion opcion1;
    private Opcion opcion2;
    private static ConPenalidad conPenalidad;
    private Modificador nulo;
    List<Modificador> modificadores = new ArrayList<>();

    @BeforeAll
    public static void setUpClass() {
        conPenalidad = new ConPenalidad();
    }

    @BeforeEach
    public void setUp() {
        nulo = new Nulo();
        Multiplicador multiplicador1 = new Multiplicador(2);
        Multiplicador multiplicador2 = new Multiplicador(3);

        modificadores.add(nulo);

        List<Modificador> modificadores = new ArrayList<>();
        modificadores.add(multiplicador1);
        modificadores.add(multiplicador2);

        jugador1 = new Jugador("Jugador 1", modificadores);

        opcion1 = new Simple("Verdadero", new Correcta());
        opcion2 = new Simple("Falso", new Incorrecta());
    }

    @Test
    public void test01unJugadorUtilizaUnMultiplicadorEnUnaPreguntaVerdaderosOFalsoYAcierto(){
        //arrange
        List<Opcion> opcionesPregunta = Arrays.asList(opcion1, opcion2);
        Pregunta pregunta = new VerdaderoFalso(
                "¿Cuáles de las siguientes opciones son correctas?",
                opcionesPregunta,
                conPenalidad
        );

        Multiplicador multiplicador1 = new Multiplicador(2);
        Respuesta respuesta = jugador1.responder(List.of(opcion1),opcionesPregunta, multiplicador1);
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);

        //act
        pregunta.asignarPuntajes(respuestas);

        //assert
        assertEquals(2, jugador1.obtenerPuntaje());
    }

    @Test
    public void test02unJugadorUtilizaUnMultiplicadorEnUnaPreguntaVerdaderosOFalsoYFalla(){
        //arrange

        List<Opcion> opcionesPregunta = Arrays.asList(opcion1, opcion2);
        Pregunta pregunta = new VerdaderoFalso(
                "¿Cuáles de las siguientes opciones son correctas?",
                opcionesPregunta,
                conPenalidad
        );

        Multiplicador multiplicador1 = new Multiplicador(2);
        Respuesta respuesta = jugador1.responder(List.of(opcion2),opcionesPregunta, multiplicador1);
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);

        //act
        pregunta.asignarPuntajes(respuestas);

        //assert
        assertEquals(-2, jugador1.obtenerPuntaje());
    }
}