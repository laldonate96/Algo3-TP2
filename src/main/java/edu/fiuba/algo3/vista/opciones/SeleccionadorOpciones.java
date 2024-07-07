package edu.fiuba.algo3.vista.opciones;

import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.GroupChoice;
import edu.fiuba.algo3.modelo.pregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.pregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.VerdaderoFalso;
import edu.fiuba.algo3.vista.alertas.Alerta;
import edu.fiuba.algo3.vista.alertas.AlgoSalioMal;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SeleccionadorOpciones {
    private OpcionesVista vista;

    public void seleccionarVistaOpciones(Pregunta pregunta, GridPane pane, Stage stage){

        String preguntaString = pregunta.getClass().toString();
        String tipoPregunta = preguntaString.substring(preguntaString.lastIndexOf('.') + 1);
        switch (tipoPregunta) {
            case "VerdaderoFalso":
                VerdaderoOFalsoVista verdaderoOFalsoVista=new VerdaderoOFalsoVista();
                verdaderoOFalsoVista.mostrarOpciones(((VerdaderoFalso)pregunta).obtenerOpciones(), pane);
                this.vista = verdaderoOFalsoVista;
                break;
            case "MultipleChoice":
                MultipleChoiceVista multipleChoiceVista = new MultipleChoiceVista();
                multipleChoiceVista.mostrarOpciones(((MultipleChoice)pregunta).obtenerOpciones(), pane);
                vista=multipleChoiceVista;
                break;
            case "OrderedChoice":
                OrderedChoiceVista orderedChoiceVista=new OrderedChoiceVista();
                orderedChoiceVista.mostrarOpciones(((OrderedChoice)pregunta).obtenerOpciones(), pane);
                vista=orderedChoiceVista;
                break;
            case "GroupChoice":
                EleccionGrupalVista eleccionGrupalVista=new EleccionGrupalVista();
                eleccionGrupalVista.mostrarOpciones(((GroupChoice)pregunta).obtenerOpciones(), pane);
                vista=eleccionGrupalVista;
                break;
            default:
                Alerta alerta = new AlgoSalioMal();
                alerta.mostrarAlerta(stage);
                break;
        }
    }

    public List<Opcion> retornarOpcionesDelJugador(){
        return this.vista.retornarOpcionesDelJugador();
    }
}
