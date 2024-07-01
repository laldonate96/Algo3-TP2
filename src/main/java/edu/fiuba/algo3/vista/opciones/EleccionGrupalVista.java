package edu.fiuba.algo3.vista.opciones;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Grupo;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.estado.Correcta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class EleccionGrupalVista implements OpcionesVista {

    private List<Spinner<String>> spinners = new ArrayList<>();
    private List<Grupo> opcionesOriginales;

    private List<String> obtenerGrupos(List<Grupo> opciones) {
        List<String> grupos = new ArrayList<>();
        for (Grupo opcion : opciones) {
            if (!grupos.contains(opcion.obtenerGrupo())){
                grupos.add(opcion.obtenerGrupo());
            }
        }
        return grupos;
    }


    public void mostrarOpciones(List<Grupo> opciones, GridPane contenedor) {
        ObservableList<String> observableListGrupo = FXCollections.observableArrayList(obtenerGrupos(opciones));
        opcionesOriginales = opciones;

        for (Grupo opcion : opciones) {
                Label opcionLabel = new Label(opcion.obtenerTexto());
                opcionLabel.getStyleClass().add("labelOpcion");
                
                Spinner<String> grupoSpinner = new Spinner<>();

                SpinnerValueFactory<String> listaGrupoSpinner = new SpinnerValueFactory.ListSpinnerValueFactory<>(observableListGrupo);
                grupoSpinner.setValueFactory(listaGrupoSpinner);
                grupoSpinner.getValueFactory().setValue(opcion.obtenerGrupo());

                HBox hbox = new HBox(10);
                hbox.getChildren().addAll(grupoSpinner, opcionLabel);

                contenedor.add(hbox, 0, opciones.indexOf(opcion));
                spinners.add(grupoSpinner);

        }
    }

    @Override
    public List<Opcion> retornarOpcionesDelJugador() {
          List<Opcion> opcionesDelJugador = new ArrayList<>();

        for (int i = 0; i < spinners.size(); i++) {
            Spinner<String> spinner = spinners.get(i);
            String grupoSeleccionado = spinner.getValue();

            Opcion opcionOriginal = opcionesOriginales.get(i);
            Grupo opcionNueva = new Grupo(opcionOriginal.obtenerTexto(), grupoSeleccionado, new Correcta());

            opcionesDelJugador.add(opcionNueva);
        }

        return opcionesDelJugador;
    }
}