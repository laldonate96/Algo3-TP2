package edu.fiuba.algo3.Tests.FabricasTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Modificador.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FabricaModificadoresTest {

    @Test
    public void test01CrearUnaListaDeModificadoresContieneLosAdecuados(){
        //Act
        List<Modificador> modificadores = FabricaModificadores.crearListaModificadores();

        //Assert
        assertEquals(6, modificadores.size());
        assertTrue(modificadores.get(0) instanceof Nulo);
        assertTrue(modificadores.get(1) instanceof Multiplicador);
        assertTrue(((Multiplicador) modificadores.get(1)).tieneFactor(2));
        assertTrue(modificadores.get(2) instanceof Multiplicador);
        assertTrue(((Multiplicador) modificadores.get(2)).tieneFactor(3));
        assertTrue(modificadores.get(3) instanceof Exclusividad);
        assertTrue(modificadores.get(4) instanceof Exclusividad);
        assertTrue(modificadores.get(5) instanceof Anulador);

    }
}
