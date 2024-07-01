package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class OrderedChoice extends Pregunta {
    public OrderedChoice(String enunciado, List<Opcion> opciones, Puntaje puntaje) {
        super(enunciado, opciones, puntaje);
    }

    
}