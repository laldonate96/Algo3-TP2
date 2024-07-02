package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class OrderedChoice extends Pregunta {
    private final List<Ordenada> opciones;

    public OrderedChoice(String enunciado, List<Ordenada> opciones, Puntaje puntaje, String categoria, String explicacion) {
        super(enunciado, puntaje, categoria,explicacion);
        this.opciones=opciones;
    }

    public List<Ordenada> obtenerOpciones(){
        return opciones;
    }
}