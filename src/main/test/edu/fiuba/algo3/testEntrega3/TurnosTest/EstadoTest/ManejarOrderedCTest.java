package edu.fiuba.algo3.testEntrega3.TurnosTest.EstadoTest;

import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaNula;
import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.GroupChoice;
import edu.fiuba.algo3.modelo.pregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.turno.Estado.ManejarGroupChoice;
import edu.fiuba.algo3.modelo.turno.Estado.ManejarOrderedC;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManejarOrderedCTest {

    private static ManejarOrderedC manejadorOC;
    private static List<Pregunta> preguntasTest;

    @BeforeAll
    public static void setupClass(){
        preguntasTest = Lector.obtenerPreguntasDeJson(new MezclaNula(),("recursos/test.json"));
        manejadorOC = new ManejarOrderedC((OrderedChoice) preguntasTest.get(7));
    }

    @Test
    public void test01ManejadorRecibeOpcionesCorrectasYLasValidaCorrectamente(){
        Ordenada cobol = new Ordenada("COBOL", 1, new Incorrecta());
        Ordenada go = new Ordenada("Go", 6, new Incorrecta());
        Ordenada smalltalk = new Ordenada("Smalltalk", 2, new Incorrecta());
        Ordenada cpulsplus = new Ordenada("C++", 3, new Incorrecta());
        Ordenada java = new Ordenada("Java", 5, new Incorrecta());
        Ordenada python = new Ordenada("Python", 4, new Incorrecta());

        List<Opcion> opciones = List.of(cobol, go, smalltalk, cpulsplus, java, python);

        manejadorOC.validarOpciones(opciones);

        for (int i = 0; i < 6; i++) {
            assertEquals(1, opciones.get(i).contarCorrecta());
            assertEquals(0, opciones.get(i).contarIncorrecta());
        }
    }

    @Test
    public void test02ManejadorRecibeOpcionesIncorrectasYLasValidaCorrectamente(){
        Ordenada cobol = new Ordenada("COBOL", 2, new Incorrecta());
        Ordenada go = new Ordenada("Go", 4, new Incorrecta());
        Ordenada smalltalk = new Ordenada("Smalltalk", 6, new Incorrecta());
        Ordenada cpulsplus = new Ordenada("C++", 1, new Incorrecta());
        Ordenada java = new Ordenada("Java", 3, new Incorrecta());
        Ordenada python = new Ordenada("Python", 5, new Incorrecta());

        List<Opcion> opciones = List.of(cobol, go, smalltalk, cpulsplus, java, python);

        manejadorOC.validarOpciones(opciones);

        for (int i = 0; i < 6; i++) {
            assertEquals(0, opciones.get(i).contarCorrecta());
            assertEquals(1, opciones.get(i).contarIncorrecta());
        }
    }

    @Test
    public void test03ManejadorRecibeOpcionesCorrectasEIncorrectasYLasValidaCorrectamente(){
        Ordenada cobol = new Ordenada("COBOL", 1, new Incorrecta());
        Ordenada go = new Ordenada("Go", 6, new Incorrecta());
        Ordenada smalltalk = new Ordenada("Smalltalk", 2, new Incorrecta());
        Ordenada cpulsplus = new Ordenada("C++", 4, new Incorrecta());
        Ordenada java = new Ordenada("Java", 3, new Incorrecta());
        Ordenada python = new Ordenada("Python", 5, new Incorrecta());

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