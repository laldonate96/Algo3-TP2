package edu.fiuba.algo3.modelo.pregunta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;

import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class FabricaPreguntas {
    public static Pregunta preguntaVerdaderoFalso(JSONObject preguntaJson, Puntaje puntaje) {
        String enunciado = preguntaJson.getString("Pregunta");
        String categoria = preguntaJson.getString("Tema");
        String opcionCorrecta = preguntaJson.getString("Respuesta");
        String opcion1 = preguntaJson.getString("Opcion 1");
        String opcion2 = preguntaJson.getString("Opcion 2");
        List<Opcion> opciones = new ArrayList<>();
        if (opcionCorrecta.equals("1")) {
            opciones.add(new Simple(opcion1, new Correcta()));
            opciones.add(new Simple(opcion2, new Incorrecta()));
        } else {
            opciones.add(new Simple(opcion1, new Incorrecta()));
            opciones.add(new Simple(opcion2, new Correcta()));
        }
        return new VerdaderoFalso(enunciado, opciones, puntaje, categoria);
    }

    public static Pregunta preguntaMultipleChoice(JSONObject preguntaJson, Puntaje puntaje) {
        String enunciado = preguntaJson.getString("Pregunta");
        String categoria = preguntaJson.getString("Tema");
        List<String> opcionesCorrectas = Arrays.asList(preguntaJson.getString("Respuesta").split("\\s*,\\s*"));
        List<Opcion> opciones = new ArrayList<>();
        
        for (int i = 1; i <= 5; i++) {
            String opcionKey = "Opcion " + i;
            if (preguntaJson.has(opcionKey)) {
                String opcionTexto = preguntaJson.getString(opcionKey);
                Opcion opcion;
                if (opcionesCorrectas.contains(String.valueOf(i))) {
                    opcion = new Simple(opcionTexto, new Correcta());
                } else {
                    opcion = new Simple(opcionTexto, new Incorrecta());
                }
                opciones.add(opcion);
            }
        }
        return new MultipleChoice(enunciado, opciones, puntaje, categoria);
    }

    public static Pregunta preguntaOrderedChoice(JSONObject preguntaJson, Puntaje puntaje) {
        String enunciado = preguntaJson.getString("Pregunta");
        String categoria = preguntaJson.getString("Tema");
        List<String> opcionesCorrectas = Arrays.asList(preguntaJson.getString("Respuesta").split("\\s*,\\s*"));
        List<Opcion> opciones = new ArrayList<>();
        
        for (int i = 1; i <= 6; i++) {
            String opcionKey = "Opcion " + i;
            if (preguntaJson.has(opcionKey)) {
                String opcionTexto = preguntaJson.getString(opcionKey);
                int posicion = opcionesCorrectas.indexOf(String.valueOf(i)) + 1;
                Opcion opcion = new Ordenada(opcionTexto, posicion, new Correcta());
                opciones.add(opcion);
            }
        }
        return new OrderedChoice(enunciado, opciones, puntaje, categoria);
    }

    public static Pregunta preguntaGroupChoice(JSONObject preguntaJson, Puntaje puntaje) {
        String enunciado = preguntaJson.getString("Pregunta");
        String categoria = preguntaJson.getString("Tema");
        String[] grupos = preguntaJson.getString("Respuesta").split("\\s*;\\s*");
        List<Opcion> opciones = new ArrayList<>();

        for (String grupo : grupos) {
            String[] partes = grupo.split(":");
            String nombreGrupo = partes[0].trim();
            List<String> indices = Arrays.asList(partes[1].split("\\s*,\\s*"));
            String etiquetaGrupo = preguntaJson.getString("Grupo " + nombreGrupo);

            for (String index : indices) {
                int i = Integer.parseInt(index.trim());
                String opcionKey = "Opcion " + i;
                if (preguntaJson.has(opcionKey)) {
                    String opcionTexto = preguntaJson.getString(opcionKey);
                    Opcion opcion = new Grupo(opcionTexto, etiquetaGrupo, new Correcta());
                    opciones.add(opcion);
                }
            }
        }
        return new GroupChoice(enunciado, opciones, puntaje, categoria);
    }
}
