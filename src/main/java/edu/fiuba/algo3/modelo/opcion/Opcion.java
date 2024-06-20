package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.opcion.estado.Estado;

public abstract class Opcion {
    protected Estado estado;
    protected String texto;
    
    public Opcion(String texto, Estado estado) {
        this.texto = texto;
        this.estado = estado;
    }

    public abstract boolean equals(Opcion opcion);
    protected abstract boolean equals(Ordenada ordenada);
    protected abstract boolean equals(Simple simple);
    protected abstract boolean equals(Grupo grupo);
    public boolean esCorrecta() {
        return estado.esCorrecta();
    }

    public void actualizarEstado(Opcion opcion) {
        if (opcion.equals(this)) {
            this.estado=(opcion.estado);
        }
    }

    public String obtenerTexto() {
        return texto;
    }


}
