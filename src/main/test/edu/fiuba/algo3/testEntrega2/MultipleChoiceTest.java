package edu.fiuba.algo3.testEntrega2;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.Parcial;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.estado.Correcta;
import edu.fiuba.algo3.modelo.estado.Incorrecta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;

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
    private Opcion opcion1;
    private Opcion opcion2;
    private Opcion opcion3;
    private static Parcial parcial;
    private Opcion opcion1Correcta;
    private Opcion opcion2Correcta;
    private Opcion opcion3Incorrecta;

    @BeforeAll
    public static void setUpClass() {
        parcial = new Parcial();
    }

    @BeforeEach
    public void setUp() {
        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Jugador 2");
        opcion1 = new Simple("Opcion 1", new Incorrecta());
        opcion2 = new Simple("Opcion 2", new Incorrecta());
        opcion3 = new Simple("Opcion 3", new Incorrecta());
        opcion1Correcta = new Simple("Opcion 1", new Correcta());
        opcion2Correcta = new Simple("Opcion 2", new Correcta());
        opcion3Incorrecta = new Simple("Opcion 3", new Incorrecta());
    }

    @Test
    public void test01MultipleChoiceParcialAsignaPuntajeCorrectoAJugadores() {
        Respuesta respuesta1 = new Respuesta(Arrays.asList(opcion1, opcion2), jugador1);
        Respuesta respuesta2 = new Respuesta(Arrays.asList(opcion1, opcion3), jugador2);

        List<Respuesta> opciones = new ArrayList<>();
        opciones.add(respuesta1);
        opciones.add(respuesta2);

        Pregunta pregunta = new VerdaderoFalso(
            "¿Cuáles de las siguientes opciones son correctas?",
            Arrays.asList(opcion1Correcta, opcion2Correcta, opcion3Incorrecta),
            parcial
        );

        pregunta.asignarPuntajes(opciones);

        assertEquals(2, jugador1.obtenerPuntaje());
        assertEquals(0, jugador2.obtenerPuntaje());
    }
}
