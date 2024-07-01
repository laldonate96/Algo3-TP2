package edu.fiuba.algo3.modelo.Fabricas;

import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.Simple;

import edu.fiuba.algo3.modelo.opcion.estado.Estado;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;

import java.util.ArrayList;
import java.util.List;

public class FabricaOpciones {

    public static List<Opcion> crearListaGrupo(List<String> grupos, List<List<String>> contenidoOpcionesPorGrupo, Estado estadoIndicado) {
        Grupo opcion;
        List<String> contenidoOpciones;
        List<Opcion> listaOpciones = new ArrayList<>();
        int contador = 0;

        for(String nombreGrupo:grupos){
            contenidoOpciones=contenidoOpcionesPorGrupo.get(contador);
            for(String contenidoOpcion:contenidoOpciones){
                opcion = new Grupo(contenidoOpcion, nombreGrupo,estadoIndicado);
                listaOpciones.add(opcion);
            }
            contador++;
        }
        return listaOpciones;

    }

    public static  List<Opcion> crearListaOrdenada(List<String> contenidoOpciones, List<String> ordenCorrecto, Estado estadoIndicado ) {

        int posicionEnLista;
        int posicionOrdenada=1;

        List<Opcion> listaOpciones = new ArrayList<>();

        Ordenada opcion;
        for (String textoPosicion : ordenCorrecto) {
            posicionEnLista=Integer.parseInt(textoPosicion);

            opcion = new Ordenada(contenidoOpciones.get(posicionOrdenada - 1), posicionEnLista ,estadoIndicado);
            listaOpciones.add(opcion);
            posicionOrdenada++;
        }
        return listaOpciones;
    }

    public static List<Opcion> crearListaSimple(List<String> contenidoOpciones, List<String> posicionesDeCorrectas, Estado estado){

        int posicion = 1;
        List<Opcion> listaOpciones=new ArrayList<>();
        Simple opcion;
        for (String contenidoOpcion : contenidoOpciones) {
            if (posicionesDeCorrectas.contains(String.valueOf(posicion))) {
                opcion = new Simple(contenidoOpcion, estado);
            } else {
                opcion = new Simple(contenidoOpcion, new Incorrecta());
            }
            listaOpciones.add(opcion);
            posicion++;
        }
        return listaOpciones;
    }
}
