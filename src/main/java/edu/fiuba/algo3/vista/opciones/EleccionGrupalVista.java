package edu.fiuba.algo3.vista.opciones;

import java.lang.classfile.Label;
import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.scene.layout.Pane;

public class EleccionGrupalVista implements OpcionesVista {

   
    @Override
    public void mostrarOpciones(List<Opcion> opciones, Pane contenedor) {
        for(Opcion opcion : opciones){
            Label opcion = new Label(opcion.);
        }
    }

    @Override
    public List<Opcion> retornarOpcionesDelJugador() {
        return 
    }
}