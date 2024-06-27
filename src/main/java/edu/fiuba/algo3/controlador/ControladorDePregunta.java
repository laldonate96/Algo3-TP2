package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.lector.mezclador.Mezclador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

public class ControladorDePregunta {
    public Pregunta mostrarPregunta() {
        return AlgoHoot3.obtenerInstancia().obtenerPreguntaDeRondaActual();
    }
}
