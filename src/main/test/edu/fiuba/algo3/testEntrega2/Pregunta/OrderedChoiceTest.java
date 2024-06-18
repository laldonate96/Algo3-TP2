package edu.fiuba.algo3.testEntrega2.Pregunta;

import edu.fiuba.algo3.modelo.Respuestas.RespuestasConcretas;
import edu.fiuba.algo3.modelo.modificadores.Modificadores;
import edu.fiuba.algo3.modelo.opciones.Opciones;
import edu.fiuba.algo3.modelo.opciones.Ordenadas;
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


    private Jugador jugador1;
    private Jugador jugador2;
    private static Clasica clasica;
    private static ModificadorPuntaje nulo;

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
        List<String> ordenCorrecto = List.of("3", "2", "1");

        respuestas=new RespuestasConcretas();
        opciones=new Ordenadas(opcionesTexto, ordenCorrecto);
    }

    @Test
    public void test01OrderedChoiceAsignaPuntajeCorrectoAJugadorQueRespondeCorrectamente(){
        //Arrange

        Pregunta pregunta = new OrderedChoice(
                "Ordenar las siguientes opciones",
                opciones,
                clasica,
                "Tema"
        );


        Opciones opcionesJugador = pregunta.crearCopiaOpciones(List.of( "Opcion 3","Opcion 2", "Opcion 1"));
        respuestas.agregar(opcionesJugador,jugador1,nulo);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Act

        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test02OrderedChoiceAsignaPuntajeCorrectoAJugadorQueRespondeIncorrectamente() {
        //Arrange

        Pregunta pregunta = new OrderedChoice(
                "Ordenar las siguientes opciones",
                opciones,
                clasica,
                "Tema"
        );
        
        Opciones opcionesJugador = pregunta.crearCopiaOpciones(List.of( "Opcion 1","Opcion 2", "Opcion 3"));
        respuestas.agregar(opcionesJugador,jugador1,nulo);

        //Act
        pregunta.asignarPuntajes(respuestas);
        //Assert
        assertEquals(0, jugador1.obtenerPuntaje());
    }
}
