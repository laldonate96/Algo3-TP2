package edu.fiuba.algo3.testEntrega2.Pregunta;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Incorrecta;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificador.Nulo;
import edu.fiuba.algo3.modelo.opciones.opcion.Grupo;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.pregunta.GroupChoice;

public class GroupChoiceTest {
    private Jugador jugador1;
    private Jugador jugador2;
    private Opcion opcion1Correcta;
    private Opcion opcion2Correcta;
    private Opcion opcion3Correcta;
    private Opcion opcion1CorrectaSinValidar;
    private Opcion opcion2CorrectaSinValidar;
    private Opcion opcion3CorrectaSinValidar;
    private Opcion opcion1Incorrecta;
    private Opcion opcion2Incorrecta;
    private Opcion opcion3Incorrecta;
    private static Clasica clasica;
    private Grupo mamifero;
    private Grupo pez;
    private Grupo grupo3;
    private ModificadorPuntaje modificadorPuntaje;
    private List<ModificadorPuntaje> modificadores;

    @BeforeAll
    public static void setUpClass() {
        clasica = new Clasica(3);
    }

    @BeforeEach
    public void setUp() {
        modificadorPuntaje = new Nulo();
        modificadores = new ArrayList<>();
        modificadores.add(modificadorPuntaje);
        jugador1 = new Jugador("Jugador 1", modificadores);
        jugador2 = new Jugador("Jugador 2", modificadores);



        opcion1Correcta = new Grupo("Gato", "Mamifero", new Correcta());
        opcion2Correcta = new Grupo("Perro", "Mamifero", new Correcta());
        opcion3Correcta = new Grupo("Tiburon", "Pez", new Correcta());

        opcion1CorrectaSinValidar = new Grupo("Gato", "Mamifero", new Incorrecta());
        opcion2CorrectaSinValidar = new Grupo("Perro", "Mamifero", new Incorrecta());
        opcion3CorrectaSinValidar = new Grupo("Tiburon", "Pez", new Incorrecta());

        opcion1Incorrecta=new Grupo("Sapo", "Mamifero", new Incorrecta());
        opcion2Incorrecta= new Grupo("Perro", "Pez", new Incorrecta());
        opcion1Incorrecta=new Grupo("Gato", "Lagarto", new Incorrecta());

    }


    @Test
    public void test01GroupChoiceAsignaPuntajeCorrectoAJugadorQueRespondeCorrectamente(){
        //Arrange
        List<Opcion> opcionesPregunta = Arrays.asList(opcion1Correcta, opcion2Correcta, opcion3Correcta);

        Pregunta pregunta = new GroupChoice(
                "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesPregunta,
                clasica,
                "Animales"
        );


        Respuesta respuesta2 = jugador2.responder(Arrays.asList(opcion1CorrectaSinValidar, opcion2CorrectaSinValidar, opcion3CorrectaSinValidar),opcionesPregunta, modificadorPuntaje);
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta2);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test02Asigna0PuntosAJugadorQueRespondeConUnaIncorrecta() {
        //Arrange
        List<Opcion> opcionesPregunta = Arrays.asList(opcion1Correcta, opcion2Correcta, opcion3Correcta);

        Pregunta pregunta = new GroupChoice(
                "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesPregunta,
                clasica,
                "Animales"
        );
        Respuesta respuesta1 = jugador1.responder(Arrays.asList(opcion2Incorrecta), opcionesPregunta, modificadorPuntaje);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert

        assertEquals(0, jugador1.obtenerPuntaje());

    }
    @Test
    public void test03Asigna0PuntosAJugadorQueRespondeConUnaIncorrectaYDosCorrectas() {
        //Arrange
        List<Opcion> opcionesPregunta = Arrays.asList(opcion1Correcta, opcion2Correcta, opcion3Correcta);

        Pregunta pregunta = new GroupChoice(
                "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesPregunta,
                clasica,
                "Animales"
        );
        Respuesta respuesta1 = jugador1.responder(Arrays.asList(opcion1Correcta,opcion2Incorrecta,opcion3Correcta), opcionesPregunta, modificadorPuntaje);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert

        assertEquals(0, jugador1.obtenerPuntaje());

    }
    @Test
    public void test04Asigna0PuntosAJugadorQueRespondeConDosCorrectasSiendo3Opciones() {
        //Arrange
        List<Opcion> opcionesPregunta = Arrays.asList(opcion1Correcta, opcion2Correcta, opcion3Correcta);

        Pregunta pregunta = new GroupChoice(
                "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesPregunta,
                clasica,
                "Animales"
        );
        Respuesta respuesta1 = jugador1.responder(Arrays.asList(opcion1Correcta,opcion2Correcta), opcionesPregunta, modificadorPuntaje);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta1);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert

        assertEquals(0, jugador1.obtenerPuntaje());

    }
}