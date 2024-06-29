package edu.fiuba.algo3.vista;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.pregunta.GroupChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import edu.fiuba.algo3.vista.opciones.SeleccionadorOpciones;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaPrueba extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        List<String> grupos = List.of("a", "b");
        List<List<String>> opcionesGrupo = List.of(List.of("opcion1"), List.of("opcion2"));

        // Convertir las listas inmutables en listas mutables
        List<String> gruposMutables = new ArrayList<>(grupos);
        List<List<String>> opcionesGrupoMutables = new ArrayList<>();
        for (List<String> grupo : opcionesGrupo) {
            opcionesGrupoMutables.add(new ArrayList<>(grupo));
        }

        List<Opcion> opciones = FabricaOpciones.crearListaGrupo(gruposMutables, opcionesGrupoMutables, new Correcta());
        Pregunta pregunta = new GroupChoice("pepe", opciones, new Clasica(1), "categoria");

        System.out.println("prueba");

        GridPane contenedor = new GridPane();



        SeleccionadorOpciones.seleccionarVistaOpciones(opciones, pregunta, contenedor);

        Scene scene = new Scene(contenedor, 300, 200);

        primaryStage.setTitle("Vista de Prueba");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
