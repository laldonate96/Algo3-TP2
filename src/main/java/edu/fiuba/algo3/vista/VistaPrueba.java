package edu.fiuba.algo3.vista;

import java.util.List;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.vista.opciones.VerdaderoOFalsoVista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaPrueba extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    
        List<String> contenidoOpciones = List.of("Verdadero", "Falso");
        List<String> posicionesDeCorrectas = List.of("Verdadero"); 
    


        List<Opcion> opciones = FabricaOpciones.crearListaSimple(contenidoOpciones, posicionesDeCorrectas, new Correcta());


        VBox contenedor = new VBox();

    
        VerdaderoOFalsoVista verdaderoOFalsoVista = new VerdaderoOFalsoVista();
        verdaderoOFalsoVista.mostrarOpciones(opciones, contenedor);

        Scene scene = new Scene(contenedor, 300, 200);

    
        primaryStage.setTitle("Vista de Prueba");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
