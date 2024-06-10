package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.estado.Correcta;
import edu.fiuba.algo3.modelo.estado.Incorrecta;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpcionTest {
    private Opcion opcion1;
    private Opcion opcion2;

    @BeforeEach
    public void setUpClass() {
        opcion1 = new Simple("Verdadero", new Correcta());
        opcion2 = new Simple("Verdadero", new Incorrecta());
    }

    @Test
    public void test01CambiarElEstadoDeUnaOpcionEstableceElEstadoCorrecto() {
        opcion2.actualizarEstado(opcion1);

        assertEquals(true, opcion2.esCorrecta());
    }
}
