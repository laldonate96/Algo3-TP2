package edu.fiuba.algo3.vista;

import java.util.List;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Ordenada;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;

import edu.fiuba.algo3.modelo.pregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.vista.opciones.SeleccionadorOpciones;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VistaPrueba extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        List<String> opcionesOrdered = List.of("opcion1", "opcion2");

        List<Ordenada> opciones = FabricaOpciones.crearListaOrdenada(opcionesOrdered, List.of("2", "1"), new Correcta());
        Pregunta pregunta = new OrderedChoice("pepe", opciones, new Clasica(1), "categoria","Say no More" );

        GridPane contenedor = new GridPane();

        SeleccionadorOpciones seleccionador = new SeleccionadorOpciones();
        seleccionador.seleccionarVistaOpciones(pregunta, contenedor);

        Scene scene = new Scene(contenedor, 300, 200);

        primaryStage.setTitle("Vista de Prueba");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
