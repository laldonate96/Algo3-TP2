package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.pregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.distribuidoraDePuntaje.Clasica;
import edu.fiuba.algo3.modelo.distribuidoraDePuntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {
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
    public void test01MultipleChoiceClasicoAsignaPuntajeCorrectoAJugadoresQueRespondieronCorrectamente() {
        Respuesta respuesta1 = new Respuesta(Arrays.asList("Opcion 1","Opcion 2"), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Opcion 1","Opcion 2"), jugador2);

        List<Respuesta> opciones = new ArrayList<>();
        opciones.add(respuesta1);
        opciones.add(respuesta2);

        Pregunta pregunta = new MultipleChoice(
            "¿Cuáles de las siguientes opciones son correctas?",
                Arrays.asList("Opcion 1","Opcion 2"), clasica, Arrays.asList("Opcion 1","Opcion 2", "Opcion 3")
        );

        pregunta.asignarPuntajes(opciones);

        assertEquals(1, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test02MultipleChoiceClasicoAsignaPuntajeCorrectoAJugadoresQueRespondieronIncorrectamente() {
        Respuesta respuesta1 = new Respuesta(Arrays.asList("Opcion 3","Opcion 2"), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Opcion 3","Opcion 1"), jugador2);

        List<Respuesta> opciones = new ArrayList<>();
        opciones.add(respuesta1);
        opciones.add(respuesta2);

        Pregunta pregunta = new MultipleChoice(
            "¿Cuáles de las siguientes opciones son correctas?",
                Arrays.asList("Opcion 1","Opcion 2"), clasica, Arrays.asList("Opcion 1","Opcion 2", "Opcion 3")
        );

        pregunta.asignarPuntajes(opciones);

        assertEquals(0, jugador1.obtenerPuntaje());
        assertEquals(0, jugador2.obtenerPuntaje());
    }

    @Test
    public void test03MultipleChoiceConPenalidadAsignaPuntajeCorrectoAJugadoresQueRespondieronCorrectamente() {
        Respuesta respuesta1 = new Respuesta(Arrays.asList("Opcion 1","Opcion 2"), jugador1);
        Respuesta respuesta2 = new Respuesta(List.of("Opcion 1"), jugador2);

        List<Respuesta> opciones = new ArrayList<>();
        opciones.add(respuesta1);
        opciones.add(respuesta2);

        Pregunta pregunta = new MultipleChoice(
            "¿Cuáles de las siguientes opciones son correctas?",
                Arrays.asList("Opcion 1","Opcion 2"), conPenalidad, Arrays.asList("Opcion 1","Opcion 2", "Opcion 3")
        );

        pregunta.asignarPuntajes(opciones);

        assertEquals(2, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test04MultipleChoiceConPenalidadAsignaPuntajeCorrectoAJugadoresQueRespondieronIncorrectamente() {
        Respuesta respuesta1 = new Respuesta(Arrays.asList("Opcion 3","Opcion 4"), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList("Opcion 3","Opcion 4"), jugador2);

        List<Respuesta> opciones = new ArrayList<>();
        opciones.add(respuesta1);
        opciones.add(respuesta2);

        Pregunta pregunta = new MultipleChoice(
            "¿Cuáles de las siguientes opciones son correctas?",
                Arrays.asList("Opcion 1","Opcion 2"), conPenalidad, Arrays.asList("Opcion 1","Opcion 2", "Opcion 3", "Opcion 4", "Opcion 5")
        );

        pregunta.asignarPuntajes(opciones);

        assertEquals(-2, jugador1.obtenerPuntaje());
        assertEquals(-2, jugador2.obtenerPuntaje());
    }
}
