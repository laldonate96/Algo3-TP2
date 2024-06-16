package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.opcion.Opcion;

import java.util.List;

public class VerdaderoFalso extends Pregunta {
    public VerdaderoFalso(String enunciado, List<Opcion> opciones, Puntaje puntaje, String categoria) {
        super(enunciado, opciones, puntaje, categoria);
    }
}