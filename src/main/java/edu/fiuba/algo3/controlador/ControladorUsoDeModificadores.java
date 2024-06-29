package edu.fiuba.algo3.controlador;

//import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.Modificador;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
//import javafx.scene.control.Button;

public class ControladorUsoDeModificadores implements EventHandler<ActionEvent> {

    private final Modificador modificador;
    private final Jugador jugadorActual;

    public ControladorUsoDeModificadores(Jugador jugador, Modificador modificador){
        this.modificador = modificador;
        this.jugadorActual= jugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugadorActual.usar(modificador);
        //Va ser solo de ModificadoresDePuntaje por ahora
    }
}
