package edu.fiuba.algo3.testEntrega3;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.estado.Correcta;
import edu.fiuba.algo3.modelo.estado.Incorrecta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Multiplicador;
import edu.fiuba.algo3.modelo.modificador.Nulo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.turno.Turno;


public class TurnosTest {
    private Turno turno;
    private VerdaderoFalso vof;
    private Modificador nulo;
    private Modificador multiplicador;
    private Correcta correcta;
    private Incorrecta incorrecta;
    private List<Opcion> opciones;
    private List<Respuesta> respuestas;
    private Opcion opcion1;
    private Opcion opcion2;
    private List<Modificador> modificadores;
    private Clasica clasica;
    private Jugador jugador1;
    private Jugador jugador2;

    @BeforeAll
    public  void setUpClass(){
        correcta = new Correcta();
        incorrecta = new Incorrecta();
        opcion1 = new Simple("correcta", correcta);
        opcion2 = new Simple("incorrecta", incorrecta);
        opciones.add(opcion1);
        opciones.add(opcion2);
        vof = new VerdaderoFalso("un enunciado",opciones, clasica);

        turno = new Turno();

    }
    @BeforeEach
    public void setUp(){
        nulo = new Nulo();
        multiplicador = new Multiplicador(2);
        modificadores.add(nulo);
        modificadores.add(multiplicador);
        jugador1 = new Jugador("un jugador", modificadores);
        jugador2 = new Jugador("otro jugador", modificadores);
        
        
    }
    
    @Test
    public void test01seJuegaUnTurnoConUnaPreguntaVoFClasicaYseLespidePuntos(){
       //arrange

        Opcion respuestaJugador1 = new Simple("correcta", incorrecta);
        Opcion respuestaJugador2 = new Simple("incorrecta", incorrecta);
        Respuesta respuesta1 = jugador1.responder(Arrays.asList(respuestaJugador1),opciones, nulo);
        Respuesta respuesta2 = jugador1.responder(Arrays.asList(respuestaJugador1),opciones, nulo);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        //act

        turno.asignarPreguntaDelTurno(vof);
        turno.responderPorTurno(respuestas);

        // assert
        
        assertEquals(1, jugador1.obtenerPuntaje());
        assertEquals(1, jugador1.obtenerPuntaje());
    }

}
