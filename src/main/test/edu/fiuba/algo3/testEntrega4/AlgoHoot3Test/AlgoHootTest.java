package edu.fiuba.algo3.testEntrega4.AlgoHoot3Test;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.Fabricas.FabricaJugadores;
import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaNula;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.turno.Turno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlgoHootTest {
    private List<String> jugadoresString;
    private List<Jugador> jugadores;
    private AlgoHoot3 algoHoot3;

    @BeforeEach
    public void setUp(){
        jugadoresString = new ArrayList<>();
        jugadoresString.add("Jugador1");
        jugadoresString.add("Jugador2");
        jugadoresString.add("Jugador3");

        jugadores = FabricaJugadores.crearListaJugadores(jugadoresString);
    }

    @Test
    public void test01AlgoHoot(){
        //Arrange
        AlgoHoot3 algoHoot3 = AlgoHoot3.obtenerInstancia(new MezclaNula());

        //Act
        int ronda = algoHoot3.obtenerRonda();

        //Assert
        assertEquals(0, ronda);

        //Arrange
        Turno turno = new Turno();
        List<String> opcionesString = new ArrayList<>();
        List<String> ordenString = new ArrayList<>();
        opcionesString.add("Televisor de tubo CRT");
        opcionesString.add("Microondas");
        opcionesString.add("Imanes del delivery");
        opcionesString.add("Heladera");
        ordenString.add("2");
        ordenString.add("1");
        ordenString.add("4");
        ordenString.add("3");
        List<Opcion> opcionesEsperadas = FabricaOpciones.crearListaOrdenada(opcionesString, ordenString, new Correcta());

        //Act
        algoHoot3.asignarJugadores(jugadores);
        ronda = algoHoot3.pasarRonda(turno);

        //Assert
        assertTrue(algoHoot3.quedanJugadores());
        assertEquals(1, ronda);
        assertEquals(algoHoot3.obtenerPreguntaDeRondaActual().obtenerEnunciado(), "Ordene de MAYOR A MENOR los siguientes objetos hogareños según su nivel de radiación electromagnética emitido (el máximo recomendado es 100 microTeslas)");
        assertEquals(algoHoot3.obtenerPreguntaDeRondaActual().obtenerCategoria(), "CIENCIAS");
        assertTrue(algoHoot3.obtenerPreguntaDeRondaActual().obtenerOpciones().get(0).equals(opcionesEsperadas.get(0)));
        assertTrue(algoHoot3.obtenerPreguntaDeRondaActual().obtenerOpciones().get(1).equals(opcionesEsperadas.get(1)));
        assertTrue(algoHoot3.obtenerPreguntaDeRondaActual().obtenerOpciones().get(2).equals(opcionesEsperadas.get(2)));
        assertTrue(algoHoot3.obtenerPreguntaDeRondaActual().obtenerOpciones().get(3).equals(opcionesEsperadas.get(3)));
        assertTrue(algoHoot3.obtenerJugadorActual().equals(jugadores.get(0)));

        //

    }

}