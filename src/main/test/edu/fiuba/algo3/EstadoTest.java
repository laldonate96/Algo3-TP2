package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.estado.Correcta;
import edu.fiuba.algo3.modelo.estado.Incorrecta;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstadoTest { 
    @Test
    public void test01UnEstadoDevuelveTrueOFalseDependiendoSiEsCorrectaOIncorrectaUnaOpcion() {
        Opcion opcion1 = new Simple("Opcion 1", new Correcta());
        Opcion opcion2 = new Simple("Opcion 2", new Incorrecta());

        assertEquals(true, opcion1.esCorrecta());
        assertEquals(false, opcion2.esCorrecta());
    }
}
