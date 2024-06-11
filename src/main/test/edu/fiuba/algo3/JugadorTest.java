package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.estado.Incorrecta;
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


//    modificadores = new ArrayList<>();
//        modificadores.add(modificador1);
//        modificadores.add(modificador2);
//        modificadores.add(modificador3);
//
//    opcion1 = new Simple("Palomas", new Incorrecta());
//    opcion2 = new Simple("Aviones", new Incorrecta());


    @Test
    public void test01SumarPuntajeAUnJugadorSumaLosPuntosCorrectamente() {
        jugador.sumarPuntaje(2);

        assertEquals(2, jugador.obtenerPuntaje());
    }

@Test
public void test01UsarUnModificadorNoNuloRemueveDeLaListaDeModificadoresDelJugador() {

//        assertEquals(2, modificadores.size());
}

@Test
public void test02UsarUnModificadorNuloNoRemueveDeLaListaDeModificadoresDelJugador() {

//        assertEquals(3, modificadores.size());
}

@Test
public void test03UsarUnMultiplicadorNoTieneMasUsosLuegoDeUsarseUnaVez() {

//        assertEquals(false, modificador1.tieneUsos());
}
}

