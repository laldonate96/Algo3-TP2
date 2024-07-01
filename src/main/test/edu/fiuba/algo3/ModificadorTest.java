package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Multiplicador;
import edu.fiuba.algo3.modelo.modificador.Nulo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ModificadorTest {

    private Opcion opcion1;
    private Opcion opcion2;
    private Modificador multiplicadorDos;
    private Modificador multiplicadorTres;
    private Modificador nulo;
    private List<Modificador> modificadores;


    @BeforeEach
    public void setUp() {
        multiplicadorDos = new Multiplicador(2);
        multiplicadorTres = new Multiplicador(3);
        nulo = new Nulo();
        modificadores = new ArrayList<>();
        modificadores.add(multiplicadorDos);
        modificadores.add(multiplicadorTres);
        modificadores.add(nulo);
    }


    @Test
    public void test05UnMultiplicadorSeUsaYNoTieneMasUsos() {
        //Act
        multiplicadorDos.usar();
        multiplicadorDos.actualizar(modificadores);

        //Assert
        assertEquals(2, modificadores.size());
    }

    @Test
    public void test06MultiplicadorModificaPuntajeDeManeraEsperada() {
        //Arrange
        int puntajeEsperado=14*2;
        //Act
        int puntajeObtenido = multiplicadorDos.modificarPuntaje(14);

        //Assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void test07MultiplicadorConOtroFactorModificaPuntajeDeManeraEsperada() {
        //Arrange
        int puntajeEsperado=14*3;
        //Act
        int puntajeObtenido = multiplicadorTres.modificarPuntaje(14);

        //Assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void test11UnNuloSeUsaYTieneMasUsos() {
        //Act
        nulo.usar();
        nulo.actualizar(modificadores);

        //Assert
        assertEquals(3, modificadores.size());
    }

    @Test
    public void test12UnNuloSeUsaVariasVecesYTieneMasUsos() {
        //Act
        nulo.usar();
        nulo.usar();
        nulo.usar();
        nulo.usar();
        nulo.actualizar(modificadores);

        //Assert
        assertEquals(3, modificadores.size());
    }

    @Test
    public void test13UnNuloModificaPuntajeDeManeraEsperada() {
        //Arrange
        int puntajeEsperado=14;
        //Act
        int puntajeObtenido = nulo.modificarPuntaje(14);

        //Assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }


}
