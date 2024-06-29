package edu.fiuba.algo3.vista.opciones;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

public class MultipleChoiceVista implements OpcionesVista {
    private List<CheckBox> checkBoxsOpciones;
    private List<Opcion> opciones;
    
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

    @Override
    public void mostrarOpciones(List<Opcion> opcionesRecibidas, GridPane contenedor) {
        opciones = opcionesRecibidas;
        checkBoxsOpciones = new ArrayList<>();
        for(Opcion opcion : opciones){
            CheckBox checkBoxOpcion = new CheckBox(opcion.obtenerTexto());
            checkBoxsOpciones.add(checkBoxOpcion);
            contenedor.getChildren().addAll(checkBoxOpcion);
        }
    }
}
