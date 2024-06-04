package edu.fiuba.algo3.modelo.pregunta;


import edu.fiuba.algo3.modelo.DistribuidoraDePuntaje.DistribuidoraDePuntaje;

import java.util.List;

public class VerdaderoOFalso extends Pregunta {
    public VerdaderoOFalso(String enunciado, List<String> respuestasCorrectas, DistribuidoraDePuntaje distribuidoraDePuntaje) {
        super(enunciado, respuestasCorrectas, distribuidoraDePuntaje);
    }
}

