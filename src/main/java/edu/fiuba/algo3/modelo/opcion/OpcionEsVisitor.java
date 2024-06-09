package edu.fiuba.algo3.modelo.opcion;

public class OpcionEsVisitor implements OpcionVisitor {
    private final Opcion opcion;

    public OpcionEsVisitor(Opcion opcion) {
        this.opcion = opcion;
    }

    @Override
    public boolean visitar(Ordered opcionOrdered) {
        if (!(opcion instanceof Ordered)) {
            return false;
        }
        Ordered ordered = (Ordered) opcion;
        return ordered.texto.equals(opcionOrdered.texto) && ordered.obtenerPosicion() == opcionOrdered.obtenerPosicion();
    }

    @Override
    public boolean visitar(Simple opcionSimple) {
        if (!(opcion instanceof Simple)) {
            return false;
        }
        Simple simple = (Simple) opcion;
        return simple.texto.equals(opcionSimple.texto);
    }

    @Override
    public boolean visitar(Group opcionGroup) {
        if (!(opcion instanceof Group)) {
            return false;
        }
        Group group = (Group) opcion;
        return group.texto.equals(opcionGroup.texto) && group.obtenerGrupo().equals(opcionGroup.obtenerGrupo());
    }
}
