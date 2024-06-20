package edu.fiuba.algo3.modelo.lector.mezclador;

import java.util.Collections;
import java.util.List;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

public class Mezclador implements Filtro {
    @Override
    public List<Pregunta> mezclarPreguntas(List<Pregunta> preguntas) {
        //Collections.shuffle(preguntas);
        return preguntas;
    }
}
