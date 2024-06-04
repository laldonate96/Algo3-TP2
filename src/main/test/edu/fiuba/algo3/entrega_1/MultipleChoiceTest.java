package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.pregunta.Clasica;
import edu.fiuba.algo3.modelo.pregunta.ConPenalidad;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoice;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {
    private Jugador jugador1;
    private Jugador jugador2;

    @BeforeEach
    public void setUp() {
        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Jugador 2");
    }

    @Test
    public void test01MultipleChoiceClasicoAsignaPuntajeCorrectoAJugadoresQueRespondieronCorrectamente() {
        Respuesta respuesta1 = new Respuesta(Arrays.asList("Opcion 1","Opcion 2"), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Opcion 1","Opcion 2"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new PreguntaMultipleChoice(
            "¿Cuáles de las siguientes opciones son correctas?", 
            Arrays.asList("Opcion 1","Opcion 2", "Opcion 3"), 
            Arrays.asList("Opcion 1","Opcion 2"),
            new Clasica()
        );

        pregunta.validarRespuestas(respuestas);

        assertEquals(2, jugador1.obtenerPuntos());
        assertEquals(2, jugador2.obtenerPuntos());
    }

    @Test
    public void test02MultipleChoiceClasicoAsignaPuntajeCorrectoAJugadoresQueRespondieronIncorrectamente() {
        Respuesta respuesta1 = new Respuesta(Arrays.asList("Opcion 3","Opcion 2"), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Opcion 3","Opcion 1"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new PreguntaMultipleChoice(
            "¿Cuáles de las siguientes opciones son correctas?", 
            Arrays.asList("Opcion 1","Opcion 2", "Opcion 3"), 
            Arrays.asList("Opcion 1","Opcion 2"),
            new Clasica()
        );

        pregunta.validarRespuestas(respuestas);

        assertEquals(0, jugador1.obtenerPuntos());
        assertEquals(0, jugador2.obtenerPuntos());
    }

    @Test
    public void test03MultipleChoiceConPenalidadAsignaPuntajeCorrectoAJugadoresQueRespondieronCorrectamente() {
        Respuesta respuesta1 = new Respuesta(Arrays.asList("Opcion 1","Opcion 2"), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Opcion 1","Opcion 2"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new PreguntaMultipleChoice(
            "¿Cuáles de las siguientes opciones son correctas?", 
            Arrays.asList("Opcion 1","Opcion 2", "Opcion 3"), 
            Arrays.asList("Opcion 1","Opcion 2"),
            new ConPenalidad()
        );

        pregunta.validarRespuestas(respuestas);

        assertEquals(2, jugador1.obtenerPuntos());
        assertEquals(2, jugador2.obtenerPuntos());
    }

    @Test
    public void test04MultipleChoiceConPenalidadAsignaPuntajeCorrectoAJugadoresQueRespondieronIncorrectamente() {
        Respuesta respuesta1 = new Respuesta(Arrays.asList("Opcion 3","Opcion 4"), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Opcion 3","Opcion 4"), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new PreguntaMultipleChoice(
            "¿Cuáles de las siguientes opciones son correctas?", 
            Arrays.asList("Opcion 1","Opcion 2", "Opcion 3", "Opcion 4"), 
            Arrays.asList("Opcion 1","Opcion 2"),
            new ConPenalidad()
        );

        pregunta.validarRespuestas(respuestas);

        assertEquals(-2, jugador1.obtenerPuntos());
        assertEquals(-2, jugador2.obtenerPuntos());
    }
}
