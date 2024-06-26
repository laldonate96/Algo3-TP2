package edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje;



public class ExclusividadPuntaje extends ModificadorPuntaje {


    public ExclusividadPuntaje() {
        this.usos = 2;
    }

    @Override
    public int modificarPuntaje(int puntaje) {
        return puntaje;
    }

    @Override
    public boolean equals(ModificadorPuntaje modificadorPuntaje) {
        return modificadorPuntaje.equals(this);
    }

    @Override
    protected boolean equals(ExclusividadPuntaje exclusividad) {
        return true;
    }
}
