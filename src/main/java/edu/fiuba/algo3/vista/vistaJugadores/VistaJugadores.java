package edu.fiuba.algo3.vista.vistaJugadores;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.vista.botones.Boton;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class VistaJugadores {
    private List<String> listaDeJugadores;
    private VBox contenedor;

    public VistaJugadores(){
        this.listaDeJugadores = new ArrayList<>();
        this.contenedor = new VBox();
    }

    public void agregarJugador(String jugador){
        this.listaDeJugadores.add(jugador);
        actualizarVista();
    }

    public void eliminarJugador(String jugador){
        this.listaDeJugadores.remove(jugador);
        actualizarVista();
    }

    private void actualizarVista() {
        this.contenedor.getChildren().clear();
        for (String jugador : this.listaDeJugadores) {
            Boton botonJugador = new Boton(jugador, "botonJugador");
            botonJugador.setOnAction(event -> eliminarJugador(jugador));
            HBox.setHgrow(botonJugador, Priority.ALWAYS);  
            botonJugador.setMaxWidth(Double.MAX_VALUE);  
            VBox.setMargin(botonJugador, new Insets(10));
            this.contenedor.getChildren().add(botonJugador);
        }
    }

    public VBox mostrarJugadores(){
        actualizarVista();
        return contenedor;
    }

    public List<String> obtenerJugadores(){
        return this.listaDeJugadores;
    }
}
