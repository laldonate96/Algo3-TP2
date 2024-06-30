package edu.fiuba.algo3.testEntrega4.FabricasTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaJugadores;
import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FabricaJugadoresTest {



    @Test
    public void test01CrearUnaListaDe5JugadoresContieneALos5(){
        //Arrange
        List<String> jugadoresStrings = List.of("NiJuan", "NiPedro", "NiPablo");

        //Act
        List<Jugador> jugadores = FabricaJugadores.crearListaJugadores(jugadoresStrings);

        //Assert
        assertEquals(3, jugadores.size());
        assertEquals("NiJuan", jugadores.get(0).obtenerNombre());
        assertEquals("NiPedro", jugadores.get(1).obtenerNombre());
        assertEquals("NiPablo", jugadores.get(2).obtenerNombre());
    }

    @Test
    public void test02LosJugadoresCreadosPoseenUnaListaDeModificadores(){
        //Arrange
        List<String> jugadoresStrings = List.of("Senior con modificadores");
        List<Modificador> modificadoresEsperados = FabricaModificadores.crearListaModificadores();

        //Act
        List<Jugador> jugadores = FabricaJugadores.crearListaJugadores(jugadoresStrings);

        //Assert
        assertEquals(modificadoresEsperados.size(), jugadores.get(0).obtenerModificadores().size());
        assertTrue(jugadores.get(0).obtenerModificadores().get(0) instanceof Modificador);
    }
}
