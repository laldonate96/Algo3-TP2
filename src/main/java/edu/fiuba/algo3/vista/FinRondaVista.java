package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.vista.opciones.SeleccionadorOpciones;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinRondaVista extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox toolbarBox = Toolbar.obtenerInstancia().mostrarToolbar(primaryStage);

        GridPane contenedor = new GridPane();

        SeleccionadorOpciones seleccionador = new SeleccionadorOpciones();
//        seleccionador.seleccionarVistaOpciones(pregunta, contenedor);

        Scene scene = new Scene(contenedor, 300, 200);

        primaryStage.setTitle("Vista de Prueba");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
