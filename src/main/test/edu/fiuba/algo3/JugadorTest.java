package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Multiplicador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.NuloPuntaje;


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
        modificadores = new ArrayList<>();
        modificadores.add(multiplicador);
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
        assertEquals(1, modificadores.size());
    }
    @Test
    public void test04UsarUnModificadorNuloNoLoRemueveDeLaListaDeModificadoresDelJugador() {
        //Arrange
        NuloPuntaje nulo = new NuloPuntaje();

        //Act
        jugador.usar(nulo);

        //Assert
        assertEquals(2, modificadores.size());
    }

}


