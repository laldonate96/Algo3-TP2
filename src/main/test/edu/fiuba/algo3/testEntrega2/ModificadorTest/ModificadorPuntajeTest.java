package edu.fiuba.algo3.testEntrega2.ModificadorTest;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Multiplicador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.NuloPuntaje;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ModificadorPuntajeTest {

    private ModificadorPuntaje multiplicadorDos;
    private ModificadorPuntaje multiplicadorTres;
    private ModificadorPuntaje nulo;
    private List<ModificadorPuntaje> modificadores;


    @BeforeEach
    public void setUp() {
        multiplicadorDos = new Multiplicador(2);
        multiplicadorTres = new Multiplicador(3);
        nulo = new NuloPuntaje();
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
