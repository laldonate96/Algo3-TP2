package edu.fiuba.algo3.testEntrega3.TurnosTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Modificador.Multiplicador;
import edu.fiuba.algo3.modelo.Modificador.Anulador;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.puntaje.Clasica;

import edu.fiuba.algo3.modelo.turno.Turno;

public class TurnosTest {


    private Pregunta vof;
    private Pregunta vofp;


    private Jugador jugador1;
    private Jugador jugador2;
    private Modificador nulo;
    private Modificador anulador;
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

        vof = new VerdaderoFalso("un enunciado", opciones, clasica,"Mock");
        vofp = new VerdaderoFalso("un enunciado", opciones, penalidad,"Mock");


        jugador1 = new Jugador("un jugador", FabricaModificadores.crearListaModificadores());
        jugador2 = new Jugador("otro jugador", FabricaModificadores.crearListaModificadores());

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


        Modificador nuloJugador1 = jugador1.obtenerModificadores().get(0);
        Modificador nuloJugador2 =jugador2.obtenerModificadores().get(0);

        turno.agregarRespuesta(opcionJugador1,jugador1,nuloJugador1);
        turno.agregarRespuesta(opcionJugador2,jugador2,nuloJugador2);

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


        Modificador nuloJugador1 = jugador1.obtenerModificadores().get(0);
        Modificador nuloJugador2 =jugador2.obtenerModificadores().get(0);

        turno.agregarRespuesta(opcionJugador1,jugador1,nuloJugador1);
        turno.agregarRespuesta(opcionJugador2,jugador2,nuloJugador2);

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




        Modificador multiplicador= jugador1.obtenerModificadores().get(1);
        Modificador nuloJugador2 =jugador2.obtenerModificadores().get(0);

        turno.agregarRespuesta(opcionJugador1,jugador1,multiplicador);
        turno.agregarRespuesta(opcionJugador2,jugador2,nuloJugador2);

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




        Modificador nuloJugador1 =jugador1.obtenerModificadores().get(0);
        Modificador anulador= jugador2.obtenerModificadores().get(5);

        turno.agregarRespuesta(opcionJugador1,jugador1,nuloJugador1);
        turno.agregarRespuesta(opcionJugador2,jugador2,anulador);

        //act
        turno.asignarPuntajes();

        // assert

        assertEquals(0, jugador1.obtenerPuntaje());
        assertEquals(0, jugador2.obtenerPuntaje());


    }



}
