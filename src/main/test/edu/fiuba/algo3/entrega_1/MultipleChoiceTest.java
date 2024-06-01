package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoicePenalizable;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaMultipleChoice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {
    @Test
    public void test01MultipleChoiceClasicoAsignaPuntajeCorrectoAJugadoresQueRespondieronCorrectamente() {
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        Respuesta respuesta1 = new RespuestaMultipleChoice(Arrays.asList("Opcion 1","Opcion 2"), jugador1);
        Respuesta respuesta2 = new RespuestaMultipleChoice(Arrays.asList("Opcion 1","Opcion 2"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new PreguntaMultipleChoiceClasico("¿Cuáles de las siguientes opciones son correctas?", Arrays.asList("Opcion 1","Opcion 2"));

        pregunta.validarRespuestas(respuestas);

        assertEquals(1, jugador1.obtenerPuntos());
        assertEquals(1, jugador2.obtenerPuntos());
    }

    @Test
    public void test02MultipleChoiceClasicoAsignaPuntajeCorrectoAJugadoresQueRespondieronIncorrectamente() {
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        Respuesta respuesta1 = new RespuestaMultipleChoice(Arrays.asList("Opcion 4","Opcion 2"), jugador1);
        Respuesta respuesta2 = new RespuestaMultipleChoice(Arrays.asList("Opcion 3","Opcion 1"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new PreguntaMultipleChoiceClasico("¿Cuáles de las siguientes opciones son correctas?", Arrays.asList("Opcion 1","Opcion 2"));

        pregunta.validarRespuestas(respuestas);

        assertEquals(0, jugador1.obtenerPuntos());
        assertEquals(0, jugador2.obtenerPuntos());
    }

    @Test
    public void test03MultipleChoicePenalizableAsignaPuntajeCorrectoAJugadoresQueRespondieronIncorrectamente() {
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        Respuesta respuesta1 = new RespuestaMultipleChoice(Arrays.asList("Opcion 1","Opcion 2"), jugador1);
        Respuesta respuesta2 = new RespuestaMultipleChoice(Arrays.asList("Opcion 1","Opcion 2"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new PreguntaMultipleChoicePenalizable("¿Cuáles de las siguientes opciones son correctas?", Arrays.asList("Opcion 1","Opcion 2"));

        pregunta.validarRespuestas(respuestas);

        assertEquals(1, jugador1.obtenerPuntos());
        assertEquals(1, jugador2.obtenerPuntos());
    }

    @Test
    public void test04MultipleChoicePenalizableAsignaPuntajeCorrectoAJugadoresQueRespondieronIncorrectamente() {
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        Respuesta respuesta1 = new RespuestaMultipleChoice(Arrays.asList("Opcion 4","Opcion 2"), jugador1);
        Respuesta respuesta2 = new RespuestaMultipleChoice(Arrays.asList("Opcion 3","Opcion 1"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new PreguntaMultipleChoicePenalizable("¿Cuáles de las siguientes opciones son correctas?", Arrays.asList("Opcion 1","Opcion 2"));

        pregunta.validarRespuestas(respuestas);

        assertEquals(-1, jugador1.obtenerPuntos());
        assertEquals(-1, jugador2.obtenerPuntos());
    }
}
