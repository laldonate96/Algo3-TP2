package edu.fiuba.algo3.modelo.Fabricas;

import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.GroupChoice;
import edu.fiuba.algo3.modelo.pregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.pregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class FabricaPreguntas {
    public static int obtenerCantidadCorrectas(JSONObject preguntaJson) {
        List<String> opcionesCorrectas = Arrays.asList(preguntaJson.getString("Respuesta").split("\\s*,\\s*"));
        return (opcionesCorrectas.size());
    }

    public static Pregunta crearPreguntaVOF(String enunciado, List<Opcion> opciones, Puntaje puntaje, String categoria) {
        return new VerdaderoFalso(enunciado, opciones, puntaje, categoria);
    }

    public static Pregunta crearPreguntaMChoice(String enunciado, List<Opcion> opciones, Puntaje puntaje, String categoria) {
        return new MultipleChoice(enunciado, opciones, puntaje, categoria);
    }

    public static Pregunta crearPreguntaGroup(String enunciado, List<Opcion> opciones, Puntaje puntaje, String categoria) {
        return new GroupChoice(enunciado, opciones, puntaje, categoria);
    }

    public static Pregunta crearPreguntaOrdered(String enunciado, List<Opcion> opciones, Puntaje puntaje, String categoria) {
        return new OrderedChoice(enunciado, opciones, puntaje, categoria);
    }
}
