package edu.fiuba.algo3.testEntrega2;

import edu.fiuba.algo3.modelo.estado.Correcta;
import edu.fiuba.algo3.modelo.estado.Incorrecta;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.Ordered;
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
    public void test05AceptaVisitaDeUnaOpcionSimpleConElMismoTextoYDevuelveTrue(){
        //Arrange
        Simple opcionVisitor = new Simple("Opcion 1", new Correcta());
        //Assert
        assertTrue(opcionCorrecta.aceptar(opcionVisitor));
    }

    @Test
    public void test06AceptaVisitaDeUnaOpcionSimpleConDistintoTextoYDevuelveFalse(){
        //Arrange
        Simple opcionVisitor = new Simple("Verdaderont", new Correcta());
        //Assert
        assertFalse(opcionCorrecta.aceptar(opcionVisitor));
    }

    @Test
    public void test07VisitaAUnaOpcionSimpleConElMismoTextoYDevuelveTrue(){
        //Arrange
        Simple opcionCorrecta2 = new Simple("Opcion 1", new Correcta());
        //Assert
        assertTrue(opcionCorrecta.visitar(opcionCorrecta2));
    }

    @Test
    public void test08VisitaAUnaOpcionSimpleConDistintoTextoYDevuelveFalse(){
        //Arrange
        Simple opcionDistintoTexto = new Simple("Opcion 1n't", new Correcta());
        //Assert
        assertFalse(opcionCorrecta.visitar(opcionDistintoTexto));
    }

    @Test
    public void test09VisitaAOpcionNoSimpleYDevuelveFalse(){
        //Arrange
        Ordered opcionOrdered = new Ordered("Verdadero", 1, new Correcta());
        //Assert
        assertFalse(opcionCorrecta.visitar(opcionOrdered));
    }
}
