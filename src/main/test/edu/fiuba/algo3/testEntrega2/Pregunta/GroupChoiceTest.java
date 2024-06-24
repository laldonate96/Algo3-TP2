package edu.fiuba.algo3.testEntrega2.Pregunta;


import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GroupChoiceTest {
    private Jugador jugador1;
    private Jugador jugador2;

    static List<String> grupos;
    static List<String> miembrosGrupo1;
    static List<String> miembrosGrupo2;
    private static Clasica clasica;
    private ModificadorPuntaje nulo;
    //USAR MOCKITO
    private List<Opcion> opcionesCorrectas;
    private List<Respuesta> respuestas;

    @BeforeAll
    public static void setUpClass() {
        clasica = new Clasica(3);
        grupos = Arrays.asList("Mamifero", "Pez");
        miembrosGrupo1 = Arrays.asList("Gato", "Perro");
        miembrosGrupo2 = List.of("Tiburon");

    }

    @BeforeEach
    public void setUp() {
        List<ModificadorPuntaje> modificadores = FabricaModificadores.crearListaModificadoresPuntaje();
        nulo = modificadores.get(0);
        jugador1 = new Jugador("Jugador 1", modificadores);
        jugador2 = new Jugador("Jugador 2", modificadores);

        List<List<String>> miembrosPorGrupos=new ArrayList<>();
        miembrosPorGrupos.add(miembrosGrupo1);
        miembrosPorGrupos.add(miembrosGrupo2);

        opcionesCorrectas= FabricaOpciones.crearListaGrupo(grupos,miembrosPorGrupos, new Correcta());


        respuestas= new ArrayList<>();


    }


    @Test
    public void test01GroupChoiceAsignaPuntajeCorrectoAJugadorQueRespondeCorrectamente(){
        //Arrange

        Pregunta pregunta = new Pregunta(
                "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesCorrectas,
                clasica,
                "Animales"
        ) {
        };
        Respuesta respuesta= new Respuesta(opcionesCorrectas,jugador1, nulo);
        respuestas.add(respuesta);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test02Asigna0PuntosAJugadorQueRespondeConUnaIncorrecta() {
        //Arrange

        Pregunta pregunta = new Pregunta(
                "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesCorrectas,
                clasica,
                "Animales"
        );


        List<Opcion> opcionesJugador=new ArrayList<>();
//        opcionesJugador = opcionesCorrectas.crearCopiaMock(miembrosGrupo2, List.of(""));
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1, nulo);
        respuestas.add(respuesta);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert

        assertEquals(0, jugador1.obtenerPuntaje());

    }
    @Test
    public void test03Asigna0PuntosAJugadorQueRespondeConUnaIncorrectaYDosCorrectas() {
        //Arrange

         Pregunta pregunta = new Pregunta(
                "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesCorrectas,
                clasica,
                "Animales"
        );
        List<Opcion> opcionesJugador=new ArrayList<>();
//        opcionesJugador = opcionesCorrectas.crearCopiaMock(miembrosGrupo2, List.of(""));
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1, nulo);
        respuestas.add(respuesta);


        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert

        assertEquals(0, jugador1.obtenerPuntaje());

    }
    @Test
    public void test04Asigna0PuntosAJugadorQueRespondeConDosCorrectasSiendo3Opciones() {
        //Arrange

        Pregunta pregunta = new Pregunta(
                "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesCorrectas,
                clasica,
                "Animales"
        );

        List<Opcion> opcionesJugador=new ArrayList<>();
//        opcionesJugador = opcionesCorrectas.crearCopiaMock(miembrosGrupo2, List.of(""));
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1, nulo);
        respuestas.add(respuesta);



        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert

        assertEquals(0, jugador1.obtenerPuntaje());

    }
}
