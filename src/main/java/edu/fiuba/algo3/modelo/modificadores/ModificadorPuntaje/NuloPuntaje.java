package edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje;

import java.util.List;

public class NuloPuntaje extends ModificadorPuntaje {
    @Override
    public int modificarPuntaje(int puntaje) {
        return puntaje;
    }

    @Override
    public void usar() {

    }


    @Override
    public void actualizar(List<ModificadorPuntaje> modificadores) {

    }

    @Override
    public boolean equals(ModificadorPuntaje modificadorPuntaje) {
        return modificadorPuntaje.equals(this);
    }

    @Override
    protected boolean equals(NuloPuntaje nulo) {
        return true;
    }
}
