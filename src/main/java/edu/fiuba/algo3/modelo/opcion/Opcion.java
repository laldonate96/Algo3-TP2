package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.estado.Estado;

public abstract class Opcion {
    protected Estado estado;
    protected String texto;
    
    public Opcion(String texto, Estado estado) {
        this.texto = texto;
        this.estado = estado;
    }

    protected abstract boolean equals(Opcion opcion);

    protected abstract boolean equalsEspecifico(Simple opcion);
    protected abstract boolean equalsEspecifico(Ordered opcion);
    protected abstract boolean equalsEspecifico(Group opcion);

    public abstract boolean aceptar(OpcionVisitor visitor);

    public boolean esCorrecta() {
        return estado.esCorrecta();
    }

    public void actualizarEstado(Opcion opcion) {
        if (opcion.equals(this)) {
            this.estado = opcion.estado;
        }
    }
}
