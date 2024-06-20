package edu.fiuba.algo3.modelo.jugador;

import java.util.List;

import edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje.ModificadorPuntaje;

public class Jugador {
    private int puntaje;
    private final String nombre;
    private final List<ModificadorPuntaje> modificadores;

    public Jugador(String nombre, List<ModificadorPuntaje> modificadores) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.modificadores = modificadores;
    }

    public void sumarPuntaje(int puntaje) {
        this.puntaje += puntaje;
    }

    public int obtenerPuntaje() {
        return puntaje;
    }


    public void usar(ModificadorPuntaje modificadorPuntaje){
        modificadorPuntaje.usar();
        modificadorPuntaje.actualizar(modificadores);
    }


    public boolean tieneNombre(String buscado) {
        return nombre.equals(buscado);
    }
    public boolean equals(Jugador jugador){
        return this.tieneNombre(jugador.nombre);
    }

    public boolean tieneModificador(ModificadorPuntaje modificadorPuntaje) {
        return modificadores.contains(modificadorPuntaje);
    }
}


