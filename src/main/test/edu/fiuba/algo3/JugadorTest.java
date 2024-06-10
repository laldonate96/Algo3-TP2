package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Multiplicador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class JugadorTest {
    private Jugador jugador;
    private Modificador modificador;
    private List<Modificador> modificadores;

    @BeforeEach
    public void setUpClass() {
        modificador = new Multiplicador(2);
        modificadores = new ArrayList<>();
        modificadores.add(modificador);

        jugador = new Jugador("Jugador 1", modificadores);
    }

    @Test
    public void test01SumarPuntajeAUnJugadorSumaLosPuntosCorrectamente() {
        jugador.sumarPuntaje(2);

        assertEquals(2, jugador.obtenerPuntaje());
    }
}
