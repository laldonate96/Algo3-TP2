package edu.fiuba.algo3.modelo.modificador;

public class Nulo implements Modificador {
    @Override
    public int modificarPuntaje(int puntaje) {
        return puntaje;
    }

    @Override
    public void usar() { }

    @Override
    public boolean equals(Modificador modificador) {
        return (modificador instanceof Nulo);
    }

    @Override
    public boolean equals(Modificador modificador) {
        return (modificador instanceof Nulo);
    }

    @Override
    public boolean tieneUsos() {
        return true;
    }
}
