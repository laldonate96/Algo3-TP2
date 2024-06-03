package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Clasica;
import edu.fiuba.algo3.modelo.pregunta.ConPenalidad;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalso;
import edu.fiuba.algo3.modelo.pregunta.TipoPregunta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {
    private Jugador jugador1;
    private Jugador jugador2;

    @BeforeEach
    public void setUp() {
        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Jugador 2");
    }

    @Test
    public void test01VerdaderoFalsoClasicoAsignaPuntajeCorrectoAJugadoresQueRespondieronCorrectamente() {
        Respuesta respuesta1 = new Respuesta(Arrays.asList("Verdadero"), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Verdadero"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        TipoPregunta preguntaClasica = new Clasica();

        Pregunta pregunta = new PreguntaVerdaderoFalso("¿Las palomas vuelan?", Arrays.asList("Verdadero"), preguntaClasica);

        pregunta.validarRespuestas(respuestas);

        assertEquals(1, jugador1.obtenerPuntos());
        assertEquals(1, jugador2.obtenerPuntos());
    }

    @Test
    public void test02VerdaderoFalsoClasicoAsignaPuntajeCorrectoAJugadoresQueRespondieronIncorrectamente() {
        Respuesta respuesta1 = new Respuesta(Arrays.asList("Falso"), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Falso"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        TipoPregunta preguntaClasica = new Clasica();

        Pregunta pregunta = new PreguntaVerdaderoFalso("¿Las palomas vuelan?", Arrays.asList("Verdadero"), preguntaClasica);

        pregunta.validarRespuestas(respuestas);

        assertEquals(0, jugador1.obtenerPuntos());
        assertEquals(0, jugador2.obtenerPuntos());
    }

    @Test
    public void test03VerdaderoFalsoConPenalidadAsignaPuntajeCorrectoAJugadoresQueRespondieronCorrectamente() {
        Respuesta respuesta1 = new Respuesta(Arrays.asList("Verdadero"), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Verdadero"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        TipoPregunta preguntaConPenalidad = new ConPenalidad();

        Pregunta pregunta = new PreguntaVerdaderoFalso("¿Las palomas vuelan?", Arrays.asList("Verdadero"), preguntaConPenalidad);

        pregunta.validarRespuestas(respuestas);

        assertEquals(1, jugador1.obtenerPuntos());
        assertEquals(1, jugador2.obtenerPuntos());
    }

    @Test
    public void test04VerdaderoFalsoConPenalidadAsignaPuntajeCorrectoAJugadoresQueRespondieronIncorrectamente() {
        Respuesta respuesta1 = new Respuesta(Arrays.asList("Falso"), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Falso"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        TipoPregunta preguntaConPenalidad = new ConPenalidad();

        Pregunta pregunta = new PreguntaVerdaderoFalso("¿Las palomas vuelan?", Arrays.asList("Verdadero"), preguntaConPenalidad);

        pregunta.validarRespuestas(respuestas);

        assertEquals(-1, jugador1.obtenerPuntos());
        assertEquals(-1, jugador2.obtenerPuntos());
    }
}
