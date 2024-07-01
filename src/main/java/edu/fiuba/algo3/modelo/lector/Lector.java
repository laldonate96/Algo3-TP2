package edu.fiuba.algo3.modelo.lector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.lector.mezclador.Mezclador;
import org.json.JSONArray;
import org.json.JSONObject;

import edu.fiuba.algo3.modelo.excepciones.ArchivoInexistenteException;
import edu.fiuba.algo3.modelo.Fabricas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.puntaje.Parcial;

public class Lector {

    public static List<Pregunta> obtenerPreguntasDeJson(Mezclador mezclador,String direccion) throws ArchivoInexistenteException {
        try {
            String datos = new String(Files.readAllBytes(Paths.get(direccion)));
            ArrayList<Pregunta> preguntas = new ArrayList<>();
            JSONArray arrayJson = new JSONArray(datos);

            Clasica clasica;
            LectorParser parser;
            ConPenalidad conPenalidad = new ConPenalidad();
            Parcial parcial = new Parcial();

            for (Object obj : arrayJson) {
                JSONObject preguntaJson = (JSONObject) obj;
                Pregunta pregunta = null;
                String tipoPregunta = preguntaJson.getString("Tipo");

                switch (tipoPregunta) {
                    case "Verdadero Falso Simple":
                        parser = new ParserVoF();
                        clasica=new Clasica(1);
                        pregunta = parser.parsearPregunta(preguntaJson, clasica);
                        break;
                    case "Verdadero Falso Penalidad":
                        parser = new ParserVoF();
                        pregunta = parser.parsearPregunta(preguntaJson, conPenalidad);
                        break;
                    case "Multiple Choice Simple":
                        parser = new ParserMChoice();
                        clasica = new Clasica(FabricaPreguntas.obtenerCantidadCorrectas(preguntaJson));
                        pregunta = parser.parsearPregunta(preguntaJson, clasica);
                        break;
                    case "Multiple Choice Penalidad":
                        parser = new ParserMChoice();
                        pregunta = parser.parsearPregunta(preguntaJson, conPenalidad);
                        break;
                    case "Multiple Choice Puntaje Parcial":
                        parser = new ParserMChoice();
                        pregunta = parser.parsearPregunta(preguntaJson, parcial);
                        break;
                    case "Ordered Choice":
                        parser = new ParserOrdered();
                        clasica = new Clasica(FabricaPreguntas.obtenerCantidadCorrectas(preguntaJson));
                        pregunta = parser.parsearPregunta(preguntaJson, clasica);
                        break;
                    case "Group Choice":
                        parser = new ParserGroup();
                        clasica = new Clasica(FabricaPreguntas.obtenerCantidadCorrectas(preguntaJson));
                        pregunta = parser.parsearPregunta(preguntaJson, clasica);
                        break;
                    default:
                        break;
                }
                preguntas.add(pregunta);
            }
            return mezclador.mezclarPreguntas(preguntas);
        } catch (NoSuchFileException e) {
            throw new ArchivoInexistenteException("El archivo de preguntas no existe: " + e.getMessage());
        } catch (IOException e) {
            throw new ArchivoInexistenteException("Error de IO al leer el archivo de preguntas: " + e.getMessage());
        } catch (Exception e) {
            throw new ArchivoInexistenteException("No se pudo leer el archivo de preguntas: " + e.getMessage());
        }
    }
}