package edu.fiuba.algo3.testEntrega2;

import edu.fiuba.algo3.modelo.estado.Correcta;
import edu.fiuba.algo3.modelo.estado.Incorrecta;
import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordered;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderedTest {
    private Opcion opcionCorrecta;
    private Opcion opcionIncorrecta;

    @BeforeEach
    public void setUpClass() {
        opcionCorrecta = new Ordered("Opcion 1", 1, new Correcta());
        opcionIncorrecta = new Ordered("Opcion 1", 1, new Incorrecta());
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
    public void test05AceptaVisitaDeUnaOpcionOrderedConLaMismaPosicionYDevuelveTrue(){
        //Arrange
        Ordered opcionVisitor = new Ordered("Opcion 1", 1, new Correcta());
        //Assert
        assertTrue(opcionCorrecta.aceptar(opcionVisitor));
    }

    @Test
    public void test06AceptaVisitaDeUnaOpcionOrderedConDistintaPosicionYDevuelveFalse(){
        //Arrange
        Ordered opcionVisitor = new Ordered("Opcion 1", 3, new Correcta());
        //Assert
        assertFalse(opcionCorrecta.aceptar(opcionVisitor));
    }

    @Test
    public void test07VisitaAUnaOpcionOrderedConLaMismaPosicionYDevuelveTrue(){
        //Arrange
        Ordered opcionCorrecta2 = new Ordered("Opcion 1", 1, new Correcta());
        //Assert
        assertTrue(opcionCorrecta.visitar(opcionCorrecta2));
    }

    @Test
    public void test08VisitaAUnaOpcionOrderedConDistintoTextoYDevuelveFalse(){
        //Arrange
        Ordered opcionDistintoTexto = new Ordered("Opcion 12", 1, new Correcta());
        //Assert
        assertFalse(opcionCorrecta.visitar(opcionDistintoTexto));
    }

    @Test
    public void test09VisitaAOpcionNoGrupoYDevuelveFalse(){
        //Arrange
        Grupo opcionGrupo = new Grupo("Verdadero", "Grupo 3", new Correcta());
        //Assert
        assertFalse(opcionCorrecta.visitar(opcionGrupo));
    }
}