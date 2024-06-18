package edu.fiuba.algo3.testEntrega2.PuntajeTest;

import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.testEntrega2.mocks.RespuestaMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PenalidadTest{
    private Simple opcion1Correcta;
    private Simple opcion2Correcta;

    private Simple opcion1;
    private Simple opcion2;
    private Puntaje conPenalidad;

    @BeforeEach
    public void setUpClass() {

        opcion1 = new Simple("Opcion 1", new Incorrecta());
        opcion1Correcta = new Simple("Opcion 1", new Correcta());
        opcion2 = new Simple("Opcion 2", new Incorrecta());
        opcion2Correcta = new Simple("Opcion 2", new Correcta());

        conPenalidad = new ConPenalidad();
    }

    @Test
    public void test06ConPenalidadAUnaRespuestaConUnaCorrectaSeLeAsignanPuntosCorrectamente() {
        //Arrange
        RespuestaMock respuesta = new RespuestaMock(Arrays.asList(opcion1Correcta));

        List<Respuesta> respuestas= List.of(respuesta);
        //Act
        conPenalidad.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }

    @Test
    public void test07ConPenalidadAUnaRespuestaConMultiplesCorrectasSeLeAsignanPuntosCorrectamente() {
        //Arrange
        RespuestaMock respuesta = new RespuestaMock(Arrays.asList(opcion1Correcta, opcion2Correcta));

        List<Respuesta> respuestas= List.of(respuesta);
        //Act
        conPenalidad.asignarPuntajes(respuestas);

        //Assert
        assertEquals(2, respuesta.obtenerPuntaje());
    }

    @Test
    public void test08ConPenalidadAUnaRespuestaConAlgunasCorrectasYOtrasIncorrectasSeLeAsignanPuntosCorrectamente() {
        //Arrange
        RespuestaMock respuesta = new RespuestaMock(Arrays.asList(opcion1Correcta, opcion2));

        List<Respuesta> respuestas= List.of(respuesta);

        //Act
        conPenalidad.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }

    @Test
    public void test09ConPenalidadAUnaRespuestaConVariasIncorrectasSeLeAsignanPuntosCorrectamente() {
        //Arrange
        RespuestaMock respuesta = new RespuestaMock(Arrays.asList(opcion1, opcion2));
        List<Respuesta> respuestas= List.of(respuesta);

        //Act
        conPenalidad.asignarPuntajes(respuestas);

        //Assert
        assertEquals(-2, respuesta.obtenerPuntaje());
    }

    @Test
    public void test10ConPenalidadAUnaListaDeRespuestasUnaCorrectaYUnaIncorrectaSeLesAsignanPuntosCorrectamente() {
        //Arrange
        RespuestaMock respuesta1 = new RespuestaMock(Arrays.asList(opcion1Correcta));
        RespuestaMock respuesta2 = new RespuestaMock(Arrays.asList(opcion1));
        List<Respuesta> respuestas= List.of(respuesta1,respuesta2);

        //Act
        conPenalidad.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta1.obtenerPuntaje());
        assertEquals(-1, respuesta2.obtenerPuntaje());

    }
}
