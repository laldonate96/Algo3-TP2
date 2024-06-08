package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.estado.Estado;
import edu.fiuba.algo3.modelo.estado.Incorrecta;

public abstract class Opcion {
    protected Estado estado;
    protected String texto;
    
    public Opcion(String texto) {
        this.texto = texto;
        this.estado = new Incorrecta();
    }

    public Opcion(String texto, Estado estado) {
        this.texto = texto;
        this.estado = estado;
    }

    protected abstract boolean equals(Opcion opcion);

    public boolean esCorrecta() {
        return estado.esCorrecta();
    }

    public void ActualizarEstado(Opcion opcion) {
        if (opcion.equals(this)) {
            this.estado = opcion.estado;
        }
    }
}
