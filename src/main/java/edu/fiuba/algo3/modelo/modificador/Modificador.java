package edu.fiuba.algo3.modelo.modificador;

import java.util.List;

public interface Modificador {
    public int modificarPuntaje(int puntaje);

    public void usar();

    public void actualizar(List<Modificador> modificadores);
}
