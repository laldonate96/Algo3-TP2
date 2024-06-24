package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class JugadorTest {
    private Jugador jugador;
    private ModificadorPuntaje multiplicador;
    private List<ModificadorPuntaje> modificadores;

    @BeforeEach
    public void setUpClass() {
        multiplicador = new Multiplicador(2);
        NuloPuntaje nulo = new NuloPuntaje();
        AnuladorPuntaje anulador = new AnuladorPuntaje();
        ExclusividadPuntaje exclusividad = new ExclusividadPuntaje();
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
        NuloPuntaje nulo = new NuloPuntaje();

        //Act
        jugador.usar(nulo);

        //Assert
        assertEquals(4, modificadores.size());
    }

    @Test
    public void test05UsarUnModificadorExclusividadLoRemueveDeLaListaDeModificadoresDelJugador() {
        //Arrange
        ExclusividadPuntaje exclusividad = new ExclusividadPuntaje();

        //Act
        jugador.usar(exclusividad);
        jugador.usar(exclusividad);

        //Assert
        assertEquals(3, modificadores.size());
    }

    @Test
    public void test06UsarUnModificadorAnuladorLoRemueveDeLaListaDeModificadoresDelJugador() {
        //Arrange
        AnuladorPuntaje anulador = new AnuladorPuntaje();

        //Act
        jugador.usar(anulador);

        //Assert
        assertEquals(3, modificadores.size());
    }
}


