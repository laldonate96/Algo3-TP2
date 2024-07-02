package edu.fiuba.algo3.testEntrega3.TurnosTest.EstadoTest;

import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaNula;
import edu.fiuba.algo3.modelo.opcion.Grupal;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.GroupChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.turno.Estado.ManejarGroupChoice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManejarGroupChoiceTest {
    private static ManejarGroupChoice manejadorGC;
    private static List<Pregunta> preguntasTest;

    @BeforeAll
    public static void setupClass(){
        preguntasTest = Lector.obtenerPreguntasDeJson(new MezclaNula(),("recursos/test.json"));
        manejadorGC = new ManejarGroupChoice((GroupChoice) preguntasTest.get(2));
    }

    @Test
    public void test01ManejadorRecibeOpcionesCorrectasYLasValidaCorrectamente(){
        String deportesGrupales = "Deportes Grupales";
        String deportesIndividuales = "Deportes Individuales";

        Grupal lioMessi = new Grupal("Lio Messi", deportesGrupales);
        Grupal manuGinobili = new Grupal("Manu Ginóbili", deportesGrupales);
        Grupal juanMartinDelPotro = new Grupal("Juan Martín del Potro", deportesIndividuales);
        Grupal miguelNajdorf = new Grupal("Miguel Najdorf", deportesIndividuales);
        Grupal hugoConte = new Grupal("Hugo Conte", deportesGrupales);
        Grupal joseMeolans = new Grupal("José Meolans", deportesIndividuales);

        List<Opcion> opciones = List.of(lioMessi, manuGinobili, juanMartinDelPotro, miguelNajdorf, hugoConte, joseMeolans);

        manejadorGC.validarOpciones(opciones);

        for (Opcion opcion : opciones) {
            assertEquals(1, opcion.contarCorrecta());
            assertEquals(0, opcion.contarIncorrecta());
        }
    }

    @Test
    public void test02ManejadorRecibeOpcionesIncorrectasYLasValidaCorrectamente(){
        String deportesGrupales = "Deportes Grupales";
        String deportesIndividuales = "Deportes Individuales";

        Grupal lioMessi = new Grupal("Lio Messi", deportesIndividuales);
        Grupal manuGinobili = new Grupal("Manu Ginóbili", deportesIndividuales);
        Grupal juanMartinDelPotro = new Grupal("Juan Martín del Potro", deportesGrupales);
        Grupal miguelNajdorf = new Grupal("Miguel Najdorf", deportesGrupales);
        Grupal hugoConte = new Grupal("Hugo Conte", deportesIndividuales);
        Grupal joseMeolans = new Grupal("José Meolans", deportesGrupales);

        List<Opcion> opciones = List.of(lioMessi, manuGinobili, juanMartinDelPotro, miguelNajdorf, hugoConte, joseMeolans);

        manejadorGC.validarOpciones(opciones);

        for (Opcion opcion : opciones) {
            assertEquals(0, opcion.contarCorrecta());
            assertEquals(1, opcion.contarIncorrecta());
        }
    }

    @Test
    public void test03ManejadorRecibeOpcionesCorrectasEIncorrectasYLasValidaCorrectamente(){
        String deportesGrupales = "Deportes Grupales";
        String deportesIndividuales = "Deportes Individuales";

        Grupal lioMessi = new Grupal("Lio Messi", deportesIndividuales);
        Grupal manuGinobili = new Grupal("Manu Ginóbili", deportesIndividuales);
        Grupal juanMartinDelPotro = new Grupal("Juan Martín del Potro", deportesGrupales);
        Grupal miguelNajdorf = new Grupal("Miguel Najdorf", deportesIndividuales);
        Grupal hugoConte = new Grupal("Hugo Conte", deportesGrupales);
        Grupal joseMeolans = new Grupal("José Meolans", deportesIndividuales);

        List<Opcion> opciones = List.of(lioMessi, manuGinobili, juanMartinDelPotro, miguelNajdorf, hugoConte, joseMeolans);

        manejadorGC.validarOpciones(opciones);

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
}
