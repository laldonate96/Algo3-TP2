package edu.fiuba.algo3.modelo.lector;

import org.json.JSONObject;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public interface LectorParser {
    public Pregunta parsearPregunta(JSONObject preguntaJson, Puntaje puntaje);
}
