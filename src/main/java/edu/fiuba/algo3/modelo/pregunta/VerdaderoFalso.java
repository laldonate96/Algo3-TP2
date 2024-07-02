package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;


import edu.fiuba.algo3.modelo.opcion.Simple;
import edu.fiuba.algo3.modelo.puntaje.Puntaje;

public class VerdaderoFalso extends Pregunta {
    private List<Simple> opciones;

    public VerdaderoFalso(String enunciado, List<Simple> opciones, Puntaje puntaje, String categoria, String explicacion) {
        super(enunciado, puntaje, categoria, explicacion);
        this.opciones=opciones;
    }

    public List<Simple> obtenerOpciones() {
        return opciones;
    }
}
