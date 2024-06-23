package edu.fiuba.algo3.testEntrega2.ModificadorTurnoTest;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.AnuladorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ExclusividadPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Multiplicador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ExclusividadTurno;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ModificadorTurno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ExclusividadTurnoTest {

    private ModificadorTurno exclusividad;
    private ModificadorPuntaje modificadorPuntaje;
    private Jugador jugador;
    private Respuesta respuestaMock;
    private ArrayList<Respuesta> respuestas;


    @BeforeEach
    public void setUp() {
        exclusividad = new ExclusividadTurno(new ExclusividadPuntaje());

        jugador = mock(Jugador.class);
        respuestaMock = spy(Respuesta.class);


        respuestaMock.asignarPuntaje(14);

        respuestas = new ArrayList<>();
        respuestas.add(respuestaMock);

    }


    @Test
    public void test01UnJugadorRespodeBienYSeDuplicaElPuntajeDeSuRespuesta() {
        //Arrange


        modificadorPuntaje = mock(ExclusividadPuntaje.class);
        exclusividad.usar(modificadorPuntaje, jugador);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(28, respuestaMock.obtenerPuntaje());
    }

    @Test
    public void test02UnJugadorRespodeBienYConMultiplesLlamadosYSeTriplicaElPuntajeDeSuRespuesta() {
        //Arrange
        modificadorPuntaje = mock(AnuladorPuntaje.class);
        exclusividad.usar(modificadorPuntaje, jugador);

        Jugador jugador2 = mock(Jugador.class);
        exclusividad.usar(modificadorPuntaje, jugador2);

        //Act

        exclusividad.modificarPuntajes(respuestas);


        //Assert
        assertEquals(42, respuestaMock.obtenerPuntaje());
    }

    @Test
    public void test03MultiplesLlamadosSinAsignarExclusividadNoMultiplicanElEfecto() {
        //Arrange
        modificadorPuntaje = mock(AnuladorPuntaje.class);
        exclusividad.usar(modificadorPuntaje, jugador);

        Jugador jugador2 = mock(Jugador.class);
        ModificadorPuntaje multiplicador = mock(Multiplicador.class);
        exclusividad.usar(multiplicador, jugador2);

        //Act

        exclusividad.modificarPuntajes(respuestas);


        //Assert
        assertEquals(28, respuestaMock.obtenerPuntaje());
    }

    @Test

    public void test04RecibeDosRespuestasCorrectasYAnulaLosPuntosDeAmbas() {
        //Arrange
        modificadorPuntaje = mock(AnuladorPuntaje.class);
        exclusividad.usar(modificadorPuntaje, jugador);

        Respuesta respuestaMock2 = mock(Respuesta.class);
        respuestaMock2.asignarPuntaje(14);
        respuestas.add(respuestaMock2);
        //Act

        exclusividad.modificarPuntajes(respuestas);


        //Assert
        assertEquals(0, respuestaMock.obtenerPuntaje());
        assertEquals(0, respuestaMock2.obtenerPuntaje());
    }

    @Test
    public void test05AUnaRespuestaCorrectaDeUnJugadorQueNoActivoExclusividadSeLeDuplicaElPuntaje() {
        //Arrange
        modificadorPuntaje = mock(AnuladorPuntaje.class);
        exclusividad.usar(modificadorPuntaje, jugador);
        respuestaMock.asignarPuntaje(0);

        Jugador jugador2 = mock(Jugador.class);

        Respuesta respuestaMock2 = mock(Respuesta.class);
        when(respuestaMock2.perteneceA(jugador2)).thenReturn(true);
        respuestaMock2.asignarPuntaje(13);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(26, respuestaMock2.obtenerPuntaje());

    }

    @Test
    public void test06RecibeMultiplesIncorrectasYUnaCorrectaALaCualLeMultiplicaElPuntaje() {
        modificadorPuntaje = mock(AnuladorPuntaje.class);
        exclusividad.usar(modificadorPuntaje, jugador);


        Respuesta respuestaMock2 = mock(Respuesta.class);
        respuestaMock2.asignarPuntaje(0);


        Respuesta respuestaMock3 = mock(Respuesta.class);
        respuestaMock3.asignarPuntaje(0);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(28, respuestaMock.obtenerPuntaje());
        assertEquals(0, respuestaMock2.obtenerPuntaje());
        assertEquals(0, respuestaMock3.obtenerPuntaje());


    }
}
