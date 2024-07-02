package edu.fiuba.algo3.TestEntrega2.OpcionTest;

import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrdenadaTest {
    private Opcion opcionCorrecta;
    private Opcion opcionIncorrecta;

    @BeforeEach
    public void setUpClass() {
        opcionCorrecta = new Ordenada("Opcion 1", 1, new Correcta());
        opcionIncorrecta = new Ordenada("Opcion 1", 1, new Incorrecta());
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
            assertEquals(1, opcionIncorrecta.contarIncorrecta());
            assertEquals(0, opcionIncorrecta.contarCorrecta());
        }

        @Test
        public void test03CambiarElEstadoConOtraIgualEstableceElEstadoEsperado() {
            opcionIncorrecta.actualizarEstado(opcionCorrecta);

            assertEquals(1, opcionIncorrecta.contarCorrecta());
            assertEquals(0, opcionIncorrecta.contarIncorrecta());
        }

        @Test
        public void test04CambiarElEstadoConOtraIncorrectaEstableceElEstadoIncorrecto() {
            opcionCorrecta.actualizarEstado(opcionCorrecta);
            assertEquals(0, opcionIncorrecta.contarCorrecta());
            assertEquals(1, opcionIncorrecta.contarIncorrecta());
        }

        @Test
        public void test05EsIgualAOtraOrdenadaConElMismoGrupoYTexto(){
            //Arrange

            Opcion opcion = new Ordenada("Opcion 1", 1, new Correcta());
            //Assert
            assertTrue(opcionCorrecta.equals(opcion));
        }

        @Test
        public void test06NoEsIgualAOtraOrdenadaConOtraPosicionYMismoTexto(){
            //Arrange
            Opcion opcion = new Ordenada("Opcion 1", 14, new Correcta());
            //Assert
            assertFalse(opcionCorrecta.equals(opcion));
        }
        @Test
        public void test07NoEsIgualAOtraOrdenadaConLaMismaPosicionYOtroTexto(){
            //Arrange

            Opcion opcion = new Ordenada("Opcion 14", 1, new Correcta());

            //Assert

            assertFalse(opcionCorrecta.equals(opcion));
        }


        @Test
        public void test07NoEsIgualAUnaOpcionNoOrdenada(){
            //Arrange
            Opcion opcionNoOrdenada = new Grupo("Opcion 1", "Grupo 1", new Correcta());
            //Assert
            assertNotEquals(opcionCorrecta, opcionNoOrdenada);
        }
    }

