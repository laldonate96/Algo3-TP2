package edu.fiuba.algo3.TestEntrega2.Pregunta;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaNula;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoOFalsoTest {
    private static VerdaderoFalso pregunta;
    private VerdaderoFalso preguntaConPenalidad;

    @BeforeEach
    public void setUp(){
        List<String> contenidoOpciones = List.of("Verdadero", "Falso");
        List<String> posicionesDeCorrectas = List.of("2");
        List<Simple> opcionesPregunta = FabricaOpciones.crearListaSimple(contenidoOpciones, posicionesDeCorrectas, new Correcta());
         pregunta =new VerdaderoFalso("Grupo1 = aprobado?", opcionesPregunta, new Clasica(1), "Test", "Pregunta siemple.");
         preguntaConPenalidad =new VerdaderoFalso("El grupo 1 entrego el TP en tiempo y forma", opcionesPregunta, new ConPenalidad(), "Test", "Es canon");
    }

    @Test
    public void test01ManejadorRecibeOpcionesCorrectasYLasValidaCorrectamente(){
        List<String> stringsContenido = List.of("Falso");
        List<String> stringsPosiciones = List.of("2");
        List<Opcion> opciones = new ArrayList<>(FabricaOpciones.crearListaSimple(stringsContenido, stringsPosiciones, new Incorrecta()));

        pregunta.validarOpciones(opciones);

        assertEquals(1, opciones.get(0).contarCorrecta());
        assertEquals(0, opciones.get(0).contarIncorrecta());
    }

    @Test
    public void test02ManejadorRecibeOpcionesIncorrectasYLasValidaCorrectamente(){
        List<String> stringsContenido = List.of("Verdadero");
        List<String> stringsPosiciones = List.of("1");
        List<Opcion> opciones = new ArrayList<>(FabricaOpciones.crearListaSimple(stringsContenido, stringsPosiciones, new Incorrecta()));

        pregunta.validarOpciones(opciones);

        assertEquals(0, opciones.get(0).contarCorrecta());
        assertEquals(1, opciones.get(0).contarIncorrecta());
    }
}
