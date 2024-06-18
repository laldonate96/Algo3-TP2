package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;

import edu.fiuba.algo3.modelo.opciones.Opciones;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class MultipleChoice extends Pregunta {

    public MultipleChoice(String enunciado, Opciones opciones, Puntaje puntaje, String categoria) {
        super(enunciado, opciones, puntaje, categoria);
    }


}