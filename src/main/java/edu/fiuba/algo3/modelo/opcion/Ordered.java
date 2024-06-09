package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.estado.Estado;

public class Ordered extends Opcion {
    private int posicion;
    
    public Ordered(String texto, int posicion, Estado estado) {
        super(texto, estado);
        this.posicion = posicion;
    }

    public int obtenerPosicion() {
        return posicion;
    }

    @Override
    protected boolean equals(Opcion opcion) {
        OpcionVisitor visitor = new OpcionEsVisitor(this);
        return opcion.aceptar(visitor);
    }

    @Override
    public boolean aceptar(OpcionVisitor visitor) {
        return visitor.visitar(this);
    }
}
