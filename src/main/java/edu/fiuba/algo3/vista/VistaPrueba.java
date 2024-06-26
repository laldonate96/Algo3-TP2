package edu.fiuba.algo3.vista;

import java.util.List;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.vista.opciones.SeleccionadorOpciones;
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
        List<String> ordenCorrecto = List.of("Verdadero", "Falso");
    


       // List<Opcion> opciones = FabricaOpciones.crearListaGrupo(contenidoOpciones, posicionesDeCorrectas, new Correcta());

        List<Opcion> opciones = FabricaOpciones.crearListaOrdenada(contenidoOpciones, ordenCorrecto, new Correcta());
        Pregunta pregunta = new Pregunta("texto", opciones, new Clasica(1) , "categoria");

        VBox contenedor = new VBox();

    
        SeleccionadorOpciones.seleccionarVistaOpciones(opciones, opciones.get(0).obtenerTipo(), contenedor);
        

        Scene scene = new Scene(contenedor, 300, 200);

    
        primaryStage.setTitle("Vista de Prueba");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
