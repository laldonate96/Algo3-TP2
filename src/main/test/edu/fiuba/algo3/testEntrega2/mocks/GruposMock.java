package edu.fiuba.algo3.testEntrega2.mocks;

import edu.fiuba.algo3.modelo.opciones.Opciones;
import edu.fiuba.algo3.modelo.opciones.opcion.Grupo;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.opciones.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Estado;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Incorrecta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GruposMock implements Opciones {
    private final List<String> listaGrupos;
    List<Grupo> listaOpciones;

    GruposMock() {
        listaOpciones = new ArrayList<>();
        listaGrupos=new ArrayList<>();
    }


    public GruposMock(List<String> grupos, List<List<String>> contenidoOpcionesPorGrupo) {
        Grupo opcion;
        String nombreGrupo;
        listaGrupos=grupos;
        listaOpciones = new ArrayList<>();

        for(List<String> contenidoOpciones:contenidoOpcionesPorGrupo){
            nombreGrupo=grupos.removeFirst();
            for(String contenidoOpcion:contenidoOpciones){
                opcion = new Grupo(contenidoOpcion, nombreGrupo, new Correcta());
                this.listaOpciones.add(opcion);
            }
        }

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


    public GruposMock crearCopiaMock(List<String> opcionesGrupo1,List<String> opcionesGrupo2) {
        GruposMock mock=new GruposMock();
        Grupo opcion;
        Estado estadoOpcion;

        String nombreGrupo = listaGrupos.get(1);
        for (String opcionGrupo1 : opcionesGrupo1) {

            if (this.contiene(opcionGrupo1, nombreGrupo)) {
                estadoOpcion = new Correcta();

            } else {
                estadoOpcion = new Incorrecta();

            }
            opcion = new Grupo(opcionGrupo1,nombreGrupo, estadoOpcion);
            mock.listaOpciones.add(opcion);
        }
        for (String opcionGrupo2 : opcionesGrupo2) {

            if (this.contiene(opcionGrupo2, nombreGrupo)) {
                estadoOpcion = new Correcta();

            } else {
                estadoOpcion = new Incorrecta();

            }
            opcion = new Grupo(opcionGrupo2,nombreGrupo, estadoOpcion);
            mock.listaOpciones.add(opcion);
        }
        return mock;
    }



    @Override
    public Iterator<Opcion> iterator() {
        List<Opcion> listaOpcion=new ArrayList<>();
        listaOpcion.add((Opcion) listaOpciones);
        return listaOpcion.iterator();
    }

    @Override
    public Opciones crearCopia(List<String> opcionesElegidas) {
        return null;
    }
}