package edu.fiuba.algo3.vista.selectores;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;

public class SelectorInicioJuego {
    private Spinner<Integer> selector;

    public HBox crearSelectorInicioJuego(String texto, int maximo) {
        Label limiteRondasLabel = new Label(texto);
        limiteRondasLabel.getStyleClass().add("jugadoresLabel");
        Spinner<Integer> selector = new Spinner<>(1, maximo, maximo);
        this.selector = selector;
        selector.setPrefWidth(75);

        HBox limiteRondas = new HBox(10);
        limiteRondas.setAlignment(Pos.CENTER);
        limiteRondas.getChildren().addAll(limiteRondasLabel, selector);

        return limiteRondas;
    }

    public int obtenerLimite() {
        return selector.getValue();
    }
}
