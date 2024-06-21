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
        return false;
    }
}
