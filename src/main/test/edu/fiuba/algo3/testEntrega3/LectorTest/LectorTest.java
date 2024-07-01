package edu.fiuba.algo3.testEntrega3.LectorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.lector.mezclador.MezclaNula;
import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.pregunta.GroupChoice;
import org.junit.jupiter.api.BeforeAll;
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

    @Test
    public void test09999999UnaGroupChoiceLeidaEsIgualALaEsperada(){

        //Arrange

        String categoriaEsperada="DEPORTES";
        String enunciadoEsperado="Asigne las siguientes leyendas del deporte nacional a disciplina grupales (Fútbol, Básquet, Voley, Rugby,) o individuales (atletismo, tenis, artes marciales, ajedrez, etc):";
        String textoRespuestaEsperado="say no more...";

        String deportesGrupales="Deportes Grupales";
        String deportesIndividuales= "Deportes Individuales";
        Grupo lioMessi=new Grupo("Lío Messi",deportesGrupales, new Correcta());
        Grupo manuGinobili=new Grupo("Manu Ginóbili",deportesGrupales, new Correcta());
        Grupo juanMartinDelPotro=new Grupo("Juan Martín del Potro",deportesIndividuales, new Correcta());
        Grupo miguelNajdorf=new Grupo("Miguel Najdorf",deportesIndividuales, new Correcta());
        Grupo hugoConte=new Grupo("Hugo Conte",deportesGrupales, new Correcta());
        Grupo joseMeolans=new Grupo("José Meolans",deportesIndividuales, new Correcta());
        List<Grupo> opcionesGrupoEsperadas = List.of(lioMessi,manuGinobili,juanMartinDelPotro,miguelNajdorf,hugoConte,joseMeolans);


        //Act
        GroupChoice preguntaLeida=(GroupChoice) preguntasLeidas.get(2);

        //Assert
        assertEquals(categoriaEsperada,preguntaLeida.obtenerCategoria());
        assertEquals(enunciadoEsperado,preguntaLeida.obtenerEnunciado());
//        assertEquals(textoRespuestaEsperado,preguntaLeida.obtenerTextoRespuesta());
        assertEquals(opcionesGrupoEsperadas,preguntaLeida.obtenerOpciones());
    }
}