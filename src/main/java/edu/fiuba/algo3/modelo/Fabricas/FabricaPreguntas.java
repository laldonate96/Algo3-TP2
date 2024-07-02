package edu.fiuba.algo3.modelo.Fabricas;

import java.util.Arrays;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Grupal;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.Simple;
import org.json.JSONObject;

import edu.fiuba.algo3.modelo.pregunta.GroupChoice;
import edu.fiuba.algo3.modelo.pregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.pregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class FabricaPreguntas {
    public static int obtenerCantidadCorrectas(JSONObject preguntaJson) {
        List<String> opcionesCorrectas = Arrays.asList(preguntaJson.getString("Respuesta").split("\\s*,\\s*"));
        return (opcionesCorrectas.size());
    }

    public static VerdaderoFalso crearPreguntaVerdaderoFalso(String enunciado, List<Simple> opciones, Puntaje puntaje, String categoria, String explicacion) {
        return new VerdaderoFalso(enunciado, opciones, puntaje, categoria,explicacion);
    }

    public static MultipleChoice crearPreguntaMultipleChoice(String enunciado, List<Simple> opciones, Puntaje puntaje, String categoria, String explicacion) {
        return new MultipleChoice(enunciado, opciones, puntaje, categoria,explicacion);
    }

    public static OrderedChoice crearPreguntaOrderedChoice(String enunciado, List<Ordenada> opciones, Puntaje puntaje, String categoria, String explicacion) {
        return new OrderedChoice(enunciado, opciones, puntaje, categoria,explicacion);
    }

    public static GroupChoice crearPreguntaGroupChoice(String enunciado, List<Grupal> opciones, Puntaje puntaje, String categoria, String explicacion) {
        return new GroupChoice(enunciado, opciones, puntaje, categoria,explicacion);
    }
}
