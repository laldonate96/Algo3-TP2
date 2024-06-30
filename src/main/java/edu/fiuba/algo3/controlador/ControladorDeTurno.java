package edu.fiuba.algo3.controlador;

import java.util.List;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorDeTurno implements EventHandler<ActionEvent> {

    private List<Opcion> opcionesElegidas;
    private Modificador modificador;


  

    public void iniciarRondaJugador() {
        AlgoHoot3 algoHoot = AlgoHoot3.obtenerInstancia();

        algoHoot.pasarRonda();

        //PreguntaVista preguntaVista = new PreguntaVista(algoHoot.obtenerPreguntaDeRondaActual(), algoHoot.obtenerJugadorActual());
    }

    public void responderPregunta(List<Opcion> opcionesElegidas, Modificador modificador) {
        this.opcionesElegidas = opcionesElegidas;
        this.modificador = modificador;
        AlgoHoot3 algoHoot = AlgoHoot3.obtenerInstancia();

        algoHoot.jugarTurno(opcionesElegidas, modificador);

        //PreguntaVista preguntaVista = new PreguntaVista(algoHoot.obtenerPreguntaDeRondaActual(), algoHoot.obtenerJugadorActual());
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        responderPregunta(opcionesElegidas, modificador);
        iniciarRondaJugador();
    }
}