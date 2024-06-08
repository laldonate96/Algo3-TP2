package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.estado.Estado;

public class Simple extends Opcion {
    public Simple(String texto) {
        super(texto);
    }

    public Simple(String texto, Estado estado) {
        super(texto, estado);
    }

    @Override
    protected boolean equals(Opcion opcion) {
        return (this.texto).equals(opcion.texto);
    }
}
