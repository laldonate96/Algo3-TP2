package edu.fiuba.algo3.TestEntrega2.JugadorTest;

import edu.fiuba.algo3.modelo.excepciones.ModificadorInexistenteException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.*;


import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.Multiplicador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

public class JugadorTest {
    private Jugador jugador;
    private Modificador multiplicador;
    private List<Modificador> modificadores;

    @BeforeEach
    public void setUpClass() {
        multiplicador = new Multiplicador(2);
        Nulo nulo = new Nulo();
        Anulador anulador = new Anulador();
        Exclusividad exclusividad = new Exclusividad();
        modificadores = new ArrayList<>();
        modificadores.add(multiplicador);
        modificadores.add(exclusividad);
        modificadores.add(anulador);
        modificadores.add(nulo);

        jugador = new Jugador("Jugador 1", modificadores);
    }

    @Test
    public void test01JugadorNuevoNoTienePuntos() {
        //Assert
        assertEquals(0, jugador.obtenerPuntaje());
    }

    @Test
    public void test02SumarPuntajeSumaLosPuntosAsignados() {
        //Act
        jugador.sumarPuntaje(2);

        //Assert
        assertEquals(2, jugador.obtenerPuntaje());
    }

    @Test
    public void test03UsarUnModificadorNoNuloRemueveDeLaListaDeModificadoresDelJugador() {
        //Act
        jugador.usar(multiplicador);

        //Assert
        assertEquals(3, modificadores.size());
    }

    @Test
    public void test04UsarUnModificadorNuloNoLoRemueveDeLaListaDeModificadoresDelJugador() {
        //Arrange
        Nulo nulo = new Nulo();

        //Act
        jugador.usar(nulo);

        //Assert
        assertEquals(4, modificadores.size());
    }

    @Test
    public void test05UsarUnModificadorExclusividadLoRemueveDeLaListaDeModificadoresDelJugador() {
        //Arrange
        Exclusividad exclusividad = new Exclusividad();

        //Act
        jugador.usar(exclusividad);
        jugador.usar(exclusividad);

        //Assert
        assertEquals(3, modificadores.size());
    }

    @Test
    public void test06UsarUnModificadorAnuladorLoRemueveDeLaListaDeModificadoresDelJugador() {
        //Arrange
        Anulador anulador = new Anulador();

        //Act
        jugador.usar(anulador);

        //Assert
        assertEquals(3, modificadores.size());
    }

    @Test
    public void test07UsarUnModificadorQueNoEstaEnLaListaLanzaExcepcion() {
        //Arrange
        Anulador anulador = new Anulador();

        //Act
        jugador.usar(anulador);

        //Assert

        ModificadorInexistenteException thrown = Assertions.assertThrows(ModificadorInexistenteException.class, () -> {
            jugador.usar(anulador);
        });

        Assertions.assertEquals("El jugador Jugador 1 no posee el modificador usado.", thrown.getMessage());
    }
}


