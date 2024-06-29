package edu.fiuba.algo3.testEntrega3.ModificadorTurnoTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Anulador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Modificador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.Anulador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnuladorTurnoTest {

    private Modificador anulador;
    private Jugador jugador;
    private Jugador jugador2;
    private Respuesta respuesta;
    private ArrayList<Respuesta> respuestas;
    private Modificador modificador;
    private List<Modificador> modificadores;
    private List<Opcion> opcionesCorrectas;

    @BeforeEach
    public void setUp() {
        anulador = new Anulador(new Anulador());

        List<String> posicionesCorrectas= List.of("1");
        opcionesCorrectas = FabricaOpciones.crearListaSimple(List.of("Correcta","Incorrecta"),posicionesCorrectas, new Correcta());
        modificador = new Anulador();
        modificadores = new ArrayList<>();
        modificadores.add(modificador);

        jugador = new Jugador("Jugador1", modificadores);

        modificador = new Anulador();
        modificadores = new ArrayList<>();
        modificadores.add(modificador);
        jugador2 = new Jugador("Jugador2", modificadores);

        respuesta = new Respuesta(opcionesCorrectas, jugador, modificador);
        respuesta.asignarPuntaje(10);

        respuestas = new ArrayList<>();
        respuestas.add(respuesta);
    }

    @Test
    public void test01LaRespuestaCorrectaDeUnJugadorQueUsoElAnuladorNoEsModificada() {
        //Arrange
        anulador.usar(modificador,jugador);

        //Act
        anulador.modificarPuntajes(respuestas);

        //Assert
        assertEquals(10, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02LaRespuestaCorrectaDeUnJugadorQueNoUsoElAnuladorEsModificada() {
        //Arrange
        anulador.usar(modificador,jugador2);

        //Act
        anulador.modificarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }

    @Test
    public void test03Los5JugadoresUsanUnAnuladorYNingunoRecibePuntos() {
        //Arrange
        modificadores = new ArrayList<>();
        modificadores.add(new Anulador());
        Jugador jugador3 = new Jugador("Jugador3", modificadores);
        modificadores = new ArrayList<>();
        modificadores.add(new Anulador());
        Jugador jugador4 = new Jugador("Jugador4", modificadores);
        modificadores = new ArrayList<>();
        modificadores.add(new Anulador());
        Jugador jugador5 = new Jugador("Jugador5", modificadores);

        Respuesta respuesta2 = new Respuesta(opcionesCorrectas, jugador, modificador);
        Respuesta respuesta3 = new Respuesta(opcionesCorrectas, jugador, modificador);
        Respuesta respuesta4 = new Respuesta(opcionesCorrectas, jugador, modificador);
        Respuesta respuesta5 = new Respuesta(opcionesCorrectas, jugador, modificador);

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
            anulador.usar(modificador, jugadores.get(i));
        }

        //Act
        anulador.modificarPuntajes(respuestas);

        //Assert
        for (Respuesta respuesta:respuestas) {
            assertEquals(0, respuesta.obtenerPuntaje());
        }
    }
}