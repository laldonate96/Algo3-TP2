package edu.fiuba.algo3.vista.opciones;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Pane;

public class EleccionGrupalVista implements OpcionesVista {

    private List<Spinner<String>> spinners;

    private List<String> obtenerGrupos(List<Opcion> opciones) {
        List<String> grupo = new ArrayList<>();
        for (Opcion opcion : opciones) {
            if (opcion instanceof Grupo) {
                Grupo grupoOpcion = (Grupo) opcion;
                grupo.add(grupoOpcion.obtenerGrupo());
            }
        }
        return grupo;
    }

    @Override
    public void mostrarOpciones(List<Opcion> opciones, Pane contenedor) {
        spinners = new ArrayList<>();
        
        ObservableList<String> observableListGrupo = FXCollections.observableArrayList(obtenerGrupos(opciones));

        for (Opcion opcion : opciones) {
            if (opcion instanceof Grupo) {
                Grupo grupo = (Grupo) opcion;

                Label opcionLabel = new Label(opcion.obtenerTexto());
                
                Spinner<String> grupoSpinner = new Spinner<>();

                SpinnerValueFactory<String> listaGrupoSpinner = new SpinnerValueFactory.ListSpinnerValueFactory<>(observableListGrupo);
                grupoSpinner.setValueFactory(listaGrupoSpinner);
                grupoSpinner.getValueFactory().setValue(grupo.obtenerGrupo());

                spinners.add(grupoSpinner);

                contenedor.getChildren().add(opcionLabel);
                contenedor.getChildren().add(grupoSpinner);
            }
        }
    }

    @Override
    public List<Opcion> retornarOpcionesDelJugador() {
        return null;
    }
}