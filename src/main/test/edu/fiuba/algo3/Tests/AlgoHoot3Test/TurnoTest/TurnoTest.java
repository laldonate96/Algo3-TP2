package edu.fiuba.algo3.Tests.AlgoHoot3Test.TurnoTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaNula;
import edu.fiuba.algo3.modelo.opcion.Grupal;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;

import edu.fiuba.algo3.modelo.turno.Turno;

public class TurnoTest {


    private static List<Pregunta> preguntasTest;
    private Pregunta verdaderoOFalso;
    private Pregunta verdaderoOFalsoPenalidad;


    private Jugador jugador1;
    private Jugador jugador2;
    private Turno turno;
    private Pregunta multipleChoicePenalidad;
    private Pregunta orderedChoice;
    private Pregunta groupChoice;
    private Pregunta multipleChoiceSimple;
    private Pregunta multipleChoiceParcial;


    @BeforeAll
    public static void setupClass() {
        preguntasTest = Lector.obtenerPreguntasDeJson(new MezclaNula(), "recursos/test.json");
    }

    @BeforeEach
    public void setUp() {
        orderedChoice=preguntasTest.get(0);
        verdaderoOFalso = preguntasTest.get(1);
        groupChoice=preguntasTest.get(2);
        multipleChoiceParcial=preguntasTest.get(3);
        multipleChoiceSimple = preguntasTest.get(4);
        verdaderoOFalsoPenalidad = preguntasTest.get(5);
        multipleChoicePenalidad=preguntasTest.get(6);

        jugador1 = new Jugador("Contigo", FabricaModificadores.crearListaModificadores());
        jugador2 = new Jugador("Pipo", FabricaModificadores.crearListaModificadores());

        turno = new Turno();

    }

