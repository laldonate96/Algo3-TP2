package edu.fiuba.algo3.modelo.opcion.Cadena;

public class Nula extends Cadena {

    public Nula(String descripcion) {
        this.descripcion=descripcion;
        this.siguiente=null;
    }


    public boolean equals(Cadena cadena) {
        return true;
    }
}