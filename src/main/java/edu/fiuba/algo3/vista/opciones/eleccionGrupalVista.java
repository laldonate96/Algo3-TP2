package edu.fiuba.algo3.vista.opciones;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.Fabricas.FabricaOpciones;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class EleccionGrupalVista implements OpcionesVista {

    private List<Opcion> opcionesJugador;
    private VBox grupo1;
    private VBox grupo2;

    public EleccionGrupalVista() {
        opcionesJugador = new ArrayList<>();
    }

    @Override
    public void mostrarOpciones(List<Opcion> opciones, Pane contenedor) {
        grupo1 = new VBox();
        grupo2 = new VBox();
        HBox grupos = new HBox(grupo1, grupo2);
        grupos.setSpacing(20);

        for (Opcion opcion : opciones) {
            Label opcionLabel = new Label(opcion.obtenerTexto());
            opcionLabel.setOnDragDetected(event -> {
                Dragboard panelArrastrable = opcionLabel.startDragAndDrop(TransferMode.MOVE);
                panelArrastrable.setDragView(opcionLabel.snapshot(null, null));
                event.consume();
            });

            opcionLabel.setOnDragDone(event -> {
                if (event.getTransferMode() == TransferMode.MOVE) {
                    opcionesJugador.add(opcion);
                }
                event.consume();
            });

            opcionLabel.setOnDragEntered(event -> {
                if (event.getGestureSource() != opcionLabel && event.getDragboard().hasString()) {
                    opcionLabel.setStyle("-fx-background-color: yellow;");
                }
                event.consume();
            });

            opcionLabel.setOnDragExited(event -> {
                opcionLabel.setStyle("");
                event.consume();
            });

            opcionLabel.setOnDragOver(event -> {
                if (event.getGestureSource() != opcionLabel && event.getDragboard().hasString()) {
                    event.acceptTransferModes(TransferMode.MOVE);
                }
                event.consume();
            });

            opcionLabel.setOnDragDropped(event -> {
                Dragboard panelArrastrable = event.getDragboard();
                boolean success = false;
                if (panelArrastrable.hasString()) {
                    ((VBox) opcionLabel.getParent()).getChildren().remove(opcionLabel);
                    ((VBox) event.getGestureTarget()).getChildren().add(opcionLabel);
                    success = true;
                }
                event.setDropCompleted(success);
                event.consume();
            });

            contenedor.getChildren().add(opcionLabel);
        }

        contenedor.getChildren().add(grupos);
    }

    @Override
    public List<Opcion> retornarOpcionesDelJugador() {

    }
}