package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.grupo.Grupo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrupoTest { 
    @Test
    public void test01DosGruposSonIgualesSiCompartenElMismoNombre() {
        Grupo grupo1 = new Grupo("Grupo 1");
        Grupo grupo2 = new Grupo("Grupo 1");

        assertEquals(true, grupo1.equals(grupo2));
    }
}
