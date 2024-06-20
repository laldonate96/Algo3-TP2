package edu.fiuba.algo3.testEntrega3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Multiplicador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.NuloPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.NuloTurno;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.turno.Turno;

public class TurnosTest {



    private VerdaderoFalso vof;
    private VerdaderoFalso vofPenal;
    private ModificadorPuntaje nulo;
    private ModificadorPuntaje multiplicador;


    private List<Opcion> opciones;
    private List<Respuesta> respuestas;
    private List<ModificadorPuntaje> modificadores;
    private Jugador jugador1;
    private Jugador jugador2;
    private NuloTurno nuloTurno;



    @BeforeEach
    public void setUp(){



        List<String> opcionesTexto= Arrays.asList("Correcta", "Incorrecta");
        List<String> posicionesCorrectas= List.of("1");
        opciones= FabricaOpciones.crearListaSimple(opcionesTexto,posicionesCorrectas);

        Clasica clasica = new Clasica(1);
        ConPenalidad penalidad=new ConPenalidad();

        vof = new VerdaderoFalso("un enunciado",opciones, clasica,"Mock");

        vofPenal = new VerdaderoFalso("un enunciado",opciones, penalidad,"Mock");

        modificadores = new ArrayList<>(); // Inicializando la lista de modificadores
        multiplicador = new Multiplicador(2);
        nulo = new NuloPuntaje();
        modificadores.add(nulo);
        modificadores.add(multiplicador);

        nuloTurno=new NuloTurno();


        jugador1 = new Jugador("un jugador", modificadores);
        jugador2 = new Jugador("otro jugador", modificadores);

        respuestas=new ArrayList<>();
        

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
        turno.agregarRespuesta(respuestaJugadores,jugador1,multiplicador);
        turno.agregarRespuesta(respuestaJugadores,jugador2,nulo);

        //act
        turno.asignarPuntajes();

        // assert
        
        assertEquals(2, jugador1.obtenerPuntaje());
        assertEquals(1, jugador2.obtenerPuntaje());
    }
}
