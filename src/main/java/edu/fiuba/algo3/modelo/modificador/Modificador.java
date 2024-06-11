package edu.fiuba.algo3.modelo.modificador;

public interface Modificador {
    public int modificarPuntaje(int puntaje);

    public void usar();

    public boolean equals(Modificador  modificador);

    public boolean tieneUsos();
}
