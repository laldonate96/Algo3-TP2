package edu.fiuba.algo3.TestEntrega2.Pregunta.EstadoTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Fabricas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class ManejarMultipleCTest {
    private static List<Simple> opcionesPregunta;
    private MultipleChoice pregunta;

    @BeforeAll
    public static void setupClass() {
        List<String> contenidoOpciones = List.of("Si", "Obvio", "No");
        List<String> posicionesDeCorrectas = List.of("1", "2");
        opcionesPregunta = FabricaOpciones.crearListaSimple(contenidoOpciones, posicionesDeCorrectas, new Correcta());
    }

    @BeforeEach
    public void SetUp(){
         pregunta = FabricaPreguntas.crearPreguntaMultipleChoice("Grupo1 = aprobado?", opcionesPregunta, new ConPenalidad(), "Test", "No hay polqué");
    }

    @Test
    public void test01ManejadorRecibeOpcionesCorrectasYLasValidaCorrectamente(){
        List<String> stringsContenido = List.of("Si", "Obvio");
        List<String> stringsPosiciones = List.of("1", "2");
        List<Opcion> opciones = new ArrayList<>(FabricaOpciones.crearListaSimple(stringsContenido, stringsPosiciones, new Incorrecta()));
        pregunta.validarOpciones(opciones);

        assertEquals(1, opciones.get(0).contarCorrecta());
        assertEquals(1, opciones.get(1).contarCorrecta());
        assertEquals(0, opciones.get(0).contarIncorrecta());
        assertEquals(0, opciones.get(1).contarIncorrecta());
    }

    @Test
    public void test02ManejadorRecibeOpcionesIncorrectasYLasValidaCorrectamente(){
        List<String> stringsContenido = List.of("No");
        List<String> stringsPosiciones = List.of("3");
        List<Opcion> opciones = new ArrayList<>(FabricaOpciones.crearListaSimple(stringsContenido, stringsPosiciones, new Incorrecta()));

        pregunta.validarOpciones(opciones);

        assertEquals(0, opciones.get(0).contarCorrecta());
        assertEquals(1, opciones.get(0).contarIncorrecta());
    }

    @Test
    public void test03ManejadorRecibeOpcionesCorrectasEIncorrectasYLasValidaCorrectamente(){
        List<String> stringsContenido = List.of("Si", "Obvio", "No");
        List<String> stringsPosiciones = List.of("1", "2", "3");
        List<Opcion> opciones = new ArrayList<>(FabricaOpciones.crearListaSimple(stringsContenido, stringsPosiciones, new Incorrecta()));

        pregunta.validarOpciones(opciones);

        assertEquals(1, opciones.get(0).contarCorrecta());
        assertEquals(1, opciones.get(1).contarCorrecta());
        assertEquals(0, opciones.get(2).contarCorrecta());
        assertEquals(0, opciones.get(0).contarIncorrecta());
        assertEquals(0, opciones.get(1).contarIncorrecta());
        assertEquals(1, opciones.get(2).contarIncorrecta());
    }
}
