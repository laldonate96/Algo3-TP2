package edu.fiuba.algo3.modelo.opcion.Cadena;

public class Comun extends Cadena {
    private String contenido;
    private Cadena siguiente;

    public Comun(String descripcion) {
        super(descripcion);
    }
    public Comun(String descripcion, Cadena siguiente) {
        super(descripcion, siguiente);
    }

}