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

public class ParserOrdered implements LectorParser {

    @Override
    public Pregunta parsearPregunta(JSONObject preguntaJson, Puntaje puntaje) {
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
        List<Opcion> opciones=FabricaOpciones.crearListaOrdenada(contenidoOpciones,posicionesCorrectas, new Correcta());
        return FabricaPreguntas.crearPreguntaOrderedChoice(enunciado, opciones, puntaje, categoria);
    }
    
}
