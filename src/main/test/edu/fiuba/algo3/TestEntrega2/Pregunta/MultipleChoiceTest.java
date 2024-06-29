package edu.fiuba.algo3.TestEntrega2.Pregunta;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;


import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.pregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Parcial;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {
    private Jugador jugador1;

    private static Parcial parcial;
    private Modificador nulo;
    private List<Opcion> opciones;
    private List<Respuesta> respuestas;

    @BeforeAll
    public static void setUpClass() {
        parcial = new Parcial();
    }

    @BeforeEach
    public void setUp() {
        List<Modificador> modificadores= FabricaModificadores.crearListaModificadores();

        nulo = modificadores.get(0);

        jugador1 = new Jugador("Jugador 1", modificadores);

        List<String> opcionesTexto= List.of("Opcion 1", "Opcion 2", "Opcion 3");
        List<String> posicionesCorrectas= List.of("1", "2");

        respuestas=new ArrayList<>();
        opciones= FabricaOpciones.crearListaSimple(opcionesTexto,posicionesCorrectas, new Correcta());

    }

    @Test
    public void test01Asigna2PuntosAUnJugadorQueRespondio2Correctas() {


        Pregunta pregunta = new MultipleChoice(
            "¿Cuáles de las siguientes opciones son opcionesPregunta?",
                opciones,       parcial, "Tema"
        );


        List<Opcion> opcionesJugador=FabricaOpciones.crearListaSimple(List.of("Opcion 1", "Opcion 2"),List.of("1", "2"), new Correcta());
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1);
        respuestas.add(respuesta);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(2, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02Asigna0PuntosAJugadorQueRespondioMal() {


        Pregunta pregunta = new MultipleChoice(
                "¿Cuáles de las siguientes opciones son opcionesPregunta?",
                opciones,       parcial, "Tema"
        );

        List<Opcion> opcionesJugador=FabricaOpciones.crearListaSimple(List.of("Opcion 1", "Opcion 3"),List.of("1"), new Correcta());
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1);
        respuestas.add(respuesta);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());

    }
    //TESTEAR E IMPLEMENTAR FUNCIONAMIENTO CON CIERTOS MODIFICADORES
}
