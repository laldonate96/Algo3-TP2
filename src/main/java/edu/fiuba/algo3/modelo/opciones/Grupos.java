package edu.fiuba.algo3.modelo.opciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import edu.fiuba.algo3.modelo.opciones.opcion.Grupo;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Estado;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Incorrecta;

public class Grupos implements Opciones {
    List<Grupo> listaOpciones;

    Grupos() {
        listaOpciones = new ArrayList<>();
    }


    public Grupos(List<String> grupos,List<List<String>> contenidoOpcionesPorGrupo) {
        Grupo opcion;
        String nombreGrupo;
        listaOpciones = new ArrayList<>();

        for(List<String> contenidoOpciones:contenidoOpcionesPorGrupo){
            nombreGrupo=grupos.removeFirst();
            for(String contenidoOpcion:contenidoOpciones){
                opcion = new Grupo(contenidoOpcion, nombreGrupo, new Correcta());
                this.listaOpciones.add(opcion);
            }
        }

    }


    private List<String> obtenerGrupos(String opcionesElegidas) {
        List<String> grupos = new ArrayList<>();
        String[] gruposYSusValores = opcionesElegidas.split(";");
        for (String grupoYValores : gruposYSusValores) {
            String nombreGrupo = grupoYValores.split(":")[0];
            grupos.add(nombreGrupo);
        }
        return grupos;
    }

    private List<String> obtenerTextos(String opcionesElegidas, String grupo) {
        List<String> textos = new ArrayList<>();
        String[] gruposYSusValores = opcionesElegidas.split(";");
        for (String grupoYValores : gruposYSusValores) {
            String nombreGrupo = grupoYValores.split(":")[0];
            if (nombreGrupo.equals(grupo)) {
                textos = Arrays.asList(grupoYValores.split(":")[1].split(","));
            }
        }
        return textos;
    }

    @Override
    public Opciones crearCopia(List<String> opcionesElegidas) {
        Grupos grupos = new Grupos();
        List<String> listaGrupos = obtenerGrupos(opcionesElegidas.getFirst());
        Grupo opcion;
        Estado estadoOpcion;
        for (String nombreGrupo : listaGrupos) {
            List<String> textos = obtenerTextos(opcionesElegidas.getFirst(), nombreGrupo);
            for (String texto : textos) {
                if (this.contiene(texto, nombreGrupo)) {
                    estadoOpcion = new Correcta();
                } else {
                    estadoOpcion = new Incorrecta();
                }
                opcion = new Grupo(texto, nombreGrupo, estadoOpcion);
                grupos.listaOpciones.add(opcion);
            }
        }
        return grupos;
    }

    @Override
    public List<String> obtenerListaStrings() {
        return List.of();
    }


    private boolean contiene(String texto, String grupo) {
        boolean contiene = false;
        for (Grupo opcion : listaOpciones) {
            if (opcion.contiene(texto, grupo)) {
                contiene = true;
            }
        }

        return contiene;
    }

    @Override
    public Iterator<Opcion> iterator() {
        List<Opcion> listaOpcion=new ArrayList<>();
        for (Opcion ordenada: listaOpciones){
            listaOpcion.add(ordenada);
        }
        return listaOpcion.iterator();
    }
}