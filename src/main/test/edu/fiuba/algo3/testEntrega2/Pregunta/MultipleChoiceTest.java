package edu.fiuba.algo3.testEntrega2.Pregunta;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.Parcial;
import edu.fiuba.algo3.modelo.Respuestas.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.NuloPuntaje;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.opciones.opcion.Simple;

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
    private NuloPuntaje nulo;
    private List<ModificadorPuntaje> modificadores;

    @BeforeAll
    public static void setUpClass() {
        parcial = new Parcial();
    }

    @BeforeEach
    public void setUp() {
        nulo = new NuloPuntaje();
        modificadores = new ArrayList<>();
        modificadores.add(nulo);
        jugador1 = new Jugador("Jugador 1", modificadores);
        jugador2 = new Jugador("Jugador 2", modificadores);
        opcion1 = new Simple("Opcion 1", new Incorrecta());
        opcion2 = new Simple("Opcion 2", new Incorrecta());
        opcion3 = new Simple("Opcion 3", new Incorrecta());
        opcion1Correcta = new Simple("Opcion 1", new Correcta());
        opcion2Correcta = new Simple("Opcion 2", new Correcta());
        opcion3Incorrecta = new Simple("Opcion 3", new Incorrecta());
    }

    @Test
    public void test01Asigna2PuntosAUnJugadorQueRespondio2Correctas() {

        List<Opcion> opcionesPregunta = Arrays.asList(opcion1Correcta, opcion2Correcta, opcion3Incorrecta);

        Pregunta pregunta = new VerdaderoFalso(
            "¿Cuáles de las siguientes opciones son opcionesPregunta?",
                opcionesPregunta,       parcial, "Tema"
        );
        Respuesta correcta = jugador1.responder(Arrays.asList(opcion1, opcion2),opcionesPregunta, nulo);

        List<Respuesta> opciones = new ArrayList<>();
        opciones.add(correcta);

        pregunta.asignarPuntajes(opciones);

        assertEquals(2, jugador1.obtenerPuntaje());
    }

    @Test
    public void test02MultipleChoiceParcialAsignaPuntajeCorrectoAJugadorQueRespondioMal() {

        List<Opcion> opcionesPregunta = Arrays.asList(opcion1Correcta, opcion2Correcta, opcion3Incorrecta);

        Pregunta pregunta = new VerdaderoFalso(
                "¿Cuáles de las siguientes opciones son opcionesPregunta?",
                opcionesPregunta,       parcial, "Tema"
        );

        Respuesta incorrecta = jugador2.responder(Arrays.asList(opcion1, opcion3),opcionesPregunta, nulo);

        List<Respuesta> opciones = new ArrayList<>();
        opciones.add(incorrecta);

        pregunta.asignarPuntajes(opciones);

        assertEquals(0, jugador2.obtenerPuntaje());
    }
}
