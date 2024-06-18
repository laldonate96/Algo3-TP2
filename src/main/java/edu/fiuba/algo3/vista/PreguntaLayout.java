package edu.fiuba.algo3.vista;

import java.util.Arrays;
import java.util.List;

import edu.fiuba.algo3.modelo.opciones.Opciones;
import edu.fiuba.algo3.modelo.opciones.Simples;
import edu.fiuba.algo3.modelo.opciones.opcion.estado.Incorrecta;
import edu.fiuba.algo3.modelo.pregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.puntaje.Clasica;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PreguntaLayout extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("!!! Respondan ¡¡¡");

        Label preguntaLabel = new Label("Pregunta");
        preguntaLabel.getStyleClass().add("titulo-label");

        Label jugadorLabel = new Label("Jugador:");
        TextField jugadorTextField = new TextField();
        jugadorTextField.setMaxWidth(200);

        Label turnoLabel = new Label("Turno:");
        TextField turnoTextField = new TextField();
        turnoTextField.setMaxWidth(50);

        Label puntosLabel = new Label("Puntos");
        TextField puntosTextField = new TextField();
        puntosTextField.setMaxWidth(50);

        Label modificadorLabel = new Label("Modificador jugado");
        TextField modificadorTextField = new TextField();
        modificadorTextField.setMaxWidth(50);

        //if(penalidad){
        Label penalidadLabel = new Label("Penalidad:");
        TextField penalidadTextField = new TextField();
        penalidadTextField.setMaxWidth(50);
        //}

        TextArea preguntaTextArea = new TextArea();
        preguntaTextArea.setEditable(false);
        preguntaTextArea.setWrapText(true);
        preguntaTextArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                + "Nullam suscipit est ut purus consequat, ac scelerisque justo varius. "
                + "Vivamus ac ante in ipsum commodo viverra nec in ligula.");

        CheckBox opcion1CheckBox = new CheckBox("Opción 1");
        opcion1CheckBox.getStyleClass().add("checkbox");

        CheckBox opcion2CheckBox = new CheckBox("Opción 2");
        opcion2CheckBox.getStyleClass().add("checkbox");

        Button enviarRespuestaButton = new Button("Enviar Respuesta");
        enviarRespuestaButton.getStyleClass().add("enviar-button");

        Button usarModificadorButton = new Button("Usar Modificador");
        usarModificadorButton.getStyleClass().add("modificador-button");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(turnoLabel, 0, 0);
        gridPane.add(turnoTextField, 1, 0);

        gridPane.add(jugadorLabel, 0, 1);
        gridPane.add(jugadorTextField, 1, 1);

        gridPane.add(puntosLabel, 0, 2);
        gridPane.add(puntosTextField, 1, 2);

        gridPane.add(modificadorLabel, 0, 3);
        gridPane.add(modificadorTextField, 1, 3);

        /* gridPane.add(penalidadLabel, 0, 4);
           gridPane.add(penalidadTextField, 1, 4); */

        gridPane.add(preguntaLabel, 0, 5, 2, 1);
        gridPane.add(preguntaTextArea, 0, 6, 2, 1);

        //if(x tipo de pregunta){
       /* gridPane.add(opcion1CheckBox, 0, 7);
        gridPane.add(opcion2CheckBox, 0, 8);*/ 

        MultipleChoiseVista mv = new MultipleChoiseVista();

        Incorrecta incorrecta = new Incorrecta();
        List<String> textoOpciones=Arrays.asList("texto1","texto2","texto3","texto4");
        List<String> posicionesCorrectas=Arrays.asList("1");
        Opciones opciones = new Simples(textoOpciones,posicionesCorrectas);
        
        Clasica clasica = new Clasica(1);


        MultipleChoice mc = new MultipleChoice(" enunciado",opciones, clasica, "categoria");

        mv.mostrarOpciones(mc, gridPane);

        gridPane.add(enviarRespuestaButton, 0, 9);
        gridPane.add(usarModificadorButton, 1, 9);

        GridPane.setHalignment(enviarRespuestaButton, javafx.geometry.HPos.CENTER);
        GridPane.setHalignment(usarModificadorButton, javafx.geometry.HPos.CENTER);

        //}
        gridPane.getStyleClass().add("form-grid");

        Scene scene = new Scene(gridPane, 500, 550);
        String css = this.getClass().getResource("src/css/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
