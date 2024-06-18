package edu.fiuba.algo3.testEntrega2.PuntajeTest;

import edu.fiuba.algo3.modelo.Respuestas.RespuestasConcretas;
import edu.fiuba.algo3.modelo.opciones.Opciones;
import edu.fiuba.algo3.modelo.opciones.Simples;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.opciones.opcion.Simple;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.puntaje.Parcial;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

import edu.fiuba.algo3.modelo.Respuestas.respuesta.Respuesta;
import edu.fiuba.algo3.testEntrega2.mocks.RespuestaMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

public class PuntajeTest {

    private Puntaje parcial;
    private Puntaje conPenalidad;
    private RespuestasConcretas respuestas;
    private Simples opciones;

    @BeforeEach
    public void setUpClass() {

        List<String> opcionesTexto= List.of("Opcion 1", "Opcion 2", "Opcion 3");
        List<String> posicionesCorrectas= List.of("1", "2");

        respuestas=new RespuestasConcretas();
        opciones=new Simples(opcionesTexto,posicionesCorrectas);


        parcial = new Parcial();
        conPenalidad = new ConPenalidad();
    }

    @Test
    public void test11ParcialAUnaRespuestaConUnaCorrectaSeLeAsignanPuntosCorrectamente() {
        //Arrange

        Opciones opcionesRespuesta=opciones.crearCopia(List.of("Opcion 1"));
        RespuestaMock respuesta = new RespuestaMock(opcionesRespuesta);
        respuestas.agregar(respuesta);

        //Act
        parcial.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }

    @Test
    public void test12ParcialAUnaRespuestaConUnaIncorrectaSeLeAsignanPuntosCorrectamente() {
        //Arrange
        Opciones opcionesRespuesta=opciones.crearCopia(List.of("Opcion 3"));
        RespuestaMock respuesta = new RespuestaMock(opcionesRespuesta);
        respuestas.agregar(respuesta);


        //Act
        parcial.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }

    @Test
    public void test13ParcialAUnaRespuestaConVariasCorrectasSeLeAsignanPuntosCorrectamente() {
        //Arrange
        Opciones opcionesRespuesta=opciones.crearCopia(List.of("Opcion 2", "Opcion 1"));
        RespuestaMock respuesta = new RespuestaMock(opcionesRespuesta);
        respuestas.agregar(respuesta);
        //Act
        parcial.asignarPuntajes(respuestas);

        //Assert
        assertEquals(2, respuesta.obtenerPuntaje());
    }

    @Test
    public void test14ParcialAUnaRespuestaConCorrectasEIncorrectasSeLeAsignanPuntosCorrectamente() {
        //Arrange
        Opciones opcionesRespuesta=opciones.crearCopia(List.of("Opcion 2n't", "Opcion 1"));
        RespuestaMock respuesta = new RespuestaMock(opcionesRespuesta);
        respuestas.agregar(respuesta);

        //Act
        parcial.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }

    @Test
    public void test15ParcialAUnaListaDeRespuestasUnaCorrectaYUnaIncorrectaSeLesAsignanPuntosCorrectamente() {
        //Arrange
        Opciones opcionesRespuesta1=opciones.crearCopia(List.of("Opcion 1", "Opcion 2"));
        Opciones opcionesRespuesta2=opciones.crearCopia(List.of("Opcion 1n't", "Opcion 2n't","Opcion 3"));
        RespuestaMock respuesta1 = new RespuestaMock(opcionesRespuesta1);
        RespuestaMock respuesta2 = new RespuestaMock(opcionesRespuesta2);
        respuestas.agregar(respuesta1);
        respuestas.agregar(respuesta2);

        //Act
        parcial.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta1.obtenerPuntaje());
        assertEquals(0, respuesta2.obtenerPuntaje());

    }
}