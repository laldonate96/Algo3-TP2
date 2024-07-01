package edu.fiuba.algo3.testEntrega3.LectorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import edu.fiuba.algo3.modelo.lector.mezclador.MezclaNula;
import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.pregunta.GroupChoice;

import edu.fiuba.algo3.modelo.pregunta.OrderedChoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

public class LectorTest {

    private List<Pregunta> preguntasLeidas;

    @BeforeEach
    public void setUp() {
       preguntasLeidas = Lector.obtenerPreguntasDeJson(new MezclaNula(),("recursos/test.json"));

    }

    @Test
    public void test01UnArchivoJsonCon7PreguntasAlLeerseCreaUnaListaDe7Preguntas() {
        assertEquals(7, preguntasLeidas.size());
    }
//    @Test
//    public void test02UnArchivoJsonCon7PreguntasAlLeerseCreaUnaListaDe7Preguntas() {
//        preguntasLeidas = Lector.obtenerPreguntasDeJson(new MezclaNula(),("recursos/preguntas.json"));
//        assertEquals(1, preguntasLeidas.size());
//    }

    @Test
    public void test13UnaOrderedChoiceLeidaEsIgualALaEsperada() {

        //Arrange

        String categoriaEsperada = "CIENCIAS";
        String enunciadoEsperado = "Ordene de MAYOR A MENOR los siguientes objetos hogareños según su nivel de radiación electromagnética emitido (el máximo recomendado es 100 microTeslas)";
        String explicacionEsperada = "El microondas emite a  3 cm entre 73 y 200µ, y a 30 cm entre 4 a 8 µT. ";


        Ordenada televisorDeTuboCrt = new Ordenada("Televisor de tubo CRT", 2, new Correcta());
        Ordenada microondas = new Ordenada("Microondas",                    1, new Correcta());
        Ordenada imanesDelDelivery = new Ordenada("Imanes del delivery",    4, new Correcta());
        Ordenada heladera = new Ordenada("Heladera",                        3, new Correcta());

        List<Ordenada> opcionesEsperadas = List.of(televisorDeTuboCrt, microondas, imanesDelDelivery, heladera);


        //Act
        OrderedChoice preguntaLeida = (OrderedChoice) preguntasLeidas.get(0);
        List<Opcion> opcionesObtenidas = preguntaLeida.obtenerOpciones();

        //Assert
        assertEquals(categoriaEsperada, preguntaLeida.obtenerCategoria());
        assertEquals(enunciadoEsperado, preguntaLeida.obtenerEnunciado());
        assertEquals(explicacionEsperada, preguntaLeida.obtenerExplicacion());
        for (int iterador = 0; iterador < 4;iterador++){
            assertTrue(opcionesEsperadas.get(iterador).equals(opcionesObtenidas.get(iterador)));
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
        Grupo lioMessi = new Grupo("Lio Messi", deportesGrupales, new Correcta());
        Grupo manuGinobili = new Grupo("Manu Ginóbili", deportesGrupales, new Correcta());
        Grupo juanMartinDelPotro = new Grupo("Juan Martín del Potro", deportesIndividuales, new Correcta());
        Grupo miguelNajdorf = new Grupo("Miguel Najdorf", deportesIndividuales, new Correcta());
        Grupo hugoConte = new Grupo("Hugo Conte", deportesGrupales, new Correcta());
        Grupo joseMeolans = new Grupo("José Meolans", deportesIndividuales, new Correcta());

        List<Grupo> opcionesEsperadas = List.of(lioMessi, manuGinobili, juanMartinDelPotro, miguelNajdorf, hugoConte, joseMeolans);


        //Act
        GroupChoice preguntaLeida = (GroupChoice) preguntasLeidas.get(2);
        List<Opcion> opcionesObtenidas = preguntaLeida.obtenerOpciones();

        //Assert
        assertEquals(categoriaEsperada, preguntaLeida.obtenerCategoria());
        assertEquals(enunciadoEsperado, preguntaLeida.obtenerEnunciado());
        assertEquals(explicacionEsperada, preguntaLeida.obtenerExplicacion());
//        assertEquals(opcionesEsperadas,opcionesObtenidas);
        for (int iterador = 0; iterador < 6;iterador++){
            assertTrue(opcionesEsperadas.get(iterador).equals(opcionesObtenidas.get(iterador)));
        }
    }
}