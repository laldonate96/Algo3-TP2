package edu.fiuba.algo3.testEntrega2;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.estado.Correcta;
import edu.fiuba.algo3.modelo.estado.Incorrecta;
import edu.fiuba.algo3.modelo.grupo.Grupo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Group;
import edu.fiuba.algo3.modelo.opcion.Opcion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.pregunta.OrderedChoice;

public class GroupChoiceTest {
    private Jugador jugador1;
    private Jugador jugador2;
    private Opcion opcion1Jugador1;
    private Opcion opcion2Jugador1;
    private Opcion opcion3Jugador1;
    private Opcion opcion1Jugador2;
    private Opcion opcion2Jugador2;
    private Opcion opcion3Jugador2;
    private static Clasica clasica;
    private Opcion opcion1Correcta;
    private Opcion opcion2Correcta;
    private Opcion opcion3Correcta;
    private Grupo grupo1;
    private Grupo grupo2;
    private Grupo grupo3;

    @BeforeAll
    public static void setUpClass() {
        clasica = new Clasica();
    }

    @BeforeEach
    public void setUp() {
        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Jugador 2");

        grupo1 = new Grupo("Grupo 1");
        grupo2 = new Grupo("Grupo 2");
        grupo3 = new Grupo("Grupo 3");
        opcion1Jugador1 = new Group("Opcion 1", grupo1, new Incorrecta());
        opcion2Jugador1 = new Group("Opcion 2", grupo2, new Incorrecta());
        opcion3Jugador1 = new Group("Opcion 3", grupo3, new Incorrecta());
        opcion1Jugador2 = new Group("Opcion 3", grupo1, new Incorrecta());
        opcion2Jugador2 = new Group("Opcion 2", grupo2, new Incorrecta());
        opcion3Jugador2 = new Group("Opcion 1", grupo3, new Incorrecta());
        opcion1Correcta = new Group("Opcion 1", grupo3, new Correcta());
        opcion2Correcta = new Group("Opcion 2", grupo2, new Correcta());
        opcion3Correcta = new Group("Opcion 3", grupo1, new Correcta());
    }

    @Test
    public void test01OrderedChoiceAsignaPuntajeCorrectoAJugadores() {
        Respuesta respuesta1 = new Respuesta(Arrays.asList(opcion3Jugador1, opcion2Jugador1, opcion1Jugador1), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList(opcion3Jugador2, opcion2Jugador2, opcion1Jugador2), jugador2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        Pregunta pregunta = new OrderedChoice(
            "Ordenar las siguientes opciones",
            Arrays.asList(opcion1Correcta, opcion2Correcta, opcion3Correcta),
            clasica
        );

        pregunta.asignarPuntajes(respuestas);

        assertEquals(0, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());
    }
}
