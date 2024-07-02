package edu.fiuba.algo3.vista.opciones;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.opcion.Grupal;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class EleccionGrupalVista implements OpcionesVista {

    private List<Spinner<String>> spinners = new ArrayList<>();
    private List<Grupal> opcionesOriginales;

    private List<String> obtenerGrupos(List<Grupal> opciones) {
        List<String> grupos = new ArrayList<>();
        for (Grupal opcion : opciones) {
            if (!grupos.contains(opcion.obtenerGrupo())){
                grupos.add(opcion.obtenerGrupo());
            }
        }
        return grupos;
    }


    public void mostrarOpciones(List<Grupal> opciones, GridPane contenedor) {
        ObservableList<String> observableListGrupo = FXCollections.observableArrayList(obtenerGrupos(opciones));
        opcionesOriginales = opciones;
        String grupoDefault = opciones.get(0).obtenerGrupo();

        for (Grupal opcion : opciones) {
                Label opcionLabel = new Label(opcion.obtenerTexto());
                opcionLabel.getStyleClass().add("labelOpcion");
                
                Spinner<String> grupoSpinner = new Spinner<>();
                grupoSpinner.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
                grupoSpinner.setPrefWidth(250);

                SpinnerValueFactory<String> listaGrupoSpinner = new SpinnerValueFactory.ListSpinnerValueFactory<>(observableListGrupo);
                grupoSpinner.setValueFactory(listaGrupoSpinner);
                grupoSpinner.getValueFactory().setValue(grupoDefault);

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
            Grupal opcionNueva = new Grupal(opcionOriginal.obtenerTexto(), grupoSeleccionado);

            opcionesDelJugador.add(opcionNueva);
        }
        
        return opcionesDelJugador;
    }
}