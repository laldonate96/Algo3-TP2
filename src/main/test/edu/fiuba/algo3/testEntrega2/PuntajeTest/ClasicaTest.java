package edu.fiuba.algo3.testEntrega2.PuntajeTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.NuloPuntaje;
import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;


import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClasicaTest {


    private List<Respuesta> respuestas;
    private Jugador jugador;

    @BeforeEach
    public void setUpClass() {



        respuestas=new ArrayList<>();

        //USAR UN MOCKITO
        jugador= new Jugador("jugador1", FabricaModificadores.crearListaModificadoresPuntaje());
    }

    @Test
    public void test01UnaRespuestaConUnaCorrectaSeLeAsignaUnPunto() {
        //Arrange
        Clasica clasica = new Clasica(1);

        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1"),List.of("1"));
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador,new NuloPuntaje());
        respuestas.add(respuesta);


        //Act
        clasica.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02UnaRespuestaConVariasCorrectasSeLeAsigna1Punto() {
        //Arrange
        Clasica clasica = new Clasica(2);


        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1", "Opcion 2"),List.of("1","2"));
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador,new NuloPuntaje());
        respuestas.add(respuesta);



        //Act
        clasica.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }

    @Test
    public void test03UnaRespuestaConVariasIncorrectasSeLeAsignan0Puntos() {
        //Arrange
        Clasica clasica = new Clasica(1);



        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1n't", "Opcion 2n't","Opcion 3"),List.of("0"));
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador,new NuloPuntaje());
        respuestas.add(respuesta);



        //Act
        clasica.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }

    @Test
    public void test04UnaRespuestaConCorrectasEIncorrectasSeLeAsignan0Puntos() {
        //Arrange
        Clasica clasica = new Clasica(1);


        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1", "Opcion 2","Opcion 3"),List.of("1","2"));
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador,new NuloPuntaje());
        respuestas.add(respuesta);


        //Act
        clasica.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }

    @Test
    public void test05DosRespuestasUnaCorrectaYUnaIncorrectaSeLesAsignan0Puntos() {
        //Arrange
        Clasica clasica = new Clasica(2);

        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1", "Opcion 2"),List.of("1","2"));
        Respuesta respuesta1 = new Respuesta(opcionesJugador,jugador,new NuloPuntaje());
        respuestas.add(respuesta1);

        Jugador jugador2= new Jugador("USAR MOCKITO", FabricaModificadores.crearListaModificadoresPuntaje());
        List<Opcion> opcionesJugador2 = FabricaOpciones.crearListaSimple(List.of("Opcion 1n't", "Opcion 2n't","Opcion 3"),List.of("0"));
        Respuesta respuesta2 = new Respuesta(opcionesJugador2,jugador2,new NuloPuntaje());
        respuestas.add(respuesta2);


        //Act
        clasica.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta1.obtenerPuntaje());
        assertEquals(0, respuesta2.obtenerPuntaje());

    }

    @Test
    public void test06AUnaRespuestaSinTodasLasOpcionesCorrectasSeLesAsignan0Puntos() {
        //Arrange
        Clasica clasica = new Clasica(3);



        //USAR MOCKITO ACA TAMBIEN
        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1"),List.of("1"));
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador,new NuloPuntaje());
        respuestas.add(respuesta);

        //Act
        clasica.asignarPuntaje(respuesta);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());

    }

}
