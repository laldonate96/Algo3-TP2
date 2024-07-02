package edu.fiuba.algo3.vista.vistaJugadores;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.vista.alertas.Alerta;
import edu.fiuba.algo3.vista.alertas.RepetirNombre;
import edu.fiuba.algo3.vista.botones.Boton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaJugadores {

    private List<String> listaDeJugadores;
    private VBox contenedor;

    public VistaJugadores(){
        this.listaDeJugadores = new ArrayList<>();
        this.contenedor = new VBox();
    }

    public void agregarJugador(String jugador, Stage stage){
        if (this.listaDeJugadores.contains(jugador)){
            Alerta repetirNombre = new RepetirNombre();
            repetirNombre.mostrarAlerta(stage);
        } else {
            this.listaDeJugadores.add(jugador);
            actualizarVista();
        }
    }

    public void eliminarJugador(String jugador){
        this.listaDeJugadores.remove(jugador);
        actualizarVista();
    }

    private void actualizarVista() {
        this.contenedor.getChildren().clear();
    
        this.contenedor.setAlignment(Pos.CENTER);
        
        for (String jugador : this.listaDeJugadores) {
            Boton botonJugador = new Boton(jugador, "botonJugador");
            botonJugador.setOnAction(event -> eliminarJugador(jugador));
            botonJugador.setMaxWidth(200);   
            VBox.setVgrow(botonJugador, Priority.NEVER); 
            
            VBox.setMargin(botonJugador, new Insets(10, 0, 10, 0));  
            
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