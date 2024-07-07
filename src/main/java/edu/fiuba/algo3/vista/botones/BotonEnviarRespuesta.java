package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.vista.animaciones.AnimacionBotones;
import edu.fiuba.algo3.vista.animaciones.BotonEnviar;

public class BotonEnviarRespuesta extends Boton {



public BotonEnviarRespuesta() {
        super("Enviar", "button");
        AnimacionBotones titilante = new BotonEnviar(1, this);
        titilante.aplicarAnimacion();
        this.setMinHeight(30); 
}
}
