package edu.fiuba.algo3.vista.opciones;

import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.alertas.Alerta;
import edu.fiuba.algo3.vista.alertas.AlgoSalioMal;
import javafx.scene.layout.GridPane;

public class SeleccionadorOpciones {
    public static void seleccionarVistaOpciones(List<Opcion> opciones, Pregunta pregunta, GridPane pane){
        String preguntaString = pregunta.getClass().toString();
        String tipoPregunta = preguntaString.substring(preguntaString.lastIndexOf('.') + 1);
        switch (tipoPregunta) {
            case "VerdaderoFalso":
                VerdaderoOFalsoVista verdaderoOFalsoVista = new VerdaderoOFalsoVista();
                verdaderoOFalsoVista.mostrarOpciones(opciones, pane);
                break;
            case "MultipleChoice":
                MultipleChoiceVista multipleChoiceVista = new MultipleChoiceVista();
                multipleChoiceVista.mostrarOpciones(opciones, pane);
                break;
            case "OrderedChoice":
                OrderedChoiceVista orderedChoiceVista = new OrderedChoiceVista();
                orderedChoiceVista.mostrarOpciones(opciones, pane);
                break;
            case "GroupChoice":
                EleccionGrupalVista eleccionGrupalVista = new EleccionGrupalVista();
                eleccionGrupalVista.mostrarOpciones(opciones, pane);    
                break;
            default:
                Alerta alerta = new AlgoSalioMal();
                alerta.mostrarAlerta();
                break;
        }
    }
}
