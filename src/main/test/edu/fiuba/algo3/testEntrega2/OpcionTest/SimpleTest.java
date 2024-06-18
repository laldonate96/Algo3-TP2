package edu.fiuba.algo3.testEntrega2.OpcionTest;

import edu.fiuba.algo3.modelo.opciones.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.opciones.opcion.Simple;
import edu.fiuba.algo3.modelo.opciones.opcion.Ordenada;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {
    private Opcion opcionCorrecta;
    private Opcion opcionIncorrecta;

    @BeforeEach
    public void setUpClass() {
        opcionCorrecta = new Simple("Opcion 1", new Correcta());
        opcionIncorrecta = new Simple("Opcion 1", new Incorrecta());
    }

    @Test
    public void test01SiSeleAsignaEstadoCorrectaEsCorrecta() {
        //Assert
        assertTrue(opcionCorrecta.esCorrecta());
    }

    @Test
    public void test02SiSeleAsignaEstadoIncorrectaNoEsCorrecta() {
        //Assert
        assertFalse(opcionIncorrecta.esCorrecta());
    }

    @Test
    public void test03CambiarElEstadoConOtraCorrectaEstableceElEstadoCorrecto() {
        opcionIncorrecta.actualizarEstado(opcionCorrecta);

        assertTrue(opcionIncorrecta.esCorrecta());
    }
    @Test
    public void test04CambiarElEstadoConOtraIncorrectaEstableceElEstadoIncorrecto() {
        opcionCorrecta.actualizarEstado(opcionCorrecta);
        assertFalse(opcionIncorrecta.esCorrecta());
    }

    @Test
    public void test05EsIgualAOtraSimpleConElMismoTexto(){
        //Arrange
        Simple opcion = new Simple("Opcion 1", new Correcta());
        //Assert

        assertTrue(opcionCorrecta.equals(opcion));
    }

    @Test
    public void test06NoEsIgualAOtraSimpleConOtroTexto(){
        //Arrange
        Simple opcion = new Simple("Opcion 1n't", new Correcta());
        //Assert
        assertFalse(opcionCorrecta.equals(opcion));
    }


    @Test
    public void test07NoEsIgualAUnaOpcionNoSimple(){
        //Arrange
        Ordenada opcionNoSimple = new Ordenada("Opcion 1", 1, new Correcta());
        //Assert
        assertNotEquals(opcionCorrecta, opcionNoSimple);
    }
}
