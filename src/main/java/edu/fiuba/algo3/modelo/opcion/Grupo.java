package edu.fiuba.algo3.modelo.opcion;

import edu.fiuba.algo3.modelo.estado.Estado;

import edu.fiuba.algo3.modelo.opcion.visitor.OpcionVisitor;

public class Grupo extends Opcion {
    private final String nombreGrupo;

    public Grupo(String texto, String nombreGrupo, Estado estado) {
        super(texto, estado);
        this.nombreGrupo = nombreGrupo;
    }

    protected String obtenerGrupo() {
        return nombreGrupo;
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
    public boolean visitar(Grupo grupo) {
        return this.texto.equals(grupo.texto) && this.nombreGrupo.equals(grupo.nombreGrupo);
    }
}
