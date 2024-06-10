package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.estado.Estado;

public abstract class Opcion implements OpcionVisitor {
    protected Estado estado;
    protected String texto;
    
    public Opcion(String texto, Estado estado) {
        this.texto = texto;
        this.estado = estado;
    }

    protected abstract boolean equals(Opcion opcion);

    public abstract boolean aceptar(OpcionVisitor visitor);

    public boolean esCorrecta() {
        return estado.esCorrecta();
    }

    public void actualizarEstado(Opcion opcion) {
        if (opcion.equals(this)) {
            this.estado = opcion.estado;
        }
    }

    protected String obtenerTexto() {
        return texto;
    }
}
