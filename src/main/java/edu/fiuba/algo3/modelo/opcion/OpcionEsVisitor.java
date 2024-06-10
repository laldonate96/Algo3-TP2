package edu.fiuba.algo3.modelo.opcion;

public class OpcionEsVisitor implements OpcionVisitor {
    private final Opcion opcion;

    public OpcionEsVisitor(Opcion opcion) {
        this.opcion = opcion;
    }

    @Override
    public boolean visitar(Ordered opcionOrdered) {
        return opcion.equalsEspecifico(opcionOrdered);
    }

    @Override
    public boolean visitar(Simple opcionSimple) {
        return opcion.equalsEspecifico(opcionSimple);
    }

    @Override
    public boolean visitar(Group opcionGroup) {
        return opcion.equalsEspecifico(opcionGroup);
    }
}
