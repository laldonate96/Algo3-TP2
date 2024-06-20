package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class preguntaVista {
    public void mostrarPregunta(Pregunta pregunta){
        
        Label preguntaLabel = new Label("Pregunta");
        preguntaLabel.getStyleClass().add("titulo-label");

        Label penalidadLabel = new Label("Penalidad:");
        TextField penalidadTextField = new TextField();
        penalidadTextField.setMaxWidth(50);

        TextArea preguntaTextArea = new TextArea();
        preguntaTextArea.setEditable(false);
        preguntaTextArea.setWrapText(true);
        preguntaTextArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                + "Nullam suscipit est ut purus consequat, ac scelerisque justo varius. "
                + "Vivamus ac ante in ipsum commodo viverra nec in ligula.");

    }
}
