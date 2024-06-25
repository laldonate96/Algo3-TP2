package edu.fiuba.algo3.testEntrega3.TurnosTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Multiplicador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.AnuladorTurno;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ModificadorTurno;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;

import edu.fiuba.algo3.modelo.puntaje.Clasica;

import edu.fiuba.algo3.modelo.turno.Turno;

public class TurnosTest {


    private Pregunta vof;
    private Pregunta vofp;


    private Jugador jugador1;
    private Jugador jugador2;
    private ModificadorPuntaje nulo;
    private ModificadorPuntaje anuladorPuntaje;
    private Turno turno;
    private List<String> opcionesJugador1;
    private List<String> opcionesJugador2;



    @BeforeEach
    public void setUp(){

        List<String> opcionesTexto= Arrays.asList("Correcta", "Incorrecta");
        List<String> posicionesCorrectas= List.of("1");
        List<Opcion> opciones = FabricaOpciones.crearListaSimple(opcionesTexto, posicionesCorrectas, new Correcta());

        Clasica clasica = new Clasica(1);
        ConPenalidad penalidad= new ConPenalidad();

        vof = new Pregunta("un enunciado", opciones, clasica,"Mock");
        vofp = new Pregunta("un enunciado", opciones, penalidad,"Mock");

        List<ModificadorPuntaje> modificadores = FabricaModificadores.crearListaModificadoresPuntaje();

        nulo= modificadores.get(0);
        anuladorPuntaje = modificadores.get(4);

        jugador1 = new Jugador("un jugador", modificadores);
        jugador2 = new Jugador("otro jugador", modificadores);

        turno = new Turno();

    }

    @Test
    public void test01seJuegaUnTurnoConUnaPreguntaVoFClasicaYseLespidePuntos(){
       //arrange
        opcionesJugador1 = List.of("Correcta");
        List<String> posicion1= List.of("1");
        List<Opcion> opcionJugador1= FabricaOpciones.crearListaSimple(opcionesJugador1, posicion1, new Correcta());

        opcionesJugador2 = List.of("Incorrecta");
        List<String> posicion2= List.of();
        List<Opcion> opcionJugador2= FabricaOpciones.crearListaSimple(opcionesJugador2,posicion2, new Incorrecta());


        turno.establecerPregunta(vof);


        turno.agregarRespuesta(opcionJugador1,jugador1,nulo);
        turno.agregarRespuesta(opcionJugador2,jugador2,nulo);

        //act

        turno.asignarPuntajes();

        // assert   

        assertEquals(0, jugador2.obtenerPuntaje());        
        assertEquals(1, jugador1.obtenerPuntaje());
    }

    @Test
    public void test02seJuegaUnTurnoConUnaPreguntaVoFPenalizadaYseLespidePuntos(){
        //arrange
        opcionesJugador1 = List.of("Correcta");
        List<String> posicion1= List.of("1");
        List<Opcion> opcionJugador1= FabricaOpciones.crearListaSimple(opcionesJugador1, posicion1, new Correcta());

        opcionesJugador2 = List.of("Incorrecta");
        List<String> posicion2= List.of();
        List<Opcion> opcionJugador2= FabricaOpciones.crearListaSimple(opcionesJugador2,posicion2, new Incorrecta());


        turno.establecerPregunta(vofp);



        turno.agregarRespuesta(opcionJugador1,jugador1,nulo);
        turno.agregarRespuesta(opcionJugador2,jugador2,nulo);

        //act
        turno.asignarPuntajes();

        // assert

        assertEquals(1, jugador1.obtenerPuntaje());
        assertEquals(-1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test03seJuegaUnTurnoConUnaPreguntaVoFPenalizadaConMultiplicadorYseLespidePuntos(){
       //arrange

        opcionesJugador1 = List.of("Correcta");
        List<String> posicion1= List.of("1");
        List<Opcion> opcionJugador1= FabricaOpciones.crearListaSimple(opcionesJugador1, posicion1, new Correcta());

        opcionesJugador2 = List.of("Incorrecta");
        List<String> posicion2= List.of();
        List<Opcion> opcionJugador2= FabricaOpciones.crearListaSimple(opcionesJugador2,posicion2, new Incorrecta());


        turno.establecerPregunta(vofp);




        Multiplicador multiplicador= new Multiplicador(2);


        turno.agregarRespuesta(opcionJugador1,jugador1,multiplicador);
        turno.agregarRespuesta(opcionJugador2,jugador2,nulo);

        //act
        turno.asignarPuntajes();

        // assert
        
        assertEquals(2, jugador1.obtenerPuntaje());
        assertEquals(-1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test04seJuegaUnTurnoConUnaPreguntaVoFClasicaConAnuladorYseLespidePuntos(){
        //arrange

        opcionesJugador1 = List.of("Correcta");
        List<String> posicion1= List.of("1");
        List<Opcion> opcionJugador1= FabricaOpciones.crearListaSimple(opcionesJugador1, posicion1, new Correcta());

        opcionesJugador2 = List.of("Incorrecta");
        List<String> posicion2= List.of();
        List<Opcion> opcionJugador2= FabricaOpciones.crearListaSimple(opcionesJugador2,posicion2, new Incorrecta());


        turno.establecerPregunta(vof);

        ModificadorTurno anulador = new AnuladorTurno(anuladorPuntaje);

        turno.asignarModificador(anulador);



        turno.agregarRespuesta(opcionJugador1,jugador1,nulo);
        turno.agregarRespuesta(opcionJugador2,jugador2,anuladorPuntaje);

        //act
        turno.asignarPuntajes();

        // assert

        assertEquals(0, jugador1.obtenerPuntaje());
        assertEquals(0, jugador2.obtenerPuntaje());


    }



}
