package edu.fiuba.algo3.modelo.modificadores.ModificadorPuntaje;



public class Multiplicador extends ModificadorPuntaje {
    private final int factorDeMultiplicacion;


    public Multiplicador(int factorDeMultiplicacion){
        this.factorDeMultiplicacion = factorDeMultiplicacion;
        this.usos=1;
    }

    @Override
    public int modificarPuntaje(int puntos) {
        return puntos*this.factorDeMultiplicacion;
    }

    @Override
    public boolean equals(ModificadorPuntaje modificadorPuntaje) {
        return modificadorPuntaje.equals(this);
    }

    @Override
    protected boolean equals(Multiplicador multiplicador) {
        return (multiplicador.factorDeMultiplicacion==factorDeMultiplicacion);
    }

}
