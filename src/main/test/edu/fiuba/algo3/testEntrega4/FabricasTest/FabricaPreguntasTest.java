package edu.fiuba.algo3.testEntrega4.FabricasTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Fabricas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.opcion.Grupal;

import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.pregunta.*;

import edu.fiuba.algo3.modelo.puntaje.Clasica;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FabricaPreguntasTest {

    @Test
    public void test01CrearPreguntaVOF(){
        //Arrange
        List<String> contenidoOpciones = List.of("Verdadero", "Falso");
        List<String> posicionesDeCorrectas = List.of("1");
        List<Simple> opciones = FabricaOpciones.crearListaSimple(contenidoOpciones, posicionesDeCorrectas, new Correcta());

        //Act
        VerdaderoFalso preguntaObtenida =(VerdaderoFalso) FabricaPreguntas.crearPreguntaVerdaderoFalso("¿Grupo 1 aprueba el TP?", opciones, new Clasica(1), "test","Say no More");

        //Assert
        assertEquals("test", preguntaObtenida.obtenerCategoria());
        assertEquals("¿Grupo 1 aprueba el TP?", preguntaObtenida.obtenerEnunciado());
        assertTrue(opciones.get(0).equals(preguntaObtenida.obtenerOpciones().get(0)));
        assertTrue(opciones.get(1).equals(preguntaObtenida.obtenerOpciones().get(1)));
    }

    @Test
    public void test02CrearPreguntaMultipleChoice(){
        //Arrange
        List<String> contenidoOpciones = List.of("Jose", "Maria", "Listorti");
        List<String> posicionesDeCorrectas = List.of("1", "2");
        List<Simple> opciones = FabricaOpciones.crearListaSimple(contenidoOpciones, posicionesDeCorrectas, new Correcta());

        //Act
        MultipleChoice preguntaObtenida = FabricaPreguntas.crearPreguntaMultipleChoice("Nombres de personajes biblicos", opciones, new Clasica(2), "test","Say no More");

        //Assert
        assertEquals("test", preguntaObtenida.obtenerCategoria());
        assertEquals("Nombres de personajes biblicos", preguntaObtenida.obtenerEnunciado());
        assertEquals(3, preguntaObtenida.obtenerOpciones().size());
        assertTrue(opciones.get(0).equals(preguntaObtenida.obtenerOpciones().get(0)));
        assertTrue(opciones.get(1).equals(preguntaObtenida.obtenerOpciones().get(1)));
        assertTrue(opciones.get(2).equals(preguntaObtenida.obtenerOpciones().get(2)));
    }

    @Test
    public void test03CrearPreguntaGroup(){
        //Arrange
        List<String> grupos = List.of("par", "impar");
        List<String> contenidoOpciones = List.of("1","2","3", "4");
        List<String> posicionesCorrectas=List.of("2","4","0","1","3");
        List<Grupal> opciones = FabricaOpciones.crearListaGrupo(grupos, contenidoOpciones,posicionesCorrectas);

        //Act
        GroupChoice preguntaObtenida = (GroupChoice)FabricaPreguntas.crearPreguntaGroupChoice("Clasifique segun sea par o impar", opciones, new Clasica(1), "test","Say no More");

        //Assert
        assertEquals("test", preguntaObtenida.obtenerCategoria());
        assertEquals("Clasifique segun sea par o impar", preguntaObtenida.obtenerEnunciado());
        assertEquals(4, preguntaObtenida.obtenerOpciones().size());
        assertTrue(opciones.get(0).equals(preguntaObtenida.obtenerOpciones().get(0)));
        assertTrue(opciones.get(1).equals(preguntaObtenida.obtenerOpciones().get(1)));
        assertTrue(opciones.get(2).equals(preguntaObtenida.obtenerOpciones().get(2)));
        assertTrue(opciones.get(3).equals(preguntaObtenida.obtenerOpciones().get(3)));
    }

    @Test
    public void test04CrearPreguntaOrdered(){
        //Arrange
        List<String> opcionesOrdered = List.of("opcion1", "opcion2", "opcion3");
        List<Ordenada> opciones = FabricaOpciones.crearListaOrdenada(opcionesOrdered, List.of("1", "2", "3"), new Correcta());

        //Act
        OrderedChoice preguntaObtenida =(OrderedChoice) FabricaPreguntas.crearPreguntaOrderedChoice("Ordene los siguientes numbers", opciones, new Clasica(1), "test","Say no More");

        //Assert
        assertEquals("test", preguntaObtenida.obtenerCategoria());
        assertEquals("Ordene los siguientes numbers", preguntaObtenida.obtenerEnunciado());
        assertEquals(3, preguntaObtenida.obtenerOpciones().size());
        assertTrue(opciones.get(0).equals(preguntaObtenida.obtenerOpciones().get(0)));
        assertTrue(opciones.get(1).equals(preguntaObtenida.obtenerOpciones().get(1)));
        assertTrue(opciones.get(2).equals(preguntaObtenida.obtenerOpciones().get(2)));
    }
}
