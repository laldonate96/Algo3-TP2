package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;

public class OrderedChoiseVista implements mostrarOpciones{

    @Override
    public void mostrarOpciones(Pregunta pregunta, GridPane gridPane) {

        ObservableList<String> items = FXCollections.observableArrayList(pregunta.obtenerOpciones());

        ListView<String> listView = new ListView<>(items);
        listView.setEditable(true);
        listView.setCellFactory(TextFieldListCell.forListView());

        listView.setOnDragDetected(event -> {
            if (listView.getSelectionModel().getSelectedItem() != null) {
                ClipboardContent content = new ClipboardContent();
                content.putString(listView.getSelectionModel().getSelectedItem());
                listView.startDragAndDrop(TransferMode.MOVE).setContent(content);
                event.consume();
            }
        });

        listView.setOnDragOver(event -> {
            if (event.getGestureSource() != listView && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        listView.setOnDragEntered(event -> {
            if (event.getGestureSource() != listView && event.getDragboard().hasString()) {
                listView.setStyle("-fx-background-color: #A9A9A9;");
            }
        });

        listView.setOnDragExited(event -> {
            if (event.getGestureSource() != listView && event.getDragboard().hasString()) {
                listView.setStyle("");
            }
        });

        listView.setOnDragDropped(event -> {
            if (listView.getItems().size() > 0) {
                int draggedIndex = listView.getItems().indexOf(event.getDragboard().getString());
                int thisIndex = listView.getSelectionModel().getSelectedIndex();

                if (draggedIndex >= 0 && thisIndex >= 0) {
                    String temp = listView.getItems().get(thisIndex);
                    listView.getItems().set(thisIndex, listView.getItems().get(draggedIndex));
                    listView.getItems().set(draggedIndex, temp);

                    event.setDropCompleted(true);
                } else {
                    event.setDropCompleted(false);
                }
                event.consume();
            }
        });

        listView.setOnDragDone(DragEvent::consume);


        gridPane.add(listView, 0, 7);
    }   
 }
    

