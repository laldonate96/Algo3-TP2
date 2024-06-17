package edu.fiuba.algo3.modelo.lector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.fiuba.algo3.excepciones.ArchivoInexistenteException;
import edu.fiuba.algo3.modelo.mezclador.Mezclador;
import edu.fiuba.algo3.modelo.pregunta.FabricaPreguntas;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.modelo.puntaje.ConPenalidad;
import edu.fiuba.algo3.modelo.puntaje.Parcial;

public class Lector {  
    public List<Pregunta> obtenerPreguntasDeJson() throws ArchivoInexistenteException {
        try {
            String datos = new String(Files.readAllBytes(Paths.get("preguntas/preguntas.json")));
            ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
            JSONArray arrayJson = new JSONArray(datos);

            Clasica clasica;
            ConPenalidad conPenalidad = new ConPenalidad();
            Parcial parcial = new Parcial();

            for (Object obj : arrayJson) {
                JSONObject preguntaJson = (JSONObject) obj;
                Pregunta pregunta = null;
                String tipoPregunta = preguntaJson.getString("Tipo");

                switch (tipoPregunta) {
                    case "Verdadero Falso Simple":
                        clasica=new Clasica(1);
                        pregunta = FabricaPreguntas.preguntaVerdaderoFalso(preguntaJson, clasica);
                        break;
                    case "Verdadero Falso Penalidad":
                        pregunta = FabricaPreguntas.preguntaVerdaderoFalso(preguntaJson, conPenalidad);
                        break;
                    case "Multiple Choice Simple":
                        clasica = new Clasica(FabricaPreguntas.obtenerCantidadCorrectas(preguntaJson));
                        pregunta = FabricaPreguntas.preguntaMultipleChoice(preguntaJson, clasica);
                        break;
                    case "Multiple Choice Penalidad":
                        pregunta = FabricaPreguntas.preguntaMultipleChoice(preguntaJson, conPenalidad);
                        break;
                    case "Multiple Choice Parcial":
                        pregunta = FabricaPreguntas.preguntaMultipleChoice(preguntaJson, parcial);
                        break;
                    case "Ordered Choice":
                        clasica = new Clasica(FabricaPreguntas.obtenerCantidadCorrectas(preguntaJson));
                        pregunta = FabricaPreguntas.preguntaOrderedChoice(preguntaJson, clasica);
                        break;
                    case "Group Choice":
                        clasica = new Clasica(FabricaPreguntas.obtenerCantidadCorrectas(preguntaJson));
                        pregunta = FabricaPreguntas.preguntaGroupChoice(preguntaJson, clasica);
                        break;
                    default:
                        break;
                }
                preguntas.add(pregunta);
            }
            List<Pregunta> preguntasMezcladas = new Mezclador().mezclarPreguntas(preguntas);
            return preguntasMezcladas;
        } catch (NoSuchFileException e) {
            throw new ArchivoInexistenteException("El archivo de preguntas no existe: " + e.getMessage());
        } catch (IOException e) {
            throw new ArchivoInexistenteException("Error de IO al leer el archivo de preguntas: " + e.getMessage());
        } catch (Exception e) {
            throw new ArchivoInexistenteException("No se pudo leer el archivo de preguntas: " + e.getMessage());
        }
    }
}
