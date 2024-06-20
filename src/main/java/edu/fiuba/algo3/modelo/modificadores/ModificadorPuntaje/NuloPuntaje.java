package edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje;

import java.util.List;

public class NuloPuntaje extends ModificadorPuntaje {
    @Override
    public int modificarPuntaje(int puntaje) {
        return puntaje;
    }

    @Override
    public void usar() { }

    @Override
    public void actualizar(List<ModificadorPuntaje> modificadores) {

    }

    @Override
    public boolean equals(ModificadorPuntaje modificadorPuntaje) {
        return false;
    }

    @Override
    protected boolean equals(AnuladorPuntaje anulador) {
        return false;
    }

    @Override
    protected boolean equals(ExclusividadPuntaje exclusividad) {
        return false;
    }

    @Override
    protected boolean equals(Multiplicador multiplicador) {
        return false;
    }

    @Override
    protected boolean equals(NuloPuntaje nulo) {
        return true;
    }
}
