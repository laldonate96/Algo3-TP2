package edu.fiuba.algo3.Tests.AlgoHoot3Test.TurnosTest.Pregunta;


import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Fabricas.FabricaModificadores;

import edu.fiuba.algo3.modelo.excepciones.OpcionesDeTamanioInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.OpcionesIncorrectasException;
import edu.fiuba.algo3.modelo.opcion.Grupal;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.pregunta.GroupChoice;
import edu.fiuba.algo3.modelo.puntaje.Clasica;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;



public class GroupChoiceTest {

    private static List<String> contenidoOpciones;
    private Jugador jugador1;
    static List<String> posicionesCorrectas;
    private List<Respuesta> respuestas;
    private static GroupChoice pregunta;
    private static String deportesIndividuales;
    private static String deportesGrupales;


    @BeforeAll
    public static void setUpClass() {


        posicionesCorrectas= List.of("1","2","5","0","3","4","6");

        deportesGrupales = "En Patota";
        deportesIndividuales = "No en patota";

        contenidoOpciones=List.of("El llio","GINOBILI!!!!","Juanma Delpo","Miguelito","Higuito","Jose");


    }

    @BeforeEach
    public void setUp() {
        List<Modificador> modificadores = FabricaModificadores.crearListaModificadores();
        jugador1 = new Jugador("Jugador 1", modificadores);




        respuestas= new ArrayList<>();
        List<Grupal> opcionesPregunta = FabricaOpciones.crearListaGrupo(List.of(deportesGrupales, deportesIndividuales), contenidoOpciones, posicionesCorrectas);

        pregunta = new GroupChoice("Asigne a las siguientes lellendas si van en patota o son lobos solitarios", opcionesPregunta, new Clasica(6),"DEPORTES","Todos juntos! Say No More . . .");


    }

    @Test
    public void test01RecibeOpcionesCorrectasLasValidaYActuanComoCorrectas(){
        Grupal lioMessi = new Grupal(contenidoOpciones.get(0), deportesGrupales);
        Grupal manuGinobili = new Grupal(contenidoOpciones.get(1), deportesGrupales);
        Grupal juanMartinDelPotro = new Grupal(contenidoOpciones.get(2), deportesIndividuales);
        Grupal miguelNajdorf = new Grupal(contenidoOpciones.get(3), deportesIndividuales);
        Grupal hugoConte = new Grupal(contenidoOpciones.get(4), deportesGrupales);
        Grupal joseMeolans = new Grupal(contenidoOpciones.get(5), deportesIndividuales);

        List<Opcion> opciones =List.of(lioMessi, manuGinobili, juanMartinDelPotro, miguelNajdorf, hugoConte, joseMeolans);


        pregunta.validarOpciones(opciones);

        for (Opcion opcion : opciones) {
            assertEquals(1, opcion.contarCorrecta());
            assertEquals(0, opcion.contarIncorrecta());
        }
    }

    @Test
    public void test02RecibeOpcionesIncorrectasLasValidaYActuanComoIncorrectas(){

        Grupal lioMessi = new Grupal(contenidoOpciones.get(0), deportesIndividuales);
        Grupal manuGinobili = new Grupal(contenidoOpciones.get(1), deportesIndividuales);
        Grupal juanMartinDelPotro = new Grupal(contenidoOpciones.get(2), deportesGrupales);
        Grupal miguelNajdorf = new Grupal(contenidoOpciones.get(3), deportesGrupales);
        Grupal hugoConte = new Grupal(contenidoOpciones.get(4), deportesIndividuales);
        Grupal joseMeolans = new Grupal(contenidoOpciones.get(5), deportesGrupales);


        List<Opcion> opciones = List.of(lioMessi, manuGinobili, juanMartinDelPotro, miguelNajdorf, hugoConte, joseMeolans);

        pregunta.validarOpciones(opciones);

        for (Opcion opcion : opciones) {
            assertEquals(0, opcion.contarCorrecta());
            assertEquals(1, opcion.contarIncorrecta());
        }
    }

