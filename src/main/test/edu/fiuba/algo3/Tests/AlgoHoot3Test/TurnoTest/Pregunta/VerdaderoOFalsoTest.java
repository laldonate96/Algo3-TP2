package edu.fiuba.algo3.Tests.AlgoHoot3Test.TurnoTest.Pregunta;

import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.excepciones.OpcionesDeTamanioInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.OpcionesIncorrectasException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoOFalsoTest {
    private static VerdaderoFalso pregunta;
    private VerdaderoFalso preguntaConPenalidad;
    private Jugador jugador1;
    private List<Respuesta> respuestas;
    private List<String> contenidoOpciones;

    @BeforeEach
    public void setUp(){
        contenidoOpciones = List.of("Verdadero", "Falso");
        List<String> posicionesDeCorrectas = List.of("2");
        List<Simple> opcionesPregunta = FabricaOpciones.crearListaSimple(contenidoOpciones, posicionesDeCorrectas, new Correcta());
        List<Modificador> modificadores= FabricaModificadores.crearListaModificadores();


        pregunta =new VerdaderoFalso("Grupo1 = aprobado?", opcionesPregunta, new Clasica(1), "Test", "Pregunta siemple.");
         preguntaConPenalidad =new VerdaderoFalso("El grupo 1 entrego el TP en tiempo y forma", opcionesPregunta, new ConPenalidad(), "Test", "Es canon");
         jugador1=new Jugador("Juan", modificadores);
        respuestas=new ArrayList<>();
    }


    @Test
    public void test01RecibeUnaOpcionCorrectaLaValidaYActuaComoCorrecta(){
        List<String> stringsContenido = List.of("Falso");
        List<String> stringsPosiciones = List.of("2");
        List<Opcion> opciones = new ArrayList<>(FabricaOpciones.crearListaSimple(stringsContenido, stringsPosiciones, new Incorrecta()));

        pregunta.validarOpciones(opciones);

        assertEquals(1, opciones.get(0).contarCorrecta());
        assertEquals(0, opciones.get(0).contarIncorrecta());
    }

    @Test
    public void test02RecibeUnaOpcionIncorrectaLaValidaYActuaComoIncorrecta(){
        List<String> stringsContenido = List.of("Verdadero");
        List<String> stringsPosiciones = List.of("1");
        List<Opcion> opciones = new ArrayList<>(FabricaOpciones.crearListaSimple(stringsContenido, stringsPosiciones, new Incorrecta()));

        pregunta.validarOpciones(opciones);

        assertEquals(0, opciones.get(0).contarCorrecta());
        assertEquals(1, opciones.get(0).contarIncorrecta());
    }
    @Test
    public void test03RecibeMasDeUnaOpcionYTiraExcepcionEsperada() {

        List<String> muchasOpciones=new ArrayList<>(contenidoOpciones);
        muchasOpciones.add("pepe");
        List<Opcion> opciones= new ArrayList<>(FabricaOpciones.crearListaSimple(muchasOpciones,List.of("1"),new Correcta()));
        OpcionesDeTamanioInvalidoException thrown = Assertions.assertThrows(OpcionesDeTamanioInvalidoException.class, () -> pregunta.validarOpciones(opciones));
        Assertions.assertEquals(" La respuesta del usuario al Verdadero o Falso contiene mas de una opcion elegida.", thrown.getMessage());
    }
    @Test
    public void test03RecibeUnaOpcionNoSimpleYTiraExcepcionEsperada() {
        List<Opcion> opciones= new ArrayList<>(FabricaOpciones.crearListaOrdenada(List.of("FAAAAALSOOOO"),List.of("1")));

        OpcionesIncorrectasException thrown = Assertions.assertThrows(OpcionesIncorrectasException.class, () -> pregunta.validarOpciones(opciones));

        Assertions.assertEquals(" Una pregunta "+pregunta.getClass().getSimpleName()+ " no acepta este tipo de opciones.", thrown.getMessage());

    }


        @Test
    public void test03ConPuntajeClasicoRecibeUnaRespuestaConUnaOpcionCorrectaYLeAsignaUnPunto() {
            List<String> contenidoOpcion = List.of("Falso");
            List<String> posicionCorrecta = List.of("2");
            List<Opcion> opciones = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpcion, posicionCorrecta, new Incorrecta()));


            pregunta.validarOpciones(opciones);


            Respuesta respuesta = new Respuesta(opciones, jugador1);
            respuestas.add(respuesta);

            //Act
            pregunta.asignarPuntajes(respuestas);

            //Assert
            assertEquals(1, respuesta.obtenerPuntaje());


        }
    @Test
    public void test04ConPuntajeClasicoRecibeUnaRespuestaConUnaOpcionIncorrectaYLeAsigna0Puntos(){
        List<String> contenidoOpcion = List.of("Verdadero");
        List<String> posicionCorrecta = List.of("1");
        List<Opcion> opciones = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpcion,posicionCorrecta, new Correcta()));

        pregunta.validarOpciones(opciones);


        Respuesta respuesta= new Respuesta(opciones,jugador1);
        respuestas.add(respuesta);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());


    }    @Test
    public void test05ConPuntajePenalidadRecibeUnaRespuestaConUnaOpcionCorrectaYLeAsignaUnPunto(){
        List<String> contenidoOpcion = List.of("Falso");
        List<String> posicionCorrecta = List.of("2");
        List<Opcion> opciones = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpcion,posicionCorrecta, new Incorrecta()));


        preguntaConPenalidad.validarOpciones(opciones);


        Respuesta respuesta= new Respuesta(opciones,jugador1);
        respuestas.add(respuesta);

        //Act
        preguntaConPenalidad.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());


    }
    @Test
    public void test04ConPuntajePenalidadRecibeUnaRespuestaConUnaOpcionIncorrectaYLeAsignaMenos1Puntos(){
        List<String> contenidoOpcion = List.of("Verdadero");
        List<String> posicionCorrecta = List.of("1");
        List<Opcion> opciones = new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpcion,posicionCorrecta, new Correcta()));

        preguntaConPenalidad.validarOpciones(opciones);


        Respuesta respuesta= new Respuesta(opciones,jugador1);
        respuestas.add(respuesta);

        //Act
        preguntaConPenalidad.asignarPuntajes(respuestas);

        //Assert
        assertEquals(-1, respuesta.obtenerPuntaje());


    }
}
