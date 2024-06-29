package edu.fiuba.algo3.vista;

import java.net.URL;
import java.util.List;

//import edu.fiuba.algo3.controlador.ControladorUsoDeModificadorDePuntaje;
import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.Multiplicador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.turno.Turno;
import edu.fiuba.algo3.vista.botones.*;
import edu.fiuba.algo3.vista.opciones.VerdaderoOFalsoVista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VistaPrueba2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        List<String> contenidoOpciones = List.of("Verdadero", "Falso");
        List<String> posicionesDeCorrectas = List.of("Verdadero");



        List<Opcion> opciones = FabricaOpciones.crearListaSimple(contenidoOpciones, posicionesDeCorrectas, new Correcta());


        HBox contenedor = new HBox();

        Button boton1= new BotonEnviarRespuesta(new Turno(),opciones,new Multiplicador(1));
        Button boton2= new BotonAnulador(new Jugador("pjepe", List.of(new Multiplicador(1))),new Multiplicador(1),"botonModificador");
        Button boton3= new BotonExclusividad(new Jugador("opepe", List.of(new Multiplicador(1))),new Multiplicador(1),"botonModificador");
        Button boton4= new BotonX2(new Jugador("pope", List.of(new Multiplicador(1))),new Multiplicador(1),"botonModificador");
        Button boton5= new BotonX3(new Jugador("ppejjjjpe", List.of(new Multiplicador(1))),new Multiplicador(1),"botonModificador");
        Button boton6= new BotonExclusividad(new Jugador("bpepe", List.of(new Multiplicador(1))),new Multiplicador(1),"botonModificador");
        contenedor.getChildren().addAll(boton1,boton2,boton3,boton6,boton4,boton5);

        VerdaderoOFalsoVista verdaderoOFalsoVista = new VerdaderoOFalsoVista();
        verdaderoOFalsoVista.mostrarOpciones(opciones, contenedor);

        Scene scene = new Scene(contenedor, 300, 200);
        String cssPath = "src/css/style.css";
        URL cssURL = this.getClass().getResource(cssPath);
        if (cssURL != null) {
            String css = cssURL.toExternalForm();
            scene.getStylesheets().add(css);
        } else {
            System.err.println("CSS file not found: " + cssPath);
        }


        primaryStage.setTitle("Vista de Prueba");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
