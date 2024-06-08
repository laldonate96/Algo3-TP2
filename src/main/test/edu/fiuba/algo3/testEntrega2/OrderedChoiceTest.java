package edu.fiuba.algo3.testEntrega2;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.estado.Correcta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordered;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.pregunta.OrderedChoice;

public class OrderedChoiceTest {
    private Jugador jugador1;
    private Opcion opcion1;
    private Opcion opcion2;
    private Opcion opcion3;
    private static Clasica clasica;
    private Opcion opcion1Incorrecta;
    private Opcion opcion2Incorrecta;
    private Opcion opcion3Incorrecta;

    @BeforeAll
    public static void setUpClass() {
        clasica = new Clasica();
    }

    @BeforeEach
    public void setUp() {
        jugador1 = new Jugador("Jugador 1");

        
        opcion1Incorrecta = new Ordered("Opcion 1",1);
        opcion2Incorrecta = new Ordered("Opcion 2",2);
        opcion3Incorrecta = new Ordered("Opcion 3",3);
        opcion1 = new Ordered("Opcion 3", 1, new Correcta());
        opcion2 = new Ordered("Opcion 2", 2, new Correcta());
        opcion3 = new Ordered("Opcion 1", 3, new Correcta());
    }

    @Test
    public void test01OrderedChoiceClasicoAsignaPuntajeCorrectoAJugadores() {
        Respuesta respuesta1 = new Respuesta(Arrays.asList(opcion1Incorrecta, opcion2Incorrecta, opcion3Incorrecta), jugador1);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);

        Pregunta pregunta = new OrderedChoice(
            "Ordenar las siguientes opciones",
            Arrays.asList(opcion1, opcion2, opcion3),
            clasica
        );

        pregunta.asignarPuntajes(respuestas);

        assertEquals(0, jugador1.obtenerPuntaje());
    }
}
