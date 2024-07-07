package edu.fiuba.algo3.vista.animaciones;

import edu.fiuba.algo3.vista.botones.Boton;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

public class BotonEnviar extends  AnimacionBotones{

    public BotonEnviar(int duracion, Boton boton){
        super(duracion, boton);
    }
    @Override
    public void aplicarAnimacion() {
        FadeTransition titilante = new FadeTransition(Duration.seconds(this.duracion), this.boton);
        titilante.setFromValue(1.0);
        titilante.setToValue(0.0);
        titilante.setCycleCount(Animation.INDEFINITE);
        titilante.setAutoReverse(true);
        titilante.play();
    }
    
}
