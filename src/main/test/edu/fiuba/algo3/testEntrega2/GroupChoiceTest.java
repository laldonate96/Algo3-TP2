package edu.fiuba.algo3.testEntrega2;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.estado.Correcta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
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
    private Opcion opcion1;
    private Opcion opcion2;
    private Opcion opcion3;
    private static Clasica clasica;
    private Opcion opcion1Incorrecta;
    private Opcion opcion2Incorrecta;

    @BeforeAll
    public static void setUpClass() {
        clasica = new Clasica();
    }

    @BeforeEach
    public void setUp() {
        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Jugador 2");

        
        opcion1Incorrecta = new Opcion("Opcion 1","Personas");
        opcion2Incorrecta = new Opcion("Opcion 2","Animales");
        grupoOpcion= new Opcion("Grupo", list<string>(perro, gato, paloma, africa), new Correcta())
        opcion3 = new Opcion("Opcion 3");
    }

    @Test
    public void test01OrderedChoiceClasicoAsignaPuntajeCorrectoAJugadores() {
        Respuesta respuesta1 = new Respuesta(Arrays.asList(opcion1Incorrecta, opcion2Incorrecta), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList(opcion1Incorrecta, opcion2Incorrecta), jugador2);

        List<Respuesta> opciones = new ArrayList<>();
        opciones.add(respuesta1);
        opciones.add(respuesta2);

        Pregunta pregunta = new OrderedChoice(
            "¿Cuáles de las siguientes opciones son correctas?",
            Arrays.asList(opcion1, opcion2, opcion3),
                clasica
        );

        pregunta.asignarPuntajes(opciones);

        assertEquals(1, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test02MultipleChoiceConPenalidadAsignaPuntajeCorrectoAJugadores() {
        Respuesta respuesta1 = new Respuesta(Arrays.asList(opcion1Incorrecta, opcion2Incorrecta), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList(opcion3), jugador2);

        List<Respuesta> opciones = new ArrayList<>();
        opciones.add(respuesta1);
        opciones.add(respuesta2);

        Pregunta pregunta = new VerdaderoFalso(
            "¿Cuáles de las siguientes opciones son correctas?",
            Arrays.asList(opcion1, opcion2, opcion3),
                conPenalidad
        );

        pregunta.asignarPuntajes(opciones);

        assertEquals(2, jugador1.obtenerPuntaje());
        assertEquals(-1, jugador2.obtenerPuntaje());
    }
}
