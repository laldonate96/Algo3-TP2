package edu.fiuba.algo3.modelo.Fabricas;

import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;

import java.util.ArrayList;
import java.util.List;

public class FabricaOpciones {

    public static List<Opcion> crearListaGrupo(List<String> grupos, List<List<String>> contenidoOpcionesPorGrupo) {
        Grupo opcion;
        String nombreGrupo;
        List<Opcion> listaOpciones = new ArrayList<>();

        for(List<String> contenidoOpciones:contenidoOpcionesPorGrupo){
            nombreGrupo=grupos.remove(0);
            for(String contenidoOpcion:contenidoOpciones){
                opcion = new Grupo(contenidoOpcion, nombreGrupo, new Correcta());
                listaOpciones.add(opcion);
            }
        }
        return listaOpciones;

    }
    public static  List<Opcion> crearListaOrdenada(List<String> contenidoOpciones, List<String> ordenCorrecto) {

        int posicionEnLista;
        int posicionOrdenada=1;

        List<Opcion> listaOpciones = new ArrayList<>();

        Ordenada opcion;
        for (String textoPosicion : ordenCorrecto) {
            posicionEnLista=Integer.parseInt(textoPosicion);

            opcion = new Ordenada(contenidoOpciones.get(posicionEnLista - 1), posicionOrdenada ,new Correcta());
            listaOpciones.add(opcion);
            posicionOrdenada++;
        }
        return listaOpciones;
    }


    public static List<Opcion> crearListaSimple(List<String> contenidoOpciones, List<String> posicionesDeCorrectas){

        int posicion = 1;
        List<Opcion> listaOpciones=new ArrayList<>();
        Simple opcion;
        for (String contenidoOpcion : contenidoOpciones) {
            if (posicionesDeCorrectas.contains(String.valueOf(posicion))) {
                opcion = new Simple(contenidoOpcion, new Correcta());
            } else {
                opcion = new Simple(contenidoOpcion, new Incorrecta());
            }
            listaOpciones.add(opcion);
            posicion++;
        }
        return listaOpciones;
    }
    public static void crearListaOpciones(){}
}
