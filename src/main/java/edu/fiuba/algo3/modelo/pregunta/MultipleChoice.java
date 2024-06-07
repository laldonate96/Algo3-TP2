package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.opcion.Opcion;

import java.util.List;

public class MultipleChoice extends Pregunta {
    public MultipleChoice(String enunciado, List<Opcion> opciones, Puntaje puntaje) {
        super(enunciado, opciones, puntaje);
    }
}