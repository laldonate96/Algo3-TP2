package edu.fiuba.algo3.testEntrega2.ModificadorPuntajeTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Multiplicador;

public class MultiplicadorPuntajeTest {

    private ModificadorPuntaje multiplicadorDos;
    private ModificadorPuntaje multiplicadorTres;
    private List<ModificadorPuntaje> modificadores;


    @BeforeEach
    public void setUp() {
        multiplicadorDos = new Multiplicador(2);
        multiplicadorTres = new Multiplicador(3);

        modificadores = new ArrayList<>();
        modificadores.add(multiplicadorDos);
        modificadores.add(multiplicadorTres);

    }


    @Test
    public void test01UnMultiplicadorNoSeUsaYNoSeBorraAlActualizar() {
        //Act

        multiplicadorDos.actualizar(modificadores);

        //Assert
        assertEquals(2, modificadores.size());
    }

    @Test
    public void test02UnMultiplicadorSeUsaYSeBorraAlActualizar() {
        //Act
        multiplicadorDos.usar();
        multiplicadorDos.actualizar(modificadores);

        //Assert
        assertEquals(1, modificadores.size());
    }

    @Test
    public void test03MultiplicadorModificaPuntajeDeManeraEsperada() {
        //Arrange
        int puntajeEsperado=14*2;
        //Act
        int puntajeObtenido = multiplicadorDos.modificarPuntaje(14);

        //Assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void test04MultiplicadorConOtroFactorModificaPuntajeDeManeraEsperada() {
        //Arrange
        int puntajeEsperado=14*3;
        //Act
        int puntajeObtenido = multiplicadorTres.modificarPuntaje(14);

        //Assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}