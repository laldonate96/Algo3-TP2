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
        OpcionVisitor visitor = new OpcionEsVisitor(this);
        return opcion.aceptar(visitor);
    }

    @Override
    public boolean aceptar(OpcionVisitor visitor) {
        return visitor.visitar(this);
    }

    @Override
    protected boolean equalsEspecifico(Simple opcion) {
        return false;
    }

    @Override
    protected boolean equalsEspecifico(Ordered opcion) {
        return false;
    }

    @Override
    protected boolean equalsEspecifico(Group opcion) {
        return this.texto.equals(opcion.texto) && this.grupo.equals(opcion.grupo);
    }
}
