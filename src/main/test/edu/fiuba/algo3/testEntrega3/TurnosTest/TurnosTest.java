package edu.fiuba.algo3.testEntrega3.TurnosTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaNula;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;


import edu.fiuba.algo3.modelo.turno.Estado.Estado;
import edu.fiuba.algo3.modelo.turno.Estado.ManejarVoF;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;

import edu.fiuba.algo3.modelo.turno.Turno;

public class TurnosTest {


    private static List<Pregunta> preguntasTest;
    private Pregunta verdaderoOFalso;
    private Pregunta verdaderoOFalsoPenalidad;


    private Jugador jugador1;
    private Jugador jugador2;
    private Turno turno;
    private Estado manejarVoF;
    private ManejarVoF manejarVoFP;


    @BeforeAll
    public static void setupClass(){
        preguntasTest = Lector.obtenerPreguntasDeJson(new MezclaNula(),("recursos/test.json"));
    }

    @BeforeEach
    public void setUp(){









        jugador1 = new Jugador("un jugador", FabricaModificadores.crearListaModificadores());
        jugador2 = new Jugador("otro jugador", FabricaModificadores.crearListaModificadores());

        turno = new Turno();

    }

    @Test
    public void test01seJuegaUnTurnoConUnaPreguntaVoFClasicaYseLespidePuntos(){
        //arrange

        verdaderoOFalso = preguntasTest.get(1);
        manejarVoF=new ManejarVoF((VerdaderoFalso) verdaderoOFalso);


        List<String> contenidoOpciones1 = List.of("Verdadero");
        List<String> posicion1= List.of("1");
        List<Opcion> opcionesJugador1= new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Incorrecta()));

        List<String> contenidoOpciones2 = List.of("Falso");
        List<String> posicion2= List.of();
        List<Opcion> opcionesJugador2 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2,posicion2, new Incorrecta()));


        turno.reiniciarTurno(verdaderoOFalso,manejarVoF);


        Modificador nuloJugador1 = jugador1.obtenerModificadores().get(0);
        Modificador nuloJugador2 =jugador2.obtenerModificadores().get(0);

        turno.agregarRespuesta(opcionesJugador1,jugador1,nuloJugador1);
        turno.agregarRespuesta(opcionesJugador2,jugador2,nuloJugador2);

        //act

        turno.asignarPuntajes();

        // assert

        assertEquals(0, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test02seJuegaUnTurnoConUnaPreguntaVoFPenalizadaYseLespidePuntos(){
        //arrange
        verdaderoOFalsoPenalidad = preguntasTest.get(5);
        manejarVoFP=new ManejarVoF((VerdaderoFalso) verdaderoOFalsoPenalidad);

        List<String> contenidoOpciones1 = List.of("Verdadero");
        List<String> posicion1= List.of("1");
        List<Opcion> opcionesJugador1 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Correcta()));

        List<String> contenidoOpciones2 = List.of("Falso");
        List<String> posicion2= List.of();
        List<Opcion> opcionesJugador2 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2,posicion2, new Incorrecta()));


        turno.reiniciarTurno(verdaderoOFalsoPenalidad,manejarVoFP);


        Modificador nuloJugador1 = jugador1.obtenerModificadores().get(0);
        Modificador nuloJugador2 =jugador2.obtenerModificadores().get(0);

        turno.agregarRespuesta(opcionesJugador1,jugador1,nuloJugador1);
        turno.agregarRespuesta(opcionesJugador2,jugador2,nuloJugador2);

        //act
        turno.asignarPuntajes();

        // assert

        assertEquals(-1, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test03UsandoUnaMultipleChoicePenalidadYUnMultiplicadorYLosJugadoresObtienenLosPuntosEsperados(){
        //arrange
        MultipleChoice multipleChoicePenalidad=(MultipleChoice) preguntasTest.get(6);
        verdaderoOFalsoPenalidad = preguntasTest.get(5);
        manejarVoFP=new ManejarVoF((VerdaderoFalso) verdaderoOFalsoPenalidad);

        List<String> contenidoOpciones1 = List.of("Verdadero");
        List<String> posicion1= List.of("1");
        List<Opcion> opcionesJugador1 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Correcta()));

        List<String> contenidoOpciones2 = List.of("Falso");
        List<String> posicion2= List.of();
        List<Opcion> opcionesJugador2 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2,posicion2, new Incorrecta()));


        turno.reiniciarTurno(verdaderoOFalsoPenalidad,manejarVoFP);




        Modificador multiplicador= jugador1.obtenerModificadores().get(1);
        Modificador nuloJugador2 =jugador2.obtenerModificadores().get(0);

        turno.agregarRespuesta(opcionesJugador1,jugador1,multiplicador);
        turno.agregarRespuesta(opcionesJugador2,jugador2,nuloJugador2);

        //act
        turno.asignarPuntajes();

        // assert
        assertEquals(-2, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test04seJuegaUnTurnoConUnaPreguntaVoFClasicaConAnuladorYseLespidePuntos(){
        //arrange
        verdaderoOFalso = preguntasTest.get(1);
        manejarVoF=new ManejarVoF((VerdaderoFalso) verdaderoOFalso);

        List<String> contenidoOpciones1 = List.of("Falso");
        List<String> posicion1= List.of("1");
        List<Opcion> opcionesJugador1 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Correcta()));

        List<String> contenidoOpciones2 = List.of("Falso");
        List<String> posicion2= List.of();
        List<Opcion> opcionesJugador2 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2,posicion2, new Incorrecta()));


        turno.reiniciarTurno(verdaderoOFalso,manejarVoF);




        Modificador nuloJugador1 =jugador1.obtenerModificadores().get(0);
        Modificador anulador= jugador2.obtenerModificadores().get(5);

        turno.agregarRespuesta(opcionesJugador1,jugador1,nuloJugador1);
        turno.agregarRespuesta(opcionesJugador2,jugador2,anulador);

        //act
        turno.asignarPuntajes();

        // assert

        assertEquals(0, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());


    }

    @Test
    public void test05UsarUnTurnoYReiniciarloAsignaLosPuntosEsperados(){
        //arrange
        verdaderoOFalsoPenalidad = preguntasTest.get(5);
        manejarVoFP=new ManejarVoF((VerdaderoFalso) verdaderoOFalsoPenalidad);

        List<String> contenidoOpciones1 = List.of("Verdadero");
        List<String> posicion1= List.of("1");
        List<Opcion> opcionesJugador1 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Correcta()));

        List<String> contenidoOpciones2 = List.of("Falso");
        List<String> posicion2= List.of();
        List<Opcion> opcionesJugador2 =new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2,posicion2, new Incorrecta()));


        turno.reiniciarTurno(verdaderoOFalsoPenalidad, manejarVoFP);




        Modificador nuloJugador= jugador1.obtenerModificadores().get(0);
        Modificador multiplicador =jugador2.obtenerModificadores().get(1);


        turno.agregarRespuesta(opcionesJugador1,jugador1,nuloJugador);
        turno.agregarRespuesta(opcionesJugador2,jugador2,multiplicador);


        turno.asignarPuntajes();
        jugador2.obtenerPuntaje();


        opcionesJugador1=new ArrayList<>( FabricaOpciones.crearListaSimple(contenidoOpciones1,posicion1, new Incorrecta()));
        opcionesJugador2=new ArrayList<>( FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));



        turno.reiniciarTurno(verdaderoOFalsoPenalidad, manejarVoFP);






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