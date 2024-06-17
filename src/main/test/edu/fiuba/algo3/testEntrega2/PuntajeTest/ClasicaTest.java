package edu.fiuba.algo3.testEntrega2.PuntajeTest;

import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.testEntrega2.mocks.RespuestaMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClasicaTest {

    private Simple opcion1Correcta;
    private Simple opcion2Correcta;

    private Simple opcion1;
    private Simple opcion2;
    private Simple opcion3;
    private Puntaje clasica;

    @BeforeEach
    public void setUpClass() {

        opcion1 = new Simple("Opcion 1", new Incorrecta());
        opcion1Correcta = new Simple("Opcion 1", new Correcta());
        opcion2 = new Simple("Opcion 2", new Incorrecta());
        opcion2Correcta = new Simple("Opcion 2", new Correcta());
        opcion3 = new Simple("Opcion 3", new Incorrecta());
    }

    public void test01UnaRespuestaConUnaCorrectaSeLeAsignaUnPunto() {
        //Arrange
        Clasica clasica = new Clasica(1);
        RespuestaMock respuesta = new RespuestaMock(Arrays.asList(opcion1Correcta));
        List<Respuesta> respuestas = List.of(respuesta);


        //Act
        clasica.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02UnaRespuestaConVariasCorrectasSeLeAsigna1Punto() {
        //Arrange
        Clasica clasica = new Clasica(2);

        RespuestaMock respuesta = new RespuestaMock(Arrays.asList(opcion1Correcta, opcion2Correcta));
        List<Respuesta> respuestas = List.of(respuesta);

        //Act
        clasica.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }

    @Test
    public void test03UnaRespuestaConVariasIncorrectasSeLeAsignan0Puntos() {
        //Arrange
        Clasica clasica = new Clasica(1);

        RespuestaMock respuesta = new RespuestaMock(Arrays.asList(opcion1, opcion2, opcion3));
        List<Respuesta> respuestas = List.of(respuesta);

        //Act
        clasica.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }

    @Test
    public void test04UnaRespuestaConCorrectasEIncorrectasSeLeAsignan0Puntos() {
        //Arrange
        Clasica clasica = new Clasica(1);
        RespuestaMock respuesta = new RespuestaMock(Arrays.asList(opcion1Correcta, opcion2Correcta, opcion3));
        List<Respuesta> respuestas = List.of(respuesta);

        //Act
        clasica.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }

    @Test
    public void test05UnaListaDeRespuestasUnaCorrectaYUnaIncorrectaSeLesAsignan0Puntos() {
        //Arrange
        Clasica clasica = new Clasica(1);

        RespuestaMock respuesta1 = new RespuestaMock(Arrays.asList(opcion1Correcta));
        RespuestaMock respuesta2 = new RespuestaMock(Arrays.asList(opcion1));
        List<Respuesta> respuestas = List.of(respuesta1, respuesta2);

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

        RespuestaMock respuesta1 = new RespuestaMock(Arrays.asList(opcion1Correcta));

        //Act
        clasica.asignarPuntaje(respuesta1);

        //Assert
        assertEquals(0, respuesta1.obtenerPuntaje());

    }

}
