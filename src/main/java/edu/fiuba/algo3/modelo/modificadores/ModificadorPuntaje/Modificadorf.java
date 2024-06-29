package edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje;

import edu.fiuba.algo3.modelo.modificadores.ModificadorTurno.Multiplicador;

import java.util.List;

public abstract class Modificadorf {
    protected int usos;

    public abstract int modificarPuntaje(int puntaje);


    public void usar(){
        this.usos--;
    }


    public void actualizar(List<Modificador> modificadores) {
        if (this.usos == 0) {
            modificadores.remove(this);
        }
    }

    public abstract boolean equals(Modificador modificador);

    protected boolean equals(Anulador anulador){
        return false;
    }
    protected boolean equals(Exclusividad exclusividad){
        return false;
    }
    protected boolean equals(Multiplicador multiplicador){
        return false;
    }
    protected boolean equals(Nulo nulo){
        return false;
    }


}
