package edu.fiuba.algo3.TestEntrega2.Pregunta;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.pregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderedChoiceTest {


    private static List<String> ordenCorrecto;
    private static List<String> opcionesTexto;
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
        opcionesTexto= List.of(textoOpcion1, textoOpcion2, textoOpcion3, textoOpcion4, textoOpcion5, textoOpcion6);

        ordenCorrecto = List.of("1", "3","4","6","5", "2");
    }

    @BeforeEach
    public void setUp() {
        List<Modificador> modificadores= FabricaModificadores.crearListaModificadores();



        List<Ordenada> opcionesPregunta = FabricaOpciones.crearListaOrdenada(opcionesTexto, ordenCorrecto);


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
    public void test01RecibeOpcionesCorrectasYSuEstadoEsElEsperado(){


        List<Opcion> opciones =new ArrayList<> (FabricaOpciones.crearListaOrdenada(opcionesTexto,ordenCorrecto));

        pregunta.validarOpciones(opciones);

        for (int i = 0; i < 6; i++) {
            assertEquals(1, opciones.get(i).contarCorrecta());
            assertEquals(0, opciones.get(i).contarIncorrecta());
        }
    }

    @Test
    public void test02ManejadorRecibeOpcionesIncorrectasYLasValidaCorrectamente(){

        List<String> ordenIncorrecto=List.of("2","4","6","1","3","5");
        List<Opcion> opciones =new ArrayList<> (FabricaOpciones.crearListaOrdenada(opcionesTexto,ordenIncorrecto));

        pregunta.validarOpciones(opciones);

        for (int i = 0; i < 6; i++) {
            assertEquals(0, opciones.get(i).contarCorrecta());
            assertEquals(1, opciones.get(i).contarIncorrecta());
        }
    }

//    @Test
//    public void test03RecibeOpcionesCorrectasEIncorrectasYLasValidaCorrectamente(){
//
//
//        List<String> ordenMezclado=List.of("1","3","2","4","6","5");
//        List<Opcion> opciones =new ArrayList<> (FabricaOpciones.crearListaOrdenada(opcionesTexto,ordenMezclado));
//
//        pregunta.validarOpciones(opciones);
//
//        for (int i = 0; i < 6; i++) {
//            if (i < 2){
//                assertEquals(1, opciones.get(i).contarCorrecta());
//                assertEquals(0, opciones.get(i).contarIncorrecta());
//            } else {
//                assertEquals(0, opciones.get(i).contarCorrecta());
//                assertEquals(1, opciones.get(i).contarIncorrecta());
//            }
//        }
//    }



    @Test
    public void test04Asigna1PuntoAUnaRespuestaConOpcionesCorrectas(){
        //Arrange
        List<Opcion> opcionesJugador;
        opcionesJugador =new ArrayList<>(FabricaOpciones.crearListaOrdenada(opcionesTexto,ordenCorrecto));
        pregunta.validarOpciones(opcionesJugador);

        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1);
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
        opcionesJugador = new ArrayList<> (FabricaOpciones.crearListaOrdenada(opcionesTexto,ordenDosIncorrectas));


        pregunta.validarOpciones(opcionesJugador);

        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1);
        respuestas.add(respuesta);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(0, respuesta.obtenerPuntaje());
    }
}
