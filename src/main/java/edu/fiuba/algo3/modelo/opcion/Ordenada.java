package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.opcion.estado.Estado;

public class Ordenada extends Opcion {
    private final int posicion;

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

    @Override
    protected boolean equals(Ordenada ordenada) {
        return this.texto.equals(ordenada.obtenerTexto()) && this.posicion == ordenada.obtenerPosicion();
    }

    @Override
    public String obtenerTipo() {
        return "Ordenada";
    }

}
