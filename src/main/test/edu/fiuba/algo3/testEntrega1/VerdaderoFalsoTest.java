package edu.fiuba.algo3.testEntrega1;

import edu.fiuba.algo3.modelo.pregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.estado.Correcta;
import edu.fiuba.algo3.modelo.estado.Incorrecta;
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
    private Opcion opcionCorrecta;
    private Opcion opcionIncorrecta;
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
        opcion1 = new Opcion("Verdadero", new Correcta());
        opcion2 = new Opcion("Falso", new Incorrecta());
        opcionCorrecta = new Opcion("Verdadero", new Correcta());
        opcionIncorrecta = new Opcion("Falso", new Incorrecta());
    }

    @Test
    public void test01VerdaderoFalsoClasicoAsignaPuntajeCorrectoAJugadores() {
        Respuesta respuesta1 = new Respuesta(List.of(opcion1), jugador1);
        Respuesta respuesta2 = new Respuesta(List.of(opcion2), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new MultipleChoice("¿Las palomas vuelan?", List.of(opcionCorrecta, opcionIncorrecta), clasica);

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

        Pregunta pregunta = new MultipleChoice("¿Las palomas vuelan?", List.of(opcionCorrecta, opcionIncorrecta), conPenalidad);

        pregunta.asignarPuntajes(respuestas);

        assertEquals(1, jugador1.obtenerPuntaje());
        assertEquals(-1, jugador2.obtenerPuntaje());
    }
}