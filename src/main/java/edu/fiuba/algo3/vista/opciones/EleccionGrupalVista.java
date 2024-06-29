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

    private List<Spinner<Grupo>> spinners;

    private List<Grupo> obtenerGrupos(List<Opcion> opciones) {
        List<Grupo> grupos = new ArrayList<>();
        for (Opcion opcion : opciones) {
            if (opcion instanceof Grupo) {
                grupos.add((Grupo) opcion);
            }
        }
        return grupos;
    }

    @Override
    public void mostrarOpciones(List<Opcion> opciones, Pane contenedor) {
        spinners = new ArrayList<>();
        
        ObservableList<Grupo> observableListGrupo = FXCollections.observableArrayList(obtenerGrupos(opciones));

        for (Opcion opcion : opciones) {
            if (opcion instanceof Grupo) {
                Grupo grupo = (Grupo) opcion;

                Label opcionLabel = new Label(opcion.obtenerTexto());
                
                Spinner<Grupo> grupoSpinner = new Spinner<>();

                SpinnerValueFactory<Grupo> listaGrupoSpinner = new SpinnerValueFactory.ListSpinnerValueFactory<>(observableListGrupo);
                grupoSpinner.setValueFactory(listaGrupoSpinner);
                grupoSpinner.getValueFactory().setValue(grupo);

                spinners.add(grupoSpinner);

                contenedor.getChildren().add(opcionLabel);
                contenedor.getChildren().add(grupoSpinner);
            }
        }
    }

    @Override
    public List<Opcion> retornarOpcionesDelJugador() {
        List<Opcion> opcionesSeleccionadas = new ArrayList<>();
        for (Spinner<Grupo> spinner : spinners) {
            opcionesSeleccionadas.add(spinner.getValue());
        }
        return opcionesSeleccionadas;
    }
}
