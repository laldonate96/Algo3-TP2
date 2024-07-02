package edu.fiuba.algo3.Tests.LectorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import edu.fiuba.algo3.modelo.lector.mezclador.MezclaNula;
import edu.fiuba.algo3.modelo.opcion.Grupal;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.lector.Lector;

public class LectorTest {

    private List<Pregunta> preguntasLeidas;

    @BeforeEach
    public void setUp() {
       preguntasLeidas = Lector.obtenerPreguntasDeJson(new MezclaNula(),("recursos/test.json"));

    }

    @Test
    public void test01UnArchivoJsonCon7PreguntasAlLeerseCreaUnaListaDe7Preguntas() {
        assertEquals(14, preguntasLeidas.size());
    }
//    @Test
//    public void test02UnArchivoJsonCon7PreguntasAlLeerseCreaUnaListaDe7Preguntas() {
//        preguntasLeidas = Lector.obtenerPreguntasDeJson(new MezclaNula(),("recursos/preguntas.json"));
//        assertEquals(1, preguntasLeidas.size());
//    }
    @Test
    public void test02UnaVerdaderoOFalsoLeidaEsIgualALaEsperada() {

        //Arrange
        String categoriaEsperada = "COMPUTACION";
        String enunciadoEsperado = "Smalltalk es un lenguaje de programación muerto";
        String explicacionEsperada = "Eee...  no vimos nada!";


        Simple verdadero = new Simple("Verdadero", new Correcta());
        Simple falso = new Simple("Falso", new Incorrecta());

        List<Simple> opcionesEsperadas = List.of(verdadero, falso);

        Simple opcionObtenida;
        Simple opcionEsperada;


        //Act
        VerdaderoFalso preguntaLeida = (VerdaderoFalso) preguntasLeidas.get(1);
        List<Simple> opcionesObtenidas = preguntaLeida.obtenerOpciones();

        //Assert
        assertEquals(categoriaEsperada, preguntaLeida.obtenerCategoria());
        assertEquals(enunciadoEsperado, preguntaLeida.obtenerEnunciado());
        assertEquals(explicacionEsperada, preguntaLeida.obtenerExplicacion());



        for (int iterador = 0; iterador < 2; iterador++) {

            opcionObtenida = opcionesObtenidas.get(iterador);
            opcionEsperada = opcionesEsperadas.get(iterador);
            opcionObtenida.actualizarEstado(opcionEsperada);
            if (iterador == 1) {
                assertEquals(1, opcionEsperada.contarCorrecta());
                assertEquals(0, opcionEsperada.contarIncorrecta());
            } else{
                assertEquals(0, opcionEsperada.contarCorrecta());
                assertEquals(1, opcionEsperada.contarIncorrecta());
            }
        }


    }
    @Test
    public void test03UnaMultipleChoiceLeidaEsIgualALaEsperada() {

        //Arrange
        String categoriaEsperada = "ARTE";
        String enunciadoEsperado = "¿Qué películas fueron dirigidas por el cineasta estadounidense Francis Ford Coppola?";
        String explicacionEsperada = "Coppola dirigió El Padrino y El Gran Gatsby en su version original (Sin Di Caprio)";


        Simple elGranGatsby = new Simple("El Gran Gatsby", new Incorrecta());
        Simple losSimuladores = new Simple("Los Simuladores", new Incorrecta());
        Simple scarface = new Simple("Scarface", new Incorrecta());
        Simple bladeRunner = new Simple("Blade Runner", new Incorrecta());
        Simple elPadrino = new Simple("El Padrino", new Incorrecta());

        Simple opcionObtenida;
        Simple opcionEsperada;

        List<Simple> opcionesEsperadas = List.of(elGranGatsby, losSimuladores,scarface,bladeRunner,elPadrino);


        //Act
        MultipleChoice preguntaLeida = (MultipleChoice) preguntasLeidas.get(3);
        List<Simple> opcionesObtenidas = preguntaLeida.obtenerOpciones();

        //Assert
        assertEquals(categoriaEsperada, preguntaLeida.obtenerCategoria());
        assertEquals(enunciadoEsperado, preguntaLeida.obtenerEnunciado());
        assertEquals(explicacionEsperada, preguntaLeida.obtenerExplicacion());


        for (int iterador = 0; iterador < 5; iterador++) {

            opcionObtenida = opcionesObtenidas.get(iterador);
            opcionEsperada = opcionesEsperadas.get(iterador);
            opcionObtenida.actualizarEstado(opcionEsperada);
            if (iterador == 0 || iterador == 4) {
                assertEquals(1, opcionEsperada.contarCorrecta());
                assertEquals(0, opcionEsperada.contarIncorrecta());
            } else{
                assertEquals(0, opcionEsperada.contarCorrecta());
                assertEquals(1, opcionEsperada.contarIncorrecta());
            }
        }
    }


