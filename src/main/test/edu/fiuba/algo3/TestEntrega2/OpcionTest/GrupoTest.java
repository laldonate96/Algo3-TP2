package edu.fiuba.algo3.TestEntrega2.OpcionTest;


import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.opcion.Grupo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrupoTest {
    private Grupo opcion1;

    @BeforeEach
    public void setUpClass() {
        opcion1 = new Grupo("Opcion 1", "Grupo 1", new Correcta());
    }


        @Test
        public void test01SinActualizarSuEstadoNoEsCorrectaNiIncorrecta() {
            //Assert
            assertEquals(0, opcion1.contarCorrecta());
            assertEquals(0, opcion1.contarIncorrecta());
        }


        @Test
        public void test02CambiarElEstadoAOtraIgualLaVuelveCorrecta() {
            Grupo opcion2 = new Grupo("Opcion 1", "Grupo 1", new Incorrecta());

            opcion1.actualizarEstado(opcion2);

            //Assert
            assertEquals(1, opcion2.contarCorrecta());
            assertEquals(0, opcion2.contarIncorrecta());
        }
        @Test
        public void test03CambiarElEstadoAOtraConDiferenteTextoLaVuelveIncorrecta() {
            Grupo opcion3 = new Grupo("Opcion 2", "Grupo 1", new Incorrecta());

            opcion1.actualizarEstado(opcion3);

            //Assert
            assertEquals(0, opcion3.contarCorrecta());
            assertEquals(1, opcion3.contarIncorrecta());
        }

         @Test
         public void test04CambiarElEstadoAOtraConDiferenteGrupoLaVuelveIncorrecta() {
             Grupo opcion4 = new Grupo("Opcion 1", "Grupo 2", new Incorrecta());
             opcion1.actualizarEstado(opcion4);

             //Assert
             assertEquals(0, opcion4.contarCorrecta());
             assertEquals(1, opcion4.contarIncorrecta());
         }



}
