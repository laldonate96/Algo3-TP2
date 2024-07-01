package edu.fiuba.algo3.testEntrega3.TurnosTest.EstadoTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Fabricas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.turno.Estado.ManejarVoF;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManejarVoFTest {
    private static ManejarVoF manejadorVoF;

    @BeforeAll
    public static void setupClass(){
        List<String> contenidoOpciones = List.of("Verdadero", "Falso");
        List<String> posicionesDeCorrectas = List.of("1");
        List<Simple> opcionesPregunta = FabricaOpciones.crearListaSimple(contenidoOpciones, posicionesDeCorrectas, new Correcta());
        VerdaderoFalso pregunta = FabricaPreguntas.crearPreguntaVerdaderoFalso("Grupo1 = aprobado?", opcionesPregunta, new ConPenalidad(), "Test", "No hay polqué");
        manejadorVoF = new ManejarVoF(pregunta);
    }

    @Test
    public void test01ManejadorRecibeOpcionesCorrectasYLasValidaCorrectamente(){
        List<String> stringsContenido = List.of("Verdadero");
        List<String> stringsPosiciones = List.of("1");
        List<Opcion> opciones = new ArrayList<>(FabricaOpciones.crearListaSimple(stringsContenido, stringsPosiciones, new Incorrecta()));

        manejadorVoF.validarOpciones(opciones);

        assertEquals(1, opciones.get(0).contarCorrecta());
        assertEquals(0, opciones.get(0).contarIncorrecta());
    }

    @Test
    public void test02ManejadorRecibeOpcionesIncorrectasYLasValidaCorrectamente(){
        List<String> stringsContenido = List.of("Falso");
        List<String> stringsPosiciones = List.of("2");
        List<Opcion> opciones = new ArrayList<>(FabricaOpciones.crearListaSimple(stringsContenido, stringsPosiciones, new Incorrecta()));

        manejadorVoF.validarOpciones(opciones);

        assertEquals(0, opciones.get(0).contarCorrecta());
        assertEquals(1, opciones.get(0).contarIncorrecta());
    }
}
