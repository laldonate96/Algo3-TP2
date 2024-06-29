package edu.fiuba.algo3.TestEntrega2.Pregunta.PuntajeTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Modificador.Nulo;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;


import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
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
        jugador= new Jugador("jugador1", FabricaModificadores.crearListaModificadores());
    }

    @Test
    public void test01UnaRespuestaConUnaCorrectaSeLeAsignaUnPunto() {
        //Arrange
        Clasica clasica = new Clasica(1);

        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1"),List.of("1"),  new Correcta());
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador);
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


        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1", "Opcion 2"),List.of("1","2"),  new Correcta());
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador);
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



        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1n't", "Opcion 2n't","Opcion 3"),List.of("0"),  new Correcta());
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador);
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


        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1", "Opcion 2","Opcion 3"),List.of("1","2"),  new Correcta());
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador);
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

        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1", "Opcion 2"),List.of("1","2"),  new Correcta());
        Respuesta respuesta1 = new Respuesta(opcionesJugador,jugador);
        respuestas.add(respuesta1);

        Jugador jugador2= new Jugador("jorgeee", FabricaModificadores.crearListaModificadores());
        List<Opcion> opcionesJugador2 = FabricaOpciones.crearListaSimple(List.of("Opcion 1n't", "Opcion 2n't","Opcion 3"),List.of("0"),  new Correcta());
        Respuesta respuesta2 = new Respuesta(opcionesJugador2,jugador2);
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
        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1"),List.of("1"),  new Correcta());
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador);
        respuestas.add(respuesta);

        //Act
        clasica.asignarPuntaje(respuesta);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());

    }

}
