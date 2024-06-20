package edu.fiuba.algo3.testEntrega2.Pregunta;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;


import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.Parcial;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {
    private Jugador jugador1;

    private static Parcial parcial;
    private ModificadorPuntaje nulo;
    private List<Opcion> opciones;
    private List<Respuesta> respuestas;

    @BeforeAll
    public static void setUpClass() {
        parcial = new Parcial();
    }

    @BeforeEach
    public void setUp() {
        List<ModificadorPuntaje> modificadores= FabricaModificadores.obtenerListaModificadoresPuntaje();

        nulo = modificadores.get(0);

        jugador1 = new Jugador("Jugador 1", modificadores);
        jugador2 = new Jugador("Jugador 2", modificadores);

        List<String> opcionesTexto= List.of("Opcion 1", "Opcion 2", "Opcion 3");
        List<String> posicionesCorrectas= List.of("1", "2");

        respuestas=new ArrayList<>();
        opciones= FabricaOpciones.crearListaSimple(opcionesTexto,posicionesCorrectas);

    }

    @Test
    public void test01Asigna2PuntosAUnJugadorQueRespondio2Correctas() {


        Pregunta pregunta = new VerdaderoFalso(
            "¿Cuáles de las siguientes opciones son opcionesPregunta?",
                opciones,       parcial, "Tema"
        );

        List<Opcion> opcionesJugador=FabricaOpciones.crearListaSimple(List.of("Opcion 1", "Opcion 2"),List.of("1", "2"));
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1, nulo);
        respuestas.add(respuesta);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(2, jugador1.obtenerPuntaje());
    }

    @Test
    public void test02Asigna0PuntosAJugadorQueRespondioMal() {


        Pregunta pregunta = new VerdaderoFalso(
                "¿Cuáles de las siguientes opciones son opcionesPregunta?",
                opciones,       parcial, "Tema"
        );

        List<Opcion> opcionesJugador=FabricaOpciones.crearListaSimple(List.of("Opcion 1", "Opcion 3"),List.of("1"));
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1, nulo);
        respuestas.add(respuesta);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, jugador1.obtenerPuntaje());

    }
}
