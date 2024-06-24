package edu.fiuba.algo3.TestEntrega2.Pregunta.PuntajeTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.NuloPuntaje;
import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PenalidadTest{

    private Puntaje conPenalidad;
    private List<Respuesta> respuestas;
    private Jugador jugador;

    @BeforeEach
    public void setUpClass() {



        respuestas=new ArrayList<>();

        //USAR UN MOCKITO
        jugador= new Jugador("jugador1", FabricaModificadores.crearListaModificadoresPuntaje());

        conPenalidad = new ConPenalidad();
    }

    @Test
    public void test01ConPenalidadAUnaRespuestaConUnaCorrectaSeLeAsignanPuntosCorrectamente() {
        //Arrange


        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1"),List.of("1"), new Correcta());
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador,new NuloPuntaje());
        respuestas.add(respuesta);


        //Act
        conPenalidad.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02UnaRespuestaConMultiplesCorrectasSeLeAsigna1Punto() {
        //Arrange

        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1", "Opcion 2"),List.of("1","2"),  new Correcta());
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador,new NuloPuntaje());
        respuestas.add(respuesta);
        //Act
        conPenalidad.asignarPuntajes(respuestas);

        //Assert
        assertEquals(2, respuesta.obtenerPuntaje());
    }


    @Test
    public void test03ConPenalidadAUnaRespuestaConVariasIncorrectasSeLeAsignanPuntosCorrectamente() {
        //Arrange
        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1n't", "Opcion 2n't","Opcion 3"),List.of("0"),  new Correcta());
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador,new NuloPuntaje());
        respuestas.add(respuesta);

        //Act
        conPenalidad.asignarPuntajes(respuestas);

        //Assert
        assertEquals(-3, respuesta.obtenerPuntaje());
    }
    @Test
    public void test04UnaRespuestaConAlgunasCorrectasYOtrasIncorrectasSeLeAsignan0Puntos() {
        //Arrange
        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1", "Opcion 2","Opcion 3"),List.of("1","2"), new Correcta());
        Respuesta respuesta = new Respuesta(opcionesJugador,jugador,new NuloPuntaje());
        respuestas.add(respuesta);
        //Act
        conPenalidad.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }


    @Test
    public void test05ConPenalidadAUnaListaDeRespuestasUnaCorrectaYUnaIncorrectaSeLesAsignanPuntosCorrectamente() {
        //Arrange
        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of("Opcion 1", "Opcion 2"),List.of("1","2"),  new Correcta());
        Respuesta respuesta1 = new Respuesta(opcionesJugador,jugador,new NuloPuntaje());
        respuestas.add(respuesta1);

        Jugador jugador2= new Jugador("USAR MOCKITO", FabricaModificadores.crearListaModificadoresPuntaje());
        List<Opcion> opcionesJugador2 = FabricaOpciones.crearListaSimple(List.of("Opcion 1n't", "Opcion 2n't","Opcion 3"),List.of("0"),  new Correcta());
        Respuesta respuesta2 = new Respuesta(opcionesJugador2,jugador2,new NuloPuntaje());
        respuestas.add(respuesta2);

        //Act
        conPenalidad.asignarPuntajes(respuestas);

        //Assert
        assertEquals(2, respuesta1.obtenerPuntaje());
        assertEquals(-3, respuesta2.obtenerPuntaje());
    }
}
