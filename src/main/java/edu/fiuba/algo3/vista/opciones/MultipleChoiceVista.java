package edu.fiuba.algo3.vista.opciones;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.Simple;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

public class MultipleChoiceVista implements OpcionesVista {
    private List<CheckBox> checkBoxsOpciones = new ArrayList<>();
    private List<Simple> opciones;
    
    @Override
    public List<Opcion> retornarOpcionesDelJugador() {
        List<Opcion> opcionesSeleccionadas = new ArrayList<>();
        for(int i = 0; i < opciones.size(); i++){
            if(checkBoxsOpciones.get(i).isSelected()){
                opcionesSeleccionadas.add(opciones.get(i));
            }
        }
        return opcionesSeleccionadas;
    }

    public void mostrarOpciones(List<Simple> opcionesRecibidas, GridPane contenedor) {
        opciones = opcionesRecibidas;
        for(Opcion opcion : opciones){
            CheckBox checkBoxOpcion = new CheckBox(opcion.obtenerTexto());
            contenedor.add(checkBoxOpcion, 0, opciones.indexOf(opcion));
            checkBoxsOpciones.add(checkBoxOpcion);
        }
    }
}
