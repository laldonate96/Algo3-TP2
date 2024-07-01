package edu.fiuba.algo3.modelo.lector;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import org.json.JSONObject;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Fabricas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class ParserVoF extends LectorParser {
    @Override
    public Pregunta parsearPregunta(JSONObject preguntaJson, Puntaje puntaje) {
        leerEnunciadoCategoriaYExplicacion(preguntaJson);


        List<String> posicionesCorrectas = new ArrayList<>();
        posicionesCorrectas.add(preguntaJson.getString("Respuesta"));

        List<String> contenidoOpciones =obtenerContenidoOpciones(preguntaJson,2);

        List<Simple> opciones=FabricaOpciones.crearListaSimple(contenidoOpciones,posicionesCorrectas, new Correcta());
        
        return FabricaPreguntas.crearPreguntaVerdaderoFalso(enunciado, opciones, puntaje, categoria,explicacion);
    }
}
