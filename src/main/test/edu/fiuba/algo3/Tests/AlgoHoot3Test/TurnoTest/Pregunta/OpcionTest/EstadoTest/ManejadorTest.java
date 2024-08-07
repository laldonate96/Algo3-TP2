package edu.fiuba.algo3.Tests.AlgoHoot3Test.TurnoTest.Pregunta.OpcionTest.EstadoTest;

import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Estado;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManejadorTest {

    @Test
    public void test01CorectaDevuelveQueEsCorrecta() {
        //Arrange
        Estado estado = new Correcta();
        //Assert
        assertEquals(estado.contarCorrecta(), 1);
        assertEquals(estado.contarIncorrecta(), 0);
    }

    @Test
    public void test02IncorrectaDevuelveQueEsIncorrecta() {
        //Arrange
        Estado estado = new Incorrecta();
        //Assert
        assertEquals(estado.contarIncorrecta(), 1);
        assertEquals(estado.contarCorrecta(), 0);
    }
}
