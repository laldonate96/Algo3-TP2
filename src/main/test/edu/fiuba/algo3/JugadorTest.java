package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Multiplicador;
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
    private Modificador modificador;
    private List<Modificador> modificadores;
    private List<Opcion> opciones;
    private Opcion opcion;

    @BeforeEach
    public void setUpClass() {
        modificador = new Multiplicador(2);
        modificadores = new ArrayList<>();
        modificadores.add(modificador);
        opcion = new Simple("Opcion 1", new Incorrecta());
        opciones = new ArrayList<>();
        opciones.add(opcion);

        jugador = new Jugador("Jugador 1", modificadores);
    }

    @Test
    public void test01SumarPuntajeAUnJugadorSumaLosPuntosCorrectamente() {
        jugador.sumarPuntaje(2);

        assertEquals(2, jugador.obtenerPuntaje());
    }

    @Test
    public void test02UsarUnModificadorNoNuloRemueveDeLaListaDeModificadoresDelJugador() {
        jugador.responder(opciones, opciones, modificador);

        assertEquals(0, modificadores.size());
    }

}

