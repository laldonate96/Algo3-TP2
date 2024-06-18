package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.opciones.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.modificador.Nulo;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.opciones.opcion.Simple;
import edu.fiuba.algo3.modelo.respuesta.RespuestaConcreta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.modificador.Multiplicador;

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
    private Opcion opcion1;
    private Opcion opcion2;
    private Opcion opcion1Correcta;
    private static Nulo nulo;


    @BeforeAll
    public static void setUpClass(){
        nulo=new Nulo();
        multiplicador = new Multiplicador(2);
    }

    @BeforeEach
    public void setUp() {

        List<ModificadorPuntaje> modificadores = new ArrayList<>();
        modificadores.add(multiplicador);
        modificadores.add(nulo);

        opcion1 = new Simple("Falso", new Incorrecta());
        opcion2 = new Simple("Verdadero", new Incorrecta());
        opcion1Correcta = new Simple("Falso", new Correcta());

        jugador = new Jugador("Jugador 1", modificadores);
    }

    @Test
    public void test01ObtenerOpcionesDaLasOpciones() {
        //Arrange
        List<Opcion> opciones = Arrays.asList(opcion1, opcion2);
        RespuestaConcreta respuesta = new RespuestaConcreta(opciones, jugador, nulo);

        //Act
        List<Opcion> opcionesObtenidas = respuesta.obtenerOpciones();

        //Assert
        assertEquals(opcionesObtenidas, opciones);
    }

    @Test
    public void test02AsignarPuntajePasaLosPuntosAsignadosConModificadorNulo() {
        //Arrange
        RespuestaConcreta respuesta = new RespuestaConcreta(Arrays.asList(opcion1, opcion2), jugador, nulo);

        //Act
        respuesta.asignarPuntaje(1);

        //Assert
        assertEquals(1, jugador.obtenerPuntaje());
    }

    @Test
    public void test03AsignarPuntajePasaLosPuntosEsperadosConModificadorNoNulo() {
        //Arrange
        RespuestaConcreta respuesta = new RespuestaConcreta(Arrays.asList(opcion1, opcion2), jugador, multiplicador);

        //Act
        respuesta.asignarPuntaje(1);


        //Assert
        assertEquals(2, jugador.obtenerPuntaje());
    }

    @Test
    public void test04ValidarOpcionRecibiendoUnaCorrectaActualizaSuEstado() {
        RespuestaConcreta respuesta = new RespuestaConcreta(Arrays.asList(opcion1, opcion2), jugador, nulo);

        respuesta.validarOpcion(opcion1Correcta);

        assertTrue(opcion1.esCorrecta());
    }

    @Test
    public void test05ValidarOpcionRecibiendoUnaIncorretaActualizaSuEstado() {
        RespuestaConcreta respuesta = new RespuestaConcreta(Arrays.asList(opcion1, opcion2), jugador, nulo);

        respuesta.validarOpcion(opcion1Correcta);

        assertFalse(opcion2.esCorrecta());
    }
}
