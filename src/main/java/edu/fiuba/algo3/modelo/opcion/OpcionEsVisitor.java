package edu.fiuba.algo3.modelo.opcion;

public class OpcionEsVisitor implements OpcionVisitor {
    private final OpcionEsVisitor opcion;

    public OpcionEsVisitor(OpcionEsVisitor opcionVisitor) {
        this.opcion = opcionVisitor;
    }

    @Override
    public boolean visitar(Ordered ordered) {
        return opcion.visitar(ordered);
    }

    @Override
    public boolean visitar(Simple simple) {
        return opcion.visitar(simple);
    }

    @Override
    public boolean visitar(Group group) {
        return opcion.visitar(group);
    }
}
