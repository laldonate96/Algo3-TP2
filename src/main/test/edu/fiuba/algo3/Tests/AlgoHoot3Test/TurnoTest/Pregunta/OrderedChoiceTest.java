package edu.fiuba.algo3.Tests.AlgoHoot3Test.TurnoTest.Pregunta;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.excepciones.OpcionesDeTamanioInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.OpcionesIncorrectasException;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.pregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderedChoiceTest {


    private static List<String> ordenCorrecto;
    private static List<String> contenidoOpciones;
    private OrderedChoice pregunta;
    private Jugador jugador1;
    private List<Respuesta> respuestas;

    @BeforeAll
    public static void setUpClass(){
        String textoOpcion1="COBOL";
        String textoOpcion2="Go";
        String textoOpcion3="Smalltalk";
        String textoOpcion4 = "C++";
        String textoOpcion5 = "Java";
        String textoOpcion6 = "Python";
        contenidoOpciones = List.of(textoOpcion1, textoOpcion2, textoOpcion3, textoOpcion4, textoOpcion5, textoOpcion6);
        ordenCorrecto = List.of("1", "3","4","6","5", "2");
    }

    @BeforeEach
    public void setUp() {
        List<Modificador> modificadores= FabricaModificadores.crearListaModificadores();
        List<Ordenada> opcionesPregunta = FabricaOpciones.crearListaOrdenada(contenidoOpciones, ordenCorrecto);
        jugador1=new Jugador("Juan", modificadores);
        Clasica clasica = new Clasica(6);
        pregunta = new OrderedChoice(
                "Ordenar las siguientes opciones",
                opcionesPregunta,
                clasica,
                "Tema","Say no More"
        );
        respuestas = new ArrayList<>();
    }



    @Test
    public void test01RecibeOpcionesCorrectasLasValidaYActuanComoCorrectas(){


        List<Opcion> opciones =new ArrayList<> (FabricaOpciones.crearListaOrdenada(contenidoOpciones,ordenCorrecto));

        pregunta.validarOpciones(opciones);

        for (int i = 0; i < 6; i++) {
            assertEquals(1, opciones.get(i).contarCorrecta());
            assertEquals(0, opciones.get(i).contarIncorrecta());
        }
    }

    @Test
    public void test02RecibeOpcionesIncorrectasLasValidaYActuanComoIncorrectas(){

        List<String> ordenIncorrecto=List.of("2","4","6","1","3","5");
        List<Opcion> opciones =new ArrayList<> (FabricaOpciones.crearListaOrdenada(contenidoOpciones,ordenIncorrecto));

        pregunta.validarOpciones(opciones);

        for (int i = 0; i < 6; i++) {
            assertEquals(0, opciones.get(i).contarCorrecta());
            assertEquals(1, opciones.get(i).contarIncorrecta());
        }
    }

    @Test
    public void test03RecibeOpcionesCorrectasEIncorrectasLasValidaYActuanComoCorrectasEIncorrectas(){


        List<String> ordenMezclado=List.of("1","3","2","4","6","5");
        List<Opcion> opciones =new ArrayList<> (FabricaOpciones.crearListaOrdenada(contenidoOpciones,ordenMezclado));

        pregunta.validarOpciones(opciones);

        for (int i = 0; i < 6; i++) {
            if (i==0 || i== 2){
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
    public void test03RecibeUnaOpcionNoOrdenadaYTiraExcepcionEsperada() {
        List<Opcion> opciones= new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones,List.of("1"),new Correcta()));

        OpcionesIncorrectasException thrown = Assertions.assertThrows(OpcionesIncorrectasException.class, () -> pregunta.validarOpciones(opciones));
        Assertions.assertEquals(" Una pregunta "+pregunta.getClass().getSimpleName()+ " no acepta este tipo de opciones.", thrown.getMessage());    }
    @Test
    public void test04Asigna1PuntoAUnaRespuestaConOpcionesCorrectas() {
        //Arrange
        List<Opcion> opcionesJugador;
        opcionesJugador = new ArrayList<>(FabricaOpciones.crearListaOrdenada(contenidoOpciones, ordenCorrecto));
        pregunta.validarOpciones(opcionesJugador);

        Respuesta respuesta = new Respuesta(opcionesJugador, jugador1);
        respuestas.add(respuesta);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }

    @Test
    public void test5Asigna0PuntosAUnaRespuestaConAlMenosUnaOpcionIncorrecta() {
        //Arrange

        List<String> ordenDosIncorrectas=List.of("2","3","4","6","5","1");
        List<Opcion> opcionesJugador;
        opcionesJugador = new ArrayList<> (FabricaOpciones.crearListaOrdenada(contenidoOpciones,ordenDosIncorrectas));


        pregunta.validarOpciones(opcionesJugador);

        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1);
        respuestas.add(respuesta);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }
}
