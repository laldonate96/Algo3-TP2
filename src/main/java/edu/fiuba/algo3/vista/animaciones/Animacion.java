package edu.fiuba.algo3.vista.animaciones;
import javafx.scene.text.Text;


public abstract class Animacion {
    protected int duracion;
    protected Text texto;

    public Animacion(int duracion, Text texto){
        this.duracion = duracion;
        this.texto = texto;
    }

    public void aplicarAnimacion(){

    };
}
