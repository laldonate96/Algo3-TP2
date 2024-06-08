package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.estado.Estado;
import edu.fiuba.algo3.modelo.grupo.Grupo;

public class Group extends Opcion {
    private Grupo grupo;

    public Group(String texto, Grupo grupo) {
        super(texto);
        this.grupo = grupo;
    }

    public Group(String texto, Grupo grupo, Estado estado) {
        super(texto, estado);
        this.grupo = grupo;
    }

    @Override
    protected boolean equals(Opcion opcion) {
        return (this.texto).equals(opcion.texto) && (this.grupo.equals(((Group)opcion).grupo));
    }
}
