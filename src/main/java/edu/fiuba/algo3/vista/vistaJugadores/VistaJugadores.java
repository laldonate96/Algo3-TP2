package edu.fiuba.algo3.vista.vistaJugadores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class VistaJugadores {
    private ListView<String> listaDeJugadores;
    private ObservableList<String> jugadores;

    public VistaJugadores(){
        this.listaDeJugadores = new ListView<>();
        this.jugadores = FXCollections.observableArrayList();
    }

    public void agregarJugador(String jugador){
        this.jugadores.add(jugador);
    }

    public ListView<String> mostrarJugadores(){
        this.listaDeJugadores.setItems(jugadores);
        return listaDeJugadores;
    }

}
