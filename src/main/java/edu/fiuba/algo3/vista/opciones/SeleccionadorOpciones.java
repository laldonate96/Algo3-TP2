package edu.fiuba.algo3.vista.opciones;

import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.vista.alertas.Alerta;
import edu.fiuba.algo3.vista.alertas.AlgoSalioMal;
import javafx.scene.layout.Pane;

public class SeleccionadorOpciones {
    public static void seleccionarVistaOpciones(List<Opcion> opciones, String tipoPregunta, Pane pane){
        switch (tipoPregunta) {
            case "Simple":
                SimpleVista simpleVista = new SimpleVista();
                simpleVista.mostrarOpciones(opciones, pane);
                break;
            case "Grupo":
                EleccionGrupalVista eleccionGrupalVista = new EleccionGrupalVista();
                eleccionGrupalVista.mostrarOpciones(opciones, pane);
                break;
            case "Ordenada":
                OrderedChoiceVista orderedChoiceVista = new OrderedChoiceVista();
                orderedChoiceVista.mostrarOpciones(opciones, pane);
                break;
            default:
                Alerta alerta = new AlgoSalioMal();
                alerta.mostrarAlerta();
                 break;
        }
    }
}
