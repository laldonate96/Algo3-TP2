package edu.fiuba.algo3.TestEntrega2.Pregunta;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.pregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Modificador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Nulo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderedChoiceTest {


    private Jugador jugador1;
    private static Clasica clasica;
    private static Modificador nulo;

    private List<Respuesta> respuestas;
    private List<Opcion> opciones;

    @BeforeAll
    public static void setUpClass() {
        clasica= new Clasica(3);
        nulo=new Nulo();
    }

    @BeforeEach
    public void setUp() {

        List<Modificador> modificadores= FabricaModificadores.crearListaModificadoresPuntaje();

        nulo = modificadores.get(0);

        jugador1 = new Jugador("Jugador 1", modificadores);

        List<String> opcionesTexto= List.of("Opcion 1", "Opcion 2", "Opcion 3");
        List<String> ordenCorrecto = List.of("3", "2", "1");

        respuestas=new ArrayList<>();
        opciones= FabricaOpciones.crearListaOrdenada(opcionesTexto, ordenCorrecto, new Correcta());
    }

    @Test
    public void test01OrderedChoiceAsignaPuntajeCorrectoAJugadorQueRespondeCorrectamente(){
        //Arrange

        Pregunta pregunta = new OrderedChoice(
                "Ordenar las siguientes opciones",
                opciones,
                clasica,
                "Tema"
        );



        List<Opcion> opcionesJugador=new ArrayList<>();
//        opcionesJugador = pregunta.crearCopia(List.of("Opcion 3", "Opcion 2", "Opcion 1"), List.of(""));
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1, nulo);
        respuestas.add(respuesta);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Act

        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02OrderedChoiceAsignaPuntajeCorrectoAJugadorQueRespondeIncorrectamente() {
        //Arrange

        Pregunta pregunta = new OrderedChoice(
                "Ordenar las siguientes opciones",
                opciones,
                clasica,
                "Tema"
        );

        List<Opcion> opcionesJugador=new ArrayList<>();
//        opcionesJugador = pregunta.crearCopia(List.of( "Opcion 1","Opcion 2", "Opcion 3"), List.of(""));
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1, nulo);
        respuestas.add(respuesta);

        //Act
        pregunta.asignarPuntajes(respuestas);
        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }
}
