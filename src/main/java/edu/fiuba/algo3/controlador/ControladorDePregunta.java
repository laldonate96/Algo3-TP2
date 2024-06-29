package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.turno.Turno;

public class ControladorDePregunta {
    public Pregunta mostrarPregunta() {
        Turno turno = new Turno();
        AlgoHoot3.obtenerInstancia().pasarRonda(turno);
        return AlgoHoot3.obtenerInstancia().obtenerPreguntaDeRondaActual();
    }
}
