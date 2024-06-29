package edu.fiuba.algo3.TestEntrega2.RespuestaTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opcion.Opcion;


import edu.fiuba.algo3.modelo.jugador.Jugador;

import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RespuestaTest {

    private Jugador jugador;

    private List<Opcion> opcionesCorrectas;



    @BeforeEach
    public void setUp() {

        List<Modificador> modificadores = FabricaModificadores.crearListaModificadores();


        List<String> posicionesCorrectas= List.of("1");

        opcionesCorrectas= FabricaOpciones.crearListaSimple(List.of("Correcta","Incorrecta"),posicionesCorrectas, new Correcta());



        jugador = new Jugador("Jugador 1", modificadores);
    }



    @Test
    public void test01AsignarPuntajePasaLosPuntosAsignados() {
        //Arrange
        Respuesta respuesta = new Respuesta(opcionesCorrectas, jugador);

        //Act
        respuesta.asignarPuntaje(1);


        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02MultiplicarPuntajeAsignaLosPuntosEsperados() {
        //Arrange
        Respuesta respuesta = new Respuesta(opcionesCorrectas, jugador);

        //Act
        respuesta.asignarPuntaje(1);
        respuesta.multiplicarPuntaje(2);


        //Assert
        assertEquals(2, respuesta.obtenerPuntaje());
    }

    //TESTEAR: SUMAR PUNTAJE, ES CORRECTA, PERTENECE A


}
