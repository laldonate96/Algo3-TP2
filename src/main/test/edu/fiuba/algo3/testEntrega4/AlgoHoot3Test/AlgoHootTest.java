package edu.fiuba.algo3.testEntrega4.AlgoHoot3Test;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.Fabricas.FabricaJugadores;
import edu.fiuba.algo3.modelo.jugador.Jugador;
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
        AlgoHoot3 algoHoot3 = AlgoHoot3.obtenerInstancia();

        //Act
        int ronda = algoHoot3.obtenerRonda();

        //Assert
        assertEquals(0, ronda);

        //Arrange
        Turno turno = new Turno();

        //Act
        algoHoot3.asignarJugadores(jugadores);
        ronda = algoHoot3.pasarRonda(turno);

        //Assert
        assertTrue(algoHoot3.quedanJugadores());
        assertEquals(1, ronda);
        assertTrue((algoHoot3.obtenerPreguntaDeRondaActual() instanceof Pregunta));
        assertTrue(algoHoot3.obtenerJugadorActual().equals(jugadores.get(0)));

        //Act
        //Acá deberíamos usar un mock. Xq yo
    }

}
