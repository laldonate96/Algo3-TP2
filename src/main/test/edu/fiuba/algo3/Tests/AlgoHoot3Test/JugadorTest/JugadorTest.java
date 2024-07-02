package edu.fiuba.algo3.Tests.AlgoHoot3Test.JugadorTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Modificador.*;
import edu.fiuba.algo3.modelo.excepciones.ModificadorInexistenteException;
import edu.fiuba.algo3.modelo.jugador.Jugador;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class JugadorTest {
    private Jugador jugador;
    private Modificador multiplicador;
    private List<Modificador> modificadores;

    @BeforeEach
    public void setUpClass() {


        modificadores= FabricaModificadores.crearListaModificadores();
        multiplicador =modificadores.get(2);

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
        assertEquals(5, modificadores.size());
    }

    @Test
    public void test04UsarUnModificadorNuloNoLoRemueveDeLaListaDeModificadoresDelJugador() {
        //Arrange
        Modificador nulo = modificadores.get(0);

        //Act
        jugador.usar(nulo);

        //Assert
        assertEquals(6, modificadores.size());
    }

    @Test
    public void test05UsarLosModificadoresExclusividadLosRemueveDeLaListaDeModificadoresDelJugador() {
        //Arrange
        Modificador exclusividad = modificadores.get(3);
        Modificador exclusividad2 = modificadores.get(4);

        //Act21
        jugador.usar(exclusividad);
        jugador.usar(exclusividad2);

        //Assert
        assertEquals(4, modificadores.size());
    }

    @Test
    public void test07UsarUnModificadorQueNoEstaEnLaListaLanzaExcepcion() {
        //Arrange
        Modificador anulador = modificadores.get(5);

        //Act
        jugador.usar(anulador);

        //Assert

        ModificadorInexistenteException thrown = Assertions.assertThrows(ModificadorInexistenteException.class, () -> jugador.usar(anulador));

        Assertions.assertEquals("El jugador Jugador 1 no posee el modificador usado.", thrown.getMessage());
    }
}


