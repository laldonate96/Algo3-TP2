package edu.fiuba.algo3.TestEntrega2.Pregunta;


import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;

import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.GroupChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;



public class GroupChoiceTest {
    private Jugador jugador1;


    static List<String> grupos;
    static List<String> contenidoOpciones;
    static List<String> posicionesCorrectas;
    private static Clasica clasica;
    private List<Grupo> opcionesPregunta;
    private List<Respuesta> respuestas;

    @BeforeAll
    public static void setUpClass() {
        clasica = new Clasica(3);
        grupos = Arrays.asList("Mamifero", "Pez");
        contenidoOpciones = Arrays.asList("Gato","Tiburon", "Perro");
        posicionesCorrectas= List.of("1","3","0","2");


    }

    @BeforeEach
    public void setUp() {
        List<Modificador> modificadores = FabricaModificadores.crearListaModificadores();
        jugador1 = new Jugador("Jugador 1", modificadores);



        opcionesPregunta= FabricaOpciones.crearListaGrupo(grupos,contenidoOpciones,posicionesCorrectas, new Correcta());


        respuestas= new ArrayList<>();


    }


    @Test
    public void test01GroupChoiceAsignaPuntajeCorrectoAJugadorQueRespondeCorrectamente(){
        //Arrange

        Pregunta pregunta = new GroupChoice(
                "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesPregunta,
                clasica,
                "Animales","Say no More"
        );
        List<Opcion> opcionesJugador=new ArrayList<>(opcionesPregunta);
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1);
        respuestas.add(respuesta);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02Asigna0PuntosAJugadorQueRespondeConUnaIncorrecta() {
        //Arrange

        Pregunta pregunta = new GroupChoice(
                "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesPregunta,
                clasica,
                "Animales","Say no More"
        );


        List<Opcion> opcionesJugador=new ArrayList<>(FabricaOpciones.crearListaGrupo(grupos,contenidoOpciones,List.of("2","0"), new Incorrecta()));
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1);
        respuestas.add(respuesta);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert

        assertEquals(0, respuesta.obtenerPuntaje());

    }
    @Test
    public void test03Asigna0PuntosAJugadorQueRespondeConUnaIncorrectaYDosCorrectas() {
        //Arrange

         Pregunta pregunta = new GroupChoice(
                "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesPregunta,
                clasica,
                "Animales","Say no More"
         );
        List<Opcion> opcionesJugador=new ArrayList<>(FabricaOpciones.crearListaGrupo(grupos,contenidoOpciones,List.of("2","0","1","3"), new Incorrecta()));
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1);
        respuestas.add(respuesta);


        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert

        assertEquals(0, respuesta.obtenerPuntaje());

    }
    @Test
    public void test04Asigna0PuntosAJugadorQueRespondeConDosCorrectasSiendo3Opciones() {
        //Arrange

        Pregunta pregunta = new GroupChoice(
                "Poner las siguientes preguntas en su grupo correspondiente",
                opcionesPregunta,
                clasica,
                "Animales","Say no More"
        );

        List<Opcion> opcionesJugador=new ArrayList<>(FabricaOpciones.crearListaGrupo(grupos,contenidoOpciones,List.of("1","0","2"), new Incorrecta()));
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1);
        respuestas.add(respuesta);



        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert

        assertEquals(0, respuesta.obtenerPuntaje());

    }
}
