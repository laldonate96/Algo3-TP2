package edu.fiuba.algo3.vista.animaciones;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Traslacion {


    public void  aplicarTraslacion(VBox nodo,int count){
        TranslateTransition translate = new TranslateTransition();

        translate.setByX(400);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(count);
        translate.setAutoReverse(true);
        translate.setNode(nodo);
        translate.play();
    }

}