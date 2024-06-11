package edu.fiuba.algo3.modelo.modificador;

public class Multiplicador implements Modificador {
    private int factorDeMultiplicacion;
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
    public boolean equals(Modificador modificador) {
        return (modificador instanceof Multiplicador);
    }

    @Override
    public boolean tieneUsos() {
        return this.usos > 0;
    }
}
