package edu.fiuba.algo3.testEntrega2.Pregunta;

import edu.fiuba.algo3.modelo.Respuestas.RespuestasConcretas;
import edu.fiuba.algo3.modelo.modificadores.Modificadores;
import edu.fiuba.algo3.modelo.opciones.Ordenadas;
import edu.fiuba.algo3.modelo.opciones.Simples;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.Respuestas.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.NuloPuntaje;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.opciones.opcion.Ordenada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.pregunta.OrderedChoice;

public class OrderedChoiceTest {
    private Opcion opcion1Correcta;
    private Opcion opcion2Correcta;
    private Opcion opcion3Correcta;
    private Opcion opcion1Incorrecta;
    private Opcion opcion2Incorrecta;
    private Opcion opcion3Incorrecta;
    private Opcion opcion1CorrectaSinValidar;
    private Opcion opcion2CorrectaSinValidar;
    private Opcion opcion3CorrectaSinValidar;

    private Jugador jugador1;
    private Jugador jugador2;
    private static Clasica clasica;
    private static ModificadorPuntaje nulo;
    private List<ModificadorPuntaje> modificadores;
    private RespuestasConcretas respuestas;
    private Ordenadas opciones;

    @BeforeAll
    public static void setUpClass() {
        clasica= new Clasica(3);
        nulo=new NuloPuntaje();
    }

    @BeforeEach
    public void setUp() {

        List<ModificadorPuntaje> modificadores= Modificadores.obtenerListaModificadoresPuntaje();

        nulo = modificadores.getFirst();

        jugador1 = new Jugador("Jugador 1", modificadores);
        jugador2 = new Jugador("Jugador 2", modificadores);

        List<String> opcionesTexto= List.of("Opcion 1", "Opcion 2", "Opcion 3");
        List<String> posicionesCorrectas= List.of("1", "2");

        respuestas=new RespuestasConcretas();
        opciones=new Ordenadas(opcionesTexto,posicionesCorrectas);


        opcion1Incorrecta = new Ordenada("Opcion 1",1, new Incorrecta());
        opcion2Incorrecta = new Ordenada("Opcion 2",2, new Incorrecta());
        opcion3Incorrecta = new Ordenada("Opcion 3",3, new Incorrecta());

        opcion1CorrectaSinValidar = new Ordenada("Opcion 3",1, new Incorrecta());
        opcion2CorrectaSinValidar = new Ordenada("Opcion 2",2, new Incorrecta());
        opcion3CorrectaSinValidar = new Ordenada("Opcion 1",3, new Incorrecta());

        opcion1Correcta = new Ordenada("Opcion 3", 1, new Correcta());
        opcion2Correcta = new Ordenada("Opcion 2", 2, new Correcta());
        opcion3Correcta = new Ordenada("Opcion 1", 3, new Correcta());
    }

    @Test
    public void test01OrderedChoiceAsignaPuntajeCorrectoAJugadorQueRespondeCorrectamente(){
        //Arrange
        List<Opcion> opcionesPregunta = Arrays.asList(opcion1Correcta, opcion2Correcta,opcion3Correcta);

        Pregunta pregunta = new OrderedChoice(
                "Ordenar las siguientes opciones",
                opcionesPregunta,
                clasica,
                "Tema"
        );

        Respuesta respuesta2 = jugador2.responder(Arrays.asList(opcion2CorrectaSinValidar, opcion1CorrectaSinValidar, opcion3CorrectaSinValidar),opcionesPregunta, nulo);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta2);

        //Act

        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test02OrderedChoiceAsignaPuntajeCorrectoAJugadorQueRespondeIncorrectamente() {
        //Arrange
        List<Opcion> opcionesPregunta = Arrays.asList(opcion1Correcta, opcion2Correcta,opcion3Correcta);

        Pregunta pregunta = new OrderedChoice(
                "Ordenar las siguientes opciones",
                opcionesPregunta,
                clasica,
                "Tema"
        );
        Respuesta correcta = jugador1.responder(Arrays.asList(opcion1Incorrecta, opcion2Incorrecta, opcion3Incorrecta),opcionesPregunta, nulo);
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(correcta);

        //Act
        pregunta.asignarPuntajes(respuestas);
        //Assert
        assertEquals(0, jugador1.obtenerPuntaje());
    }
}
