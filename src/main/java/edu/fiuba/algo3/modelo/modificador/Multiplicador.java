package edu.fiuba.algo3.modelo.modificador;

import java.util.List;

public class Multiplicador implements ModificadorPuntaje {
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
        if (usado)
            modificadores.remove(this);
    }
}
