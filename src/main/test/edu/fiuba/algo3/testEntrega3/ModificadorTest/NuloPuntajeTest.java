package edu.fiuba.algo3.testEntrega3.ModificadorTest;


import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.Nulo;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NuloPuntajeTest {


    private Modificador nulo;
    private List<Modificador> modificadores;
    private List<Opcion> opcionesCorrectas;
    private Jugador jugador;
    private Respuesta respuesta;
    private List<Respuesta> respuestas;


    @BeforeEach
    public void setUp() {

        nulo=new Nulo();

        List<String> posicionesCorrectas = List.of("1");
        opcionesCorrectas = new ArrayList<>(FabricaOpciones.crearListaSimple(List.of("Correcta", "Incorrecta"), posicionesCorrectas, new Correcta()));


        modificadores = new ArrayList<>();

        jugador = new Jugador("Jugador1", modificadores);

        respuesta = new Respuesta(opcionesCorrectas, jugador);
        respuesta.asignarPuntaje(1);
        respuestas = new ArrayList<>();
        respuestas.add(respuesta);

    }




    @Test
    public void test01NoSeBorra() {
        //Act
        int tamanioEsperado= modificadores.size()-0;

        nulo.actualizar(modificadores);

        //Assert
        assertEquals(tamanioEsperado, modificadores.size());
    }

    @Test
    public void test03NoModificaPuntaje() {
        //Arrange


        //Act
         nulo.modificarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }


}
