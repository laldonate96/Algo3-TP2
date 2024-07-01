package edu.fiuba.algo3.modelo.Fabricas;

import edu.fiuba.algo3.modelo.excepciones.PreguntaInexistenteException;

import edu.fiuba.algo3.modelo.pregunta.*;
import edu.fiuba.algo3.modelo.turno.Estado.*;


public class FabricaEstado {
    public static Estado crearEstado(Pregunta pregunta) {
        String preguntaString = pregunta.getClass().toString();

        String nombrePregunta = preguntaString.substring(preguntaString.lastIndexOf('.') + 1);
        Estado estado;

        switch (nombrePregunta) {
            case "VerdaderoFalso":
                estado = new ManejarVoF((VerdaderoFalso) pregunta);
                break;
            case "MultipleChoice":
                estado= new ManejarMultipleC((MultipleChoice) pregunta);
                break;
            case "OrderedChoice":
                estado=new ManejarOrderedC((OrderedChoice) pregunta);
                break;
            case "GroupChoice":
                estado= new ManejarGroupChoice((GroupChoice) pregunta);
                break;
            default:
                throw new PreguntaInexistenteException();

        }
        return estado;

    }



}