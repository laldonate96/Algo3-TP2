package edu.fiuba.algo3.modelo.lector.mezclador;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.List;

public interface Mezclador {
    List<Pregunta> mezclarPreguntas(List<Pregunta> preguntas);
}
