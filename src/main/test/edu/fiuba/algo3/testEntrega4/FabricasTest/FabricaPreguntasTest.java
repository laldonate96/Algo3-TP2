package edu.fiuba.algo3.testEntrega4.FabricasTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Fabricas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.opcion.Grupal;

import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.*;

import edu.fiuba.algo3.modelo.puntaje.Clasica;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FabricaPreguntasTest {

    @Test
    public void test01CrearPreguntaVOF(){
        //Arrange
        List<String> contenidoOpciones = List.of("Verdadero", "Falso");
        List<String> posicionesDeCorrectas = List.of("1");
        List<Simple> opcionesEsperadas = FabricaOpciones.crearListaSimple(contenidoOpciones, posicionesDeCorrectas, new Incorrecta());
        List<Simple> opcionesPregunta = FabricaOpciones.crearListaSimple(contenidoOpciones, posicionesDeCorrectas, new Correcta());
        Simple opcionPregunta;
        Simple opcionEsperada;

        //Act
        VerdaderoFalso preguntaObtenida = FabricaPreguntas.crearPreguntaVerdaderoFalso("¿Grupo 1 aprueba el TP?", opcionesPregunta, new Clasica(1), "FELICIDAD","Say N0 More");
        opcionesPregunta=preguntaObtenida.obtenerOpciones();

        assertEquals("¿Grupo 1 aprueba el TP?",preguntaObtenida.obtenerEnunciado());
        assertEquals("FELICIDAD",preguntaObtenida.obtenerCategoria());
        assertEquals("Say N0 More",preguntaObtenida.obtenerExplicacion());


        //Assert
        for (int i = 0; i < 2; i++) {

            opcionPregunta = opcionesPregunta.get(i);

            opcionEsperada = opcionesEsperadas.get(i);
            opcionPregunta.actualizarEstado(opcionEsperada);
            if(i==0) {
                assertEquals(1, opcionEsperada.contarCorrecta());
                assertEquals(0, opcionEsperada.contarIncorrecta());

            } else {
                assertEquals(0, opcionEsperada.contarCorrecta());
                assertEquals(1, opcionEsperada.contarIncorrecta());

            }
        }
    }

    @Test
    public void test02CrearPreguntaMultipleChoice() {
        //Arrange
        List<String> contenidoOpciones = List.of("Jose", "Maria", "Listorti");
        List<String> posicionesDeCorrectas = List.of("1", "2");
        List<Simple> opcionesEsperadas = FabricaOpciones.crearListaSimple(contenidoOpciones, posicionesDeCorrectas, new Incorrecta());
        List<Simple> opcionesPregunta = FabricaOpciones.crearListaSimple(contenidoOpciones, posicionesDeCorrectas, new Correcta());
        Simple opcionPregunta;
        Simple opcionEsperada;


        //Act
        MultipleChoice preguntaObtenida = FabricaPreguntas.crearPreguntaMultipleChoice("Nombres de personajes biblicos", opcionesPregunta, new Clasica(2), "FICCION", "No te leas la biblia pibe");
        opcionesPregunta=preguntaObtenida.obtenerOpciones();

        //Assert
        assertEquals("FICCION", preguntaObtenida.obtenerCategoria());
        assertEquals("Nombres de personajes biblicos", preguntaObtenida.obtenerEnunciado());
        assertEquals("No te leas la biblia pibe",preguntaObtenida.obtenerExplicacion());

        assertEquals(3, preguntaObtenida.obtenerOpciones().size());


        for (int i = 0; i < 3; i++) {
            opcionPregunta = opcionesPregunta.get(i);
            opcionEsperada = opcionesEsperadas.get(i);
            opcionPregunta.actualizarEstado(opcionEsperada);
            if(i<2) {
                assertEquals(1, opcionEsperada.contarCorrecta());
                assertEquals(0, opcionEsperada.contarIncorrecta());

            } else {
                assertEquals(0, opcionEsperada.contarCorrecta());
                assertEquals(1, opcionEsperada.contarIncorrecta());

            }

        }
    }

    @Test
    public void test03CrearPreguntaGroup(){
        //Arrange
        List<String> grupos = List.of("par", "impar");
        List<String> contenidoOpciones = List.of("1","2","3", "4");
        List<String> posicionesCorrectas=List.of("2","4","0","1","3");
        List<Grupal> opcionesEsperadas = FabricaOpciones.crearListaGrupo(grupos, contenidoOpciones,posicionesCorrectas);
        List<Grupal> opcionesPregunta = FabricaOpciones.crearListaGrupo(grupos, contenidoOpciones,posicionesCorrectas);
        Grupal opcionPregunta;
        Grupal opcionEsperada;

        //Act
        GroupChoice preguntaObtenida = FabricaPreguntas.crearPreguntaGroupChoice("Clasifique segun sea par o impar", opcionesPregunta, new Clasica(1), "ANALISIS MATEMATICO V","¿Estudiaste?");

        //Assert
        assertEquals("ANALISIS MATEMATICO V", preguntaObtenida.obtenerCategoria());
        assertEquals("Clasifique segun sea par o impar", preguntaObtenida.obtenerEnunciado());
        assertEquals("¿Estudiaste?",preguntaObtenida.obtenerExplicacion());
        assertEquals(4, preguntaObtenida.obtenerOpciones().size());

        for (int i = 0; i < 4; i++) {
            opcionPregunta = opcionesPregunta.get(i);
            opcionEsperada = opcionesEsperadas.get(i);
            opcionPregunta.actualizarEstado(opcionEsperada);

            assertEquals(1, opcionEsperada.contarCorrecta());
            assertEquals(0, opcionEsperada.contarIncorrecta());

        }

    }

    @Test
    public void test04CrearPreguntaOrdered(){
        //Arrange
        List<String> opcionesOrdered = List.of("opcion1", "opcion2", "opcion3");
        List<Ordenada> opcionesEsperadas = FabricaOpciones.crearListaOrdenada(opcionesOrdered, List.of("1", "2", "3"));
        List<Ordenada> opcionesPregunta = FabricaOpciones.crearListaOrdenada(opcionesOrdered, List.of("1", "2", "3"));
        Ordenada opcionPregunta;
        Ordenada opcionEsperada;
        //Act
        OrderedChoice preguntaObtenida = FabricaPreguntas.crearPreguntaOrderedChoice("Ordene los siguientes numeritos", opcionesPregunta, new Clasica(1), "ALGEBRA IV","¿Estudiaste?");

        //Assert
        assertEquals("ALGEBRA IV", preguntaObtenida.obtenerCategoria());
        assertEquals("Ordene los siguientes numeritos", preguntaObtenida.obtenerEnunciado());
        assertEquals("¿Estudiaste?",preguntaObtenida.obtenerExplicacion());
        assertEquals(3, preguntaObtenida.obtenerOpciones().size());


        for (int i = 0; i < 3; i++) {
            opcionPregunta = opcionesPregunta.get(i);
            opcionEsperada = opcionesEsperadas.get(i);
            opcionPregunta.actualizarEstado(opcionEsperada);

            assertEquals(1, opcionEsperada.contarCorrecta());
            assertEquals(0, opcionEsperada.contarIncorrecta());

        }
    }
}
