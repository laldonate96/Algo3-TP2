package edu.fiuba.algo3.testEntrega4.FabricasTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;

public class FabricaOpcionesTest {
    @Test
    public void test01FabricaOpcionesOrdenadas(){
        //Arrange
        Ordenada opcionObtenida;
        Ordenada opcionEsperada;


        List<String> contenidoOpciones=List.of("Televisor de tubo CRT","Microondas","Imanes del delivery","Heladera");
        List<String> posicionesCorrectas=List.of("2","1","4","3");
        Ordenada televisorDeTuboCrt = new Ordenada(contenidoOpciones.get(0),2, new Incorrecta());
        Ordenada microondas =         new Ordenada(contenidoOpciones.get(1),1, new Incorrecta());
        Ordenada imanesDelDelivery =  new Ordenada(contenidoOpciones.get(2),4, new Incorrecta());
        Ordenada heladera =           new Ordenada(contenidoOpciones.get(3),3, new Incorrecta());


        List<Ordenada> opcionesEsperadas = List.of(televisorDeTuboCrt, microondas, imanesDelDelivery, heladera);


        //Act

        List<Ordenada> opcionesObtenidas = FabricaOpciones.crearListaOrdenada(contenidoOpciones,posicionesCorrectas, new Correcta());

        //Assert
        assertEquals(opcionesEsperadas.size(), opcionesObtenidas.size());
        for (int iterador = 0; iterador < 4;iterador++) {


            opcionObtenida = opcionesObtenidas.get(iterador);
            opcionEsperada = opcionesEsperadas.get(iterador);
            opcionObtenida.actualizarEstado(opcionEsperada);

            assertEquals(1, opcionEsperada.contarCorrecta());
            assertEquals(0, opcionEsperada.contarIncorrecta());

        }

    }

    @Test
    public void test02FabricaOpcionesGrupo(){
        //Arrange
        Grupo opcionObtenida;
        Grupo opcionEsperada;

        Grupo opcion1 = new Grupo("x", "1", new Incorrecta());
        Grupo opcion2 = new Grupo("a", "2", new Incorrecta());
        Grupo opcion3 = new Grupo("y", "1", new Incorrecta());
        Grupo opcion4 = new Grupo("z", "1", new Incorrecta());
        Grupo opcion5 = new Grupo("s", "2", new Incorrecta());
        Grupo opcion6 = new Grupo("d", "2", new Incorrecta());
        List<Grupo> opcionesEsperadas=List.of(opcion1,opcion2,opcion3,opcion4,opcion5,opcion6);

        //Act
        List<Grupo> opcionesObtenidas = FabricaOpciones.crearListaGrupo(List.of("1", "2"), List.of("x", "a","y", "z", "s", "d"),List.of("1","3","4","0","2","5","6"), new Correcta());

        //Assert
        assertEquals(opcionesEsperadas.size(), opcionesObtenidas.size());
        for(int i=0; i<6;i++) {
            opcionObtenida = opcionesObtenidas.get(i);
            opcionEsperada = opcionesEsperadas.get(i);
            opcionObtenida.actualizarEstado(opcionEsperada);

            assertEquals(1, opcionEsperada.contarCorrecta());
            assertEquals(0, opcionEsperada.contarIncorrecta());

        }

    }

    @Test
    public void test03FabricaOpcionesSimples(){
        //Arrange
        Simple opcion1 = new Simple("opcion1", new Incorrecta());
        Simple opcion2 = new Simple("opcion2", new Correcta());
        Simple opcion3 = new Simple("opcion3", new Incorrecta());

        List<String> contenidoOpciones = List.of("opcion1", "opcion2", "opcion3");
        List<String> posicionesDeCorrectas = List.of("1","3");

        //Act
        List<Simple> opciones = FabricaOpciones.crearListaSimple(contenidoOpciones, posicionesDeCorrectas, new Correcta());

        //Assert
        assertEquals(3, opciones.size());

        opciones.get(0).actualizarEstado(opcion1);

        assertEquals(1, opcion1.contarCorrecta());
        assertEquals(0, opcion1.contarIncorrecta());



        opciones.get(1).actualizarEstado(opcion2);

        assertEquals(0, opcion2.contarCorrecta());
        assertEquals(1, opcion2.contarIncorrecta());

        opciones.get(2).actualizarEstado(opcion3);

        assertEquals(1, opcion3.contarCorrecta());
        assertEquals(0, opcion3.contarIncorrecta());
    }
}
