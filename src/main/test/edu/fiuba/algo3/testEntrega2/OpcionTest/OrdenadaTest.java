package edu.fiuba.algo3.testEntrega2.OpcionTest;

import edu.fiuba.algo3.modelo.opciones.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.opciones.opcion.Grupo;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.opciones.opcion.Ordenada;
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
            assertTrue(opcionCorrecta.esCorrecta());
        }

        @Test
        public void test02SiSeleAsignaEstadoIncorrectaNoEsCorrecta() {
            //Assert
            assertFalse(opcionIncorrecta.esCorrecta());
        }

        @Test
        public void test03CambiarElEstadoConOtraIgualEstableceElEstadoEsperado() {
            opcionIncorrecta.actualizarEstado(opcionCorrecta);

            assertTrue(opcionIncorrecta.esCorrecta());
        }
        @Test
        public void test04CambiarElEstadoConOtraIncorrectaEstableceElEstadoIncorrecto() {
            opcionCorrecta.actualizarEstado(opcionCorrecta);
            assertFalse(opcionIncorrecta.esCorrecta());
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

