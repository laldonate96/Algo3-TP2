package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.estado.Correcta;
import edu.fiuba.algo3.modelo.estado.Incorrecta;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaConcreta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Multiplicador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RespuestaTest {
    private Jugador jugador;
    private Opcion opcion1;
    private Opcion opcion2;
    private Opcion opcion1Correcta;
    private Modificador modificador;
    private List<Modificador> modificadores;
    private Respuesta respuesta;

    @BeforeEach
    public void setUpClass() {
        modificador = new Multiplicador(2);
        modificadores = new ArrayList<>();
        modificadores.add(modificador);

        opcion1 = new Simple("Falso", new Incorrecta());
        opcion2 = new Simple("Verdadero", new Incorrecta());
        opcion1Correcta = new Simple("Falso", new Correcta());

        jugador = new Jugador("Jugador 1", modificadores);
        respuesta = new RespuestaConcreta(Arrays.asList(opcion1, opcion2), jugador, modificador);
    }

    @Test
    public void test01UnaRespuestaSumaPuntajeCorrectamenteConMultiplicador() {
        respuesta.sumarPuntaje(1);

        assertEquals(2, jugador.obtenerPuntaje());
    }

    @Test
    public void test02ValidarOpcionTeniendoUnaCorrectaCambiaSu() {
        respuesta.validarOpcion(opcion1Correcta);

        assertEquals(true, opcion2.esCorrecta());
    }

    @Test
    public void test03ValidarOpcionesDeUnaRespuestaEstableceElEstadoCorrectamente() {
        respuesta.validarOpcion(opcion1Correcta);

        assertEquals(true, opcion2.esCorrecta());
    }
}
