package edu.fiuba.algo3.testEntrega2.ModificadorPuntajeTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.AnuladorPuntaje;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;

public class AnuladorPuntajeTest {

    private ModificadorPuntaje anulador;
    private List<ModificadorPuntaje> modificadores;


    @BeforeEach
    public void setUp() {
        anulador = new AnuladorPuntaje();
        modificadores = new ArrayList<>();
        modificadores.add(anulador);


    }


    @Test
    public void test01NoSeUsaYNoSeBorraAlActualizar() {
        //Act

        anulador.actualizar(modificadores);

        //Assert
        assertEquals(1, modificadores.size());
    }

    @Test
    public void test02SeUsaYSeBorraAlActualizar() {
        //Act
        anulador.usar();
        anulador.actualizar(modificadores);


        //Assert
        assertEquals(0, modificadores.size());
    }

    @Test
    public void test03NoModificaPuntaje() {
        //Arrange
        int puntajeEsperado=14;
        //Act
        int puntajeObtenido = anulador.modificarPuntaje(14);

        //Assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }


}