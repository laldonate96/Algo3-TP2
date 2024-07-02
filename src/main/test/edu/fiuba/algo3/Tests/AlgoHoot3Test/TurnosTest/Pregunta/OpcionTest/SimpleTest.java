package edu.fiuba.algo3.Tests.AlgoHoot3Test.TurnosTest.Pregunta.OpcionTest;

import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.opcion.Simple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {
    private Simple opcion1Correcta;
    private Simple opcion1Incorrecta;

    @BeforeEach
    public void setUpClass() {
        opcion1Correcta = new Simple("Opcion 1", new Correcta());
        opcion1Incorrecta = new Simple("Opcion 1", new Incorrecta());
    }

    @Test
    public void test01SiSeleAsignaEstadoCorrectaEsCorrecta() {
        //Assert
        assertEquals(1, opcion1Correcta.contarCorrecta());
        assertEquals(0, opcion1Correcta.contarIncorrecta());
    }

    @Test
    public void test02SiSeleAsignaEstadoIncorrectaEsIncorrecta() {
        //Assert
        assertEquals(0, opcion1Incorrecta.contarCorrecta());
        assertEquals(1, opcion1Incorrecta.contarIncorrecta());
    }

    @Test
    public void test03CambiarElEstadoAUnaCorrectaConUnaIncorrectaIgualEstableceElEstadoIncorrecta() {
        opcion1Incorrecta.actualizarEstado(opcion1Correcta);

        assertEquals(0, opcion1Correcta.contarCorrecta());
        assertEquals(1, opcion1Correcta.contarIncorrecta());

    }
    @Test
    public void test04CambiarElEstadoAUnaIncorrectaConUnaCorrectaIgualEstableceElEstadoCorrecto() {

        opcion1Correcta.actualizarEstado(opcion1Incorrecta);


        assertEquals(1, opcion1Incorrecta.contarCorrecta());
        assertEquals(0, opcion1Incorrecta.contarIncorrecta());

    }
    @Test
    public void test04CambiarElEstadoAUnaIncorrectaDifenrenteNoLoCambia() {
        Simple opcion2Incorrecta = new Simple("Opcion 2", new Incorrecta());

        opcion1Correcta.actualizarEstado(opcion2Incorrecta);

        assertEquals(0, opcion2Incorrecta.contarCorrecta());
        assertEquals(1, opcion2Incorrecta.contarIncorrecta());
    }
    @Test
    public void test05CambiarElEstadoAUnaCorrectaDifenrenteNoLoCambia() {
        Simple opcion2Correcta = new Simple("Opcion 2", new Correcta());
        opcion1Incorrecta.actualizarEstado(opcion2Correcta);
        assertEquals(1, opcion2Correcta.contarCorrecta());
        assertEquals(0, opcion2Correcta.contarIncorrecta());
    }



}
