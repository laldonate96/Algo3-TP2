package edu.fiuba.algo3.testEntrega3.TurnosTest.EstadoTest;

import edu.fiuba.algo3.modelo.lector.Lector;
import edu.fiuba.algo3.modelo.lector.mezclador.MezclaNula;
import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
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

        Grupo lioMessi = new Grupo("Lio Messi", deportesGrupales, new Incorrecta());
        Grupo manuGinobili = new Grupo("Manu Ginóbili", deportesGrupales, new Incorrecta());
        Grupo juanMartinDelPotro = new Grupo("Juan Martín del Potro", deportesIndividuales, new Incorrecta());
        Grupo miguelNajdorf = new Grupo("Miguel Najdorf", deportesIndividuales, new Incorrecta());
        Grupo hugoConte = new Grupo("Hugo Conte", deportesGrupales, new Incorrecta());
        Grupo joseMeolans = new Grupo("José Meolans", deportesIndividuales, new Incorrecta());

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

        Grupo lioMessi = new Grupo("Lio Messi", deportesIndividuales, new Incorrecta());
        Grupo manuGinobili = new Grupo("Manu Ginóbili", deportesIndividuales, new Incorrecta());
        Grupo juanMartinDelPotro = new Grupo("Juan Martín del Potro", deportesGrupales, new Incorrecta());
        Grupo miguelNajdorf = new Grupo("Miguel Najdorf", deportesGrupales, new Incorrecta());
        Grupo hugoConte = new Grupo("Hugo Conte", deportesIndividuales, new Incorrecta());
        Grupo joseMeolans = new Grupo("José Meolans", deportesGrupales, new Incorrecta());

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

        Grupo lioMessi = new Grupo("Lio Messi", deportesIndividuales, new Incorrecta());
        Grupo manuGinobili = new Grupo("Manu Ginóbili", deportesIndividuales, new Incorrecta());
        Grupo juanMartinDelPotro = new Grupo("Juan Martín del Potro", deportesGrupales, new Incorrecta());
        Grupo miguelNajdorf = new Grupo("Miguel Najdorf", deportesIndividuales, new Incorrecta());
        Grupo hugoConte = new Grupo("Hugo Conte", deportesGrupales, new Incorrecta());
        Grupo joseMeolans = new Grupo("José Meolans", deportesIndividuales, new Incorrecta());

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
