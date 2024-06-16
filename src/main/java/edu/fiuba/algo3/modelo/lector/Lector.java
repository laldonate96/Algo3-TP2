package edu.fiuba.algo3.modelo.lector;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.fiuba.algo3.excepciones.ArchivoInexistenteException;
import edu.fiuba.algo3.modelo.pregunta.FabricaPreguntas;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.puntaje.Parcial;

public class Lector {
    private int cantidadDePreguntas = 24;
    
    public ArrayList<Pregunta> obtenerPreguntasDeJson() throws ArchivoInexistenteException {
        try {
            String datos = new String(Files.readAllBytes(Paths.get("preguntas/preguntas.json")));
            ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
            JSONArray arrayJson = new JSONArray(datos);
            for (int i = 0; i < cantidadDePreguntas; i++) {
                Pregunta pregunta = null;
                JSONObject preguntaJson = arrayJson.getJSONObject(i);
                String tipoPregunta = preguntaJson.getString("tipo");

                switch (tipoPregunta) {
                    case "Verdadero Falso Simple":
                        pregunta = FabricaPreguntas.preguntaVerdaderoFalso(preguntaJson, new Clasica());
                        break;
                    case "Verdadero Falso Penalidad":
                        pregunta = FabricaPreguntas.preguntaVerdaderoFalso(preguntaJson, new ConPenalidad());
                        break;
                    case "Multiple Choice Simple":
                        pregunta = FabricaPreguntas.preguntaMultipleChoice(preguntaJson, new Clasica());
                        break;
                    case "Multiple Choice Penalidad":
                        pregunta = FabricaPreguntas.preguntaMultipleChoice(preguntaJson, new ConPenalidad());
                        break;
                    case "Multiple Choice Parcial":
                        pregunta = FabricaPreguntas.preguntaMultipleChoice(preguntaJson, new Parcial());
                        break;
                    case "Ordered Choice":
                        pregunta = FabricaPreguntas.preguntaOrderedChoice(preguntaJson, new Clasica());
                        break;
                    case "Group Choice":
                        pregunta = FabricaPreguntas.preguntaGroupChoice(preguntaJson, new Clasica());
                        break;
                    default:
                        break;
                }

                preguntas.add(pregunta);
            }

            return preguntas;
        } catch (Exception e) {
            throw new ArchivoInexistenteException("No se pudo leer el archivo de preguntas porque no existe");
        }
    }
}
