package edu.fiuba.algo3.TestEntrega2.ModificadorPuntajeTest;


import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.NuloPuntaje;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NuloPuntajeTest {


    private ModificadorPuntaje nulo;
    private List<ModificadorPuntaje> modificadores;


    @BeforeEach
    public void setUp() {
        nulo = new NuloPuntaje();
        modificadores = new ArrayList<>();
        modificadores.add(nulo);
    }



    @Test
    public void test01NoSeUsaYNoSeBorra() {
        //Act

        nulo.actualizar(modificadores);

        //Assert
        assertEquals(1, modificadores.size());
    }

    @Test
    public void test02SeUsaVariasVecesYNoSeBorra() {
        //Act
        nulo.usar();
        nulo.usar();
        nulo.usar();
        nulo.usar();
        nulo.actualizar(modificadores);

        //Assert
        assertEquals(1, modificadores.size());
    }

    @Test
    public void test03NoModificaPuntaje() {
        //Arrange
        int puntajeEsperado=14;
        //Act
        int puntajeObtenido = nulo.modificarPuntaje(14);

        //Assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }


}
