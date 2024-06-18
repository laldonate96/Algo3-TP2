package edu.fiuba.algo3.modelo.opciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.opciones.opcion.Simple;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Incorrecta;

public class Simples implements Opciones {
    protected List<Simple> listaOpciones;

    protected Simples() {
        listaOpciones = new ArrayList<>();
    }

    protected void add(Simple simple){
        listaOpciones.add(simple);
    }

    public Simples(List<Simple> listaOpciones) {
        this.listaOpciones = listaOpciones;
    }


    public Simples(List<String> contenidoOpciones, List<String> posicionesDeCorrectas){

        int posicion = 1;
        this.listaOpciones=new ArrayList<>();
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

    @Override
    public List<String> obtenerListaStrings() {
        return List.of();
    }

    @Override
    public Iterator<Opcion> iterator() {
        List<Opcion> listaOpcion=new ArrayList<>();
        for (Opcion simple: listaOpciones){
            listaOpcion.add(simple);
        }
        return listaOpcion.iterator();
    }
}
