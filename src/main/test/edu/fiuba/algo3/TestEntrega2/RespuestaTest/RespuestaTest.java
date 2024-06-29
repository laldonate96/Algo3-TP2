package edu.fiuba.algo3.TestEntrega2.RespuestaTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opcion.Opcion;


import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Nulo;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Modificador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.Multiplicador;

import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RespuestaTest {
    private static Multiplicador multiplicador;
    private Jugador jugador;
    private static Nulo nulo;
    private List<Opcion> opcionesCorrectas;


    @BeforeAll
    public static void setUpClass(){
        nulo=new Nulo();
        multiplicador = new Multiplicador(2);
    }

    @BeforeEach
    public void setUp() {

        List<Modificador> modificadores = new ArrayList<>();
        modificadores.add(multiplicador);
        modificadores.add(nulo);


        List<String> posicionesCorrectas= List.of("1");

        opcionesCorrectas= FabricaOpciones.crearListaSimple(List.of("Correcta","Incorrecta"),posicionesCorrectas, new Correcta());



        jugador = new Jugador("Jugador 1", modificadores);
    }



    @Test
    public void test01AsignarPuntajePasaLosPuntosAsignadosConModificadorNulo() {
        //Arrange
        Respuesta respuesta = new Respuesta(opcionesCorrectas, jugador, nulo);

        //Act
        respuesta.asignarPuntaje(1);


        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02AsignarPuntajePasaLosPuntosEsperadosConModificadorNoNulo() {
        //Arrange
        Respuesta respuesta = new Respuesta(opcionesCorrectas, jugador, multiplicador);

        //Act
        respuesta.asignarPuntaje(1);


        //Assert
        assertEquals(2, respuesta.obtenerPuntaje());
    }
}
