package edu.fiuba.algo3.controlador;

import java.util.List;

import edu.fiuba.algo3.modelo.AlgoHoot3;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.vista.InicioDelJuego;
import edu.fiuba.algo3.vista.PreguntaVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControladorDeTurno implements EventHandler<ActionEvent> {

    private List<Opcion> opcionesElegidas;
    private Modificador modificador;
    private Stage stage;
  

    public void iniciarRondaJugador() {
        AlgoHoot3 algoHoot = AlgoHoot3.obtenerInstancia();

        algoHoot.pasarRonda();

        //PreguntaVista preguntaVista = new PreguntaVista(algoHoot.obtenerPreguntaDeRondaActual(), algoHoot.obtenerJugadorActual());
    }

    public void responderPregunta(List<Opcion> opcionesElegidas, Modificador modificador, Stage stage) {
        this.opcionesElegidas = opcionesElegidas;
        this.modificador = modificador;
        this.stage = stage;
        AlgoHoot3 algoHoot = AlgoHoot3.obtenerInstancia();

        algoHoot.jugarTurno(opcionesElegidas, modificador);

        ControladorVentanaNueva ventanaNueva = new ControladorVentanaNueva();
        ventanaNueva.abrirVentanaNueva(new PreguntaVista(), stage);

        if (algoHoot.terminoJuego()) {
            ventanaNueva.abrirVentanaNueva(new InicioDelJuego(), stage);
        }
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        responderPregunta(opcionesElegidas, modificador, stage);
        //iniciarRondaJugador();
    }
}