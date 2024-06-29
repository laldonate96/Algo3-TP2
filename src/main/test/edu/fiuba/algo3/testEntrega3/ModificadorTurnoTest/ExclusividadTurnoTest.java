package edu.fiuba.algo3.testEntrega3.ModificadorTurnoTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Exclusividad;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Modificador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.Multiplicador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.Exclusividad;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadTurnoTest {

    private Modificador exclusividad;
    private Jugador jugador;
    private Jugador jugador2;
    private Respuesta respuesta;
    private Respuesta respuesta2;
    private ArrayList<Respuesta> respuestas;
    private Modificador modificador;
    private List<Modificador> modificadores;
    private List<Opcion> opcionesCorrectas;

    @BeforeEach
    public void setUp() {
        exclusividad = new Exclusividad(new Exclusividad());

        List<String> posicionesCorrectas= List.of("1");
        opcionesCorrectas = FabricaOpciones.crearListaSimple(List.of("Correcta","Incorrecta"),posicionesCorrectas, new Correcta());
        modificador = new Exclusividad();
        modificadores = new ArrayList<>();
        modificadores.add(modificador);
        modificadores.add(new Multiplicador(2));

        jugador = new Jugador("Jugador1", modificadores);

        respuesta = new Respuesta(opcionesCorrectas, jugador, modificador);
        respuesta.asignarPuntaje(10);

        respuestas = new ArrayList<>();
        respuestas.add(respuesta);

        modificador = new Exclusividad();
        modificadores = new ArrayList<>();
        modificadores.add(modificador);
        jugador2 = new Jugador("Jugador2", modificadores);

        respuesta2 = new Respuesta(opcionesCorrectas, jugador, modificador);
        respuesta2.asignarPuntaje(0);

        respuestas.add(respuesta2);
    }

    @Test
    public void test01UnJugadorRespodeBienYSeDuplicaElPuntajeDeSuRespuesta() {
        //Arrange
        exclusividad.usar(modificador, jugador);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(20, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02UnJugadorRespodeBienYElMismoUsaLaExclusividadSeDuplicaElPuntajeDeSuRespuesta() {
        //Arrange
        exclusividad.usar(modificador, jugador);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(20, respuesta.obtenerPuntaje());
    }

    @Test
    public void test03UnJugadorRespodeBienYConMultiplesLlamadosYSeTriplicaElPuntajeDeSuRespuesta() {
        //Arrange
        exclusividad.usar(modificador, jugador);
        exclusividad.usar(modificador, jugador2);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(40, respuesta.obtenerPuntaje());
    }

    @Test
    public void test04MultiplesLlamadosSinAsignarExclusividadNoMultiplicanElEfecto() {
        //Arrange
        exclusividad.usar(new Multiplicador(2), jugador);
        exclusividad.usar(modificador, jugador2);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(20, respuesta.obtenerPuntaje());
    }

    @Test

    public void test05RecibeDosRespuestasCorrectasYAnulaLosPuntosDeAmbas() {
        //Arrange
        exclusividad.usar(modificador, jugador);

        respuesta2.asignarPuntaje(1);
        respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        respuestas.add(respuesta2);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        assertEquals(0, respuesta.obtenerPuntaje());
        assertEquals(0, respuesta2.obtenerPuntaje());
    }

    @Test
    public void test06AUnaRespuestaCorrectaDeUnJugadorQueNoActivoExclusividadSeLeDuplicaElPuntaje() {
        //Arrange
        exclusividad.usar(modificador, jugador2);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(20, respuesta.obtenerPuntaje());
    }

    @Test
    public void test06RecibeMultiplesIncorrectasYUnaCorrectaALaCualLeMultiplicaElPuntaje() {
        exclusividad.usar(modificador, jugador);

        Respuesta respuesta3 = new Respuesta(opcionesCorrectas, new Jugador("carlos", modificadores), modificador);
        respuesta3.asignarPuntaje(0);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(20, respuesta.obtenerPuntaje());
        assertEquals(0, respuesta2.obtenerPuntaje());
        assertEquals(0, respuesta3.obtenerPuntaje());
    }
}
