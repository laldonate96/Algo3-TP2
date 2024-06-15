package edu.fiuba.algo3.modelo.modificador;

import java.util.List;

public class Multiplicador implements Modificador {
    private final int factorDeMultiplicacion;
    private int usos;

    public Multiplicador(int factorDeMultiplicacion){
        this.factorDeMultiplicacion = factorDeMultiplicacion;
        this.usos = 1;
    }

    @Override
    public int modificarPuntaje(int puntos) {
        return puntos*this.factorDeMultiplicacion;
    }

    @Override
    public void usar() {
        this.usos -= 1;
    }

    @Override
    public void actualizar(List<Modificador> modificadores) {
        if (usos == 0)
            modificadores.remove(this);
    }
}
