package edu.fiuba.algo3.modelo.modificador;

import java.util.List;

public class Nulo implements Modificador {
    @Override
    public int modificarPuntaje(int puntaje) {
        return puntaje;
    }

    @Override
    public void usar() { }

    @Override
    public void actualizar(List<Modificador> modificadores) {
        return;
    }
}
