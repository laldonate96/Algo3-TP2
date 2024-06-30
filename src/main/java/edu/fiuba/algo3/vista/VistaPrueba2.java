package edu.fiuba.algo3.vista;

import java.net.URL;
import java.util.List;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.Multiplicador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import edu.fiuba.algo3.modelo.turno.Turno;
import edu.fiuba.algo3.vista.botones.BotonAnulador;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import edu.fiuba.algo3.vista.botones.BotonX2;
import edu.fiuba.algo3.vista.botones.BotonX3;
import edu.fiuba.algo3.vista.opciones.VerdaderoOFalsoVista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VistaPrueba2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        List<String> contenidoOpciones = List.of("Verdadero", "Falso");
        List<String> posicionesDeCorrectas = List.of("Verdadero");
        List<Modificador> modificadores = List.of(new Multiplicador(2), new Multiplicador(3));


        List<Opcion> opciones = FabricaOpciones.crearListaSimple(contenidoOpciones, posicionesDeCorrectas, new Correcta());
        Jugador jugador = new Jugador("pepe", modificadores);


        Button boton1= new BotonEnviarRespuesta(new Turno(),opciones,new Multiplicador(1));
        Button boton2= new BotonAnulador(jugador);
        Button boton3= new BotonExclusividad(jugador);
        Button boton4= new BotonX2(jugador);
        Button boton5= new BotonX3(jugador);
        Button boton6= new BotonExclusividad(jugador);

        GridPane contenedor = new GridPane();
        List<Button> listaBotones= List.of(boton1,boton2,boton3,boton4,boton5, boton6);
        for (Button boton: listaBotones){
            contenedor.add(boton,0,listaBotones.indexOf(boton));
        }

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
