package edu.fiuba.algo3.controlador;

//import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
//import javafx.scene.control.Button;

public class ControladorUsoDeModificadores implements EventHandler<ActionEvent> {

    private final ModificadorPuntaje modificadorPuntaje;
    private final Jugador jugadorActual;

    public ControladorUsoDeModificadores(Jugador jugador,ModificadorPuntaje modificadorPuntaje){
        this.modificadorPuntaje= modificadorPuntaje;
        this.jugadorActual= jugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugadorActual.usar(modificadorPuntaje);
        //Va ser solo de ModificadoresDePuntaje por ahora
    }
}
