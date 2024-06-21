package edu.fiuba.algo3.testEntrega2.ModificadorTurnoTest;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.AnuladorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.AnuladorTurno;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ModificadorTurno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class AnuladorTurnoTest {

    private ModificadorTurno anulador;
    private ModificadorPuntaje modificadorPuntaje;
    private Jugador jugador;
    private Respuesta respuestaMock;
    private ArrayList<Respuesta> respuestas;


    @BeforeEach
    public void setUp() {
        anulador = new AnuladorTurno(new AnuladorPuntaje());
         jugador = mock(Jugador.class);
         respuestaMock =spy(Respuesta.class);


        respuestaMock.asignarPuntaje(14);

        respuestas = new ArrayList<>();
        respuestas.add(respuestaMock);

    }


    @Test
    public void test01LaRespuestaCorrectaDeUnJugadorQueUsoElAnuladorNoEsModificada() {
        //Arrange
        when(respuestaMock.perteneceA(jugador)).thenReturn(true);

        modificadorPuntaje=mock(AnuladorPuntaje.class);
        anulador.usar(modificadorPuntaje,jugador);

        //Act
        anulador.modificarPuntajes(respuestas);

        //Assert
        assertEquals(14, respuestaMock.obtenerPuntaje());
    }

    @Test
    public void test02LaRespuestaCorrectaDeUnJugadorQueNoUsoElAnuladorEsModificada() {
        //Arrange
        when(respuestaMock.perteneceA(jugador)).thenReturn(false);
        modificadorPuntaje=mock(AnuladorPuntaje.class);
        anulador.usar(modificadorPuntaje,jugador);

        //Act

        anulador.modificarPuntajes(respuestas);


        //Assert
        assertEquals(0, respuestaMock.obtenerPuntaje());
    }

    @Test
    public void test03LaRespuestaIncorrectaDeUnJugadorQueNoUsoElAnuladorNoEsModificada() {
        //Arrange
        when(respuestaMock.perteneceA(jugador)).thenReturn(false);
        when(respuestaMock.esCorrecta()).thenReturn(false);
        respuestaMock.asignarPuntaje(-1);

        modificadorPuntaje=mock(AnuladorPuntaje.class);
        anulador.usar(modificadorPuntaje,jugador);

        //Act


        anulador.modificarPuntajes(respuestas);



        //Act

        anulador.modificarPuntajes(respuestas);


        //Assert
//        assertTrue(verify(respuestaMock,never().multiplicarPuntaje(anyInt())));
    }

    @Test
    public void test04Los5JugadoresUsanUnAnuladorYNingunoRecibePuntos() {
        //Arrange
        Jugador jugador2 = mock(Jugador.class);
        Jugador jugador3 = mock(Jugador.class);
        Jugador jugador4 = mock(Jugador.class);
        Jugador jugador5 = mock(Jugador.class);
        Respuesta respuestaMock2 = spy(Respuesta.class);
        Respuesta respuestaMock3 = spy(Respuesta.class);
        Respuesta respuestaMock4 = spy(Respuesta.class);
        Respuesta respuestaMock5 = spy(Respuesta.class);
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);
        jugadores.add(jugador5);

        respuestas.add(respuestaMock2);
        respuestas.add(respuestaMock3);
        respuestas.add(respuestaMock4);
        respuestas.add(respuestaMock5);
        modificadorPuntaje = mock(AnuladorPuntaje.class);

        for (int i = 0; i < 5; i++) {
            respuestas.get(i).asignarPuntaje(1);

            when(respuestas.get(i).perteneceA(jugadores.get(i))).thenReturn(true);

            anulador.usar(modificadorPuntaje, jugadores.get(i));
        }


        //Act

        anulador.modificarPuntajes(respuestas);


        //Assert
        for (Respuesta respuesta:respuestas) {
            assertEquals(0, respuesta.obtenerPuntaje());
        }
    }


}