package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoPenalizable;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {
    @Test
    public void test01VerdaderoFalsoClasicoAsignaPuntajeCorrectoAJugadoresQueRespondieronCorrectamente() {
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        Respuesta respuesta1 = new Respuesta(Arrays.asList("Verdadero"), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Verdadero"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿Las palomas vuelan?", Arrays.asList("Verdadero"));

        pregunta.validarRespuestas(respuestas);

        assertEquals(1, jugador1.obtenerPuntos());
        assertEquals(1, jugador2.obtenerPuntos());
    }

    @Test
    public void test02VerdaderoFalsoClasicoAsignaPuntajeCorrectoAJugadoresQueRespondieronIncorrectamente() {
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        Respuesta respuesta1 = new Respuesta(Arrays.asList("Falso"), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Falso"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico("¿Las palomas vuelan?", Arrays.asList("Verdadero"));

        pregunta.validarRespuestas(respuestas);

        assertEquals(0, jugador1.obtenerPuntos());
        assertEquals(0, jugador2.obtenerPuntos());
    }

    @Test
    public void test03VerdaderoFalsoPenalizableAsignaPuntajeCorrectoAJugadoresQueRespondieronCorrectamente() {
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        Respuesta respuesta1 = new Respuesta(Arrays.asList("Verdadero"), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Verdadero"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        PreguntaVerdaderoFalsoPenalizable pregunta = new PreguntaVerdaderoFalsoPenalizable("¿Las palomas vuelan?", Arrays.asList("Verdadero"));

        pregunta.validarRespuestas(respuestas);

        assertEquals(1, jugador1.obtenerPuntos());
        assertEquals(1, jugador2.obtenerPuntos());
    }

    @Test
    public void test04VerdaderoFalsoPenalizableAsignaPuntajeCorrectoAJugadoresQueRespondieronIncorrectamente() {
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        Respuesta respuesta1 = new Respuesta(Arrays.asList("Falso"), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Falso"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        PreguntaVerdaderoFalsoPenalizable pregunta = new PreguntaVerdaderoFalsoPenalizable("¿Las palomas vuelan?", Arrays.asList("Verdadero"));

        pregunta.validarRespuestas(respuestas);

        assertEquals(-1, jugador1.obtenerPuntos());
        assertEquals(-1, jugador2.obtenerPuntos());
    }
}
