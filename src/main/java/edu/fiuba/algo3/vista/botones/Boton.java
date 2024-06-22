package edu.fiuba.algo3.vista.botones;

import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class Boton extends Button {
    
    public Boton(String textoDeBoton, String claseCSSDeBoton) {
        super(textoDeBoton);
        this.getStyleClass().add(claseCSSDeBoton);    
        this.setOnMouseEntered(event -> this.setCursor(Cursor.HAND));
        this.setOnMouseExited(event -> this.setCursor(Cursor.DEFAULT));
    }

}
