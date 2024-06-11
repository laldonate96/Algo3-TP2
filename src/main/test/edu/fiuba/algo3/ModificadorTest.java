package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Multiplicador;
import edu.fiuba.algo3.modelo.modificador.Nulo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}

    @Test
    public void test01UnMultiplicadorTieneUsos() {
        //Assert
        assertTrue(multiplicadorDos.tieneUsos());
    }

    @Test
    public void test02UnMultiplicadorEsIgualASiMismo() {
        //Assert
        assertTrue(multiplicadorDos.equals(multiplicadorDos));
    }

    @Test
    public void test03UnMultiplicadorEsIgualAOtroConMismoFactor() {
        //Arrange
        Multiplicador multiplicadorDos2=new Multiplicador(2);

        //Assert
        assertTrue(multiplicadorDos.equals(multiplicadorDos2));
    }


    // @Test
    // public void test04UnMultiplicadorNoEsIgualAOtroConDistintoFactor() {
    //     //Assert
    //     assertFalse(multiplicadorDos.equals(multiplicadorTres));
    // }

    @Test
    public void test05UnMultiplicadorSeUsaYNoTieneMasUsos() {
        //Act
        multiplicadorDos.usar();

        //Assert
        assertFalse(multiplicadorDos.tieneUsos());
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
    public void test08UnNuloTieneUsos() {
        //Assert
        assertTrue(nulo.tieneUsos());
    }

    @Test
    public void test09UnNuloEsIgualASiMismo() {
        //Assert
        assertTrue(nulo.equals(nulo));
    }

    @Test
    public void test10UnNuloEsIgualACualquierOtroNulo() {
        //Arrange
        Modificador nulo2 = new Nulo();
        //Assert
        assertTrue(nulo.equals(nulo2));
    }

    @Test
    public void test11UnNuloSeUsaYTieneMasUsos() {
        //Act
        nulo.usar();

        //Assert
        assertTrue(nulo.tieneUsos());
    }

    @Test
    public void test12UnNuloSeUsaVariasVecesYTieneMasUsos() {
        //Act
        nulo.usar();
        nulo.usar();
        nulo.usar();
        nulo.usar();

        //Assert
        assertTrue(nulo.tieneUsos());
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
