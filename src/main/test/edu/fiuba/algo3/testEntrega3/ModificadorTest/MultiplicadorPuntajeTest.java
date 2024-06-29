package edu.fiuba.algo3.testEntrega3.ModificadorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import edu.fiuba.algo3.modelo.Modificador.Multiplicador;

public class MultiplicadorPuntajeTest {

    private Modificador multiplicadorDos;
    private Modificador multiplicadorTres;
    private List<Modificador> modificadores;
    private List<Respuesta> respuestas;
    private Jugador jugador;
    private Respuesta respuesta;
    private List<Opcion> opcionesCorrectas;


    @BeforeEach
    public void setUp() {
        multiplicadorDos = new Multiplicador(2);
        multiplicadorTres = new Multiplicador(3);


        List<String> posicionesCorrectas = List.of("1");
        opcionesCorrectas = FabricaOpciones.crearListaSimple(List.of("Correcta", "Incorrecta"), posicionesCorrectas, new Correcta());


        modificadores = new ArrayList<>();

        jugador = new Jugador("Jugador1", modificadores);

        respuesta = new Respuesta(opcionesCorrectas, jugador);
        respuesta.asignarPuntaje(1);
        respuestas = new ArrayList<>();
        respuestas.add(respuesta);

    }


    @Test
    public void test01SeBorraAlActualizar() {
        //Act

        modificadores.add(multiplicadorDos);

        int tamanioEsperado= modificadores.size()-1;

        multiplicadorDos.actualizar(modificadores);

        //Assert
        assertEquals(tamanioEsperado, modificadores.size());
    }

    @Test
    public void test03ModificaElPuntajeDeLarRespuestaAdecuada() {
        //Arrange
        int puntajeEsperado = 2;
        multiplicadorDos.establecerDuenio(jugador);
        //Act
        multiplicadorDos.modificarPuntajes(respuestas);

        //Assert
        assertEquals(puntajeEsperado, respuesta.obtenerPuntaje());
    }

    @Test
    public void test04MultiplicadorConOtroFactorModificaPuntajeDeManeraEsperada() {
        //Arrange
        int puntajeEsperado = 3;
        multiplicadorTres.establecerDuenio(jugador);
        //Act
        multiplicadorTres.modificarPuntajes(respuestas);

        //Assert
        assertEquals(puntajeEsperado, respuesta.obtenerPuntaje());
    }

    @Test
    public void test04NoModificaPuntajeDeRespuestasDeOtroJugador() {
        //Arrange

        multiplicadorDos.establecerDuenio(jugador);

        modificadores = new ArrayList<>();
        Jugador jugador2 = new Jugador("Jugador2", modificadores);

        modificadores = new ArrayList<>();
        Jugador jugador3 = new Jugador("Jugador3", modificadores);

        modificadores = new ArrayList<>();
        Jugador jugador4 = new Jugador("Jugador4", modificadores);

        modificadores = new ArrayList<>();
        Jugador jugador5 = new Jugador("Jugador4", modificadores);

        Respuesta respuesta2 = new Respuesta(opcionesCorrectas, jugador2);
        Respuesta respuesta3 = new Respuesta(opcionesCorrectas, jugador3);
        Respuesta respuesta4 = new Respuesta(opcionesCorrectas, jugador4);
        Respuesta respuesta5 = new Respuesta(opcionesCorrectas, jugador5);


        respuestas = new ArrayList<>();
        respuestas.add(respuesta2);
        respuestas.add(respuesta3);
        respuestas.add(respuesta4);
        respuestas.add(respuesta5);
        respuestas.remove(respuesta);

        //Act

        for (Respuesta respuesta : respuestas) {
            respuesta.asignarPuntaje(1);
        }
        multiplicadorDos.modificarPuntajes(respuestas);

        //Assert
        for (Respuesta respuesta : respuestas) {
            assertEquals(1, respuesta.obtenerPuntaje());
        }
    }
}