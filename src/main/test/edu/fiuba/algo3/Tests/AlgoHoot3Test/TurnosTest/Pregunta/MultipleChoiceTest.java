package edu.fiuba.algo3.Tests.AlgoHoot3Test.TurnosTest.Pregunta;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;


import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.excepciones.OpcionesDeTamanioInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.OpcionesIncorrectasException;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.puntaje.Parcial;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {
    private static List<Simple> opcionesPregunta2;
    private Jugador jugador1;

    private static Parcial parcial;
    private List<Respuesta> respuestas;
    private MultipleChoice preguntaParcial;
    private static List<String> opcionesTexto2;
    private static List<Simple> opcionesPregunta;
    private static List<String> contenidoOpciones;
    private MultipleChoice pregunta;


    @BeforeAll
    public static void setUpClass() {
        parcial = new Parcial();
        contenidoOpciones = List.of("El disco durisimo", "El Sol", "Las bases de datos relacionales", "El metodo de ordenamiento conocido como ordenar rapido","Los lenguajes");
        List<String> posicionesDeCorrectas = List.of("3");
        opcionesPregunta = FabricaOpciones.crearListaSimple(contenidoOpciones, posicionesDeCorrectas, new Correcta());

        opcionesTexto2 = List.of("Opcion 1", "Opcion 2", "Opcion 3");
        List<String> posicionesCorrectas2 = List.of("1", "2");
        opcionesPregunta2 = FabricaOpciones.crearListaSimple(opcionesTexto2, posicionesCorrectas2, new Correcta());

    }

    @BeforeEach
    public void setUp() {
        List<Modificador> modificadores = FabricaModificadores.crearListaModificadores();


        jugador1 = new Jugador("Jugador 1", modificadores);


        respuestas = new ArrayList<>();
        preguntaParcial = new MultipleChoice("¿Cuáles de las siguientes opciones son opcionesPregunta?", opcionesPregunta2, parcial, "Tema", "Say no More");
        pregunta = new MultipleChoice("¿Cuál fue el aporte más conocido del inglés Edd Codigo a la computación?", opcionesPregunta, new Clasica(1), "Test", "No hay polqué");

    }

    @Test
    public void test01RecibeUnaOpcionCorrectaLaValidaYActuaComoCorrecta(){
        List<String> stringsContenido = List.of(contenidoOpciones.get(2));
        List<String> stringsPosiciones = List.of("3");
        List<Opcion> opciones = new ArrayList<>(FabricaOpciones.crearListaSimple(stringsContenido, stringsPosiciones, new Incorrecta()));

        pregunta.validarOpciones(opciones);

        assertEquals(1, opciones.get(0).contarCorrecta());
        assertEquals(0, opciones.get(0).contarIncorrecta());
    }

    @Test
    public void test02ManejadorRecibeOpcionesIncorrectasLasValidaYActuanComoIncorrectas(){
        List<String> stringsContenido = List.of(contenidoOpciones.get(0),contenidoOpciones.get(1));
        List<String> stringsPosiciones = List.of("1","2");
        List<Opcion> opciones = new ArrayList<>(FabricaOpciones.crearListaSimple(stringsContenido, stringsPosiciones, new Correcta()));

        pregunta.validarOpciones(opciones);

        assertEquals(0, opciones.get(0).contarCorrecta());
        assertEquals(1, opciones.get(0).contarIncorrecta());
        assertEquals(0, opciones.get(1).contarCorrecta());
        assertEquals(1, opciones.get(1).contarIncorrecta());
    }

    @Test
    public void test03ManejadorRecibeOpcionesCorrectasEIncorrectasLasValidaYActuanComoCorrectasEIncorrectas(){
        List<String> stringsContenido = new ArrayList<>(contenidoOpciones);
        List<String> stringsPosiciones = List.of("1", "2");
        List<Opcion> opciones = new ArrayList<>(FabricaOpciones.crearListaSimple(stringsContenido, stringsPosiciones, new Correcta()));

        pregunta.validarOpciones(opciones);

        for(int i=0; i<5;i++){
            if (i==2) {
                assertEquals(1, opciones.get(i).contarCorrecta());
                assertEquals(0, opciones.get(i).contarIncorrecta());
            } else {
                assertEquals(0, opciones.get(i).contarCorrecta());
                assertEquals(1, opciones.get(i).contarIncorrecta());

            }
        }
    }
    @Test
    public void test04RecibeMasOpcionesDeLasQueTieneYTiraLaExcepcionEsperada() {

        List<String> muchasOpciones=new ArrayList<>(contenidoOpciones);
        muchasOpciones.add("pepe");
        List<Opcion> opciones= new ArrayList<>(FabricaOpciones.crearListaSimple(muchasOpciones,List.of("1"),new Correcta()));
        OpcionesDeTamanioInvalidoException thrown = Assertions.assertThrows(OpcionesDeTamanioInvalidoException.class, () -> pregunta.validarOpciones(opciones));

        Assertions.assertEquals(" La respuesta del usuario a una Pregunta "+pregunta.getClass().getSimpleName()+" contiene mas opciones elegidas  que las existentes.", thrown.getMessage());

    }
    @Test
    public void test05RecibeUnaOpcionNoSimpleYTiraExcepcionEsperada() {
        List<Opcion> opciones= new ArrayList<>(FabricaOpciones.crearListaOrdenada(contenidoOpciones,List.of("1")));

        OpcionesIncorrectasException thrown = Assertions.assertThrows(OpcionesIncorrectasException.class, () -> pregunta.validarOpciones(opciones));

        Assertions.assertEquals(" Una pregunta "+pregunta.getClass().getSimpleName()+ " no acepta este tipo de opciones.", thrown.getMessage());
    }
    @Test
    public void test01ConPuntajeParcialAsigna2PuntosAUnJugadorQueRespondio2Correctas() {


        List<Opcion> opcionesJugador= new ArrayList<>(FabricaOpciones.crearListaSimple(List.of(opcionesTexto2.get(0), opcionesTexto2.get(1)),List.of("1", "2"), new Correcta()));
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1);
        respuestas.add(respuesta);

        //Act
        preguntaParcial.asignarPuntajes(respuestas);

        //Assert
        assertEquals(2, respuesta.obtenerPuntaje());
    }

    @Test
    public void test02ConPuntajeParcialAsigna0PuntosAJugadorQueRespondioMal() {


       

        List<Opcion> opcionesJugador=new ArrayList<>(FabricaOpciones.crearListaSimple(List.of("Opcion 1", "Opcion 3"),List.of("1"), new Correcta()));
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1);
        respuestas.add(respuesta);

        //Act
        preguntaParcial.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());

    }
}
