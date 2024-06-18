package edu.fiuba.algo3.testEntrega2.Pregunta;


import edu.fiuba.algo3.modelo.Respuestas.RespuestasConcretas;

import edu.fiuba.algo3.modelo.modificadores.Modificadores;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.fiuba.algo3.testEntrega2.mocks.GruposMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.pregunta.GroupChoice;

public class GroupChoiceTest {
    private Jugador jugador1;
    private Jugador jugador2;

    static List<String> grupos;
    static List<String> miembrosGrupo1;
    static List<String> miembrosGrupo2;
    private static Clasica clasica;
    private ModificadorPuntaje modificadorPuntaje;
    private List<ModificadorPuntaje> modificadores;
    private GruposMock opcionesCorrectas;
    private RespuestasConcretas respuestas;

    @BeforeAll
    public static void setUpClass() {
        clasica = new Clasica(3);
        grupos = Arrays.asList("Mamifero", "Pez");
        miembrosGrupo1 = Arrays.asList("Gato", "Perro");
        miembrosGrupo2 = List.of("Tiburon");

    }

    @BeforeEach
    public void setUp() {
        modificadores = Modificadores.obtenerListaModificadoresPuntaje();
        modificadorPuntaje= modificadores.getFirst();
        jugador1 = new Jugador("Jugador 1", modificadores);
        jugador2 = new Jugador("Jugador 2", modificadores);

        List<List<String>> miembrosPorGrupos=new ArrayList<>();
        miembrosPorGrupos.add(miembrosGrupo1);
        miembrosPorGrupos.add(miembrosGrupo2);
        opcionesCorrectas=new GruposMock(grupos,miembrosPorGrupos);


        respuestas= new RespuestasConcretas();


    }


    @Test
    public void test01GroupChoiceAsignaPuntajeCorrectoAJugadorQueRespondeCorrectamente(){
        //Arrange

        Pregunta pregunta = new GroupChoice(
                "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesCorrectas,
                clasica,
                "Animales"
        );

        respuestas.agregar(opcionesCorrectas,jugador1, modificadorPuntaje);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test02Asigna0PuntosAJugadorQueRespondeConUnaIncorrecta() {
        //Arrange

        Pregunta pregunta = new GroupChoice(
                "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesCorrectas,
                clasica,
                "Animales"
        );

        GruposMock opcionesJugador = opcionesCorrectas.crearCopiaMock(miembrosGrupo2, List.of(""));
        respuestas.agregar(opcionesJugador,jugador1, modificadorPuntaje);


        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert

        assertEquals(0, jugador1.obtenerPuntaje());

    }
    @Test
    public void test03Asigna0PuntosAJugadorQueRespondeConUnaIncorrectaYDosCorrectas() {
        //Arrange

         Pregunta pregunta = new GroupChoice(
                "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesCorrectas,
                clasica,
                "Animales"
        );
        GruposMock opcionesJugador = opcionesCorrectas.crearCopiaMock(miembrosGrupo1, List.of("Reja"));
        respuestas.agregar(opcionesJugador,jugador1, modificadorPuntaje);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert

        assertEquals(0, jugador1.obtenerPuntaje());

    }
    @Test
    public void test04Asigna0PuntosAJugadorQueRespondeConDosCorrectasSiendo3Opciones() {
        //Arrange

        Pregunta pregunta = new GroupChoice(
                "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesCorrectas,
                clasica,
                "Animales"
        );

        GruposMock opcionesJugador = opcionesCorrectas.crearCopiaMock(List.of("Perro"), List.of("Tiburon"));
        respuestas.agregar(opcionesJugador,jugador1, modificadorPuntaje);


        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert

        assertEquals(0, jugador1.obtenerPuntaje());

    }
}
