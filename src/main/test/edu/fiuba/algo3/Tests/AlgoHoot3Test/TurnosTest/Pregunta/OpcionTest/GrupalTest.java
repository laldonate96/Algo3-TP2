package edu.fiuba.algo3.Tests.AlgoHoot3Test.TurnosTest.Pregunta.OpcionTest;


import edu.fiuba.algo3.modelo.opcion.Grupal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrupalTest {
    private Grupal opcion1;

    @BeforeEach
    public void setUpClass() {
        opcion1 = new Grupal("Opcion 1", "Grupo 1");
    }

        @Test
        public void test01SinActualizarSuEstadoNoEsCorrectaNiIncorrecta() {
            //Assert
            assertEquals(0, opcion1.contarCorrecta());
            assertEquals(0, opcion1.contarIncorrecta());
        }


        @Test
        public void test02CambiarElEstadoAOtraIgualLaVuelveCorrecta() {
            Grupal opcion2 = new Grupal("Opcion 1", "Grupo 1");

            opcion1.actualizarEstado(opcion2);

            //Assert
            assertEquals(1, opcion2.contarCorrecta());
            assertEquals(0, opcion2.contarIncorrecta());
        }
        @Test
        public void test03CambiarElEstadoAOtraConDiferenteTextoLaVuelveIncorrecta() {
            Grupal opcion3 = new Grupal("Opcion 2", "Grupo 1");

            opcion1.actualizarEstado(opcion3);

            //Assert
            assertEquals(0, opcion3.contarCorrecta());
            assertEquals(1, opcion3.contarIncorrecta());
        }

         @Test
         public void test04CambiarElEstadoAOtraConDiferenteGrupoLaVuelveIncorrecta() {
             Grupal opcion4 = new Grupal("Opcion 1", "Grupo 2");
             opcion1.actualizarEstado(opcion4);

             //Assert
             assertEquals(0, opcion4.contarCorrecta());
             assertEquals(1, opcion4.contarIncorrecta());
         }



}
