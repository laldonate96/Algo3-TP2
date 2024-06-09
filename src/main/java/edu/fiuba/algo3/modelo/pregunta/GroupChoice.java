package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;

public class GroupChoice extends Pregunta {
    public GroupChoice(String enunciado, List<Opcion> opciones, edu.fiuba.algo3.modelo.puntaje.Puntaje Puntaje) {
        super(enunciado, opciones, Puntaje);
    }
}
