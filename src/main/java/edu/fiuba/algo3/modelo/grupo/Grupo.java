package edu.fiuba.algo3.modelo.grupo;

public class Grupo {
    private String nombre;

    public Grupo(String nombre) {
        this.nombre = nombre;
    }

    public boolean equals(Grupo grupo) {
        return this.nombre.equals(grupo.nombre);
    }
}
