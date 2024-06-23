package edu.fiuba.algo3.testEntrega2.ModificadorTurnoTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.AnuladorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ExclusividadPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Multiplicador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ExclusividadTurno;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ModificadorTurno;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ExclusividadTurnoTest {

    private ModificadorTurno exclusividad;
    private Jugador jugador;
    private Jugador jugador2;
    private Respuesta respuesta;
    private Respuesta respuesta2;
    private ArrayList<Respuesta> respuestas;
    private ModificadorPuntaje modificadorPuntaje;
    private List<ModificadorPuntaje> modificadores;
    private List<Opcion> opcionesCorrectas;

    @BeforeEach
    public void setUp() {
        exclusividad = new ExclusividadTurno(new ExclusividadPuntaje());

        List<String> posicionesCorrectas= List.of("1");
        opcionesCorrectas = FabricaOpciones.crearListaSimple(List.of("Correcta","Incorrecta"),posicionesCorrectas);
        modificadorPuntaje = new ExclusividadPuntaje();
        modificadores = new ArrayList<>();
        modificadores.add(modificadorPuntaje);

        jugador = new Jugador("Jugador1", modificadores);

        respuesta = new Respuesta(opcionesCorrectas, jugador, modificadorPuntaje);
        respuesta.asignarPuntaje(10);

        respuestas = new ArrayList<>();
        respuestas.add(respuesta);

        modificadorPuntaje = new ExclusividadPuntaje();
        modificadores = new ArrayList<>();
        modificadores.add(modificadorPuntaje);
        jugador2 = new Jugador("Jugador2", modificadores);

        respuesta2 = new Respuesta(opcionesCorrectas, jugador, modificadorPuntaje);
        respuesta2.asignarPuntaje(0);

        respuestas.add(respuesta2);
    }

    @Test
    public void test01UnJugadorRespodeBienYSeDuplicaElPuntajeDeSuRespuesta() {
        //Arrange
        exclusividad.usar(modificadorPuntaje, jugador2);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(20, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02UnJugadorRespodeBienYElMismoUsaLaExclusividadSeDuplicaElPuntajeDeSuRespuesta() {
        //Arrange
        exclusividad.usar(modificadorPuntaje, jugador);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(20, respuesta.obtenerPuntaje());
    }

    @Test
    public void test03UnJugadorRespodeBienYConMultiplesLlamadosYSeTriplicaElPuntajeDeSuRespuesta() {
        //Arrange
        exclusividad.usar(modificadorPuntaje, jugador);
        exclusividad.usar(modificadorPuntaje, jugador2);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(40, respuesta.obtenerPuntaje());
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
        //assertEquals(28, respuestaMock.obtenerPuntaje());
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
        //assertEquals(0, respuestaMock.obtenerPuntaje());
        //assertEquals(0, respuestaMock2.obtenerPuntaje());
    }

    @Test
    public void test05AUnaRespuestaCorrectaDeUnJugadorQueNoActivoExclusividadSeLeDuplicaElPuntaje() {
        //Arrange
        modificadorPuntaje = mock(AnuladorPuntaje.class);
        exclusividad.usar(modificadorPuntaje, jugador);
        //respuestaMock.asignarPuntaje(0);

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
        //assertEquals(28, respuestaMock.obtenerPuntaje());
        //assertEquals(0, respuestaMock2.obtenerPuntaje());
        //assertEquals(0, respuestaMock3.obtenerPuntaje());


    }
}
