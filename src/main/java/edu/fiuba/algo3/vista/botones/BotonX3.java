package edu.fiuba.algo3.vista.botones;


import edu.fiuba.algo3.controlador.ControladorActivarBoton;
import edu.fiuba.algo3.controlador.ControladorUsoDeModificadores;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;
import javafx.scene.Cursor;
import javafx.scene.control.Button;

//import java.awt.*;

public class BotonX3 extends Button {

    public BotonX3(Jugador jugador, ModificadorPuntaje modificador, String claseCSSDeBoton){
        super();
        this.setText("X3");
        this.setMinHeight(100);
//        this.setStyle("-fx-background-color: red;");
        this.getStyleClass().add(claseCSSDeBoton);
        this.setOnMouseEntered(event -> this.setCursor(Cursor.HAND));
        this.setOnMouseExited(event -> this.setCursor(Cursor.DEFAULT));
        this.setOnAction(new ControladorUsoDeModificadores(jugador,modificador));
        this.setOnAction(new ControladorActivarBoton(this));
    }


}