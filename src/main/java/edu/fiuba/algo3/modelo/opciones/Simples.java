package edu.fiuba.algo3.modelo.opciones;

import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.opciones.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opciones.opcion.Simple;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Incorrecta;

import java.util.ArrayList;
import java.util.List;

public class Simples implements Opciones {
    protected List<Simple> listaOpciones;

    protected Simples() {
        listaOpciones = new ArrayList<>();
    }

    protected void add(Simple simple){
        listaOpciones.add(simple);
    }

    public Simples(List<String> contenidoOpciones, List<String> posicionesDeCorrectas){

        int posicion = 1;

        Simple opcion;
        for (String contenidoOpcion : contenidoOpciones) {
            if (posicionesDeCorrectas.contains(String.valueOf(posicion))) {
                opcion = new Simple(contenidoOpcion, new Correcta());
            } else {
                opcion = new Simple(contenidoOpcion, new Incorrecta());
            }
            this.listaOpciones.add(opcion);
            posicion++;
        }

    }


    @Override
    public Opciones crearCopia(List<String> opcionesElegidas) {
        Simples opciones;
        opciones= new Simples();
        for (Simple opcion:opciones.listaOpciones){
            if(opcion.textoEstaContenido(opcionesElegidas)){
                opciones.add(opcion);
            }
        }
        return opciones;
    }
}