    @Test
    public void test13UnaOrderedChoiceLeidaEsIgualALaEsperada() {

        //Arrange

        String categoriaEsperada = "CIENCIAS";
        String enunciadoEsperado = "Ordene de MAYOR A MENOR los siguientes objetos hogareños según su nivel de radiación electromagnética emitido (el máximo recomendado es 100 microTeslas)";
        String explicacionEsperada = "El microondas emite a  3 cm entre 73 y 200µ, y a 30 cm entre 4 a 8 µT. ";


        Ordenada televisorDeTuboCrt = new Ordenada("Televisor de tubo CRT", 2);
        Ordenada microondas = new Ordenada("Microondas",                    1);
        Ordenada imanesDelDelivery = new Ordenada("Imanes del delivery",    4);
        Ordenada heladera = new Ordenada("Heladera",                        3);

        List<Ordenada> opcionesEsperadas = List.of(televisorDeTuboCrt, microondas, imanesDelDelivery, heladera);

        Ordenada opcionObtenida;
        Ordenada opcionEsperada;


        //Act
        OrderedChoice preguntaLeida = (OrderedChoice) preguntasLeidas.get(0);
        List<Ordenada> opcionesObtenidas = preguntaLeida.obtenerOpciones();

        //Assert
        assertEquals(categoriaEsperada, preguntaLeida.obtenerCategoria());
        assertEquals(enunciadoEsperado, preguntaLeida.obtenerEnunciado());
        assertEquals(explicacionEsperada, preguntaLeida.obtenerExplicacion());
        for (int iterador = 0; iterador < 4;iterador++) {

            opcionObtenida = opcionesObtenidas.get(iterador);
            opcionEsperada = opcionesEsperadas.get(iterador);
            opcionObtenida.actualizarEstado(opcionEsperada);

            assertEquals(1, opcionEsperada.contarCorrecta());
            assertEquals(0, opcionEsperada.contarIncorrecta());
        }
    }
    @Test
    public void test14UnaGroupChoiceLeidaEsIgualALaEsperada() {

        //Arrange

        String categoriaEsperada = "DEPORTES";
        String enunciadoEsperado = "Asigne las siguientes leyendas del deporte nacional a disciplina grupales (Fútbol, Básquet, Voley, Rugby,) o individuales (atletismo, tenis, artes marciales, ajedrez, etc):";
        String explicacionEsperada = "say no more...";

        String deportesGrupales = "Deportes Grupales";
        String deportesIndividuales = "Deportes Individuales";

        Grupal lioMessi = new Grupal("Lio Messi", deportesGrupales);
        Grupal manuGinobili = new Grupal("Manu Ginóbili", deportesGrupales);
        Grupal juanMartinDelPotro = new Grupal("Juan Martín del Potro", deportesIndividuales);
        Grupal miguelNajdorf = new Grupal("Miguel Najdorf", deportesIndividuales);
        Grupal hugoConte = new Grupal("Hugo Conte", deportesGrupales);
        Grupal joseMeolans = new Grupal("José Meolans", deportesIndividuales);

        List<Grupal> opcionesEsperadas = List.of(lioMessi, manuGinobili, juanMartinDelPotro, miguelNajdorf, hugoConte, joseMeolans);

        Grupal opcionObtenida;
        Grupal opcionEsperada;

        //Act
        GroupChoice preguntaLeida = (GroupChoice) preguntasLeidas.get(2);
        List<Grupal> opcionesObtenidas = preguntaLeida.obtenerOpciones();

        //Assert
        assertEquals(categoriaEsperada, preguntaLeida.obtenerCategoria());
        assertEquals(enunciadoEsperado, preguntaLeida.obtenerEnunciado());
        assertEquals(explicacionEsperada, preguntaLeida.obtenerExplicacion());
//        assertEquals(opcionesEsperadas,opcionesObtenidas);
        for (int iterador = 0; iterador < 5; iterador++) {

            opcionObtenida = opcionesObtenidas.get(iterador);
            opcionEsperada = opcionesEsperadas.get(iterador);
            opcionObtenida.actualizarEstado(opcionEsperada);

            assertEquals(1, opcionEsperada.contarCorrecta());
            assertEquals(0, opcionEsperada.contarIncorrecta());
        }
    }
}