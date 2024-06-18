package edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje;

import java.util.List;

public class Multiplicador extends ModificadorPuntaje {
    private final int factorDeMultiplicacion;
    private boolean usado;

    public Multiplicador(int factorDeMultiplicacion){
        this.factorDeMultiplicacion = factorDeMultiplicacion;
        this.usado=false;
    }

    @Override
    public int modificarPuntaje(int puntos) {
        return puntos*this.factorDeMultiplicacion;
    }

    @Override
    public void usar() {
        this.usado=true;
    }

    @Override
    public void actualizar(List<ModificadorPuntaje> modificadores) {
        if (usado) {
            modificadores.remove(this);
        }
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
        return false;
    }

    @Override
    protected boolean equals(Multiplicador multiplicador) {
        return (multiplicador.factorDeMultiplicacion==factorDeMultiplicacion);
    }

    @Override
    protected boolean equals(NuloPuntaje nulo) {
        return false;
    }
}
