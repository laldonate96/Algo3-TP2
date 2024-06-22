package edu.fiuba.algo3.testEntrega3;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Multiplicador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.NuloTurno;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.turno.Turno;

public class TurnosTest {



    private VerdaderoFalso vof;

    private  static NuloTurno nuloTurno;

    private Jugador jugador1;
    private Jugador jugador2;
    private ModificadorPuntaje nulo;

    @BeforeAll
    public static void setUpClass() {
        nuloTurno = new NuloTurno();
    }


    @BeforeEach
    public void setUp(){



        List<String> opcionesTexto= Arrays.asList("Correcta", "Incorrecta");
        List<String> posicionesCorrectas= List.of("1");
        List<Opcion> opciones = FabricaOpciones.crearListaSimple(opcionesTexto, posicionesCorrectas);

        Clasica clasica = new Clasica(1);


        vof = new VerdaderoFalso("un enunciado", opciones, clasica,"Mock");


        List<ModificadorPuntaje> modificadores = FabricaModificadores.crearListaModificadoresPuntaje();
        nulo=modificadores.get(0);

        jugador1 = new Jugador("un jugador", modificadores);
        jugador2 = new Jugador("otro jugador", modificadores);


        

    }

    @Test
    public void test01seJuegaUnTurnoConUnaPreguntaVoFClasicaYseLespidePuntos(){
       //arrange
        Turno turno = new Turno(vof);


        List<String> respuestaJugador1 = List.of("Correcta");
        List<String> respuestaJugador2 = List.of("Incorrecta");

        turno.asignarModificador(nuloTurno);
        turno.agregarRespuesta(respuestaJugador1,jugador1,nulo);
        turno.agregarRespuesta(respuestaJugador2,jugador2,nulo);

        //act

        turno.asignarPuntajes();

        // assert   

        assertEquals(0, jugador2.obtenerPuntaje());        
        assertEquals(1, jugador1.obtenerPuntaje());
    }

    @Test
    public void test02seJuegaUnTurnoConUnaPreguntaVoFPenalizadaYseLespidePuntos(){
        //arrange
        Turno turno = new Turno(vof);


        List<String> respuestaJugador1 = List.of("Correcta");
        List<String> respuestaJugador2 = List.of("Incorrecta");

        turno.asignarModificador(nuloTurno);

        turno.agregarRespuesta(respuestaJugador1,jugador1,nulo);
        turno.agregarRespuesta(respuestaJugador2,jugador2,nulo);

        //act
        turno.asignarPuntajes();

        // assert

        assertEquals(1, jugador1.obtenerPuntaje());
        assertEquals(0, jugador2.obtenerPuntaje());
    }

    @Test
    public void test03seJuegaUnTurnoConUnaPreguntaVoFPenalizadaConMultiplicadorYseLespidePuntos(){
       //arrange
        Turno turno = new Turno(vof);


        List<String> respuestaJugadores = List.of("Correcta");

        turno.asignarModificador(nuloTurno);

        Multiplicador multiplicador= new Multiplicador(2);
        turno.agregarRespuesta(respuestaJugadores,jugador1,multiplicador);
        turno.agregarRespuesta(respuestaJugadores,jugador2,nulo);

        //act
        turno.asignarPuntajes();

        // assert
        
        assertEquals(2, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());
    }
}
