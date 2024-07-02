package edu.fiuba.algo3.vista.animaciones;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Titilante extends Animacion{
    
    public Titilante(int duracion, Text texto){
        super(duracion, texto);
    }
    @Override
    public void aplicarAnimacion() {
        FadeTransition titilante = new FadeTransition(Duration.seconds(this.duracion), this.texto);
        titilante.setFromValue(1.0);
        titilante.setToValue(0.0);
        titilante.setCycleCount(Animation.INDEFINITE);
        titilante.setAutoReverse(true);
        titilante.play();
    }
    
}
