package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Grupal;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class GroupChoice extends Pregunta {
    private final List<Grupal> opciones;

    public GroupChoice(String enunciado, List<Grupal> opciones, Puntaje puntaje, String categoria, String explicacion) {
        super(enunciado, puntaje, categoria,explicacion);
        this.opciones=opciones;
    }

    public List<Grupal> obtenerOpciones(){
        return opciones;
    }
}
