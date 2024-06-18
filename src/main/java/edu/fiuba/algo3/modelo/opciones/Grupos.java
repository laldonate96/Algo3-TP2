package edu.fiuba.algo3.modelo.opciones;

import edu.fiuba.algo3.modelo.opciones.opcion.Grupo;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.opciones.opcion.Simple;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Estado;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.GroupChoice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grupos implements Opciones {
    List<Grupo> listaOpciones;

    Grupos() {
        listaOpciones = new ArrayList<>();
    }


    public Grupos(List<String> opcionesGrupos) {
        Grupo opcion;

        List<String> listaGrupos = obtenerGrupos(opcionesGrupos.getFirst());
        for (String nombreGrupo : listaGrupos) {
            List<String> textos = obtenerTextos(opcionesGrupos.getFirst(), nombreGrupo);
            for (String texto : textos) {
                opcion = new Grupo(texto, nombreGrupo, new Correcta());
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

    private boolean contiene(String texto, String grupo) {
        boolean contiene = false;
        for (Grupo opcion : listaOpciones) {
            if (opcion.contiene(texto, grupo)) {
                contiene = true;
            }
        }

        return contiene;
    }
}