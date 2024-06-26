package edu.fiuba.algo3.controlador;

import java.util.List;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.turno.Turno;
import edu.fiuba.algo3.vista.PreguntaVista;

public class ControladorDeTurno {
    public void iniciarTurnoJugador(Turno turno) {
        AlgoHoot3 algoHoot = AlgoHoot3.obtenerInstancia();

        algoHoot.pasarRonda(turno);

        PreguntaVista preguntaVista = new PreguntaVista(algoHoot.obtenerPreguntaDeRondaActual(), algoHoot.obtenerJugadorActual());
    }

    public void responderPregunta(List<Opcion> opcionesElegidas, ModificadorPuntaje modificadorPuntaje) {
        AlgoHoot3 algoHoot = AlgoHoot3.obtenerInstancia();

        algoHoot.jugarTurno(opcionesElegidas, modificadorPuntaje);

        PreguntaVista preguntaVista = new PreguntaVista(algoHoot.obtenerPreguntaDeRondaActual(), algoHoot.obtenerJugadorActual());
    }
}