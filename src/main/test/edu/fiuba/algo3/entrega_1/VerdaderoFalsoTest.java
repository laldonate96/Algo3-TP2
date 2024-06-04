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
        TipoPregunta preguntaClasica = new Clasica();
        Respuesta respuesta1 = new Respuesta(Arrays.asList("Verdadero"), jugador1, preguntaClasica);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Verdadero"), jugador2, preguntaClasica);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        

        Pregunta pregunta = new PreguntaVerdaderoFalso("¿Las palomas vuelan?", Arrays.asList("Verdadero"));

        pregunta.validarRespuestas(respuestas);

        assertEquals(1, jugador1.obtenerPuntos());
        assertEquals(1, jugador2.obtenerPuntos());
    }

    @Test
    public void test02VerdaderoFalsoClasicoAsignaPuntajeCorrectoAJugadoresQueRespondieronIncorrectamente() {
        TipoPregunta preguntaClasica = new Clasica();
        Respuesta respuesta1 = new Respuesta(Arrays.asList("Falso"), jugador1, preguntaClasica);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Falso"), jugador2, preguntaClasica);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new PreguntaVerdaderoFalso("¿Las palomas vuelan?", Arrays.asList("Verdadero"));

        pregunta.validarRespuestas(respuestas);

        assertEquals(0, jugador1.obtenerPuntos());
        assertEquals(0, jugador2.obtenerPuntos());
    }

    @Test
    public void test03VerdaderoFalsoConPenalidadAsignaPuntajeCorrectoAJugadoresQueRespondieronCorrectamente() {
        TipoPregunta preguntaConPenalidad = new ConPenalidad();
        Respuesta respuesta1 = new Respuesta(Arrays.asList("Verdadero"), jugador1, preguntaConPenalidad);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Verdadero"), jugador2, preguntaConPenalidad);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new PreguntaVerdaderoFalso("¿Las palomas vuelan?", Arrays.asList("Verdadero"));

        pregunta.validarRespuestas(respuestas);

        assertEquals(1, jugador1.obtenerPuntos());
        assertEquals(1, jugador2.obtenerPuntos());
    }

    @Test
    public void test04VerdaderoFalsoConPenalidadAsignaPuntajeCorrectoAJugadoresQueRespondieronIncorrectamente() {
        TipoPregunta preguntaConPenalidad = new ConPenalidad();
        Respuesta respuesta1 = new Respuesta(Arrays.asList("Falso"), jugador1, preguntaConPenalidad);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Falso"), jugador2, preguntaConPenalidad);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new PreguntaVerdaderoFalso("¿Las palomas vuelan?", Arrays.asList("Verdadero"));

        pregunta.validarRespuestas(respuestas);

        assertEquals(-1, jugador1.obtenerPuntos());
        assertEquals(-1, jugador2.obtenerPuntos());
    }
}
