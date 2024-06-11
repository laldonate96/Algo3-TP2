package edu.fiuba.algo3.testEntrega2;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.estado.Correcta;
import edu.fiuba.algo3.modelo.estado.Incorrecta;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Nulo;
import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Opcion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.pregunta.GroupChoice;

public class GrupoChoiceTest {
    private Jugador jugador1;
    private Jugador jugador2;
    private Opcion opcion1Jugador1;
    private Opcion opcion2Jugador1;
    private Opcion opcion3Jugador1;
    private Opcion opcion1Jugador2;
    private Opcion opcion2Jugador2;
    private Opcion opcion3Jugador2;
    private static Clasica clasica;
    private Opcion opcion1Correcta;
    private Opcion opcion2Correcta;
    private Opcion opcion3Correcta;
    private Grupo mamifero;
    private Grupo pez;
    private Grupo grupo3;
    private Modificador modificador;
    private List<Modificador> modificadores;

    @BeforeAll
    public static void setUpClass() {
        clasica = new Clasica();
    }

    @BeforeEach
    public void setUp() {
        modificador = new Nulo();
        modificadores = new ArrayList<>();
        modificadores.add(modificador);
        jugador1 = new Jugador("Jugador 1", modificadores);
        jugador2 = new Jugador("Jugador 2", modificadores);



        opcion1Jugador1 = new Grupo("Gato", "Mamifero", new Incorrecta());
        opcion2Jugador1 = new Grupo("Perro", "Pez", new Incorrecta());
        opcion3Jugador1 = new Grupo("Tiburon", "Mamifero", new Incorrecta());
        opcion1Jugador2 = new Grupo("Gato", "Mamifero", new Incorrecta());
        opcion2Jugador2 = new Grupo("Perro", "Mamifero", new Incorrecta());
        opcion3Jugador2 = new Grupo("Tiburon", "Pez", new Incorrecta());
        opcion1Correcta = new Grupo("Gato", "Mamifero", new Correcta());
        opcion2Correcta = new Grupo("Perro", "Mamifero", new Correcta());
        opcion3Correcta = new Grupo("Tiburon", "Pez", new Correcta());
    }

    @Test
    public void test01GroupChoiceAsignaPuntajeCorrectoAJugadorQueRespondeIncorrectamente() {
        //Arrange
        List<Opcion> opcionesPregunta = Arrays.asList(opcion1Correcta, opcion2Correcta, opcion3Correcta);

        Pregunta pregunta = new GroupChoice(
            "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesPregunta,
            clasica
        );
        Respuesta respuesta1 = jugador1.responder(Arrays.asList(opcion1Jugador1, opcion2Jugador1, opcion3Jugador1),opcionesPregunta, modificador);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, jugador1.obtenerPuntaje());
    }

    @Test
    public void test02GroupChoiceAsignaPuntajeCorrectoAJugadorQueRespondeCorrectamente(){
        //Arrange
        List<Opcion> opcionesPregunta = Arrays.asList(opcion1Correcta, opcion2Correcta, opcion3Correcta);

        Pregunta pregunta = new GroupChoice(
                "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesPregunta,
                clasica
        );


        Respuesta respuesta2 = jugador2.responder(Arrays.asList(opcion3Jugador2, opcion2Jugador2, opcion1Jugador2),opcionesPregunta, modificador);
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta2);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, jugador2.obtenerPuntaje());
    }
}
