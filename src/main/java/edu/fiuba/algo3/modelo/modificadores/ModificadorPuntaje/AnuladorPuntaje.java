package edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje;



public class AnuladorPuntaje extends ModificadorPuntaje {



    public AnuladorPuntaje() {
        usos=1;
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
    protected boolean equals(AnuladorPuntaje anulador) {
        return true;
    }
}
