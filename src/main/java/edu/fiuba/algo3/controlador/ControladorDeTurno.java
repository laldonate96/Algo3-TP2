package edu.fiuba.algo3.controlador;

import java.util.List;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.vista.PreguntaVista;
import edu.fiuba.algo3.vista.VistaPrueba;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControladorDeTurno implements EventHandler<ActionEvent> {

    private List<Opcion> opcionesElegidas;
    private Modificador modificador;
    private Stage stage;

    public void responderPregunta(List<Opcion> opcionesElegidas, Modificador modificador, Stage stage) {
        this.opcionesElegidas = opcionesElegidas;
        this.modificador = modificador;
        this.stage = stage;
        AlgoHoot3 algoHoot = AlgoHoot3.obtenerInstancia();

        ControladorVentanaNueva ventanaNueva = new ControladorVentanaNueva();

        algoHoot.jugarTurno(opcionesElegidas, modificador);

        if (algoHoot.terminoJuego()) {
            ventanaNueva.abrirVentanaNueva(new VistaPrueba(), stage);
            return;
        }

        ventanaNueva.abrirVentanaNueva(new PreguntaVista(), stage);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        responderPregunta(opcionesElegidas, modificador, stage);
    }
}