package edu.fiuba.algo3.testEntrega3.ModificadorTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Modificador.Anulador;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
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
        anulador = new Anulador();

        List<String> posicionesCorrectas= List.of("1");
        opcionesCorrectas = FabricaOpciones.crearListaSimple(List.of("Correcta","Incorrecta"),posicionesCorrectas, new Correcta());

        modificador = anulador;
        modificadores = new ArrayList<>();
        jugador = new Jugador("Jugador1", modificadores);

        modificador = new Anulador();
        List<Modificador> modificadores2 = new ArrayList<>();
        modificadores2.add(modificador);
        jugador2 = new Jugador("Jugador2", modificadores2);

        respuesta = new Respuesta(opcionesCorrectas, jugador);
        respuesta.asignarPuntaje(1);

        respuestas = new ArrayList<>();

        modificadores.add(modificador);
        modificadores.add(anulador);
        respuestas.add(respuesta);
    }

    @Test
    public void test01LaRespuestaCorrectaDeUnJugadorQueUsoElAnuladorNoEsModificada() {
        //Arrange
        anulador.establecerDuenio(jugador);

        //Act
        anulador.modificarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02LaRespuestaCorrectaDeUnJugadorQueNoUsoElAnuladorEsModificada() {
        //Arrange
        anulador.establecerDuenio(jugador2);

        //Act
        anulador.modificarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }

    @Test
    public void test03Los5JugadoresUsanUnAnuladorYNingunoRecibePuntos() {
        //Arrange
        anulador.establecerDuenio(jugador);
        anulador.agregarModificador(modificador);

        modificadores = new ArrayList<>();
        modificador= new Anulador();
        modificadores.add(anulador);
        anulador.agregarModificador(modificador);
        Jugador jugador3 = new Jugador("Jugador3", modificadores);

        modificadores = new ArrayList<>();
        modificador= new Anulador();
        modificadores.add(anulador);
        anulador.agregarModificador(modificador);

        Jugador jugador4 = new Jugador("Jugador4", modificadores);

        modificadores = new ArrayList<>();
        modificador= new Anulador();
        modificadores.add(anulador);
        anulador.agregarModificador(modificador);

        Jugador jugador5 = new Jugador("Jugador5", modificadores);

        Respuesta respuesta2 = new Respuesta(opcionesCorrectas, jugador);
        Respuesta respuesta3 = new Respuesta(opcionesCorrectas, jugador);
        Respuesta respuesta4 = new Respuesta(opcionesCorrectas, jugador);
        Respuesta respuesta5 = new Respuesta(opcionesCorrectas, jugador);

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

        //Act
        anulador.modificarPuntajes(respuestas);

        //Assert
        for (Respuesta respuesta:respuestas) {
            assertEquals(0, respuesta.obtenerPuntaje());
        }
    }

    @Test
    public void test04SeBorraAlActualizar() {
        //Act
        int tamanioEsperado= modificadores.size()-1;
        anulador.actualizar(modificadores);

        //Assert
        assertEquals(tamanioEsperado, modificadores.size());
    }
}