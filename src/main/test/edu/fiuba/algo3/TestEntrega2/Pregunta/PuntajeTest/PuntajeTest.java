package edu.fiuba.algo3.TestEntrega2.Pregunta.PuntajeTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Nulo;
import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.opcion.Opcion;


import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.puntaje.Parcial;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class PuntajeTest {

    private Puntaje parcial;
    private List<Respuesta> respuestas;
    private Jugador jugador;

    @BeforeEach
    public void setUpClass() {



        respuestas=new ArrayList<>();

        //USAR UN MOCKITO
        jugador= new Jugador("jugador1", FabricaModificadores.crearListaModificadoresPuntaje());


        parcial = new Parcial();

    }

    @Test
    public void test01AUnaRespuestaConUnaCorrectaSeLeAsigna1Punto() {
        //Arrange

        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1"),List.of("1"), new Correcta());
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador,new Nulo());
        respuestas.add(respuesta);

        //Act
        parcial.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02AUnaRespuestaConVariasCorrectasSeLeAsignan2Puntos() {
        //Arrange
        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1", "Opcion 2"),List.of("1","2"), new Correcta());
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador,new Nulo());
        respuestas.add(respuesta);
        //Act
        parcial.asignarPuntajes(respuestas);

        //Assert
        assertEquals(2, respuesta.obtenerPuntaje());
    }

    @Test
    public void test03AUnaRespuestaConUnaIncorrectaSeLeAsignan0Puntos() {
        //Arrange
        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1n't", "Opcion 2n't","Opcion 3"),List.of("0"), new Correcta());
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador,new Nulo());
        respuestas.add(respuesta);


        //Act
        parcial.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }



    @Test
    public void test04AUnaRespuestaConUnaCorrectaEIncorrectasSeLeAsignan0Puntos() {
        //Arrange
        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1", "Opcion 2","Opcion 3"),List.of("1","2"), new Correcta());
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador,new Nulo());
        respuestas.add(respuesta);

        //Act
        parcial.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }

    @Test
    public void test05UnaListaDeRespuestasUnaCorrectaYUnaIncorrectaSeLesAsignan2Y0PuntosRespectivamente() {
        //Arrange
        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1", "Opcion 2"),List.of("1","2"), new Correcta());
        Respuesta respuesta1 = new Respuesta(opcionesJugador,jugador,new Nulo());
        respuestas.add(respuesta1);

        Jugador jugador2= new Jugador("Jose", FabricaModificadores.crearListaModificadoresPuntaje());
        List<Opcion> opcionesJugador2 = FabricaOpciones.crearListaSimple(List.of("Opcion 1n't", "Opcion 2n't","Opcion 3"),List.of("0"), new Correcta());
        Respuesta respuesta2 = new Respuesta(opcionesJugador2,jugador2,new Nulo());
        respuestas.add(respuesta2);


        //Act
        parcial.asignarPuntajes(respuestas);

        //Assert
        assertEquals(2, respuesta1.obtenerPuntaje());
        assertEquals(0, respuesta2.obtenerPuntaje());

    }
}