package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.InicioDelJuego;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        InicioDelJuego juego = new InicioDelJuego();
        try {
            juego.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
