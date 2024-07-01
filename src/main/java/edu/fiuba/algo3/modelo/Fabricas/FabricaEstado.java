package edu.fiuba.algo3.modelo.Fabricas;

import edu.fiuba.algo3.modelo.excepciones.PreguntaInexistenteException;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.turno.Estado.*;


public class FabricaEstado {
    public static Estado crearEstado(Pregunta pregunta) {
        String preguntaString = pregunta.getClass().toString();

        String nombrePregunta = preguntaString.substring(preguntaString.lastIndexOf('.') + 1);
        Estado estado;

        switch (nombrePregunta) {
            case "VerdaderoFalso":
                estado = new ManejarVoF();
                break;
            case "MultipleChoice":
                estado= new ManejarMultipleC();
                break;
            case "OrderedChoice":
                estado=new ManejarOrderedC();
                break;
            case "GroupChoice":
                estado= new ManejarGrupC();
                break;
            default:
                throw new PreguntaInexistenteException();

        }
        return estado;

    }



}