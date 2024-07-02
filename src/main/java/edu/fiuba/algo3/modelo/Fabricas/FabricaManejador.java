package edu.fiuba.algo3.modelo.Fabricas;

import edu.fiuba.algo3.modelo.excepciones.PreguntaInexistenteException;

import edu.fiuba.algo3.modelo.pregunta.*;
import edu.fiuba.algo3.modelo.turno.Estado.*;


public class FabricaManejador {
    public static Manejador crearManejador(Pregunta pregunta) {
        String preguntaString = pregunta.getClass().toString();

        String nombrePregunta = preguntaString.substring(preguntaString.lastIndexOf('.') + 1);
        Manejador manejador;

        switch (nombrePregunta) {
            case "VerdaderoFalso":
                manejador = new ManejarVoF((VerdaderoFalso) pregunta);
                break;
            case "MultipleChoice":
                manejador = new ManejarMultipleC((MultipleChoice) pregunta);
                break;
            case "OrderedChoice":
                manejador =new ManejarOrderedC((OrderedChoice) pregunta);
                break;
            case "GroupChoice":
                manejador = new ManejarGroupChoice((GroupChoice) pregunta);
                break;
            default:
                throw new PreguntaInexistenteException(" la pregunta guardada no tiene asignado un Manejador");

        }
        return manejador;

    }



}