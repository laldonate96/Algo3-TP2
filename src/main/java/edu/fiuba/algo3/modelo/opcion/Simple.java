package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.opcion.estado.Estado;



public class Simple extends Opcion {
    public Simple(String texto, Estado estado) {
        super(texto, estado);
    }



    @Override
    public boolean equals(Opcion opcion) {
        return opcion.equals(this);
    }

    protected boolean equals(Ordenada ordenada) {
        return false;
    }

    protected boolean equals(Simple simple) {
        return this.texto.equals(simple.obtenerTexto());
    }

    protected boolean equals(Grupo grupo) {
        return false;
    }

}