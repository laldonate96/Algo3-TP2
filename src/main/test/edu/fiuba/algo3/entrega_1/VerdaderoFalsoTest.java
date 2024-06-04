package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Clasica;
import edu.fiuba.algo3.modelo.pregunta.ConPenalidad;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoOFalso;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {
    private Jugador jugador1;
    private Jugador jugador2;
    private static Clasica clasica;
    private static ConPenalidad conPenalidad;

    @BeforeAll
    public static void setUpClass() {
        clasica=new Clasica();
        conPenalidad=new ConPenalidad();
    }

    @BeforeEach
    public void setUp() {
        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Jugador 2");
    }

    @Test
    public void test01VerdaderoFalsoClasicoAsignaPuntajeCorrectoAJugadoresQueRespondieronCorrectamente() {
        Respuesta respuesta1 = new Respuesta(List.of("Verdadero"), jugador1);
        Respuesta respuesta2 = new Respuesta(List.of("Verdadero"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new VerdaderoOFalso("¿Las palomas vuelan?", List.of("Verdadero"), clasica);

        pregunta.asignarPuntajes(respuestas);

        assertEquals(1, jugador1.obtenerPuntos());
        assertEquals(1, jugador2.obtenerPuntos());
    }

    @Test
    public void test02VerdaderoFalsoClasicoAsignaPuntajeCorrectoAJugadoresQueRespondieronIncorrectamente() {
        Respuesta respuesta1 = new Respuesta(List.of("Falso"), jugador1);
        Respuesta respuesta2 = new Respuesta(List.of("Falso"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new VerdaderoOFalso("¿Las palomas vuelan?", List.of("Verdadero"),clasica );

        pregunta.asignarPuntajes(respuestas);

        assertEquals(0, jugador1.obtenerPuntos());
        assertEquals(0, jugador2.obtenerPuntos());
    }

    @Test
    public void test03VerdaderoFalsoConPenalidadAsignaPuntajeCorrectoAJugadoresQueRespondieronCorrectamente() {
        Respuesta respuesta1 = new Respuesta(List.of("Verdadero"), jugador1);
        Respuesta respuesta2 = new Respuesta(List.of("Verdadero"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new VerdaderoOFalso("¿Las palomas vuelan?", List.of("Verdadero"), conPenalidad);

        pregunta.asignarPuntajes(respuestas);

        assertEquals(1, jugador1.obtenerPuntos());
        assertEquals(1, jugador2.obtenerPuntos());
    }

    @Test
    public void test04VerdaderoFalsoConPenalidadAsignaPuntajeCorrectoAJugadoresQueRespondieronIncorrectamente() {
        Respuesta respuesta1 = new Respuesta(List.of("Falso"), jugador1);
        Respuesta respuesta2 = new Respuesta(List.of("Falso"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new VerdaderoOFalso("¿Las palomas vuelan?", List.of("Verdadero"), conPenalidad);

        pregunta.asignarPuntajes(respuestas);

        assertEquals(-1, jugador1.obtenerPuntos());
        assertEquals(-1, jugador2.obtenerPuntos());
    }
}
