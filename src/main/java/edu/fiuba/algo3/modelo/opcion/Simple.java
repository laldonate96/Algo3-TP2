package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.estado.Estado;

public class Simple extends Opcion {
    public Simple(String texto, Estado estado) {
        super(texto, estado);
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