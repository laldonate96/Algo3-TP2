package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class GroupChoice extends Pregunta {
    public GroupChoice(String enunciado, List<Opcion> opciones, Puntaje puntaje, String categoria, String explicacion) {
        super(enunciado, opciones, puntaje, categoria,explicacion);
    }
}
