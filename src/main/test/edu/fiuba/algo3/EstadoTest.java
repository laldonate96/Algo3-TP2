package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.opciones.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Estado;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Incorrecta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EstadoTest { 
    @Test
    public void test01CorectaDevuelveQueEsCorrecta() {
        //Arrange
        Estado estado = new Correcta();
        //Assert
        assertTrue(estado.esCorrecta());
    }

    @Test
    public void test02IncorrectaDevuelveQueEsIncorrecta() {
        //Arrange
        Estado estado = new Incorrecta();
        //Assert
        assertFalse(estado.esCorrecta());
    }
}
