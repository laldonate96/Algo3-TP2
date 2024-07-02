package edu.fiuba.algo3.testEntrega3.TurnosTest.EstadoTest;

import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaNula;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.pregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.turno.Estado.ManejarOrderedC;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManejarOrderedCTest {

    private static ManejarOrderedC manejadorOC;

    @BeforeAll
    public static void setupClass(){
        List<Pregunta> preguntasTest = Lector.obtenerPreguntasDeJson(new MezclaNula(), ("recursos/test.json"));
        manejadorOC = new ManejarOrderedC((OrderedChoice) preguntasTest.get(7));
    }

    @Test
    public void test01ManejadorRecibeOpcionesCorrectasYLasValidaCorrectamente(){
        Ordenada cobol = new Ordenada("COBOL", 1);
        Ordenada go = new Ordenada("Go", 6);
        Ordenada smalltalk = new Ordenada("Smalltalk", 2);
        Ordenada cpulsplus = new Ordenada("C++", 3);
        Ordenada java = new Ordenada("Java", 5);
        Ordenada python = new Ordenada("Python", 4);

        List<Opcion> opciones = List.of(cobol, go, smalltalk, cpulsplus, java, python);

        manejadorOC.validarOpciones(opciones);

        for (int i = 0; i < 6; i++) {
            assertEquals(1, opciones.get(i).contarCorrecta());
            assertEquals(0, opciones.get(i).contarIncorrecta());
        }
    }

    @Test
    public void test02ManejadorRecibeOpcionesIncorrectasYLasValidaCorrectamente(){
        Ordenada cobol = new Ordenada("COBOL", 2);
        Ordenada go = new Ordenada("Go", 4);
        Ordenada smalltalk = new Ordenada("Smalltalk", 6);
        Ordenada cpulsplus = new Ordenada("C++", 1);
        Ordenada java = new Ordenada("Java", 3);
        Ordenada python = new Ordenada("Python", 5);

        List<Opcion> opciones = List.of(cobol, go, smalltalk, cpulsplus, java, python);

        manejadorOC.validarOpciones(opciones);

        for (int i = 0; i < 6; i++) {
            assertEquals(0, opciones.get(i).contarCorrecta());
            assertEquals(1, opciones.get(i).contarIncorrecta());
        }
    }

    @Test
    public void test03ManejadorRecibeOpcionesCorrectasEIncorrectasYLasValidaCorrectamente(){
        Ordenada cobol = new Ordenada("COBOL", 1);
        Ordenada go = new Ordenada("Go", 6);
        Ordenada smalltalk = new Ordenada("Smalltalk", 2);
        Ordenada cpulsplus = new Ordenada("C++", 4);
        Ordenada java = new Ordenada("Java", 3);
        Ordenada python = new Ordenada("Python", 5);

        List<Opcion> opciones = List.of(cobol, go, smalltalk, cpulsplus, java, python);

        manejadorOC.validarOpciones(opciones);

        for (int i = 0; i < 6; i++) {
            if (i < 3){
                assertEquals(1, opciones.get(i).contarCorrecta());
                assertEquals(0, opciones.get(i).contarIncorrecta());
            } else {
                assertEquals(0, opciones.get(i).contarCorrecta());
                assertEquals(1, opciones.get(i).contarIncorrecta());
            }
        }
    }
}
