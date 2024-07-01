package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Multiplicador;
import edu.fiuba.algo3.modelo.modificador.Nulo;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.estado.Incorrecta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class JugadorTest {
    private Jugador jugador;
    private Modificador multiplicador;
    private List<Modificador> modificadores;
    private List<Opcion> opciones;
    private Opcion opcion;

    @BeforeEach
    public void setUpClass() {
        multiplicador = new Multiplicador(2);
        Nulo nulo = new Nulo();
        modificadores = new ArrayList<>();
        modificadores.add(multiplicador);
        modificadores.add(nulo);
        opcion = new Simple("Opcion 1", new Incorrecta());
        opciones = new ArrayList<>();
        opciones.add(opcion);

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
        jugador.responder(opciones, opciones, multiplicador);

        //Assert
        assertEquals(1, modificadores.size());
    }
    @Test
    public void test04UsarUnModificadorNuloNoLoRemueveDeLaListaDeModificadoresDelJugador() {
        //Arrange
        Nulo nulo = new Nulo();

        //Act
        jugador.responder(opciones, opciones, nulo);

        //Assert
        assertEquals(2, modificadores.size());
    }

}

