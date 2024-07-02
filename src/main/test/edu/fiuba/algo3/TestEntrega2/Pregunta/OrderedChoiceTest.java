package edu.fiuba.algo3.TestEntrega2.Pregunta;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.pregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderedChoiceTest {


    private Jugador jugador1;
    private static Clasica clasica;


    private List<Respuesta> respuestas;
    private List<Ordenada> opcionesPregunta;

    @BeforeAll
    public static void setUpClass() {
        clasica= new Clasica(3);

    }

    @BeforeEach
    public void setUp() {

        List<Modificador> modificadores= FabricaModificadores.crearListaModificadores();



        jugador1 = new Jugador("Jugador 1", modificadores);

        List<String> opcionesTexto= List.of("Opcion 1", "Opcion 2", "Opcion 3");
        List<String> ordenCorrecto = List.of("3", "2", "1");

        respuestas=new ArrayList<>();
        opcionesPregunta = FabricaOpciones.crearListaOrdenada(opcionesTexto, ordenCorrecto);
    }

    @Test
    public void test01OrderedChoiceAsignaPuntajeCorrectoAJugadorQueRespondeCorrectamente(){
        //Arrange

        Pregunta pregunta = new OrderedChoice(
                "Ordenar las siguientes opciones",
                opcionesPregunta,
                clasica,
                "Tema","Say no More"
        );



        List<Opcion> opcionesJugador;
        opcionesJugador =new ArrayList<>(FabricaOpciones.crearListaOrdenada(List.of("Opcion 1", "Opcion 2", "Opcion 3"), List.of("3","2","1")));
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1);
        respuestas.add(respuesta);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Act

        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02OrderedChoiceAsignaPuntajeCorrectoAJugadorQueRespondeIncorrectamente() {
        //Arrange

        Pregunta pregunta = new OrderedChoice(
                "Ordenar las siguientes opciones",
                opcionesPregunta,
                clasica,
                "Tema","Say no More"
        );

        List<Opcion> opcionesJugador=new ArrayList<>();

        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1);
        respuestas.add(respuesta);

        //Act
        pregunta.asignarPuntajes(respuestas);
        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }
}