    @Test
    public void test01seJuegaUnTurnoConUnaPreguntaOrderedChoiceClasicaUnoRespondeBienElOtroMalYSeEsperaCiertoPuntaje() {
        //arrange

        List<String> contenidoOpciones=List.of("Televisor de tubo CRT","Microondas","Imanes del delivery","Heladera");
        Ordenada televisorDeTuboCrt = new Ordenada(contenidoOpciones.get(0),2);
        Ordenada microondas =         new Ordenada(contenidoOpciones.get(1),1);
        Ordenada imanesDelDelivery =  new Ordenada(contenidoOpciones.get(2),4);
        Ordenada heladera =           new Ordenada(contenidoOpciones.get(3),3);
        Ordenada heladeraIncorrecto = new Ordenada(contenidoOpciones.get(3),2);

        List<Opcion> opcionesJugador1 = List.of(televisorDeTuboCrt, microondas, imanesDelDelivery, heladera);
        List<Opcion> opcionesJugador2 = List.of(televisorDeTuboCrt, microondas, imanesDelDelivery, heladeraIncorrecto);


        Modificador nuloJugador1 = jugador1.obtenerModificadores().get(0);
        Modificador nuloJugador2 = jugador2.obtenerModificadores().get(0);

        turno.reiniciarTurno(orderedChoice);
        turno.agregarRespuesta(opcionesJugador1, jugador1, nuloJugador1);
        turno.agregarRespuesta(opcionesJugador2, jugador2, nuloJugador2);


        //act

        turno.asignarPuntajes();

        // assert

        assertEquals(1, jugador1.obtenerPuntaje());
        assertEquals(0, jugador2.obtenerPuntaje());
    }
    @Test
    public void test02seJuegaUnTurnoConUnaPreguntaVoFClasicaUnoRespondeBienElOtroMalYSeEsperaCiertoPuntaje() {
        //arrange
        List<String> contenidoOpciones1 = List.of("Verdadero");
        List<String> posicion1 = List.of("1");
        List<Opcion> opcionesJugador1 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Incorrecta()));

        List<String> contenidoOpciones2 = List.of("Falso");
        List<String> posicion2 = List.of();
        List<Opcion> opcionesJugador2 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));


        Modificador nuloJugador1 = jugador1.obtenerModificadores().get(0);
        Modificador nuloJugador2 = jugador2.obtenerModificadores().get(0);

        turno.reiniciarTurno(verdaderoOFalso);
        turno.agregarRespuesta(opcionesJugador1, jugador1, nuloJugador1);
        turno.agregarRespuesta(opcionesJugador2, jugador2, nuloJugador2);


        //act

        turno.asignarPuntajes();

        // assert

        assertEquals(0, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());
    }
    @Test
    public void test03SeJuegaUnTurnoConUnaPreguntaGroupChoiceLosDosRespondenBienConAnuladorYSeEsperan1Y0Puntos() {
        //arrange
        String deportesGrupales = "Deportes Grupales";
        String deportesIndividuales = "Deportes Individuales";

        Grupal lioMessi = new Grupal("Lio Messi", deportesGrupales);
        Grupal manuGinobili = new Grupal("Manu Ginóbili", deportesGrupales);
        Grupal juanMartinDelPotro = new Grupal("Juan Martín del Potro", deportesIndividuales);
        Grupal miguelNajdorf = new Grupal("Miguel Najdorf", deportesIndividuales);
        Grupal hugoConte = new Grupal("Hugo Conte", deportesGrupales);
        Grupal joseMeolans = new Grupal("José Meolans", deportesIndividuales);

        List<Opcion> opcionesJugador1= List.of(lioMessi, manuGinobili, juanMartinDelPotro, miguelNajdorf, hugoConte, joseMeolans);
        List<Opcion> opcionesJugador2= List.of(lioMessi, manuGinobili, juanMartinDelPotro, miguelNajdorf, hugoConte, joseMeolans);

        Modificador anuladorJugador1 = jugador1.obtenerModificadores().get(5);
        Modificador nuloJugador2 = jugador2.obtenerModificadores().get(0);


        turno.reiniciarTurno(groupChoice);
        turno.agregarRespuesta(opcionesJugador1, jugador1, anuladorJugador1);
        turno.agregarRespuesta(opcionesJugador2, jugador2, nuloJugador2);


        //act

        turno.asignarPuntajes();

        // assert

        assertEquals(1, jugador1.obtenerPuntaje());
        assertEquals(0, jugador2.obtenerPuntaje());
    }

    @Test
    public void test04seJuegaUnTurnoConUnaMultipleChoiceParcialModificadoresNulosYSeEsperan2Y1Puntos() {

        //arrange
        Simple opcionCorrecta1=  new Simple("El Gran Gatsby",new Incorrecta());
        Simple opcionCorrecta2 = new Simple("El Padrino",new Incorrecta());
        List<Opcion> opcionesJugador1 =List.of(opcionCorrecta1,opcionCorrecta2);
        List<Opcion> opcionesJugador2 =List.of(opcionCorrecta1);

        turno.reiniciarTurno(multipleChoiceParcial);

        Modificador nuloJugador1 = jugador1.obtenerModificadores().get(0);
        Modificador nuloJugador2 = jugador2.obtenerModificadores().get(0);

        turno.agregarRespuesta(opcionesJugador1, jugador1, nuloJugador1);
        turno.agregarRespuesta(opcionesJugador2, jugador2, nuloJugador2);

        //act
        turno.asignarPuntajes();

        // assert

        assertEquals(2, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());
    }

    @Test
    public void test05SeJuegaUnTurnoConUnaMultipleChoiceClasicaConModificadoresExclusividadYSeEsperan0Puntos() {

        //arrange
        Simple opcionCorrecta1=  new Simple("Las bases de datos relacionales",new Incorrecta());
        Simple opcionIncorrecta1 = new Simple("El disco rígido",new Incorrecta());
        Simple opcionIncorrecta2= new Simple("El sistema operativo Solaris",new Incorrecta());
        Simple opcionIncorrecta3 = new Simple("El algoritmo quicksort",new Incorrecta());
        Simple opcionIncorrecta4 = new Simple("Los lenguajes tipados",new Incorrecta());
        List<Opcion> opcionesJugador1 =List.of(opcionCorrecta1);
        List<Opcion> opcionesJugador2 =List.of(opcionCorrecta1);
        List<Opcion> opcionesJugador3 =List.of(opcionIncorrecta1,opcionIncorrecta2,opcionIncorrecta3,opcionIncorrecta4);
        Jugador jugador3=new Jugador("Pipo!!!",FabricaModificadores.crearListaModificadores());

        turno.reiniciarTurno(multipleChoiceSimple);

        Modificador exclusividadJugador1 = jugador1.obtenerModificadores().get(3);
        Modificador exclusividadJugador2 = jugador2.obtenerModificadores().get(3);
        Modificador exclusividadJugador3 = jugador3.obtenerModificadores().get(3);

        turno.agregarRespuesta(opcionesJugador1, jugador1, exclusividadJugador1);
        turno.agregarRespuesta(opcionesJugador2, jugador2, exclusividadJugador2);
        turno.agregarRespuesta(opcionesJugador3, jugador3, exclusividadJugador3);

        //act
        turno.asignarPuntajes();

        // assert

        assertEquals(0, jugador1.obtenerPuntaje());
        assertEquals(0, jugador2.obtenerPuntaje());
        assertEquals(0, jugador3.obtenerPuntaje());
    }
    @Test
    public void test06seJuegaUnTurnoConUnaPreguntaVoFConPenalidadYseLespidePuntos() {
        //arrange


        List<String> contenidoOpciones1 = List.of("Verdadero");
        List<String> posicion1 = List.of("1");
        List<Opcion> opcionesJugador1 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Correcta()));

        List<String> contenidoOpciones2 = List.of("Falso");
        List<String> posicion2 = List.of();
        List<Opcion> opcionesJugador2 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));

        turno.reiniciarTurno(verdaderoOFalsoPenalidad);

        Modificador nuloJugador1 = jugador1.obtenerModificadores().get(0);
        Modificador nuloJugador2 = jugador2.obtenerModificadores().get(0);

        turno.agregarRespuesta(opcionesJugador1, jugador1, nuloJugador1);
        turno.agregarRespuesta(opcionesJugador2, jugador2, nuloJugador2);

        //act
        turno.asignarPuntajes();

        // assert

        assertEquals(-1, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());
    }
    @Test
    public void test07SeJuegaUnTurnoConUnaMultipleChoiceConPenalidadConModificadoresExclusividadYSeEsperan9Menos2YMenos6Puntos() {

        //arrange
        Simple opcionCorrecta1=  new Simple("San Lorenzo",new Incorrecta());
        Simple opcionCorrecta2= new Simple("Carlos Calvo",new Incorrecta());
        Simple opcionCorrecta3= new Simple("Av. Brasil",new Incorrecta());

        Simple opcionIncorrecta1 = new Simple("México",new Incorrecta());
        Simple opcionIncorrecta2= new Simple("Alicia Moreau de Justo",new Incorrecta());

        List<Opcion> opcionesJugador1 =List.of(opcionCorrecta1,opcionCorrecta2,opcionCorrecta3);
        List<Opcion> opcionesJugador2 =List.of(opcionIncorrecta1);
        List<Opcion> opcionesJugador3 =List.of(opcionIncorrecta1,opcionIncorrecta2);
        Jugador jugador3=new Jugador("Pipo!!!",FabricaModificadores.crearListaModificadores());

        turno.reiniciarTurno(multipleChoicePenalidad);

        Modificador multiplicadorJugador1 = jugador1.obtenerModificadores().get(2);
        Modificador multiplicadorJugador2 = jugador2.obtenerModificadores().get(1);
        Modificador multiplicadorJugador3 = jugador3.obtenerModificadores().get(2);

        turno.agregarRespuesta(opcionesJugador1, jugador1, multiplicadorJugador1);
        turno.agregarRespuesta(opcionesJugador2, jugador2, multiplicadorJugador2);
        turno.agregarRespuesta(opcionesJugador3, jugador3, multiplicadorJugador3);

        //act
        turno.asignarPuntajes();

        // assert

        assertEquals(9, jugador1.obtenerPuntaje());
        assertEquals(-2, jugador2.obtenerPuntaje());
        assertEquals(-6, jugador3.obtenerPuntaje());
    }

    @Test
    public void test08seJuegaUnTurnoConUnaPreguntaVoFClasicaConAnuladorYseLespidePuntos() {
        //arrange


        List<String> contenidoOpciones1 = List.of("Falso");
        List<String> posicion1 = List.of("1");
        List<Opcion> opcionesJugador1 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Correcta()));

        List<String> contenidoOpciones2 = List.of("Falso");
        List<String> posicion2 = List.of();
        List<Opcion> opcionesJugador2 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));


        turno.reiniciarTurno(verdaderoOFalso);


        Modificador nuloJugador1 = jugador1.obtenerModificadores().get(0);
        Modificador anuladorJugador2 = jugador2.obtenerModificadores().get(5);

        turno.agregarRespuesta(opcionesJugador1, jugador1, nuloJugador1);
        turno.agregarRespuesta(opcionesJugador2, jugador2, anuladorJugador2);

        //act
        turno.asignarPuntajes();

        // assert

        assertEquals(0, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());


    }


    @Test
    public void test09AgregarRespuestasConNuloReiniciarYAgregarlasDeVueltaAsignaLosPuntosEsperados() {
        //arrange
        List<String> contenidoOpciones1 = List.of("Verdadero");
        List<String> posicion1 = List.of("1");
        List<Opcion> opcionesJugador1 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Correcta()));

        List<String> contenidoOpciones2 = List.of("Falso");
        List<String> posicion2 = List.of();
        List<Opcion> opcionesJugador2 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));

        turno.reiniciarTurno(verdaderoOFalsoPenalidad);

        Modificador nuloJugador1 = jugador1.obtenerModificadores().get(0);
        Modificador multiplicadorJugador2 = jugador2.obtenerModificadores().get(0);

        turno.agregarRespuesta(opcionesJugador2, jugador2, multiplicadorJugador2);
        turno.agregarRespuesta(opcionesJugador1, jugador1, nuloJugador1);

        turno.asignarPuntajes();
        jugador2.obtenerPuntaje();


        opcionesJugador1 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Incorrecta()));
        opcionesJugador2 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));

        turno.reiniciarTurno(verdaderoOFalsoPenalidad);

        turno.agregarRespuesta(opcionesJugador2, jugador2, multiplicadorJugador2);
        turno.agregarRespuesta(opcionesJugador1, jugador1, nuloJugador1);

        //act
        turno.asignarPuntajes();
        jugador2.obtenerPuntaje();

        // assert
        assertEquals(-2, jugador1.obtenerPuntaje());
        assertEquals(2, jugador2.obtenerPuntaje());
    }


    @Test
    public void test10AgregarRespuestasConUnMultiplicadorYUnNuloReiniciarYAgregarlasDeVueltaAsignaLosPuntosEsperados() {
        //arrange

        List<String> contenidoOpciones1 = List.of("Verdadero");
        List<String> posicion1 = List.of("1");
        List<Opcion> opcionesJugador1 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Correcta()));

        List<String> contenidoOpciones2 = List.of("Falso");
        List<String> posicion2 = List.of();
        List<Opcion> opcionesJugador2 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));


        turno.reiniciarTurno(verdaderoOFalsoPenalidad);


        Modificador nuloJugador = jugador1.obtenerModificadores().get(0);
        Modificador multiplicadorJugador2 = jugador2.obtenerModificadores().get(1);

        turno.agregarRespuesta(opcionesJugador2, jugador2, multiplicadorJugador2);
        turno.agregarRespuesta(opcionesJugador1, jugador1, nuloJugador);


        turno.asignarPuntajes();
        jugador2.obtenerPuntaje();


        opcionesJugador1 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones1, posicion1, new Incorrecta()));
        opcionesJugador2 = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones2, posicion2, new Incorrecta()));


        turno.reiniciarTurno(verdaderoOFalsoPenalidad);


        multiplicadorJugador2 = jugador2.obtenerModificadores().get(1);

        turno.agregarRespuesta(opcionesJugador2, jugador2, multiplicadorJugador2);
        turno.agregarRespuesta(opcionesJugador1, jugador1, nuloJugador);

        //act
        turno.asignarPuntajes();


        jugador2.obtenerPuntaje();
        // assert
        assertEquals(-2, jugador1.obtenerPuntaje());
        assertEquals(5, jugador2.obtenerPuntaje());
    }
}

