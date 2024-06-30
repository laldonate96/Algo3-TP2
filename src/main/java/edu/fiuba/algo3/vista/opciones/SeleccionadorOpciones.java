package edu.fiuba.algo3.vista.opciones;

import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.vista.alertas.Alerta;
import edu.fiuba.algo3.vista.alertas.AlgoSalioMal;
import javafx.scene.layout.GridPane;

public class SeleccionadorOpciones {
    private OpcionesVista vista;

    public void seleccionarVistaOpciones(Pregunta pregunta, GridPane pane){
        String preguntaString = pregunta.getClass().toString();
        String tipoPregunta = preguntaString.substring(preguntaString.lastIndexOf('.') + 1);
        switch (tipoPregunta) {
            case "VerdaderoFalso":
                this.vista = new VerdaderoOFalsoVista();
                this.vista.mostrarOpciones(pregunta.obtenerOpciones(), pane);
                break;
            case "MultipleChoice":
                this.vista = new MultipleChoiceVista();
                this.vista.mostrarOpciones(pregunta.obtenerOpciones(), pane);
                break;
            case "OrderedChoice":
                this.vista = new OrderedChoiceVista();
                this.vista.mostrarOpciones(pregunta.obtenerOpciones(), pane);
                break;
            case "GroupChoice":
                this.vista = new EleccionGrupalVista();
                this.vista.mostrarOpciones(pregunta.obtenerOpciones(), pane);    
                break;
            default:
                Alerta alerta = new AlgoSalioMal();
                alerta.mostrarAlerta();
                break;
        }
    }

    public List<Opcion> retornarOpcionesDelJugador(){
        return this.vista.retornarOpcionesDelJugador();
    }
}
