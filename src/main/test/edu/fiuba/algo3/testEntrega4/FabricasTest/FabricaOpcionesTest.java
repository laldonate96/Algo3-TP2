package edu.fiuba.algo3.testEntrega4.FabricasTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;

public class FabricaOpcionesTest {
    @Test
    public void test01FabricaOpciones(){
        List<String> opcionesOrdered = List.of("opcion1", "opcion2");

        List<Opcion> opciones = FabricaOpciones.crearListaGrupo(List.of("1", "2"), List.of(List.of("x", "y", "z"), List.of("a", "s", "d")), new Correcta());

        assertEquals(6, opciones.size());
    }
}
