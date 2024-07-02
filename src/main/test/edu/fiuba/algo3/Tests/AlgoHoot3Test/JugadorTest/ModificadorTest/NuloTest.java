package edu.fiuba.algo3.Tests.AlgoHoot3Test.JugadorTest.ModificadorTest;


import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.Nulo;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NuloTest {


    private Modificador nulo;
    private List<Modificador> modificadores;
    private Respuesta respuesta;
    private List<Respuesta> respuestas;


    @BeforeEach
    public void setUp() {

        nulo=new Nulo();

        List<String> posicionesCorrectas = List.of("1");
        List<Opcion> opcionesCorrectas = new ArrayList<>(FabricaOpciones.crearListaSimple(List.of("Correcta", "Incorrecta"), posicionesCorrectas, new Correcta()));


        modificadores = new ArrayList<>();

        Jugador jugador = new Jugador("Jugador1", modificadores);

        respuesta = new Respuesta(opcionesCorrectas, jugador);
        respuesta.asignarPuntaje(1);
        respuestas = new ArrayList<>();
        respuestas.add(respuesta);

    }




    @Test
    public void test01NoSeBorra() {
        //Act
        int tamanioEsperado= modificadores.size();

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


    @Test
    public void test06MostrarModificadorDevuelveElMensajeEsperado() {
        //Act

        String mensaje="Modificador usado: Ninguno";



        //Assert
        Assertions.assertEquals(mensaje, nulo.mostrarModificador());
    }

}
