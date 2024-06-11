package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.estado.Correcta;
import edu.fiuba.algo3.modelo.estado.Incorrecta;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Multiplicador;
import edu.fiuba.algo3.modelo.modificador.Nulo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModificadorTest {

    private Opcion opcion1;
    private Opcion opcion2;
    private Modificador modificador1;
    private Modificador modificador2;
    private Modificador modificador3;
    private List<Modificador> modificadores;


    @BeforeEach
    public void setUpClass() {
        modificador1 = new Multiplicador(2);
        modificador2 = new Multiplicador(3);
        modificador3 = new Nulo();

        modificadores = new ArrayList<>();
        modificadores.add(modificador1);
        modificadores.add(modificador2);
        modificadores.add(modificador3);



        opcion1 = new Simple("Palomas", new Incorrecta());
        opcion2 = new Simple("Aviones", new Incorrecta());
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
