package edu.fiuba.algo3.modelo.Fabricas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;





import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.*;
import org.json.JSONObject;

import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class FabricaPreguntas {
    public static Pregunta preguntaVerdaderoFalso(JSONObject preguntaJson, Puntaje puntaje) {
        String enunciado = preguntaJson.getString("Pregunta");
        String categoria = preguntaJson.getString("Tema");
        List<String> posicionesCorrectas =new ArrayList<>();
        posicionesCorrectas.add(preguntaJson.getString("Respuesta"));
        List<String> contenidoOpciones = new ArrayList<>();
        contenidoOpciones.add(preguntaJson.getString("Opcion 1"));
        contenidoOpciones.add(preguntaJson.getString("Opcion 2" ));

        List<Opcion> opciones=FabricaOpciones.crearListaSimple(contenidoOpciones,posicionesCorrectas);


        return new VerdaderoFalso(enunciado, opciones, puntaje, categoria);
    }

    public static Pregunta preguntaMultipleChoice(JSONObject preguntaJson, Puntaje puntaje) {
        String enunciado = preguntaJson.getString("Pregunta");
        String categoria = preguntaJson.getString("Tema");
        List<String> posicionesCorrectas = Arrays.asList(preguntaJson.getString("Respuesta").split("\\s*,\\s*"));
        List<String> contenidoOpciones = new ArrayList<>();


        for (int i = 1; i <= 5; i++) {
            String opcionKey = "Opcion " + i;
            if (preguntaJson.has(opcionKey)) {
                contenidoOpciones.add(preguntaJson.getString(opcionKey));
            }
        }
        List<Opcion> opciones=FabricaOpciones.crearListaSimple(contenidoOpciones,posicionesCorrectas);

        return new MultipleChoice(enunciado, opciones, puntaje, categoria);
    }

    public static Pregunta preguntaOrderedChoice(JSONObject preguntaJson, Puntaje puntaje) {
        String enunciado = preguntaJson.getString("Pregunta");
        String categoria = preguntaJson.getString("Tema");
        List<String> posicionesCorrectas = Arrays.asList(preguntaJson.getString("Respuesta").split("\\s*,\\s*"));
        List<String> contenidoOpciones = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            String opcionKey = "Opcion " + i;
            if (preguntaJson.has(opcionKey)) {
                contenidoOpciones.add(preguntaJson.getString(opcionKey));
            }
        }
        List<Opcion> opciones=FabricaOpciones.crearListaOrdenada(contenidoOpciones,posicionesCorrectas);
        return new OrderedChoice(enunciado, opciones, puntaje, categoria);
    }

    public static Pregunta preguntaGroupChoice(JSONObject preguntaJson, Puntaje puntaje) {
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

        List<Opcion> opciones=FabricaOpciones.crearListaGrupo(nombresGrupos,contenidoOpcionesPorGrupo);

        return new GroupChoice(enunciado, opciones, puntaje, categoria);
    }

    public static int obtenerCantidadCorrectas(JSONObject preguntaJson) {
        List<String> opcionesCorrectas = Arrays.asList(preguntaJson.getString("Respuesta").split("\\s*,\\s*"));
        return (opcionesCorrectas.size());
    }
}
