package edu.fiuba.algo3.modelo.lector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import org.json.JSONObject;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Fabricas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class ParserGroup extends LectorParser {

    @Override
    public Pregunta parsearPregunta(JSONObject preguntaJson, Puntaje puntaje) {

        leerEnunciadoCategoriaYExplicacion(preguntaJson);


        String[] grupos = (preguntaJson.getString("Respuesta").split("\\s*;\\s*"));

        List<String> nombresGrupos=new ArrayList<>();

        String[] partesTexto;
        String indexGrupo;

        List<String> posicionesCorrectas = new ArrayList<>();

        for (String grupo : grupos) {

            partesTexto = grupo.split("\\s*:\\s*");
            indexGrupo = partesTexto[0].trim();
            nombresGrupos.add(preguntaJson.getString("Grupo " + indexGrupo));


            Collections.addAll(posicionesCorrectas, partesTexto[1].split("\\s*,\\s*"));
            posicionesCorrectas.add("0");
        }
        posicionesCorrectas.remove(posicionesCorrectas.size()-1);

        List<String> contenidoOpciones=obtenerContenidoOpciones(preguntaJson,posicionesCorrectas.size());


        List<Grupo> opciones=FabricaOpciones.crearListaGrupo(nombresGrupos,contenidoOpciones,posicionesCorrectas, new Correcta());
        return FabricaPreguntas.crearPreguntaGroupChoice(enunciado, opciones, new Clasica(opciones.size()), categoria,explicacion);
    }



}
