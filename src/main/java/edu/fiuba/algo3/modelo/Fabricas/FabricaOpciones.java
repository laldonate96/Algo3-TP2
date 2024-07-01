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

    public static List<Opcion> crearListaGrupo(List<String> grupos, List<String> contenidoOpciones,List<String>  posicionesCorrectas,Estado estadoIndicado) {
        Grupo opcion;

        List<Opcion> listaOpciones = new ArrayList<>();
        int posicionBuscada;
        int posicionAnterior=Integer.parseInt(posicionesCorrectas.get(0));
        int grupoActual = 0;
        for (String textoPosicion : posicionesCorrectas) {
            posicionBuscada = Integer.parseInt(textoPosicion);
            if (posicionBuscada <posicionAnterior) {
                grupoActual++;

            } else {
                opcion = new Grupo(contenidoOpciones.get(posicionBuscada-1), grupos.get(grupoActual), estadoIndicado);
                if(grupoActual>0){
                    listaOpciones.add(posicionBuscada-1,opcion);
                } else{
                    listaOpciones.add(opcion);
                }
            }
            posicionAnterior=posicionBuscada;
        }
        return listaOpciones;

    }

    public static  List<Opcion> crearListaOrdenada(List<String> contenidoOpciones, List<String> ordenCorrecto, Estado estadoIndicado ) {

        int posicionEnLista;

        String textoOpcion;
        List<Opcion> listaOpciones = new ArrayList<>();

        Ordenada opcion;
        for(int i=0; i<contenidoOpciones.size();i++){
            posicionEnLista=Integer.parseInt(ordenCorrecto.get(i));
            textoOpcion=contenidoOpciones.get(i);

            opcion = new Ordenada(textoOpcion,posicionEnLista  ,estadoIndicado);

            listaOpciones.add(opcion);
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
