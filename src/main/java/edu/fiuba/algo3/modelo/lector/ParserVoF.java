package edu.fiuba.algo3.modelo.lector;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Fabricas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class ParserVoF implements LectorParser {
    @Override
    public Pregunta parsearPregunta(JSONObject preguntaJson, Puntaje puntaje) {
        String enunciado = preguntaJson.getString("Pregunta");
        String categoria = preguntaJson.getString("Tema");
        List<String> posicionesCorrectas =new ArrayList<>();
        posicionesCorrectas.add(preguntaJson.getString("Respuesta"));
        List<String> contenidoOpciones = new ArrayList<>();
        contenidoOpciones.add(preguntaJson.getString("Opcion 1"));
        contenidoOpciones.add(preguntaJson.getString("Opcion 2" ));

        List<Opcion> opciones=FabricaOpciones.crearListaSimple(contenidoOpciones,posicionesCorrectas);
        
        return FabricaPreguntas.crearPreguntaVOF(enunciado, opciones, puntaje, categoria);
    }
}
