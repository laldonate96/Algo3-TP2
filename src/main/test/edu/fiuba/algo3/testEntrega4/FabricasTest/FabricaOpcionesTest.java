package edu.fiuba.algo3.testEntrega4.FabricasTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;

public class FabricaOpcionesTest {
    @Test
    public void test01FabricaOpcionesOrdenadas(){
        //Arrange

        List<String> contenidoOpciones=List.of("Televisor de tubo CRT","Microondas","Imanes del delivery","Heladera");
        List<String> posicionesCorrectas=List.of("2","1","4","3");
        Ordenada televisorDeTuboCrt = new Ordenada(contenidoOpciones.get(0),2, new Correcta());
        Ordenada microondas =         new Ordenada(contenidoOpciones.get(1),1, new Correcta());
        Ordenada imanesDelDelivery =  new Ordenada(contenidoOpciones.get(2),4, new Correcta());
        Ordenada heladera =           new Ordenada(contenidoOpciones.get(3),3, new Correcta());


        List<Ordenada> opcionesEsperadas = List.of(televisorDeTuboCrt, microondas, imanesDelDelivery, heladera);


        //Act

        List<Ordenada> opcionesObtenidas = FabricaOpciones.crearListaOrdenada(contenidoOpciones,posicionesCorrectas, new Correcta());

        //Assert
        assertEquals(opcionesEsperadas.size(), opcionesObtenidas.size());
        for (int iterador = 0; iterador < 4;iterador++){
            assertTrue(opcionesEsperadas.get(iterador).equals(opcionesObtenidas.get(iterador)));
        }

    }

    @Test
    public void test02FabricaOpcionesGrupo(){
        //Arrange
        Opcion opcion1 = new Grupo("x", "1", new Correcta());
        Opcion opcion2 = new Grupo("a", "2", new Correcta());
        Opcion opcion3 = new Grupo("y", "1", new Correcta());
        Opcion opcion4 = new Grupo("z", "1", new Correcta());
        Opcion opcion5 = new Grupo("s", "2", new Correcta());
        Opcion opcion6 = new Grupo("d", "2", new Correcta());

        //Act
        List<Grupo> opciones = FabricaOpciones.crearListaGrupo(List.of("1", "2"), List.of("x", "a","y", "z", "s", "d"),List.of("1","3","4","0","2","5","6"), new Correcta());

        //Assert
        assertEquals(6, opciones.size());
        assertTrue(opcion1.equals(opciones.get(0)));
        assertTrue(opcion2.equals(opciones.get(1)));
        assertTrue(opcion3.equals(opciones.get(2)));
        assertTrue(opcion4.equals(opciones.get(3)));
        assertTrue(opcion5.equals(opciones.get(4)));
        assertTrue(opcion6.equals(opciones.get(5)));
    }

    @Test
    public void test03FabricaOpcionesSimples(){
        //Arrange
        Simple opcion1 = new Simple("opcion1", new Correcta());
        Simple opcion2 = new Simple("opcion2", new Incorrecta());
        Simple opcion3 = new Simple("opcion3", new Correcta());

        List<String> contenidoOpciones = List.of("opcion1", "opcion2", "opcion3");
        List<String> posicionesDeCorrectas = List.of("1","3");

        //Act
        List<Simple> opciones = FabricaOpciones.crearListaSimple(contenidoOpciones, posicionesDeCorrectas, new Correcta());

        //Assert
        assertEquals(3, opciones.size());

        assertTrue(opcion1.equals(opciones.get(0)));
        assertEquals(1, opciones.get(0).contarCorrecta());

        assertTrue(opcion2.equals(opciones.get(1)));
        assertEquals(1, opciones.get(1).contarIncorrecta());

        assertTrue(opcion3.equals(opciones.get(2)));
        assertEquals(1, opciones.get(2).contarCorrecta());
    }
}
