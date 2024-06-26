package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class VerdaderoFalso extends Pregunta {
    public VerdaderoFalso(String enunciado, List<Opcion> opciones, Puntaje puntaje, String categoria) {
        super(enunciado, opciones, puntaje, categoria);
    }
}
