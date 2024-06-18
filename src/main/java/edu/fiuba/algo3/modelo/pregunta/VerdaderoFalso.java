package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.opciones.Opciones;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.opciones.opcion.Opcion;

import java.util.List;

public class VerdaderoFalso extends Pregunta {
    public VerdaderoFalso(String enunciado, Opciones opciones, Puntaje puntaje, String categoria) {
        super(enunciado, opciones, puntaje, categoria);
    }
}