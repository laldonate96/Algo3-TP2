package edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje;

import java.util.List;

public class ExclusividadPuntaje extends ModificadorPuntaje {
    int usos;
    public ExclusividadPuntaje(){
        usos=2;
    }

    @Override
    public int modificarPuntaje(int puntaje) {
        return puntaje;
    }

    @Override
    public void usar() {
        usos--;
    }

    @Override
    public void actualizar(List<ModificadorPuntaje> modificadores) {
        if (usos==0)
            modificadores.remove(this);
    }

    @Override
    public boolean equals(ModificadorPuntaje modificadorPuntaje) {
        return modificadorPuntaje.equals(this);
    }

    @Override
    protected boolean equals(AnuladorPuntaje anulador) {
        return false;
    }

    @Override
    protected boolean equals(ExclusividadPuntaje exclusividad) {
        return true;
    }

    @Override
    protected boolean equals(Multiplicador multiplicador) {
        return false;
    }

    @Override
    protected boolean equals(NuloPuntaje nulo) {
        return false;
    }
}
