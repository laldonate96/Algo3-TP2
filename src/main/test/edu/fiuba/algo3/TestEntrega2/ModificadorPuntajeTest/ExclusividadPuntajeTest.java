package edu.fiuba.algo3.TestEntrega2.ModificadorPuntajeTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExclusividadPuntajeTest {

    private Modificador exclusividad;
    private List<Modificador> modificadores;


    @BeforeEach
    public void setUp() {
        exclusividad = new Exclusividad();
        modificadores = new ArrayList<>();
        modificadores.add(exclusividad);


    }


    @Test
    public void test01NoSeUsaYNoSeBorraAlActualizar() {
        //Act
        exclusividad.actualizar(modificadores);

        //Assert
        assertEquals(1, modificadores.size());
    }

    @Test
    public void test02SeUsaYNoSeBorraAlActualizar() {
        //Act
        exclusividad.usar();
        exclusividad.actualizar(modificadores);


        //Assert
        assertEquals(1, modificadores.size());
    }
    @Test
    public void test03SeUsaDosVecesYSeBorraAlActualizar() {
        //Act
        exclusividad.usar();
        exclusividad.usar();
        exclusividad.actualizar(modificadores);


        //Assert
        assertEquals(0, modificadores.size());
    }

    @Test
    public void test04NoModificaPuntaje() {
        //Arrange
        int puntajeEsperado=14;
        //Act
        int puntajeObtenido = exclusividad.modificarPuntaje(14);

        //Assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }


}