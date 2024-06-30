package edu.fiuba.algo3.vista.botones;

import java.util.List;

import edu.fiuba.algo3.controlador.ControladorDeTurno;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;

public class BotonEnviarRespuesta extends Boton {



public BotonEnviarRespuesta(List<Opcion> opcionesElegidas, Modificador modificador) {
        super("Enviar", "button");
        this.setMinHeight(30); 
        this.setOnAction(new ControladorDeTurno(opcionesElegidas, modificador));
}
}
