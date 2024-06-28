package edu.fiuba.algo3.vista.botones;

import javafx.scene.Cursor;
import javafx.scene.control.MenuButton;

public class BotonMenu extends MenuButton {
    
    public BotonMenu(String textoDeBoton) {
        super(textoDeBoton); 
        this.setOnMouseEntered(event -> this.setCursor(Cursor.HAND));
        this.setOnMouseExited(event -> this.setCursor(Cursor.DEFAULT));
    }
}
