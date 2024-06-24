package edu.fiuba.algo3.vista.animaciones;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MaquinaDeEscribir extends Animacion {
    
    private final String textoCompleto;
    
    public MaquinaDeEscribir(int duracion, Text texto, String textoCompleto) {
        super(duracion, texto);
        this.textoCompleto = textoCompleto;
    }

    @Override
    public void aplicarAnimacion() {
        Timeline lineaDeTiempo = new Timeline();
        texto.setText(""); 
        
        int longitud = textoCompleto.length();
        double intervalo = (double) duracion / longitud; 

        for (int i = 0; i < longitud; i++) {
            final int indice = i;
            KeyFrame fotogramaClave = new KeyFrame(Duration.seconds(intervalo * indice), 
                e -> texto.setText(texto.getText() + textoCompleto.charAt(indice)));
            lineaDeTiempo.getKeyFrames().add(fotogramaClave);
        }
        
        lineaDeTiempo.setCycleCount(1);
        lineaDeTiempo.play();
    }
}