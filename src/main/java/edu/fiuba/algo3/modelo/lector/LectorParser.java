package edu.fiuba.algo3.modelo.lector;

import org.json.JSONObject;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

import java.util.ArrayList;
import java.util.List;

public abstract class LectorParser {


     protected String enunciado;
     protected String categoria;
     protected String explicacion;

     public abstract Pregunta parsearPregunta(JSONObject preguntaJson, Puntaje puntaje);


     protected void leerEnunciadoCategoriaYExplicacion(JSONObject preguntaJson){
          enunciado = preguntaJson.getString("Pregunta");
          categoria = preguntaJson.getString("Tema");
          explicacion = preguntaJson.getString("Texto respuesta");
     }
     protected List<String> obtenerContenidoOpciones(JSONObject preguntaJson, int cantidadOpciones) {
          List<String> contenidoOpciones = new ArrayList<>();

          for (int i = 1; i < cantidadOpciones; i++) {
               String opcionKey = "Opcion " + i;
               if (preguntaJson.has(opcionKey)) {
                    contenidoOpciones.add(preguntaJson.getString(opcionKey));
               }
          }
          return contenidoOpciones;
     }
}
