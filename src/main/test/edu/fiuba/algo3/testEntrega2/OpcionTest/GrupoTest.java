package edu.fiuba.algo3.testEntrega2.OpcionTest;


import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrupoTest {
    private Opcion opcionCorrecta;
    private Opcion opcionIncorrecta;

    @BeforeEach
    public void setUpClass() {
        opcionCorrecta = new Grupo("Opcion 1", "Grupo 1", new Correcta());
        opcionIncorrecta = new Grupo("Opcion 1", "Grupo 1", new Incorrecta());
    }


        @Test
        public void test01SiSeleAsignaEstadoCorrectaEsCorrecta() {
            //Assert
            assertEquals(1, opcionCorrecta.contarCorrecta());
            assertEquals(0, opcionCorrecta.contarIncorrecta());
        }

        @Test
        public void test02SiSeleAsignaEstadoIncorrectaNoEsCorrecta() {
            //Assert
            assertEquals(0, opcionIncorrecta.contarCorrecta());
            assertEquals(1, opcionIncorrecta.contarIncorrecta());
        }

        @Test
        public void test03CambiarElEstadoConOtraIgualEstableceElEstadoEsperado() {
            opcionIncorrecta.actualizarEstado(opcionCorrecta);

            //Assert
            assertEquals(1, opcionIncorrecta.contarCorrecta());
            assertEquals(0, opcionIncorrecta.contarIncorrecta());
        }
        @Test
        public void test04CambiarElEstadoConOtraIncorrectaEstableceElEstadoIncorrecto() {
            opcionCorrecta.actualizarEstado(opcionIncorrecta);

            //Assert
            assertEquals(0, opcionCorrecta.contarCorrecta());
            assertEquals(1, opcionCorrecta.contarIncorrecta());
        }

        @Test
        public void test05EsIgualAOtraGrupoConElMismoGrupoYTexto(){
            //Arrange

            Opcion opcion = new Grupo("Opcion 1", "Grupo 1", new Correcta());

            //Assert
            assertTrue(opcionCorrecta.equals(opcion));
        }

        @Test
        public void test06NoEsIgualAOtraGrupoConOtroTexto(){
            //Arrange
            Opcion opcion = new Grupo("Opcion 1", "Grupo 1n't", new Correcta());
            //Assert
            assertFalse(opcionCorrecta.equals(opcion));
        }
        @Test
        public void test07NoEsIgualAOtraGrupoConElMismoGrupoYOtroTexto(){
        //Arrange

        Opcion opcion = new Grupo("Opcion 24", "Grupo 1", new Correcta());

        //Assert

        assertFalse(opcionCorrecta.equals(opcion));
        }


        @Test
        public void test07NoEsIgualAUnaOpcionNoGrupo(){
            //Arrange
            Ordenada opcionNoGrupo = new Ordenada("Opcion 1", 1, new Correcta());
            //Assert
            assertNotEquals(opcionCorrecta, opcionNoGrupo);
        }
    }
