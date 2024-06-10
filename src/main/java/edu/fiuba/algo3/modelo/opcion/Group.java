package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.estado.Estado;
import edu.fiuba.algo3.modelo.grupo.Grupo;

public class Group extends Opcion {
    private Grupo grupo;

    public Group(String texto, Grupo grupo, Estado estado) {
        super(texto, estado);
        this.grupo = grupo;
    }

    public Grupo obtenerGrupo() {
        return grupo;
    }

    @Override
    protected boolean equals(Opcion opcion) {
        return opcion.aceptar(this);
    }

    @Override
    public boolean aceptar(OpcionVisitor visitor) {
        return visitor.visitar(this);
    }

    @Override
    public boolean visitar(Ordered ordered) {
        return false;
    }

    @Override
    public boolean visitar(Simple simple) {
        return false;
    }

    @Override
    public boolean visitar(Group group) {
        return this.texto.equals(group.obtenerTexto()) && this.grupo.equals(group.obtenerGrupo());
    }
}
