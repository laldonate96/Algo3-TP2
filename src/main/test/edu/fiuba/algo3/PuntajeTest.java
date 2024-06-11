package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.estado.Correcta;
import edu.fiuba.algo3.modelo.estado.Incorrecta;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.puntaje.Parcial;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Multiplicador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PuntajeTest {
    private Jugador jugador;
    private Opcion opcion1;
    private Opcion opcion1Correcta;
    private Opcion opcion2;
    private Opcion opcion3;
    private Modificador modificador;
    private List<Modificador> modificadores;
    private Respuesta respuesta1;
    private Respuesta respuesta2;
    private Puntaje puntaje1;
    private Puntaje puntaje2;
    private Puntaje puntaje3;

    @BeforeEach
    public void setUpClass() {
        modificador = new Multiplicador(2);
        modificadores = new ArrayList<>();
        modificadores.add(modificador);

        opcion1 = new Simple("Opcion 1", new Incorrecta());
        opcion1Correcta = new Simple("Opcion 1", new Correcta());
        opcion2 = new Simple("Opcion 2", new Incorrecta());
        opcion3 = new Simple("Opcion 3", new Incorrecta());

        jugador = new Jugador("Jugador 1", modificadores);
        List<Opcion> opcionesPregunta=Arrays.asList(opcion1Correcta,opcion2,opcion3);
        respuesta1 = jugador.responder(Arrays.asList(opcion1, opcion2, opcion3),opcionesPregunta, modificador);
        respuesta2 = jugador.responder(Arrays.asList(opcion1),opcionesPregunta, modificador);

        puntaje1 = new Clasica();
        puntaje2 = new Parcial();
        puntaje3 = new ConPenalidad();
    }

    @Test
    public void test01UnPuntajeClasicaAsignaCorrectamentePuntosAJugador() {
        puntaje1.asignarPuntaje(respuesta1);

        assertEquals(0, jugador.obtenerPuntaje());
    }

    @Test
    public void test02UnPuntajeParcialAsignaCorrectamentePuntosAJugador() {
        puntaje2.asignarPuntaje(respuesta2);

        assertEquals(2, jugador.obtenerPuntaje());
    }

    @Test
    public void test03UnPuntajeConPenalidadAsignaCorrectamentePuntosAJugador() {
        puntaje3.asignarPuntaje(respuesta1);

        assertEquals(-2, jugador.obtenerPuntaje());
    }
}