package edu.fiuba.algo3.modelo.modificador;

public class Nulo implements Modificador {
    @Override
    public int modificarPuntaje(int puntaje) {
        return puntaje;
    }

    @Override
    public void usar() {
        return;
    }

    @Override
    public boolean tieneUsos() {
        return true;
    }
}
