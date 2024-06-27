package edu.fiuba.algo3.controlador;

import java.util.List;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.turno.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorDeTurno implements EventHandler<ActionEvent> {

    private List<Opcion> opcionesElegidas;
    private ModificadorPuntaje modificadorPuntaje;
    private Turno turno;

    public ControladorDeTurno(Turno turno,List<Opcion> opcionesElegidas,ModificadorPuntaje modificadorPuntaje) {
        this.turno = turno;
        this.opcionesElegidas = opcionesElegidas;
        this.modificadorPuntaje = modificadorPuntaje;
    }

    public void iniciarRondaJugador(Turno turno) {
        AlgoHoot3 algoHoot = AlgoHoot3.obtenerInstancia();

        algoHoot.pasarRonda(turno);

        //PreguntaVista preguntaVista = new PreguntaVista(algoHoot.obtenerPreguntaDeRondaActual(), algoHoot.obtenerJugadorActual());
    }

    public void responderPregunta(List<Opcion> opcionesElegidas, ModificadorPuntaje modificadorPuntaje) {
        AlgoHoot3 algoHoot = AlgoHoot3.obtenerInstancia();

        algoHoot.jugarTurno(opcionesElegidas, modificadorPuntaje);

        //PreguntaVista preguntaVista = new PreguntaVista(algoHoot.obtenerPreguntaDeRondaActual(), algoHoot.obtenerJugadorActual());
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        responderPregunta(opcionesElegidas, modificadorPuntaje);
        iniciarRondaJugador(turno);
    }
}