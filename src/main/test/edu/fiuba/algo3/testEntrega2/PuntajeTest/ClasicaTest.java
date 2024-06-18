package edu.fiuba.algo3.testEntrega2.PuntajeTest;

import edu.fiuba.algo3.modelo.Respuestas.RespuestasConcretas;
import edu.fiuba.algo3.modelo.opciones.Opciones;
import edu.fiuba.algo3.modelo.opciones.Simples;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.testEntrega2.mocks.RespuestaMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClasicaTest {


    private Puntaje clasica;
    private Simples opciones;
    private RespuestasConcretas respuestas;

    @BeforeEach
    public void setUpClass() {

        List<String> opcionesTexto= List.of("Opcion 1", "Opcion 2", "Opcion 3");
        List<String> posicionesCorrectas= List.of("1", "2");

        respuestas=new RespuestasConcretas();
        opciones=new Simples(opcionesTexto,posicionesCorrectas);
    }

    public void test01UnaRespuestaConUnaCorrectaSeLeAsignaUnPunto() {
        //Arrange
        Clasica clasica = new Clasica(1);

        Opciones opcionesRespuesta=opciones.crearCopia(List.of("Opcion 1"));
        RespuestaMock respuesta = new RespuestaMock(opcionesRespuesta);
        respuestas.agregar(respuesta);


        //Act
        clasica.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02UnaRespuestaConVariasCorrectasSeLeAsigna1Punto() {
        //Arrange
        Clasica clasica = new Clasica(2);

        Opciones opcionesRespuesta=opciones.crearCopia(List.of("Opcion 1", "Opcion 2"));
        RespuestaMock respuesta = new RespuestaMock(opcionesRespuesta);
        respuestas.agregar(respuesta);

        //Act
        clasica.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }

    @Test
    public void test03UnaRespuestaConVariasIncorrectasSeLeAsignan0Puntos() {
        //Arrange
        Clasica clasica = new Clasica(1);


        Opciones opcionesRespuesta=opciones.crearCopia(List.of("Opcion 1n't", "Opcion 2n't","Opcion 3"));
        RespuestaMock respuesta = new RespuestaMock(opcionesRespuesta);
        respuestas.agregar(respuesta);

        //Act
        clasica.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }

    @Test
    public void test04UnaRespuestaConCorrectasEIncorrectasSeLeAsignan0Puntos() {
        //Arrange
        Clasica clasica = new Clasica(1);


        Opciones opcionesRespuesta=opciones.crearCopia(List.of("Opcion 1", "Opcion 2","Opcion 3"));
        RespuestaMock respuesta = new RespuestaMock(opcionesRespuesta);
        respuestas.agregar(respuesta);

        //Act
        clasica.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }

    @Test
    public void test05DosRespuestasUnaCorrectaYUnaIncorrectaSeLesAsignan0Puntos() {
        //Arrange
        Clasica clasica = new Clasica(1);

        Opciones opcionesRespuesta1=opciones.crearCopia(List.of("Opcion 1", "Opcion 2"));
        Opciones opcionesRespuesta2=opciones.crearCopia(List.of("Opcion 1n't", "Opcion 2n't","Opcion 3"));
        RespuestaMock respuesta1 = new RespuestaMock(opcionesRespuesta1);
        RespuestaMock respuesta2 = new RespuestaMock(opcionesRespuesta2);
        respuestas.agregar(respuesta1);
        respuestas.agregar(respuesta2);

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

        Opciones opcionesRespuesta=opciones.crearCopia(List.of("Opcion 1"));
        RespuestaMock respuesta = new RespuestaMock(opcionesRespuesta);

        //Act
        clasica.asignarPuntaje(respuesta);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());

    }

}
