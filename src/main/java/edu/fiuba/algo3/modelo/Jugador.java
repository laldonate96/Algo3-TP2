package edu.fiuba.algo3.modelo;

public class Jugador {
    private int puntaje;
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
    }

    public void sumarPuntaje(int puntaje) {
        this.puntaje += puntaje;
    }

    public int obtenerPuntaje() {
        return puntaje;
    }
}
