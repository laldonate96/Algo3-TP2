package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.opcion.estado.Estado;

public class Ordenada extends Opcion {
    private int posicion;
    
    public Ordenada(String texto, int posicion, Estado estado) {
        super(texto, estado);
        this.posicion = posicion;
    }

    public int obtenerPosicion() {
        return posicion;
    }



    @Override
    public boolean equals(Opcion opcion) {
        return opcion.equals(this);
    }

    protected boolean equals(Ordenada ordenada) {
        return this.texto.equals(ordenada.obtenerTexto()) && this.posicion == ordenada.obtenerPosicion();
    }


    protected boolean equals(Simple simple) {
        return false;
    }


    protected boolean equals(Grupo grupo) {
        return false;
    }
}
