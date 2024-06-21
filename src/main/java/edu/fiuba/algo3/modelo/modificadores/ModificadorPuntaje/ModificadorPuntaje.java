package edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje;

import java.util.List;

public abstract class ModificadorPuntaje {
    protected int usos;

    public abstract int modificarPuntaje(int puntaje);


    public void usar(){
        this.usos--;
    }


    public void actualizar(List<ModificadorPuntaje> modificadores) {
        if (this.usos == 0) {
            modificadores.remove(this);
        }
    }

    public abstract boolean equals(ModificadorPuntaje modificadorPuntaje);

    protected abstract boolean equals(AnuladorPuntaje anulador);
    protected abstract boolean equals(ExclusividadPuntaje exclusividad);
    protected abstract boolean equals(Multiplicador multiplicador);
    protected abstract boolean equals(NuloPuntaje nulo);


}
