package edu.fiuba.algo3.testEntrega3.LectorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import edu.fiuba.algo3.modelo.lector.mezclador.MezclaSinRepetirCategoria;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

public class LectorTest {
    @Test
    public void test01LectorLeeCorrectamenteArchivoJson() {
        List<Pregunta> preguntas = Lector.obtenerPreguntasDeJson(new MezclaSinRepetirCategoria());
        assertEquals(25, preguntas.size());
    }
}