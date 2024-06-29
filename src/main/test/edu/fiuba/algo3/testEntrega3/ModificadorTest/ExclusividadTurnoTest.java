package edu.fiuba.algo3.testEntrega3.ModificadorTest;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;


import edu.fiuba.algo3.modelo.Modificador.Multiplicador;
import edu.fiuba.algo3.modelo.Modificador.Exclusividad;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadTurnoTest {

    private Modificador exclusividad;
    private Jugador jugador;
    private Jugador jugador2;
    private Respuesta respuesta;
    private Respuesta respuesta2;
    private ArrayList<Respuesta> respuestas;
    private Modificador modificadorJugador2;
    private List<Modificador> modificadores;
    private List<Opcion> opcionesCorrectas;

    @BeforeEach
    public void setUp() {
        exclusividad = new Exclusividad();

        List<String> posicionesCorrectas= List.of("1");
        opcionesCorrectas = FabricaOpciones.crearListaSimple(List.of("Correcta","Incorrecta"),posicionesCorrectas, new Correcta());

        List<Modificador> modificadoresJugadores = new ArrayList<>();
        modificadoresJugadores.add(new Exclusividad());
        modificadoresJugadores.add(new Multiplicador(2));

        jugador = new Jugador("Jugador1", modificadoresJugadores);

        respuesta = new Respuesta(opcionesCorrectas, jugador);
        respuesta.asignarPuntaje(1);

        respuestas = new ArrayList<>();
        respuestas.add(respuesta);

        modificadorJugador2 = new Exclusividad();
        modificadoresJugadores = new ArrayList<>();
        modificadoresJugadores.add(modificadorJugador2);
        jugador2 = new Jugador("Jugador2", modificadoresJugadores);

        respuesta2 = new Respuesta(opcionesCorrectas, jugador);
        respuesta2.asignarPuntaje(0);

        modificadores = new ArrayList<>();
        modificadores.add(exclusividad);

        respuestas.add(respuesta2);
    }


    @Test
    public void test01UnJugadorRespodeBienYSeDuplicaElPuntajeDeSuRespuesta() {
        //Arrange


        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(2, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02UnJugadorRespodeBienYElMismoUsaLaExclusividadSeDuplicaElPuntajeDeSuRespuesta() {
        //Arrange
        exclusividad.establecerDuenio(jugador);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(2, respuesta.obtenerPuntaje());
    }

    @Test
    public void test03UnJugadorRespodeBienYConMultiplesLlamadosYSeCuatriplicaElPuntajeDeSuRespuesta() {
        //Arrange
        exclusividad.agregarModificador(modificadorJugador2);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(4, respuesta.obtenerPuntaje());
    }

    @Test
    public void test04MultiplesLlamadosMultiplicanElEfecto() {
        //Arrange
        Modificador exclusividad1=new Exclusividad();
        exclusividad1.establecerDuenio(jugador);

        exclusividad.agregarModificador(exclusividad1);

        Modificador exclusividad2=new Exclusividad();
        exclusividad2.establecerDuenio(jugador2);

        exclusividad.agregarModificador(exclusividad2);


        Modificador exclusividad3=new Exclusividad();
        exclusividad3.establecerDuenio(jugador2);
        List<Modificador> modificadoresJugador3= List.of(exclusividad3);
        exclusividad1.establecerDuenio(new Jugador("jugador3", modificadoresJugador3));

        exclusividad.agregarModificador(exclusividad3);


        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(8, respuesta.obtenerPuntaje());
    }

    @Test

    public void test05RecibeDosRespuestasCorrectasYAnulaLosPuntosDeAmbas() {
        //Arrange
        exclusividad.agregarModificador(modificadorJugador2);

        respuesta2.asignarPuntaje(1);
        respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        respuestas.add(respuesta2);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        assertEquals(0, respuesta.obtenerPuntaje());
        assertEquals(0, respuesta2.obtenerPuntaje());
    }

    @Test
    public void test06AUnaRespuestaCorrectaDeUnJugadorQueNoActivoExclusividadSeLeDuplicaElPuntaje() {
        //Arrange
        exclusividad.establecerDuenio(jugador2);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(2, respuesta.obtenerPuntaje());
    }

    @Test
    public void test06RecibeMultiplesIncorrectasYUnaCorrectaALaCualLeMultiplicaElPuntaje() {

        Exclusividad exclusividad3 = new Exclusividad();
        List<Modificador> modificadoresJugador3= List.of(exclusividad3);
        Jugador jugador3=new Jugador("jugador3", modificadoresJugador3);
        exclusividad3.establecerDuenio(jugador3);
        Respuesta respuesta3 = new Respuesta(opcionesCorrectas, jugador3);
        respuesta3.asignarPuntaje(0);

        //Act
        exclusividad.modificarPuntajes(respuestas);

        //Assert
        assertEquals(2, respuesta.obtenerPuntaje());
        assertEquals(0, respuesta2.obtenerPuntaje());
        assertEquals(0, respuesta3.obtenerPuntaje());
    }
    @Test
    public void test07SeBorraAlActualizar() {
        //Act
        int tamanioEsperado= modificadores.size()-1;
        exclusividad.actualizar(modificadores);

        //Assert
        assertEquals(tamanioEsperado, modificadores.size());
    }
}
