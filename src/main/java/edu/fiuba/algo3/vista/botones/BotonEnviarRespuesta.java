package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.ControladorDeTurno;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.turno.Turno;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.util.List;

public class BotonEnviarRespuesta extends Button {


    public BotonEnviarRespuesta(Turno turno, List<Opcion> opcionesElegidas, Modificador modificador) {
        super();
        this.setText("Enviar");
        this.setMinHeight(30);
        FadeTransition titilante = new FadeTransition(Duration.seconds(1), this);
        titilante.setFromValue(1.0);
        titilante.setToValue(0.0);
        titilante.setCycleCount(Animation.INDEFINITE);
        titilante.setAutoReverse(true);
        titilante.play();
        this.setOnMouseEntered(event -> this.setCursor(Cursor.HAND));
        this.setOnMouseExited(event -> this.setCursor(Cursor.DEFAULT));
        this.setOnAction(new ControladorDeTurno(turno, opcionesElegidas, modificador));
    }
}
