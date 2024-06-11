package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.estado.Estado;
import edu.fiuba.algo3.modelo.opcion.visitor.OpcionVisitor;

public abstract class Opcion implements OpcionVisitor {
    protected Estado estado;
    protected String texto;
    
    public Opcion(String texto, Estado estado) {
        this.texto = texto;
        this.estado = estado;
    }

    protected boolean equals(Opcion opcion) {
        return opcion.aceptar(this);
    }
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
