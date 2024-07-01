package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class GroupChoice extends Pregunta {
    private final List<Grupo> opciones;

    public GroupChoice(String enunciado, List<Grupo> opciones, Puntaje puntaje, String categoria, String explicacion) {
        super(enunciado, puntaje, categoria,explicacion);
        this.opciones=opciones;
    }

    public List<Grupo> obtenerOpciones(){
        return opciones;
    }
}
