package edu.fiuba.algo3.testEntrega2.ModificadorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;


import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Multiplicador;

public class MultiplicadorTest {
    private Jugador jugador1;
    private List<Respuesta> respuestas;

    private Pregunta vofPenal;
    private static String opcionCorrectaTexto;
    private static String opcionIncorrectaTexto;



    @BeforeAll
    public static void setUpClass() {
        opcionCorrectaTexto ="Verdadero";
        opcionIncorrectaTexto ="Falso";

    }

    @BeforeEach
    public void setUp() {

        List<ModificadorPuntaje> modificadores = FabricaModificadores.crearListaModificadoresPuntaje();



        List<String> opcionesTexto= Arrays.asList(opcionCorrectaTexto, opcionIncorrectaTexto);
        List<String> posicionesCorrectas= List.of("1");
        List<Opcion> opcionesPregunta = FabricaOpciones.crearListaSimple(opcionesTexto, posicionesCorrectas);

        ConPenalidad penalidad=new ConPenalidad();
        vofPenal = new VerdaderoFalso("un enunciado", opcionesPregunta, penalidad,"Mock");


        respuestas=new ArrayList<>();
        jugador1 = new Jugador("Jugador 1", modificadores);

    }

    @Test
    public void test01unJugadorUtilizaUnMultiplicadorEnUnaPreguntaVerdaderosOFalsoYAcierto(){
        //arrange

        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of(opcionCorrectaTexto),List.of("1"));


        Multiplicador multiplicador1 = new Multiplicador(2);
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1, multiplicador1);
        respuestas.add(respuesta);

        //act
        vofPenal.asignarPuntajes(respuestas);

        //assert
        assertEquals(2, jugador1.obtenerPuntaje());
    }

    @Test
    public void test02unJugadorUtilizaUnMultiplicadorEnUnaPreguntaVerdaderosOFalsoYFalla(){

        //arrange
        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of(opcionIncorrectaTexto),List.of("0"));



        Multiplicador multiplicador1 = new Multiplicador(2);
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1, multiplicador1);
        respuestas.add(respuesta);

        //act
        vofPenal.asignarPuntajes(respuestas);

        //assert
        assertEquals(-2, jugador1.obtenerPuntaje());
    }
}