package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.estado.Correcta;
import edu.fiuba.algo3.modelo.estado.Estado;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;

import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {
    private Jugador jugador1;
    private Jugador jugador2;
    private Opcion opcion1;
    private Opcion opcion2;
    private Estado correcta;
    private Opcion opcionCorrecta;
    private static Clasica clasica;
    private static ConPenalidad conPenalidad;

    @BeforeAll
    public static void setUpClass() {
        clasica = new Clasica();
        conPenalidad = new ConPenalidad();
    }

    @BeforeEach
    public void setUp() {
        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Jugador 2");
        opcion1 = new Opcion("Verdadero");
        opcion2 = new Opcion("Falso");
        correcta = new Correcta();
        opcionCorrecta = new Opcion("Verdadero", correcta);
    }

    @Test
    public void test01VerdaderoFalsoClasicoAsignaPuntajeCorrectoAJugadoresQueRespondieronCorrectamente() {
        Respuesta respuesta1 = new Respuesta(List.of(opcion1), jugador1);
        Respuesta respuesta2 = new Respuesta(List.of(opcion2), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new Pregunta("¿Las palomas vuelan?", List.of(opcion1, opcion2), List.of(opcionCorrecta), clasica);

        pregunta.asignarPuntajes(respuestas);

        assertEquals(1, jugador1.obtenerPuntaje());
        assertEquals(0, jugador2.obtenerPuntaje());
    }

    @Test
    public void test02VerdaderoFalsoConPenalidadAsignaPuntajeCorrectoAJugadores() {
        Respuesta respuesta1 = new Respuesta(List.of(opcion1), jugador1);
        Respuesta respuesta2 = new Respuesta(List.of(opcion2), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new Pregunta("¿Las palomas vuelan?", List.of(opcion1, opcion2), List.of(opcionCorrecta), conPenalidad);

        pregunta.asignarPuntajes(respuestas);

        assertEquals(1, jugador1.obtenerPuntaje());
        assertEquals(-1, jugador2.obtenerPuntaje());
    }
}
