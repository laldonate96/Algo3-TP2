package edu.fiuba.algo3.testEntrega2.ModificadorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;


import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Multiplicador;

public class MultiplicadorTest {

    private Jugador jugador1;
    private static String correctaTexto;
    private static String incorrectaTexto;



    @BeforeAll
    public static void setUpClass() {
        correctaTexto ="Verdadero";
        incorrectaTexto ="Falso";

    }

    @BeforeEach
    public void setUp() {

        List<ModificadorPuntaje> modificadores = FabricaModificadores.crearListaModificadoresPuntaje();





        jugador1 = new Jugador("Jugador 1", modificadores);

    }

    @Test
    public void test01unJugadorUtilizaUnMultiplicadorEnUnaPreguntaVerdaderosOFalsoYAcierto(){
        //arrange

        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of(correctaTexto),List.of("1"));


        Multiplicador multiplicador1 = new Multiplicador(2);
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1, multiplicador1);


        //act
        respuesta.asignarPuntaje(1);

        //assert
        assertEquals(2, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02unJugadorUtilizaUnMultiplicadorEnUnaPreguntaVerdaderosOFalsoYFalla(){

        //arrange
        List<Opcion> opcionesJugador = FabricaOpciones.crearListaSimple(List.of(incorrectaTexto),List.of("0"));



        Multiplicador multiplicador1 = new Multiplicador(2);
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1, multiplicador1);

        //act
        respuesta.asignarPuntaje(-1);

        //assert
        assertEquals(-2, respuesta.obtenerPuntaje());
    }
}