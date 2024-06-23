package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.turno.Turno;
import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TurnoVista extends Application{
    private  Turno turnoActual;
    private  Jugador jugadorActual;
    public static void main(String[] args) {
        launch(args);
    }
    public void mostrarTurno(int ronda, Jugador jugador){
        //this.turnoActual = turno;
        this.jugadorActual = jugador;
    }
    @Override
         public void start(Stage stage) throws Exception {
            stage.setTitle(this.jugadorActual.obtenerNombre());
            Text turno = new Text();
        }

}