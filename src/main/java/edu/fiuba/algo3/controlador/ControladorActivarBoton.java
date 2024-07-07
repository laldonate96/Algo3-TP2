package edu.fiuba.algo3.controlador;

import java.util.List;

import edu.fiuba.algo3.vista.botones.BotonModificador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControladorActivarBoton implements EventHandler<ActionEvent> {

    private final Button boton;
    private List<BotonModificador> botones;

    public ControladorActivarBoton(Button boton, List<BotonModificador> botones){
        this.boton= boton;
        this.botones = botones;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        for(BotonModificador boton : botones){
            boton.setDisable(false);
        }
        this.boton.setDisable(true);
    }
}