package edu.fiuba.algo3.modelo.jugador;

public class Jugador {
    private int puntos;
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int obtenerPuntos() {
        return puntos;
    }
}