    @Test
    public void test03RecibeOpcionesCorrectasEIncorrectasLasValidaYActuanComoCorrectasEIncorrectas(){

        Grupal lioMessi = new Grupal(contenidoOpciones.get(0), deportesIndividuales);
        Grupal manuGinobili = new Grupal(contenidoOpciones.get(1), deportesIndividuales);
        Grupal juanMartinDelPotro = new Grupal(contenidoOpciones.get(2), deportesGrupales);
        Grupal miguelNajdorf = new Grupal(contenidoOpciones.get(3), deportesIndividuales);
        Grupal hugoConte = new Grupal(contenidoOpciones.get(4), deportesGrupales);
        Grupal joseMeolans = new Grupal(contenidoOpciones.get(5), deportesIndividuales);


        List<Opcion> opciones = List.of(lioMessi, manuGinobili, juanMartinDelPotro, miguelNajdorf, hugoConte, joseMeolans);

        pregunta.validarOpciones(opciones);

        for (int i = 0; i < 6; i++) {
            if (i < 3){
                assertEquals(0, opciones.get(i).contarCorrecta());
                assertEquals(1, opciones.get(i).contarIncorrecta());
            } else {
                assertEquals(1, opciones.get(i).contarCorrecta());
                assertEquals(0, opciones.get(i).contarIncorrecta());
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
    public void test05RecibeUnaOpcionNoGrupalYTiraExcepcionEsperada() {
        List<Opcion> opciones= new ArrayList<>(FabricaOpciones.crearListaSimple(contenidoOpciones,List.of("1"),new Correcta()));

        OpcionesIncorrectasException thrown = Assertions.assertThrows(OpcionesIncorrectasException.class, () -> pregunta.validarOpciones(opciones));

        Assertions.assertEquals(" Una pregunta "+pregunta.getClass().getSimpleName()+ " no acepta este tipo de opciones.", thrown.getMessage());

    }
    @Test
    public void test06GroupChoiceAsignaPuntajeCorrectoAJugadorQueRespondeCorrectamente(){
        //Arrange
        Grupal lioMessi = new Grupal(contenidoOpciones.get(0), deportesGrupales);
        Grupal manuGinobili = new Grupal(contenidoOpciones.get(1), deportesGrupales);
        Grupal juanMartinDelPotro = new Grupal(contenidoOpciones.get(2), deportesIndividuales);
        Grupal miguelNajdorf = new Grupal(contenidoOpciones.get(3), deportesIndividuales);
        Grupal hugoConte = new Grupal(contenidoOpciones.get(4), deportesGrupales);
        Grupal joseMeolans = new Grupal(contenidoOpciones.get(5), deportesIndividuales);



        List<Opcion> opcionesJugador = List.of(lioMessi, manuGinobili, juanMartinDelPotro, miguelNajdorf, hugoConte, joseMeolans);

        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1);
        respuestas.add(respuesta);


        //Act
        pregunta.validarOpciones(opcionesJugador);
        pregunta.asignarPuntajes(respuestas);

        //Assert
        assertEquals(1, respuesta.obtenerPuntaje());
    }

    @Test
    public void test07Asigna0PuntosAJugadorQueRespondeConUnaIncorrecta() {
        //Arrange
        Grupal lioMessi = new Grupal(contenidoOpciones.get(0), deportesGrupales);
        Grupal manuGinobili = new Grupal(contenidoOpciones.get(1), deportesGrupales);
        Grupal juanMartinDelPotro = new Grupal(contenidoOpciones.get(2), deportesIndividuales);
        Grupal miguelNajdorf = new Grupal(contenidoOpciones.get(3), deportesGrupales);
        Grupal hugoConte = new Grupal(contenidoOpciones.get(4), deportesGrupales);
        Grupal joseMeolans = new Grupal(contenidoOpciones.get(5), deportesIndividuales);



        List<Opcion> opcionesJugador = List.of(lioMessi, manuGinobili, juanMartinDelPotro, miguelNajdorf, hugoConte, joseMeolans);
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1);
        respuestas.add(respuesta);

        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert

        assertEquals(0, respuesta.obtenerPuntaje());

    }

    @Test
    public void test08Asigna0PuntosAJugadorQueRespondeCon3CorrectasSiendo6Opciones() {
        //Arrange

        Grupal lioMessi = new Grupal(contenidoOpciones.get(0), deportesGrupales);
        Grupal manuGinobili = new Grupal(contenidoOpciones.get(1), deportesGrupales);
        Grupal juanMartinDelPotro = new Grupal(contenidoOpciones.get(2), deportesIndividuales);

        List<Opcion> opcionesJugador = List.of(lioMessi, manuGinobili, juanMartinDelPotro);
        Respuesta respuesta= new Respuesta(opcionesJugador,jugador1);
        respuestas.add(respuesta);



        //Act
        pregunta.asignarPuntajes(respuestas);

        //Assert

        assertEquals(0, respuesta.obtenerPuntaje());

    }
}
