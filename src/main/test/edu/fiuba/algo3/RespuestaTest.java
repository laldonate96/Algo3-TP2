package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opcion.Opcion;


import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.NuloPuntaje;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Multiplicador;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RespuestaTest {
    private static Multiplicador multiplicador;
    private Jugador jugador;
    private static NuloPuntaje nulo;
    private List<Opcion> opcionesCorrectas;



    @BeforeAll
    public static void setUpClass(){
        nulo=new NuloPuntaje();
        multiplicador = new Multiplicador(2);
    }

    @BeforeEach
    public void setUp() {

        List<ModificadorPuntaje> modificadores = new ArrayList<>();
        modificadores.add(multiplicador);
        modificadores.add(nulo);


        List<String> posicionesCorrectas= List.of("1");

        opcionesCorrectas= FabricaOpciones.crearListaSimple(List.of("Correcta","Incorrecta"),posicionesCorrectas);



        jugador = new Jugador("Jugador 1", modificadores);
    }



    @Test
    public void test01AsignarPuntajePasaLosPuntosAsignadosConModificadorNulo() {
        //Arrange
        Respuesta respuesta = new Respuesta(opcionesCorrectas, jugador, nulo);

        //Act
        respuesta.asignarPuntaje(1);

        //Assert
        assertEquals(1, jugador.obtenerPuntaje());
    }

    @Test
    public void test02AsignarPuntajePasaLosPuntosEsperadosConModificadorNoNulo() {
        //Arrange
        Respuesta respuesta = new Respuesta(opcionesCorrectas, jugador, multiplicador);

        //Act
        respuesta.asignarPuntaje(1);


        //Assert
        assertEquals(2, jugador.obtenerPuntaje());
    }
}
