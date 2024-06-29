package edu.fiuba.algo3.vista.opciones;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.alertas.Alerta;
import edu.fiuba.algo3.vista.alertas.AlgoSalioMal;
import javafx.scene.layout.GridPane;

public class SeleccionadorOpciones {
    public static void seleccionarVistaOpciones(Pregunta pregunta, GridPane pane){
        String preguntaString = pregunta.getClass().toString();
        String tipoPregunta = preguntaString.substring(preguntaString.lastIndexOf('.') + 1);
        switch (tipoPregunta) {
            case "VerdaderoFalso":
                VerdaderoOFalsoVista verdaderoOFalsoVista = new VerdaderoOFalsoVista();
                verdaderoOFalsoVista.mostrarOpciones(pregunta.obtenerOpciones(), pane);
                break;
            case "MultipleChoice":
                MultipleChoiceVista multipleChoiceVista = new MultipleChoiceVista();
                multipleChoiceVista.mostrarOpciones(pregunta.obtenerOpciones(), pane);
                break;
            case "OrderedChoice":
                OrderedChoiceVista orderedChoiceVista = new OrderedChoiceVista();
                orderedChoiceVista.mostrarOpciones(pregunta.obtenerOpciones(), pane);
                break;
            case "GroupChoice":
                EleccionGrupalVista eleccionGrupalVista = new EleccionGrupalVista();
                eleccionGrupalVista.mostrarOpciones(pregunta.obtenerOpciones(), pane);    
                break;
            default:
                Alerta alerta = new AlgoSalioMal();
                alerta.mostrarAlerta();
                break;
        }
    }
}
