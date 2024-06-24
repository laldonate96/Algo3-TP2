package edu.fiuba.algo3.modelo.lector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import org.json.JSONObject;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Fabricas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class ParserGroup implements LectorParser {

    @Override
    public Pregunta parsearPregunta(JSONObject preguntaJson, Puntaje puntaje) {
        String enunciado = preguntaJson.getString("Pregunta");
        String categoria = preguntaJson.getString("Tema");
        String[] grupos = preguntaJson.getString("Respuesta").split("\\s*;\\s*");

        List<String> nombresGrupos=new ArrayList<>();
        List<List<String>> contenidoOpcionesPorGrupo=new ArrayList<>();
        List<String> contenidoOpciones=new ArrayList<>();

        String[] partesTexto;
        String indexGrupo;
        List<String> indices;

        for (String grupo : grupos) {

            partesTexto = grupo.split(":");
            indexGrupo = partesTexto[0].trim();
            indices = Arrays.asList(partesTexto[1].split("\\s*,\\s*"));

            nombresGrupos.add(preguntaJson.getString("Grupo " + indexGrupo));
            for (String index : indices) {
                int i = Integer.parseInt(index.trim());
                String opcionKey = "Opcion " + i;
                if (preguntaJson.has(opcionKey)) {
                    contenidoOpciones.add(preguntaJson.getString(opcionKey));
                }
            }

            contenidoOpcionesPorGrupo.add(contenidoOpciones);
        }

        List<Opcion> opciones=FabricaOpciones.crearListaGrupo(nombresGrupos,contenidoOpcionesPorGrupo, new Correcta());
        return FabricaPreguntas.crearPregunta(enunciado, opciones, puntaje, categoria);
    }
    
}
