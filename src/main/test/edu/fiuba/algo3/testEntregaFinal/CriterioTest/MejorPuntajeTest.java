package edu.fiuba.algo3.testEntregaFinal.CriterioTest;

import edu.fiuba.algo3.modelo.CriterioDeVictoria.MejorPuntaje;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MejorPuntajeTest {

    List<Jugador> jugadores;
    private MejorPuntaje criterio;

    @BeforeEach
    void setUp(){
        Jugador jugador1=new Jugador("Juan", List.of());
        Jugador jugador2=new Jugador("Lucas", List.of());
        Jugador jugador3=new Jugador("Nacho", List.of());
        Jugador jugador4=new Jugador("Felipe", List.of());
        Jugador jugador5=new Jugador("Martin", List.of());
        Jugador jugador6=new Jugador("Santellán", List.of());

        jugadores=List.of(jugador1,jugador2,jugador3,jugador4,jugador5,jugador6);
        criterio=new MejorPuntaje(2,4);

        criterio.establecerJugadores(jugadores);
    }
    @Test
    void test01SabeQueNoTerminoElJuegoSiTodoEstaEn0(){

        //Arrange

        //Act
        criterio.establecerJugadores(jugadores);

        //Assert
        assertFalse(criterio.terminoJuego(0));
    }
    @Test
    void test02SabeQueNoTerminoElJuegoSinTodoEn0(){
        //Arrange
        jugadores.get(0).sumarPuntaje(-1);
        jugadores.get(1).sumarPuntaje(0);
        jugadores.get(2).sumarPuntaje(1);
        jugadores.get(3).sumarPuntaje(2);
        jugadores.get(4).sumarPuntaje(3);
        jugadores.get(5).sumarPuntaje(3);

        //Act
        criterio.establecerJugadores(jugadores);

        //Assert
        assertFalse(criterio.terminoJuego(0));
    }





    @Test
    void test03SabeTerminoElJuegoSiUnJugadorTieneLosPuntosMaximos(){
        //Arrange
        jugadores.get(0).sumarPuntaje(-1);
        jugadores.get(1).sumarPuntaje(0);
        jugadores.get(2).sumarPuntaje(1);
        jugadores.get(3).sumarPuntaje(2);
        jugadores.get(4).sumarPuntaje(3);
        jugadores.get(5).sumarPuntaje(4);

        //Act
        criterio.establecerJugadores(jugadores);

        //Assert
        assertTrue(criterio.terminoJuego(0));

    }

    @Test
    void test04SabeTerminoElJuegoSiLasRondasSuperanElMaximoAsignado(){
        //Arrange
        jugadores.get(0).sumarPuntaje(-1);
        jugadores.get(1).sumarPuntaje(0);
        jugadores.get(2).sumarPuntaje(1);
        jugadores.get(3).sumarPuntaje(2);
        jugadores.get(4).sumarPuntaje(3);
        jugadores.get(5).sumarPuntaje(3);

        //Act
        criterio.establecerJugadores(jugadores);

        //Assert
        assertTrue(criterio.terminoJuego(5));

    }
    @Test
    void test04SabeTerminoElJuegoSiLasRondasSuperanElMaximoAsignadoYUnJugadorTieneElMaximoDePuntos(){
        //Arrange
        jugadores.get(0).sumarPuntaje(-1);
        jugadores.get(1).sumarPuntaje(0);
        jugadores.get(2).sumarPuntaje(1);
        jugadores.get(3).sumarPuntaje(2);
        jugadores.get(4).sumarPuntaje(3);
        jugadores.get(5).sumarPuntaje(4);

        //Act
        criterio.establecerJugadores(jugadores);

        //Assert
        assertTrue(criterio.terminoJuego(5));

    }
    @Test
    void test05OrdenaCorrectamenteAlterminarElJuego(){
        //Arrange
        jugadores.get(1).sumarPuntaje(10);
        jugadores.get(5).sumarPuntaje(4);
        jugadores.get(0).sumarPuntaje(3);
        jugadores.get(3).sumarPuntaje(2);
        jugadores.get(4).sumarPuntaje(-1);
        jugadores.get(2).sumarPuntaje(-51);

        List<Jugador> jugadoresEsperados =List.of(jugadores.get(1),jugadores.get(5),
                                                 jugadores.get(0),jugadores.get(3),
                                                 jugadores.get(4),jugadores.get(2));



        //Act
        criterio.establecerJugadores(jugadores);

        List<Jugador> jugadoresObtenidos=criterio.jugadoresOrdenados();

        //Assert

        assertEquals(jugadoresEsperados.size(),jugadoresObtenidos.size());

        for(int i=0; i<6;i++) {
            assertTrue(jugadoresEsperados.get(i).equals(jugadoresObtenidos.get(i)));

        }

    }




}
