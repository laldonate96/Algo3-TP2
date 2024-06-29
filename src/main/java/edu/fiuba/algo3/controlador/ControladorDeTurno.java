package edu.fiuba.algo3.controlador;

import java.util.List;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.turno.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorDeTurno implements EventHandler<ActionEvent> {

    private List<Opcion> opcionesElegidas;
    private Modificador modificador;
    private Turno turno;

    public ControladorDeTurno(Turno turno, List<Opcion> opcionesElegidas, Modificador modificador) {
        this.turno = turno;
        this.opcionesElegidas = opcionesElegidas;
        this.modificador = modificador;
    }

    public void iniciarRondaJugador(Turno turno) {
        AlgoHoot3 algoHoot = AlgoHoot3.obtenerInstancia();

        algoHoot.pasarRonda(turno);

        //PreguntaVista preguntaVista = new PreguntaVista(algoHoot.obtenerPreguntaDeRondaActual(), algoHoot.obtenerJugadorActual());
    }

    public void responderPregunta(List<Opcion> opcionesElegidas, Modificador modificador) {
        AlgoHoot3 algoHoot = AlgoHoot3.obtenerInstancia();

        algoHoot.jugarTurno(opcionesElegidas, modificador);

        //PreguntaVista preguntaVista = new PreguntaVista(algoHoot.obtenerPreguntaDeRondaActual(), algoHoot.obtenerJugadorActual());
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        responderPregunta(opcionesElegidas, modificador);
        iniciarRondaJugador(turno);
    }
}