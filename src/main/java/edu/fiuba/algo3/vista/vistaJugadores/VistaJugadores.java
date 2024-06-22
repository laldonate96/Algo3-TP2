package edu.fiuba.algo3.vista.vistaJugadores;

import java.util.List;

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

    public List<String> obtenerJugadores(){
        List<String> nombresDeJugadores = this.listaDeJugadores.getItems();
        return nombresDeJugadores;
    }

}
