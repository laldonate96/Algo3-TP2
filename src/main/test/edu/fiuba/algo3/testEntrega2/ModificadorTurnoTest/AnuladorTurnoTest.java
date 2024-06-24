package edu.fiuba.algo3.testEntrega2.ModificadorTurnoTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.AnuladorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.AnuladorTurno;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.ModificadorTurno;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnuladorTurnoTest {

    private ModificadorTurno anulador;
    private Jugador jugador;
    private Jugador jugador2;
    private Respuesta respuesta;
    private ArrayList<Respuesta> respuestas;
    private ModificadorPuntaje modificadorPuntaje;
    private List<ModificadorPuntaje> modificadores;
    private List<Opcion> opcionesCorrectas;

    @BeforeEach
    public void setUp() {
        anulador = new AnuladorTurno(new AnuladorPuntaje());

        List<String> posicionesCorrectas= List.of("1");
        opcionesCorrectas = FabricaOpciones.crearListaSimple(List.of("Correcta","Incorrecta"),posicionesCorrectas, new Correcta());
        modificadorPuntaje = new AnuladorPuntaje();
        modificadores = new ArrayList<>();
        modificadores.add(modificadorPuntaje);

        jugador = new Jugador("Jugador1", modificadores);

        modificadorPuntaje = new AnuladorPuntaje();
        modificadores = new ArrayList<>();
        modificadores.add(modificadorPuntaje);
        jugador2 = new Jugador("Jugador2", modificadores);

        respuesta = new Respuesta(opcionesCorrectas, jugador, modificadorPuntaje);
        respuesta.asignarPuntaje(10);

        respuestas = new ArrayList<>();
        respuestas.add(respuesta);
    }

    @Test
    public void test01LaRespuestaCorrectaDeUnJugadorQueUsoElAnuladorNoEsModificada() {
        //Arrange
        anulador.usar(modificadorPuntaje,jugador);

        //Act
        anulador.modificarPuntajes(respuestas);

        //Assert
        assertEquals(10, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02LaRespuestaCorrectaDeUnJugadorQueNoUsoElAnuladorEsModificada() {
        //Arrange
        anulador.usar(modificadorPuntaje,jugador2);

        //Act
        anulador.modificarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }

    @Test
    public void test03Los5JugadoresUsanUnAnuladorYNingunoRecibePuntos() {
        //Arrange
        modificadores = new ArrayList<>();
        modificadores.add(new AnuladorPuntaje());
        Jugador jugador3 = new Jugador("Jugador3", modificadores);
        modificadores = new ArrayList<>();
        modificadores.add(new AnuladorPuntaje());
        Jugador jugador4 = new Jugador("Jugador4", modificadores);
        modificadores = new ArrayList<>();
        modificadores.add(new AnuladorPuntaje());
        Jugador jugador5 = new Jugador("Jugador5", modificadores);

        Respuesta respuesta2 = new Respuesta(opcionesCorrectas, jugador, modificadorPuntaje);
        Respuesta respuesta3 = new Respuesta(opcionesCorrectas, jugador, modificadorPuntaje);
        Respuesta respuesta4 = new Respuesta(opcionesCorrectas, jugador, modificadorPuntaje);
        Respuesta respuesta5 = new Respuesta(opcionesCorrectas, jugador, modificadorPuntaje);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);
        jugadores.add(jugador5);

        respuestas.add(respuesta);
        respuestas.add(respuesta2);
        respuestas.add(respuesta3);
        respuestas.add(respuesta4);
        respuestas.add(respuesta5);

        for (int i = 0; i < 5; i++) {
            respuestas.get(i).asignarPuntaje(1);
            anulador.usar(modificadorPuntaje, jugadores.get(i));
        }

        //Act
        anulador.modificarPuntajes(respuestas);

        //Assert
        for (Respuesta respuesta:respuestas) {
            assertEquals(0, respuesta.obtenerPuntaje());
        }
    }
}