package edu.fiuba.algo3.modelo.lector.mezclador;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.List;

public class MezclaNula implements Mezclador {
    @Override
    public List<Pregunta> mezclarPreguntas(List<Pregunta> preguntas) {
        return preguntas;
    }
}
