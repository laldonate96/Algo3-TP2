package edu.fiuba.algo3.testEntrega3.TurnosTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;


import edu.fiuba.algo3.modelo.turno.Estado.Estado;
import edu.fiuba.algo3.modelo.turno.Estado.ManejarVoF;
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
    private Turno turno;
    private List<String> contenidoOpciones1;
    private List<String> contenidoOpciones2;
    private Estado manejarVoF;
    private ManejarVoF manejarVoFP;


    @BeforeEach
    public void setUp(){

        List<String> opcionesTexto= Arrays.asList("A bloques", "Cortadas");
        List<String> posicionesCorrectas= List.of("1");
        List<Simple> opcionesPregunta = FabricaOpciones.crearListaSimple(opcionesTexto, posicionesCorrectas, new Correcta());

        Clasica clasica = new Clasica(1);
        ConPenalidad penalidad= new ConPenalidad();


        vof = new VerdaderoFalso("Cuales son las mejores Papas Fritas", opcionesPregunta, clasica,"Mock", "Say no More");
        vofp = new VerdaderoFalso("Cuales son las mejores Papas Fritas", opcionesPregunta, penalidad,"Mock","Say no More" );
        manejarVoF=new ManejarVoF((VerdaderoFalso) vof);
        manejarVoFP=new ManejarVoF((VerdaderoFalso)vofp);

        jugador1 = new Jugador("un jugador", FabricaModificadores.crearListaModificadores());
        jugador2 = new Jugador("otro jugador", FabricaModificadores.crearListaModificadores());

        turno = new Turno();

    }

    @Test
    public void test01seJuegaUnTurnoConUnaPreguntaVoFClasicaYseLespidePuntos(){
        //arrange
        contenidoOpciones1 = List.of("A bloques");
        List<String> posicion1= List.of("1");
        List<Opcion> opcionesJugador1= new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Incorrecta()));

        contenidoOpciones2 = List.of("Cortadas");
        List<String> posicion2= List.of();
        List<Opcion> opcionesJugador2 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2,posicion2, new Incorrecta()));


        turno.reiniciarTurno(vof,manejarVoF);


        Modificador nuloJugador1 = jugador1.obtenerModificadores().get(0);
        Modificador nuloJugador2 =jugador2.obtenerModificadores().get(0);

        turno.agregarRespuesta(opcionesJugador1,jugador1,nuloJugador1);
        turno.agregarRespuesta(opcionesJugador2,jugador2,nuloJugador2);

        //act

        turno.asignarPuntajes();

        // assert

        assertEquals(0, jugador2.obtenerPuntaje());
        assertEquals(1, jugador1.obtenerPuntaje());
    }

    @Test
    public void test02seJuegaUnTurnoConUnaPreguntaVoFPenalizadaYseLespidePuntos(){
        //arrange
        contenidoOpciones1 = List.of("A bloques");
        List<String> posicion1= List.of("1");
        List<Opcion> opcionesJugador1 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Incorrecta()));

        contenidoOpciones2 = List.of("Cortadas");
        List<String> posicion2= List.of();
        List<Opcion> opcionesJugador2 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2,posicion2, new Incorrecta()));


        turno.reiniciarTurno(vofp,manejarVoFP);


        Modificador nuloJugador1 = jugador1.obtenerModificadores().get(0);
        Modificador nuloJugador2 =jugador2.obtenerModificadores().get(0);

        turno.agregarRespuesta(opcionesJugador1,jugador1,nuloJugador1);
        turno.agregarRespuesta(opcionesJugador2,jugador2,nuloJugador2);

        //act
        turno.asignarPuntajes();

        // assert

        assertEquals(1, jugador1.obtenerPuntaje());
        assertEquals(-1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test03seJuegaUnTurnoConUnaPreguntaVoFPenalizadaConMultiplicadorYseLespidePuntos(){
        //arrange

        contenidoOpciones1 = List.of("A bloques");
        List<String> posicion1= List.of("1");
        List<Opcion> opcionesJugador1 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Incorrecta()));

        contenidoOpciones2 = List.of("Cortadas");
        List<String> posicion2= List.of();
        List<Opcion> opcionesJugador2 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2,posicion2, new Incorrecta()));


        turno.reiniciarTurno(vofp,manejarVoFP);




        Modificador multiplicador= jugador1.obtenerModificadores().get(1);
        Modificador nuloJugador2 =jugador2.obtenerModificadores().get(0);

        turno.agregarRespuesta(opcionesJugador1,jugador1,multiplicador);
        turno.agregarRespuesta(opcionesJugador2,jugador2,nuloJugador2);

        //act
        turno.asignarPuntajes();

        // assert
        assertEquals(2, jugador1.obtenerPuntaje());
        assertEquals(-1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test04seJuegaUnTurnoConUnaPreguntaVoFClasicaConAnuladorYseLespidePuntos(){
        //arrange

        contenidoOpciones1 = List.of("A bloques");
        List<String> posicion1= List.of("1");
        List<Opcion> opcionesJugador1 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Incorrecta()));

        contenidoOpciones2 = List.of("Cortadas");
        List<String> posicion2= List.of();
        List<Opcion> opcionesJugador2 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2,posicion2, new Incorrecta()));


        turno.reiniciarTurno(vof,manejarVoF);




        Modificador nuloJugador1 =jugador1.obtenerModificadores().get(0);
        Modificador anulador= jugador2.obtenerModificadores().get(5);

        turno.agregarRespuesta(opcionesJugador1,jugador1,nuloJugador1);
        turno.agregarRespuesta(opcionesJugador2,jugador2,anulador);

        //act
        turno.asignarPuntajes();

        // assert

        assertEquals(0, jugador1.obtenerPuntaje());
        assertEquals(0, jugador2.obtenerPuntaje());


    }

    @Test
    public void test05UsarUnTurnoYReiniciarloAsignaLosPuntosEsperados(){
        //arrange

        contenidoOpciones1 = List.of("Cortadas");
        List<String> posicion1= List.of("5");
        List<Opcion> opcionesJugador1 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1,posicion1, new Incorrecta()));

        contenidoOpciones2 = List.of("A bloques");
        List<String>  posicion2= List.of("1");
        List<Opcion> opcionesJugador2 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));


        turno.reiniciarTurno(vofp, manejarVoFP);




        Modificador nuloJugador= jugador1.obtenerModificadores().get(0);
        Modificador multiplicador =jugador2.obtenerModificadores().get(1);


        turno.agregarRespuesta(opcionesJugador1,jugador1,nuloJugador);
        turno.agregarRespuesta(opcionesJugador2,jugador2,multiplicador);


        turno.asignarPuntajes();
        jugador2.obtenerPuntaje();


        opcionesJugador1=new ArrayList<>( FabricaOpciones.crearListaSimple(contenidoOpciones1,posicion1, new Incorrecta()));
        opcionesJugador2=new ArrayList<>( FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));



        turno.reiniciarTurno(vofp, manejarVoFP);






        multiplicador= jugador2.obtenerModificadores().get(1);

        turno.agregarRespuesta(opcionesJugador1,jugador1,nuloJugador);
        turno.agregarRespuesta(opcionesJugador2,jugador2,multiplicador);

        //act
        turno.asignarPuntajes();








        jugador2.obtenerPuntaje();
        // assert
        assertEquals(-2, jugador1.obtenerPuntaje());
        assertEquals(8, jugador2.obtenerPuntaje());
    }




}