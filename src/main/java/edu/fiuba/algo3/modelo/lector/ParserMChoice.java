package edu.fiuba.algo3.modelo.lector;


import java.util.Arrays;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import org.json.JSONObject;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Fabricas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class ParserMChoice extends LectorParser {
    @Override
    public Pregunta parsearPregunta(JSONObject preguntaJson, Puntaje puntaje) {
        leerEnunciadoCategoriaYExplicacion(preguntaJson);


        List<String> posicionesCorrectas = Arrays.asList(preguntaJson.getString("Respuesta").split("\\s*,\\s*"));
        List<String> contenidoOpciones=obtenerContenidoOpciones(preguntaJson,6);
        List<Opcion> opciones=FabricaOpciones.crearListaSimple(contenidoOpciones,posicionesCorrectas, new Correcta());

        return FabricaPreguntas.crearPreguntaMultipleChoice(enunciado, opciones, puntaje, categoria,explicacion);
    }
}
