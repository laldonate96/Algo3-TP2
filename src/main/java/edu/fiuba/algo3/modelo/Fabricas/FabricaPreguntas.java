package edu.fiuba.algo3.modelo.Fabricas;

import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class FabricaPreguntas {
    public static int obtenerCantidadCorrectas(JSONObject preguntaJson) {
        List<String> opcionesCorrectas = Arrays.asList(preguntaJson.getString("Respuesta").split("\\s*,\\s*"));
        return (opcionesCorrectas.size());
    }

    public static Pregunta crearPreguntaVerdaderoFalso(String enunciado, List<Opcion> opciones, Puntaje puntaje, String categoria) {
        return new VerdaderoFalso(enunciado, opciones, puntaje, categoria);
    }

    public static Pregunta crearPreguntaMultipleChoice(String enunciado, List<Opcion> opciones, Puntaje puntaje, String categoria) {
        return new VerdaderoFalso(enunciado, opciones, puntaje, categoria);
    }

    public static Pregunta crearPreguntaOrderedChoice(String enunciado, List<Opcion> opciones, Puntaje puntaje, String categoria) {
        return new VerdaderoFalso(enunciado, opciones, puntaje, categoria);
    }

    public static Pregunta crearPreguntaGroupChoice(String enunciado, List<Opcion> opciones, Puntaje puntaje, String categoria) {
        return new VerdaderoFalso(enunciado, opciones, puntaje, categoria);
    }
}
